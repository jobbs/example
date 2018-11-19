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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.StCludSwtchGoalRslt;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.stts.cludSwtchGoalRslt.service.CludSwtchGoalRsltService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludSwtchGoalRsltVo;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("cludSwtchGoalRsltController")

@RequestMapping("/dsb/stts/cludSwtchGoalRslt/cludSwtchGoalRslt")
public class CludSwtchGoalRsltController extends BaseController {

	@Resource(name = "cludSwtchGoalRsltService")
	CludSwtchGoalRsltService cludSwtchGoalRsltService;


	/**
	 * 클라우드 전환 목표 및 실적
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludSwtchGoalRsltList.do")
	public String selectCludReqPrcssStteList(
			HttpServletRequest request,
			Model model) throws Exception{
		List<String> yearList = cludSwtchGoalRsltService.select2011toCurrentYear();
		List<Map<String, Object>> dtlList = cludSwtchGoalRsltService.selectCludSwtchRsltDtl(yearList);
		List<CludSwtchGoalRsltVo> list = cludSwtchGoalRsltService.selectCludSwtchGoalRsltList();
		model.addAttribute("yearList",yearList);
		model.addAttribute("dtlList",dtlList);
		model.addAttribute("list",list);
		return dashTilesView(request,"selectCludSwtchGoalRsltList");
	}
	/**
	 * 클라우드 전환 목표 및 실적
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludSwtchGoalRsltView.do")
	public String insertCludSwtchGoalRsltView(
			HttpServletRequest request,
			Model model) throws Exception{
		List<String> yearList = cludSwtchGoalRsltService.select2011toCurrentYear();
		List<Map<String, Object>> list = cludSwtchGoalRsltService.selectCludSwtchGoalRsltDtl(yearList);
		model.addAttribute("yearList",yearList);
		model.addAttribute("list",list);
		return dashTilesView(request,"insertCludSwtchGoalRslt");
	}

	/**
	 * 클라우드 전환 목표 및 실적
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCludSwtchGoalRsltXlsDown.do")
	public void selectCludSwtchGoalRsltXlsDown(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{
		List<String> yearList = cludSwtchGoalRsltService.select2011toCurrentYear();
		List<Map<String, Object>> dtlList = cludSwtchGoalRsltService.selectCludSwtchRsltDtl(yearList);
		List<CludSwtchGoalRsltVo> list = cludSwtchGoalRsltService.selectCludSwtchGoalRsltList();

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("클라우드 전환 목표 및 실적");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);


        Row row0 = sheet.createRow(0);
        Cell titleCell0 = row0.createCell(0);	titleCell0.setCellValue( "클라우드 전환 목표 및 실적" );

		Row row = sheet.createRow(1);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "구분" );					titleCell2.setCellStyle(headerStyle);

		for(int i=0; i<yearList.size();i++){
			Cell titleCell3 = row.createCell(i+2);	titleCell3.setCellValue( yearList.get(i) );					titleCell3.setCellStyle(headerStyle);
		}


		Row dataRow = sheet.createRow(2);
		Cell dataCell00 = dataRow.createCell(0);	dataCell00.setCellValue("전환목표");
		Cell dataCell01 = dataRow.createCell(1);	dataCell01.setCellValue("업무수");
		for(int i=0; i<list.size(); i++){
			CludSwtchGoalRsltVo vo = (CludSwtchGoalRsltVo)list.get(i);
			Cell dataCell3 = dataRow.createCell(2+i);	dataCell3.setCellValue(vo.getGoalJobQty());
		}

		Row dataRow1 = sheet.createRow(3);
		Cell dataCell10 = dataRow1.createCell(0);	dataCell10.setCellValue("전화목표");
		Cell dataCell11 = dataRow1.createCell(1);	dataCell11.setCellValue("누적업무수(누계비율)");
		for(int i=0; i<list.size(); i++){
			CludSwtchGoalRsltVo vo = (CludSwtchGoalRsltVo)list.get(i);
			Cell dataCell3 = dataRow1.createCell(2+i);	dataCell3.setCellValue(vo.getSumGoalJobQty()+"("+vo.getGoalJobRt()+"%)");
		}

		Row dataRow2 = sheet.createRow(4);
		Cell dataCell20 = dataRow2.createCell(0);	dataCell20.setCellValue("전환실적");
		Cell dataCell21 = dataRow2.createCell(1);	dataCell21.setCellValue("업무수");
		for(int i=0; i<list.size(); i++){
			CludSwtchGoalRsltVo vo = (CludSwtchGoalRsltVo)list.get(i);
			Cell dataCell3 = dataRow2.createCell(2+i);	dataCell3.setCellValue( vo.getRsltJobQty()==null?"":Long.toString(vo.getRsltJobQty()));
		}

		Row dataRow3 = sheet.createRow(5);
		Cell dataCell30 = dataRow3.createCell(0);	dataCell30.setCellValue("전환실적");
		Cell dataCell31 = dataRow3.createCell(1);	dataCell31.setCellValue("누적업무수(누계비율)");
		for(int i=0; i<list.size(); i++){
			CludSwtchGoalRsltVo vo = (CludSwtchGoalRsltVo)list.get(i);
			Cell dataCell3 = dataRow3.createCell(2+i);
			if(vo.getRsltJobQty()==null){
				dataCell3.setCellValue("");
			}else{
				dataCell3.setCellValue(vo.getSumRsltJobQty()+"("+vo.getRsltJobRt()+"%)");
			}
		}


		Row dataRow4 = sheet.createRow(7);
		Cell dataCell40 = dataRow4.createCell(0);	dataCell40.setCellValue("클라우드 실적");


		Row row5 = sheet.createRow(8);
		Cell titleCell51 = row5.createCell(0);	titleCell51.setCellValue( "구분" );					titleCell51.setCellStyle(headerStyle);
		Cell titleCell52 = row5.createCell(1);	titleCell52.setCellValue( "구분" );					titleCell52.setCellStyle(headerStyle);
		Cell titleCell53 = row5.createCell(2);	titleCell53.setCellValue( "계" );					titleCell53.setCellStyle(headerStyle);
		sheet.setColumnWidth(0, 5000);sheet.setColumnWidth(1, 5000);sheet.setColumnWidth(2, 5000);
		for(int i=0; i<yearList.size();i++){
			Cell titleCell54 = row5.createCell(i+3);	titleCell54.setCellValue( yearList.get(i) );					titleCell54.setCellStyle(headerStyle);
			sheet.setColumnWidth(i+3, 5000);
		}

		for( int i=0;i<dtlList.size();i++){
			Map<String, Object> dtlMap = (Map<String, Object>)dtlList.get(i);
			Row row7 = sheet.createRow(9+i);
			Cell dataCell1 = row7.createCell(0); dataCell1.setCellValue((String)dtlMap.get("region_nm"));
			Cell dataCell2 = row7.createCell(1); dataCell2.setCellValue(i%2==1?"기관수":"업무수");
			Cell dataCell3 = row7.createCell(2); dataCell3.setCellValue(ObjectUtils.isEmpty(dtlMap.get("tot"))?"":dtlMap.get("tot").toString());
			for(int j=0;j<yearList.size();j++){
				Cell dataCell4 = row7.createCell(3+j); dataCell4.setCellValue(dtlMap.get(yearList.get(j))==null?"":dtlMap.get(yearList.get(j)).toString());
			}
		}

		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));//구분
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));//전환목표
		sheet.addMergedRegion(new CellRangeAddress(4,5,0,0));//전환실적
		sheet.addMergedRegion(new CellRangeAddress(8,8,0,1));//구분
		sheet.addMergedRegion(new CellRangeAddress(9,10,0,0));//구분
		sheet.addMergedRegion(new CellRangeAddress(11,12,0,0));//구분
		sheet.addMergedRegion(new CellRangeAddress(13,14,0,0));//
        OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("클라우드 전환 목표 및 실적").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}

	/**
	 * 클라우드 요청처리현황 등록
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCludSwtchGoalRslt.do")
	@OperateLog(action="클라우드 전환목표 및 실적 등록", desc="클라우드 전환목표 및 실적을 등록한다.",		params={"stdrYr","regionId","goalJobQty","rsltJobQty"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo insertCludSwtchGoalRslt(
			@RequestBody  List<StCludSwtchGoalRslt> reqPrcssStteVoList,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			cludSwtchGoalRsltService.insertCludSwtchGoalRslt(reqPrcssStteVoList);
		} catch (InstantiationException | IllegalAccessException | IOException | SQLException e) {
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}
}
