/**
 * copyright 2016 NCIS Cloud API-Gateway System
 * @description
 * <pre></pre>
 *
 * @filename ApiController.java
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
package ncis.api.opapi.api.web;

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

import ncis.api.opapi.api.service.ApiService;
import ncis.api.opapi.api.vo.ApiSearchVo;
import ncis.api.opapi.api.vo.ApiVo;
import ncis.cmn.entity.CnvrRule;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.vo.CodeVo;
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
@RequestMapping(value="/api/opapi/api")
public class ApiController extends BaseController {

	@Resource(name="apiService")
	ApiService apiService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * API 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectApiList.do")
	public String selectApiList(HttpServletRequest request, Model model, ApiSearchVo searchVo) throws Exception {

		/** API 목록 조회 */
		List<ApiVo> list = apiService.selectApiList(searchVo);

		/** 코드조회 */
		List<CodeVo> stackClCd = commonService.selectCodeList("039", "201", true);	// 스택분류코드
		List<CodeVo> apiVerCd = commonService.selectCodeList("041", "203", true);	// API버전코드
		List<CodeVo> methodCd = commonService.selectCodeList("040", "202", true);	// Method코드


		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
	    model.addAttribute("stackClCd", stackClCd);
	    model.addAttribute("apiVerCd", apiVerCd);
	    model.addAttribute("methodCd", methodCd);


		return apiTilesView(request);
	}

	/**
	 * API 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectApi.do")
	public String selectApi(HttpServletRequest request, Model model, @RequestParam("keyId") String keyId) throws Exception {

		ApiVo apiVo = apiService.selectApi(keyId);
		if (null == apiVo) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		model.addAttribute("apiVo", apiVo);

		return apiTilesView(request);
	}

	/**
	 * API 등록 화면
	 *
	 * @param boardId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertApi.do", method = RequestMethod.GET)
	public String insertApiView(HttpServletRequest request, Model model) {

		model.addAttribute("vo", new ApiVo());

		return apiTilesView(request, "insertApi");
	}

	/**
	 * API 등록 프로세스
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/insertApi.do", method=RequestMethod.POST)
	@OperateLog(action = "API 등록", desc = "API 정보 등록 처리", params = { "vo" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertApi(@ModelAttribute("vo") ApiVo apiVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(apiVo, bindResult, InsertProc.class);



		if (result.isSuccess()) {

			/** 전체 API 조회 */
			ApiSearchVo apiSearchVo = new ApiSearchVo();
			List<ApiVo> apiList = apiService.selectApiList(apiSearchVo);

			int chkCnt = 0;
			for (ApiVo chkVo : apiList) {
				if(apiVo.getApiId().equals(chkVo.getApiId())){
					chkCnt++;
				}
			}

			if(chkCnt > 0){
				result.addMessage("이미 존재하는 API ID 입니다.");
			}else{
				/** 사용자 세팅 */
				apiVo.setRegUserNm(getUserName());

				/** 등록일자 세팅 */
				apiVo.setRegDt(DateUtil.getCurrentDate());
				int year = DateUtil.getCurrentYear();

				/** 변환룰에 API ID, 스택분류 세팅 */
				List<CnvrRule> list = new ArrayList<>();
				if(apiVo.getCnvrRules() != null){
					for(int i=0; i<apiVo.getCnvrRules().size(); i++){
						CnvrRule cnvrRuleVo = new CnvrRule();

						cnvrRuleVo = apiVo.getCnvrRules().get(i);
						cnvrRuleVo.setCnvrRuleStackClCd(apiVo.getStackClCd());
						cnvrRuleVo.setCnvrRuleApiId(apiVo.getApiId());

						list.add(cnvrRuleVo);
					}

					apiVo.setCnvrRules(list);
				}

				/** ID Generation Service : 구분자, 업무구분_년도_001 ~*/
				apiVo.set_id(commonService.selectSeqNum("COUCH_API", "API_"+year+"_"));

				apiService.insertApi(apiVo);

				result.addMessage("저장되었습니다.");
				result.setProcType("insert");
			}
		}

		return result;
	}

	/**
	 * API 수정 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/updateApi.do", method=RequestMethod.POST)
	@OperateLog(action = "API 수정", desc = "API 정보 수정 처리", params = { "apiVo" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateApi(@ModelAttribute("apiVo") ApiVo apiVo, BindingResult bindResult) throws Exception{

		// validate 체크
		ProcResultVo result = getBindingResult(apiVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			/** 전체 API 조회 */
			ApiSearchVo apiSearchVo = new ApiSearchVo();
			List<ApiVo> apiList = apiService.selectApiList(apiSearchVo);

			int chkCnt = 0;
			for (ApiVo chkVo : apiList) {
				if(apiVo.getApiId().equals(chkVo.getApiId()) && !apiVo.getKeyId().equals(chkVo.get_id())){
					chkCnt++;
				}
			}

			if(chkCnt > 0){
				result.addMessage("이미 존재하는 API ID 입니다.");
			}else{
				/** 사용자 세팅 */
				apiVo.setRegUserNm(getUserName());

				/** 등록일자 세팅 */
				apiVo.setRegDt(DateUtil.getCurrentDate());

				/** 변환룰에 API ID, 스택분류 세팅 */
				List<CnvrRule> list = new ArrayList<>();

				if(apiVo.getCnvrRules() != null){
					for(int i=0; i<apiVo.getCnvrRules().size(); i++){
						CnvrRule cnvrRuleVo = new CnvrRule();
						cnvrRuleVo = apiVo.getCnvrRules().get(i);
						cnvrRuleVo.setCnvrRuleStackClCd(apiVo.getStackClCd());
						cnvrRuleVo.setCnvrRuleApiId(apiVo.getApiId());

						list.add(cnvrRuleVo);
					}
					apiVo.setCnvrRules(list);
				}

				apiService.updateApi(apiVo);

				result.addMessage("수정되었습니다.");
				result.setProcType("update");
			}
		}

		return result;
	}

	/**
	 * API 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteApi.do", method=RequestMethod.POST)
	@OperateLog(action = "API 삭제", desc = "API 정보 삭제 처리", params = { "apiVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteApi(@ModelAttribute("apiVo") ApiVo apiVo, BindingResult bindResult) throws Exception{

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		apiService.deleteApi(apiVo);

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}

	/**
	 * API 일괄/선택 삭제 프로세스
	 * @param request
	 * @param model
	 * @param svo
	 * @return
	 */
	@RequestMapping(value="/deleteChkApi.do", method=RequestMethod.POST)
	@OperateLog(action = "API 일괄/선택 삭제", desc = "API 정보 일괄/선택 삭제 처리", params = { "apiVo" }, actionType = ActionType.DELETE)
	@ResponseBody
	public ProcResultVo deleteChkApi(@ModelAttribute("apiVo") ApiVo apiVo, BindingResult bindResult) throws Exception{

		List<String> delKeys = apiVo.getDelKey();
		List<String> delRevs = apiVo.getDelRev();

		for(int i=0; i < delKeys.size(); i++ ) {
			ApiVo vo = new ApiVo();

			vo.setKeyId(delKeys.get(i));
			vo.setRev(delRevs.get(i));

			apiService.deleteApi(vo);
		}

		// 결과 return Vo
		ProcResultVo result = new ProcResultVo();

		result.addMessage("삭제되었습니다.");
		result.setProcType("delete");

		return result;
	}

	/**
	 * API 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectApiListXlsDwnl.do")
    public void selectApiListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ApiSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		// 목록조회
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo = searchVo.getPaginationInfo();
		paginationInfo.setRecordCountPerPage(9999);
		searchVo.setPaginationInfo(paginationInfo);
		List<ApiVo> list = apiService.selectApiList(searchVo);
        // CusomSheet 생성
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();

        header.put("apiId", "API ID");
        header.put("apiNm", "API명");
        header.put("apiVerNm", "API버전");
        header.put("methodNm", "Method");
        header.put("stackClNm", "스택분류");
        header.put("uri", "URI");
        header.put("dc", "설명");
        header.put("regUserNm", "등록자명");
        header.put("regDt", "등록일자");

        // Sheet Vo 생성
        List<ApiVo> datas = new ArrayList<ApiVo>();
        for (ApiVo apiVo : list) {
        	ApiVo vo = new ApiVo();

        	vo.setApiId(apiVo.getApiId());
        	vo.setApiNm(apiVo.getApiNm());
        	vo.setApiVerNm(apiVo.getApiVerNm());
        	vo.setMethodNm(apiVo.getMethodNm());
        	vo.setStackClNm(apiVo.getStackClNm());
        	vo.setUri(apiVo.getUri());
        	vo.setDc(apiVo.getDc());
        	vo.setRegUserNm(apiVo.getRegUserNm());
        	vo.setRegDt(apiVo.getRegDt());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("ApiVo");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("Api_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }

}
