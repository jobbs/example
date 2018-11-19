/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserController.java
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
package ncis.cpt.sys.user.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.CmInsttUser;
import ncis.cmn.entity.CmJobUser;
import ncis.cmn.entity.CmRsrcPoolUser;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.role.service.RoleService;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserInsttVo;
import ncis.cpt.sys.user.vo.UserJobVo;
import ncis.cpt.sys.user.vo.UserPoolVo;
import ncis.cpt.sys.user.vo.UserRoleVo;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cpt/sys/user")
public class UserController extends BaseController {

	@Resource(name="userService")
	UserService userService;

	@Resource(name="roleService")
	RoleService roleService;

	/**
	 * 사용자 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectUserList.do")
	public String selectUserList(HttpServletRequest request, Model model, UserSearchVo searchVo) {

		List<UserVo> list = userService.selectUserList(searchVo);

		List<RoleVo> roles = roleService.selectRoleAllList(new RoleSearchVo());

		model.addAttribute("list", list);
		model.addAttribute("roles", roles);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
     * 사용자 목록 조회
     * @param request
     * @param model
     * @param searchVo
     * @return
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
     */
    @RequestMapping(value="/selectDownloadUser.do")
    public void selectDownloadUser(HttpServletRequest request, HttpServletResponse response, UserSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        //Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("userId", "사용자ID");
        header.put("userNm", "사용자명");
        header.put("institutionNm", "부처");
        header.put("orgnztNm", "조직");
        header.put("ofcpsNm", "직위");
        header.put("sysAuthrTyId", "시스템권한유형");
        header.put("roleNm", "권한");
        header.put("telno", "전화번호");
        header.put("lxtnNo", "내선");
        header.put("mobile", "핸드폰");
        header.put("email", "이메일");
        header.put("rcntLoginDttmPattern", "nTOPS 최근접속일시");
        header.put("ncmsRcntLoginDttmPattern", "nCMS 최근접속일시");

        List<UserVo> list = userService.selectDownloadUser(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("사용자목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("사용자목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 사용자 상세 정보 조회
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUser.do")
	public String selectUser(HttpServletRequest request, Model model, @RequestParam(required=true) String userId) {

		UserVo user = userService.selectUser(userId);
		if( ObjectUtils.isEmpty(user) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		model.addAttribute("user", user);
		return portalTilesView(request);
	}

	/**
	 * 사용자 상세 정보에 해당 롤 목록 조회
	 * 사용자의 상제 성보 및 사용자가 가지고 있는 권한정보 조회
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUserRoleList.do")
	public String selectUserRoleList(HttpServletRequest request, Model model, @RequestParam(required=true) String userId) {

		List<UserRoleVo> list = userService.selectUserRoleList(userId);

		model.addAttribute("userId", userId);
		model.addAttribute("list", list);
		return jstlView(request);
	}

	/**
	 * 사용자에게 롤 맵핑
	 * @param request
	 * @param model
	 * @param roleVo
	 * @return
	 */
	@RequestMapping(value="/insertUserRole.do", method=RequestMethod.POST)
	@OperateLog(action="사용자 롤 권한 등록", desc="사용자 롤 권한 등록 처리", params={"userId"}, actionType=ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertUserRole(HttpServletRequest request, UserVo userVo){

		userService.insertUserRole(userVo);
		return getSuccessProcResult("사용자 롤 정보를 저장하였습니다.", "insertUserRole");
	}

	/**
	 * 사용자에게 맵핑된 롤 삭제
	 * @param request
	 * @param model
	 * @param roleVo
	 * @return
	 */
	@RequestMapping(value="/deleteUserRole.do", method=RequestMethod.POST)
	@OperateLog(action="사용자 롤 권한 삭제", desc="사용자 롤 권한 삭제 처리", params={"userId", "roleTyCd"}, actionType=ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteUserRole(HttpServletRequest request, UserRoleVo roleUser){

		userService.deleteUserRole(roleUser);
		return getSuccessProcResult("사용자 롤 정보를 삭제하였습니다.", "deleteUserRole");

	}

	/**
	 * 사용자 상세정보에 부처 목록 조회
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUserInsttList.do")
	public String selectUserInsttList(HttpServletRequest request, Model model, @RequestParam(required=true) String userId) {

		List<UserInsttVo> list = null;

		//담당자 롤을 가지고 있는지 여부를 판단하여 없을 경우 등록을 할 수 없도록 처리 한다.
	    boolean isUserRole = userService.selectUserRoleByCodeType(userId, "OPRCHR");
	    if( isUserRole ) {
	        list = userService.selectUserInsttList(userId);
	    }

	    model.addAttribute("userId", userId);
		model.addAttribute("isUserRole", isUserRole);
		model.addAttribute("list", list);
		return jstlView(request);
	}

	/**
	 * 사용자 상세 정보에 부처 맵핑
	 * @param request
	 * @param userVo
	 * @return
	 */
    @RequestMapping(value="/insertUserInstt.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 부처 등록", desc="사용자 부처 등록 처리", params={"userId"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertUserInstt(HttpServletRequest request, UserVo userVo){

        boolean isChargeRole = userService.selectUserRoleByCodeType(userVo.getUserId(), "OPRCHR");
        if( !isChargeRole ) {
            return getFailProcResult("사용자 롤 권한에 담당자 권한이 없습니다. 확인하여 주시기 바랍니다.");
        }

        userService.insertUserInstt(userVo);
        return getSuccessProcResult("사용자 부처 정보를 저장하였습니다.", "insertUserInstt");
    }

    /**
     * 사용자에게 맵핑된 부처 삭제
     * @param request
     * @param userInstt
     * @return
     */
    @RequestMapping(value="/deleteUserInstt.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 부처 삭제", desc="사용자 부처 삭제 처리", params={"userId","institutionId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteUserInstitution(HttpServletRequest request,  CmInsttUser userInstt){

        userService.deleteUserInstt(userInstt);
        return getSuccessProcResult("사용자 업무 정보를 삭제하였습니다.", "deleteUserJob");

    }

	/**
	 * 사용자 상세 정보에 해당 업무 목록 조회
	 * 사용자의 상제 성보 및 사용자가 가지고 있는 업무정보 조회
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUserJobList.do")
	public String selectJobList(HttpServletRequest request, Model model, @RequestParam(required=true) String userId) {

	    List<UserJobVo> list = null;

	    //담당자 롤을 가지고 있는지 여부를 판단하여 없을 경우 등록을 할 수 없도록 처리 한다.
	    boolean isUserRole = userService.selectUserRoleByCodeType(userId, "OPRCHR");
	    if( isUserRole ) {
	        list = userService.selectUserJobList(userId);
	    }

	    model.addAttribute("userId", userId);
	    model.addAttribute("isUserRole", isUserRole);
		model.addAttribute("list", list);
		return jstlView(request);
	}

	 /**
     * 사용자에게 업무 맵핑
     * @param request
     * @param model
     * @param roleVo
     * @return
     */
    @RequestMapping(value="/insertUserJob.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 업무 등록", desc="사용자 업무 등록 처리", params={"userId"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertUserJob(HttpServletRequest request, UserVo userVo){

        boolean isChargeRole = userService.selectUserRoleByCodeType(userVo.getUserId(), "OPRCHR");
        if( !isChargeRole ) {
            return getFailProcResult("사용자 롤 권한에 담당자 권한이 없습니다. 확인하여 주시기 바랍니다.");
        }

        userService.insertUserJob(userVo);
        return getSuccessProcResult("사용자 업무 정보를 저장하였습니다.", "insertUserJob");
    }

    /**
     * 사용자에게 맵핑된 업무 삭제
     * @param request
     * @param model
     * @param roleVo
     * @return
     */
    @RequestMapping(value="/deleteUserJob.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 업무 삭제", desc="사용자 업무 삭제 처리", params={"userId","jobId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteUserJob(HttpServletRequest request,  CmJobUser userJob){

        userService.deleteUserJob(userJob);
        return getSuccessProcResult("사용자 업무 정보를 삭제하였습니다.", "deleteUserJob");

    }

	/**
	 * 사용자 상세 정보에 해당 자원풀 목록 조회
	 * 사용자의 상제 성보 및 사용자가 가지고 있는 자원풀정보 조회
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUserPoolList.do")
	public String selectPoolList(HttpServletRequest request, Model model, @RequestParam(required=true) String userId) {

	    List<UserPoolVo> list = null;

        //담당자 롤을 가지고 있는지 여부를 판단하여 없을 경우 등록을 할 수 없도록 처리 한다.
        boolean isUserRole = userService.selectUserRoleByCodeType(userId, "OPRADM");
        if( isUserRole ) {
            list = userService.selectUserPoolList(userId);
        }

        model.addAttribute("userId", userId);
        model.addAttribute("isUserRole", isUserRole);
        model.addAttribute("list", list);
        return jstlView(request);
	}


	/**
     * 사용자에게 자원풀 맵핑
     * @param request
     * @param model
     * @param roleVo
     * @return
     */
    @RequestMapping(value="/insertUserPool.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 자원풀 등록", desc="사용자 자원풀 등록 처리", params={"userId","rsrcPoolId"}, actionType=ActionType.INSERT)
    @ResponseBody
    public ProcResultVo insertUserPool(HttpServletRequest request, UserVo userVo){

        boolean isChargeRole = userService.selectUserRoleByCodeType(userVo.getUserId(), "OPRADM");
        if( !isChargeRole ) {
            return getFailProcResult("사용자 롤 권한에 운영자 권한이 없습니다. 확인하여 주시기 바랍니다.");
        }

        userService.insertUserPool(userVo);
        return getSuccessProcResult("사용자 자원풀 정보가 저장 되었습니다.", "insertUserPool");
    }

    /**
     * 사용자에게 맵핑된 자원풀 삭제
     * @param request
     * @param model
     * @param roleVo
     * @return
     */
    @RequestMapping(value="/deleteUserPool.do", method=RequestMethod.POST)
    @OperateLog(action="사용자 자원풀 등록", desc="사용자 자원풀 등록 처리", params={"userId","rsrcPoolId"}, actionType=ActionType.DELETE)
    @ResponseBody
    public ProcResultVo deleteUserPool(HttpServletRequest request,  CmRsrcPoolUser userPool){
        userService.deleteUserPool(userPool);
        return getSuccessProcResult("사용자 자원풀 정보를 삭제하였습니다.", "deleteUserPool");

    }
    /**
	 * 사용자관리 등록 화면 호출
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertUser.do")
	public String insertUserView(HttpServletRequest request, Model model) {
		model.addAttribute("title", "사용자등록");
		model.addAttribute("vo", new UserVo());

		return portalTilesView(request, "formUser");
	}


	/**
	 * 사용자 관리 등록 프로세스
	 * @param userVo
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = "/insertUser.do", method=RequestMethod.POST)
	@OperateLog(action = "사용자 관리 등록", desc = "사용자 관리 내용 등록 처리", params = { "userId" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertUser(@ModelAttribute("vo") UserVo userVo, BindingResult bindResult) {

		boolean checkUserId = userService.selectUserId(userVo.getUserId());

		if(checkUserId){
			return getFailProcResult("중복된 아이디 입니다.");
		}

		ProcResultVo result = getBindingResult(userVo, bindResult, InsertProc.class);
		if (result.isSuccess()) {

			userService.insertUser(userVo);

			result.addMessage("사용자정보를 저장하였습니다.");
			result.setProcType("insert");
		}

		return result;

	}

	/**
	 * 사용자정보 수정화면 호출
	 * @param request
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public String updateUserView(HttpServletRequest request, Model model, @RequestParam("userId") String userId, UserSearchVo searchVo) {

		UserVo userVo = userService.selectUser(userId);
		if( ObjectUtils.isEmpty(userVo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

		if( !"Y".equals(userVo.getSysInptYn()) ) {
			throw new DataNotFoundException("nTOPS 연계 사용자이므로 수정할 수 없습니다.");
		}

		model.addAttribute("title", "사용자수정");
		model.addAttribute("vo", userVo);
		return portalTilesView(request, "formUser");
	}


	/**
	 * 사용자정보 수정 프로세스
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/updateUser.do", method=RequestMethod.POST)
	@OperateLog(action="사용자정보 수정", desc="사용자정보 내용 수정처리", params={"userId"}, actionType=ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateUser(@ModelAttribute("vo") UserVo userVo, BindingResult bindResult, @RequestParam("userId") String userId ) {

		ProcResultVo result = getBindingResult(userVo, bindResult, UpdateProc.class);
		if (result.isSuccess()) {
			userVo.setUpdtUserId(getUserId());

			userService.updateUser(userVo);

			result.addMessage("사용자 정보를 저장하였습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * 사용자 정보 삭제
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/deleteUser.do", method=RequestMethod.POST)
	@OperateLog(action="사용자정보 삭제", params={"userId"}, desc="사용자정보 내용 삭제 처리")
	@ResponseBody
	public ProcResultVo deleteUser(@RequestParam("userId") String userId) {
		userService.deleteUser(userId);
		return getSuccessProcResult("사용자정보를 삭제하였습니다.", "delete");
	}

	/**
	 * 사용자ID 중복 체크
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/selectUserIdCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo selectUserIdCheck(@RequestParam("userId") String userId){
		return getSuccessProcResult(null, "userIdCheck", userService.selectUserId(userId));
	}
}
