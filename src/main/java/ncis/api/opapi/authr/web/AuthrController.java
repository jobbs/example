/**
 * copyright 2016 NCIS Cloud api-gateway System
 * @description
 * <pre></pre>
 *
 * @filename AuthrController.java
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
package ncis.api.opapi.authr.web;

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

import ncis.api.gw.user.service.UserMngService;
import ncis.api.gw.user.vo.UserMngSearchVo;
import ncis.api.gw.user.vo.UserMngVo;
import ncis.api.opapi.authr.service.AuthrService;
import ncis.api.opapi.authr.vo.AuthrSearchVo;
import ncis.api.opapi.authr.vo.AuthrVo;
import ncis.api.opapi.opapi.service.OpenApiService;
import ncis.api.opapi.opapi.vo.OpenApiSearchVo;
import ncis.api.opapi.opapi.vo.OpenApiVo;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/opapi/authr")
public class AuthrController extends BaseController {

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="openApiService")
	OpenApiService openApiService;

	@Resource(name="authrService")
	AuthrService authrService;

	@Resource(name="userMngService")
	UserMngService userMngService;

	/**
	 * OpenAPI권한 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectAuthrList.do")
	public String selectAuthrList(HttpServletRequest request, Model model, AuthrSearchVo searchVo) throws Exception {

		/** OpenAPI권한 목록 조회 */
		List<AuthrVo> list = authrService.selectAuthrList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return apiTilesView(request);
	}

	/**
	 * OpenAPI권한 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertAuthr.do", method = RequestMethod.GET)
	public String insertAuthrView(HttpServletRequest request, Model model) {

		model.addAttribute("vo", new AuthrVo());

		return apiTilesView(request, "insertAuthr");
	}

	/**
	 * OpenAPI권한 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectOpenApiList.do")
	public ProcResultVo selectOpenApiList(HttpServletRequest request, Model model, OpenApiSearchVo searchVo) throws Exception {

		searchVo.setSearchUri(searchVo.getSearchNm());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(999);
		searchVo.setPaginationInfo(paginationInfo);

		/** OpenAPI권한 목록 조회 */
		List<OpenApiVo> list = openApiService.selectOpenApiList(searchVo);
		List<OpenApiVo> chkList = new ArrayList<OpenApiVo>();
		// /DJ, /GJ, /DG
		for (OpenApiVo openApiVo : list) {
			//  ( DJ,GJ,DG) 와 같이 구성된 URI는  tyk에서 스택매니저를 호출하기위해 설정해준 URI라 권한설정시 제외시킴(업무URI가 아님)
			if(!"/".equals(openApiVo.getUri())){
				if(!"DJ".equals(openApiVo.getUri().substring(1, 3).toUpperCase()) &&
						!"GJ".equals(openApiVo.getUri().substring(1, 3).toUpperCase()) &&
						!"DG".equals(openApiVo.getUri().substring(1, 3).toUpperCase())){
					chkList.add(openApiVo);
				}
			}else{	// root인경우는 권한설정 대상임
				chkList.add(openApiVo);
			}
		}
		ProcResultVo result = new ProcResultVo();
		result.setData(chkList);
		result.setSuccess(true);


		return result;
	}

	/**
	 * OpenAPI권한 등록 프로세스
	 * @param request
	 * @param model
	 * @param AuthrVo
	 * @return
	 */
	@RequestMapping(value="/insertAuthr.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI권한 등록", desc = "OpenAPI권한 등록 처리", params = { "vo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertAuthr(@ModelAttribute("vo") AuthrVo authrVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(authrVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			/** 사용자 세팅 */
			authrVo.setRegUserNm(getUserName());

			/** 등록일자 세팅 */
			authrVo.setRegDt(DateUtil.getCurrentDate());
			int year = DateUtil.getCurrentYear();

			/** ID Generation Service : 구분자, 업무구분_년도_001 ~*/
			authrVo.set_id(commonService.selectSeqNum("COUCH_AUTHR", "AUTHR_"+year+"_"));

			authrService.insertAuthr(authrVo);

			result.setProcType("insert");
			result.addMessage("저장되었습니다.");
		}

		return result;
	}

	/**
	 * OpenAPI권한 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectAuthr.do")
	public String selectAuthr(HttpServletRequest request, Model model, @RequestParam("authrId") String authrId) throws Exception {

		AuthrVo authrVo = authrService.selectAuthr(authrId);
		if (null == authrVo) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		model.addAttribute("authrVo", authrVo);

		return apiTilesView(request);
	}

	/**
	 * OpenAPI권한 수정 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateAuthr.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI권한 수정", desc = "OpenAPI권한 수정 처리", params = { "authrVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateAuthr(@ModelAttribute("authrVo") AuthrVo authrVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(authrVo, bindResult, InsertProc.class);
		boolean check = false;

		if (result.isSuccess()) {
			// 사용여부 체크 호출
			check = auchrCheck(authrVo.getAuthrId());

			if(check){
				result.addMessage("사용자에게 설정된 권한 입니다. \n 사용중인 사용자의 권한을 변경해야 합니다.");
				result.setProcType("using");
			}else{
				/** 사용자 세팅 */
				authrVo.setRegUserNm(getUserName());

				/** 등록일자 세팅 */
				authrVo.setRegDt(DateUtil.getCurrentDate());

				authrService.updateAuthr(authrVo);

				result.addMessage("수정되었습니다.");
				result.setProcType("update");
			}
		}
		return result;
	}

	/**
	 * OpenAPI권한 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteAuthr.do", method=RequestMethod.POST)
	@OperateLog(action = "OpenAPI권한 삭제", desc = "OpenAPI권한 삭제 처리", params = { "authrVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteAuthr(@ModelAttribute("authrVo") AuthrVo authrVo, BindingResult bindResult) throws Exception{

		boolean check = false;

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		// 사용여부 체크 호출
		check = auchrCheck(authrVo.getAuthrId());

		if(check){
			result.addMessage("사용자에게 설정된 권한 입니다. \n 사용중인 사용자의 권한을 변경해야 합니다.");
			result.setProcType("using");
		}else{
			authrService.deleteAuthr(authrVo);
			result.addMessage("삭제되었습니다.");
			result.setProcType("delete");
		}

		return result;
	}

	/**
	 * OpenAPI권한 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteChkAuthr.do", method=RequestMethod.POST)
	@ResponseBody
	public ProcResultVo deleteChkAuthr(@ModelAttribute("authrVo") AuthrVo authrVo, BindingResult bindResult) throws Exception{

		List<String> delKeys = authrVo.getDelKey();
		List<String> delRevs = authrVo.getDelRev();
		boolean check = false;
		int checkCnt = 0;

		// 사용여부 체크
		for(int i=0; i < delKeys.size(); i++ ) {
			AuthrVo vo = new AuthrVo();

			vo.setAuthrId(delKeys.get(i));
			vo.setRev(delRevs.get(i));

			// 사용여부 체크 호출
			check = auchrCheck(vo.getAuthrId());
			if(check){
				checkCnt++;
			}

		}

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		if(checkCnt > 0){
			result.addMessage("사용자에게 설정된 권한 입니다. \n 사용중인 사용자의 권한을 변경해야 합니다.");
		}else{
			// 삭제처리
			for(int i=0; i < delKeys.size(); i++ ) {
				AuthrVo vo = new AuthrVo();

				vo.setAuthrId(delKeys.get(i));
				vo.setRev(delRevs.get(i));

				authrService.deleteAuthr(vo);
			}
			result.addMessage("삭제되었습니다.");
		}

		result.setProcType("delete");

		return result;
	}

	/**
	 * OpenAPI권한 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectAuthrListXlsDwnl.do")
    public void selectAuthrListXlsDwnl(HttpServletRequest request, HttpServletResponse response, AuthrSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// 목록조회
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<AuthrVo> list = authrService.selectAuthrList(searchVo);

        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("authrNm", "권한명");
        header.put("apiMapng", "Api매핑");
        header.put("regUserNm", "등록자명");
        header.put("regDt", "등록일자");
        header.put("dc", "설명");

        // Sheet Vo 생성
        List<AuthrVo> datas = new ArrayList<AuthrVo>();
        for (AuthrVo authrVo : list) {
        	AuthrVo vo = new AuthrVo();

    		vo.setAuthrNm(authrVo.getAuthrNm());
    		vo.setApiMapng(authrVo.getApiMapng());
    		vo.setRegUserNm(authrVo.getRegUserNm());
    		vo.setRegDt(authrVo.getRegDt());
    		vo.setDc(authrVo.getDc());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("AuthrVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("OpenApiAuthr_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

	/**
	 * OpenAPI권한 사용여부 체크
	 * @param authrId
	 * @throws Exception
	 */
	public boolean auchrCheck(String authrId) throws Exception{

		boolean check = false;

		/** 사용자관리 목록 조회 */
		UserMngSearchVo searchVo = new UserMngSearchVo();
		List<UserMngVo> list = userMngService.selectUserMngList(searchVo);

		/** 권한 정보조회 */
		AuthrVo authrChkVo = authrService.selectAuthr(authrId);

		for(int k=0; k< list.size();k++){
			List<String> authr = list.get(k).getAuthrMapng();
			if(authr != null){
				for(int j=0;j <authr.size(); j++){
					if((authrId+"&"+authrChkVo.getAuthrNm()).equals(authr.get(j))){
						check = true;
					}
				}
			}
		}

		return check;
	}
}
