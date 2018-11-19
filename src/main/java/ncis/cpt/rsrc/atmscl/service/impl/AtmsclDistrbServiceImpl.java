package ncis.cpt.rsrc.atmscl.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxDistrbConfDao;
import ncis.cmn.dao.CRxDistrbHstryDao;
import ncis.cmn.dao.CRxServcPodDao;
import ncis.cmn.entity.RxDistrbConf;
import ncis.cmn.entity.RxDistrbEnvConf;
import ncis.cmn.entity.RxDistrbHstry;
import ncis.cmn.entity.RxMnulScl;
import ncis.cmn.entity.RxPvc;
import ncis.cmn.entity.RxRsrvSclng;
import ncis.cmn.entity.RxServcPod;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.rsrc.atmscl.dao.AtmsclDistrbDao;
import ncis.cpt.rsrc.atmscl.dao.ServcDao;
import ncis.cpt.rsrc.atmscl.service.AtmsclDistrbService;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.cpt.rsrc.atmscl.vo.PvcVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.intfc.atmscl.service.AtmsclDistrbAPIService;
import ncis.intfc.atmscl.service.ServcAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.DeploymentConfigsIfVo;
import ncis.intfc.atmscl.vo.PodIfVo;

import org.apache.commons.beanutils.BeanUtils;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service("atmsclDistrbService")
public class AtmsclDistrbServiceImpl implements AtmsclDistrbService {

	private final Logger logger = LoggerFactory.getLogger(AtmsclDistrbServiceImpl.class);

