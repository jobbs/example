/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssController.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.opr.catalg.service.RoutingScriptService;
import ncis.cpt.opr.catalg.vo.RoutingScriptSearchVo;
import ncis.cpt.opr.catalg.vo.RoutingScriptVo;
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
 * @author 이화영
 *
 */
@Controller
@RequestMapping(value="/cpt/opr/catalg/script")
public class RoutingScriptController extends BaseController{

	@Resource(name="routingScriptService")
	private RoutingScriptService routingScriptService;


	/**
	 * 스태틱라우팅 스크립트 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectScriptList.do")
	public String selectPrcssList(HttpServletRequest request, Model model, RoutingScriptSearchVo searchVo){

		List<RoutingScriptVo> list = routingScriptService.selectScriptList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return portalTilesView(request);
	}

	/**
	 * 스태틱라우팅 스크립트 상세 조회
	 * @param request
	 * @param model
	 * @param routingScriptSeq
	 * @return
	 */
	@RequestMapping(value="/selectScript.do")
	public String selectPrcss(HttpServletRequest request, Model model, @RequestParam(required = true) Long sRoutingScriptSeq){

		RoutingScriptVo vo = routingScriptService.selectScript(sRoutingScriptSeq);

		if( ObjectUtils.isEmpty(vo) )
			throw new DataNotFoundException("스태틱라우팅 스크립트 데이터가 없습니다.");

		model.addAttribute("vo", vo);
		return portalTilesView(request);
	}

	/**
	 * 스태틱라우팅 스크립트 등록 화면
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertScript.do", method = RequestMethod.GET)
	public String insertScriptView(HttpServletRequest request, Model model) {
		model.addAttribute("vo", new RoutingScriptVo());
		return portalTilesView(request, "formScript");
	}

	/**
	 * 스태틱라우팅 스크립트 등록 프로세스
	 * @param request
	 * @param routingScript
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = "/insertScript.do", method = RequestMethod.POST)
	@OperateLog(action = "스태틱라우팅 스크립트 등록", desc = "스태틱라우팅 스크립트 등록 처리", params = { "osTyCd", "osVer", "script" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertScript(HttpServletRequest request, @ModelAttribute("vo") RoutingScriptVo routingScript, BindingResult bindResult) {

		//validation 체크
        ProcResultVo result = getBindingResult(routingScript, bindResult, InsertProc.class);

        if (result.isSuccess()) {

        	boolean existRouting = routingScriptService.selectExistRoutingScript(
        			routingScript.getOsTyCd(),
        			routingScript.getOsVer(),
        			null
        		);
        	if( existRouting )
        		return getFailProcResult("동일한 OS타입의 OS버전 정보가 존재합니다.");

        	routingScript.setRegUserId(getUserId());
        	routingScript.setUpdtUserId(getUserId());

        	routingScriptService.insertScript(routingScript);
            result.setProcType("insert");
        }

	    return result;

	}

	/**
	 * 스태틱라우팅 스크립트 수정 화면
	 * @param request
	 * @param routingScriptSeq
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateScript.do", method = RequestMethod.GET)
	public String updateScriptView(HttpServletRequest request, @RequestParam(required=true)Long sRoutingScriptSeq, Model model) {

		RoutingScriptVo vo = routingScriptService.selectScript(sRoutingScriptSeq);
		if( ObjectUtils.isEmpty(vo) )
			throw new DataNotFoundException("스태틱라우팅 스크립트 데이터가 없습니다.");

		model.addAttribute("vo", vo);
		return portalTilesView(request, "formScript");
	}

	/**
	 * 스태틱라우팅 스크립트 수정 프로세스
	 * @param request
	 * @param routingScript
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = "/updateScript.do", method = RequestMethod.POST)
	@OperateLog(action = "스태틱라우팅 스크립트 수정", desc = "스태틱라우팅 스크립트 수정 처리", params = { "osTyCd", "osVer", "script" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateScript(HttpServletRequest request, @ModelAttribute("vo") RoutingScriptVo routingScript, BindingResult bindResult) {

		//validation 체크
        ProcResultVo result = getBindingResult(routingScript, bindResult, UpdateProc.class);

        if (result.isSuccess()) {

        	boolean existRouting = routingScriptService.selectExistRoutingScript(
        			routingScript.getOsTyCd(),
        			routingScript.getOsVer(),
        			routingScript.getsRoutingScriptSeq()
        		);
        	if( existRouting )
        		return getFailProcResult("동일한 OS타입의 OS버전 정보가 존재합니다.");

        	routingScript.setUpdtUserId(getUserId());
        	routingScriptService.updateScript(routingScript);
            result.setProcType("update");
        }

	    return result;
	}

	@RequestMapping(value = "/deleteScript.do", method = RequestMethod.POST)
	@OperateLog(action = "스태틱라우팅 스크립트 삭제", desc = "스태틱라우팅 스크립트 삭제 처리", params = { "routingScriptSeq" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteScript(HttpServletRequest request, @RequestParam(required=true)Long sRoutingScriptSeq) {
		routingScriptService.deleteScript(sRoutingScriptSeq);
		return getSuccessProcResult("스태틱라우팅 스크립트를 삭제하였습니다.", "delete");
	}

}
