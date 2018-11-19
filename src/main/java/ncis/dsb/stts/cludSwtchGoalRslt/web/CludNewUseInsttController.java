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
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.StYrCludNwUseInstitution;
import ncis.cmn.util.DateUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.stts.cludSwtchGoalRslt.service.CludNewUseInsttService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludNewUseInsttVo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("cludNewUseInsttController")
@RequestMapping("/dsb/stts/cludSwtchGoalRslt/cludNewUseInstt")
public class CludNewUseInsttController extends BaseController {


	@Resource(name="cludNewUseInsttService")
	CludNewUseInsttService cludNewUseInsttService;

	/**
	 * 클라우드 신규이용 기관
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludNewUseInsttList.do")
	public String selectCludNewUseInsttList(
			HttpServletRequest request,
			Model model) throws Exception{
		StYrCludNwUseInstitution vo =  new StYrCludNwUseInstitution();
		List<CludNewUseInsttVo> list = cludNewUseInsttService.selectCludNewUseInsttList(vo);
		model.addAttribute("list", list);
		return dashTilesView(request,"selectCludNewUseInsttList");
	}
	/**
	 * 클라우드 신규이용 기관 등록화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludNewUseInsttView.do")
	public String insertCludNewUseInsttListView(
			HttpServletRequest request,
			Model model) throws Exception{
		List<String> yearList = cludNewUseInsttService.selectRegPosblYear();

		model.addAttribute("yearList", yearList);
		model.addAttribute("cmd", "I");
		return dashTilesView(request,"insertCludNewUseInstt");
	}
	/**
	 * 클라우드 신규이용 기관 수정화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCludNewUseInsttView.do")
	public String updateCludNewUseInsttView( StYrCludNwUseInstitution searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<String> yearList = new ArrayList<String>();
		yearList.add(searchVo.getStdrYr());
		List<CludNewUseInsttVo> list = cludNewUseInsttService.selectCludNewUseInsttDtl(searchVo);
		model.addAttribute("list", list);
		model.addAttribute("yearList", yearList);
		model.addAttribute("cmd", "U");
		return dashTilesView(request,"insertCludNewUseInstt");
	}

	/**
	 * 클라우드 요청처리현황 등록
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludNewUseInstt.do")
	@OperateLog(action="G-클라우드 신규 이용기관 등록", desc="G-클라우드 신규 이용기관을 등록한다.",		params={"stdrYr","institutionId","jobQty"}, actionType=ActionType.INSERT)
	public  @ResponseBody ProcResultVo insertCludNewUseInstt(
			@RequestBody  List<StYrCludNwUseInstitution> listParam,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			cludNewUseInsttService.insertCludNewUseInstt(listParam);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
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
	@RequestMapping(value="/updateCludNewUseInstt.do")
	@OperateLog(action="G-클라우드 신규 이용기관 수정", desc="G-클라우드 신규 이용기관을 수정한다.",		params={"stdrYr","institutionId","jobQty"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo updateCludNewUseInstt(
			@RequestBody  List<StYrCludNwUseInstitution> listParam,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("update");
		result.setSuccess(true);
		try{
			cludNewUseInsttService.updateCludNewUseInstt(listParam);

		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}
	/**
	 * 클라우드 요청처리현황 등록
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCludNewUseInstt.do")
	@OperateLog(action="G-클라우드 신규 이용기관 삭제", desc="G-클라우드 신규 이용기관을 삭제한다.",		params={"stdrYr"}, actionType=ActionType.DELETE)
	public  @ResponseBody ProcResultVo deleteCludNewUseInstt(
			StYrCludNwUseInstitution vo,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		result.setSuccess(true);
		try{
			cludNewUseInsttService.deleteCludNewUseInstt(vo);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}
		return result;
	}

		/**
		 * 클라우드 전환 목표 및 실적
		 * @param request
		 * @param model
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/selectCludNewUseInsttXlsDown.do")
		public void selectCludNewUseInsttXlsDown(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model) throws Exception{
			StYrCludNwUseInstitution paramVo =  new StYrCludNwUseInstitution();
			List<CludNewUseInsttVo> list = cludNewUseInsttService.selectCludNewUseInsttList(paramVo);

			Workbook workBook = new XSSFWorkbook();
			Sheet sheet = workBook.createSheet("G-클라우드 신규 이용기관");

			CellStyle headerStyle = workBook.createCellStyle();
	        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
	        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

	        Font font = workBook.createFont();
	        font.setColor(IndexedColors.WHITE.getIndex());
	        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

	        headerStyle.setFont(font);


			Row row = sheet.createRow(0);
			for(int i=0;i<list.size(); i++){
				CludNewUseInsttVo insttVo = list.get(i);
				Cell titleCell1 = row.createCell(i);	titleCell1.setCellValue( insttVo.getStdrYr() );					titleCell1.setCellStyle(headerStyle);
			}



			Row dataRow = sheet.createRow(1);
			CellStyle dataStyle = workBook.createCellStyle();
			dataStyle.setWrapText(true);//줄바꿈 처리
			for(int i=0; i<list.size(); i++){
				CludNewUseInsttVo insttVo = list.get(i);
				Cell dataCell3 = dataRow.createCell(i);	dataCell3.setCellValue(insttVo.getInstitutionNm());	dataCell3.setCellStyle(dataStyle);
				sheet.setColumnWidth(i, 8000);
			}

			Row dataRow1 = sheet.createRow(2);
			for(int i=0; i<list.size(); i++){
				CludNewUseInsttVo insttVo = list.get(i);
				Cell dataCell3 = dataRow1.createCell(i);
				dataCell3.setCellValue("업무수 : "+insttVo.getJobQty()+" / "+insttVo.getSumJobQty()+
										"\n기관수 : "+insttVo.getInstitutionQty()+" / "+insttVo.getSumInstitutionQty());
				dataCell3.setCellStyle(dataStyle);

			}


	        OutputStream out = response.getOutputStream();
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("연도별 G-클라우드 신규 이용기관").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

	        workBook.write(out);
	        out.flush();
	        out.close();

		}
}
