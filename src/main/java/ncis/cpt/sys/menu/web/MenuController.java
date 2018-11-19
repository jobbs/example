/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.menu.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.menu.service.MenuService;
import ncis.cpt.sys.menu.vo.MenuRoleVo;
import ncis.cpt.sys.menu.vo.MenuVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/sys/menu")
public class MenuController extends BaseController {

	@Resource(name="menuService") MenuService menuService;

	/**
	 * 메뉴관리 Index
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/selectMenuList.do")
	public String selectMenuList(HttpServletRequest request) {
		return portalTilesView(request);
	}

	/**
	 * 메뉴 목록을 Tree 형태로 호출
	 * @param parentSeq
	 * @return
	 */
	@RequestMapping(value="/selectMenuListTree.do")
	@ResponseBody
	public List<TreeNode<Long,MenuVo>> selectMenuListTree(@RequestParam(required=false)Long parentSeq) {
		Tree<Long,MenuVo> tree = menuService.selectMenuListTree(parentSeq, false);
		return tree.getRoot().getChildren();
	}

	/**
	 * 메뉴 상세 조회
	 * @param request
	 * @param model
	 * @param menuSeq
	 * @return
	 */
	@RequestMapping(value="/selectMenu.do")
	public String selectMenu(HttpServletRequest request, Model model, @RequestParam(required=true)Long menuSeq) {

		MenuVo menu = menuService.selectMenu(menuSeq);
		model.addAttribute("vo", menu);
		return jstlView(request);
	}

	/**
	 * 메뉴 등록 화면 호출
	 * @param request
	 * @param model
	 * @param parentSeq
	 * @return
	 */
	@RequestMapping(value="/insertMenu.do", method=RequestMethod.GET)
	public String insertMenuView(HttpServletRequest request, Model model, @RequestParam(required=true) Long parentSeq) {

		MenuVo menu = new MenuVo();
		menu.setParentSeq(parentSeq);
		menu.setParent(menuService.selectMenu(parentSeq));
		menu.setMenuPattern(menu.getParent().getMenuPattern());
		menu.setUseYn("Y");
		menu.setPopupYn("N");

		model.addAttribute("vo", menu);
		return jstlView(request,"formMenu");
	}

	/**
	 * 메뉴 등록 프로세스 처리
	 * @param request
	 * @param model
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/insertMenu.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴등록", desc="메뉴등록 처리 호출", params={"menuNm", "menuPattern", "menuFile"})
	@ResponseBody
	public ProcResultVo insertMenu(HttpServletRequest request, Model model,
			@ModelAttribute("vo") MenuVo menu, BindingResult bindingResult) {

		ProcResultVo result = getBindingResult(menu, bindingResult, InsertProc.class);
		if( result.isSuccess() ) {

			if( menuService.selectExistsPattern(menu.getMenuPattern(), null)) {
				return getFailProcResult("중복된 URL 패턴이 존재합니다. URL 패턴은 하나의 메뉴에만 사용가능합니다.");
			}

//			if( menu.getMenuPattern() != null && !menu.getMenuPattern().startsWith(menu.getParent().getMenuPattern()) ) {
//				return getFailProcResult("메뉴 패턴은 상위 메뉴 패턴을 포함하여야 합니다.");
//			}

			MenuVo parent = menuService.selectMenu(menu.getParentSeq());
			menu.setMenuLevel(parent.getMenuLevel()+1);
			menu.setRegUserId(getUserId());
			menu.setUpdtUserId(getUserId());
			menuService.insertMenu(menu);

			result.addMessage("메뉴를 저장하였습니다.");
			result.setProcType("insert");
		}

		return result;
	}

	/**
	 * 메뉴 수정 화면 호출
	 * @param request
	 * @param model
	 * @param menuSeq
	 * @return
	 */
	@RequestMapping(value="/updateMenu.do", method=RequestMethod.GET)
	public String updateMenuView(HttpServletRequest request, Model model, @RequestParam(required=true)Long menuSeq) {

		MenuVo menu = menuService.selectMenu(menuSeq);
		model.addAttribute("vo", menu);
		return jstlView(request,"formMenu");
	}

	/**
	 * 메뉴 수정 프로세스 처리
	 * @param request
	 * @param model
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/updateMenu.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴수정", desc="메뉴수정 처리 호출", params={"menuNm", "menuPattern", "menuFile"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateMenu(HttpServletRequest request, Model model,
			@ModelAttribute("menu") MenuVo menu, BindingResult bindingResult) {

		ProcResultVo result = getBindingResult(menu, bindingResult, UpdateProc.class);
		if( result.isSuccess() ) {

			if( menuService.selectExistsPattern(menu.getMenuPattern(), menu.getMenuSeq())) {
				return getFailProcResult("중복된 URL 패턴이 존재합니다. URL 패턴은 하나의 메뉴에만 사용가능합니다.");
			}

//			if( menu.getMenuPattern() != null && !menu.getMenuPattern().startsWith(menu.getParent().getMenuPattern()) ) {
//				return getFailProcResult("메뉴 패턴은 상위 메뉴 패턴을 포함하여야 합니다.");
//			}

			menu.setUpdtUserId(getUserId());
			menuService.updateMenu(menu);

			result.addMessage("메뉴를 저장하였습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * 메뉴삭제처리
	 * @param request
	 * @param model
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/deleteMenu.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴삭제", desc="메뉴삭제 처리 호출", params={"menuNm", "menuPattern", "menuFile"}, actionType=ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteMenu(HttpServletRequest request, @RequestParam(required=true) Long menuSeq) {

		//하위 메뉴가 있는지 확인
		List<MenuVo> menus = menuService.selectChildMenu(menuSeq);

		if( null != menus && menus.size() > 0 ) {
			return getFailProcResult("하위메뉴가 존재합니다. \n\n하위메뉴를 먼저 삭제하여 주시기 바랍니다.");
		}

		menuService.deleteMenu(menuSeq);
		return getSuccessProcResult("delete");
	}

	/**
	 * 권한 목록 팝업 호출
	 * @param request
	 * @param model
	 * @param menuSeq
	 * @return
	 */
	@RequestMapping(value="/insertMenuRole.do", method=RequestMethod.GET)
	public String insertMenuRoleView(HttpServletRequest request, Model model, @RequestParam(required=true) Long menuSeq) {

		MenuVo menu = menuService.selectMenu(menuSeq);

		String title = new StringBuffer().append(menu.getMenuNm()).append(" ").append("권한 부여").toString();

		menu.setMenuRoleList(menuService.selectMenuRoleList(menuSeq));

		model.addAttribute("title", title);
		model.addAttribute("vo", menu);
		return popup(request, "formMenuRole");
	}

