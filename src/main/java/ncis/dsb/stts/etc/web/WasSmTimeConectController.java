/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasSmTimeConectController.java
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
package ncis.dsb.stts.etc.web;

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
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.dsb.stts.etc.service.WasSmTimeConectService;
import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WasVstrQtyVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("wasSmTimeConectController")
@RequestMapping("/dsb/stts/etc/wasSmTimeConect")
public class WasSmTimeConectController extends BaseController {


	@Resource(name="wasSmTimeConectService")
	WasSmTimeConectService wasSmTimeConectService;

	/**
	 * WAS 동시접속자 및 일일방문자
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWasSmTimeConectList.do")
	public String selectWasSmTimeConectList( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo) throws Exception{
		List<WasVstrQtyVo> list = null;
		List<String> objList = null;
		List<String> dateList = null;
		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -14),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = wasSmTimeConectService.selectWasSmTimeConectList( searchVo);	// 게시글list 가져오기
			dateList = wasSmTimeConectService.selectWasDailyVstrQtyDateList( searchVo);
			objList= wasSmTimeConectService.selectWasDailyVstrQtyObjList( searchVo);
		}
		List<GcamObjVo> wasList = null;

		if(!StringUtils.isEmpty(searchVo.getJobId())){
			GcamObjSearchVo wasSearcVo = new GcamObjSearchVo();
			wasSearcVo.setJobId(searchVo.getJobId());
			wasSearcVo.setManagetypeId("WAS");
			wasList = wasSmTimeConectService.selectJobWebWasDbmsList( wasSearcVo);

		}
		if(list!=null && list.size()>0){
			searchVo.setTotalRecordCount(list.get(0).getCnt());
		}
		model.addAttribute("list", list);
		model.addAttribute("objList", objList);
		model.addAttribute("dateList", dateList);


		model.addAttribute("searchVo", searchVo);
		model.addAttribute("wasList", wasList);
		return dashTilesView(request,"selectWasSmTimeConectList");
	}

	/**
	 * WAS 동시접속자 및 일일방문자 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWasSmTimeConectXlsDown.do")
	public void selectWasSmTimeConectXlsDown( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{
		List<WasVstrQtyVo> list = null;
		list = wasSmTimeConectService.selectWasSmTimeConectList( searchVo);	// 게시글list 가져오기
		if(list==null){
			list = new ArrayList<WasVstrQtyVo>();
		}
		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("checkDatetime", "일자");
        header.put("objName", "가상서버명");
        header.put("maxCncrtUsertQty", "최대 동시접속자 수");
        header.put("maxDailyVstrQty", "방문자수");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("(WAS)일일 방문자");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "일일 방문자 및 동시접속자_"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
	}

	/**
	 * GCAMS의 WEB SERVER, WAS, DBMS 목록 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobWebWasDbmsList.do")
	@ResponseBody
	public ProcResultVo selectJobWebWasDbmsList( HttpServletRequest request,
			Model model, GcamObjSearchVo searchVo) throws Exception{

		ProcResultVo result = new ProcResultVo();
		
		List<?> list = wasSmTimeConectService.selectJobWebWasDbmsList(searchVo);	// 게시글list 가져오기

		result.setProcType("select");
		result.setSuccess(true);
		result.setData(list);

		return result;
	}
}
