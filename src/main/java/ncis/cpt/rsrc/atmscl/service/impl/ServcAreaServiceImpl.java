package ncis.cpt.rsrc.atmscl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxPvDao;
import ncis.cmn.dao.CRxServcAreaDao;
import ncis.cmn.dao.CRxServcAreaLmttConfDao;
import ncis.cmn.entity.RxPv;
import ncis.cmn.entity.RxServcArea;
import ncis.cmn.entity.RxServcAreaLmttConf;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.rsrc.atmscl.dao.ServcAreaDao;
import ncis.cpt.rsrc.atmscl.service.ServcAreaService;
import ncis.cpt.rsrc.atmscl.vo.PvSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PvVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.intfc.atmscl.service.ServcAreaAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.LimitrangesIfVo;
import ncis.intfc.atmscl.vo.NamespaceIfVo;
import ncis.intfc.atmscl.vo.ProjectRequestsIfVo;
import ncis.intfc.atmscl.vo.ResourceQuotasIfVo;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service("servcAreaService")
public class ServcAreaServiceImpl implements ServcAreaService {

	@Resource(name="servcAreaDao")
	private ServcAreaDao servcAreaDao;

	@Resource(name="cRxServcAreaDao")
	private CRxServcAreaDao cRxServcAreaDao;

	@Resource(name="cRxServcAreaLmttConfDao")
	private CRxServcAreaLmttConfDao cRxServcAreaLmttConfDao;

	@Resource(name="cRxPvDao")
	private CRxPvDao cRxPvDao;


	@Resource(name="servcAreaAPIService")
	private ServcAreaAPIService servcAreaAPIService;

	@Resource(name="commonService")
	private CommonService commonService;

	private static final Logger logger = LoggerFactory.getLogger(ServcAreaServiceImpl.class);


	/**
	 * 서비스영역 목록 조회
	 * @param  searchVo
	 * @return List
	 */
	@Override
	public List<ServcAreaVo> selectServcAreaList(ServcAreaSearchVo searchVo) {

		List<ServcAreaVo> list = null;
		int totalCount = servcAreaDao.selectServcAreaTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한   count
			list = servcAreaDao.selectServcAreaList(searchVo);
		}

