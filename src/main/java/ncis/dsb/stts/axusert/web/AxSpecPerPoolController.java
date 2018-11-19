/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.axusert.service.AxSpecPerPoolService;
import ncis.dsb.stts.axusert.vo.AxSpecPerPoolSearchVo;
import ncis.dsb.stts.axusert.vo.AxSpecPerPoolVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("axSpecPerPoolController")
@RequestMapping("/dsb/stts/axusert/axSpecPerPool")
public class AxSpecPerPoolController extends BaseController {


	@Resource(name="axSpecPerPoolService")
	AxSpecPerPoolService axSpecPerPoolService;

	/**
	 * 자원풀별 가상서버 사양 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxSpecPerPoolList.do")
	public String selectAxSpecPerPoolList( HttpServletRequest request,
			Model model, AxSpecPerPoolSearchVo searchVo) throws Exception{

		List<AxSpecPerPoolVo> list = null;

		if(request.getParameter("regionId") != null){
			list = axSpecPerPoolService.selectAxSpecPerPoolList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectAxSpecPerPoolList");
	}

	/**
	 * 자원풀별 가상서버 사양 조회 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxSpecPerPoolXlsDown.do")
	public void selectAxSpecPerPoolXlsDown(AxSpecPerPoolSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<AxSpecPerPoolVo> list = axSpecPerPoolService.selectAxSpecPerPoolList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("no", "No.");
        header.put("rsrcPoolNm", "자원풀");
        header.put("minCpuCorQty", "Core 최저");
        header.put("avgCpuCorQty", "Core 평균");
        header.put("maxCpuCorQty", "Core 최고");
        header.put("minMemTotCapa", "MEM 최저(GB)");
        header.put("avgMemTotCapa", "MEM 평균(GB)");
        header.put("maxMemTotCapa", "MEM 최고(GB)");
        header.put("minStrgTotCapa", "스토리지 최저(GB)");
        header.put("avgStrgTotCapa", "스토리지 평균(GB)");
        header.put("maxStrgTotCapa", "스토리지 최고(GB)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장사양 분포");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장사양 분포_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }
}
