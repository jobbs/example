/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwkController.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.config.OprConstant;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqNetwkService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkSlbConfIpReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

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

@Controller
@RequestMapping(value="/cpt/opr/req/rsrcreq")
public class RsrcReqNetwkController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqNetwkController.class);
	private final String RR_SLB_CONF = "SLB설정요청";

	@Resource(name="rsrcReqNetwkService")
	protected RsrcReqNetwkService rsrcReqNetwkService;

	/**
	 * SLB 설정 요청 생성 조회
	 * @param request
	 * @param model
	 * @param rsrcReqNo
	 * @return
	 */
	@RequestMapping(value="/formRsrcReqSlbCre.do")
	public String selectRserReqSlbCreView(HttpServletRequest request, Model model, @RequestParam("schRsrcReqNo") String rsrcReqNo) {
		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqNo);

			RsrcReqVo  rsrcReqVo =  this.rsrcReqNetwkService.selectRsrcReqInfo(rsrcReqNo);
			List<RsrcReqNetwkVo>  rsrcReqNetwkList =  this.rsrcReqNetwkService.selectRsrcReqNetwkList(searchVo);
			List<RsrcReqNetwkSlbConfIpReqVo>  rsrcReqNetwkSlbConfIpReqList =  this.rsrcReqNetwkService.selectRsrcReqNetwkSlbConfIpReqList(searchVo);

			model.addAttribute("title",RR_SLB_CONF);
			model.addAttribute("rrVo", rsrcReqVo);
			model.addAttribute("rrnwVoList", rsrcReqNetwkList);
			model.addAttribute("rrnwSlbciqVoList", rsrcReqNetwkSlbConfIpReqList);
			return portalTilesView(request, "formRsrcReqSlbCre");
		}catch(Exception e){
			logger.error(e.toString(),e);
			model.addAttribute("errormsg", e.getMessage());
			return portalTilesView(request, "viewRsrcReqError");
		}
	}

	/**
	 * 자원관리상세_네트워크 실행
	 * @param rsrcReqVo
	 * @param bindResult
	 * @return
	 */
	@OperateLog(action="자원요청상세_네트워크 실행", desc="네트워크의 자원요청 실행", params={"rrVo"}, actionType= ActionType.UPDATE)
	@RequestMapping(value="/updateRsrcReqSlbCreExe.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateRsrcReqSlbCreExe(@ModelAttribute("rrVo") RsrcReqVo rrVo, BindingResult bindResult) {
		logger.debug("자원관리상세_네트워크 실행 >> rsrcReqVo="+rrVo);
		ProcResultVo result = getBindingResult(rrVo, bindResult, UpdateProc.class);

		String reqPrcssStatNm ="실행";
		if (result.isSuccess()) {
			try {
				RsrcReqNetwkVo rsrcReqNetwkVo = new RsrcReqNetwkVo();
				rsrcReqNetwkVo.setRsrcReqNo(rrVo.getRsrcReqNo());
				rsrcReqNetwkVo.setRjctTyCd(rrVo.getRjctTyCd());
				rsrcReqNetwkVo.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT);
				String resultmessage = this.rsrcReqNetwkService.updateRsrcReqNetwkSlbExe(rsrcReqNetwkVo, getUserId());
				result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);
				result.addMessage( "["+reqPrcssStatNm+"] " + resultmessage);
				result.setSuccess(true);
			}catch(Exception e){
				logger.error(e.toString(),e);
				result.setSuccess(false);
				result.addMessage("["+reqPrcssStatNm+"] " + OprConstant.RSRC_EXEC_FAIL_MSG   + ", error="+ e.getMessage());
			}
		}
		return result;
	}


	/**
	 * 자원요청상세_네트워크 반려
	 * @param rsrcReqVo
	 * @param bindResult
	 * @return
	 */
	@OperateLog(action="자원요청상세_네트워크 반려", desc="네트워크의 자원요청 반려", params={"rrVo"}, actionType= ActionType.UPDATE)
	@RequestMapping(value = "/updateRsrcReqNetwkRjct.do", method = RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateRsrcReqNetwkRjct(@ModelAttribute("rrVo") RsrcReqVo rrVo, BindingResult bindResult) {
		ProcResultVo result = getBindingResult(rrVo, bindResult, UpdateProc.class);
		result.setProcType(OprConstant.RSRC_PROC_TYPE_UPDATA);

		logger.debug("rsrcReqVo getRsrcReqNo="+ rrVo.getRsrcReqNo()
					+", getRsrcReqNo=" + rrVo.getRsrcReqTyCd()
					+", getRjctTyCd=" + rrVo.getRjctTyCd()
					+", getRjctReasn=" + rrVo.getRjctReasn()
					);
		String reqPrcssStatNm ="반려";
		if(result.isSuccess()){
			try{
				RsrcReqNetwkVo rsrcReqNetwkVo = new RsrcReqNetwkVo();
				rsrcReqNetwkVo.setRsrcReqNo(rrVo.getRsrcReqNo());
				rsrcReqNetwkVo.setRsrcReqTyCd(rrVo.getRsrcReqTyCd());
				rsrcReqNetwkVo.setRjctTyCd(rrVo.getRjctTyCd());
				rsrcReqNetwkVo.setRjctReasn(rrVo.getRjctReasn());
				rsrcReqNetwkVo.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_RJCT);
				String resultmessage = this.rsrcReqNetwkService.updateRsrcReqNetwkRjct(rsrcReqNetwkVo, getUserId());
				result.setSuccess(true);
				result.addMessage( "["+reqPrcssStatNm+"] " +resultmessage);
			}catch(Exception e){
				logger.error(e.toString(),e);
				result.setSuccess(false);
				result.addMessage("["+reqPrcssStatNm+"] " + OprConstant.RSRC_EXEC_FAIL_MSG);
			}
		}
		return result;
	}


}


