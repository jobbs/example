/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WebVstrController.java
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
import ncis.cmn.web.BaseController;
import ncis.dsb.stts.etc.service.WasSmTimeConectService;
import ncis.dsb.stts.etc.service.WebReqPageIncrService;
import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WebReqPageQtyVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("webReqPageIncrController")
@RequestMapping("/dsb/stts/etc/webVstr")
public class WebReqPageIncrController extends BaseController {


	@Resource(name="webReqPageIncrService")
	WebReqPageIncrService webReqPageIncrService;

	@Resource(name="wasSmTimeConectService")
	WasSmTimeConectService wasSmTimeConectService;

	/**
	 * 요청 페이지 증가량
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWebReqPageIncrList.do")
	public String selectWebReqPageIncrList( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo) throws Exception{

		List<WebReqPageQtyVo> list = null;
		List<String> objList = null;
		List<String> dateList = null;
		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -14),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = webReqPageIncrService.selectWebReqPageIncrList(searchVo);
			dateList = webReqPageIncrService.selectWebReqPageIncrDateList( searchVo);
			objList= webReqPageIncrService.selectWebReqPageIncrObjList( searchVo);
		}
		List<GcamObjVo> webList = null;

		if(!StringUtils.isEmpty(searchVo.getJobId())){
			GcamObjSearchVo wasSearcVo = new GcamObjSearchVo();
			wasSearcVo.setJobId(searchVo.getJobId());
			wasSearcVo.setManagetypeId("WEB");
			webList = wasSmTimeConectService.selectJobWebWasDbmsList( wasSearcVo);

		}
		if(list!=null && list.size()>0){
			searchVo.setTotalRecordCount(list.get(0).getCnt());
		}
		model.addAttribute("list", list);
		model.addAttribute("objList", objList);
		model.addAttribute("dateList", dateList);


		model.addAttribute("searchVo", searchVo);
		model.addAttribute("webList", webList);

		return dashTilesView(request,"selectWebReqPageIncrList");
	}
	/**
	 * 요청 페이지 증가량
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWebReqPageIncrXlsDown.do")
	public void selectWebReqPageIncrXlsDown( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<WebReqPageQtyVo> list = null;

		list = webReqPageIncrService.selectWebReqPageIncrList(searchVo);
		if(list==null){
			list = new ArrayList<WebReqPageQtyVo>();
		}
		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("checkDatetime", "일자");
        header.put("objName", "가상서버명");
        header.put("reqPageMax", "요청페이지 수");
        header.put("hitMax", "히트 수");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("요청페이지 수 및 히트 수");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "요청페이지수 및 히트수"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
	}
}
