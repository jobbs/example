/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmResStteController.java
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
package ncis.dsb.stts.reqPrcssStte.web;

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
import ncis.dsb.stts.reqPrcssStte.service.InsttReqPrcssStteService;
import ncis.dsb.stts.reqPrcssStte.vo.InsttReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("insttReqPrcssStteController")
@RequestMapping("/dsb/stts/reqPrcssStte/insttReqPrcssStte")
public class InsttReqPrcssStteController extends BaseController {

	@Resource(name = "regionService")
    RegionService regionService;

	@Resource(name="insttReqPrcssStteService")
	InsttReqPrcssStteService insttReqPrcssStteService;

	/**
	 * 기관별 요청처리현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttReqPrcssStteList.do")
	public String selectInsttReqPrcssStteList( InsttReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{


		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());

		List<RegionVo> regionVoList = regionService.selectRegionAllList();//센터 목록 조회
		List<ReqPrcssStteVo> list =null;
		if(searchVo.getSearch() != null){
			list = insttReqPrcssStteService.selectInsttReqPrcssStteList(searchVo);
		}

		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return dashTilesView(request,"selectInsttReqPrcssStteList");
	}
	/**
	 * 클라우드 요청처리현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttReqPrcssStteListXlsDown.do")
	public void selectInsttReqPrcssStteListXlsDown( InsttReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<ReqPrcssStteVo> list =null;
		list = insttReqPrcssStteService.selectInsttReqPrcssStteList(searchVo);

		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("institutionNm", "기관명");
        header.put("tot", "계");
        header.put("vmCreateQty", "가상서버 생성");
        header.put("vmRemoveQty", "가성서버 삭제");
        header.put("specUpdateQty", "스펙 변경");
        header.put("sanAddQty", "SAN 추가");
        header.put("withdrawQty", "SAN 회수");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("기관별 요청 처리 현황 상세");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "기관별 요청 처리 현황 상세"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
	}
}
