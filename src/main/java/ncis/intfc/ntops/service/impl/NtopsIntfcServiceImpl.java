/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmCreateHandler.java
 *
 * @author hsLee
 * @lastmodifier hsLee
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     hsLee         v1.0             최초생성
 *
 */
package ncis.intfc.ntops.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmGatewayDao;
import ncis.cmn.entity.CmGateway;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.PropertiesUtil;
import ncis.cpt.opr.req.rsrcreq.dao.RcVmDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqVmDao;
import ncis.intfc.ntops.service.NtopsIntfcService;
import ncis.intfc.ntops.vo.CreateVmResultVO;
import ncis.intfc.ntops.vo.ModifyVmResultVO;
import ncis.intfc.ntops.vo.NTopsSendVo;
import ncis.intfc.ntops.vo.ProcessConstant;
import ncis.intfc.ntops.vo.RemoveVmResultVO;
import ncis.intfc.ntops.vo.ResultMessageCreateVmVO;
import ncis.intfc.ntops.vo.ResultMessageModifyVmVO;
import ncis.intfc.ntops.vo.ResultMessageRemoveVmVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component("ntopsIntfcService")
public class NtopsIntfcServiceImpl implements NtopsIntfcService {

//	@Resource(name="createVmResultService")
//	private CreateVmResultService createVmResultService;  //가상서버 생성 nTops결과전송 Service
//
//	@Resource(name="processMngDao")
//	private ProcessMngDao processMngDao; //프로세스관리 DAO

	@Resource(name="rsrcReqVmDao")
	private RsrcReqVmDao rsrcReqVmDao; //자원요청상세 DAO

	@Resource(name="rsrcRcVmDao")
	public RcVmDao rcVmDao;

	@Resource(name="restSender") private RestSender restSender;

	@Resource(name = "cCmGatewayDao")
	private CCmGatewayDao cCmGatewayDao; // 게이트웨이 DAO

	private final Logger logger = LoggerFactory.getLogger(NtopsIntfcServiceImpl.class);


