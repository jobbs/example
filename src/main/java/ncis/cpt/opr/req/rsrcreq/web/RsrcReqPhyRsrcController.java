/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-물리서버</pre>
 *
 * @filename RsrcReqAddController.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.web;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.config.OprConstant;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqPhyRsrcService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.intfc.pmintfc.service.PmIntfcService;
import ncis.intfc.pmintfc.vo.PmStatusResultBodyVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="/cpt/opr/req/rsrcreq")
public class RsrcReqPhyRsrcController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqPopCallController.class);

	private final String RR_PM_ADD = "물리서버 추가요청";
	private final String RR_PM_DEL = "물리서버 삭제요청";
	private final String RR_CLSTR_ADD = "클러스터 생성요청";
	private final String RR_CLSTR_DEL = "클러스터 삭제요청";

	@Resource(name="rsrcReqPhyRsrcService")
	protected RsrcReqPhyRsrcService rsrcReqPhyRsrcService;

	@Resource(name="commonService")
	protected CommonService commonService;

	@Resource(name = "pmIntfcService")
    PmIntfcService pmIntfcService;

    @Resource(name = "pmService")
    PmService pmService;

	/**
	 * 자원상세  물리서버추가 View
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqPhySrvAdd.do")
	public String selectRserReqPhySrvrAddView(HttpServletRequest request, Model model, @RequestParam("schRsrcReqNo") String rsrcReqNo) {
		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqNo);
			//요청 기본 정보 조회
			RsrcReqVo rsrcReqVo = rsrcReqPhyRsrcService.selectRsrcReqInfo(searchVo);
			//요청에 따른 물리서버 목록 (마지막 순서의 물리 서버만 반환하게 구현)

			RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo = rsrcReqPhyRsrcService.selectRsrcReqPhySrvrAdd(rsrcReqNo);

			model.addAttribute("title",RR_PM_ADD);
			model.addAttribute("rrVo", rsrcReqVo);
			model.addAttribute("rrprVo",rsrcReqPhyRsrcVo);

			return portalTilesView(request, "formRsrcReqPhySrvrAdd");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}


	/**
	 * 자원상세  = 물리서버삭제 View
	 * @param request
	 * @param model
	 * @param rsrcReqNo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqPhySrvDel.do")
	public String selectRserReqPhySrvrDelView(HttpServletRequest request, Model model, @RequestParam("schRsrcReqNo") String rsrcReqNo) {
		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqNo);
			//요청 기본 정보 조회
			RsrcReqVo rsrcReqVo = rsrcReqPhyRsrcService.selectRsrcReqInfo(searchVo);
			//요청에 따른 물리서버 목록 (마지막 순서의 물리 서버만 반환하게 구현)

			RsrcReqPhyRsrcVo rrprVo = rsrcReqPhyRsrcService.selectRsrcReqPhySrvrDel(rsrcReqNo);

			if(rrprVo.getPmSeq() == null){
				throw new Exception("물리서버가 존재하지 않습니다.");
			}

			PmVo pmVo =  pmService.selectPm(rrprVo.getPmSeq());

			model.addAttribute("title",RR_PM_DEL);
			model.addAttribute("rrVo", rsrcReqVo);
			model.addAttribute("rrprVo",rrprVo);
			model.addAttribute("pmVo",pmVo);

			return portalTilesView(request, "formRsrcReqPhySrvrDel");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}


	/**
	 *  자원요청상세-클러스터추가View
	 * @param request
	 * @param model
	 * @param rsrcReqNo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqClstAdd.do")
	public String selectRsrcReqClstAddView(HttpServletRequest request, Model model, @RequestParam("schRsrcReqNo") String rsrcReqNo) {
		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqNo);
			//요청 기본 정보 조회
			RsrcReqVo rsrcReqVo = rsrcReqPhyRsrcService.selectRsrcReqInfo(searchVo);
			//요청에 따른 물리서버 목록 (마지막 순서의 물리 서버만 반환하게 구현)

			RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo = rsrcReqPhyRsrcService.selectRsrcReqClstrAdd(rsrcReqNo);
			List<RsrcReqPhyRsrcVo> dataCntrListVo = rsrcReqPhyRsrcService.selectDataCntrList();

			model.addAttribute("title",RR_CLSTR_ADD);
			model.addAttribute("rrVo", rsrcReqVo);
			model.addAttribute("rrprVo",rsrcReqPhyRsrcVo);
			model.addAttribute("rrDataCntrListVo",dataCntrListVo);

			return portalTilesView(request, "formRsrcReqClstrAdd");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}

	/**
	 * 자원요청상세-클러스터 삭제
	 * @param request
	 * @param model
	 * @param rsrcReqNo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqClstDel.do")
	public String selectRsrcReqClstDelView(HttpServletRequest request, Model model, @RequestParam("schRsrcReqNo") String rsrcReqNo) {
		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqNo);
			//요청 기본 정보 조회
			RsrcReqVo rsrcReqVo = rsrcReqPhyRsrcService.selectRsrcReqInfo(searchVo);
			//요청에 따른 물리서버 목록 (마지막 순서의 물리 서버만 반환하게 구현)
			RsrcReqPhyRsrcVo rrprVo = rsrcReqPhyRsrcService.selectRsrcReqClstrDel(rsrcReqNo);

			if(rrprVo.getClstrSeq() == null){
				throw new Exception("클러스터가 존재하지 않습니다.");
			}

			model.addAttribute("title",RR_CLSTR_DEL);
			model.addAttribute("rrVo", rsrcReqVo);
			model.addAttribute("rrprVo",rrprVo);

			return portalTilesView(request, "formRsrcReqClstrDel");

		}catch(Exception e){
			logger.error(e.getMessage(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}

    /**
	 * 자원요청상세_물리자원_실행
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */
	@OperateLog(action="자원요청상세_물지자원_실행", desc="물리자원 자원요청 실행.", params={"rrprVo"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updateRsrcReqPhyRsrcExe.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateRsrcReqPhySrvAddExe(@ModelAttribute("rrprVo") RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo, BindingResult bindResult) {
		ProcResultVo result = getBindingResult(rsrcReqPhyRsrcVo, bindResult, UpdateProc.class);
		rsrcReqPhyRsrcVo.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_PRCSS);

		if (result.isSuccess()) {
			String reqPrcssStatNm ="실행";
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			try {
				String resultmessage = rsrcReqPhyRsrcService.updateRsrcReqPhyRsrcExe(rsrcReqPhyRsrcVo, getUserId() );
				result.addMessage( "["+reqPrcssStatNm+"] " +resultmessage);
				result.setSuccess(true);
			} catch (Exception e) {
				logger.error(e.getMessage());
				result.setSuccess(false);
				result.addMessage("["+reqPrcssStatNm+"] "+ OprConstant.RSRC_EXEC_FAIL_MSG + e.getMessage());
			}

		}
		return result;
	}

	/**
	 * 자원요청상세_물리자원_반려
	 * @param rsrcReqPhyRsrcVo
	 * @param bindResult
	 * @return
	 */
	@OperateLog(action="자원요청상세_물리자원_반려", desc="물리자원 자원요청 반려", params={"rrVo"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updateRsrcReqPhyRsrcRjct.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateRsrcReqPhyRsrcRjct(@ModelAttribute("rrVo") RsrcReqVo rsrcReqVo, BindingResult bindResult) {
		ProcResultVo result = getBindingResult(rsrcReqVo, bindResult, UpdateProc.class);

		RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo = new RsrcReqPhyRsrcVo();
		rsrcReqPhyRsrcVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
		rsrcReqPhyRsrcVo.setRsrcReqSeq(rsrcReqVo.getRsrcReqSeq());
		rsrcReqPhyRsrcVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
		rsrcReqPhyRsrcVo.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_RJCT);
		rsrcReqPhyRsrcVo.setRjctTyCd(rsrcReqVo.getRjctTyCd());
		rsrcReqPhyRsrcVo.setRjctReasn(rsrcReqVo.getRjctReasn());

		String reqPrcssStatNm ="반려";
		if (result.isSuccess()) {
			result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
			try {
				String resultmessage = rsrcReqPhyRsrcService.updateRsrcReqPhyRsrcRjct(rsrcReqPhyRsrcVo, getUserId() );
				result.addMessage( "["+reqPrcssStatNm+"] " +resultmessage);
				result.setSuccess(true);
			} catch (Exception e) {
				result.setSuccess(false);
				result.addMessage("["+reqPrcssStatNm+"] "+OprConstant.RSRC_EXEC_FAIL_MSG);
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	@OperateLog(action="물리서버 상태 조회", desc="물리서버 상태 조회", params={"pmSeq"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/selectSyncPmsStatus.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo selectSyncPmsStatus(@ModelAttribute("pmSeq") BigDecimal pmSeq, BindingResult bindResult) throws Exception {
		try{
			PmVo pmVo =  pmService.selectPm(pmSeq);
			return getSuccessProcResult(OprConstant.SUCCESS_MSG, "select", pmVo);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG + "\n"+e.getMessage());
		}
	}
	/**
	 * 자원요청상세_물리서버 상태 새로고침
	 * @param rrPrVo
	 * @param bindResult
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="물리서버 상태 동기화", desc="물리서버 상태 동기화", params={"pmSeq"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updateSyncPmsStatus.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateSyncPmsStatus(@ModelAttribute("pmSeq") BigDecimal pmSeq, BindingResult bindResult) throws Exception {
		try{
			PmVo pmVo =  pmService.selectPm(pmSeq);
			//step 1 : 연계를 통한 현제 상태 조회 및 설정
			RestHeaders restHeaders = getRestHeaders(pmVo);
			logger.debug("[updateSyncPmsStatus] uuid = " + pmVo.getUuid() + ", curr status="+pmVo.getStatCd()+"("+pmVo.getStatCdNm()+")" +",  restHeaders = " + new Gson().toJson(restHeaders));
			PmStatusResultBodyVO bodyVo = this.pmIntfcService.status(pmVo.getUuid(), restHeaders);
			logger.debug("[bodyVo] id = " + bodyVo.getId() +", getStatusCode="+ bodyVo.getStatusCode());

			//step 2 : 상태 업데이트
			if( !bodyVo.getId().equals(pmVo.getUuid()) ){
				return getFailProcResult(OprConstant.ERROR_MSG  + "\n"+ OprConstant.ERROR_MSG_PM_NOT_EQUALS_REQ_PM +"\n(요청ID)" + pmVo.getUuid() + ", (응답ID)=" + bodyVo.getId());
			}else if(!bodyVo.getStatusCode().equals(pmVo.getStatCd())){
				logger.debug( "상태변경=" + pmVo.getStatCd()  +">>"+bodyVo.getStatusCode());
				PmVo uptPmVo  = new PmVo();
				uptPmVo.setPmSeq(pmSeq);
				//추후 코드로 전환되면 수정 필요.
				uptPmVo.setStatCd(bodyVo.getStatusCode());
				uptPmVo.setUuid(bodyVo.getId());
				pmService.updateRcPmStat(uptPmVo);
				//step 2-1: 업데이트 후 상태 재 조회
				pmVo = pmService.selectPm(pmSeq);
			}
			return getSuccessProcResult(OprConstant.SUCCESS_MSG, "select", pmVo);

		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG + "\n"+e.getMessage());
		}
	}

	/**
	 * 물리서버 활성 (연계)
	 * @param rrPrVo
	 * @param bindResult
	 * @return
	 * @throws Exception
	 */
	@OperateLog(action="물리서버 활성", desc="물리서버 활성", params={"pmSeq"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updatePmActive.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updatePmActivate(@ModelAttribute("pmSeq") BigDecimal pmSeq, BindingResult bindResult) throws Exception {
		try{

			PmVo pmVo =  pmService.selectPm(pmSeq);
			//실제 상태 점검.
			RestHeaders restHeaders = getRestHeaders(pmVo);
			logger.debug("[updatePmActivate] uuid = " + pmVo.getUuid() +",  restHeaders = " + new Gson().toJson(restHeaders));
			PmStatusResultBodyVO bodyVo = this.pmIntfcService.status(pmVo.getUuid(), restHeaders);
			logger.debug("[bodyVo] id = " + bodyVo.getId() +", status="+ bodyVo.getStatusCode());

			String errmsg = "";
			if(!pmVo.getUuid().equals(bodyVo.getId())){
				errmsg = OprConstant.ERROR_MSG_PM_NOT_EQUALS_REQ_PM + ", Req ID="+ pmVo.getUuid() + ", res ID="+ bodyVo.getId();
			}else if(!OprConstant.PM_STAT_CD_OFF.equals(bodyVo.getStatusCode())  ){
				errmsg = OprConstant.ERROR_MSG_PM_INVALID_STATUS + ", ID="+ bodyVo.getId() + ", STATUS="+ bodyVo.getStatusCode();
			}else if(OprConstant.PM_STAT_CD_OFF.equals(bodyVo.getStatusCode()) ){
				logger.debug("[updatePmActive] uuid = " + pmVo.getUuid() +",  restHeaders = " + new Gson().toJson(restHeaders));
				pmIntfcService.active(pmVo.getUuid(),  getRestHeaders(pmVo));
				return getSuccessProcResult(OprConstant.SUCCESS_MSG, null, pmVo);
			}
			return getFailProcResult(OprConstant.ERROR_MSG  + "\n"+errmsg);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG + "\n"+e.getMessage());
		}
	}

	/**
	 * 물리서버 비활성 (연계)
	 *  - 가상서버 존재 여부 확인 필요.
	 * @param rrPrVo
	 * @param bindResult
	 * @return
	 */
	@OperateLog(action="물리서버 비활성", desc="물리서버 비활성", params={"pmSeq"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updatePmDeactive.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updatePmDeactivate(@ModelAttribute("pmSeq") BigDecimal pmSeq, BindingResult bindResult) {
		try{
			PmVo pmVo =  pmService.selectPm(pmSeq);
			RestHeaders restHeaders = getRestHeaders(pmVo);
			logger.debug("[updatePmDeactivate] uuid = " + pmVo.getUuid() +",  restHeaders = " + new Gson().toJson(restHeaders));
			PmStatusResultBodyVO bodyVo = this.pmIntfcService.status(pmVo.getUuid(), restHeaders);
			logger.debug("[bodyVo] id = " + bodyVo.getId() +", status="+ bodyVo.getStatusCode());

			String errmsg = "";
			if(!pmVo.getUuid().equals(bodyVo.getId())){
				errmsg = OprConstant.ERROR_MSG_PM_NOT_EQUALS_REQ_PM + ", Req ID="+ pmVo.getUuid() + ", res ID="+ bodyVo.getId();
			}else if(!OprConstant.PM_STAT_CD_UP.equals(bodyVo.getStatusCode())  ){
				errmsg = OprConstant.ERROR_MSG_PM_INVALID_STATUS + ", ID="+ bodyVo.getId() + ", STATUS="+ bodyVo.getStatusCode();
			}else if( OprConstant.PM_STAT_CD_UP.equals(bodyVo.getStatusCode())  &&  toInt(bodyVo.getVirtualServerCount()) !=0 ){
				errmsg = OprConstant.ERROR_MSG_PM_HAVING_VM + ", VM 수량="+ bodyVo.getVirtualServerCount() ;
			}else if( OprConstant.PM_STAT_CD_UP.equals(bodyVo.getStatusCode())  &&  toInt(bodyVo.getVirtualServerCount()) ==0 ){
				logger.debug("[updatePmDeactive] uuid = " + pmVo.getUuid() +",  restHeaders = " + new Gson().toJson(restHeaders));
				pmIntfcService.deactive(pmVo.getUuid(), restHeaders);
				return getSuccessProcResult(OprConstant.SUCCESS_MSG, null, pmVo);
			}
			return getFailProcResult(OprConstant.ERROR_MSG  + "\n"+errmsg);
		}catch(HttpServerErrorException e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG +"\n"+ e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG +"\n"+ e.getResponseBodyAsString());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return getFailProcResult(OprConstant.ERROR_MSG);
		}
	}

	private int toInt(String value){
		try{
			return Integer.parseInt(value);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return 0;
		}
	}

	/**
	 * rest header 조회
	 * @param pmVo
	 * @return
	 */
	private RestHeaders getRestHeaders(PmVo pmVo ){
		RestHeaders restHeaders = new RestHeaders();
		restHeaders.setAreaId(pmVo.getRegionId());
		restHeaders.setZoneId(pmVo.getZoneId());
		restHeaders.setNetworkId(pmVo.getNetClCd());
		restHeaders.setManagerId(pmVo.getRsrcPoolId());
		restHeaders.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
		return restHeaders;
	}


}
