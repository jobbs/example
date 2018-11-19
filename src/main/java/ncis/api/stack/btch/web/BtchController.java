/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchController.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     정승용         v1.0             최초생성
 *
 */
package ncis.api.stack.btch.web;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.api.stack.btch.service.BtchService;
import ncis.api.stack.btch.vo.BtchVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 정승용
 *
 */
@Controller
@RequestMapping(value="/api/stack/btch")
public class BtchController extends BaseController {

	@Resource(name="btchService")
	BtchService btchService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * 배치관리 수집주기 상세
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectBtch.do")
	public String selectBtch(HttpServletRequest request, Model model) throws Exception {
		/** 배치관리 조회 */
		List<BtchVo> btchList = btchService.selectBtch();

		/** 배치정보 삭제주기 조회 */
		List<BtchVo> btchDelList = btchService.selectBtchInfoDel();

		model.addAttribute("btchList", btchList);
		model.addAttribute("btchDelList", btchDelList);

		return apiTilesView(request);
	}

	/**
	 * 배치관리 수집주기 수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateBtch.do", method=RequestMethod.POST)
	@OperateLog(action = "배치 수집주기 수정", desc = "배치 수집주기 수정 처리", params = { "btchVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateBtch(@ModelAttribute("btchVo") BtchVo btchVo,
			BindingResult bindResult) throws Exception {
		// validate 체크
		ProcResultVo result = getBindingResult(btchVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {
			btchService.updateBtch(btchVo);

			result.addMessage("수정되었습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * 배치정보 삭제주기 수정
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateBtchInfoDel.do", method=RequestMethod.POST)
	@OperateLog(action = "배치정보 삭제주기 수정", desc = "배치정보 삭제주기 수정 처리", params = { "delBtchVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateBtchInfoDel(@ModelAttribute("delBtchVo") BtchVo delBtchVo,
			BindingResult bindResult) throws Exception {
		// validate 체크
		ProcResultVo result = getBindingResult(delBtchVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {
			btchService.updateBtchInfoDel(delBtchVo);

			result.addMessage("수정되었습니다.");
			result.setProcType("update");
		}

		return result;
	}

}
