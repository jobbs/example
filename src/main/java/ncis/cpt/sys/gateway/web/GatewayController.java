/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewayController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.gateway.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.gateway.service.GatewayService;
import ncis.cpt.sys.gateway.vo.GatewaySearchVo;
import ncis.cpt.sys.gateway.vo.GatewayVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 박봉춘
 *
 */
@Controller("GatewayController")
@RequestMapping(value = "/cpt/sys/gateway")
public class GatewayController extends BaseController {

	@Resource(name="GatewayService")
	GatewayService gatewayService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * API-Gateway 접속정보 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectGatewayList.do")
	public String selectGatewayList(HttpServletRequest request, Model model, GatewaySearchVo searchVo) {

		List<GatewayVo> list = gatewayService.selectGatewayList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}


   @RequestMapping(value = "/selectGatewayHealthCheck.do")
   @ResponseBody
    public ProcResultVo selectGatewayHealthCheck(HttpServletRequest request, Model model,
            @RequestParam(required=true)String regionId) throws Exception {

       ProcResultVo result = new ProcResultVo();
       result.setData(gatewayService.selectGatewayHealthCheck(regionId));
       return result;
    }


	/**
	 * API-Gateway 접속정보 상세 조회
	 * @param request
	 * @param model
	 * @param gatewaySeq
	 * @return
	 */
	@RequestMapping(value = "/selectGateway.do")
	public String selectGateway(HttpServletRequest request, Model model, @RequestParam("gatewaySeq") Long gatewaySeq) {

	    GatewayVo gateway = gatewayService.selectGateway(gatewaySeq);
		if( ObjectUtils.isEmpty(gateway) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("vo", gateway);

		return portalTilesView(request);

	}

	/**
	 * API-Gateway 접속정보 등록 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertGateway.do")
	public String insertGatewayView(HttpServletRequest request, Model model) {
		model.addAttribute("title", "API-Gateway 접속정보 등록");
		model.addAttribute("vo", new GatewayVo());

		return portalTilesView(request, "formGateway");
	}


	/**
	 * API-Gateway 접속정보 등록 프로세스
	 * @param gatewayVo
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = "/insertGateway.do", method=RequestMethod.POST)
	@OperateLog(action = "API-Gateway 접속정보 관리 등록", desc = "API-Gateway 접속정보 관리 내용 등록 처리", params = { "gatewayNm" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertGateway(@ModelAttribute("vo") GatewayVo gatewayVo, BindingResult bindResult) {

		ProcResultVo result = getBindingResult(gatewayVo, bindResult, InsertProc.class);
		if (result.isSuccess()) {

			//RegionId 체크
			if( gatewayService.selectRegionCnt(gatewayVo.getRegionId(), null) > 0) {
				return getFailProcResult("동일한 센터정보가 등록되어 있습니다.");
			}

			gatewayVo.setRegUserId(getUserId());
			gatewayVo.setUpdtUserId(getUserId());

			gatewayService.insertGateway(gatewayVo);

			result.addMessage("API-Gateway 접속정보를 저장하였습니다.");
			result.setProcType("insert");
		}

		return result;

	}

	/**
	 * API-Gateway 접속정보 수정화면 호출
	 * @param request
	 * @param model
	 * @param gatewaySeq
	 * @return
	 */
	@RequestMapping(value = "/updateGateway.do", method = RequestMethod.GET)
	public String updateGatewayView(HttpServletRequest request, Model model, @RequestParam("gatewaySeq") Long gatewaySeq, GatewaySearchVo searchVo) {

		GatewayVo gateway = gatewayService.selectGateway(gatewaySeq);
		if( ObjectUtils.isEmpty(gateway) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }
		model.addAttribute("title", "API-Gateway 접속정보 수정");
		model.addAttribute("vo", gateway);
		return portalTilesView(request, "formGateway");
	}


	/**
	 * API-Gateway 접속정보 수정 프로세스
	 * @param gatewayVo
	 * @return
	 */
	@RequestMapping(value="/updateGateway.do", method=RequestMethod.POST)
	@OperateLog(action="API-Gateway 접속정보 수정", desc="API-Gateway 접속정보 내용 수정처리", params={"gatewayNm"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateGateway(@ModelAttribute("vo") GatewayVo gatewayVo, BindingResult bindResult) {

		ProcResultVo result = getBindingResult(gatewayVo, bindResult, InsertProc.class);
		if (result.isSuccess()) {
			//RegionId 체크
			if( gatewayService.selectRegionCnt(gatewayVo.getRegionId(), gatewayVo.getGatewaySeq()) > 0) {
				return getFailProcResult("동일한 센터정보가 등록되어 있습니다.");
			}

			gatewayVo.setUpdtUserId(getUserName());

			gatewayService.updateGateway(gatewayVo);

			result.addMessage("API-Gateway 접속정보를 저장하였습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * API-Gateway 접속정보 삭제
	 * @param gatewaySeq
	 * @return
	 */
	@RequestMapping(value="/deleteGateway.do", method=RequestMethod.POST)
	@OperateLog(action="API-Gateway 접속정보 삭제", params={"gatewaySeq"}, desc="API-Gateway 접속정보 내용 삭제 처리")
	@ResponseBody
	public ProcResultVo delete(@RequestParam("gatewaySeq") Long gatewaySeq) {
		gatewayService.deleteGateway(gatewaySeq);
		return getSuccessProcResult("API-Gateway 접속정보를 삭제하였습니다.", "delete");
	}
}
