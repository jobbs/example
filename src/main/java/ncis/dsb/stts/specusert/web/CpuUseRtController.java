/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CpuUseRtController.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.web;

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
import ncis.dsb.stts.specusert.service.CpuUseRtService;
import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("cpuUseRtController")
@RequestMapping("/dsb/stts/specusert/cpuUseRt")
public class CpuUseRtController extends BaseController {


	@Resource(name="cpuUseRtService")
	CpuUseRtService cpuUseRtService;

	/**
	 * 가상서버 CPU 사용률 분포
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCpuUseRtList.do")
	public String selectCpuUseRtList( HttpServletRequest request,
			Model model, CpuUseRtSearchVo searchVo) throws Exception{

		List<MemUseRtVo> cpuUseRtList = null;
		List<MemUseRtVo> topCpuUseRtList = null;

		if(request.getParameter("regionId") != null){
			cpuUseRtList = cpuUseRtService.selectCpuUseRtList(searchVo);
			topCpuUseRtList = cpuUseRtService.selectTopCpuUseRtList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuUseRtList", cpuUseRtList);
		model.addAttribute("topCpuUseRtList", topCpuUseRtList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectCpuUseRtList");
	}

	/**
	 * 가상서버 CPU 사용률 분포 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCpuUseRtXlsDown.do")
	public void selectCpuUseRtXlsDown(CpuUseRtSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<MemUseRtVo> cpuUseRtList = cpuUseRtService.selectCpuUseRtList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("capa", "가상서버 수(vCore)");
        header.put("total", "계");
        header.put("useRt10", "10%이하");
        header.put("useRt20", "20%이하");
        header.put("useRt30", "30%이하");
        header.put("useRt40", "40%이하");
        header.put("useRt50", "50%이하");
        header.put("useRt60", "60%이하");
        header.put("useRt70", "70%이하");
        header.put("useRt80", "80%이하");
        header.put("useRt90", "90%이하");
        header.put("useRt100", "100%이하");
        header.put("useRtNull", "미수집");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("CPU 자원사용율");
        sheet.setDatas(cpuUseRtList);
        sheet.setHreader(header);

        sheets.add(sheet);

        List<MemUseRtVo> topCpuUseRtList = cpuUseRtService.selectTopCpuUseRtList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header2 = new LinkedHashMap<String, String>();
        header2.put("capa", "가상서버 수(vCore)");
        header2.put("total", "계");
        header2.put("useRt10", "10%이하");
        header2.put("useRt20", "20%이하");
        header2.put("useRt30", "30%이하");
        header2.put("useRt40", "40%이하");
        header2.put("useRt50", "50%이하");
        header2.put("useRt60", "60%이하");
        header2.put("useRt70", "70%이하");
        header2.put("useRt80", "80%이하");
        header2.put("useRt90", "90%이하");
        header2.put("useRt100", "100%이하");
        header2.put("useRtNull", "미수집");


        //두번째 Sheet setting
        CustomSheet sheet2 = new CustomSheet();
        sheet2.setSheetName("CPU 최빈시 자원사용율");
        sheet2.setDatas(topCpuUseRtList);
        sheet2.setHreader(header);

        sheets.add(sheet2);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "가상서버 CPU 사용률 분포"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }
}
