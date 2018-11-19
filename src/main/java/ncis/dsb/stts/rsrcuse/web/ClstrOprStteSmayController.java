/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstrOprStteSmayController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcuse.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
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
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.rsrcuse.service.ClstrOprStteSmayService;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmaySearchVo;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmayVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("clstrOprStteSmayController")
@RequestMapping("/dsb/stts/rsrcuse/smay")
public class ClstrOprStteSmayController extends BaseController {


	@Resource(name="clstrOprStteSmayService")
	ClstrOprStteSmayService clstrOprStteSmayService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원풀 운영 현황 개요 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstrOprStteSmayList.do")
	public String selectClstrOprStteSmayList( HttpServletRequest request,ClstrOprStteSmaySearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;


		if(searchVo.getYear() == null) searchVo.setYear(year);

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}



		List<ClstrOprStteSmayVo> list = null;
		List<ClstrOprStteSmayVo> rsList = null;
		if(searchVo.getSearch() != null){
				list = clstrOprStteSmayService.selectClstrOprStteSmayList(searchVo);	// 게시글list 가져오기
				rsList = clstrOprStteSmayService.selectClstrOprStteSmayRsAutoList(searchVo);
		}
		model.addAttribute("list", list);

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		model.addAttribute("searchVo", searchVo);

		model.addAttribute("rsList", rsList);

		return dashTilesView(request,"selectClstrOprStteSmayList");
	}

	/**
	 * 자원풀 운영 현황 개요 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstrOprStteSmayXlsDown.do")
	public void selectClstrOprStteSmayXlsDown(
			ClstrOprStteSmaySearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);


		List<ClstrOprStteSmayVo> list = null;

		if(searchVo.getSearch() != null){
				list = clstrOprStteSmayService.selectClstrOprStteSmayList(searchVo);	// 게시글list 가져오기
		}

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	    	header.put("yy",        "년도");
	        header.put("gubun",     "구분");
	        header.put("totHold",   "계_보유량(GB)");
	        header.put("totAsgn",   "계_할당량(GB)");
	        header.put("totAsgnRt", "계_할당률(%)");
	        header.put("djHold",    "대전_보유량(GB)");
	        header.put("djAsgn",    "대전_할당량(GB)");
	        header.put("djAsgnRt",  "대전_할당률(%)");
	        header.put("gjHold",    "광주_보유량(GB)");
	        header.put("gjAsgn",    "광주_할당량(GB)");
	        header.put("gjAsgnRt",  "광주_할당률(%)");

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("물리/가상 자원풀 운영 현황 개요");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "물리/가상 자원풀 운영 현황 개요_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자원풀 운영 현황 개요 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstrOprStteSmayRsAutoXlsDown.do")
	public void selectClstrOprStteSmayRsAutoXlsDown(ClstrOprStteSmaySearchVo searchVo,HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<ClstrOprStteSmayVo> rsList = null;

		if(searchVo.getSearch() != null){
			rsList = clstrOprStteSmayService.selectClstrOprStteSmayRsAutoList(searchVo);
		}

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	    	header.put("yy",        "년도");
	        header.put("gubun",     "구분");
	        header.put("totAtmsclNode",   "계_보유량(GB)");
	        header.put("totPodQtyAsgn",   "계_할당량(GB)");
	        header.put("totAtmsclNodeRt", "계_할당률(%)");
	        header.put("djAtmsclNode",    "대전_보유량(GB)");
	        header.put("djPodAsgn",    "대전_할당량(GB)");
	        header.put("djAtmsclNodeRt",  "대전_할당률(%)");
	        header.put("gjAtmsclNode",    "광주_보유량(GB)");
	        header.put("gjPodAsgn",    "광주_할당량(GB)");
	        header.put("gjAtmsclNodeRt",  "광주_할당률(%)");

	    //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장 자원풀 운영 현황 개요");
        sheet.setDatas(rsList);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장 자원풀 운영 현황 개요_"+DateUtil.getCurrentDate(), sheets);
    }

}