	@Resource(name="atmsclDistrbDao")
	private AtmsclDistrbDao atmsclDistrbDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="cRxDistrbConfDao")
	private CRxDistrbConfDao cRxDistrbConfDao;

	@Resource(name="servcDao")
	private ServcDao servcDao;

	@Resource(name="cRxServcPodDao")
	private CRxServcPodDao cRxServcPodDao;

	@Resource(name="atmsclDistrbAPIService")
	private AtmsclDistrbAPIService atmsclDistrbAPIService;

	@Resource(name="servcAPIService")
	ServcAPIService servcAPIService;

	@Resource(name="cRxDistrbHstryDao")
	private CRxDistrbHstryDao cRxDistrbHstryDao;

	@Override
	public List<AtmsclDistrbVo> selectAtmsclDistrbList(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {

		List<AtmsclDistrbVo> list = null;
		int totalCount = atmsclDistrbDao.selectAtmsclDistrbTotCnt(atmsclDistrbSearchVo);

		if(totalCount > 0){
			atmsclDistrbSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = atmsclDistrbDao.selectAtmsclDistrbList(atmsclDistrbSearchVo);
		}

		return list;
	}


	@Override
	public List<AtmsclDistrbVo> selectDetailAtmsclDistrb(AtmsclDistrbVo atmsclDistrbVo) throws Exception{

		List<AtmsclDistrbVo> list = atmsclDistrbDao.selectDetailAtmsclDistrb(atmsclDistrbVo);

		AtmsclDistrbVo atmsclDistVo = new AtmsclDistrbVo();
		BeanUtils.copyProperties(atmsclDistVo,list.get(0));

		//header 셋팅
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistVo.getRegionId());
		headers.setZoneId(atmsclDistVo.getZoneId());
		headers.setNetworkId(atmsclDistVo.getNetClCd());
		headers.setManagerId(atmsclDistVo.getRsrcPoolId());

		AtmSclResultIfVo syncResult = null;
		try {
			//최신 버전 조회
			syncResult = atmsclDistrbAPIService.updateDistrbSync(headers, atmsclDistVo);
		} catch(HttpClientErrorException e) {
			logger.error("배포 최신버전 조회 중 오류", e);
		} catch(HttpServerErrorException e) {
			logger.error("배포 최신버전 조회 중 오류", e);
		}
		try {
			if(syncResult!= null && "Y".equals(syncResult.getSuccYn())){
				String distrbId = new String();

				Integer newLastVer = syncResult.getLatestVersion();
				Integer oldLastVer = 0;
				if(newLastVer != 1){
					if(ObjectUtils.isEmpty(atmsclDistVo.getLastDistrbVer())){
						atmsclDistVo.setLastDistrbVer("0");
					}
					oldLastVer = Integer.valueOf(atmsclDistVo.getLastDistrbVer());
				}

				RxDistrbConf rxDistrbConf = new RxDistrbConf();
				rxDistrbConf.setUpdtUserId(atmsclDistrbVo.getUpdtUserId());
				rxDistrbConf.setServcSeq(atmsclDistVo.getServcSeq());
				rxDistrbConf.setDistrbConfId(atmsclDistVo.getDistrbConfId());

				//이력
				RxDistrbHstry rxDistrbHstry = new RxDistrbHstry();
				rxDistrbHstry.setServcSeq(atmsclDistVo.getServcSeq());
				rxDistrbHstry.setDistrbConfId(atmsclDistVo.getDistrbConfId());

				for (int i = (oldLastVer+1); i < newLastVer+1; i++) {

					distrbId = atmsclDistVo.getDistrbConfId()+"-"+i;
					rxDistrbHstry.setDistrbId(distrbId); // 배포 ID
					rxDistrbHstry.setDistrbVer(String.valueOf(i));
					atmsclDistVo.setLastDistrbVer(String.valueOf(i));

					//replicationController API
					AtmSclResultIfVo distrbHstrySync = atmsclDistrbAPIService.distrbHstrySync(headers,atmsclDistVo);

					rxDistrbHstry.setDistrbDttmSync(distrbHstrySync.getLastDistrbDttm());
					rxDistrbHstry.setRplcaQty(distrbHstrySync.getReplicas());
					rxDistrbHstry.setDistrbStatCd(distrbHstrySync.getDeploymentPhase());
					if(i == newLastVer){
						rxDistrbConf.setRplcaQty(distrbHstrySync.getReplicas());
						rxDistrbConf.setStatCd(distrbHstrySync.getDeploymentPhase());
						rxDistrbConf.setDistrbDttmSync(distrbHstrySync.getLastDistrbDttm());
						rxDistrbConf.setLastDistrbVer(String.valueOf(newLastVer));
						cRxDistrbConfDao.updateRxDistrbSync(rxDistrbConf);
					}
					cRxDistrbHstryDao.insertRxDistrbHstrySync(rxDistrbHstry);
				}
				list = atmsclDistrbDao.selectDetailAtmsclDistrb(atmsclDistrbVo);
			}
		} catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			logger.error(e.toString(),e);
			throw new CommonException("배포 동기화 중 오류가 발생했습니다."+e.getMessage());
		}


		return list;
	}

	@Override
	public List<AtmsclDistrbVo> selectDistrbPodInfo(AtmsclDistrbVo atmsclDistrbVo) throws Exception {

		try{
		//해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		//API를 호출하여 Pod 정보 조회
		DeploymentConfigsIfVo podDeploymentconfigsIfVo = new DeploymentConfigsIfVo();
		podDeploymentconfigsIfVo.setName(atmsclDistrbVo.getServcId());
		podDeploymentconfigsIfVo.setNamespaceId(atmsclDistrbVo.getServcAreaId());
		List<PodIfVo> podIfVoList = servcAPIService.podsGet(headers, podDeploymentconfigsIfVo);

		//DB에 있는 Pod 정보 조회
		ServcPodVo pvo = new ServcPodVo();
		pvo.setServcSeq(atmsclDistrbVo.getServcSeq());
		List<ServcPodVo> servcPodList = servcDao.selectServcPodList(pvo);

		String podId = "";
		String podUid = "";
		String podStatCd = "";
		boolean checkFlag = false;
		RxServcPod rxServcPod =  null;

		// API호출 Pod정보
		for (PodIfVo podDetail : podIfVoList) {
			podId = podDetail.getName();
			podUid  = podDetail.getUid();

			rxServcPod = new RxServcPod();
			rxServcPod.setServcSeq(atmsclDistrbVo.getServcSeq());
			rxServcPod.setPodId(podId);
			rxServcPod.setPodNm(podId);
			rxServcPod.setPodIpAddr(podDetail.getHostIP());
			rxServcPod.setPodUid(podDetail.getUid());
			rxServcPod.setImgId(podDetail.getImage());
			rxServcPod.setRsrcPoolId(atmsclDistrbVo.getRsrcPoolId());
			rxServcPod.setImgRepoDtlAddr(podDetail.getImageID());
			rxServcPod.setCreDttm(podDetail.getCreationTimestamp());
			rxServcPod.setStrtDttm(podDetail.getStartTime());
			rxServcPod.setStatCd(podDetail.getPhase());
			rxServcPod.setAtmsclNodeId(podDetail.getNodeName());
			rxServcPod.setPodTyCd(podDetail.getPodType());
			rxServcPod.setDelYn("N");

			//DB에 해당 서비스의  Pod가 있을경우
			if(servcPodList.size() >0 ) {
				checkFlag = false;
				podStatCd = "";

				//DB에 있는 Pod정보
				for (ServcPodVo servcPodVo : servcPodList) {

					//Pod ID와 UID가 서로 일치하는지 체크
					if(podId.equals(servcPodVo.getPodId()) && podUid.equals(servcPodVo.getPodUid())  ) {
						if("01".equals(servcPodVo.getPodTyCd())) {
							podStatCd = servcPodVo.getStatCd();
						}
						checkFlag = true;
						break;
					}
				}

				if(checkFlag) { //일치할 경우는 update
					if(podDetail.getPhase() !=null && ("01".equals(podDetail.getPodType()))) {
						if(!podStatCd.equals(podDetail.getPhase())) {
							cRxServcPodDao.updateRxServcPod(rxServcPod); // update
						}
					}
				}else {  //DB에 일치하는 건이 없을경우 insert
					cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
				}
			}else { //DB에 해당 서비스의  Pod가 없을경우 insert
				cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
			}
		}


		//DB에는 있으나 API호출정보에 없으면 삭제처리
		for (ServcPodVo servcPodVo : servcPodList) { //DB에 있는 데이터
			checkFlag = false;
			for (PodIfVo podDetail : podIfVoList) { //API호출 데이터

				//Pod ID와 UID가 서로 일치하는지 체크
				if(podDetail.getName().equals(servcPodVo.getPodId()) && podDetail.getUid().equals(servcPodVo.getPodUid())  ) {
					checkFlag = true;  // 일치여부
				}
			}

			if(!checkFlag) {  //일치하지 않을 경우
				rxServcPod = new RxServcPod();
				rxServcPod.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxServcPod.setPodId(servcPodVo.getPodId());
				cRxServcPodDao.deleteRxServcPod((rxServcPod)); //해당 Pod삭제
			}
		}
		}catch(HttpServerErrorException e){
			logger.error(e.getResponseBodyAsString(), e);
		}catch(HttpStatusCodeException e){
			logger.error(e.getResponseBodyAsString(), e);
		}

		List<AtmsclDistrbVo> podInfo = atmsclDistrbDao.selectDistrbPodInfo(atmsclDistrbVo);

		return podInfo;
	}

	@Override
	public List<AtmsclDistrbVo> selectRsrvSclInfo(AtmsclDistrbVo atmsclDistrbVo) {

		List<AtmsclDistrbVo> autoSclInfo = atmsclDistrbDao.selectRsrvSclInfo(atmsclDistrbVo);

		return autoSclInfo;
	}

	@Override
	public List<AtmsclDistrbVo> selectAtmsclStrgP(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		List<AtmsclDistrbVo> selectAtmsclStrgP = atmsclDistrbDao.selectAtmsclStrgP(atmsclDistrbSearchVo);
		return selectAtmsclStrgP;
	}

	@Override
	public AtmSclResultIfVo insertPvcStrgAdd(AtmsclDistrbVo atmsclDistrbVo) throws Exception {

		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		RxPvc rxPvc = new RxPvc();

		String pvcId = atmsclDistrbVo.getServcAreaId()+"-";
		String seqAreaNum = commonService.selectSeqNum("RX_PVC",pvcId);
		rxPvc.setServcAreaSeq(atmsclDistrbVo.getServcAreaSeq());
		rxPvc.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxPvc.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxPvc.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
		rxPvc.setPvcId(seqAreaNum);
		rxPvc.setPvId(atmsclDistrbVo.getPvId());
		rxPvc.setVolumeNm(atmsclDistrbVo.getVolumeNm());
		rxPvc.setMountPath(atmsclDistrbVo.getMountPath());
		rxPvc.setAccssModeClCd(atmsclDistrbVo.getAccssModeClCd());
		rxPvc.setReqStrgCapa(atmsclDistrbVo.getReqStrgCapa());

		AtmSclResultIfVo pvcCre = atmsclDistrbAPIService.pvcCre(headers,rxPvc);
		AtmSclResultIfVo deployConf = new AtmSclResultIfVo();
		if("Y".equals(pvcCre.getSuccYn())){
				deployConf = atmsclDistrbAPIService.deployConf(headers,rxPvc);
				if("Y".equals(deployConf.getSuccYn())){
					rxPvc.setPvcNm(rxPvc.getPvcId());
					rxPvc.setRsrcPoolId(atmsclDistrbVo.getRsrcPoolId());
					rxPvc.setPvcUid(pvcCre.getUid());
					cRxDistrbConfDao.insertDistrbAsgn(rxPvc); // 배포설정 pvc 할당
					cRxDistrbConfDao.insertPvcStrgAdd(rxPvc); // pvc 추가
				}
		}

//		if (deployConf == null) {
//			deployConf.setSuccYn("N");
//		}
		return deployConf;

	}

	@Override
	public Integer selectAutoSclingCheck(AtmsclDistrbVo atmsclDistrbVo) {

		return atmsclDistrbDao.selectAutoSclingCheck(atmsclDistrbVo);
	}


	@Override
	public AtmSclResultIfVo insertReplicasAdd(AtmsclDistrbVo atmsclDistrbVo) {

		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());


		RxMnulScl rxMnulScl = new RxMnulScl();

		rxMnulScl.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxMnulScl.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
		rxMnulScl.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxMnulScl.setChngPodQty(atmsclDistrbVo.getChngPodQty());
		rxMnulScl.setRegUserId(atmsclDistrbVo.getRegUserId());
		rxMnulScl.setNowPodQty(atmsclDistrbVo.getNowPodQty());
		rxMnulScl.setAvgCpuUseRt(atmsclDistrbVo.getAvgCpuUseRt());
		rxMnulScl.setAvgMemUseRt(atmsclDistrbVo.getAvgMemUseRt());
		rxMnulScl.setSclReasn(atmsclDistrbVo.getSclReasn());


		AtmSclResultIfVo putReplicasAdd = atmsclDistrbAPIService.putReplicasAdd(headers,rxMnulScl);
		if("Y".equals(putReplicasAdd.getSuccYn())){
			try {
				cRxDistrbConfDao.insertReplicasAdd(rxMnulScl);
			}catch(HttpServerErrorException e){
				throw new CommonException("자원확장 시 오류가 발생했습니다."+e.getMessage());
			}catch(HttpStatusCodeException e){
				throw new CommonException("자원확장 시 오류가 발생했습니다."+e.getMessage());
			}

		}
		return putReplicasAdd;
	}


	@Override
	public AtmSclResultIfVo updateRsrcLt(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		AtmSclResultIfVo updateCheck = new AtmSclResultIfVo();
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		RxDistrbConf disConf = new RxDistrbConf();
		disConf.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		disConf.setServcSeq(atmsclDistrbVo.getServcSeq());
		disConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());

		disConf.setReqCpuCorQty(atmsclDistrbVo.getReqCpuCorQty());
		disConf.setLmttCpuCorQty(atmsclDistrbVo.getLmttCpuCorQty());
		disConf.setReqMemCapa(atmsclDistrbVo.getReqMemCapa());
		disConf.setLmttMemCapa(atmsclDistrbVo.getLmttMemCapa());
		disConf.setDistrbId(atmsclDistrbVo.getDistrbId());
		AtmSclResultIfVo updateRsrcLtApi = atmsclDistrbAPIService.updateRsrcLtApi(headers,disConf);

		if ("Y".equals(updateRsrcLtApi.getSuccYn())) {
			try {
				cRxDistrbConfDao.updateRsrcLt(disConf);
				updateCheck.setSuccYn("Y");

			}catch(HttpServerErrorException e){
				throw new CommonException("자원제한 시 오류가 발생했습니다."+e.getMessage());
			}catch(HttpStatusCodeException e){
				throw new CommonException("자원제한 시 오류가 발생했습니다."+e.getMessage());
			}

		}else{
			updateCheck.setSuccYn("N");
		}

		return updateCheck;
	}


	@Override
	public List<DistrbEnvConfVo> selectDistrbEnvConfInfo(AtmsclDistrbVo atmsclDistrbVo) {
		List<DistrbEnvConfVo> selectDistrbEnvConfInfo = atmsclDistrbDao.selectDistrbEnvConfInfo(atmsclDistrbVo);
		return selectDistrbEnvConfInfo;
	}


	@Override
	public AtmSclResultIfVo updateDistrbConf(AtmsclDistrbVo atmsclDistrbVo)throws Exception {
		AtmSclResultIfVo updateCheck = new AtmSclResultIfVo();
		String varVlTyCd = "01";
		atmsclDistrbVo.setCheckCd("01");

		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());
		//받은값
		if(null != atmsclDistrbVo.getDistrbEnvConfList()) {
			List<DistrbEnvConfVo> selectDistrbEnvConfExcept = atmsclDistrbDao.selectDistrbEnvConfExcept(atmsclDistrbVo);
			atmsclDistrbVo.setDefaultYn("Y");

			List<DistrbEnvConfVo> distrbEnvConfList = atmsclDistrbVo.getDistrbEnvConfList();
			AtmSclResultIfVo updateDistrbConfApi = atmsclDistrbAPIService.updateDistrbConfApi(headers,atmsclDistrbVo,selectDistrbEnvConfExcept);
			if ("Y".equals(updateDistrbConfApi.getSuccYn())) {
				RxDistrbConf rxDistrbConf = new RxDistrbConf();
				RxDistrbEnvConf rxEnvConf = new RxDistrbEnvConf();
				rxEnvConf.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxEnvConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
				rxEnvConf.setVarVlTyCd(varVlTyCd);

				String lastVer = String.valueOf(updateDistrbConfApi.getLatestVersion()) ;
				String distrbId = atmsclDistrbVo.getDistrbConfId()+"-"+lastVer;
				rxDistrbConf.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxDistrbConf.setDistrbId(distrbId);
				rxDistrbConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
				rxDistrbConf.setLastDistrbVer(lastVer);
				rxDistrbConf.setStatCd("01");
				rxDistrbConf.setUpdtUserId(atmsclDistrbVo.getUpdtUserId());
				rxDistrbConf.setTmplatNm(atmsclDistrbVo.getTmplatNm());
				rxDistrbConf.setReStrtPolicyClCd(atmsclDistrbVo.getReStrtPolicyClCd());
				rxDistrbConf.setDnsPolicyClCd(atmsclDistrbVo.getDnsPolicyClCd());
				rxDistrbConf.setReqCpuCorQty(atmsclDistrbVo.getReqCpuCorQty());
				rxDistrbConf.setReqMemCapa(atmsclDistrbVo.getReqMemCapa());
				rxDistrbConf.setLmttCpuCorQty(atmsclDistrbVo.getLmttCpuCorQty());
				rxDistrbConf.setLmttMemCapa(atmsclDistrbVo.getLmttMemCapa());
				rxDistrbConf.setRplcaQty(atmsclDistrbVo.getRplcaQty());
				rxDistrbConf.setRmk(atmsclDistrbVo.getRmk());

				cRxDistrbConfDao.updateRxDistrbConfVer(rxDistrbConf); // 배포설정 update
				cRxDistrbConfDao.insertRxDistrbHstry(rxDistrbConf);
				cRxDistrbConfDao.deleteDistrbConf(rxEnvConf); //기존 환경변수 삭제
					for (DistrbEnvConfVo distrbEnvConfVo : distrbEnvConfList) {
						rxEnvConf.setEnvVarNm(distrbEnvConfVo.getEnvVarNm());
						rxEnvConf.setEnvVarVl(distrbEnvConfVo.getEnvVarVl());
						cRxDistrbConfDao.insertDistrbConf(rxEnvConf); // 환경변수 Insert
					}


				updateCheck.setSuccYn("Y");
				//Pod정보 반영
				DeploymentConfigsIfVo deploymentconfigsIfVo = new DeploymentConfigsIfVo();
				deploymentconfigsIfVo.setName(atmsclDistrbVo.getDistrbConfId());
				deploymentconfigsIfVo.setNamespaceId(atmsclDistrbVo.getServcAreaId());

				List<PodIfVo> podIfVoList = servcAPIService.podsGet(headers, deploymentconfigsIfVo);

				ServcPodVo pvo = new ServcPodVo();
				pvo.setServcSeq(atmsclDistrbVo.getServcSeq());
				List<ServcPodVo> servcPodList = servcDao.selectServcPodList(pvo);


				String podId = "";
				String podUid = "";
				String podStatCd = "";
				boolean checkFlag = false;
				RxServcPod rxServcPod =  null;

				// API호출 Pod정보
				for (PodIfVo podDetail : podIfVoList) {
					podId = podDetail.getName();
					podUid  = podDetail.getUid();

					rxServcPod = new RxServcPod();
					rxServcPod.setServcSeq(rxDistrbConf.getServcSeq());
					rxServcPod.setPodId(podId);
					rxServcPod.setPodNm(podId);
					rxServcPod.setPodIpAddr(podDetail.getHostIP());
					rxServcPod.setPodUid(podDetail.getUid());
					rxServcPod.setImgId(podDetail.getImage());
					rxServcPod.setRsrcPoolId(atmsclDistrbVo.getRsrcPoolId());
					rxServcPod.setImgRepoDtlAddr(podDetail.getImageID());
					rxServcPod.setCreDttm(podDetail.getCreationTimestamp());
					rxServcPod.setStrtDttm(podDetail.getStartTime());
					rxServcPod.setStatCd(podDetail.getPhase());
					rxServcPod.setAtmsclNodeId(podDetail.getNodeName());
					rxServcPod.setPodTyCd(podDetail.getPodType());
					rxServcPod.setDelYn("N");

					//DB에 해당 서비스의  Pod가 있을경우
					if(servcPodList.size() >0 ) {
						checkFlag = false;
						podStatCd = "";

						//DB에 있는 Pod정보
						for (ServcPodVo servcPodVo : servcPodList) {

							//Pod ID와 UID가 서로 일치하는지 체크
							if(podId.equals(servcPodVo.getPodId()) && podUid.equals(servcPodVo.getPodUid())  ) {
								if("01".equals(servcPodVo.getPodTyCd())) {
									podStatCd = servcPodVo.getStatCd();
								}
								checkFlag = true;
								break;
							}
						}

						if(checkFlag) { //일치할 경우는 update
							if(podDetail.getPhase() !=null && ("01".equals(podDetail.getPodType()))) {
								if(!podStatCd.equals(podDetail.getPhase())) {
									cRxServcPodDao.updateRxServcPod(rxServcPod); // update
								}
							}
						}else {  //DB에 일치하는 건이 없을경우 insert
							cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
						}
					}else { //DB에 해당 서비스의  Pod가 없을경우 insert
						cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
					}
					}
				//DB에는 있으나 API호출정보에 없으면 삭제처리
				for (ServcPodVo servcPodVo : servcPodList) { //DB에 있는 데이터
					checkFlag = false;
					for (PodIfVo podDetail : podIfVoList) { //API호출 데이터

						//Pod ID와 UID가 서로 일치하는지 체크
						if(podDetail.getName().equals(servcPodVo.getPodId()) && podDetail.getUid().equals(servcPodVo.getPodUid())  ) {
							checkFlag = true;  // 일치여부
						}
					}

					if(!checkFlag) {  //일치하지 않을 경우
						rxServcPod = new RxServcPod();
						rxServcPod.setServcSeq(rxDistrbConf.getServcSeq());
						rxServcPod.setPodId(servcPodVo.getPodId());
						cRxServcPodDao.deleteRxServcPod((rxServcPod)); //해당 Pod삭제
					}
				}
			}

		}else{
			AtmSclResultIfVo updateDistrbConfApi = atmsclDistrbAPIService.updateDistrbConfApi(headers,atmsclDistrbVo,null);
			if ("Y".equals(updateDistrbConfApi.getSuccYn())) {

				RxDistrbConf rxDistrbConf = new RxDistrbConf();

				String lastVer = String.valueOf(updateDistrbConfApi.getLatestVersion()) ;
				String distrbId = atmsclDistrbVo.getDistrbConfId()+"-"+lastVer;
				rxDistrbConf.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxDistrbConf.setDistrbId(distrbId);
				rxDistrbConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
				rxDistrbConf.setLastDistrbVer(lastVer);
				rxDistrbConf.setStatCd("01");
				rxDistrbConf.setUpdtUserId(atmsclDistrbVo.getUpdtUserId());
				rxDistrbConf.setTmplatNm(atmsclDistrbVo.getTmplatNm());
				rxDistrbConf.setReStrtPolicyClCd(atmsclDistrbVo.getReStrtPolicyClCd());
				rxDistrbConf.setDnsPolicyClCd(atmsclDistrbVo.getDnsPolicyClCd());
				rxDistrbConf.setReqCpuCorQty(atmsclDistrbVo.getReqCpuCorQty());
				rxDistrbConf.setReqMemCapa(atmsclDistrbVo.getReqMemCapa());
				rxDistrbConf.setLmttCpuCorQty(atmsclDistrbVo.getLmttCpuCorQty());
				rxDistrbConf.setLmttMemCapa(atmsclDistrbVo.getLmttMemCapa());
				rxDistrbConf.setRplcaQty(atmsclDistrbVo.getRplcaQty());
				rxDistrbConf.setRmk(atmsclDistrbVo.getRmk());

				cRxDistrbConfDao.updateRxDistrbConfVer(rxDistrbConf); // 배포설정 update
				cRxDistrbConfDao.insertRxDistrbHstry(rxDistrbConf);
				updateCheck.setSuccYn("Y");


				//Pod정보 반영
				DeploymentConfigsIfVo deploymentconfigsIfVo = new DeploymentConfigsIfVo();
				deploymentconfigsIfVo.setName(atmsclDistrbVo.getDistrbConfId());
				deploymentconfigsIfVo.setNamespaceId(atmsclDistrbVo.getServcAreaId());

				List<PodIfVo> podIfVoList = servcAPIService.podsGet(headers, deploymentconfigsIfVo);

				ServcPodVo pvo = new ServcPodVo();
				pvo.setServcSeq(atmsclDistrbVo.getServcSeq());
				List<ServcPodVo> servcPodList = servcDao.selectServcPodList(pvo);


				String podId = "";
				String podUid = "";
				String podStatCd = "";
				boolean checkFlag = false;
				RxServcPod rxServcPod =  null;

				// API호출 Pod정보
				for (PodIfVo podDetail : podIfVoList) {
					podId = podDetail.getName();
					podUid  = podDetail.getUid();

					rxServcPod = new RxServcPod();
					rxServcPod.setServcSeq(rxDistrbConf.getServcSeq());
					rxServcPod.setPodId(podId);
					rxServcPod.setPodNm(podId);
					rxServcPod.setPodIpAddr(podDetail.getHostIP());
					rxServcPod.setPodUid(podDetail.getUid());
					rxServcPod.setImgId(podDetail.getImage());
					rxServcPod.setRsrcPoolId(atmsclDistrbVo.getRsrcPoolId());
					rxServcPod.setImgRepoDtlAddr(podDetail.getImageID());
					rxServcPod.setCreDttm(podDetail.getCreationTimestamp());
					rxServcPod.setStrtDttm(podDetail.getStartTime());
					rxServcPod.setStatCd(podDetail.getPhase());
					rxServcPod.setAtmsclNodeId(podDetail.getNodeName());
					rxServcPod.setPodTyCd(podDetail.getPodType());
					rxServcPod.setDelYn("N");

					//DB에 해당 서비스의  Pod가 있을경우
					if(servcPodList.size() >0 ) {
						checkFlag = false;
						podStatCd = "";

						//DB에 있는 Pod정보
						for (ServcPodVo servcPodVo : servcPodList) {

							//Pod ID와 UID가 서로 일치하는지 체크
							if(podId.equals(servcPodVo.getPodId()) && podUid.equals(servcPodVo.getPodUid())  ) {
								if("01".equals(servcPodVo.getPodTyCd())) {
									podStatCd = servcPodVo.getStatCd();
								}
								checkFlag = true;
								break;
							}
						}

						if(checkFlag) { //일치할 경우는 update
							if(podDetail.getPhase() !=null && ("01".equals(podDetail.getPodType()))) {
								if(!podStatCd.equals(podDetail.getPhase())) {
									cRxServcPodDao.updateRxServcPod(rxServcPod); // update
								}
							}
						}else {  //DB에 일치하는 건이 없을경우 insert
							cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
						}
					}else { //DB에 해당 서비스의  Pod가 없을경우 insert
						cRxServcPodDao.insertRxServcPod(rxServcPod); // insert
					}
					}
				//DB에는 있으나 API호출정보에 없으면 삭제처리
				for (ServcPodVo servcPodVo : servcPodList) { //DB에 있는 데이터
					checkFlag = false;
					for (PodIfVo podDetail : podIfVoList) { //API호출 데이터

						//Pod ID와 UID가 서로 일치하는지 체크
						if(podDetail.getName().equals(servcPodVo.getPodId()) && podDetail.getUid().equals(servcPodVo.getPodUid())  ) {
							checkFlag = true;  // 일치여부
						}
					}

					if(!checkFlag) {  //일치하지 않을 경우
						rxServcPod = new RxServcPod();
						rxServcPod.setServcSeq(rxDistrbConf.getServcSeq());
						rxServcPod.setPodId(servcPodVo.getPodId());
						cRxServcPodDao.deleteRxServcPod((rxServcPod)); //해당 Pod삭제
					}
				}
				}

			}


		if(null == updateCheck.getSuccYn()  || "".equals(updateCheck.getSuccYn())  ){
			updateCheck.setSuccYn("N");
		}
		return updateCheck;
	}


	@Override
	public void insertDistrbAutoConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception {

		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		String scalrId = atmsclDistrbVo.getServcSeq() + "_";
		String seqNum = commonService.selectSeqNum("RX_SERVC_SCLNG",scalrId);
		RxRsrvSclng rxRsrvSclng = new RxRsrvSclng();
		rxRsrvSclng.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxRsrvSclng.setScalrId(seqNum);
		rxRsrvSclng.setSclngClCd(atmsclDistrbVo.getSclngClCd());
		rxRsrvSclng.setScalrNm(seqNum);
		rxRsrvSclng.setNowPodQty(atmsclDistrbVo.getNowPodQty());
		rxRsrvSclng.setMinPodQty(atmsclDistrbVo.getMinPodQty());
		rxRsrvSclng.setMaxPodQty(atmsclDistrbVo.getMaxPodQty());
		rxRsrvSclng.setUseYn("Y");
		rxRsrvSclng.setAlarmYn("N");
		rxRsrvSclng.setCreUserId(atmsclDistrbVo.getRegUserId());
		rxRsrvSclng.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxRsrvSclng.setServcId(atmsclDistrbVo.getServcId());
		if (atmsclDistrbVo.getSclngClCd().equals("01"))
		{

			//임계치설정 정보
			rxRsrvSclng.setStrtThresVl(atmsclDistrbVo.getEndThresVl());
			rxRsrvSclng.setEndThresVl(atmsclDistrbVo.getEndThresVl());
			rxRsrvSclng.setThresClCd("01");
			try {
					AtmSclResultIfVo insertDistrbAutoConf = atmsclDistrbAPIService.insertDistrbAutoConf(headers,rxRsrvSclng);
				if ("Y".equals(insertDistrbAutoConf.getSuccYn())) {
					cRxDistrbConfDao.insertDistrbAutoConf(rxRsrvSclng);
				}else{
					throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
				}

			}catch(HttpServerErrorException e){
				throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
			}catch(HttpStatusCodeException e){
				throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
			}catch(IllegalArgumentException e){
				throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
			}


		}else if(atmsclDistrbVo.getSclngClCd().equals("02")) {


			if ( atmsclDistrbVo.getDistrbMultiSclList() != null) {
				RxMnulScl rxMnulScl = new RxMnulScl();

				rxMnulScl.setServcAreaId(atmsclDistrbVo.getServcAreaId());
				rxMnulScl.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
				rxMnulScl.setChngPodQty(atmsclDistrbVo.getMinPodQty());
				AtmSclResultIfVo putReplicasAdd = atmsclDistrbAPIService.putReplicasAdd(headers,rxMnulScl);

				//임계치설정 정보
//				rxRsrvSclng.setStrtThresVl(atmsclDistrbVo.getEndThresVl());
//				rxRsrvSclng.setEndThresVl(atmsclDistrbVo.getEndThresVl());
//				rxRsrvSclng.setThresClCd("0");
				if("Y".equals(putReplicasAdd.getSuccYn())){
					try {

						cRxDistrbConfDao.insertDistrbMultiSclConf(rxRsrvSclng);
						for (RsrvSclngVo sclVo :  atmsclDistrbVo.getDistrbMultiSclList()) {

							rxRsrvSclng.setStrtThresVl(sclVo.getEndThresVl());
							rxRsrvSclng.setEndThresVl(sclVo.getEndThresVl());
							rxRsrvSclng.setThresClCd(sclVo.getThresClCd());
							rxRsrvSclng.setSclGrpCd(sclVo.getSclGrpCd());

							cRxDistrbConfDao.insertDistrbMultiSclThresConf(rxRsrvSclng);
						}

					}catch(HttpServerErrorException e){
						throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
					}catch(HttpStatusCodeException e){
						throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
					}
				}else{
					throw new CommonException("스케일 설정 시 오류가 발생했습니다.");
				}
			}

		}


	}


	@Override
	public AtmSclResultIfVo selectDistrbStat(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		AtmSclResultIfVo distrbStat = atmsclDistrbAPIService.selectDistrbStat(headers,atmsclDistrbVo);
		AtmSclResultIfVo resultStat = new AtmSclResultIfVo();
		if("Y".equals(distrbStat.getSuccYn())){

			if(null != distrbStat.getStatCd() || "" != distrbStat.getStatCd()){
				if("01" != distrbStat.getStatCd()){


					RxDistrbConf rxDistrbConf = new RxDistrbConf();
					RxDistrbHstry rxDistrbHstry = new RxDistrbHstry();

					String distrbId = atmsclDistrbVo.getDistrbConfId()+"-"+atmsclDistrbVo.getLastDistrbVer();
					rxDistrbConf.setServcSeq(atmsclDistrbVo.getServcSeq());
					rxDistrbConf.setDistrbId(distrbId);
					rxDistrbConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
					rxDistrbConf.setLastDistrbVer(atmsclDistrbVo.getLastDistrbVer());
					rxDistrbConf.setUpdtUserId(atmsclDistrbVo.getUpdtUserId());
					rxDistrbConf.setStatCd( distrbStat.getStatCd());

					rxDistrbHstry.setServcSeq(atmsclDistrbVo.getServcSeq());
					rxDistrbHstry.setDistrbId(distrbId);
					rxDistrbHstry.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
					rxDistrbHstry.setDistrbVer(atmsclDistrbVo.getLastDistrbVer());

					rxDistrbHstry.setDistrbStatCd(distrbStat.getStatCd());

					rxDistrbHstry.setTmplatNm(atmsclDistrbVo.getTmplatNm()); //?
					rxDistrbHstry.setReStrtPolicyClCd(atmsclDistrbVo.getReStrtPolicyClCd());
					rxDistrbHstry.setDnsPolicyClCd(atmsclDistrbVo.getDnsPolicyClCd());
					rxDistrbHstry.setReqCpuCorQty(atmsclDistrbVo.getReqCpuCorQty());
					rxDistrbHstry.setReqMemCapa(atmsclDistrbVo.getReqMemCapa());
					rxDistrbHstry.setLmttCpuCorQty(atmsclDistrbVo.getLmttCpuCorQty());
					rxDistrbHstry.setLmttMemCapa(atmsclDistrbVo.getLmttMemCapa());
					rxDistrbHstry.setRplcaQty(atmsclDistrbVo.getRplcaQty());

					cRxDistrbConfDao.updateRxDistrbConfVer(rxDistrbConf); // 배포설정 update
					cRxDistrbHstryDao.updateRxDistrbHstryStat(rxDistrbHstry); // 배포이력 update
					resultStat.setSuccYn("Y");
				}else{
					resultStat.setSuccYn("N");
				}

			}else{
				resultStat.setSuccYn("N");
			}

		}else{
			resultStat.setSuccYn("N");
		}


		return resultStat;
	}


	@Override
	public List<AtmsclDistrbVo> selectAtmsclDistrbListP(AtmsclDistrbSearchVo atmsclDistrbSearchVo) {
		List<AtmsclDistrbVo> list = null;
		int totalCount = atmsclDistrbDao.selectAtmsclDistrbTotCntP(atmsclDistrbSearchVo);

		if(totalCount > 0){
			atmsclDistrbSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = atmsclDistrbDao.selectAtmsclDistrbListP(atmsclDistrbSearchVo);
		}

		return list;
	}

	//스토리지 추가 정보
	@Override
	public List<PvcVo> selectDistrbPvc(AtmsclDistrbVo atmsclDistrbVo) {

		return atmsclDistrbDao.selectDistrbPvc(atmsclDistrbVo);
	}

	//배포 설정 저장
	@Override
	public void updateDistrbConfSave(AtmsclDistrbVo atmsclDistrbVo) throws Exception  {
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		List<DistrbEnvConfVo> selectDistrbEnvConfExcept = atmsclDistrbDao.selectDistrbEnvConfExcept(atmsclDistrbVo);
		atmsclDistrbVo.setDefaultYn("Y");
		atmsclDistrbVo.setCheckCd("02");
		List<DistrbEnvConfVo> distrbEnvConfList = atmsclDistrbVo.getDistrbEnvConfList();
		AtmSclResultIfVo updateDistrbConfApi;
		try {
			updateDistrbConfApi = atmsclDistrbAPIService.updateDistrbConfApi(headers,atmsclDistrbVo,selectDistrbEnvConfExcept);
			if("Y".equals(updateDistrbConfApi.getSuccYn())){
				String varVlTyCd = "01";
				RxDistrbConf rxDistrbConf = new RxDistrbConf();
				rxDistrbConf.setRmk(atmsclDistrbVo.getRmk());
				rxDistrbConf.setUpdtUserId(atmsclDistrbVo.getUpdtUserId());
				rxDistrbConf.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxDistrbConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());

				RxDistrbEnvConf rxEnvConf = new RxDistrbEnvConf();
				rxEnvConf.setServcSeq(atmsclDistrbVo.getServcSeq());
				rxEnvConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
				rxEnvConf.setVarVlTyCd(varVlTyCd);
					if (null != atmsclDistrbVo.getDistrbEnvConfList()) {

						cRxDistrbConfDao.updateRxDistrbConfSave(rxDistrbConf); // 배포설정 update
						cRxDistrbConfDao.deleteDistrbConf(rxEnvConf); //기존 환경변수 삭제
						for (DistrbEnvConfVo distrbEnvConfVo : distrbEnvConfList) {
							rxEnvConf.setEnvVarNm(distrbEnvConfVo.getEnvVarNm());
							rxEnvConf.setEnvVarVl(distrbEnvConfVo.getEnvVarVl());
							cRxDistrbConfDao.insertDistrbConf(rxEnvConf); // 환경변수 Insert
						}
					}else{
						cRxDistrbConfDao.updateRxDistrbConfSave(rxDistrbConf); // 배포설정 update
					}

			}else{
				throw new CommonException("배포 설정 저장시 오류가 발생했습니다.");
			}

		} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			throw new CommonException("배포 설정 저장시 오류가 발생했습니다.");
		}


	}


	@Override
	public void updateDistrbAutoSclConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());


		RxRsrvSclng rxRsrvSclng = new RxRsrvSclng();
		rxRsrvSclng.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxRsrvSclng.setScalrId(atmsclDistrbVo.getScalrId());
		rxRsrvSclng.setSclngClCd(atmsclDistrbVo.getSclngClCd());
		rxRsrvSclng.setScalrNm(atmsclDistrbVo.getScalrId());
		rxRsrvSclng.setNowPodQty(atmsclDistrbVo.getNowPodQty());
		rxRsrvSclng.setMinPodQty(atmsclDistrbVo.getMinPodQty());
		rxRsrvSclng.setMaxPodQty(atmsclDistrbVo.getMaxPodQty());
		rxRsrvSclng.setUseYn("Y");
		rxRsrvSclng.setAlarmYn("N");
		rxRsrvSclng.setCreUserId(atmsclDistrbVo.getCreUserId());
		rxRsrvSclng.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxRsrvSclng.setServcId(atmsclDistrbVo.getServcId());


		if (atmsclDistrbVo.getSclngClCd().equals("01"))
		{

			//임계치설정 정보
			rxRsrvSclng.setStrtThresVl(atmsclDistrbVo.getEndThresVl());
			rxRsrvSclng.setEndThresVl(atmsclDistrbVo.getEndThresVl());
			rxRsrvSclng.setThresClCd("01"); //CPU
			// 수정 Api
			AtmSclResultIfVo updateDistrbAutoConf = atmsclDistrbAPIService.updateDistrbAutoConf(headers,rxRsrvSclng);
			if("Y".equals(updateDistrbAutoConf.getSuccYn())){
				try {
					cRxDistrbConfDao.updateDistrbAutoConf(rxRsrvSclng);
				}catch(HttpServerErrorException e){
					throw new CommonException("스케일 설정 수정 시 오류가 발생했습니다."+e.getMessage());
				}catch(HttpStatusCodeException e){
					throw new CommonException("스케일 설정 수정 시 오류가 발생했습니다."+e.getMessage());
				}
			}else{
				throw new CommonException("스케일 설정 수정 시 오류가 발생했습니다.");
			}

		}else if(atmsclDistrbVo.getSclngClCd().equals("02")) {


			if ( atmsclDistrbVo.getDistrbMultiSclList() != null) {

				//임계치설정 정보
//				rxRsrvSclng.setStrtThresVl(atmsclDistrbVo.getEndThresVl());
//				rxRsrvSclng.setEndThresVl(atmsclDistrbVo.getEndThresVl());
//				rxRsrvSclng.setThresClCd("0");

				try {

					cRxDistrbConfDao.deleteDistrbMultiScl(rxRsrvSclng);
//					for (RsrvSclngVo sclVo :  atmsclDistrbVo.getDistrbMultiSclList()) {
//						System.out.println(sclVo.getSclGrpCd());
//						System.out.println(sclVo.getThresClCd());
//						System.out.println(sclVo.getEndThresVl());
//						rxRsrvSclng.setStrtThresVl(sclVo.getEndThresVl());
//						rxRsrvSclng.setEndThresVl(sclVo.getEndThresVl());
//						rxRsrvSclng.setThresClCd(sclVo.getThresClCd());
//						rxRsrvSclng.setSclGrpCd(sclVo.getSclGrpCd());
////
////						cRxDistrbConfDao.updateDistrbMultiSclThresConf(rxRsrvSclng);
//					}
					cRxDistrbConfDao.insertDistrbMultiSclConf(rxRsrvSclng);
					for (RsrvSclngVo sclVo :  atmsclDistrbVo.getDistrbMultiSclList()) {


						rxRsrvSclng.setStrtThresVl(sclVo.getEndThresVl());
						rxRsrvSclng.setEndThresVl(sclVo.getEndThresVl());
						rxRsrvSclng.setThresClCd(sclVo.getThresClCd());
						rxRsrvSclng.setSclGrpCd(sclVo.getSclGrpCd());
						cRxDistrbConfDao.insertDistrbMultiSclThresConf(rxRsrvSclng);
					}



				}catch (IllegalArgumentException |  BadSqlGrammarException   e) {
					throw new CommonException("스케일 설정 수정 시 오류가 발생했습니다."+e.getMessage());
				}catch(HttpServerErrorException e){
					throw new Exception(e.getResponseBodyAsString());
				}catch(HttpStatusCodeException e){
					throw new Exception(e.getResponseBodyAsString());
				}


			}

		}
	}


	@Override
	public void deleteDistrbAutoSclConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		RxRsrvSclng rxRsrvSclng = new RxRsrvSclng();
		rxRsrvSclng.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxRsrvSclng.setServcId(atmsclDistrbVo.getServcId());
		rxRsrvSclng.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxRsrvSclng.setScalrId(atmsclDistrbVo.getScalrId());
		rxRsrvSclng.setThresClCd(atmsclDistrbVo.getThresClCd());
		rxRsrvSclng.setSclGrpCd(atmsclDistrbVo.getSclGrpCd());

		if (atmsclDistrbVo.getSclngClCd().equals("01")){
			AtmSclResultIfVo deleteDistrbAutoSclConf = atmsclDistrbAPIService.deleteDistrbAutoSclConf(headers,rxRsrvSclng);
			if("Y".equals(deleteDistrbAutoSclConf.getSuccYn())){
				try {
					cRxDistrbConfDao.deleteDistrbAutoSclConf(rxRsrvSclng);
				}  catch (IllegalArgumentException | BadSqlGrammarException  e) {
					logger.error(e.getMessage(),e);
					throw new CommonException("스케일 설정 수정 시 오류가 발생했습니다.");
				}
			}else{
				throw new CommonException("스케일 설정 삭제 시 오류가 발생했습니다.");
			}
		}else if(atmsclDistrbVo.getSclngClCd().equals("02")) {
			if ( atmsclDistrbVo.getDistrbMultiSclList() != null) {
				try {
					cRxDistrbConfDao.deleteDistrbAutoSclConf(rxRsrvSclng);
					for (RsrvSclngVo sclVo :  atmsclDistrbVo.getDistrbMultiSclList()) {

						rxRsrvSclng.setStrtThresVl(sclVo.getEndThresVl());
						rxRsrvSclng.setEndThresVl(sclVo.getEndThresVl());
						rxRsrvSclng.setThresClCd(sclVo.getThresClCd());
						rxRsrvSclng.setSclGrpCd(sclVo.getSclGrpCd());
						cRxDistrbConfDao.deleteDistrbMultiSclConf(rxRsrvSclng);
					}

				} catch (IllegalArgumentException | BadSqlGrammarException  e) {
					logger.error(e.getMessage(),e);
				}
			}

		}
	}


	@Override
	public AtmsclDistrbVo selectPodQuata(AtmsclDistrbVo atmsclDistrbVo) {
		return atmsclDistrbDao.selectPodQuata(atmsclDistrbVo);
	}

	@Override
	public AtmSclResultIfVo updateInitRsrcLt(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		AtmSclResultIfVo updateCheck = new AtmSclResultIfVo();
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		RxDistrbConf disConf = new RxDistrbConf();
		disConf.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		disConf.setServcSeq(atmsclDistrbVo.getServcSeq());
		disConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
		disConf.setDistrbId(atmsclDistrbVo.getDistrbId());
		AtmSclResultIfVo updateRsrcLtApi = atmsclDistrbAPIService.updateInitRsrcLtApi(headers,disConf);

		if ("Y".equals(updateRsrcLtApi.getSuccYn())) {
			try {
				cRxDistrbConfDao.updateInitRsrcLt(disConf);
				updateCheck.setSuccYn("Y");

			}catch(HttpServerErrorException  e){
				throw new CommonException("자원제한 초기화 시 오류가 발생했습니다."+e.getMessage());
			}catch (HttpStatusCodeException e) {
				throw new CommonException("자원제한 초기화 시 오류가 발생했습니다."+e.getMessage());
			}
		}else{
			updateCheck.setSuccYn("N");
		}

		return updateCheck;
	}


	@Override
	public AtmSclResultIfVo deletePvc(AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(atmsclDistrbVo.getRegionId());
		headers.setZoneId(atmsclDistrbVo.getZoneId());
		headers.setNetworkId(atmsclDistrbVo.getNetClCd());
		headers.setManagerId(atmsclDistrbVo.getRsrcPoolId());

		RxPvc rxPvc = new RxPvc();
		rxPvc.setServcAreaSeq(atmsclDistrbVo.getServcAreaSeq());
		rxPvc.setServcSeq(atmsclDistrbVo.getServcSeq());
		rxPvc.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
		rxPvc.setPvcId(atmsclDistrbVo.getPvcId());
		rxPvc.setPvId(atmsclDistrbVo.getPvId());
		rxPvc.setServcAreaId(atmsclDistrbVo.getServcAreaId());
		rxPvc.setVolumeNm(atmsclDistrbVo.getVolumeNm());

		AtmSclResultIfVo deletePvcApi = new AtmSclResultIfVo();;
		try {
			deletePvcApi = atmsclDistrbAPIService.deletePvc(headers,rxPvc);
			if("Y".equals(deletePvcApi.getSuccYn())){
					cRxDistrbConfDao.deleteDistrbAsgn(rxPvc); // 배포설정 pvc 할당
					cRxDistrbConfDao.deletePvcStrgAdd(rxPvc); // pvc 추가
					return deletePvcApi;
			}else{
				throw new CommonException("스토리지 삭제 시 오류가 발생했습니다.");
			}
		} catch (IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
			throw new CommonException("스토리지 삭제 시 오류가 발생했습니다.");
		}


	}

//자원확장 배포이력 상태 조회
	@Override
	public int selectDitrbStatCnt(AtmsclDistrbVo atmsclDistrbVo)throws Exception {
		int statCnt = atmsclDistrbDao.selectDitrbStatCnt(atmsclDistrbVo);
			return statCnt;
	}



}
