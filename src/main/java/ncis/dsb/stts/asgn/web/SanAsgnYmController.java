/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanAsgnYmController.java
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
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.asgn.service.SanAsgnYmService;
import ncis.dsb.stts.asgn.vo.SanAsgnYmSearchVo;
import ncis.dsb.stts.asgn.vo.SanAsgnYmVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("SanAsgnYmController")
@RequestMapping("/dsb/stts/asgn/san")
public class SanAsgnYmController extends BaseController {


	@Resource(name="sanAsgnYmService")
	SanAsgnYmService sanAsgnYmService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanAsgnYmList.do")
	public String selectSanAsgnYmList( HttpServletRequest request,
			Model model, SanAsgnYmSearchVo searchVo) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH)+1);

		if(mm.length() < 2) mm = "0"+ mm;

		if(searchVo.getYear() == null) searchVo.setYear(year);

		List<SanAsgnYmVo> list = null;
		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		if(searchVo.getSearch() != null){
			list = sanAsgnYmService.selectSanAsgnYmList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("mmList", mmList);

		return dashTilesView(request,"selectSanAsgnYmList");
	}

	/**
	 * 자원 보유 및 할당 현황 상세- SAN 스토리지
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanAsgnRsrcList.do")
	public String selectSanAsgnRsrcList( HttpServletRequest request,
			Model model, SanAsgnYmSearchVo searchVo) throws Exception{


		List<SanAsgnYmVo> list = null;


		if(searchVo.getSearch() != null){
			list = sanAsgnYmService.selectSanAsgnRsrcList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectSanAsgnRsrcList");
	}

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanAsgnYmXlsDown.do")
	public void selectSanAsgnYmXlsDown(
			SanAsgnYmSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<SanAsgnYmVo> list = sanAsgnYmService.selectSanAsgnYmList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("mm", "구분");
        header.put("phyCapa", "물리용량(GB)");
        header.put("keepCapa", "보유량(GB)");
        header.put("totAsgnCapa", "총할당량(GB)");
        header.put("vmAsgnCapa", "가상서버 할당량(GB)");
        header.put("unusedLunCapa", "미사용LUN용량(GB)");
        header.put("unusedLunQty", "미사용LUN수");
        header.put("marginQty", "실여유량(GB)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원 보유 및 할당 현황 - SAN 스토리지");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원 보유 및 할당 현황 - SAN 스토리지_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자원 보유 및 할당 현황 상세 - SAN 스토리지 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectSanAsgnRsrcXlsDown.do")
	public void selectSanAsgnRsrcXlsDown(
			SanAsgnYmSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<SanAsgnYmVo> list = sanAsgnYmService.selectSanAsgnRsrcList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("rn", "번호");
        header.put("rsrcPoolNm", "자원풀코드");
        header.put("phyCapaS", "물리용량(GB)");
        header.put("keepCapa", "보유량(GB)");
        header.put("totAsgnCapa", "총할당량(GB)");
        header.put("vmAsgnCapa", "가상서버 할당량(GB)");
        header.put("unusedLunCapa", "미사용LUN용량(GB)");
        header.put("unusedLunQty", "미사용LUN수");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원 보유 및 할당 현황 상세 - SAN 스토리지");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원 보유 및 할당 현황 상세 - SAN 스토리지_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자원 보유 및 할당 현황 상세 - SAN 스토리지 추가 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertSanAsgnView.do")
	public String insertSanAsgnView(
			HttpServletRequest request,
			Model model, SanAsgnYmSearchVo searchVo) throws Exception{
		Calendar t = Calendar.getInstance();
		String mm = Integer.toString(t.get(Calendar.MONTH)+1);

		if(mm.length() < 2) mm = "0"+ mm;
		if(searchVo.getMm() == null) searchVo.setMm(mm);
		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		List<SanAsgnYmVo> list = null;
		if(searchVo.getRsrcPoolId() != null && !searchVo.getRsrcPoolId().equals("")){
			list = sanAsgnYmService.selectSanAsgnView(searchVo);
		}
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("mmList", mmList);
		model.addAttribute("list", list);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"insertSanAsgn");
	}


	/**
	 * 자원 보유 및 할당 현황 상세 - SAN 스토리지 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteSanAsgn.do")
	@OperateLog(action="SAN 스토리지 현황 삭제", desc="SAN 스토리지 현황을 삭제한다.",		params={"rsrcPoolId","year","mm"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo deleteSanAsgn(
			@RequestBody List<SanAsgnYmVo> voList ,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		result.setSuccess(true);
		try{
			sanAsgnYmService.deleteSanAsgn(voList);
		}catch(Exception e){
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 자원 보유 및 할당 현황 상세 - SAN 스토리지 입력 또는 수정
	 * @param request
	 * @param model
	 * @param WthdrwStVo
	 * @return
	 */
	@RequestMapping(value="/insertSanAsgn.do", method=RequestMethod.POST)
	@OperateLog(action="자원 보유 및 할당 현황 상세 - SAN 스토리지 등록 수정", desc="자원 보유 및 할당 현황 상세 - SAN 스토리지을 등록 수정 한다.",	params={"rsrcPoolId","year","mm"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertSanAsgn(
			@RequestBody  List<SanAsgnYmVo> SanAsgnYmVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			sanAsgnYmService.insertSanAsgn(SanAsgnYmVoList);
		}catch(Exception e){
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

}
