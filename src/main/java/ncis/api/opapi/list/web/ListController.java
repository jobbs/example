/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ListController.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 11. 16.
 * @lastmodified 2016. 11. 16.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 16.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.list.web;

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
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 박희택
 *
 */
@Controller
@RequestMapping(value="/api/opapi/list")
public class ListController extends BaseController {

	@Resource(name="apiService")
	ApiService apiService;

	@Resource(name="commonService")
	CommonService commonService;

	/**
	 * ApiList 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectListList.do")
	public String selectListList(HttpServletRequest request, Model model, ApiSearchVo searchVo) throws Exception {

		/** Api 목록 조회 */
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
	 * ApiList 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectList.do")
	public String selectList(HttpServletRequest request, Model model, @RequestParam("keyId") String keyId) throws Exception {

		ApiVo apiVo = apiService.selectApi(keyId);
		if (null == apiVo) throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		model.addAttribute("apiVo", apiVo);

		return apiTilesView(request);
	}

	/**
	 * Api 엑셀다운로드
	 * @param request
	 * @param response
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectListListXlsDwnl.do")
    public void selectListListXlsDwnl(HttpServletRequest request, HttpServletResponse response, ApiSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

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

        header.put("stackClNm", "스택분류");
        header.put("apiNm", "API명");
        header.put("apiVerNm", "API버전");
        header.put("methodNm", "Method");
        header.put("uri", "URI");
        header.put("dc", "설명");

        // Sheet Vo 생성
        List<ApiVo> datas = new ArrayList<ApiVo>();
        for (ApiVo apiVo : list) {
        	ApiVo vo = new ApiVo();

        	vo.setStackClNm(apiVo.getStackClNm());
        	vo.setApiNm(apiVo.getApiNm());
        	vo.setApiVerNm(apiVo.getApiVerNm());
        	vo.setMethodNm(apiVo.getMethodNm());
        	vo.setUri(apiVo.getUri());
        	vo.setDc(apiVo.getDc());

            datas.add(vo);
        }

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("apiList");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        // Excel 생성
        ExcelUtil.downloadExcel(response, String.format("List_%s", (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date())), sheets);
    }
}
