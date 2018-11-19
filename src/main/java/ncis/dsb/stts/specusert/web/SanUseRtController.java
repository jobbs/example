/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanUseRtController.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
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
import ncis.dsb.stts.specusert.service.SanUseRtService;
import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("sanUseRtController")
@RequestMapping("/dsb/stts/specusert/sanUseRt")
public class SanUseRtController extends BaseController {


	@Resource(name="sanUseRtService")
	SanUseRtService sanUseRtService;

	/**
	 * 가상서버 SAN 사용률 분포
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanUseRtList.do")
	public String selectSanUseRtList( HttpServletRequest request,
			Model model, CpuUseRtSearchVo searchVo) throws Exception{

		List<MemUseRtVo> sanUseRtList = null;
		List<MemUseRtVo> topSanUseRtList = null;

		if(searchVo.getRegionId() != null){
			sanUseRtList = sanUseRtService.selectSanUseRtList(searchVo);
			topSanUseRtList = sanUseRtService.selectTopSanUseRtList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("sanUseRtList", sanUseRtList);
		model.addAttribute("topSanUseRtList", topSanUseRtList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectSanUseRtList");
	}

	/**
	 * 가상서버 SAN 사용률 분포 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanUseRtXlsDown.do")
	public void selectSanUseRtXlsDown(CpuUseRtSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<MemUseRtVo> cpuUseRtList = sanUseRtService.selectSanUseRtList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("capa", "SAN(TG)");
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
        sheet.setSheetName("SAN 자원사용율");
        sheet.setDatas(cpuUseRtList);
        sheet.setHreader(header);

        sheets.add(sheet);

        List<MemUseRtVo> topCpuUseRtList = sanUseRtService.selectTopSanUseRtList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header2 = new LinkedHashMap<String, String>();
        header2.put("capa", "SAN(TG)");
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
        sheet2.setSheetName("SAN 최빈시 자원사용율");
        sheet2.setDatas(topCpuUseRtList);
        sheet2.setHreader(header);

        sheets.add(sheet2);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "가상서버 SAN 사용률 분포"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
    }
}
