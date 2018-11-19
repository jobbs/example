/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttRsrcUseStteController.java
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

package ncis.dsb.stts.rsrcuse.web;

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
import ncis.dsb.stts.rsrcuse.service.InsttRsrcUseStteService;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteSearchVo;

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

@Controller("insttRsrcUseStteController")
@RequestMapping("/dsb/stts/rsrcuse/instt")
public class InsttRsrcUseStteController extends BaseController {


	@Resource(name="insttRsrcUseStteService")
	InsttRsrcUseStteService insttRsrcUseStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 기관별 자원 사용 현황 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttRsrcUseStteList.do")
	public String selectClstrOprStteSmayList( HttpServletRequest request,InsttRsrcUseStteSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;


		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<InsttRsrcUseStteAsgnVo> listAsgn = null;
		List<InsttRsrcUseStteMaxVo> listMax = null;
		List<InsttRsrcRxAsgnVo> listRxAsgn = null;
		List<InsttRsrcRxMaxVo> listRxMax = null;

		if(searchVo.getSearch() != null){
				listAsgn = insttRsrcUseStteService.selectInsttRsrcUseStteAsgnList(searchVo);	// 게시글list 가져오기
				listMax = insttRsrcUseStteService.selectInsttRsrcUseStteMaxList(searchVo);	// 게시글list 가져오기
				listRxAsgn = insttRsrcUseStteService.selectRxAsgnList(searchVo);	// 게시글list 가져오기
				listRxMax = insttRsrcUseStteService.selectRxMaxList(searchVo);	// 게시글list 가져오기
		}
		model.addAttribute("listAsgn", listAsgn);
		model.addAttribute("listMax", listMax);
		model.addAttribute("listRxAsgn", listRxAsgn);
		model.addAttribute("listRxMax", listRxMax);


		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectInsttRsrcUseStteList");
	}