		return list;
	}


	/**
	 * 서비스영역 생성
	 * @param vo
	 * @return String
	 */
	@Override
	public String insertServcArea(ServcAreaVo vo) throws Exception{

		/*  아래의 API가 모두 정상적으로 수행된 후 서비스영역이 생성되어야 이후 업무가(서비스생성, 빌드, 배포 등) 정상적으로 처리됨
		 	1. 서비스영역 생성 API호출
		 	2. 서비스영역 계정 생성 API호출
		 	3. 서비스영역 롤 생성 API호출
		 	4. 서비스영역 수정 API호출 (Annotation, Labels 셋팅을 위해 호출)
		 	5. 쿼터 생성 API 호출
		 	6. 제한범위 생성 API 호출
		 */

		AtmSclResultIfVo atmSclResultIfVo = null;
		RestHeaders headers = null;
		String resultmessage =  OprConstant.RX_CRE_FAIL_MSG;
		String uid = null; //API호출 후 생성된 오브젝트의 고유ID
		String servcCreationTime = null;  //서빗스 생성시간
		boolean namespacesFlag = false; //서비스생성 여부
		boolean succFlag = false; //API호출 성공여부

		String servcAreaIdPreStr = "ns-"+vo.getNetClCd().toLowerCase()+"-"+vo.getInstitutionId().substring(0, 3).toLowerCase()+"-";
		String servcAreaId = commonService.selectSeqNum("RX_SERVC_AREA",servcAreaIdPreStr);  // 서비스영역 ID
		String resourceQuotasId = servcAreaId;  // 서비스영역 쿼터 ID
		String limitrangesId = servcAreaId;  // 서비스영역 제한범위 ID

		vo.setServcAreaId(servcAreaId);

		RxServcArea rxServcArea = new RxServcArea();
		BeanUtils.copyProperties(rxServcArea, vo);

		try{
			// Header정보 셋팅
			headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			//서비스 영역 생성에 필요한 데이터 셋팅
			ProjectRequestsIfVo projectRequestsIfVo = new ProjectRequestsIfVo();
			projectRequestsIfVo.setDisplayName(vo.getServcAreaNm()); //서비스영역명
			projectRequestsIfVo.setDescription(vo.getRmk()); //비고
			projectRequestsIfVo.setName(servcAreaId); //서비스영역ID

			//서비스영역 생성 API호출
			atmSclResultIfVo = servcAreaAPIService.projectRequestsPost(headers, projectRequestsIfVo);

			//서비스영역이 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				namespacesFlag = true;
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//서비스영역 계정 생성 API호출
				atmSclResultIfVo = servcAreaAPIService.serviceAccountsPost(headers, servcAreaId);
			}

			//서비스영역계정이 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//서비스영역 롤 생성 API호출
				atmSclResultIfVo = servcAreaAPIService.rollBindingsPost(headers, servcAreaId);
				logger.debug("atmSclResultIfVo : "+atmSclResultIfVo.getSuccYn());
			}

			//서비스영역 롤이 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				//서비스 영역 수정에 필요한 데이터 셋팅
				NamespaceIfVo namespaceVO = new NamespaceIfVo();
				namespaceVO.setNamespaceId(servcAreaId); //namespaceId
				namespaceVO.setDisplayName(vo.getServcAreaNm()); //서비스영역명
				namespaceVO.setDescription(vo.getRmk()); //서비스영역 설명
				namespaceVO.setName(servcAreaId); // 서비스영역 ID
				namespaceVO.setInstitutionId(vo.getInstitutionId()); //부처ID
				namespaceVO.setJobId(vo.getJobId()); //업무ID
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				//서비스영역 수정 API호출
				atmSclResultIfVo = servcAreaAPIService.nameSpacesPut(headers, namespaceVO);
			}

			//서비스영역이 정상적으로 수정되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				uid = atmSclResultIfVo.getUid(); //정상적으로 수정되었을 경우 uid 값이 셋팅됨
				servcCreationTime = atmSclResultIfVo.getCreationTime(); //생성일자

				if(!StringUtils.isEmpty(uid)) {
					ResourceQuotasIfVo resourceQuotasIfVo = new ResourceQuotasIfVo();
					resourceQuotasIfVo.setNamespaceId(servcAreaId); //서비스영역ID
					resourceQuotasIfVo.setName(resourceQuotasId); //쿼터ID
					resourceQuotasIfVo.setRequestsCpu(Integer.toString(vo.getReqCpuCorQty())); //요청CPU
					resourceQuotasIfVo.setRequestsMemory(Integer.toString(vo.getReqMemCapa())); //요청메모리
					resourceQuotasIfVo.setLimitsCpu(Integer.toString(vo.getLmttCpuCorQty())); //제한CPU
					resourceQuotasIfVo.setLimitsMemory(Integer.toString(vo.getLmttMemCapa())); //제한메모리
					resourceQuotasIfVo.setPods(Integer.toString(vo.getMaxPodQty())); //Pod수
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

					// 쿼터 생성 API 호출
					atmSclResultIfVo = servcAreaAPIService.resourceQuotasPost(headers, resourceQuotasIfVo);
				}
			}

			//서비스영역 쿼터가 정상적으로 생성 되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				// 제한범위 생성
				LimitrangesIfVo limitrangesIfVo = new LimitrangesIfVo();
				limitrangesIfVo.setNamespaceId(servcAreaId); // 서비스영역 ID
				limitrangesIfVo.setName(limitrangesId); // 제한범위 ID
				limitrangesIfVo.setMinCpu(changeSetVal(vo.getMinCpuCorQty(),"01")); //최소CPU
				limitrangesIfVo.setMinMemory(changeSetVal(vo.getMinMemCapa(),"02")); //최소메모리
				limitrangesIfVo.setMaxCpu(changeSetVal(vo.getMaxCpuCorQty(),"01")); //최대CPU
				limitrangesIfVo.setMaxMemory(changeSetVal(vo.getMaxMemCapa(),"02")); //최대메모리
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

				// 제한범위 생성 API 호출
				atmSclResultIfVo = servcAreaAPIService.limitrangesPost(headers, limitrangesIfVo);

				// 서비스영역 제한범위가 정상적으로 생성되었을 경우
				if("Y".equals(atmSclResultIfVo.getSuccYn())) {
					succFlag =  true; //최종 성공
				}
			}

			//API가 최종 성공일 경우
			if(succFlag) {

				rxServcArea.setServcAreaUid(uid);
				rxServcArea.setServcAreaClCd("02"); //서비스영역 구분코드 (서비스)
				rxServcArea.setCreDttm(servcCreationTime); //생성일자
				cRxServcAreaDao.insertRxServcArea(rxServcArea); //서비스영역 정보 insert

				RxServcAreaLmttConf rxServcnsLmttConf = null;
				rxServcnsLmttConf = new RxServcAreaLmttConf();
				rxServcnsLmttConf.setReqCpuCorQty(vo.getReqCpuCorQty());
				rxServcnsLmttConf.setReqMemCapa(vo.getReqMemCapa());
				rxServcnsLmttConf.setLmttCpuCorQty(vo.getLmttCpuCorQty());
				rxServcnsLmttConf.setLmttMemCapa(vo.getLmttMemCapa());
				rxServcnsLmttConf.setMaxPodQty(vo.getMaxPodQty());
				rxServcnsLmttConf.setServcAreaSeq(rxServcArea.getServcAreaSeq());
				rxServcnsLmttConf.setLmttConfId(resourceQuotasId);
				rxServcnsLmttConf.setLmttTyCd("01"); //제할설정유형코드 (서비스영역)
				rxServcnsLmttConf.setCreUserId(rxServcArea.getCreUserId());
				cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 쿼터설정 정보 insert

				rxServcnsLmttConf = new RxServcAreaLmttConf();
				rxServcnsLmttConf.setMaxCpuCorQty(vo.getMaxCpuCorQty());
				rxServcnsLmttConf.setMaxMemCapa(vo.getMaxMemCapa());
				rxServcnsLmttConf.setMinCpuCorQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU_CORE);
				rxServcnsLmttConf.setMinMemCapa(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY_GI);
				rxServcnsLmttConf.setServcAreaSeq(rxServcArea.getServcAreaSeq());
				rxServcnsLmttConf.setLmttConfId(limitrangesId);
				rxServcnsLmttConf.setLmttTyCd("02"); //제할설정유형코드 (Pod)
				rxServcnsLmttConf.setCreUserId(rxServcArea.getCreUserId());
				cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 insert

				rxServcnsLmttConf.setReqCpuCorQty(vo.getMinCpuCorQty());
				rxServcnsLmttConf.setReqMemCapa(vo.getMinMemCapa());
				//rxServcnsLmttConf.setLmttCpuCorQty(vo.getMaxCpuCorQty());
				//rxServcnsLmttConf.setLmttMemCapa(vo.getMaxMemCapa());
				rxServcnsLmttConf.setLmttCpuCorQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU_CORE);
				rxServcnsLmttConf.setLmttMemCapa(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY_GI);
				rxServcnsLmttConf.setLmttTyCd("03"); //제할설정유형코드 (컨테이너)
				cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 insert

				resultmessage =  OprConstant.RX_CRE_SUCC_MSG;
			}else {
				resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
			}
		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}finally {
			if(!succFlag) {
				if(namespacesFlag) {
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					servcAreaAPIService.deleteNamespaces(headers, servcAreaId); //API가 모두 성공하지 못했을경우 서비스영역 삭제처리
				}
			}
		}

		return resultmessage;
	}


	/**
	 * 서비스영역 상세조회
	 * @param servcAreaSeq
	 * @return ServcAreaVo
	 */
	@Override
	public ServcAreaVo selectServcArea(int servcAreaSeq) {
		ServcAreaVo servcAreaVo = new ServcAreaVo();
		servcAreaVo.setServcAreaSeq(servcAreaSeq);

		return servcAreaDao.selectServcArea(servcAreaVo);
	}


	/**
	 * 서비스목록 조회
	 * @param servcAreaSeq
	 * @return List
	 */
	@Override
	public List<ServcVo> selectServcList(int servcAreaSeq) {
		List<ServcVo> list = servcAreaDao.selectServcList(servcAreaSeq);
		return list;
	}


	/**
	 * PV 목록 조회
	 * @param searchVo
	 * @return List
	 */
	@Override
	public List<PvVo> selectPvList(PvSearchVo searchVo) {
		List<PvVo> list = null;

		int totalCount = servcAreaDao.selectPvListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = servcAreaDao.selectPvList(searchVo);
		}

		return list;
	}


	/**
	 * 서비스영역 PV할당
	 * @param vo
	 * @return String
	 */
	@Override
	public String updatePv(ServcAreaVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_ADD_SUCC_MSG;
		RxPv rxPv = null;

        for (PvVo pvVo : vo.getPvList()) {
        	rxPv = new RxPv();
        	rxPv.setRsrcPoolId(pvVo.getRsrcPoolId());
        	rxPv.setServcAreaSeq(pvVo.getServcAreaSeq());
        	rxPv.setPvId(pvVo.getPvId());
        	cRxPvDao.updateRxPv(rxPv);
        }

		return resultmessage;
	}


	/**
	 * 서비스영역 PV할당 삭제
	 * @param vo
	 * @return String
	 */
	@Override
	public String deletePv(PvVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_DEL_SUCC_MSG;
		RxPv rxPv = new RxPv();
		BeanUtils.copyProperties(rxPv, vo);
		cRxPvDao.deleteRxPv(rxPv);
		return resultmessage;
	}


	/**
	 * 서비스영역 수정
	 * @param vo
	 * @return String
	 */
	public String updateServcArea(ServcAreaVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_SAVE_FAIL_MSG;
		boolean succFlag = true;

		try{
			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			//서비스 영역 수정에 필요한 데이터 셋팅
			NamespaceIfVo namespaceVO = new NamespaceIfVo();
			namespaceVO.setDisplayName(vo.getServcAreaNm()); //서비스영역명
			namespaceVO.setDescription(vo.getRmk()); //서비스영역 설명
			namespaceVO.setNamespaceId(vo.getServcAreaId());
			namespaceVO.setInstitutionId(vo.getInstitutionId()); //부처ID
			namespaceVO.setJobId(vo.getJobId()); //업무ID

			//서비스영역 수정 API 호출
			AtmSclResultIfVo atmSclResultIfVo = servcAreaAPIService.nameSpacesPut(headers, namespaceVO);

			//정상적으로 수정되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				if("Y".equals(vo.getQuotaEditYn())) {

					// 쿼터 수정
					ResourceQuotasIfVo resourceQuotasIfVo = new ResourceQuotasIfVo();
					resourceQuotasIfVo.setNamespaceId(vo.getServcAreaId());
					resourceQuotasIfVo.setRequestsCpu(Integer.toString(vo.getReqCpuCorQty()));
					resourceQuotasIfVo.setRequestsMemory(Integer.toString(vo.getReqMemCapa()));
					resourceQuotasIfVo.setLimitsCpu(Integer.toString(vo.getLmttCpuCorQty()));
					resourceQuotasIfVo.setLimitsMemory(Integer.toString(vo.getLmttMemCapa()));
					resourceQuotasIfVo.setPods(Integer.toString(vo.getMaxPodQty()));
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

					//쿼터 정보가 없을경우
					if(StringUtils.isEmpty(vo.getQuotaId())) {
						resourceQuotasIfVo.setName(vo.getServcAreaId());
						atmSclResultIfVo = servcAreaAPIService.resourceQuotasPost(headers, resourceQuotasIfVo);
					}else {
						resourceQuotasIfVo.setName(vo.getQuotaId());
						atmSclResultIfVo = servcAreaAPIService.resourceQuotasPut(headers, resourceQuotasIfVo);
					}

					if("N".equals(atmSclResultIfVo.getSuccYn())) {
						succFlag = false;
					}
				}

				if("Y".equals(vo.getLimitEditYn())) {

					// 제한범위 수정
					LimitrangesIfVo limitrangesIfVo = new LimitrangesIfVo();
					limitrangesIfVo.setNamespaceId(vo.getServcAreaId());
					limitrangesIfVo.setName(vo.getLimitId());

					limitrangesIfVo.setMinCpu(changeSetVal(vo.getMinCpuCorQty(),"01"));
					limitrangesIfVo.setMinMemory(changeSetVal(vo.getMinMemCapa(),"02"));
					limitrangesIfVo.setMaxCpu(changeSetVal(vo.getMaxCpuCorQty(),"01"));
					limitrangesIfVo.setMaxMemory(changeSetVal(vo.getMaxMemCapa(),"02"));
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

					//제한범위 정보가 없을경우
					if(StringUtils.isEmpty(vo.getLimitId())) {
						limitrangesIfVo.setName(vo.getServcAreaId());
						atmSclResultIfVo = servcAreaAPIService.limitrangesPost(headers, limitrangesIfVo);
					}else {
						limitrangesIfVo.setName(vo.getLimitId());
						atmSclResultIfVo = servcAreaAPIService.limitrangesPut(headers, limitrangesIfVo);
					}

					if("N".equals(atmSclResultIfVo.getSuccYn())) {
						succFlag = false;
					}
				}
			}else {
				resultmessage = resultmessage+"\n ["+atmSclResultIfVo.getMessage()+"]";
			}

			if(succFlag) {

				RxServcArea rxServcArea = new RxServcArea();
				BeanUtils.copyProperties(rxServcArea, vo);

				cRxServcAreaDao.updateRxServcArea(rxServcArea); //서비스영역 정보 수정
				RxServcAreaLmttConf rxServcnsLmttConf = null;

				if("Y".equals(vo.getQuotaEditYn())) {

					rxServcnsLmttConf = new RxServcAreaLmttConf();
					BeanUtils.copyProperties(rxServcnsLmttConf, vo);
					rxServcnsLmttConf.setLmttTyCd("01"); //제할설정유형코드 (서비스영역)

					//쿼터 정보가 없을경우
					if(StringUtils.isEmpty(vo.getQuotaId())) {
						rxServcnsLmttConf.setCreUserId(rxServcArea.getUpdtUserId());
						rxServcnsLmttConf.setLmttConfId(vo.getServcAreaId());
						cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 쿼터설정 정보 insert

					}else {
						rxServcnsLmttConf.setLmttConfId(vo.getQuotaId());
						rxServcnsLmttConf.setUpdtUserId(rxServcArea.getUpdtUserId());
						cRxServcAreaLmttConfDao.updateRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 update
					}
				}

				if("Y".equals(vo.getLimitEditYn())) {

					rxServcnsLmttConf = new RxServcAreaLmttConf();
					BeanUtils.copyProperties(rxServcnsLmttConf, vo);

					//제한범위 정보가 없을경우
					if(StringUtils.isEmpty(vo.getLimitId())) {
						rxServcnsLmttConf.setLmttConfId(vo.getServcAreaId());
						rxServcnsLmttConf.setLmttTyCd("02"); //제할설정유형코드 (Pod)
						rxServcnsLmttConf.setMinCpuCorQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU_CORE);
						rxServcnsLmttConf.setMinMemCapa(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY_GI);
						rxServcnsLmttConf.setCreUserId(rxServcArea.getUpdtUserId());
						cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 insert

						rxServcnsLmttConf.setReqCpuCorQty(vo.getMinCpuCorQty());
						rxServcnsLmttConf.setReqMemCapa(vo.getMinMemCapa());
						rxServcnsLmttConf.setLmttCpuCorQty(vo.getMaxCpuCorQty());
						rxServcnsLmttConf.setLmttMemCapa(vo.getMaxMemCapa());
						rxServcnsLmttConf.setLmttTyCd("03"); //제할설정유형코드 (컨테이너)
						cRxServcAreaLmttConfDao.insertRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 insert

					}else {
						rxServcnsLmttConf.setLmttConfId(vo.getLimitId());
						rxServcnsLmttConf.setLmttTyCd("02"); //제할설정유형코드 (Pod)
						rxServcnsLmttConf.setMinCpuCorQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU_CORE);
						rxServcnsLmttConf.setMinMemCapa(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY_GI);
						rxServcnsLmttConf.setUpdtUserId(rxServcArea.getUpdtUserId());
						cRxServcAreaLmttConfDao.updateRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 update

						rxServcnsLmttConf.setLmttTyCd("03"); //제할설정유형코드 (컨테이너)
						rxServcnsLmttConf.setReqCpuCorQty(vo.getMinCpuCorQty());
						rxServcnsLmttConf.setReqMemCapa(vo.getMinMemCapa());
						//rxServcnsLmttConf.setLmttCpuCorQty(vo.getMaxCpuCorQty());
						//rxServcnsLmttConf.setLmttMemCapa(vo.getMaxMemCapa());
						rxServcnsLmttConf.setLmttCpuCorQty(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU_CORE);
						rxServcnsLmttConf.setLmttMemCapa(OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY_GI);
						cRxServcAreaLmttConfDao.updateRxServcAreaLmttConf(rxServcnsLmttConf); //서비스영역 제한설정 정보 update
					}
				}

				resultmessage =  OprConstant.RX_CRE_SUCC_MSG;
			}
		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultmessage;
	}


	/**
	 * 서비스영역 삭제
	 * @param vo
	 * @return String
	 */
	@Override
	public String updateServcAreaDeleteYn(ServcAreaVo vo) throws Exception{

		String resultmessage =  OprConstant.RX_DEL_FAIL_MSG;

		try{

			int servcCnt = servcAreaDao.selectServcCnt(vo);  //서비스 존재여부 확인

			if(servcCnt>0) {
				throw new CommonException("해당 서비스영역에 사용중인 서비스가 있습니다.\n서비스를 삭제 후 진행해 주시기 바랍니다.");
			}

			//해더정보 셋팅
			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(vo.getRsrcPoolId());

			//서비스영역 삭제 API 호출
			AtmSclResultIfVo atmSclResultIfVo = servcAreaAPIService.deleteNamespaces(headers, vo.getServcAreaId());

			//API가 정상적으로 수행되었을경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {

				//PV할당정보 초기화
				RxPv rxPv = new RxPv();
				rxPv.setServcAreaSeq(vo.getServcAreaSeq());
				rxPv.setRsrcPoolId(vo.getRsrcPoolId());
				cRxPvDao.deleteRxPv(rxPv);

				//자동확장서비스영역제한설정 삭제
				RxServcAreaLmttConf rxServcAreaLmttConf = new RxServcAreaLmttConf();
				rxServcAreaLmttConf.setServcAreaSeq(vo.getServcAreaSeq());
				cRxServcAreaLmttConfDao.deleteRxServcAreaLmttConf(rxServcAreaLmttConf);

				//서비스영역 삭제
				RxServcArea rxServcArea = new RxServcArea();
				BeanUtils.copyProperties(rxServcArea, vo);
				rxServcArea.setDelYn("Y");
				cRxServcAreaDao.deleteRxServcArea(rxServcArea); //서비스영역 삭제정보 정보 수정
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
	 * CPU, 메모리 값 변환
	 * @param doubleVal
	 * @param type
	 * @return String
	 */
	private String changeSetVal(double doubleVal, String type) {

		String rtnVal = null;
		String unitStr = "";

		if("01".equals(type)) {  //CPU일경우
			unitStr = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_M;
			rtnVal =Long.toString(Math.round(doubleVal*1000))+unitStr;
		}else if("02".equals(type)) {  //메모리일경우
			unitStr = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_MI;
			rtnVal =Long.toString(Math.round(doubleVal*1024))+unitStr;
		}

		return rtnVal;
	}
}
