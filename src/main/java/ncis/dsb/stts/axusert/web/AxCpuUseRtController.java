/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxCpuUseRtController.java
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
import ncis.dsb.stts.axusert.service.AxCpuUseRtService;
import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("axCpuUseRtController")
@RequestMapping("/dsb/stts/axusert/axCpuUseRt")
public class AxCpuUseRtController extends BaseController {


	@Resource(name="axCpuUseRtService")
	AxCpuUseRtService axCpuUseRtService;

	/**
	 * 서비스 CPU 사용률 분포
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxCpuUseRtList.do")
	public String selectAxCpuUseRtList( HttpServletRequest request,
			Model model, AxUseRtSearchVo searchVo) throws Exception{

		List<AxUseRtVo> axCpuUseRtList = null;
		List<AxUseRtVo> axTopCpuUseRtList = null;

		if(request.getParameter("regionId") != null){
			axCpuUseRtList = axCpuUseRtService.selectAxCpuUseRtList(searchVo);
			axTopCpuUseRtList = axCpuUseRtService.selectAxTopCpuUseRtList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("axCpuUseRtList", axCpuUseRtList);
		model.addAttribute("axTopCpuUseRtList", axTopCpuUseRtList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectAxCpuUseRtList");
	}

	/**
	 * 서비스 CPU 사용률 분포 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxCpuUseRtXlsDown.do")
	public void selectAxCpuUseRtXlsDown(AxUseRtSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<AxUseRtVo> axCpuUseRtList = axCpuUseRtService.selectAxCpuUseRtList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("capa", "서비스 수(Core)");
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

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("CPU 자원사용률");
        sheet.setDatas(axCpuUseRtList);
        sheet.setHreader(header);

        sheets.add(sheet);

        List<AxUseRtVo> axTopCpuUseRtList = axCpuUseRtService.selectAxTopCpuUseRtList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header2 = new LinkedHashMap<String, String>();
        header2.put("capa", "서비스 수(Core)");
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

        //두번째 Sheet setting
        CustomSheet sheet2 = new CustomSheet();
        sheet2.setSheetName("CPU 최빈시 자원사용률");
        sheet2.setDatas(axTopCpuUseRtList);
        sheet2.setHreader(header);

        sheets.add(sheet2);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "서비스 CPU 사용률 분포"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }
}