	/**
	 * 기관별 자원 사용 현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectInsttRsrcUseStteAsgnXlsDown.do")
	public void selectInsttRsrcUseStteAsgnXlsDown(
			InsttRsrcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{


		List<InsttRsrcUseStteAsgnVo> list = null;
		if(searchVo.getSearch() != null){
			list = insttRsrcUseStteService.selectInsttRsrcUseStteAsgnList(searchVo);	// 게시글list 가져오기

		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 자원 사용 현황-논리자원 할당량");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "논리자원 할당량" );		titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "논리자원 할당량" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "논리자원 할당량" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "논리자원 할당량" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "논리자원 할당량" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "논리자원 할당량" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "논리자원 할당량" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "논리자원 할당량" );		titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "논리자원 할당량" );		titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "논리자원 할당량" );		titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "논리자원 할당량" );		titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "논리자원 할당량" );		titleCell14.setCellStyle(headerStyle);/////

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "vCore" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "vCore" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "vCore" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "vCore" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "MEM(GB)" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "MEM(GB)" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "MEM(GB)" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );			titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "SAN(GB)" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "SAN(GB)" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "SAN(GB)" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "SAN(GB)" );		titleCell14.setCellStyle(headerStyle);/////


		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "1분기" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "2분기" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "3분기" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "4분기" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "1분기" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "2분기" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "3분기" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "4분기" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "1분기" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "2분기" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "3분기" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "4분기" );		titleCell14.setCellStyle(headerStyle);/////


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//순서
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//기관명
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,13));//논리자원 할당량

		sheet.addMergedRegion(new CellRangeAddress(1,1,2,5));//vCore
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,9));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,1,10,13));//SAN

		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,13));
			list = new ArrayList<InsttRsrcUseStteAsgnVo>();
		}
		for(int i=0; i<list.size(); i++){
			InsttRsrcUseStteAsgnVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue((searchVo.getPaginationInfo().getTotalRecordCount()-searchVo.getPaginationInfo().getFirstRecordIndex()-i) );
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getInstitutionNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty1()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty2()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty3()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty4()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa1()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa2()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa3()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa4()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa1()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa2()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa3()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa4()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 자원 사용 현황-논리자원 할당량").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

    }

	@RequestMapping(value="/selectInsttRsrcUseStteMaxXlsDown.do")
	public void selectInsttRsrcUseStteMaxXlsDown(
			InsttRsrcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<InsttRsrcUseStteMaxVo> list = null;

		if(searchVo.getSearch() != null){
				list = insttRsrcUseStteService.selectInsttRsrcUseStteMaxList(searchVo);	// 게시글list 가져오기
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 자원 사용 현황-가상서버 최빈시 자원 사용률");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "가상서버 최빈시 자원 사용률 평균(%)" );		titleCell14.setCellStyle(headerStyle);/////

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "vCore" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "vCore" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "vCore" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "vCore" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "MEM(GB)" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "MEM(GB)" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "MEM(GB)" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );			titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "SAN(GB)" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "SAN(GB)" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "SAN(GB)" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "SAN(GB)" );		titleCell14.setCellStyle(headerStyle);/////


		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "기관명" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "1분기" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "2분기" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "3분기" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "4분기" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "1분기" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "2분기" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "3분기" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "4분기" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "1분기" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "2분기" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "3분기" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "4분기" );		titleCell14.setCellStyle(headerStyle);/////


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//순서
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//기관명
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,13));//논리자원 할당량

		sheet.addMergedRegion(new CellRangeAddress(1,1,2,5));//vCore
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,9));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,1,10,13));//SAN

		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,13));
			list = new ArrayList<InsttRsrcUseStteMaxVo>();
		}
		for(int i=0; i<list.size(); i++){
			InsttRsrcUseStteMaxVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(searchVo.getPaginationInfo().getTotalRecordCount()-searchVo.getPaginationInfo().getFirstRecordIndex()-i );
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getInstitutionNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt1()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt2()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt3()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt4()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt1()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt2()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt3()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt4()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getMaxStrgUseRt1()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getMaxStrgUseRt2()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getMaxStrgUseRt3()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getMaxStrgUseRt4()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 자원 사용 현황-가상서버 최빈시 자원 사용률").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }
	@RequestMapping(value="/selectRxAsgnListXlsDown.do")
	public void selectRxAsgnListXlsDown(
			InsttRsrcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<InsttRsrcRxAsgnVo> listRxAsgn = null;	// 게시글list 가져오기

		if(searchVo.getSearch() != null){
			listRxAsgn = insttRsrcUseStteService.selectRxAsgnList(searchVo);
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 자원 사용 현황-자동확장 할당량");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );							titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "부처" );							titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "자동확장 할당량" );		titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "자동확장 할당량" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "자동확장 할당량" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "자동확장 할당량" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "자동확장 할당량" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "자동확장 할당량" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "자동확장 할당량" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "자동확장 할당량" );		titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "자동확장 할당량" );		titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "자동확장 할당량" );		titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "자동확장 할당량" );		titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "자동확장 할당량" );		titleCell14.setCellStyle(headerStyle);/////

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);		titleCell1.setCellValue( "No." );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);		titleCell2.setCellValue( "부처" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);		titleCell3.setCellValue( "CPU" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);		titleCell4.setCellValue( "CPU" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);		titleCell5.setCellValue( "CPU" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);		titleCell6.setCellValue( "CPU" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);		titleCell7.setCellValue( "MEM(GB)" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);		titleCell8.setCellValue( "MEM(GB)" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);		titleCell9.setCellValue( "MEM(GB)" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );			titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "스토리지(GB)" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "스토리지(GB)" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "스토리지(GB)" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "스토리지(GB)" );		titleCell14.setCellStyle(headerStyle);/////


		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "부처" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "1분기" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "2분기" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "3분기" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "4분기" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "1분기" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "2분기" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "3분기" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "4분기" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "1분기" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "2분기" );		titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "3분기" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "4분기" );		titleCell14.setCellStyle(headerStyle);/////


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//순서
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//부처
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,13));//자동확장 할당량

		sheet.addMergedRegion(new CellRangeAddress(1,1,2,5));//CPU
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,9));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,1,10,13));//스토리지

		if(listRxAsgn==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,13));
			listRxAsgn = new ArrayList<InsttRsrcRxAsgnVo>();
		}
		for(int i=0; i<listRxAsgn.size(); i++){
			InsttRsrcRxAsgnVo vo = listRxAsgn.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(listRxAsgn.size()-i);
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getInstitutionNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getCpuAsgnCapa1()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getCpuAsgnCapa2()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getCpuAsgnCapa3()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getCpuAsgnCapa4()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa1()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa2()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa3()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa4()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa1()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa2()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa3()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa4()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 자원 사용 현황-자동확장 할당량").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }


	@RequestMapping(value="/selectRxMaxListXlsDown.do")
	public void selectRxMaxListXlsDown(
			InsttRsrcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<InsttRsrcRxMaxVo> listRxMax = null;	// 게시글list 가져오기

		if(searchVo.getSearch() != null){
			listRxMax = insttRsrcUseStteService.selectRxMaxList(searchVo);
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("기관별 자원 사용 현황-자동확장 최빈시 자원 사용률 평균(%)");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );							titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "부처" );							titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "자동확장 최빈시 자원 사용률 평균(%)" );		titleCell10.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);		titleCell1.setCellValue( "No." );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);		titleCell2.setCellValue( "부처" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);		titleCell3.setCellValue( "CPU" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);		titleCell4.setCellValue( "CPU" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);		titleCell5.setCellValue( "CPU" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);		titleCell6.setCellValue( "CPU" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);		titleCell7.setCellValue( "MEM(GB)" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);		titleCell8.setCellValue( "MEM(GB)" );				titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);		titleCell9.setCellValue( "MEM(GB)" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );			titleCell10.setCellStyle(headerStyle);


		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "No." );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "부처" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "1분기" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "2분기" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "3분기" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "4분기" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "1분기" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "2분기" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "3분기" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "4분기" );						titleCell10.setCellStyle(headerStyle);


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//순서
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//부처
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,9));//자동확장 할당량

		sheet.addMergedRegion(new CellRangeAddress(1,1,2,5));//CPU
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,9));//MEM

		if(listRxMax==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,9));
			listRxMax = new ArrayList<InsttRsrcRxMaxVo>();
		}
		for(int i=0; i<listRxMax.size(); i++){
			InsttRsrcRxMaxVo vo = listRxMax.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(listRxMax.size()-i );
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getInstitutionNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt1()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt2()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt3()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt4()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt1()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt2()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt3()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt4()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("기관별 자원 사용 현황-자동확장 최빈시 자원 사용률 평균(%)").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }
}

