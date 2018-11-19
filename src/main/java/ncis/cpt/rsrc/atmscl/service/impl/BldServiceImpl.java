package ncis.cpt.rsrc.atmscl.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxBldConfDao;
import ncis.cmn.dao.CRxBldHstryDao;
import ncis.cmn.entity.RxBldConf;
import ncis.cmn.entity.RxBldHstry;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.rsrc.atmscl.dao.BldDao;
import ncis.cpt.rsrc.atmscl.service.BldService;
import ncis.cpt.rsrc.atmscl.vo.BldSearchVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.intfc.atmscl.service.BldAPIService;
import ncis.intfc.atmscl.service.ServcAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.BuildConfigsIfVo;

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

@Service("bldService")
public class BldServiceImpl implements BldService {

	@Resource(name="bldDao")
	private BldDao bldDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="cRxBldConfDao")
	private CRxBldConfDao cRxBldConfDao;

	@Resource(name="cRxBldHstryDao")
	private CRxBldHstryDao cRxBldHstryDao;

	@Resource(name="bldService")
	BldService bldService;

	@Resource(name="bldApiService")
	BldAPIService bldApiService;

	@Resource(name="servcAPIService")
	ServcAPIService servcAPIService;

	private final Logger logger = LoggerFactory.getLogger(BldServiceImpl.class);

	@Override
	public List<BldVo> selectBldList(BldSearchVo bldSearchVo) {

		List<BldVo> list = null;
		int totalCount = bldDao.selectBldTotCnt(bldSearchVo);

		if(totalCount > 0){
			bldSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = bldDao.selectBldList(bldSearchVo);
		}

		return list;
	}


	@Override
	public List<BldVo> selectDetailBld(Integer servcSeq, String bldId, String userId) throws Exception {

		BldVo bldVo = new BldVo();
		bldVo.setBldId(bldId);
		bldVo.setServcSeq(servcSeq);

		List<BldVo> selectDetailBld = bldDao.selectDetailBld(bldVo);

		BldVo lastBldVo = new BldVo();
		if(!ObjectUtils.isEmpty(selectDetailBld)){
			BeanUtils.copyProperties(lastBldVo,selectDetailBld.get(0));
			//header 셋팅
			RestHeaders headers = new RestHeaders();

			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(lastBldVo.getRegionId());
			headers.setZoneId(lastBldVo.getZoneId());
			headers.setNetworkId(lastBldVo.getNetClCd());
			headers.setManagerId(lastBldVo.getRsrcPoolId());

			AtmSclResultIfVo syncResult = null;
			try {
				//최신 버전 조회
				syncResult = bldApiService.updateBldSync(headers,lastBldVo);
			} catch(HttpClientErrorException e) {
				logger.error("빌드 최신버전 조회 중 오류", e);
			}  catch(HttpServerErrorException e) {
				logger.error("빌드 최신버전 조회 중 오류", e);
			}
			try{
				if(syncResult != null && "Y".equals(syncResult.getSuccYn())){
					String buildId = new String();
					Integer newLastVer = syncResult.getLatestVersion();
					Integer oldLastVer = 0;
					if(newLastVer != 1){
						if(ObjectUtils.isEmpty(lastBldVo.getLastBldVer())){
							lastBldVo.setLastBldVer("0");
						}
						oldLastVer = Integer.valueOf(lastBldVo.getLastBldVer());
					}

					//insert & update 값 셋팅해야함
					//빌드Conf
					RxBldConf rxBldConf = new RxBldConf();
					rxBldConf.setUpdtUserId(userId);
					rxBldConf.setServcSeq(lastBldVo.getServcSeq());
					rxBldConf.setBldId(lastBldVo.getBldId());

					//빌드 이력
					RxBldHstry rxBldHstry = new RxBldHstry();
					rxBldHstry.setUpdtUserId(userId);
					rxBldHstry.setCreUserId(userId);
					rxBldHstry.setBldId(lastBldVo.getBldId());
					rxBldHstry.setBasImgServcAreaId(lastBldVo.getBasImgServcAreaId());
					rxBldHstry.setBasImgId(lastBldVo.getBasImgId());
					rxBldHstry.setServcSeq(lastBldVo.getServcSeq());

					for(int i = (oldLastVer+1); i < newLastVer+1; i++){
						buildId = lastBldVo.getBldId()+"-"+i;
						//빌드 이력 값 셋팅
						rxBldHstry.setBldHstryId(buildId);
						rxBldHstry.setBldVer(String.valueOf(i));

						lastBldVo.setLastBldVer(String.valueOf(i));

						rxBldHstry.setGitBestPath(lastBldVo.getGitBestPath());


						AtmSclResultIfVo bldHstrySync = bldApiService.bldHstrySync(headers,lastBldVo);

						rxBldHstry.setRepoTyCd(bldHstrySync.getRepoTyCd());
						rxBldHstry.setRepoAddr(bldHstrySync.getRepoAddr());
						rxBldHstry.setGitBrnchNm(bldHstrySync.getGitBrnchNm());
						rxBldHstry.setCreImgNm(bldHstrySync.getCreImgNm());
						rxBldHstry.setCreImgId(bldHstrySync.getCreImgId());
						rxBldHstry.setImgTag(bldHstrySync.getImgTag());
						rxBldHstry.setBldDttmSync(bldHstrySync.getLastBldDttm());
						rxBldHstry.setBldStatCd(bldHstrySync.getBuildPhase());

						if(i == newLastVer){
							//buildConf Update
							rxBldConf.setBldDttmSync(bldHstrySync.getLastBldDttm());
							rxBldConf.setLastBldVer(String.valueOf(newLastVer));
							cRxBldConfDao.updateBldConfSync(rxBldConf);
						}

						//buildHstry Insert
						cRxBldHstryDao.insertRxBldSync(rxBldHstry);
					}
					selectDetailBld = bldDao.selectDetailBld(bldVo);
				}

			} catch(IllegalAccessException | InvocationTargetException | BadSqlGrammarException | PSQLException e) {
				logger.error(e.toString(),e);
				throw new CommonException("빌드 동기화 중 오류가 발생했습니다."+e.getMessage());
			}
		}
		return selectDetailBld;
	}


	@Override
	public void updateBldConf(BldVo bldVo) {
		RxBldConf bldConf = new RxBldConf();
		bldConf.setScrtkyId(bldVo.getScrtkyId());
		bldConf.setGitBrnchNm(bldVo.getGitBrnchNm());
		bldConf.setGitBestPath(bldVo.getGitBestPath());
		bldConf.setRepoAddr(bldVo.getRepoAddr());
		bldConf.setBasImgId(bldVo.getBasImgId());
		bldConf.setUpdtUserId(bldVo.getUpdtUserId());
		bldConf.setLastBldVer(bldVo.getLastBldVer());
		bldConf.setServcSeq(bldVo.getServcSeq());
		bldConf.setBldId(bldVo.getBldId());

		cRxBldConfDao.updateBldConf(bldConf);
	}

	@Override
	public void insertBldHstry(BldVo bldVo) {
		RxBldHstry bldHstry = new RxBldHstry();
		String bldHstryId = bldVo.getBldId()+"-"+bldVo.getLastBldVer();
		bldHstry.setServcSeq(bldVo.getServcSeq());
		bldHstry.setBldHstryId(bldHstryId);
		bldHstry.setBldId(bldVo.getBldId());
		bldHstry.setBldVer(bldVo.getLastBldVer());
		bldHstry.setBasImgServcAreaId(bldVo.getBasImgServcAreaId());
		bldHstry.setBasImgId(bldVo.getBasImgId());
		bldHstry.setRepoTyCd(bldVo.getRepoTyCd());
		bldHstry.setRepoAddr(bldVo.getRepoAddr());
		bldHstry.setGitBrnchNm(bldVo.getGitBrnchNm());
		bldHstry.setGitBestPath(bldVo.getGitBestPath());
		bldHstry.setScrtkyId(bldVo.getScrtkyId());
		bldHstry.setCreImgId(bldVo.getCreImgId());
		bldHstry.setCreImgNm(bldVo.getCreImgNm());
		bldHstry.setImgTag(bldVo.getImgTag());
		bldHstry.setBldStatCd(bldVo.getBldStatCd());
		bldHstry.setCreUserId(bldVo.getCreUserId());
		cRxBldConfDao.insertBldHstry(bldHstry);

	}

	@Override
	public List<BldVo> selectScrtky(Integer servcAreaSeq) {
		return bldDao.selectScrtky(servcAreaSeq);
	}


	@Override
	public ProcResultVo bldRun(BldVo bldVo) throws Exception {
		BuildConfigsIfVo buildConfigsIfVo = new BuildConfigsIfVo();

		// 해더정보 셋팅
		RestHeaders headers = new RestHeaders();
		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(bldVo.getRegionId());
		headers.setZoneId(bldVo.getZoneId());
		headers.setNetworkId(bldVo.getNetClCd());
		headers.setManagerId(bldVo.getRsrcPoolId());


//		//설정 정보 Check
//		if(bldVo.getRepoAddr().equals(bldVo.getOriginRepoAddr()) && bldVo.getScrtkyId().equals(bldVo.getOriginScrtkyId())
//				&& bldVo.getGitBrnchNm().equals(bldVo.getOriginGitBrnchNm()) && bldVo.getGitBestPath().equals(bldVo.getOriginGitBestPath())
//				&& bldVo.getBasImgId().equals(bldVo.getOriginBasImgId())){

			buildConfigsIfVo.setNamespaceId(bldVo.getServcAreaId());
			buildConfigsIfVo.setName(bldVo.getBldId());

			ProcResultVo insertResult = new ProcResultVo();
				//빌드 API호출
				AtmSclResultIfVo atmSclResultIfVo = servcAPIService.instantiatePost(headers, buildConfigsIfVo);

				if("Y".equals(atmSclResultIfVo.getSuccYn())) {

					bldVo.setLastBldVer(atmSclResultIfVo.getBuildNumber());

						try {
							bldVo.setBldStatCd("01");
							bldService.updateBldConf(bldVo);
							bldService.insertBldHstry(bldVo);

							insertResult.setProcType("insert");
							insertResult.addMessage("정상적으로 빌드되었습니다.");
							insertResult.setSuccess(true);

						}catch(HttpServerErrorException e){
							logger.error(e.toString(),e);
							insertResult.setSuccess(false);
							insertResult.addMessage("빌드 시 오류가 발생했습니다., error="+ e.getMessage());
						}catch(HttpStatusCodeException e){
							logger.error(e.toString(),e);
							insertResult.setSuccess(false);
							insertResult.addMessage("빌드 시 오류가 발생했습니다., error="+ e.getMessage());
						}catch(IllegalArgumentException e){
							logger.error(e.toString(),e);
							insertResult.setSuccess(false);
							insertResult.addMessage("빌드 시 오류가 발생했습니다., error="+ e.getMessage());
						}
				}else{ // API 실패
					insertResult.setSuccess(false);
					insertResult.addMessage("빌드 시 오류가 발생했습니다., error="+ atmSclResultIfVo.getMessage());
				}

			return insertResult;
//		}else{

//		}
	}


	@Override
	public AtmSclResultIfVo selectBldStat(BldVo bldVo) throws Exception {

		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(bldVo.getRegionId());
		headers.setZoneId(bldVo.getZoneId());
		headers.setNetworkId(bldVo.getNetClCd());
		headers.setManagerId(bldVo.getRsrcPoolId());

		AtmSclResultIfVo atmSclResultIfVo = bldApiService.selectBldStat(headers,bldVo);
		if("Y".equals(atmSclResultIfVo.getSuccYn())){
			if(!"01".equals(atmSclResultIfVo.getStatCd())){
				RxBldHstry rxHstry = new RxBldHstry();

				rxHstry.setServcSeq(bldVo.getServcSeq());
				rxHstry.setBldHstryId(bldVo.getBldHstryId());
				rxHstry.setBldId(bldVo.getBldId());
				rxHstry.setBldStatCd(atmSclResultIfVo.getStatCd());
				rxHstry.setUpdtUserId(bldVo.getUpdtUserId());

				cRxBldHstryDao.updateRxBldHstryStat(rxHstry);

			}else{
				atmSclResultIfVo.setSuccYn("N");
			}
		}
		return atmSclResultIfVo;
	}


	@Override
	public ProcResultVo updateRxBldConf(BldVo bldVo) throws Exception {

		BuildConfigsIfVo buildConfigsIfVo = new BuildConfigsIfVo();
		RestHeaders headers = new RestHeaders();

		headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		headers.setAreaId(bldVo.getRegionId());
		headers.setZoneId(bldVo.getZoneId());
		headers.setNetworkId(bldVo.getNetClCd());
		headers.setManagerId(bldVo.getRsrcPoolId());


		ProcResultVo insertResult = new ProcResultVo();;
		buildConfigsIfVo.setContextDir(bldVo.getGitBestPath());
		buildConfigsIfVo.setName(bldVo.getBldId());
		buildConfigsIfVo.setNamespaceId(bldVo.getServcAreaId());

		buildConfigsIfVo.setRef(bldVo.getGitBrnchNm());
		buildConfigsIfVo.setSecret(bldVo.getScrtkyId());
		buildConfigsIfVo.setServiceName(bldVo.getServcId());
		buildConfigsIfVo.setSourceType(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BUILD_SOURCE_TYPE);
		buildConfigsIfVo.setUri(bldVo.getRepoAddr());

		buildConfigsIfVo.setBaseImgId(bldVo.getBasImgId());
		buildConfigsIfVo.setBaseImgVer(bldVo.getBasImgVer());
		AtmSclResultIfVo atmSclResultIfVo = servcAPIService.buildconfigsPut(headers, buildConfigsIfVo);

		if("Y".equals(atmSclResultIfVo.getSuccYn())){
			try{
				bldService.updateBldConf(bldVo);
				insertResult.setSuccess(true);
			}catch(HttpServerErrorException e){
				logger.error(e.toString(),e);
				insertResult.setSuccess(false);
			}catch(HttpStatusCodeException e){
				logger.error(e.toString(),e);
				insertResult.setSuccess(false);
			}catch(IllegalArgumentException e){
				logger.error(e.toString(),e);
				insertResult.setSuccess(false);
			}


		}else{
			insertResult.setSuccess(false);
		}

			return insertResult;

	}




}
