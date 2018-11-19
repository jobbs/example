/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStController.java
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
import ncis.dsb.stts.rsrcoptz.service.WthdrwStService;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("wthdrwStController")
@RequestMapping("/dsb/stts/rsrcoptz/wthdrwSt")
public class WthdrwStController extends BaseController {


	@Resource(name="wthdrwStService")
	WthdrwStService wthdrwStService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원 회수 현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwStList.do")
	public String selectWthdrwStList( HttpServletRequest request,
			Model model, WthdrwStSearchVo searchVo) throws Exception{

		List<WthdrwStVo> list = null;

		if(searchVo.getYear() != null){
			list = wthdrwStService.selectWthdrwStList(searchVo);
		}

		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectWthdrwStList");
	}

	/**
	 * 자원 회수 현황 상세 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwRsrcList.do")
	public String selectWthdrwRsrcList( HttpServletRequest request,
			Model model, WthdrwStSearchVo searchVo) throws Exception{

		List<WthdrwStVo> list = null;

		if(searchVo.getYear() != null){
			list = wthdrwStService.selectWthdrwRsrcList(searchVo);
		}


		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectWthdrwRsrcList");
	}




	/**
	 * 자원 회수 현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwStXlsDown.do")
	public void selectWthdrwStXlsDown(
			WthdrwStSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<WthdrwStVo> list = wthdrwStService.selectWthdrwStList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("quarterK", "구분");
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
        sheet.setSheetName("자원 회수 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원 회수 현황_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자원 회수 상세 현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectWthdrwRsrcXlsDown.do")
	public void selectWthdrwRsrcXlsDown(
			WthdrwStSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		List<WthdrwStVo> list = wthdrwStService.selectWthdrwRsrcList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("rn", "번호");
        header.put("rsrcPoolId", "자원풀코드");
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
        sheet.setSheetName("자원 회수 상세 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자원 회수 상세 현황_"+DateUtil.getCurrentDate(), sheets);
    }


	/**
	 * 자원 회수 현황 추가 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertWthdrwStView.do")
	public String insertWthdrwStView(
			HttpServletRequest request,
			Model model, WthdrwStSearchVo searchVo) throws Exception{

		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		List<WthdrwStVo> list = null;
		if(searchVo.getRsrcPoolId() != null && !searchVo.getRsrcPoolId().equals("")){
			list = wthdrwStService.selectWthdrwStView(searchVo);
		}
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("list", list);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"insertWthdrwSt");
	}

	/**
	 * 자원 회수 현황 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteWthdrwSt.do")
	@OperateLog(action="자원 회수 현황 삭제", desc="자원 회수 현황을 삭제한다.",		params={"rsrcPoolId","year","ym"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo deleteWthdrwSt(
			 WthdrwStVo vo ,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		result.setSuccess(true);
		try{
			wthdrwStService.deleteWthdrwSt(vo);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}



	/**
	 * 자원 회수 현황 입력 또는 수정
	 * @param request
	 * @param model
	 * @param WthdrwStVo
	 * @return
	 */
	@RequestMapping(value="/insertWthdrwSt.do", method=RequestMethod.POST)
	@OperateLog(action="자원 회수 현황 등록 수정", desc="자원 회수 현황을 등록 수정 한다.",	params={"regionId","rsrcPoolId","year","quarter"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertWthdrwStPerInst(
			@RequestBody  List<WthdrwStVo> wthdrwStVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			wthdrwStService.insertWthdrwSt(wthdrwStVoList);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

}
