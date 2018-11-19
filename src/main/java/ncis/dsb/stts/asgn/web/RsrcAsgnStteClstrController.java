/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteTrmController.java
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


package ncis.dsb.stts.asgn.web;

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
import ncis.dsb.stts.asgn.service.RsrcAsgnStteClstrService;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrAxVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("rsrcAsgnStteClstrController")
@RequestMapping("/dsb/stts/asgn/clstr")
public class RsrcAsgnStteClstrController extends BaseController {


	@Resource(name="rsrcAsgnStteClstrService")
	RsrcAsgnStteClstrService rsrcAsgnStteClstrService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원 보유 및 할당 현황 - 클러스터별 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcAsgnStteClstrList.do")
	public String selectRsrcAsgnStteClstrList( HttpServletRequest request,RsrcAsgnStteClstrSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;


		if(searchVo.getDtlGubun() == null) searchVo.setDtlGubun("sumy");
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

		List<RsrcAsgnStteClstrVo> list = null;
		List<RsrcAsgnStteClstrAxVo> axList = null;
		if(searchVo.getSearch() != null){
				list = rsrcAsgnStteClstrService.selectRsrcAsgnStteClstrList(searchVo);	// 게시글list 가져오기
				axList = rsrcAsgnStteClstrService.selectRsrcAsgnStteClstrAxList(searchVo);	// 자동확장 게시글list 가져오기
		}
		model.addAttribute("list", list);
		model.addAttribute("axList", axList);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("mmList", mmList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectRsrcAsgnStteClstrList");
	}

	/**
	 * 자원 보유 및 할당 현황 - 클러스터별 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcAsgnStteClstrXlsDown.do")
	public void selecInsttChngStteXlsDown(
			RsrcAsgnStteClstrSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{



		List<RsrcAsgnStteClstrVo> list = rsrcAsgnStteClstrService.selectRsrcAsgnStteClstrList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	        header.put("rsrcPoolNm", "자원풀코드");
	        header.put("clstrSeq", "클러스터수");
	        if(searchVo.getDtlGubun().equals("dtl")){
	        	header.put("clstrNm", "클러스터");
	        }
	        header.put("pmSeq", "물리자원_서버수");
	        header.put("lastCpuCorQty", "물리자원 보유량_Core");
	        header.put("lastMemSumCapa", "물리자원 보유량_MEM(GB)");
	        header.put("lastStrgSumCapa", "물리자원 보유량_SAN(GB)");
	        header.put("lastVSrvrQty", "논리자원 할당량_가상서버수");
	        header.put("lastAsgnVcorQty", "논리자원 할당량_vCore");
	        header.put("lastAsgnMemCapa", "논리자원 할당량_MEM");
	        header.put("vmLastAsgnStrgCapa", "논리자원 할당량_SAN");
	        header.put("vrlzRt", "서버가상화율(%)");
	        header.put("vcoreRt", "자원 할당률(%)_vCore");
	        header.put("memRt", "자원 할당률(%)_MEM");
	        header.put("sanRt", "자원 할당률(%)_SAN");



        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원 보유 및 할당 현황 - 클러스터별");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원 보유 및 할당 현황 - 클러스터별_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자동확장 자원 보유 및 할당 현황 - 클러스터별 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcAsgnStteClstrAxXlsDown.do")
	public void selectRsrcAsgnStteClstrAxXlsDown(
			RsrcAsgnStteClstrSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{



		List<RsrcAsgnStteClstrAxVo> list = rsrcAsgnStteClstrService.selectRsrcAsgnStteClstrAxList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	        header.put("rsrcPoolNm", "자원풀");
	        header.put("nodeQty", "자원 보유량_서버수");
	        header.put("cpuCorQty", "자원 보유량_Core");
	        header.put("memTotCapa", "자원 보유량_MEM(GB)");
	        header.put("strgTotCapa", "자원 보유량_스토리지(GB)");
	        header.put("quotaPodQty", "자원 할당량_POD수");
	        header.put("quotaCpuCorQty", "자원 할당량_Core");
	        header.put("quotaMemTotCapa", "자원 할당량_MEM(GB)");
	        header.put("asgnCpuRt", "자원 할당률_CPU");
	        header.put("asgnMemRt", "자원 할당률_MEM");
	        header.put("lastPodQty", "자원 사용량_POD수");
	        header.put("cpuUseCapa", "자원 사용량_Core");
	        header.put("memUseCapa", "자원 사용량_MEM(GB)");
	        header.put("nodeUseCpuRt", "노드 자원 사용률(%)_CPU");
	        header.put("nodeUseMemRt", "노드 자원 사용률(%)_MEM");
	        header.put("quotaUsePodRt", "쿼타 자원 사용률(%)_POD");
	        header.put("quotaUseCpuRt", "쿼타 자원 사용률(%)_CPU");
	        header.put("quotaUseMemRt", "쿼타 자원 사용률(%)_MEM");

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장 자원 보유 및 할당 현황 - 클러스터별");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장 자원 보유 및 할당 현황 - 클러스터별_"+DateUtil.getCurrentDate(), sheets);
    }


}

