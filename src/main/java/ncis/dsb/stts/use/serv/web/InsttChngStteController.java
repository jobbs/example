/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttChngStteController.java
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
package ncis.dsb.stts.use.serv.web;

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
import ncis.dsb.stts.use.serv.service.InsttChngStteService;
import ncis.dsb.stts.use.serv.vo.InsttChngStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttChngStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("insttChngStteController")
@RequestMapping("/dsb/stts/use/insttchng")
public class InsttChngStteController extends BaseController {


	@Resource(name="insttChngStteService")
	InsttChngStteService insttChngStteService;

	@Resource(name = "regionService")
    RegionService regionService;
	/**
	 * 기관별 변동 현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttChngStteList.do")
	public String selectInsttChngStteList( HttpServletRequest request,InsttChngStteSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());


		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<InsttChngStteVo> list = null;
		if(searchVo.getSearch() != null){
			list = insttChngStteService.selectInsttChngStteList(searchVo);	// 게시글list 가져오기
		}
		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectInsttChngStteList");
	}

	/**
	 * 기관별 변동 현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selecInsttChngStteXlsDown.do")
	public void selecInsttChngStteXlsDown(
			InsttChngStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<InsttChngStteVo> list = null;
		if(searchVo.getSearch() != null){
			list = insttChngStteService.selectInsttChngStteList(searchVo);	// 게시글list 가져오기
		}
	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("regionNm", "센터명");
        header.put("institutionNm", "기관명");
        header.put("jobId1", "업무수1분기");
        header.put("jobId2", "업무수2분기");
        header.put("jobId3", "업무수3분기");
        header.put("jobId4", "업무수4분기");
        header.put("vmSeq1", "가상서버수1분기");
        header.put("vmSeq2", "가상서버수2분기");
        header.put("vmSeq3", "가상서버수3분기");
        header.put("vmSeq4", "가상서버수4분기");
        header.put("servcSeq1", "서비스수1분기");
        header.put("servcSeq2", "서비스수2분기");
        header.put("servcSeq3", "서비스수3분기");
        header.put("servcSeq4", "서비스수4분기");



        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("기관별 변동현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "기관별 변동현황_"+DateUtil.getCurrentDate(), sheets);
    }


}