    /**
     * nTops 가상서버 요청 결과 업데이트
     * @param vo
     * @return ResultMessageCreateVmVO 응답코드, 응답메시지
     */
    private ResultMessageCreateVmVO createVmResultUpdate(CreateVmResultVO vo) throws Exception {

        String nTopsKey = PropertiesUtil.getProperty("gateway.ntops.key");
        CmGateway gwInfo = cCmGatewayDao.selectCmGatewayByRegion("DJ");
        String baseUrl = null;
        String token = null;

        if(gwInfo != null)
        {
            baseUrl = gwInfo.getGatewayHost();
            token = gwInfo.getGatewayToken();
        }
        else
        {
            baseUrl = PropertiesUtil.getProperty("Gateway.Host");
            token =  PropertiesUtil.getProperty("Gateway.Token");
        }

        baseUrl = baseUrl  + ProcessConstant.getNtopsCreResultUpdtUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("authorization", token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("reqId", vo.getReqId())         /* 요청Id */
                .queryParam("vmId", vo.getVmId())           /* 가상서버구성Id */
                .queryParam("key", nTopsKey);

        // 요청메시지(body)
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("createDate", vo.getCreateDate());                     /* 처리일자 */
        params.put("createResult", vo.getCreateResult());                 /* 처리결과 'S', 'F'*/
        params.put("errorMsg", vo.getErrorMsg());                   /* 에러메시지 */

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(params, headers);

        ResponseEntity<ResultMessageCreateVmVO> responseEntity = (new RestTemplate()).exchange(
                builder.build().encode().toUri()
                , HttpMethod.PUT
                , requestEntity
                , ResultMessageCreateVmVO.class
                );

        try {
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
    }

    private ResultMessageModifyVmVO modifyVmResultUpdate(ModifyVmResultVO vo) throws Exception {
    	String nTopsKey = PropertiesUtil.getProperty("gateway.ntops.key");
        CmGateway gwInfo = cCmGatewayDao.selectCmGatewayByRegion("DJ");
        String baseUrl = null;
        String token = null;

        if(gwInfo != null)
        {
            baseUrl = gwInfo.getGatewayHost();
            token = gwInfo.getGatewayToken();
        }
        else
        {
            baseUrl = PropertiesUtil.getProperty("Gateway.Host");
            token =  PropertiesUtil.getProperty("Gateway.Token");
        }

        baseUrl = baseUrl  + ProcessConstant.getNtopsModResultUpdtUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("authorization", token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("reqId", vo.getReqId())         /* 요청Id */
                .queryParam("vmId", vo.getVmId())           /* 가상서버구성Id */
                .queryParam("reqType", vo.getReqType())     /* 요청타입 'VM_ADD_STORAGE', 'VM_SPEC', 'VM_DEL' */
                .queryParam("key", nTopsKey);

        // 요청메시지(body)
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("modDate", vo.getModDate());                     /* 처리일자 */
        params.put("modResult", vo.getModResult());                 /* 처리결과 'S', 'F'*/
        params.put("errorMsg", vo.getErrorMsg());                   /* 에러메시지 */
        params.put("totalStorageSize", vo.getTotalStorageSize());   /* 총 스토리지 용량 */

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(params, headers);

        ResponseEntity<ResultMessageModifyVmVO> responseEntity = (new RestTemplate()).exchange(
                builder.build().encode().toUri()
                , HttpMethod.PUT
                , requestEntity
                , ResultMessageModifyVmVO.class
                );

        try {
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
    }


    private ResultMessageRemoveVmVO removeVmResultUpdate(RemoveVmResultVO vo) throws Exception {

    	String nTopsKey = PropertiesUtil.getProperty("gateway.ntops.key");
        CmGateway gwInfo = cCmGatewayDao.selectCmGatewayByRegion("DJ");
        String baseUrl = null;
        String token = null;

        if(gwInfo != null)
        {
            baseUrl = gwInfo.getGatewayHost();
            token = gwInfo.getGatewayToken();
        }
        else
        {
            baseUrl = PropertiesUtil.getProperty("Gateway.Host");
            token =  PropertiesUtil.getProperty("Gateway.Token");
        }

        baseUrl = baseUrl  + ProcessConstant.getNtopsModResultUpdtUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("authorization", token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("reqId", vo.getReqId())         /* 요청Id */
                .queryParam("vmId", vo.getVmId())           /* 가상서버구성Id */
                .queryParam("reqType", vo.getReqType())     /* 요청타입 'VM_ADD_STORAGE', 'VM_SPEC', 'VM_DEL' */
                .queryParam("key", nTopsKey);

        // 요청메시지(body)
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("modDate", vo.getModDate());                     /* 처리일자 */
        params.put("modResult", vo.getModResult());                 /* 처리결과 'S', 'F'*/
        params.put("errorMsg", vo.getErrorMsg());                   /* 에러메시지 */

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(params, headers);

        ResponseEntity<ResultMessageRemoveVmVO> responseEntity = (new RestTemplate()).exchange(
                builder.build().encode().toUri()
                , HttpMethod.PUT
                , requestEntity
                , ResultMessageRemoveVmVO.class
                );

        try {
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
    }


	/**
	 * nTops 결과전송 (가상서버 생성)
	 * @param vo
	 * @return
	 *
	 */
	public boolean sendVmCreateNTopsResult(String rsrcReqNo) throws Exception {

		boolean rtnFlag = false;  //정상처리 여부
		NTopsSendVo nTopsSendVo = rcVmDao.selectNTopsSendInfo(rsrcReqNo);

		if("Y".equals(nTopsSendVo.getLinkYn())) {  //nTops를 통해 연계된 요청건일경우
			CreateVmResultVO createVmResultVO = new CreateVmResultVO();
			createVmResultVO.setReqId(nTopsSendVo.getTicktNo());  //티켓번호
			createVmResultVO.setVmId(nTopsSendVo.getVmCompId());  //가상서버구성ID
			createVmResultVO.setCreateDate(DateUtil.getCurrentDate("yyyyMMddhhmmss")); //생성일
			createVmResultVO.setCreateResult(ProcessConstant.getNtopsResultS()); //생성결과는 성공 (실패는 발생할 수 없음, 실패전송은 화면에서 반려기능을 통해 인터페이스함)
			createVmResultVO.setErrorMsg(""); //에러정보

			ResultMessageCreateVmVO resultMessageCreateVmVO = createVmResultUpdate(createVmResultVO);

			if(ProcessConstant.getNtopsStatCdIfm0000().equals(resultMessageCreateVmVO.getCode())
					|| ProcessConstant.getNtopsStatCdIfm0004().equals(resultMessageCreateVmVO.getCode())) {
				rtnFlag = true;
			}
		}else {
			rtnFlag = true;
		}

		return rtnFlag;
	}


	/**
	 * 가상서버 스펙변경 nTops 결과전송
	 * @param vo
	 * @return
	 *
	 */
	public boolean sendVmSpecChangeNTopsResult(String rsrcReqNo) throws Exception {

		boolean rtnFlag = false;

		NTopsSendVo nTopsSendVo = rcVmDao.selectNTopsSendInfo(rsrcReqNo);

		if("Y".equals(nTopsSendVo.getLinkYn())) {  //nTops를 통해 연계된 요청건일경우
			ModifyVmResultVO modifyVmResultVO = new ModifyVmResultVO();
			modifyVmResultVO.setReqId(nTopsSendVo.getTicktNo());
			modifyVmResultVO.setVmId(nTopsSendVo.getVmCompId());
			modifyVmResultVO.setReqType(ProcessConstant.getNtopsReqTypeVmSpec()); //nTOPS에 정의된 값. (VM_SPEC)
			modifyVmResultVO.setModDate(DateUtil.getCurrentDate("yyyyMMddhhmmss"));
			modifyVmResultVO.setModResult(ProcessConstant.getNtopsResultS()); //생성결과는 성공 (실패는 발생할 수 없음, 실패전송은 화면에서 반려기능을 통해 인터페이스함)
			modifyVmResultVO.setErrorMsg("");

			ResultMessageModifyVmVO resultMessageModifyVmVO = modifyVmResultUpdate(modifyVmResultVO);

			if(ProcessConstant.getNtopsStatCdIfm0000().equals(resultMessageModifyVmVO.getCode())
					|| ProcessConstant.getNtopsStatCdIfm0004().equals(resultMessageModifyVmVO.getCode())) {
				rtnFlag = true;
			}
		}else {
			rtnFlag = true;
		}

		return rtnFlag;
	}


	/**
	 * 가상서버 스토리지추가 nTops 결과전송
	 * @param vo
	 * @return
	 *
	 */
	public boolean sendVmStorageAddNTopsResult(String rsrcReqNo) throws Exception {

		boolean rtnFlag = false;

		NTopsSendVo nTopsSendVo = rcVmDao.selectNTopsSendInfo(rsrcReqNo);

		if("Y".equals(nTopsSendVo.getLinkYn())) {  //nTops를 통해 연계된 요청건일경우
			ModifyVmResultVO modifyVmResultVO = new ModifyVmResultVO();
			modifyVmResultVO.setReqId(nTopsSendVo.getTicktNo());
			modifyVmResultVO.setVmId(nTopsSendVo.getVmCompId());
			modifyVmResultVO.setReqType(ProcessConstant.getNtopsReqTypeStorage());  //VM_ADD_STORAGE
			modifyVmResultVO.setModDate(DateUtil.getCurrentDate("yyyyMMddhhmmss"));
			modifyVmResultVO.setModResult(ProcessConstant.getNtopsResultS()); //생성결과는 성공 (실패는 발생할 수 없음, 실패전송은 화면에서 반려기능을 통해 인터페이스함)
			modifyVmResultVO.setErrorMsg("");
			modifyVmResultVO.setTotalStorageSize(nTopsSendVo.getTotalStrgAsgnCapa());

			ResultMessageModifyVmVO resultMessageModifyVmVO = modifyVmResultUpdate(modifyVmResultVO);

			if(ProcessConstant.getNtopsStatCdIfm0000().equals(resultMessageModifyVmVO.getCode())
					|| ProcessConstant.getNtopsStatCdIfm0004().equals(resultMessageModifyVmVO.getCode())) {
				rtnFlag = true;
			}
		}else {
			rtnFlag = true;
		}

		return rtnFlag;
	}



	/**
	 * 가상서버 삭제 nTops 결과전송
	 * @param vo
	 * @return
	 *
	 */
	public boolean sendVmDeleteNTopsResult(String rsrcReqNo) throws Exception {

		boolean rtnFlag = false;

		NTopsSendVo nTopsSendVo = rcVmDao.selectNTopsSendInfo(rsrcReqNo);

		if("Y".equals(nTopsSendVo.getLinkYn())) {  //nTops를 통해 연계된 요청건일경우
			RemoveVmResultVO removeVmResultVO = new RemoveVmResultVO();
			removeVmResultVO.setReqId(nTopsSendVo.getTicktNo());
			removeVmResultVO.setVmId(nTopsSendVo.getVmCompId());
			removeVmResultVO.setReqType(ProcessConstant.getNtopsReqTypeVmDel()); //nTOPS에 정의된 값.(VM_DEL)
			removeVmResultVO.setModDate(DateUtil.getCurrentDate("yyyyMMddhhmmss"));
			removeVmResultVO.setModResult(ProcessConstant.getNtopsResultS()); //생성결과는 성공 (실패는 발생할 수 없음, 실패전송은 화면에서 반려기능을 통해 인터페이스함)
			removeVmResultVO.setErrorMsg("");

			ResultMessageRemoveVmVO resultMessageRemoveVmVO = removeVmResultUpdate(removeVmResultVO);

			if(ProcessConstant.getNtopsStatCdIfm0000().equals(resultMessageRemoveVmVO.getCode())
					|| ProcessConstant.getNtopsStatCdIfm0004().equals(resultMessageRemoveVmVO.getCode())) {
				rtnFlag = true;
			}
		}else {
			rtnFlag = true;
		}

		return rtnFlag;
	}

//
//	/**
//	 * 자원요청 상태를 업데이트한다.
//	 * @param vo
//	 * @return void
//	 *
//	 */
//	public void updateRsrcReqPrcssStat(ProcessMngVo vo) throws Exception {
//		RsrcReqDtlVmVo rsrcReqDtlVmVo = new RsrcReqDtlVmVo();
//		rsrcReqDtlVmVo.setRsrcReqNo(vo.getRsrcReqNo());
//		rsrcReqDtlVmVo.setRsrcReqPrcssStatCd(ProcessConstant.getRsrcReqStatCd05()); //오류
//		rsrcReqDtlDao.updateRsrcReqPrcssStat(rsrcReqDtlVmVo);
//	}
//

//	/**
//	 * 자원요청상태 완료처리
//	 * @param vo
//	 * @return
//	 *
//	 */
//	public void completeRsrcReqDtlStat(ProcessMngVo vo) throws Exception {
//
//		String haRsrcReqNo = "";  //HA가상서버 생성건인지 체크하기 위한 변수
//
//		vo.setRsrcReqPrcssStatCd(ProcessConstant.getRsrcReqStatCd03()); //완료
//		rsrcReqDtlDao.updateRsrcReqStat(vo); //자원요청 상태를 완료로 업데이트
//		rsrcReqDtlDao.updateRsrcReqDtlVmStat(vo); //자원요청상세(가상서버) 상태를 완료로 업데이트
//
//		haRsrcReqNo = rsrcReqDtlDao.selectHaVmRsrcReqNo(vo); //연관 HA가상서버 생성건 조회
//
//		if(haRsrcReqNo !=null) { //연관 HA가상서버 생성건이 남아 있을 경우
//			ProcessMngVo haProcessMngVo = new ProcessMngVo();
//			haProcessMngVo.setRsrcReqNo(haRsrcReqNo); //대상 자원요청번호
//			haProcessMngVo.setProcssSeq(vo.getProcssSeq()); //대상 프로세스SEQ
//			haProcessMngVo.setStatCd(ProcessConstant.getStatCd01()); //진행
//			processMngDao.updateWaitProcssInstStat(haProcessMngVo); //대기중인 해당 HA건 프로세스의 상태를 진행중으로 변경
//		}
//	}
}
