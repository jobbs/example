/**
 * copyright 2016 NCIS Cloud api-gateway System
 * @description
 * <pre></pre>
 *
 * @filename UseReqController.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.use.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.api.gw.hstry.service.ReqstHstryService;
import ncis.api.gw.use.service.UseMngService;
import ncis.api.gw.use.vo.ReqstHstrySearchVo;
import ncis.api.gw.use.vo.ReqstHstryVo;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.cmn.util.DateUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/gw/use")
public class UseMngController extends BaseController {

	@Resource(name="useMngService")
	UseMngService useMngService;

	@Resource(name="reqstHstryService")
	ReqstHstryService reqstHstryService;

	/**
	 * 사용 관리 로그인
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectUseLogin.do", method = RequestMethod.GET)
	public String insertUseReqView(HttpServletRequest request, Model model) {

		model.addAttribute("userMngVo", new UserMngVo());

		return apiTilesView(request, "selectUseLogin");
	}

	/**
	 * 로그인 체크
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectLoginChk.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo apiLoginChk(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(userMngVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			UserMngVo resultVo = useMngService.apiLoginChk(userMngVo);

			if(!"".equals(resultVo) && resultVo != null){
				if(!resultVo.getPasswd().equals(userMngVo.getPasswd())){
					return getFailProcResult("비밀번호가 일치하지 않습니다.", "login");
				}
			}else{
				return getFailProcResult("존재하진 않는 사용자 입니다.", "login");
			}
		}

		return result;
	}

	/**
	 * 사용관리 상세 조회(로그인 후 상세 조회)
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectUseMngLogin.do", method=RequestMethod.GET)
	public String selectUseMngLogin(HttpServletRequest request, Model model, @RequestParam("useReqId") String useReqId) throws Exception {

		/** 사용자정보 조회 */
		UserMngVo userMngVo = useMngService.selectUseMng(useReqId);
		ReqstHstrySearchVo searchVo = new ReqstHstrySearchVo();

		// 시스템 코드 세팅
		searchVo.setUseReqId(useReqId);

		/** 사용신청이력 목록 조회 */
		List<ReqstHstryVo> list = reqstHstryService.selectReqstHistryList(searchVo);


		model.addAttribute("list", list);
		model.addAttribute("userMngVo", userMngVo);
		model.addAttribute("searchVo", searchVo);

		return apiTilesView(request,"selectUseMng");
	}

	/**
	 * 사용관리 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectUseMng.do")
	public String selectUseMng(HttpServletRequest request, Model model, ReqstHstrySearchVo searchVo, @RequestParam("useReqId") String useReqId) throws Exception {

		/** 사용자정보 조회 */
		UserMngVo userMngVo = useMngService.selectUseMng(useReqId);

		// 시스템 코드 세팅
		searchVo.setUseReqId(useReqId);

		/** 사용신청이력 목록 조회 */
		List<ReqstHstryVo> list = reqstHstryService.selectReqstHistryList(searchVo);


		model.addAttribute("list", list);
		model.addAttribute("userMngVo", userMngVo);
		model.addAttribute("searchVo", searchVo);

		return apiTilesView(request);
	}

	/**
	 * 사용 신청 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateUseMng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateUseMng(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(userMngVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			/** 비밀번호 변경시 변경된 비밀번호로 저장 */
			if(!("").equals(userMngVo.getChangePasswd())){
				userMngVo.setPasswd(userMngVo.getChangePasswd());
			}

			/** 신청자 세팅 */
			userMngVo.setReqUsrNm(getUserName());
			/** 등록일자 세팅 */
			userMngVo.setReqDt(DateUtil.getCurrentDate());

			useMngService.updateUseMng(userMngVo);

			result.addMessage("처리되었습니다.");
			result.setProcType("update");
		}

		return result;
	}
}
