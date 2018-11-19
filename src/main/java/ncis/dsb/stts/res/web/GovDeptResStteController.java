/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptResStteController.java
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

package ncis.dsb.stts.res.web;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.res.service.GovDeptResStteService;
import ncis.dsb.stts.res.vo.GovDeptResStteCvo;
import ncis.dsb.stts.res.vo.GovDeptResStteSearchVo;
import ncis.dsb.stts.res.vo.GovDeptResStteVo;

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

@Controller("govDeptResStteController")
@RequestMapping("/dsb/stts/res/govDeptRes")
public class GovDeptResStteController extends BaseController {


	@Resource(name="govDeptResStteService")
	GovDeptResStteService govDeptResStteService;

	/**
	 * 부처 자원 현황 목록조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectGovDeptResStteList.do")
	public String selectGovDeptResStteList( HttpServletRequest request,
			Model model, GovDeptResStteSearchVo searchVo) throws Exception{

		GovDeptResStteCvo govDeptResStteCvo = null;
		if(searchVo.getSearchTrmCd()!=null){
			govDeptResStteCvo = govDeptResStteService.selectGovDeptResList(searchVo);	// 게시글list 가져오기
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}
		model.addAttribute("GovDeptResStteCvo", govDeptResStteCvo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"selectGovDeptResStteList");
	}

	/**
	 * 부처 자원 현황 엑셀 다운
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectGovDeptResStteListXlsDown.do")
	public void selectGovDeptResStteListXlsDown(
			GovDeptResStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		GovDeptResStteCvo govDeptResStteCvo = null;
		List<GovDeptResStteVo> list = null;

		if(searchVo.getSearchTrmCd()!=null){
			govDeptResStteCvo = govDeptResStteService.selectGovDeptResList(searchVo);
			list = govDeptResStteCvo.getGvDeptResStteList();
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("부처자원현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "부처명" );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "업무수" );					titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "가상서버수" );				titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "가상서버수" );				titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "가상서버수" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "가상서버수" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "가상서버수" );				titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "가상서버수" );				titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "자동확장수" );				titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "자동확장수" );				titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "O/S" );					titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "O/S" );					titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "O/S" );					titleCell13.setCellStyle(headerStyle);
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "O/S" );					titleCell14.setCellStyle(headerStyle);/////
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "O/S" );					titleCell15.setCellStyle(headerStyle);/////
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "O/S" );					titleCell16.setCellStyle(headerStyle);/////

		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "WEB(할당량/사용률)" );		titleCell17.setCellStyle(headerStyle);/////
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "WEB(할당량/사용률)" );		titleCell18.setCellStyle(headerStyle);
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "WEB(할당량/사용률)" );		titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "WEB(할당량/사용률)" );		titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "WEB(할당량/사용률)" );		titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "WEB(할당량/사용률)" );		titleCell22.setCellStyle(headerStyle);

		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "WAS(할당량/사용률)" );		titleCell23.setCellStyle(headerStyle);
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "WAS(할당량/사용률)" );		titleCell24.setCellStyle(headerStyle);
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "WAS(할당량/사용률)" );		titleCell25.setCellStyle(headerStyle);
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "WAS(할당량/사용률)" );		titleCell26.setCellStyle(headerStyle);
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "WAS(할당량/사용률)" );		titleCell27.setCellStyle(headerStyle);
		Cell titleCell28 = row.createCell(27);	titleCell28.setCellValue( "WAS(할당량/사용률)" );		titleCell28.setCellStyle(headerStyle);

		Cell titleCell29 = row.createCell(28);	titleCell29.setCellValue( "DB(할당량/사용률)" );			titleCell29.setCellStyle(headerStyle);
		Cell titleCell30 = row.createCell(29);	titleCell30.setCellValue( "DB(할당량/사용률)" );			titleCell30.setCellStyle(headerStyle);
		Cell titleCell31 = row.createCell(30);	titleCell31.setCellValue( "DB(할당량/사용률)" );			titleCell31.setCellStyle(headerStyle);
		Cell titleCell32 = row.createCell(31);	titleCell32.setCellValue( "DB(할당량/사용률)" );			titleCell32.setCellStyle(headerStyle);
		Cell titleCell33 = row.createCell(32);	titleCell33.setCellValue( "DB(할당량/사용률)" );			titleCell33.setCellStyle(headerStyle);
		Cell titleCell34 = row.createCell(33);	titleCell34.setCellValue( "DB(할당량/사용률)" );			titleCell34.setCellStyle(headerStyle);

		Cell titleCell35 = row.createCell(34);	titleCell35.setCellValue( "WIN(할당량/사용률)" );		titleCell35.setCellStyle(headerStyle);
		Cell titleCell36 = row.createCell(35);	titleCell36.setCellValue( "WIN(할당량/사용률)" );		titleCell36.setCellStyle(headerStyle);
		Cell titleCell37 = row.createCell(36);	titleCell37.setCellValue( "WIN(할당량/사용률)" );		titleCell37.setCellStyle(headerStyle);
		Cell titleCell38 = row.createCell(37);	titleCell38.setCellValue( "WIN(할당량/사용률)" );		titleCell38.setCellStyle(headerStyle);
		Cell titleCell39 = row.createCell(38);	titleCell39.setCellValue( "WIN(할당량/사용률)" );		titleCell39.setCellStyle(headerStyle);
		Cell titleCell40 = row.createCell(39);	titleCell40.setCellValue( "WIN(할당량/사용률)" );		titleCell40.setCellStyle(headerStyle);

		Cell titleCell41 = row.createCell(40);	titleCell41.setCellValue( "TEST(할당량/사용률)" );		titleCell41.setCellStyle(headerStyle);
		Cell titleCell42 = row.createCell(41);	titleCell42.setCellValue( "TEST(할당량/사용률)" );		titleCell42.setCellStyle(headerStyle);
		Cell titleCell43 = row.createCell(42);	titleCell43.setCellValue( "TEST(할당량/사용률)" );		titleCell43.setCellStyle(headerStyle);
		Cell titleCell44 = row.createCell(43);	titleCell44.setCellValue( "TEST(할당량/사용률)" );		titleCell44.setCellStyle(headerStyle);
		Cell titleCell45 = row.createCell(44);	titleCell45.setCellValue( "TEST(할당량/사용률)" );		titleCell45.setCellStyle(headerStyle);
		Cell titleCell46 = row.createCell(45);	titleCell46.setCellValue( "TEST(할당량/사용률)" );		titleCell46.setCellStyle(headerStyle);

		Cell titleCell47 = row.createCell(46);	titleCell47.setCellValue( "ETC(할당량/사용률)" );		titleCell47.setCellStyle(headerStyle);
		Cell titleCell48 = row.createCell(47);	titleCell48.setCellValue( "ETC(할당량/사용률)" );		titleCell48.setCellStyle(headerStyle);
		Cell titleCell49 = row.createCell(48);	titleCell49.setCellValue( "ETC(할당량/사용률)" );		titleCell49.setCellStyle(headerStyle);
		Cell titleCell50 = row.createCell(49);	titleCell50.setCellValue( "ETC(할당량/사용률)" );		titleCell50.setCellStyle(headerStyle);
		Cell titleCell51 = row.createCell(50);	titleCell51.setCellValue( "ETC(할당량/사용률)" );		titleCell51.setCellStyle(headerStyle);
		Cell titleCell52 = row.createCell(51);	titleCell52.setCellValue( "ETC(할당량/사용률)" );		titleCell52.setCellStyle(headerStyle);

		Cell titleCell53 = row.createCell(52);	titleCell53.setCellValue( "자동확장(할당량/사용률)" );		titleCell53.setCellStyle(headerStyle);
		Cell titleCell54 = row.createCell(53);	titleCell54.setCellValue( "자동확장(할당량/사용률)" );		titleCell54.setCellStyle(headerStyle);
		Cell titleCell55 = row.createCell(54);	titleCell55.setCellValue( "자동확장(할당량/사용률)" );		titleCell55.setCellStyle(headerStyle);
		Cell titleCell56 = row.createCell(55);	titleCell56.setCellValue( "자동확장(할당량/사용률)" );		titleCell56.setCellStyle(headerStyle);
		Cell titleCell57 = row.createCell(56);	titleCell57.setCellValue( "자동확장(할당량/사용률)" );		titleCell57.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "부처명" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "업무수" );					titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "WEB" );					titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "WAS" );					titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "DB" );					titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "WIN" );					titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "TEST" );					titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "ETC" );					titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "서비스수" );					titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "POD수" );					titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "LINUX" );				titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "HP-UX" );				titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "AIX" );					titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "WIN" );					titleCell14.setCellStyle(headerStyle);//
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "SOLARIS" );					titleCell15.setCellStyle(headerStyle);//
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "ETC" );					titleCell16.setCellStyle(headerStyle);//

		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "CPU(vCore)" );			titleCell17.setCellStyle(headerStyle);
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "CPU 사용률(%)" );			titleCell18.setCellStyle(headerStyle);
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "메모리(GB)" );				titleCell19.setCellStyle(headerStyle);//
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "메모리 사용률(%)" );			titleCell20.setCellStyle(headerStyle);
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "스토리지(TB)" );			titleCell21.setCellStyle(headerStyle);//
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "스토리지 사용률(%)" );			titleCell22.setCellStyle(headerStyle);//

		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "CPU(vCore)" );			titleCell23.setCellStyle(headerStyle);
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "CPU 사용률(%)" );			titleCell24.setCellStyle(headerStyle);
		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "메모리(GB)" );				titleCell25.setCellStyle(headerStyle);//
		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "메모리 사용률(%)" );			titleCell26.setCellStyle(headerStyle);
		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "스토리지(TB)" );			titleCell27.setCellStyle(headerStyle);//
		titleCell28 = row.createCell(27);		titleCell28.setCellValue( "스토리지 사용률(%)" );			titleCell28.setCellStyle(headerStyle);//

		titleCell29 = row.createCell(28);		titleCell29.setCellValue( "CPU(vCore)" );			titleCell29.setCellStyle(headerStyle);
		titleCell30 = row.createCell(29);		titleCell30.setCellValue( "CPU 사용률(%)" );			titleCell30.setCellStyle(headerStyle);
		titleCell31 = row.createCell(30);		titleCell31.setCellValue( "메모리(GB)" );				titleCell31.setCellStyle(headerStyle);//
		titleCell32 = row.createCell(31);		titleCell32.setCellValue( "메모리 사용률(%)" );			titleCell32.setCellStyle(headerStyle);
		titleCell33 = row.createCell(32);		titleCell33.setCellValue( "스토리지(TB)" );			titleCell33.setCellStyle(headerStyle);//
		titleCell34 = row.createCell(33);		titleCell34.setCellValue( "스토리지 사용률(%)" );			titleCell34.setCellStyle(headerStyle);//

		titleCell35 = row.createCell(34);		titleCell35.setCellValue( "CPU(vCore)" );			titleCell35.setCellStyle(headerStyle);
		titleCell36 = row.createCell(35);		titleCell36.setCellValue( "CPU 사용률(%)" );			titleCell36.setCellStyle(headerStyle);
		titleCell37 = row.createCell(36);		titleCell37.setCellValue( "메모리(GB)" );				titleCell37.setCellStyle(headerStyle);//
		titleCell38 = row.createCell(37);		titleCell38.setCellValue( "메모리 사용률(%)" );			titleCell38.setCellStyle(headerStyle);
		titleCell39 = row.createCell(38);		titleCell39.setCellValue( "스토리지(TB)" );			titleCell39.setCellStyle(headerStyle);//
		titleCell40 = row.createCell(39);		titleCell40.setCellValue( "스토리지 사용률(%)" );			titleCell40.setCellStyle(headerStyle);//

		titleCell41 = row.createCell(40);		titleCell41.setCellValue( "CPU(vCore)" );			titleCell41.setCellStyle(headerStyle);
		titleCell42 = row.createCell(41);		titleCell42.setCellValue( "CPU 사용률(%)" );			titleCell42.setCellStyle(headerStyle);
		titleCell43 = row.createCell(42);		titleCell43.setCellValue( "메모리(GB)" );				titleCell43.setCellStyle(headerStyle);//
		titleCell44 = row.createCell(43);		titleCell44.setCellValue( "메모리 사용률(%)" );			titleCell44.setCellStyle(headerStyle);
		titleCell45 = row.createCell(44);		titleCell45.setCellValue( "스토리지(TB)" );			titleCell45.setCellStyle(headerStyle);//
		titleCell46 = row.createCell(45);		titleCell46.setCellValue( "스토리지 사용률(%)" );			titleCell46.setCellStyle(headerStyle);//


		titleCell47 = row.createCell(46);		titleCell47.setCellValue( "CPU(vCore)" );			titleCell47.setCellStyle(headerStyle);
		titleCell48 = row.createCell(47);		titleCell48.setCellValue( "CPU 사용률(%)" );			titleCell48.setCellStyle(headerStyle);
		titleCell49 = row.createCell(48);		titleCell49.setCellValue( "메모리(GB)" );				titleCell49.setCellStyle(headerStyle);//
		titleCell50 = row.createCell(49);		titleCell50.setCellValue( "메모리 사용률(%)" );			titleCell50.setCellStyle(headerStyle);
		titleCell51 = row.createCell(50);		titleCell51.setCellValue( "스토리지(TB)" );			titleCell51.setCellStyle(headerStyle);//
		titleCell52 = row.createCell(51);		titleCell52.setCellValue( "스토리지 사용률(%)" );			titleCell52.setCellStyle(headerStyle);//


		titleCell53 = row.createCell(52);		titleCell53.setCellValue( "CPU(Core)" );			titleCell53.setCellStyle(headerStyle);
		titleCell54 = row.createCell(53);		titleCell54.setCellValue( "CPU 사용률(%)" );			titleCell54.setCellStyle(headerStyle);
		titleCell55 = row.createCell(54);		titleCell55.setCellValue( "메모리(GB)" );				titleCell55.setCellStyle(headerStyle);//
		titleCell56 = row.createCell(55);		titleCell56.setCellValue( "메모리 사용률(%)" );			titleCell56.setCellStyle(headerStyle);
		titleCell57 = row.createCell(56);		titleCell57.setCellValue( "스토리지(GB)" );			titleCell57.setCellStyle(headerStyle);//


		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,7));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,9));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,10,15));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,16,21));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,22,27));
		sheet.addMergedRegion(new CellRangeAddress(0,0,28,33));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,34,39));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,40,45));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,46,51));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,52,56));//

		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,56));
			list = new ArrayList<GovDeptResStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			GovDeptResStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
			Cell dataCell0 = dataRow.createCell(0);	  	dataCell0.setCellValue(vo.getInstitutionNm());
			Cell dataCell1 = dataRow.createCell(1);	  	dataCell1.setCellValue(DateUtil.stringValueOf(vo.getJobCnt()));
			Cell dataCell2 = dataRow.createCell(2);	  	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getWebCnt()));
			Cell dataCell3 = dataRow.createCell(3);	  	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getWasCnt()));
			Cell dataCell4 = dataRow.createCell(4);	  	dataCell4.setCellValue(DateUtil.stringValueOf(vo.getDbCnt()));
			Cell dataCell5 = dataRow.createCell(5);	  	dataCell5.setCellValue(DateUtil.stringValueOf(vo.getWinCnt()));
			Cell dataCell6 = dataRow.createCell(6);	  	dataCell6.setCellValue(DateUtil.stringValueOf(vo.getTestCnt()));
			Cell dataCell7 = dataRow.createCell(7);	  	dataCell7.setCellValue(DateUtil.stringValueOf(vo.getEtcCnt()));

			Cell dataCell8 = dataRow.createCell(8);	  	dataCell8.setCellValue(DateUtil.stringValueOf(vo.getServcCnt()));
			Cell dataCell9 = dataRow.createCell(9);	  	dataCell9.setCellValue(DateUtil.stringValueOf(vo.getPodQty()));

			Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(vo.getOsLinuxCnt()));
			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getOsHpCnt()));
			Cell dataCell12 = dataRow.createCell(12); 	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getOsAixCnt()));
			Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(DateUtil.stringValueOf(vo.getOsWinCnt()));
			Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vo.getOsSolarisCnt()));
			Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vo.getOsEtcCnt()));

			Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vo.getWebVcore()));
			Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vo.getWebCpuRt()));
			Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(DateUtil.stringValueOf(vo.getWebMem()));
			Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(DateUtil.stringValueOf(vo.getWebMemRt()));
			Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(DateUtil.stringValueOf(vo.getWebStrg()));
			Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(DateUtil.stringValueOf(vo.getWebStrgRt()));

			Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(DateUtil.stringValueOf(vo.getWasVcore()));
			Cell dataCell23 = dataRow.createCell(23);	dataCell23.setCellValue(DateUtil.stringValueOf(vo.getWasCpuRt()));
			Cell dataCell24 = dataRow.createCell(24);	dataCell24.setCellValue(DateUtil.stringValueOf(vo.getWasMem()));
			Cell dataCell25 = dataRow.createCell(25);	dataCell25.setCellValue(DateUtil.stringValueOf(vo.getWasMemRt()));
			Cell dataCell26 = dataRow.createCell(26);	dataCell26.setCellValue(DateUtil.stringValueOf(vo.getWasStrg()));
			Cell dataCell27 = dataRow.createCell(27);	dataCell27.setCellValue(DateUtil.stringValueOf(vo.getWasStrgRt()));

			Cell dataCell28 = dataRow.createCell(28);	dataCell28.setCellValue(DateUtil.stringValueOf(vo.getDbVcore()));
			Cell dataCell29 = dataRow.createCell(29);	dataCell29.setCellValue(DateUtil.stringValueOf(vo.getDbCpuRt()));
			Cell dataCell30 = dataRow.createCell(30);	dataCell30.setCellValue(DateUtil.stringValueOf(vo.getDbMem()));
			Cell dataCell31 = dataRow.createCell(31);	dataCell31.setCellValue(DateUtil.stringValueOf(vo.getDbMemRt()));
			Cell dataCell32 = dataRow.createCell(32);	dataCell32.setCellValue(DateUtil.stringValueOf(vo.getDbStrg()));
			Cell dataCell33 = dataRow.createCell(33);	dataCell33.setCellValue(DateUtil.stringValueOf(vo.getDbStrgRt()));

			Cell dataCell34 = dataRow.createCell(34);	dataCell34.setCellValue(DateUtil.stringValueOf(vo.getWinVcore()));
			Cell dataCell35 = dataRow.createCell(35);	dataCell35.setCellValue(DateUtil.stringValueOf(vo.getWinCpuRt()));
			Cell dataCell36 = dataRow.createCell(36);	dataCell36.setCellValue(DateUtil.stringValueOf(vo.getWinMem()));
			Cell dataCell37 = dataRow.createCell(37);	dataCell37.setCellValue(DateUtil.stringValueOf(vo.getWinMemRt()));
			Cell dataCell38 = dataRow.createCell(38);	dataCell38.setCellValue(DateUtil.stringValueOf(vo.getWinStrg()));
			Cell dataCell39 = dataRow.createCell(39);	dataCell39.setCellValue(DateUtil.stringValueOf(vo.getWinStrgRt()));

			Cell dataCell40 = dataRow.createCell(40);	dataCell40.setCellValue(DateUtil.stringValueOf(vo.getTestVcore()));
			Cell dataCell41 = dataRow.createCell(41);	dataCell41.setCellValue(DateUtil.stringValueOf(vo.getTestCpuRt()));
			Cell dataCell42 = dataRow.createCell(42);	dataCell42.setCellValue(DateUtil.stringValueOf(vo.getTestMem()));
			Cell dataCell43 = dataRow.createCell(43);	dataCell43.setCellValue(DateUtil.stringValueOf(vo.getTestMemRt()));
			Cell dataCell44 = dataRow.createCell(44);	dataCell44.setCellValue(DateUtil.stringValueOf(vo.getTestStrg()));
			Cell dataCell45 = dataRow.createCell(45);	dataCell45.setCellValue(DateUtil.stringValueOf(vo.getTestStrgRt()));

			Cell dataCell46 = dataRow.createCell(46);	dataCell46.setCellValue(DateUtil.stringValueOf(vo.getEtcVcore()));
			Cell dataCell47 = dataRow.createCell(47);	dataCell47.setCellValue(DateUtil.stringValueOf(vo.getEtcCpuRt()));
			Cell dataCell48 = dataRow.createCell(48);	dataCell48.setCellValue(DateUtil.stringValueOf(vo.getEtcMem()));
			Cell dataCell49 = dataRow.createCell(49);	dataCell49.setCellValue(DateUtil.stringValueOf(vo.getEtcMemRt()));
			Cell dataCell50 = dataRow.createCell(50);	dataCell50.setCellValue(DateUtil.stringValueOf(vo.getEtcStrg()));
			Cell dataCell51 = dataRow.createCell(51);	dataCell51.setCellValue(DateUtil.stringValueOf(vo.getEtcStrgRt()));

			Cell dataCell52 = dataRow.createCell(52);	dataCell52.setCellValue(DateUtil.stringValueOf(vo.getOcpCpuAsgnCapa()));
			Cell dataCell53 = dataRow.createCell(53);	dataCell53.setCellValue(DateUtil.stringValueOf(vo.getOcpAvgCpuUseRt()));
			Cell dataCell54 = dataRow.createCell(54);	dataCell54.setCellValue(DateUtil.stringValueOf(vo.getOcpMemTotCapa()));
			Cell dataCell55 = dataRow.createCell(55);	dataCell55.setCellValue(DateUtil.stringValueOf(vo.getOcpAvgMemUseRt()));
			Cell dataCell56 = dataRow.createCell(56);	dataCell56.setCellValue(DateUtil.stringValueOf(vo.getOcpStrgTotCapa()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("부처자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

    }


}
