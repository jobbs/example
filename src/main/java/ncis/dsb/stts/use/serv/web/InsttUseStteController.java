/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttUseStteController.java
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.use.serv.service.InsttUseStteService;
import ncis.dsb.stts.use.serv.vo.InsttUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttUseStteVo;

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

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("insttUseStteController")
@RequestMapping("/dsb/stts/use/instt")
public class InsttUseStteController extends BaseController {


	@Resource(name="insttUseStteService")
	InsttUseStteService insttUseStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 기관별 이용현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectInsttUseStteList.do")
	public String selectInsttUseStteList( HttpServletRequest request,
			Model model, InsttUseStteSearchVo searchVo) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getTrm() == null) searchVo.setTrm("mm");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());


		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<InsttUseStteVo> list = null;
		List<InsttUseStteVo> atmSclList = null;

		if(searchVo.getSearch() != null){

			list = insttUseStteService.selectInsttUseStteList(searchVo);	// 게시글list 가져오기
			atmSclList = insttUseStteService.selectInsttUseStteAtmSclList(searchVo);
		}
		model.addAttribute("list", list);
		model.addAttribute("atmSclList", atmSclList);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectInsttUseStteList");
	}

	/**
	 * 기관별 이용현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttUseStteXlsDown.do")
	public void selectInsttUseStteXlsDown(
			InsttUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<InsttUseStteVo> list = null;
		if(searchVo.getSearch() != null){

			list = insttUseStteService.selectInsttUseStteList(searchVo);	// 게시글list 가져오기
		}
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 이용 현황(가상서버)");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "이용업무" );			titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "이용업무" );			titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "가상서버" );			titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "가상서버" );			titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "가상서버" );			titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "가상서버" );			titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "논리자원 할당량" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "논리자원 할당량" );	titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "논리자원 할당량)" );	titleCell13.setCellStyle(headerStyle);/////


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "이용업무수" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "비율" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "가상서버수" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "비율" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "업무당 가상서버수" );	titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);			titleCell10.setCellValue( "업무당 가상서버수" );titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "vCore" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "MEM(GB)" );			titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "SAN(GB)" );			titleCell13.setCellStyle(headerStyle);//

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "이용업무수" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "비율" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "가상서버수" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "비율" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "최소" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "최대" );				titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "vCore" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "MEM(GB)" );			titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "SAN(GB)" );			titleCell13.setCellStyle(headerStyle);//


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//번호
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//구분
		sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//기관명
		sheet.addMergedRegion(new CellRangeAddress(0,1,4,5));//이용업무
		//sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//이용업무수
		//sheet.addMergedRegion(new CellRangeAddress(0,2,4,4));//비율

		sheet.addMergedRegion(new CellRangeAddress(0,0,6,9));//가상서버
		sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//가상서버수
		sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//비율
		sheet.addMergedRegion(new CellRangeAddress(1,1,8,9));//업무당 가상서버수

		sheet.addMergedRegion(new CellRangeAddress(0,1,10,12));//web



		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,11));
			list = new ArrayList<InsttUseStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			InsttUseStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);	    dataCell0.setCellValue(i+1 );
				Cell dataCell1 = dataRow.createCell(1);	    dataCell1.setCellValue(vo.getRegionNm());
				Cell dataCell2 = dataRow.createCell(2);	    dataCell2.setCellValue(vo.getMm());
				Cell dataCell3 = dataRow.createCell(3);	    dataCell3.setCellValue(vo.getInstitutionNm());
				Cell dataCell4 = dataRow.createCell(4);	    dataCell4.setCellValue(DateUtil.stringValueOf(vo.getJobId()));
				Cell dataCell5 = dataRow.createCell(5);	    dataCell5.setCellValue(DateUtil.stringValueOf(vo.getJobPer()));
				Cell dataCell6 = dataRow.createCell(6);	    dataCell6.setCellValue(DateUtil.stringValueOf(vo.getVmSeq()));
				Cell dataCell7 = dataRow.createCell(7);	    dataCell7.setCellValue(DateUtil.stringValueOf(vo.getVmPer()));
				Cell dataCell8 = dataRow.createCell(8);	    dataCell8.setCellValue(DateUtil.stringValueOf(vo.getJobMin()));
				Cell dataCell9 = dataRow.createCell(9);	    dataCell9.setCellValue(DateUtil.stringValueOf(vo.getJobMax()));
				Cell dataCell10 = dataRow.createCell(10);   dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty()));
				Cell dataCell11 = dataRow.createCell(11);   dataCell11.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 이용 현황(가상서버)").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }




	/**
	 * 기관별 이용현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttUseStteAtmSclXlsDown.do")
	public void selectInsttUseStteAtmSclXlsDown(
			InsttUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<InsttUseStteVo> list = null;
		if(searchVo.getSearch() != null){

			list = insttUseStteService.selectInsttUseStteAtmSclList(searchVo);	// 게시글list 가져오기
		}
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 이용 현황(자동확장)");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "이용업무" );			titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "이용업무" );			titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "서비스영역" );			titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "서비스영역" );			titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "서비스영역" );			titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "서비스영역" );			titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "Pod 할당량" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "Pod 할당량" );	titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "Pod 할당량)" );	titleCell13.setCellStyle(headerStyle);/////


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "이용업무수" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "비율" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "서비스영역수" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "비율" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "업무당 서비스영역수" );	titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);			titleCell10.setCellValue( "업무당 서비스영역수" );titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "Core" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "MEM(GB)" );			titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "STORAGE(GB)" );			titleCell13.setCellStyle(headerStyle);//

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "번호" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "센터" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "구분" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "기관명" );			titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "이용업무수" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "비율" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "서비스영역수" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "비율" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "최소" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "최대" );				titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "Core" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "MEM(GB)" );			titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "STORAGE(GB)" );			titleCell13.setCellStyle(headerStyle);//


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//번호
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//구분
		sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//기관명
		sheet.addMergedRegion(new CellRangeAddress(0,1,4,5));//이용업무
		//sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//이용업무수
		//sheet.addMergedRegion(new CellRangeAddress(0,2,4,4));//비율

		sheet.addMergedRegion(new CellRangeAddress(0,0,6,9));//가상서버
		sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//가상서버수
		sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//비율
		sheet.addMergedRegion(new CellRangeAddress(1,1,8,9));//업무당 가상서버수

		sheet.addMergedRegion(new CellRangeAddress(0,1,10,12));//web


		for(int i=0; i<list.size(); i++){
			InsttUseStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);	    dataCell0.setCellValue(i+1 );
				Cell dataCell1 = dataRow.createCell(1);	    dataCell1.setCellValue(vo.getRegionNm());
				Cell dataCell2 = dataRow.createCell(2);	    dataCell2.setCellValue(vo.getMm());
				Cell dataCell3 = dataRow.createCell(3);	    dataCell3.setCellValue(vo.getInstitutionNm());
				Cell dataCell4 = dataRow.createCell(4);	    dataCell4.setCellValue(DateUtil.stringValueOf(vo.getJobId()));
				Cell dataCell5 = dataRow.createCell(5);	    dataCell5.setCellValue(DateUtil.stringValueOf(vo.getJobPer()));
				Cell dataCell6 = dataRow.createCell(6);	    dataCell6.setCellValue(DateUtil.stringValueOf(vo.getServcAreaSeq()));
				Cell dataCell7 = dataRow.createCell(7);	    dataCell7.setCellValue(DateUtil.stringValueOf(vo.getServcAreaPer()));
				Cell dataCell8 = dataRow.createCell(8);	    dataCell8.setCellValue(DateUtil.stringValueOf(vo.getJobMin()));
				Cell dataCell9 = dataRow.createCell(9);	    dataCell9.setCellValue(DateUtil.stringValueOf(vo.getJobMax()));
				Cell dataCell10 = dataRow.createCell(10);   dataCell10.setCellValue(DateUtil.stringValueOf(vo.getCpuAsgnCapa()));
				Cell dataCell11 = dataRow.createCell(11);   dataCell11.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa()));
				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa()));
		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 이용 현황(자동확장)").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }


}
