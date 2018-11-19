/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStPerInstController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcoptz.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.rsrcoptz.service.WthdrwStPerInstService;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("wthdrwStPerInstController")
@RequestMapping("/dsb/stts/rsrcoptz/wthdrwStPerInst")
public class WthdrwStPerInstController extends BaseController {


	@Resource(name="wthdrwStPerInstService")
	WthdrwStPerInstService wthdrwStPerInstService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 기관별 자원 회수 현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwStPerInstList.do")
	public String selectWthdrwStPerInstList( HttpServletRequest request,
			Model model, WthdrwStPerInstSearchVo searchVo) throws Exception{

		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		List<WthdrwStPerInstVo> list = null;
		if(searchVo.getYear() != null){
			list = wthdrwStPerInstService.selectWthdrwStPerInstList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectWthdrwStPerInstList");
	}



	/**
	 * 기관별 자원 회수 현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwStPerInstXlsDown.do")
	public void selectWthdrwStPerInstXlsDown(
			WthdrwStPerInstSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<WthdrwStPerInstVo> list = wthdrwStPerInstService.selectWthdrwStPerInstList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("rn", "번호");
        header.put("institutionNm", "기관명");
        header.put("returnReqQtyVm", "반납요구가상서버");
        header.put("returnReqQtyVcore", "반납요구vCore");
        header.put("returnReqQtyMem", "반납요구MEM");
        header.put("returnReqQtySan", "반납요구SAN");
        header.put("returnQtyVm", "반납가상서버");
        header.put("returnQtyVcore", "반납vCore");
        header.put("returnQtyMem", "반납MEM");
        header.put("returnQtySan", "반납SAN");
        header.put("returnRtVm", "가상서버반납률(%)");
        header.put("returnRtVcore", "vCore반납률(%)");
        header.put("returnRtMem", "MEM반납률(%)");
        header.put("returnRtSan", "SAN반납률(%)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("기관별 자원 회수 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "기관별 자원 회수 현황_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 기관별 자원 회수 현황 추가 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertWthdrwStPerInstView.do")
	public String insertWthdrwStPerInstView(
			HttpServletRequest request,
			Model model, WthdrwStPerInstSearchVo searchVo) throws Exception{

		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		List<WthdrwStPerInstVo> list = null;
		if(searchVo.getInstitutionId() != null && !searchVo.getInstitutionId().equals("")){
			list = wthdrwStPerInstService.selectWthdrwStPerInstView(searchVo);
		}
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("list", list);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"insertWthdrwStPerInst");
	}

	/**
	 * 클라우드 요청처리현황 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteWthdrwStPerInst.do")
	@OperateLog(action="기관별 자원 회수 현황 삭제", desc="기관별 자원 회수 현황을 삭제한다.",		params={"institutionId","year","ym"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo deleteWthdrwStPerInst(
			WthdrwStPerInstVo vo ,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		result.setSuccess(true);
		try{
			wthdrwStPerInstService.deleteWthdrwStPerInst(vo);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}



	/**
	 * 기관별 자원 회수 현황 등록 수정
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/insertWthdrwStPerInst.do")
	@OperateLog(action="기관별 자원 회수 현황 저장", desc="기관별 자원 회수 현황을 저장한다.",	params={"regionId","institutionId","year","quarter"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertWthdrwStPerInst(
			@RequestBody  List<WthdrwStPerInstVo> wthdrwStPerInstVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			wthdrwStPerInstService.insertWthdrwStPerInst(wthdrwStPerInstVoList);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}




}
