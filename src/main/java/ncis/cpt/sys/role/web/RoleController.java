/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleController.java
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
package ncis.cpt.sys.role.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.service.CommonService;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.vo.CodeVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.menu.vo.MenuVo;
import ncis.cpt.sys.role.service.RoleService;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cpt/sys/role")
public class RoleController extends BaseController {

	@Resource(name="roleService")
	private RoleService roleService;

	@Resource(name="commonService")
	private CommonService commonService;

	/**
	 * 롤 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectRoleList.do")
	public String selectRoleList(HttpServletRequest request, Model model, RoleSearchVo searchVo){

        List<RoleVo> list = roleService.selectRoleList(searchVo);

        List<CodeVo> codes = commonService.selectCodeList("090", "AUTHCD");
        List<CodeVo> tmpCodes = new ArrayList<CodeVo>();
        for (CodeVo codeVo : codes) {
        	if( !"SYSADM".equals(codeVo.getCd()) ) {
        		tmpCodes.add(codeVo);
        	}
		}


        model.addAttribute("list", list);
        model.addAttribute("codes", tmpCodes);
        model.addAttribute("searchVo", searchVo);

	    return portalTilesView(request);

	}

	/**
	 * 롤 추가 프로세스
	 * @param request
	 * @param model
	 * @param roleVo
	 * @return
	 */
	@RequestMapping(value="/insertRole.do", method=RequestMethod.POST)
	@OperateLog(action="롤등록", desc="롤 등록 처리", params={"roleCd", "roleNm"})
	@ResponseBody
	public ProcResultVo insertRole(HttpServletRequest request,
			@ModelAttribute("role") RoleVo roleVo, BindingResult bindingResult){

		ProcResultVo result = getBindingResult(roleVo, bindingResult, InsertProc.class);
		if( result.isSuccess() ) {

			result.setProcType("insert");

			RoleVo roleTmp = roleService.selectRole(roleVo.getRoleCd().trim());
			if( null == roleTmp ) {

				roleVo.setRegUserId(getUserId());
				roleVo.setUpdtUserId(getUserId());
				roleService.insertRole(roleVo);
				result.addMessage("롤을 저장하였습니다.");
				result.setSuccess(true);

			} else {
				result.addMessage("롤코드가 중복되었습니다. 다른 롤코드를 사용하시기 바랍니다.");
				result.setSuccess(false);
			}
		}

		return result;
	}

	/**
	 * 롤 수정 프로세스
	 * @param request
	 * @param model
	 * @param roleVo
	 * @return
	 */
	@RequestMapping(value="/updateRole.do", method=RequestMethod.POST)
	@OperateLog(action="롤 수정", desc="롤 수정 처리", params={"roleCd", "roleNm"})
	@ResponseBody
	public ProcResultVo updateRole(HttpServletRequest request,
			@ModelAttribute("role") RoleVo roleVo, BindingResult bindingResult){

		ProcResultVo result = getBindingResult(roleVo, bindingResult, UpdateProc.class);
		if( result.isSuccess() ) {
			roleVo.setRegUserId(getUserId());
			roleVo.setUpdtUserId(getUserId());
			roleService.updateRole(roleVo);
			result.setProcType("update");
			result.setSuccess(true);
		}

		return result;
	}

	/**
	 * 롤 삭제 프로세스
	 * @param request
	 * @param model
	 * @param roleVo
	 * @return
	 */
	@RequestMapping(value="/deleteRole.do", method=RequestMethod.POST)
	@OperateLog(action="롤 삭제", desc="롤 삭제 처리", params={"roleCd"})
	@ResponseBody
	public ProcResultVo deleteRole(HttpServletRequest request, @RequestParam(required=true) String roleCd){

		roleService.deleteRole(roleCd);
		return getSuccessProcResult("롤을 삭제하였습니다.","delete");
	}


	/**
	 * 롤 메뉴 권한 목록화면
	 * @param request
	 * @param model
	 * @param roleCd
	 * @return
	 */
	@RequestMapping(value="/selectRoleMenuList.do", method=RequestMethod.GET)
	public String selectRoleMenuList(HttpServletRequest request,
			Model model, @RequestParam(required=true)String roleCd){

	    RoleVo role = roleService.selectRole(roleCd.toUpperCase().trim());
		List<MenuVo> menus = roleService.selectRoleMenu(roleCd.toUpperCase().trim());
		model.addAttribute("menus", menus);
		model.addAttribute("role", role);

		return jstlView(request);
	}


	@RequestMapping(value="/updateRoleMenu.do", method=RequestMethod.POST)
    @ResponseBody
    public ProcResultVo updateRoleMenu(HttpServletRequest request,
            @ModelAttribute("role") RoleVo roleVo){

	    roleVo.setRegUserId(getUserId());
	    roleService.updateRoleMenu(roleVo);
        return getSuccessProcResult();
    }

}