	/**
	 * 메뉴에 권한 등록 처리
	 * @param request
	 * @param model
	 * @param menu
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/insertMenuRole.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴 권한 등록", desc="메뉴에 권한 부여 처리", params={"menuName"})
	@ResponseBody
	public ProcResultVo insertMenuRole(HttpServletRequest request, Model model, @ModelAttribute("vo") MenuVo menu) {

		menu.setUpdtUserId(getUserId());
		menuService.insertMenuRole(menu);
		return getSuccessProcResult("메뉴 권한을 저장하였습니다.","insertMenuRole");
	}

	/**
	 * 메뉴 권한 복제 팝업 호출
	 * @param request
	 * @param model
	 * @param menuSeq
	 * @return
	 */
	@RequestMapping(value="/updateCopyMenuRole.do", method=RequestMethod.GET)
	public String updateCopyMenuRoleView(HttpServletRequest request, Model model, @RequestParam(required=true) Long menuSeq) {

		MenuVo menu = menuService.selectMenu(menuSeq);
		String title = new StringBuffer().append(menu.getMenuNm()).append(" ").append("권한 복제").toString();

		model.addAttribute("title", title);
		model.addAttribute("vo", menu);

		return popup(request);
	}

	/**
	 * 메뉴에 속한 권한 목록 조회
	 * @param request
	 * @param model
	 * @param menuSeq
	 * @return
	 */
	@RequestMapping(value="/selectMenuRoleList.do")
	public String selectMenuRoleList(HttpServletRequest request, Model model, @RequestParam(required=true)Long menuSeq) {

		List<MenuRoleVo> menuRoleList = menuService.selectMenuRoleList(menuSeq);
		model.addAttribute("menuRoleList", menuRoleList);
		model.addAttribute("menuSeq", menuSeq);
		return jstlView(request);
	}

	/** <pre>
	 * 메뉴 권한를 복제한다.
	 * </pre>
	 * @param request
	 * @param menuSeq
	 * @param sourceMenuSeq
	 * @return
	 */
	@RequestMapping(value="/updateCopyMenuRole.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴 권한 복제", desc="메뉴에 권한 복제 처리", params={"targetMenuSeq", "sourceMenuSeq"})
	@ResponseBody
	public ProcResultVo updateCopyMenuRole(HttpServletRequest request,
			@RequestParam(required=true) Long targetMenuSeq,
			@RequestParam(required=true) Long sourceMenuSeq){

		menuService.updateCopyMenuRole(sourceMenuSeq, targetMenuSeq, getUserId());
		return getSuccessProcResult("메뉴 권한 복제를 완료하였습니다.","updateCopyMenuRole");
	}



	/** <pre>
	 * 메뉴순서를 위로 이동시킨다.
	 * </pre>
	 *
	 * @param request
	 * @param menuSeq
	 * @param parentSeq
	 * @return
	 */
	@RequestMapping(value="/updateMenuOrderUp.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴 순서변경", desc="메뉴를 한단계 위로 이동 처리", params={"menuSeq"})
	@ResponseBody
	public ProcResultVo updateMenuOrderUp(HttpServletRequest request,
			@RequestParam(required=true) Long menuSeq,
			@RequestParam(required=true) Long parentSeq){

		ProcResultVo procResultVO = new ProcResultVo();
		menuService.updateMenuOrderUp(menuSeq, parentSeq);
		procResultVO.setSuccess(true);
		procResultVO.setData("before");
		return procResultVO;
	}

	/** <pre>
	 * 메뉴순서를 아래로 이동시킨다.
	 * </pre>
	 *
	 * @param request
	 * @param menuSeq
	 * @param parentSeq
	 * @return
	 */
	@RequestMapping(value="/updateMenuOrderDown.do", method=RequestMethod.POST)
	@OperateLog(action="메뉴 순서변경", desc="메뉴를 한단계 아래로 이동 처리", params={"menuSeq"})
	@ResponseBody
	public ProcResultVo updateMenuOrderDown(HttpServletRequest request,
			@RequestParam(required=true) Long menuSeq,
			@RequestParam(required=true) Long parentSeq){

		ProcResultVo procResultVO = new ProcResultVo();
		menuService.updateMenuOrderDown(menuSeq, parentSeq);
		procResultVO.setSuccess(true);
		procResultVO.setData("after");
		return procResultVO;
	}
}
