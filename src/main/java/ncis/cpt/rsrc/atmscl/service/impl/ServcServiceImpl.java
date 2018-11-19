package ncis.cpt.rsrc.atmscl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxBldConfDao;
import ncis.cmn.dao.CRxBldHstryDao;
import ncis.cmn.dao.CRxDistrbConfDao;
import ncis.cmn.dao.CRxDistrbEnvConfDao;
import ncis.cmn.dao.CRxDistrbHstryDao;
import ncis.cmn.dao.CRxImgDao;
import ncis.cmn.dao.CRxScrtkyDao;
import ncis.cmn.dao.CRxServcDao;
import ncis.cmn.dao.CRxServcPodDao;
import ncis.cmn.dao.CRxServcPortDao;
import ncis.cmn.dao.CRxServcRouteDao;
import ncis.cmn.entity.RxBldConf;
import ncis.cmn.entity.RxBldHstry;
import ncis.cmn.entity.RxDistrbConf;
import ncis.cmn.entity.RxDistrbEnvConf;
import ncis.cmn.entity.RxDistrbHstry;
import ncis.cmn.entity.RxImg;
import ncis.cmn.entity.RxScrtky;
import ncis.cmn.entity.RxServc;
import ncis.cmn.entity.RxServcPod;
import ncis.cmn.entity.RxServcPort;
import ncis.cmn.entity.RxServcRoute;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.opr.catalg.dao.BaseImgDao;
import ncis.cpt.opr.catalg.vo.BaseImgVo;
import ncis.cpt.rsrc.atmscl.dao.ServcDao;
import ncis.cpt.rsrc.atmscl.service.ServcService;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.cpt.rsrc.atmscl.vo.ScrtkyVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPortVo;
import ncis.cpt.rsrc.atmscl.vo.ServcRouteVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSclngVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.intfc.atmscl.service.ServcAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.BuildConfigsIfVo;
import ncis.intfc.atmscl.vo.ContainersPortsIfVo;
import ncis.intfc.atmscl.vo.DeploymentConfigsIfVo;
import ncis.intfc.atmscl.vo.EnvIfVo;
import ncis.intfc.atmscl.vo.ImagestreamsIfVo;
import ncis.intfc.atmscl.vo.PodIfVo;
import ncis.intfc.atmscl.vo.RoutesIfVo;
import ncis.intfc.atmscl.vo.SecretsIfVo;
import ncis.intfc.atmscl.vo.ServicesIfVo;
import ncis.intfc.atmscl.vo.ServicesPortsIfVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service("servcService")
public class ServcServiceImpl implements ServcService {

	@Resource(name="servcDao")
	private ServcDao servcDao;

	@Resource(name="baseImgDao")
	private BaseImgDao baseImgDao;

	@Resource(name="cRxServcDao")
	private CRxServcDao cRxServcDao;

	@Resource(name="cRxBldConfDao")
	private CRxBldConfDao cRxBldConfDao;

	@Resource(name="cRxBldHstryDao")
	private CRxBldHstryDao cRxBldHstryDao;

	@Resource(name="cRxImgDao")
	private CRxImgDao cRxImgDao;

	@Resource(name="cRxServcRouteDao")
	private CRxServcRouteDao cRxServcRouteDao;

	@Resource(name="cRxServcPortDao")
	private CRxServcPortDao cRxServcPortDao;

	@Resource(name="cRxScrtkyDao")
	private CRxScrtkyDao cRxScrtkyDao;

	@Resource(name="cRxDistrbConfDao")
	private CRxDistrbConfDao cRxDistrbConfDao;

	@Resource(name="cRxDistrbHstryDao")
	private CRxDistrbHstryDao cRxDistrbHstryDao;

	@Resource(name="cRxDistrbEnvConfDao")
	private CRxDistrbEnvConfDao cRxDistrbEnvConfDao;

