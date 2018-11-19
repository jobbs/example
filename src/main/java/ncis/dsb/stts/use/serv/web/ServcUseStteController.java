/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmResStteController.java
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
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import ncis.dsb.stts.use.serv.service.ServcUseStteService;
import ncis.dsb.stts.use.serv.vo.ServcUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.ServcUseStteVo;

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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("servcUseStteController")
@RequestMapping("/dsb/stts/use/serv")
public class ServcUseStteController extends BaseController {


	@Resource(name="servcUseStteService")
	ServcUseStteService servcUseStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 클라우드 서비스 이용현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectServcUseStteList.do")
		public String selectServcUseStteList( HttpServletRequest request,
			Model model, ServcUseStteSearchVo searchVo) throws Exception{


		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getTrm() == null) searchVo.setTrm("mm");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());


		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<ServcUseStteVo> list = null;
		List<ServcUseStteVo> atmSclList = null;

		if(searchVo.getSearch() != null){
				list = servcUseStteService.selectServcUseStteList(searchVo);
				atmSclList = servcUseStteService.selectServcUseStteAtmSclList(searchVo);
		}
		model.addAttribute("list", list);
		model.addAttribute("atmSclList", atmSclList);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectServcUseStteList");
	}

	/**
	 * 클라우드 서비스 이용현황 엑셀 다운(가상서버)
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectServUseStteXlsDown.do")
	public void selectServUseStteXlsDown(
			ServcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{



		List<ServcUseStteVo> list = servcUseStteService.selectServcUseStteList(searchVo);

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("클라우드 서비스 이용 현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관수" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "이용업무수" );			titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "OS별 가상서버수" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "OS별 가상서버수" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "OS별 가상서버수" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "OS별 가상서버수" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "OS별 가상서버수" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "논리자원 할당량" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "논리자원 할당량" );		titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "논리자원 할당량" );		titleCell11.setCellStyle(headerStyle);


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );			titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관수" );		titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "이용업무수" );	titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "계" );			titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "LINUX" );			titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "WIN" );			titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "HP" );			titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "AIX" );			titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "vCore" );			titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );	titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "SAN(GB)" );	titleCell11.setCellStyle(headerStyle);

		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//구분
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));//기관수
		sheet.addMergedRegion(new CellRangeAddress(0,1,2,2));//업무수
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,7));//OS별 가상서버수
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,10));//논리자원 할당량

		sheet.addMergedRegion(new CellRangeAddress(1,1,3,3));//계
		sheet.addMergedRegion(new CellRangeAddress(1,1,4,4));//LINUX
		sheet.addMergedRegion(new CellRangeAddress(1,1,5,5));//WIN
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,6));//HP
		sheet.addMergedRegion(new CellRangeAddress(1,1,7,7));//AIX
		sheet.addMergedRegion(new CellRangeAddress(1,1,8,8));//vCore
		sheet.addMergedRegion(new CellRangeAddress(1,1,9,9));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,1,10,10));//SAN


		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,21));
			list = new ArrayList<ServcUseStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			ServcUseStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(vo.getMm().toString() );
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getInstitutionId()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getJobId()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getTot()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getLinux()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getWin()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getHp()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getAix()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("클라우드 서비스 이용 현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();



    }



	/**
	 * 클라우드 서비스 이용현황 엑셀 다운(자동확장)
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectServUseStteAtmSclXlsDown.do")
	public void selectServUseStteAtmSclXlsDown(
			ServcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("mm", "구분");
        header.put("institutionId", "기관수");
        header.put("jobId", "이용업무수");
        header.put("tot", "서비스수");
        header.put("cpuAsgnCapa", "Core");
        header.put("memTotCapa", "MEM(GB)");
        header.put("strgTotCapa", "STORAGE(GB)");

        List<ServcUseStteVo> list = servcUseStteService.selectServcUseStteAtmSclList(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("클라우드 자동확장 서비스 이용 현황");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("클라우드 자동확장 서비스 이용 현황_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

}
