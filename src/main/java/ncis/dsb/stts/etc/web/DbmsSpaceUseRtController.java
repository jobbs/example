/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtController.java
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
import ncis.dsb.stts.etc.service.DbmsSpaceUseRtService;
import ncis.dsb.stts.etc.service.WasSmTimeConectService;
import ncis.dsb.stts.etc.vo.DbmsSpaceUseRtVo;
import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("dbmsSpaceUseRtController")
@RequestMapping("/dsb/stts/etc/dbmsSpaceUseRt")
public class DbmsSpaceUseRtController extends BaseController {


	@Resource(name="dbmsSpaceUseRtService")
	DbmsSpaceUseRtService dbmsSpaceUseRtService;

	@Resource(name="wasSmTimeConectService")
	WasSmTimeConectService wasSmTimeConectService;
	/**
	 * DBMS 공간사용률 버퍼캐시적중률
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectDbmsSpaceUseRtList.do")
	public String selectDbmsSpaceUseRtList( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo) throws Exception{

		List<DbmsSpaceUseRtVo> list = null;
		List<String> objList = null;
		List<String> dateList = null;
		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -14),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = dbmsSpaceUseRtService.selectDbmsSpaceUseRtList(searchVo);	// 게시글list 가져오기
			dateList = dbmsSpaceUseRtService.selectDbmsSpaceUseRtDateList( searchVo);
			objList= dbmsSpaceUseRtService.selectDbmsSpaceUseRtObjList( searchVo);
		}
		List<GcamObjVo> dbmsList = null;

		if(!StringUtils.isEmpty(searchVo.getJobId())){
			GcamObjSearchVo wasSearcVo = new GcamObjSearchVo();
			wasSearcVo.setJobId(searchVo.getJobId());
			wasSearcVo.setManagetypeId("DBMS");
			dbmsList = wasSmTimeConectService.selectJobWebWasDbmsList( wasSearcVo);

		}
		if(list!=null && list.size()>0){
			searchVo.setTotalRecordCount(list.get(0).getCnt());
		}
		model.addAttribute("list", list);
		model.addAttribute("objList", objList);
		model.addAttribute("dateList", dateList);


		model.addAttribute("searchVo", searchVo);
		model.addAttribute("dbmsList", dbmsList);

		return dashTilesView(request,"selectDbmsSpaceUseRtList");
	}
	/**
	 * DBMS 공간사용률 버퍼캐시적중률
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectDbmsSpaceUseRtXlsDown.do")
	public void selectDbmsSpaceUseRtxlsDown( HttpServletRequest request,
			Model model, GcamsSearchVo searchVo,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<DbmsSpaceUseRtVo> list = null;
		list = dbmsSpaceUseRtService.selectDbmsSpaceUseRtList(searchVo);
		if(list==null){
			list = new ArrayList<DbmsSpaceUseRtVo>();
		}

		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("checkDatetime", "일자");
        header.put("objName", "가상서버명");
        header.put("dbBufferCacheAvg", "버퍼캐시적중률(%)");
        header.put("dbSpaceUseRtAvg", "공간사용률(%)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("DBMS 공간사용률");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "DBMS 공간사용률 및 버퍼캐시 적중률"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);

	}



}