	@Resource(name="cRxServcPodDao")
	private CRxServcPodDao cRxServcPodDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="servcAPIService")
	private ServcAPIService servcAPIService;


	/**
	 * 서비스 목록 조회
	 * @param  searchVo
	 * @return
	 */
	@Override
	public List<ServcVo> selectServcList(ServcSearchVo searchVo) {

		List<ServcVo> list = null;
		int totalCount = servcDao.selectServcTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한   count
			list = servcDao.selectServcList(searchVo);
		}

		return list;
	}


	/**
	 * 보인키 목록 조회
	 * @param  servcAreaSeq
	 * @return
	 */
	@Override
	public List<ScrtkyVo> selectScrtKyList(int servcAreaSeq) {

		List<ScrtkyVo> list = servcDao.selectScrtKyList(servcAreaSeq);
		return list;
	}


	/**
	 * 보안키 생성
	 * @param vo
	 * @return String
	 */
	@Override
	public String insertScrtky(ScrtkyVo vo) throws Exception{

		//보안키 ID 정규식 체크
		if(!Pattern.matches("[a-z0-9]([-a-z0-9]*[a-z0-9])?", vo.getScrtkyId())) {
			throw new CommonException("보안키ID를 다시 입력해 주세요.");
		}

		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		String passwd = Base64.encodeBase64String(vo.getPasswd().getBytes());
		String userNm = Base64.encodeBase64String(vo.getId().getBytes());

		//해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(vo.getRegionId());
		headers.setZoneId(vo.getZoneId());
		headers.setNetworkId(vo.getNetClCd());
		headers.setManagerId(vo.getRsrcPoolId());

		//보안키 생성에 필요한 데이터 셋팅
		SecretsIfVo secretsIfVo = new SecretsIfVo();
		secretsIfVo.setName(vo.getScrtkyId());
		secretsIfVo.setNamespaceId(vo.getServcAreaId());
		secretsIfVo.setPassword(passwd);
		secretsIfVo.setUsername(userNm);
		secretsIfVo.setType(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SECRETS_TYPE);

		//보안키 생성 API호출
		AtmSclResultIfVo atmSclResultIfVo = servcAPIService.secretsPost(headers, secretsIfVo);

		//정상적으로 생성되었을 경우
		if("Y".equals(atmSclResultIfVo.getSuccYn())) {

			RxScrtky rxScrtky = new RxScrtky();
			BeanUtils.copyProperties(rxScrtky, vo);
			rxScrtky.setPasswd(passwd);
			rxScrtky.setId(userNm);
			rxScrtky.setCrtfcMthdClCd("01");  //인증방식구분코드
			cRxScrtkyDao.insertRxScrtky(rxScrtky); //보안키 insert
			resultmessage =  OprConstant.RX_CRE_SUCC_MSG;
		}else {
			resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
		}

		return resultmessage;
	}



	/**
	 * 서비스 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	@Override
	public String insertServc(ServcVo vo) throws Exception{

		/*  아래의 API가 모두 정상적으로 수행되어야 이후 업무가(빌드, 배포 등) 정상적으로 처리됨
		 	1. 서비스 생성 API호출
		 	2. 라우트 생성 API호출
		 	3. 이미지스트림 생성 API호출
		 	4. 빌드설정 생성 API호출
		 	5. 빌드실행 API 호출
		 	6. 배포설정 생성  API호출
		 */

		AtmSclResultIfVo atmSclResultIfVo = null;
		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		ServicesPortsIfVo servicesPortsIfVo = null;
		ServicesIfVo servicesIfVo = null;
		RestHeaders headers = null;

		String servcUid = null;
		String routeUid = null;
		String imagestreamUid = null;
		String imgRepoAddr = null;
		String lastBldVer = null;
		String servcCreationTime = null;

		boolean servcFlag = false;  //서비스 생성 API호출 성공여부
		boolean routeFlag = false;  //라우트 생성 API호출 성공여부
		boolean imagestreamFlag = false;  //이미지스트림 생성 API호출 성공여부
		boolean buildConfig = false; //빌드설정 생성 API호출 성공여부
		boolean instantiateFlag = false; //빌드이력 생성 API호출 성공여부
		boolean deploymentconfigFlag = false; //배포설정 생성 API호출 성공여부

		boolean succFlag = false; //API호출 성공여부
		boolean dbSuccFlag = false; //DB처리 성공여부

		String servcId = commonService.selectSeqNum("RX_SERVC", vo.getServcAreaId()+"-");  // 서비스 ID를 셋팅한다.
		String routeId = commonService.selectSeqNum("RX_SERVC_ROUTE", servcId+"-");  //라우트 ID를 셋팅한다.

		try{

			// 환경변수명 체크
			if(!checkDistrbEnvConf(vo.getDistrbEnvConfList())) {
				throw new CommonException("환경변수 명을 다시 입력해 주세요.");
			}

			//해더정보 셋팅
			headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			BaseImgVo baseImgVo = new BaseImgVo();
			baseImgVo.setRsrcPoolId(vo.getRsrcPoolId());
			baseImgVo.setImgId(vo.getImgId());
			baseImgVo.setServcAreaSeq(vo.getBaseImgServcAreaSeq());

			List<BaseImgVo> baseImgPortList = baseImgDao.selectBaseImgPortList(baseImgVo); //베이스 이미지 포트정보

			//서비스 생성 API호출에 필요한  포트 정보를 담는다.
			List<ServicesPortsIfVo> portList = new ArrayList<ServicesPortsIfVo>();
			for(BaseImgVo getVo : baseImgPortList) {
				servicesPortsIfVo = new ServicesPortsIfVo();
				servicesPortsIfVo.setPort(getVo.getPort());
				servicesPortsIfVo.setTargetPort(getVo.getPort());
				servicesPortsIfVo.setProtocol(getVo.getPrtcl().toUpperCase());
				servicesPortsIfVo.setName(getVo.getPortInfo());
				portList.add(servicesPortsIfVo);
			}

			//서비스 생성에 필요한 데이터 셋팅
			servicesIfVo = new ServicesIfVo();
			servicesIfVo.setName(servcId);
			servicesIfVo.setDisplayName(vo.getServcNm());
			servicesIfVo.setDescription(vo.getRmk());
			servicesIfVo.setBaseImgId(vo.getImgId());
			servicesIfVo.setNamespaceId(vo.getServcAreaId());
			servicesIfVo.setPorts(portList);

			//서비스 생성 API호출
			atmSclResultIfVo = servcAPIService.servicesPost(headers, servicesIfVo);

			//서비스가 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				servcUid = atmSclResultIfVo.getUid();
				servcCreationTime = atmSclResultIfVo.getCreationTime();
				servcFlag = true;

				//라우트 생성에 필요한 데이터 셋팅
				RoutesIfVo routesIfVo = new RoutesIfVo();
				routesIfVo.setName(routeId);
				routesIfVo.setHost(vo.getHstNm());
				routesIfVo.setBaseImgId(vo.getImgId());
				routesIfVo.setNamespaceId(vo.getServcAreaId());
				routesIfVo.setServiceName(servcId);
				routesIfVo.setTargetPort(vo.getTargtPort());
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//라우트 생성  API호출
				atmSclResultIfVo = servcAPIService.routesPost(headers, routesIfVo);

				routeUid = atmSclResultIfVo.getUid(); //생성된 라우트의 uid
			}

			//라우트가 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				routeFlag = true;
				ImagestreamsIfVo imagestreamsIfVo = new ImagestreamsIfVo();
				imagestreamsIfVo.setName(servcId);
				imagestreamsIfVo.setServiceName(servcId);
				imagestreamsIfVo.setBaseImgId(vo.getImgId());
				imagestreamsIfVo.setNamespaceId(vo.getServcAreaId());
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//이미지스트림 생성  API호출
				atmSclResultIfVo = servcAPIService.imagestreamsPost(headers, imagestreamsIfVo);

				imagestreamUid = atmSclResultIfVo.getUid(); //생성된 이미지의 uid
				imgRepoAddr = atmSclResultIfVo.getImgRepoAddr(); //이미지경로
			}

			//이미지스트림이 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				imagestreamFlag = true;
				BuildConfigsIfVo buildConfigsIfVo = new BuildConfigsIfVo();
				buildConfigsIfVo.setContextDir(vo.getGitBestPath());
				buildConfigsIfVo.setName(servcId);
				buildConfigsIfVo.setNamespaceId(vo.getServcAreaId());
				buildConfigsIfVo.setRef(vo.getGitBrnchNm());
				buildConfigsIfVo.setSecret(vo.getGitScrtkyId());
				buildConfigsIfVo.setServiceName(servcId);
				buildConfigsIfVo.setSourceType(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BUILD_SOURCE_TYPE);
				buildConfigsIfVo.setUri(vo.getGitRepoAddr());
				buildConfigsIfVo.setBaseImgId(vo.getImgId());
				buildConfigsIfVo.setBaseImgVer(vo.getImgVer());
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//빌드설정 생성  API호출
				atmSclResultIfVo = servcAPIService.buildconfigsPost(headers, buildConfigsIfVo);

				if("Y".equals(atmSclResultIfVo.getSuccYn())) {
					buildConfig = true;
					//빌드실행 API호출
					atmSclResultIfVo = servcAPIService.instantiatePost(headers, buildConfigsIfVo);
				}
			}

			//빌드실행이 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				instantiateFlag = true;
				DeploymentConfigsIfVo deploymentconfigsIfVo = new DeploymentConfigsIfVo();
				ContainersPortsIfVo containersPortsIfVo = null;
				List<ContainersPortsIfVo> containerPortList = new ArrayList<ContainersPortsIfVo>();

				for(BaseImgVo getVo : baseImgPortList) {
					containersPortsIfVo = new ContainersPortsIfVo();
					containersPortsIfVo.setContainerPort(getVo.getPort());
					containersPortsIfVo.setProtocol(getVo.getPrtcl().toUpperCase());
					containerPortList.add(containersPortsIfVo);
				}

				deploymentconfigsIfVo.setName(servcId);
				deploymentconfigsIfVo.setBaseImgId(vo.getImgId());
				deploymentconfigsIfVo.setNamespaceId(vo.getServcAreaId());
				deploymentconfigsIfVo.setPorts(containerPortList);
				deploymentconfigsIfVo.setServiceName(servcId);
				deploymentconfigsIfVo.setImgRepoAddr(imgRepoAddr);
				deploymentconfigsIfVo.setReplicas(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_DEFAULT_REPLICAS);

				List<EnvIfVo> envIfList = new ArrayList<EnvIfVo>();
				EnvIfVo envIfVo = null;

				if(!ObjectUtils.isEmpty(vo.getDistrbEnvConfList())) {
					for(DistrbEnvConfVo getVo : vo.getDistrbEnvConfList()) {
						envIfVo = new EnvIfVo();
						envIfVo.setName(getVo.getEnvVarNm());
						envIfVo.setValue(getVo.getEnvVarVl());
						envIfList.add(envIfVo);
					}
				}

				deploymentconfigsIfVo.setEnvList(envIfList);
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//배포설정 생성  API호출
				atmSclResultIfVo = servcAPIService.deploymentConfigsPost(headers, deploymentconfigsIfVo);

				if("Y".equals(atmSclResultIfVo.getSuccYn())) {
					succFlag = true;
					deploymentconfigFlag = true;
				}
			}

			//API호출이 최종 성공일 경우
			if(succFlag) {

				//서비스정보 insert
				RxServc rxServc = new RxServc();
				BeanUtils.copyProperties(rxServc, vo);
				rxServc.setServcUid(servcUid);
				rxServc.setServcId(servcId);
				rxServc.setStatCd("01");
				rxServc.setServcTyCd("01"); //서비스구부
				rxServc.setCreDttm(servcCreationTime);
				cRxServcDao.insertRxServc(rxServc);

				//이미지정보 insert
				RxImg rxImg = new RxImg();
				BeanUtils.copyProperties(rxImg, vo);
				rxImg.setImgUid(imagestreamUid);
				rxImg.setImgNm(servcId);
				rxImg.setBasImgYn("N");
				rxImg.setImgId(servcId);
				rxImg.setUseYn("Y");
				rxImg.setImgRepoAddr(imgRepoAddr);
				cRxImgDao.insertRxImg(rxImg);

				//빌드설정정보 insert
				lastBldVer = "1";
				RxBldConf rxBldConf	 = new RxBldConf();
				BeanUtils.copyProperties(rxBldConf, vo);
				rxBldConf.setServcSeq(rxServc.getServcSeq());
				rxBldConf.setBldId(servcId);
				rxBldConf.setBldNm(servcId);
				rxBldConf.setRepoAddr(vo.getGitRepoAddr());
				rxBldConf.setLastBldVer(lastBldVer);
				rxBldConf.setCreImgId(servcId);
				rxBldConf.setCreImgNm(servcId+":latest");
				rxBldConf.setBasImgId(vo.getImgId());
				cRxBldConfDao.insertRxBldConf(rxBldConf); //빌드설정정보 insert

				//빌드이력정보 insert
				RxBldHstry rxBldHstry = new RxBldHstry();
				BeanUtils.copyProperties(rxBldHstry, rxBldConf);
				rxBldHstry.setBldHstryId(servcId+'-'+lastBldVer);
				rxBldHstry.setBldStatCd("01");
				rxBldHstry.setBldVer(lastBldVer);
				rxBldHstry.setBasImgServcAreaId(vo.getBaseImgServcAreaId());
				cRxBldHstryDao.insertRxBldHstry(rxBldHstry);

				//서비스 라우트정보 insert
				RxServcRoute rxServcRoute = new RxServcRoute();
				BeanUtils.copyProperties(rxServcRoute, vo);
				rxServcRoute.setRouteId(routeId);
				rxServcRoute.setRouteNm(routeId);
				rxServcRoute.setRouteUid(routeUid);
				rxServcRoute.setServcSeq(rxServc.getServcSeq());
				cRxServcRouteDao.insertRxServcRoute(rxServcRoute);

				//서비스 포트정보 insert
				RxServcPort rxServcPort = new RxServcPort();
				BeanUtils.copyProperties(rxServcPort, vo);
				rxServcPort.setServcSeq(rxServc.getServcSeq());

				for(BaseImgVo getVo : baseImgPortList) {
					rxServcPort.setTargtPort(Integer.toString(getVo.getPort()));
					rxServcPort.setPort(Integer.toString(getVo.getPort()));
					rxServcPort.setPrtcl(getVo.getPrtcl());
					rxServcPort.setPortNm(getVo.getPortInfo());
					rxServcPort.setPortId(getVo.getPortInfo());
					cRxServcPortDao.insertRxServcPort(rxServcPort);
				}

				//배포설정정보 insert
				RxDistrbConf rxDistrbConf = new RxDistrbConf();
				rxDistrbConf.setServcSeq(rxServc.getServcSeq());
				rxDistrbConf.setCreUserId(vo.getCreUserId());
				rxDistrbConf.setDistrbConfId(servcId);
				rxDistrbConf.setDistrbConfNm(servcId);
				rxDistrbConf.setCntanrId(servcId);
				rxDistrbConf.setImgId(servcId);
				rxDistrbConf.setRplcaQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_DEFAULT_REPLICAS);
				cRxDistrbConfDao.insertRxDistrbConf(rxDistrbConf);

				if(!ObjectUtils.isEmpty(vo.getDistrbEnvConfList())) {
					//환경변수정보 insert
					RxDistrbEnvConf rxDistrbEnvConf = new RxDistrbEnvConf();
					rxDistrbEnvConf.setServcSeq(rxServc.getServcSeq());
					rxDistrbEnvConf.setDistrbConfId(servcId);

					//사용자 입력 환경변수 저장
					for(DistrbEnvConfVo getVo : vo.getDistrbEnvConfList()) {
						rxDistrbEnvConf.setEnvVarNm(getVo.getEnvVarNm());
						rxDistrbEnvConf.setEnvVarVl(getVo.getEnvVarVl());
						rxDistrbEnvConf.setVarVlTyCd("01");
						cRxDistrbEnvConfDao.insertRxDistrbEnvConf(rxDistrbEnvConf);
					}

					//세션 클러스터링 관련 환경변수 저장
					rxDistrbEnvConf.setEnvVarNm(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_OPENSHIFT_KUBE_PING_LABELS);
					rxDistrbEnvConf.setEnvVarVl("application="+servcId);
					rxDistrbEnvConf.setVarVlTyCd("01");
					cRxDistrbEnvConfDao.insertRxDistrbEnvConf(rxDistrbEnvConf);

					rxDistrbEnvConf.setEnvVarNm(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_OPENSHIFT_KUBE_PING_NAMESPACE);
					rxDistrbEnvConf.setEnvVarVl(vo.getServcAreaId());
					rxDistrbEnvConf.setVarVlTyCd("01");
					cRxDistrbEnvConfDao.insertRxDistrbEnvConf(rxDistrbEnvConf);
				}

				dbSuccFlag = true;
				resultmessage =  OprConstant.RX_CRE_SUCC_MSG;

			}else {
				resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
			}

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}finally {
			if(!succFlag && !dbSuccFlag) {
				if(servcFlag) { // 서비스가 생성된 상태라면 삭제처리
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.servicesDelete(headers, servicesIfVo); //서비스 삭제

					if(routeFlag) { // 라우트가 생성된 상태라면 삭제처리
						headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
						servcAPIService.routesDelete(headers, vo.getServcAreaId(), routeId);

						if(imagestreamFlag) { // 이미지스트림이 생성된 상태라면 삭제처리
							headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
							servcAPIService.imagestreamsDelete(headers, vo.getServcAreaId(), servcId);

							if(buildConfig) { // 빌드설정이 생성된 상태라면 삭제처리
								headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
								servcAPIService.buildconfigsDelete(headers, vo.getServcAreaId(), servcId);

								if(instantiateFlag) { // 빌드이력이 생성된 상태라면 삭제처리
									headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
									servcAPIService.buildsDelete(headers, vo.getServcAreaId(), servcId+'-'+lastBldVer);

									if(deploymentconfigFlag) { // 빌드이력이 생성된 상태라면 삭제처리
										headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
										servcAPIService.deploymentConfigsDelete(headers, vo.getServcAreaId(), servcId);
									}
								}
							}
						}
					}
				}
			}
		}

		return resultmessage;
	}



	/**
	 * 서비스 상세조회
	 * @param servcSeq
	 * @return ServcAreaVo
	 */
	@Override
	public ServcVo selectServc(int servcSeq) {
		ServcVo servcVo = new ServcVo();
		servcVo.setServcSeq(servcSeq);
		return servcDao.selectServc(servcVo);
	}


	/**
	 * 서비스 수정
	 * @param vo
	 * @param exeUserId
	 */
	public String updateServc(ServcVo vo) throws Exception{

		AtmSclResultIfVo atmSclResultIfVo = null;
		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;

		//해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(vo.getRegionId());
		headers.setZoneId(vo.getZoneId());
		headers.setNetworkId(vo.getNetClCd());
		headers.setManagerId(vo.getRsrcPoolId());

		//서비스 생성에 필요한 데이터 셋팅
		ServicesIfVo servicesIfVo = new ServicesIfVo();
		servicesIfVo.setName(vo.getServcId());
		servicesIfVo.setDisplayName(vo.getServcNm());
		servicesIfVo.setDescription(vo.getRmk());
		servicesIfVo.setNamespaceId(vo.getServcAreaId());

		//서비스 수정 API호출
		atmSclResultIfVo = servcAPIService.servicesPut(headers, servicesIfVo);

		if("Y".equals(atmSclResultIfVo.getSuccYn())) {

			//서비스정보 update
			RxServc rxServc = new RxServc();
			rxServc.setServcSeq(vo.getServcSeq());
			rxServc.setServcNm(vo.getServcNm());
			rxServc.setRmk(vo.getRmk());
			rxServc.setUpdtUserId(vo.getUpdtUserId());
			cRxServcDao.updateRxServc(rxServc);

			resultmessage =  OprConstant.RX_SAVE_SUCC_MSG;
		}

		return resultmessage;
	}


	/**
	 * 대상포트 조회
	 * @param rsrcPoolId
	 * @param imgId
	 * @return List
	 */
	public List<BaseImgVo> selectTargetPortList(String rsrcPoolId, String imgId, Integer servcAreaSeq) {

		BaseImgVo baseImgVo = new BaseImgVo();
		baseImgVo.setRsrcPoolId(rsrcPoolId);
		baseImgVo.setImgId(imgId);
		baseImgVo.setServcAreaSeq(servcAreaSeq);
		List<BaseImgVo> baseImgPortList = baseImgDao.selectBaseImgPortList(baseImgVo);
		return baseImgPortList;
	}


	/**
	 * 빌드 수행
	 * @param vo
	 * @return List
	 */
	public String insertBldHstry(ServcVo vo) throws Exception{

		AtmSclResultIfVo atmSclResultIfVo = null;
		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		String buildNumber = null;
		String bldHstryId = commonService.selectSeqNum("RX_BLD_HSTRY", vo.getServcAreaId());

		//해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(vo.getRegionId());
		headers.setZoneId(vo.getZoneId());
		headers.setNetworkId(vo.getNetClCd());
		headers.setManagerId(vo.getRsrcPoolId());


		BuildConfigsIfVo buildConfigsIfVo = new BuildConfigsIfVo();

		buildConfigsIfVo.setNamespaceId(vo.getServcAreaId());
		buildConfigsIfVo.setName(vo.getBldId());
		buildConfigsIfVo.setBldHstryId(bldHstryId);

		//빌드 API호출
		atmSclResultIfVo = servcAPIService.instantiatePost(headers, buildConfigsIfVo);

		if("Y".equals(atmSclResultIfVo.getSuccYn())) {

			buildNumber = atmSclResultIfVo.getBuildNumber();

			//빌드설정정보 update
			RxBldConf rxBldConf	 = new RxBldConf();
			rxBldConf.setServcSeq(vo.getServcSeq());
			rxBldConf.setBldId(vo.getBldId());
			rxBldConf.setLastBldVer(buildNumber);
			rxBldConf.setUpdtUserId(vo.getUpdtUserId());
			cRxBldConfDao.updateRxBldConfBldVer(rxBldConf); //빌드설정정보 update

			//빌드이력정보 insert
			BldVo bldVo = servcDao.selectBldConf(vo.getServcSeq());
			RxBldHstry rxBldHstry = new RxBldHstry();
			BeanUtils.copyProperties(rxBldHstry, bldVo);
			rxBldHstry.setBldHstryId(vo.getBldId()+'-'+buildNumber);
			rxBldHstry.setBldStatCd("01");
			rxBldHstry.setBldVer(buildNumber);
			rxBldHstry.setCreUserId(vo.getUpdtUserId());
			cRxBldHstryDao.insertRxBldHstry(rxBldHstry);


			resultmessage =  OprConstant.RX_EXEC_SUCC_MSG;
		}

		return resultmessage;

	}



	/**
	 * 배포 실행
	 * @param vo
	 * @return List
	 */
	public String updateDeploymentConfig(ServcVo vo) throws Exception{

		AtmSclResultIfVo atmSclResultIfVo = null;
		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;

		//해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(vo.getRegionId());
		headers.setZoneId(vo.getZoneId());
		headers.setNetworkId(vo.getNetClCd());
		headers.setManagerId(vo.getRsrcPoolId());

		DeploymentConfigsIfVo deploymentconfigsIfVo = new DeploymentConfigsIfVo();
		deploymentconfigsIfVo.setName(vo.getServcId());
		deploymentconfigsIfVo.setNamespaceId(vo.getServcAreaId());
		deploymentconfigsIfVo.setDefaultYn("Y");

		atmSclResultIfVo = servcAPIService.deploymentConfigsPut(headers, deploymentconfigsIfVo);

		if("Y".equals(atmSclResultIfVo.getSuccYn())) {
			AtmsclDistrbVo atmsclDistrbVo = servcDao.selectDistrb(vo.getServcSeq());

			//배포설정정보 update
			RxDistrbConf rxDistrbConf = new RxDistrbConf();
			rxDistrbConf.setDistrbConfId(atmsclDistrbVo.getDistrbConfId());
			rxDistrbConf.setServcSeq(vo.getServcSeq());
			rxDistrbConf.setStatCd("01");
			rxDistrbConf.setLastDistrbVer(Integer.toString(atmSclResultIfVo.getLatestVersion()));
			cRxDistrbConfDao.updateRxDistrbConfVer(rxDistrbConf);


			RxDistrbHstry rxDistrbHstry = new RxDistrbHstry();
			BeanUtils.copyProperties(rxDistrbHstry, atmsclDistrbVo);
			rxDistrbHstry.setDistrbStatCd("01");
			rxDistrbHstry.setDistrbVer(Integer.toString(atmSclResultIfVo.getLatestVersion()));
			rxDistrbHstry.setDistrbId(atmsclDistrbVo.getDistrbConfId()+"-"+Integer.toString(atmSclResultIfVo.getLatestVersion()));
			cRxDistrbHstryDao.insertRxDistrbHstry(rxDistrbHstry);

			resultmessage =  OprConstant.RX_EXEC_SUCC_MSG;
		}

		return resultmessage;
	}



	/**
	 * 라우트 생성
	 * @param vo
	 * @return String
	 */
	@Override
	public String insertServcRoute(ServcRouteVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		AtmSclResultIfVo atmSclResultIfVo = null;

		try{

			//라우트 ID를 셋팅한다.
			String routeId = commonService.selectSeqNum("RX_SERVC_ROUTE", vo.getServcId()+"-");

			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			//라우트 생성에 필요한 데이터 셋팅
			RoutesIfVo routesIfVo = new RoutesIfVo();
			routesIfVo.setName(routeId);
			routesIfVo.setHost(vo.getHstNm());
			routesIfVo.setNamespaceId(vo.getServcAreaId());
			routesIfVo.setServiceName(vo.getServcId());
			routesIfVo.setTargetPort(vo.getTargtPort());
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

			//라우트 생성  API호출
			atmSclResultIfVo = servcAPIService.routesPost(headers, routesIfVo);

			//정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				//서비스 라우트정보 insert
				RxServcRoute rxServcRoute = new RxServcRoute();
				BeanUtils.copyProperties(rxServcRoute, vo);
				rxServcRoute.setRouteId(routeId);
				rxServcRoute.setRouteNm(routeId);
				rxServcRoute.setRouteUid(atmSclResultIfVo.getUid());
				rxServcRoute.setServcSeq(vo.getServcSeq());
				cRxServcRouteDao.insertRxServcRoute(rxServcRoute);

				resultmessage =  OprConstant.RX_CRE_SUCC_MSG;
			}else {
				resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
			}

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultmessage;
	}


	/**
	 * 서비스 삭제
	 * @param vo
	 * @return String
	 */
	@Override
	public String deleteServc(ServcVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		AtmSclResultIfVo atmSclResultIfVo = null;

		try{

			String notFoundFlag = "N";

			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			ServicesIfVo servicesIfVo = new ServicesIfVo();
			servicesIfVo.setName(vo.getServcId());
			servicesIfVo.setNamespaceId(vo.getServcAreaId());

			//서비스 삭제 API호출
			atmSclResultIfVo = servcAPIService.servicesDelete(headers, servicesIfVo);


			//라우터 정보 삭제
			List<ServcRouteVo> servcRouteList =servcDao.selectServcRouteList(vo.getServcSeq());
			if(servcRouteList != null) {
				for (ServcRouteVo servcRouteVo : servcRouteList) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.routesDelete(headers, vo.getServcAreaId(), servcRouteVo.getRouteId());
				}
			}

			//이미지 삭제
			List<BaseImgVo> imgList =servcDao.selectImgList(vo.getServcSeq());
			if(imgList != null) {
				for (BaseImgVo baseImgVo : imgList) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.imagestreamsDelete(headers, vo.getServcAreaId(), baseImgVo.getImgId());
				}
			}

			//빌드이력 삭제
			List<BldVo> bldList =servcDao.selectBldList(vo.getServcSeq());
			if(bldList != null) {
				for (BldVo bldVo : bldList) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.buildsDelete(headers, vo.getServcAreaId(), bldVo.getBldHstryId());
				}
			}

			//빌드설정 삭제
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			servcAPIService.buildconfigsDelete(headers, vo.getServcAreaId(), vo.getBldId());

			//배포설정 삭제
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			servcAPIService.deploymentConfigsDelete(headers, vo.getServcAreaId(), vo.getDistrbConfId());

			//Pod정보 삭제
			ServcPodVo pvo = new ServcPodVo();
			pvo.setServcSeq(vo.getServcSeq());
			List<ServcPodVo> servcPodList = servcDao.selectServcPodList(pvo);
			if(servcPodList != null) {
				for (ServcPodVo servcPodVo : servcPodList) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.podsDelete(headers, vo.getServcAreaId(), servcPodVo.getPodId());
				}
			}

			//배포이력 삭제
			List<AtmsclDistrbVo> atmsclDistrList =servcDao.selectDistrbList(vo.getServcSeq());
			if(atmsclDistrList != null) {
				for (AtmsclDistrbVo atmsclDistrbVo : atmsclDistrList) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAPIService.replicationcontrollersDelete(headers, vo.getServcAreaId(), atmsclDistrbVo.getDistrbId());
				}
			}

			// 삭제 시점에 Pod가 확장될수 있기 때문에 다시 한번 API를 호출하여 삭제처리
			DeploymentConfigsIfVo podDeploymentconfigsIfVo = new DeploymentConfigsIfVo();
			podDeploymentconfigsIfVo.setName(vo.getServcId());
			podDeploymentconfigsIfVo.setNamespaceId(vo.getServcAreaId());
			List<PodIfVo> podIfVoList = servcAPIService.podsGet(headers, podDeploymentconfigsIfVo);
			for (PodIfVo podDetail : podIfVoList) {
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
				if("01".equals(podDetail.getPodType())) {
					servcAPIService.podsDelete(headers, vo.getServcAreaId(), podDetail.getName());
				}
			}


			if(!"Y".equals(atmSclResultIfVo.getSuccYn())) {
				if(atmSclResultIfVo.getMessage().indexOf("not found")>=0) {
					notFoundFlag = "Y";
				}
			}


			//정상적으로 삭제되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn()) || "Y".equals(notFoundFlag)) {
				//서비스 삭제
				RxServc rxServc = new RxServc();
				rxServc.setServcSeq(vo.getServcSeq());
				rxServc.setDelUserId(vo.getDelUserId());
				rxServc.setDelYn("Y");
				cRxServcDao.deleteRxServc(rxServc);

				//라우트 정보 삭제
				RxServcRoute rxServcRoute = new RxServcRoute();
				rxServcRoute.setServcSeq(vo.getServcSeq());
				cRxServcRouteDao.deleteRxServcRoute(rxServcRoute);

				//이미지정보  삭제
				RxImg rxImg = new RxImg();
				rxImg.setImgId(vo.getImgId());
				rxImg.setRsrcPoolId(vo.getRsrcPoolId());
				rxImg.setServcAreaSeq(vo.getServcAreaSeq());
				cRxImgDao.deleteRxImg(rxImg);

				//빌드이력정보 삭제
				RxBldHstry rxBldHstry = new RxBldHstry();
				rxBldHstry.setServcSeq(vo.getServcSeq());
				cRxBldHstryDao.deleteRxBldHstry(rxBldHstry);

				//빌드설정정보 삭제
				RxBldConf rxBldConf	 = new RxBldConf();
				rxBldConf.setServcSeq(vo.getServcSeq());
				cRxBldConfDao.deleteRxBldConf(rxBldConf);

				//배포이력정보 삭제
				RxDistrbHstry rxDistrbHstry = new RxDistrbHstry();
				rxDistrbHstry.setServcSeq(vo.getServcSeq());
				cRxDistrbHstryDao.deleteRxDistrbHstry(rxDistrbHstry);

				//배포설정 정보 삭제
				RxDistrbConf rxDistrbConf = new RxDistrbConf();
				rxDistrbConf.setServcSeq(vo.getServcSeq());
				cRxDistrbConfDao.deleteRxDistrbConf(rxDistrbConf);

				//환경변수정보 삭제
				RxDistrbEnvConf rxDistrbEnvConf = new RxDistrbEnvConf();
				rxDistrbEnvConf.setServcSeq(rxServc.getServcSeq());
				cRxDistrbEnvConfDao.deleteRxDistrbEnvConf(rxDistrbEnvConf);

				//서비스 포트정보 삭제
				RxServcPort rxServcPort = new RxServcPort();
				rxServcPort.setServcSeq(vo.getServcSeq());
				cRxServcPortDao.deleteRxServcPort(rxServcPort);

				//서비스 Pod정보 삭제
				RxServcPod rxServcPod = new RxServcPod();
				rxServcPod.setServcSeq(vo.getServcSeq());
				cRxServcPodDao.deleteRxServcPod(rxServcPod);

				resultmessage =  OprConstant.RX_DEL_SUCC_MSG;
			}else {
				resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
			}

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultmessage;
	}


	/**
	 * 상태정보 업데이트
	 * @param vo
	 * @return String
	 */
	@Override
	public String updateServcStat(ServcVo vo) throws Exception{

		String resultStat =  "";

		try{

			String statCd = ""; //서비스상태코드
			String bldStatCd = ""; //빌드상태코드
			String deployStatCd = ""; //배포상태코드

			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			//빌드 상태정보
			BuildConfigsIfVo buildConfigsIfVo = new BuildConfigsIfVo();
			buildConfigsIfVo.setNamespaceId(vo.getServcAreaId());
			buildConfigsIfVo.setName(vo.getBldId()+"-"+vo.getLastBldVer());
			AtmSclResultIfVo atmSclResultIfVo = servcAPIService.buildsGet(headers, buildConfigsIfVo);
			bldStatCd = atmSclResultIfVo.getBuildPhase();

			//빌드이력 상태정보 update
			RxBldHstry rxBldHstry = new RxBldHstry();
			rxBldHstry.setBldHstryId(vo.getBldId()+'-'+atmSclResultIfVo.getBuildNumber());
			rxBldHstry.setBldStatCd(bldStatCd);
			rxBldHstry.setServcSeq(vo.getServcSeq());
			rxBldHstry.setUpdtUserId(vo.getUpdtUserId());
			cRxBldHstryDao.updateRxBldHstryStat(rxBldHstry);

			//서비스 상태가 빌드 진행중 또는 오류일 경우
			if("01".equals(vo.getStatCd()) || "03".equals(vo.getStatCd())) {

				if("02".equals(bldStatCd)) { //빌드 상태가 완료일 경우 서비스 상태도 완료처리
					statCd = "02";
				}else if("03".equals(bldStatCd) || "06".equals(bldStatCd) || "07".equals(bldStatCd)) {  //빌드 상태가 실패, 팬딩, 에러일 경우 서비스 상태는 오류처리
					statCd = "03";
				}

				//서비스 상태정보 update
				if(!"".equals(statCd)) {
					RxServc rxServc = new RxServc();
					rxServc.setServcSeq(vo.getServcSeq());
					rxServc.setStatCd(statCd);
					rxServc.setUpdtUserId(vo.getUpdtUserId());
					cRxServcDao.updateRxServcStat(rxServc);

					resultStat = statCd;
				}
			}


			/*  ###### 상태정보 업데이트를 배치로 분리해야될것으로 보임, 배치 처리 여부에 따라서 아래의 로직  주석 처리 시작  ####### */

			DeploymentConfigsIfVo deploymentconfigsIfVo = new DeploymentConfigsIfVo();
			deploymentconfigsIfVo.setName(vo.getDistrbConfId()+"-"+vo.getLastDistrbVer());
			deploymentconfigsIfVo.setNamespaceId(vo.getServcAreaId());
			atmSclResultIfVo = servcAPIService.replicationcontrollersStatGet(headers, deploymentconfigsIfVo);
			deployStatCd = atmSclResultIfVo.getDeploymentPhase();

			//배포설정정보 update
			RxDistrbConf rxDistrbConf = new RxDistrbConf();
			rxDistrbConf.setDistrbConfId(vo.getDistrbConfId());
			rxDistrbConf.setServcSeq(vo.getServcSeq());
			rxDistrbConf.setStatCd(deployStatCd);
			rxDistrbConf.setUpdtUserId(vo.getUpdtUserId());
			cRxDistrbConfDao.updateRxDistrbConfStat(rxDistrbConf);

			//배포이력상태정보 update
			RxDistrbHstry rxDistrbHstry = new RxDistrbHstry();
			rxDistrbHstry.setDistrbId(vo.getDistrbConfId()+"-"+vo.getLastDistrbVer());
			rxDistrbHstry.setServcSeq(vo.getServcSeq());
			rxDistrbHstry.setDistrbStatCd(deployStatCd);
			cRxDistrbHstryDao.updateRxDistrbHstryStat(rxDistrbHstry);

			//API를 호출하여 Pod 정보 조회
			DeploymentConfigsIfVo podDeploymentconfigsIfVo = new DeploymentConfigsIfVo();
			podDeploymentconfigsIfVo.setName(vo.getServcId());
			podDeploymentconfigsIfVo.setNamespaceId(vo.getServcAreaId());
			List<PodIfVo> podIfVoList = servcAPIService.podsGet(headers, podDeploymentconfigsIfVo);

			//DB에 있는 Pod 정보 조회
			ServcPodVo pvo = new ServcPodVo();
			pvo.setServcSeq(vo.getServcSeq());
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
				rxServcPod.setServcSeq(vo.getServcSeq());
				rxServcPod.setPodId(podId);
				rxServcPod.setPodNm(podId);
				rxServcPod.setPodIpAddr(podDetail.getHostIP());
				rxServcPod.setPodUid(podDetail.getUid());
				rxServcPod.setImgId(podDetail.getImage());
				rxServcPod.setRsrcPoolId(vo.getRsrcPoolId());
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
					rxServcPod.setServcSeq(vo.getServcSeq());
					rxServcPod.setPodId(servcPodVo.getPodId());
					cRxServcPodDao.deleteRxServcPod((rxServcPod)); //해당 Pod삭제
				}
			}

			/*  ###### 상태정보 업데이트를 배치로 분리해야될것으로 보임, 배치 처리 여부에 따라서 아래의 로직  주석 처리  끝  ####### */

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultStat;

	}


	/**
	 * Pod 목록 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<ServcPodVo> selectServcPodList(Integer servcSeq) {
		ServcPodVo servcPodVo = new ServcPodVo();
		servcPodVo.setServcSeq(servcSeq);
		servcPodVo.setStatCd("01");

		List<ServcPodVo> list = servcDao.selectServcPodList(servcPodVo);
		return list;
	}


	/**
	 * 라우트 목록 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<ServcRouteVo> selectServcRouteList(Integer servcSeq) {
		List<ServcRouteVo> list =servcDao.selectServcRouteList(servcSeq);
		return list;
	}


	/**
	 * 포트 목록 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<ServcPortVo> selectServcPortList(Integer servcSeq) {
		List<ServcPortVo> list =servcDao.selectServcPortList(servcSeq);
		return list;
	}


	/**
	 * 제한 목록 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public AtmsclDistrbVo selectLimit(Integer servcSeq) {

		//ServcAreaVo servcAreaVo =servcDao.selectLimit(servcAreaSeq);
		AtmsclDistrbVo atmsclDistrbVo = servcDao.selectDistrb(servcSeq);

		return atmsclDistrbVo;
	}


	/**
	 * 빌드이력 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<BldVo> selectBldList(Integer servcSeq) {
		List<BldVo> list =servcDao.selectBldList(servcSeq);
		return list;
	}


	/**
	 * 배포이력 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<AtmsclDistrbVo> selectDistrbList(Integer servcSeq) {
		List<AtmsclDistrbVo> list =servcDao.selectDistrbList(servcSeq);
		return list;
	}


	/**
	 * 이미지 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<BaseImgVo> selectImgList(Integer servcSeq) {
		List<BaseImgVo> list =servcDao.selectImgList(servcSeq);
		return list;
	}


	/**
	 * 오토스케일 정보 조회
	 * @param servcSeq
	 * @return List
	 */
	@Override
	public List<ServcSclngVo> selecServcSclngList(Integer servcSeq) {
		List<ServcSclngVo> list =servcDao.selecServcSclngList(servcSeq);
		return list;
	}


	/**
	 * 환경변수 정규식 체크
	 * @param vo
	 * @return List
	 */
	private boolean checkDistrbEnvConf(List<DistrbEnvConfVo> distrbEnvConfList) {
		boolean rtnFlag = true;

		// 환경변수명 정규식 체크
		if(distrbEnvConfList!=null) {
			if(distrbEnvConfList.size()>0) {
				for(DistrbEnvConfVo getVo : distrbEnvConfList) {
					if(!Pattern.matches("[a-zA-Z_][a-zA-Z0-9_]*", getVo.getEnvVarNm())) {  //환경변수 명 정규식 체크
						rtnFlag = false;
						break;
					}
				}
			}
		}

		return rtnFlag;
	}


	/**
	 * 라우트 삭제
	 * @param vo
	 * @return String
	 */
	@Override
	public String deleteServcRoute(ServcRouteVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;

		try{

			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

			//라우트 삭제 API 호출
			servcAPIService.routesDelete(headers, vo.getServcAreaId(), vo.getRouteId());

			//라우트 정보 삭제
			RxServcRoute rxServcRoute = new RxServcRoute();
			rxServcRoute.setServcSeq(vo.getServcSeq());
			rxServcRoute.setRouteId(vo.getRouteId());
			cRxServcRouteDao.deleteRxServcRoute(rxServcRoute);

			resultmessage =  OprConstant.RX_DEL_SUCC_MSG;

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultmessage;
	}

}
