/**
 * copyright 2016 NCIS Cloud api-gateway System
 * @description
 * <pre></pre>
 *
 * @filename UserMngController.java
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
package ncis.api.gw.user.web;

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

import ncis.api.gw.hstry.service.ReqstHstryService;
import ncis.api.gw.use.vo.ReqstHstrySearchVo;
import ncis.api.gw.use.vo.ReqstHstryVo;
import ncis.api.gw.user.service.UserMngService;
import ncis.api.gw.user.vo.UserMngSearchVo;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.api.opapi.authr.service.AuthrService;
import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
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

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/gw/user")
public class UserMngController extends BaseController {

	@Resource(name="userMngService")
	UserMngService userMngService;

	@Resource(name="reqstHstryService")
	ReqstHstryService reqstHstryService;

	@Resource(name="authrService")
	AuthrService authrService;

	/**
	 * 사용자관리 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectUserMngList.do")
	public String selectUserMngList(HttpServletRequest request, Model model, UserMngSearchVo searchVo) throws Exception {

		/** 사용자관리 목록 조회 */
		List<UserMngVo> list = userMngService.selectUserMngList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return apiTilesView(request);
	}

	/**
	 * 사용자관리 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectUserMng.do")
	public String selectUserMng(HttpServletRequest request, Model model, ReqstHstrySearchVo searchVo, @RequestParam("useReqId") String useReqId) throws Exception {

		/** 사용자정보 조회 */
		UserMngVo userMngVo = userMngService.selectUserMng(useReqId);
		if (null == userMngVo) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

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
	 * 사용자관리 수정 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateUserMng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo updateUserMng(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(userMngVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			/** 관리자 세팅 */
			userMngVo.setChargerNm(getUserName());

			/** 등록일자 세팅 */
			userMngVo.setReqDt(DateUtil.getCurrentDate());
			userMngService.updateUserMng(userMngVo);

			result.addMessage("처리되었습니다.");
			result.setProcType("update");
		}

		return result;
	}

	/**
	 * 사용자관리 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteUserMng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteUserMng(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		userMngService.deleteUserMng(userMngVo);

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}


	/**
	 * 사용자관리 check삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteChkUserMng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteChkUserMng(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		List<String> delKeys = userMngVo.getDelKey();
		List<String> delRevs = userMngVo.getDelRev();

		for(int i=0; i < delKeys.size(); i++ ) {

			UserMngVo vo = new UserMngVo();

			vo.setUseReqId(delKeys.get(i));
			vo.setRev(delRevs.get(i));

			/** 사용자정보 조회 */
			UserMngVo userInfoVo = userMngService.selectUserMng(vo.getUseReqId());
			vo.setRegionId(userInfoVo.getRegionId());

			userMngService.deleteUserMng(vo);
		}

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}

	/**
	 * openApi 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectUserMngListXlsDwnl.do")
    public void selectUserMngListXlsDwnl(HttpServletRequest request, HttpServletResponse response, UserMngSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		/** 사용자관리 목록 조회 */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<UserMngVo> list = userMngService.selectUserMngList(searchVo);

		// CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("reqUsrNm","신청자명");
        header.put("reqDt", "신청일자");
        header.put("sysNm", "시스템");
        header.put("statNm", "상태");
        header.put("accssKey", "접근키");
        header.put("passwd", "비밀번호");
        header.put("ipAddr", "IP주소");
        header.put("authrMapng", "권한매핑");
        header.put("reqReasn", "신청사유");
        header.put("rjctReasn", "반려사유");

        // Sheet Vo 생성
        List<UserMngVo> datas = new ArrayList<UserMngVo>();
        for (UserMngVo userMngVo : list) {
        	UserMngVo vo = new UserMngVo();

        	vo.setReqUsrNm(userMngVo.getReqUsrNm());
        	vo.setReqDt(userMngVo.getReqDt());
        	vo.setSysNm(userMngVo.getSysNm());
        	vo.setStatNm(userMngVo.getStatNm());
        	vo.setAccssKey(userMngVo.getAccssKey());
        	vo.setPasswd(userMngVo.getPasswd());
        	vo.setIpAddr(userMngVo.getIpAddr());
        	vo.setAuthrMapng(userMngVo.getAuthrMapng());
        	vo.setReqReasn(userMngVo.getReqReasn());
        	vo.setRjctReasn(userMngVo.getRjctReasn());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("UserMngVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("UserMng_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

	/**
	 * 사용자이력 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectReqstHstryListXlsDwnl.do")
    public void selectReqstHstryListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ReqstHstrySearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		/** 사용신청이력 목록 조회 */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<ReqstHstryVo> list = reqstHstryService.selectReqstHistryList(searchVo);

		// CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("sysNm", "시스템명");
        header.put("reqHstryNm", "신청이력명");
        header.put("reqHstrystatNm", "신청이력상태");
        header.put("reqhstryUsrNm", "신청자명");
        header.put("chargerNm", "담당자명");
        header.put("reqHstryDt", "신청일자");

        // Sheet Vo 생성
        List<ReqstHstryVo> datas = new ArrayList<ReqstHstryVo>();
        for (ReqstHstryVo reqstHstryVo : list) {
        	ReqstHstryVo vo = new ReqstHstryVo();

        	vo.setSysNm(reqstHstryVo.getSysNm());
        	vo.setReqHstryNm(reqstHstryVo.getReqHstryNm());
        	vo.setReqHstrystatNm(reqstHstryVo.getReqHstryNm());
        	vo.setReqhstryUsrNm(reqstHstryVo.getReqhstryUsrNm());
        	vo.setChargerNm(reqstHstryVo.getChargerNm());
        	vo.setReqHstryDt(reqstHstryVo.getReqHstryDt());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("ReqstHstryVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("ReqstHstry_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

	/**
	 * openAPI권한 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectAuthrList.do")
	public ProcResultVo selectAuthrList(HttpServletRequest request, Model model, AuthrSearchVo searchVo) throws Exception {

		searchVo.setSearchAuthrNm(searchVo.getSearchNm());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(999);
		searchVo.setPaginationInfo(paginationInfo);

		/** openApi 권한목록 조회 */
		List<AuthrVo> list = authrService.selectAuthrList(searchVo);

		ProcResultVo result = new ProcResultVo();
		result.setData(list);
		result.setSuccess(true);


		return result;
	}

	/**
	 * 키 재발급 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/reIssuedUserMng.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo reIssuedUserMng(@ModelAttribute("userMngVo") UserMngVo userMngVo, BindingResult bindResult) throws Exception{

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		/** 관리자 세팅 */
		userMngVo.setChargerNm(getUserName());

		/** 등록일자 세팅 */
		userMngVo.setReqDt(DateUtil.getCurrentDate());

		userMngService.reIssuedUserMng(userMngVo);

		result.addMessage("키가 재발급 되었습니다.");
		result.setProcType("reIssued");

		return result;
	}

}
