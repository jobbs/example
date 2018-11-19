/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmUsefulRngController.java
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
package ncis.dsb.stts.specusert.web;

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
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.specusert.service.VmUsefulRngService;
import ncis.dsb.stts.specusert.vo.VmUsefulMemVo;
import ncis.dsb.stts.specusert.vo.VmUsefulRngSearchVo;
import ncis.dsb.stts.specusert.vo.VmUsefulSanVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("vmUsefulRngController")
@RequestMapping("/dsb/stts/specusert/vmUsefulRng")
public class VmUsefulRngController extends BaseController {


	@Resource(name="vmUsefulRngService")
	VmUsefulRngService vmUsefulRngService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 가상서버 사양 분포
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmUsefulRngList.do")
	public String selectVmUsefulRngtList( HttpServletRequest request,
			Model model, VmUsefulRngSearchVo searchVo) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;

		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getMm() == null) searchVo.setMm(mm);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());


		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<VmUsefulMemVo> memCntList = null;
		List<VmUsefulSanVo> sanCntList = null;
		List<VmUsefulMemVo> memCntRtList = null;
		List<VmUsefulSanVo> sanCntRtList = null;

		if(searchVo.getSearch() != null){
			memCntList = vmUsefulRngService.selectMemCntList(searchVo);
			sanCntList = vmUsefulRngService.selectSanCntList(searchVo);
			memCntRtList = vmUsefulRngService.selectMemCntRtList(searchVo);
			sanCntRtList = vmUsefulRngService.selectSanCntRtList(searchVo);
		}
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		model.addAttribute("mmList", mmList);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("memCntList", memCntList);
		model.addAttribute("sanCntList", sanCntList);
		model.addAttribute("memCntRtList", memCntRtList);
		model.addAttribute("sanCntRtList", sanCntRtList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectVmUsefulRngList");
	}

	/**
	 * 가상서버 사양 분포 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmUsefulRngXlsDown.do")
	public void selectVmUsefulRngXlsDown(VmUsefulRngSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<VmUsefulMemVo> memCntList = vmUsefulRngService.selectMemCntList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("lastVcoreQty",    	"가상서버 수(vCore)");
        header.put("lastMemSumCapa8", 	"8");
        header.put("lastMemSumCapa16",	"16");
        header.put("lastMemSumCapa24",	"24");
        header.put("lastMemSumCapa32",	"32");
        header.put("lastMemSumCapa48",	"48");
        header.put("lastMemSumCapa64", 	"64");
        header.put("lastMemSumCapa128", "128");
        header.put("lastMemSumCapaetc", "기타");
        header.put("total", 			"계");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("vCore수 및 MEM(GB)용량별 가상서버수");
        sheet.setDatas(memCntList);
        sheet.setHreader(header);

        sheets.add(sheet);

        List<VmUsefulSanVo> sanCntList = vmUsefulRngService.selectSanCntList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header2 = new LinkedHashMap<String, String>();
        header2.put("가상서버수", 			"가상서버수");
        header2.put("lastStrgSumCapa0", 			"0.5이하");
        header2.put("lastStrgSumCapa1", 			"1");
        header2.put("lastStrgSumCapa2", 	"1-2");
        header2.put("lastStrgSumCapa3", 	"2-4");
        header2.put("lastStrgSumCapa4", 	"4-8");
        header2.put("lastStrgSumCapa", 	"8초과");
        header2.put("total", 	"계");

        //두번째 Sheet setting
        CustomSheet sheet2 = new CustomSheet();
        sheet2.setSheetName("SAN(TB) 용량별 가상서버수");
        sheet2.setDatas(sanCntList);
        sheet2.setHreader(header2);

        sheets.add(sheet2);

        List<VmUsefulMemVo> memCntRtList = vmUsefulRngService.selectMemCntRtList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header3 = new LinkedHashMap<String, String>();
        header3.put("lastVcoreQty", 		"비율(%)(vCore)");
        header3.put("lastMemSumCapa8", 		"8");
        header3.put("lastMemSumCapa16", 	"16");
        header3.put("lastMemSumCapa24", 	"24");
        header3.put("lastMemSumCapa32", 	"32");
        header3.put("lastMemSumCapa48", 	"48");
        header3.put("lastMemSumCapa64", 	"64");
        header3.put("lastMemSumCapa128", 	"128");
        header3.put("lastMemSumCapaetc", 	"기타");
        header3.put("total", 				"계");

        //세번째 Sheet setting
        CustomSheet sheet3 = new CustomSheet();
        sheet3.setSheetName("vCore수 및 MEM(GB)용량별 가상서버 비율(%)");
        sheet3.setDatas(memCntRtList);
        sheet3.setHreader(header3);

        sheets.add(sheet3);


        List<VmUsefulSanVo> sanCntRtList = vmUsefulRngService.selectSanCntRtList(searchVo);

	    //CusomSheet 생성
        //List<CustomSheet> sheets2 = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
        Map<String, String> header4 = new LinkedHashMap<String, String>();
        header4.put("비율", 	"가상서버비율");
        header4.put("lastStrgSumCapa0", 	"0.5이하");
        header4.put("lastStrgSumCapa1", 	"1");
        header4.put("lastStrgSumCapa2", 	"1-2");
        header4.put("lastStrgSumCapa3", 	"2-4");
        header4.put("lastStrgSumCapa4", 	"4-8");
        header4.put("lastStrgSumCapa", 		"8초과");
        header4.put("total", 				"계");

        //네번째 Sheet setting
        CustomSheet sheet4 = new CustomSheet();
        sheet4.setSheetName("SAN(TB) 용량별 가상서버 비율(%)");
        sheet4.setDatas(sanCntRtList);
        sheet4.setHreader(header4);

        sheets.add(sheet4);

        //Excel 생성
        ExcelUtil.downloadExcel(response, "가상서버 사양 분포_"+DateUtil.getCurrentDate(), sheets);
    }
}
