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

import java.io.IOException;
import java.sql.SQLException;
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
import ncis.dsb.stts.reqPrcssStte.service.CludReqPrcssStteService;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("cludReqPrcssStteController")

@RequestMapping("/dsb/stts/reqPrcssStte/cludReqPrcssStte")
public class CludReqPrcssStteController extends BaseController {

	@Resource(name = "regionService")
    RegionService regionService;

	@Resource(name="cludReqPrcssStteService")
	CludReqPrcssStteService cludReqPrcssStteService;

	/**
	 * 클라우드 요청처리현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludReqPrcssStteList.do")
	public String selectCludReqPrcssStteList( ReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getTrm() == null) searchVo.setTrm("mm");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());

		List<RegionVo> regionVoList = regionService.selectRegionAllList();//센터 목록 조회
		List<ReqPrcssStteVo> list =null;
		if(searchVo.getSearch() != null){
			list = cludReqPrcssStteService.selectCludReqPrcssStteList(searchVo);
		}

		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectCludReqPrcssStteList");
	}
	/**
	 * 클라우드 요청처리현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludReqPrcssStteListXlsDown.do")
	public void selectCludReqPrcssStteListXlsDown( ReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<ReqPrcssStteVo> list =null;
			list = cludReqPrcssStteService.selectCludReqPrcssStteList(searchVo);

		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("ymNm", "구분");
        header.put("tot", "계");
        header.put("vmCreateQty", "가상서버 생성");
        header.put("vmRemoveQty", "가성서버 삭제");
        header.put("specUpdateQty", "스펙 변경");
        header.put("sanAddQty", "SAN 추가");
        header.put("withdrawQty", "SAN 회수");

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("클라우드 요청 처리 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "클라우드 요청 처리 현황"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
	}
	/**
	 * 클라우드 요청처리현황 상세
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludReqPrcssStteDtl.do")
	public String selectCludReqPrcssStteDtl( ReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{






		List<ReqPrcssStteVo> list =null;
			list = cludReqPrcssStteService.selectCludReqPrcssStteDtl(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectCludReqPrcssStteDtl");
	}
	/**
	 * 클라우드 요청처리현황 상세 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludReqPrcssStteDtlXlsDown.do")
	public void selectCludReqPrcssStteDtlXlsDown( ReqPrcssStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<ReqPrcssStteVo> list =null;
		list = cludReqPrcssStteService.selectCludReqPrcssStteDtl(searchVo);

		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("rnk", "No.");
        header.put("rsrcPoolId", "자원풀 코드");
        header.put("tot", "계");
        header.put("vmCreateQty", "가상서버 생성");
        header.put("vmRemoveQty", "가성서버 삭제");
        header.put("specUpdateQty", "스펙 변경");
        header.put("sanAddQty", "SAN 추가");
        header.put("withdrawQty", "SAN 회수");

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("클라우드 요청 처리 현황 상세");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "클라우드 요청 처리 현황 상세"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
	}

	/**
	 * 클라우드 요청처리현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludReqPrcssStteView.do")
	public String insertCludReqPrcssStteView(
			HttpServletRequest request,
			Model model) throws Exception{

		model.addAttribute("cmd", "I");
		model.addAttribute("searchVo", new ReqPrcssStteSearchVo());
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"insertCludReqPrcssStte");
	}

	/**
	 * 클라우드 요청처리현황 등록
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludReqPrcssStte.do")
	@OperateLog(action="클라우드 요청처리 현황 등록", desc="클라우드 요청처리 현황(SAN 회수)을 등록한다.",		params={"rsrcPoolId","institutionId","yy","mm"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertCludReqPrcssStte(
			@RequestBody  List<ReqPrcssStteVo> reqPrcssStteVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			cludReqPrcssStteService.insertCludReqPrcssStte(reqPrcssStteVoList);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

		/**
		 * 클라우드 요청처리현황 수정화면 호출
		 * @param request
		 * @param model
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/updateCludReqPrcssStteView.do")
		public String updateCludReqPrcssStteView(
				ReqPrcssStteSearchVo searchVo,
				HttpServletRequest request,
				Model model) throws Exception{

			List<ReqPrcssStteVo> list = cludReqPrcssStteService.selectSanWithdrawStte(searchVo);
			model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
			model.addAttribute("list", list);
			model.addAttribute("searchVo", searchVo);
			model.addAttribute("cmd", "U");


			return dashTilesView(request,"insertCludReqPrcssStte");
		}
		/**
		 * 클라우드 요청처리현황 수정
		 * @param request
		 * @param model
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/updateCludReqPrcssStte.do")
		@OperateLog(action="클라우드 요청처리 현황 수정", desc="클라우드 요청처리 현황(SAN 회수)을 수정한다.",		params={"rsrcPoolId","institutionId","yy","mm"}, actionType=ActionType.UPDATE)
		public  @ResponseBody ProcResultVo updateCludReqPrcssStte(
				@RequestBody  List<ReqPrcssStteVo> reqPrcssStteVoList,
				HttpServletRequest request,
				Model model) throws Exception{
			ProcResultVo result = new ProcResultVo();
			result.setProcType("update");
			result.setSuccess(true);
			try{
				cludReqPrcssStteService.updateCludReqPrcssStte(reqPrcssStteVoList);
			} catch (InstantiationException | IllegalAccessException | IOException e) {
				result.setSuccess(false);
				result.addMessage(e.getMessage());
			}

			return result;
		}
		/**
		 * 클라우드 요청처리현황 수정
		 * @param request
		 * @param model
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/deleteCludReqPrcssStte.do")
		@OperateLog(action="클라우드 요청처리 현황 삭제", desc="클라우드 요청처리 현황(SAN 회수)을 삭제한다.",		params={"rsrcPoolId","institutionId","year","ym"}, actionType=ActionType.UPDATE)
		public  @ResponseBody ProcResultVo deleteCludReqPrcssStte(
				ReqPrcssStteVo vo ,
				HttpServletRequest request,
				Model model) throws Exception{
			ProcResultVo result = new ProcResultVo();
			result.setProcType("update");
			result.setSuccess(true);
			try{
				cludReqPrcssStteService.deleteCludReqPrcssStte(vo);
			} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
				result.setSuccess(false);
				result.addMessage(e.getMessage());
			}

			return result;
		}
}
