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
package ncis.dsb.stts.cludSwtchGoalRslt.web;

import java.io.IOException;
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
import ncis.cmn.vo.CommonSearchVo;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.stts.cludSwtchGoalRslt.service.InsttSwtchStteService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.InsttSwtchStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller("insttSwtchStteController")

@RequestMapping("/dsb/stts/cludSwtchGoalRslt/insttSwtchStte")
public class InsttSwtchStteController extends BaseController {

	@Resource(name = "insttSwtchStteService")
	InsttSwtchStteService insttSwtchStteService;


	/**
	 * 기관별 전환현황 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttSwtchStteList.do")
	public String selectInsttSwtchStteList(
			CommonSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<InsttSwtchStteVo> list = insttSwtchStteService.selectInsttSwtchStteList(searchVo);
		model.addAttribute("list",list);
		model.addAttribute("searchVo",searchVo);
		return dashTilesView(request,"selectInsttSwtchStteList");
	}
	/**
	 * 기관별 전환현황 등록화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertInsttSwtchStteView.do")
	public String insertInsttSwtchStteView(
			CommonSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<InsttSwtchStteVo> list = insttSwtchStteService.selectInsttSwtchStteList(searchVo);
		model.addAttribute("list",list);
		model.addAttribute("searchVo",searchVo);
		return dashTilesView(request,"insertInsttSwtchStte");
	}

	/**
	 * 기관별 전환현황 등록
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertInsttSwtchStte.do")
	@OperateLog(action="기관별 전환 현황 등록", desc="기관별 전환 현황을 등록한다.",		params={"institutionId","swtchJobQty","primeSwtchExam"}, actionType=ActionType.INSERT)
	public  @ResponseBody ProcResultVo insertCludReqPrcssStte(
			@RequestBody  List<InsttSwtchStteVo> list,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			insttSwtchStteService.insertCludReqPrcssStte(list);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}

		/**
		 * 클라우드 요청처리현황
		 * @param request
		 * @param model
		 * @return
		 * @throws Exception
		 */
	@RequestMapping(value="/selectInsttSwtchStteXlsDown.do")
	public void selectCludReqPrcssStteListXlsDown( CommonSearchVo searchVo,
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws Exception{

			PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(1);
			paginationInfo.setRecordCountPerPage(1000000);
			searchVo.setPaginationInfo(paginationInfo);
			List<InsttSwtchStteVo> list = insttSwtchStteService.selectInsttSwtchStteList(searchVo);

			//CusomSheet 생성
		    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		    //첫번째 Sheet Header 생성
		    Map<String, String> header = new LinkedHashMap<String, String>();
		    header.put("rnk", "No.");
	        header.put("institutionNm", "기관명");
	        header.put("swtchJobQty", "전환 업무 수");
	        header.put("primeSwtchExam", "주요 전환 사례");

	        //첫번째 Sheet setting
	        CustomSheet sheet = new CustomSheet();
	        sheet.setSheetName("기관별 전환 현황");
	        sheet.setDatas(list);
	        sheet.setHreader(header);

	        sheets.add(sheet);


	        //Excel 생성
	        ExcelUtil.downloadExcel(response, "기관별 전환 현황"+DateUtil.getCurrentDate("yyyyMMdd"), sheets);
		}
}
