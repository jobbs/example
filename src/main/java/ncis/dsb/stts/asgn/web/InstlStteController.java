/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InstlStteController.java
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
import ncis.dsb.stts.asgn.service.InstlService;
import ncis.dsb.stts.asgn.vo.InstlSearchVo;
import ncis.dsb.stts.asgn.vo.InstlVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("InstlController")
@RequestMapping("/dsb/stts/asgn/instl")
public class InstlStteController extends BaseController {


	@Resource(name="instlService")
	InstlService instlService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원풀 구축 현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInstlList.do")
	public String selectInstlList( HttpServletRequest request,
			Model model, InstlSearchVo searchVo) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH)+1);

		if(mm.length() < 2) mm = "0"+ mm;

		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getMm() == null) searchVo.setMm(mm);

		List<InstlVo> list = null;
		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		if(searchVo.getSearch() != null){
			list = instlService.selectInstlList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("mmList", mmList);

		return dashTilesView(request,"selectInstlList");
	}

	/**
	 * 자원풀 구축 현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInstlXlsDown.do")
	public void selectInstlXlsDown(
			InstlSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<InstlVo> list = instlService.selectInstlList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("rn", "번호");
        header.put("zoneNm", "Zone");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀 코드");
        header.put("cdNm", "가상화SW");
        header.put("instlYear", "최초 구축");
        header.put("hwKnd", "HW 종류");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원풀 구축 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원풀 구축 현황_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자원풀 구축 현황  수정 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertInstlView.do")
	public String inserInstlView(
			HttpServletRequest request,
			Model model, InstlSearchVo searchVo) throws Exception{

		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		List<InstlVo> list = null;
		if(searchVo.getRsrcPoolId() != null && !searchVo.getRsrcPoolId().equals("")){
			list = instlService.selectInstlView(searchVo);
		}
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("list", list);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"insertInstl");
	}

	/**
	 * 자원풀 구축 현황 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteInstl.do")
	@OperateLog(action="자원풀 구축 현황 삭제", desc="자원풀 구축 현황을 삭제한다.",		params={"rsrcPoolId","instlYear","hwKnd"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo deleteInstl(
			InstlVo vo ,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		try{

			result.setProcType("delete");
			result.setSuccess(true);
			instlService.deleteInstl(vo);
		}catch(IllegalArgumentException ie){
			result.setSuccess(false);
			result.addMessage(ie.getMessage());
		}catch(Exception e){	// NOPMD
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}
	/**
	 * 자원풀 구축 현황 입력 또는 수정
	 * @param request
	 * @param model
	 * @param WthdrwStVo
	 * @return
	 */
	@RequestMapping(value="/insertInstl.do", method=RequestMethod.POST)
	@OperateLog(action="자원풀 구축 현황 등록 수정", desc="자원풀 구축 현황을 등록 수정 한다.",	params={"rsrcPoolId","instlYear","hwKnd"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertInstl(
			@RequestBody  List<InstlVo> InstVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();

		try{
			result.setProcType("insert");
			result.setSuccess(true);
			instlService.insertInstl(InstVoList);
		}catch(IllegalArgumentException ie){
			result.setSuccess(false);
			result.addMessage(ie.getMessage());
		}catch(Exception e){ // NOPMD
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

}
