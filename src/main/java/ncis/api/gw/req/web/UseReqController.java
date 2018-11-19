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
package ncis.api.gw.req.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.api.gw.req.service.UseReqService;
import ncis.api.gw.user.service.UserMngService;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.api.opapi.api.service.ApiService;
import ncis.api.opapi.api.vo.ApiSearchVo;
import ncis.api.opapi.api.vo.ApiVo;
import ncis.cmn.service.CommonService;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/gw/req")
public class UseReqController extends BaseController {

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="useReqService")
	UseReqService useReqService;

	@Resource(name="userMngService")
	UserMngService userMngService;

	@Resource(name="apiService")
	ApiService apiService;

	/**
	 * 사용신청 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertUseReq.do", method = RequestMethod.GET)
	public String insertUseReqView(HttpServletRequest request, Model model) throws Exception{

		model.addAttribute("vo", new UserMngVo());

		return apiTilesView(request, "insertUseReq");
	}

    /**
     * API 목록 조회 팝업
     *
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectApiListP.do")
    public String selectApiListPView(HttpServletRequest request, Model model, ApiSearchVo searchVo) throws Exception{

    	/** Api 목록 조회 */
		List<ApiVo> list = apiService.selectApiList(searchVo);

		model.addAttribute("title", "API 목록 조회");
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("list", list);

        return popup(request);
    }

	/**
	 * 사용신청 등록 프로세스
	 * @param request
	 * @param model
	 * @param UserMngVo
	 * @return
	 */
	@RequestMapping(value="/insertUseReq.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo insertUseReq(@ModelAttribute("vo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(userMngVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			/** 사용자정보 조회 */
			UserMngVo chkResultVo = new UserMngVo();
			chkResultVo = userMngService.selectUserMng(userMngVo.getRegionId()+"_"+userMngVo.getSysCd());

			// DB에 존재하는지 체크
			if(chkResultVo == null){


				/** 신청자 세팅 */
				userMngVo.setReqUsrNm(getUserName());

				/** 신청일자 세팅 */
				userMngVo.setReqDt(DateUtil.getCurrentDate());

				/** _id세팅 */
				userMngVo.setUseReqId(userMngVo.getRegionId()+"_"+userMngVo.getSysCd());

				useReqService.insertUseReq(userMngVo);

				result.addMessage("저장되었습니다.");
				result.setProcType("insert");

			}else{
				result.addMessage("이미 사용신청이 되어 있습니다.");
			}
		}

		return result;
	}

}
