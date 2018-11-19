/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteClstrController.java
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
import ncis.dsb.stts.rsrcuse.service.RsrcUseStteClstrService;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteClstrSearchVo;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteClstrVo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("rsrcUseStteClstrController")
@RequestMapping("/dsb/stts/rsrcuse/clstr")
public class RsrcUseStteClstrController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RsrcUseStteClstrController.class);

	@Resource(name="rsrcUseStteClstrService")
	RsrcUseStteClstrService rsrcUseStteClstrService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원사용현황 - 클러스터별
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcUseStteClstrList.do")
	public String selectJobRsrcStteList( HttpServletRequest request,RsrcUseStteClstrSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;


		if(searchVo.getDtlGubun() == null) searchVo.setDtlGubun("sumy");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getMm() == null) searchVo.setMm(mm);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		List<RegionVo> regionVoList = regionService.selectRegionAllList();


		List<RsrcUseStteClstrVo> list = null;

		if(searchVo.getSearch() != null){
				list = rsrcUseStteClstrService.selectRsrcUseStteClstrList(searchVo);	// 게시글list 가져오기
		}
		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("mmList", mmList);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectRsrcUseStteClstrList");
	}

	/**
	 * 자원사용현황 - 클러스터별 엑셀다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcUseStteClstrXlsDown.do")
	public void selecInsttChngStteXlsDown(
			RsrcUseStteClstrSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);


		List<RsrcUseStteClstrVo> list = null;

		if(searchVo.getSearch() != null){
				list = rsrcUseStteClstrService.selectRsrcUseStteClstrList(searchVo);	// 게시글list 가져오기
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자원사용현황 - 클러스터별");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		logger.debug("searchVo.getDtlGubun()"+searchVo.getDtlGubun());
		if(searchVo.getDtlGubun().equals("sumy")){

			Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "번호" );							titleCell1.setCellStyle(headerStyle);
			Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "자원풀코드" );					titleCell2.setCellStyle(headerStyle);
			Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );					titleCell3.setCellStyle(headerStyle);
			Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "물리자원 보유량" );				titleCell4.setCellStyle(headerStyle);
			Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "물리자원 보유량" );				titleCell5.setCellStyle(headerStyle);
			Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "물리자원 보유량" );				titleCell6.setCellStyle(headerStyle);
			Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리자원 보유량" );				titleCell7.setCellStyle(headerStyle);
			Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "논리자원 할당량" );				titleCell8.setCellStyle(headerStyle);
			Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "논리자원 할당량" );				titleCell9.setCellStyle(headerStyle);
			Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "논리자원 할당량" );				titleCell10.setCellStyle(headerStyle);
			Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "논리자원 할당량" );				titleCell11.setCellStyle(headerStyle);
			Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "자동확장 할당량" );				titleCell12.setCellStyle(headerStyle);/////
			Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "자동확장 할당량" );				titleCell13.setCellStyle(headerStyle);/////
			Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "자동확장 할당량" );				titleCell14.setCellStyle(headerStyle);/////
			Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "자동확장 할당량" );				titleCell15.setCellStyle(headerStyle);/////
			Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell16.setCellStyle(headerStyle);/////
			Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell17.setCellStyle(headerStyle);/////
			Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell18.setCellStyle(headerStyle);/////
			Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell19.setCellStyle(headerStyle);/////
			Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell20.setCellStyle(headerStyle);/////
			Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell21.setCellStyle(headerStyle);/////
			Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell22.setCellStyle(headerStyle);/////

			row = sheet.createRow(1);
			titleCell1 = row.createCell(0);		titleCell1.setCellValue( "번호" );			titleCell1.setCellStyle(headerStyle);
			titleCell2 = row.createCell(1);		titleCell2.setCellValue( "자원풀코드" );	titleCell2.setCellStyle(headerStyle);
			titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터수" );	titleCell3.setCellStyle(headerStyle);
			titleCell4 = row.createCell(3);		titleCell4.setCellValue( "서버수" );		titleCell4.setCellStyle(headerStyle);
			titleCell5 = row.createCell(4);		titleCell5.setCellValue( "Core" );			titleCell5.setCellStyle(headerStyle);
			titleCell6 = row.createCell(5);		titleCell6.setCellValue( "MEM(GB)" );		titleCell6.setCellStyle(headerStyle);
			titleCell7 = row.createCell(6);		titleCell7.setCellValue( "SAN(GB)" );		titleCell7.setCellStyle(headerStyle);
			titleCell8 = row.createCell(7);		titleCell8.setCellValue( "가상서버수" );	titleCell8.setCellStyle(headerStyle);
			titleCell9 = row.createCell(8);		titleCell9.setCellValue( "vCore" );			titleCell9.setCellStyle(headerStyle);
			titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );		titleCell10.setCellStyle(headerStyle);
			titleCell11 = row.createCell(10);	titleCell11.setCellValue( "SAN(GB)" );		titleCell11.setCellStyle(headerStyle);
			titleCell12 = row.createCell(11);	titleCell12.setCellValue( "서비스수" );		titleCell12.setCellStyle(headerStyle);/////
			titleCell13 = row.createCell(12);	titleCell13.setCellValue( "Core" );			titleCell13.setCellStyle(headerStyle);/////
			titleCell14 = row.createCell(13);	titleCell14.setCellValue( "MEM(GB)" );		titleCell14.setCellStyle(headerStyle);/////
			titleCell15 = row.createCell(14);	titleCell15.setCellValue( "스토리지(GB)" );	titleCell15.setCellStyle(headerStyle);/////
			titleCell16 = row.createCell(15);	titleCell16.setCellValue( "물리서버" );		titleCell16.setCellStyle(headerStyle);/////
			titleCell17 = row.createCell(16);	titleCell17.setCellValue( "물리서버" );		titleCell17.setCellStyle(headerStyle);/////
			titleCell18 = row.createCell(17);	titleCell18.setCellValue( "가상서버" );		titleCell18.setCellStyle(headerStyle);/////
			titleCell19 = row.createCell(18);	titleCell19.setCellValue( "가상서버" );		titleCell19.setCellStyle(headerStyle);/////
			titleCell20 = row.createCell(19);	titleCell20.setCellValue( "가상서버" );		titleCell20.setCellStyle(headerStyle);/////
			titleCell21 = row.createCell(20);	titleCell21.setCellValue( "자동확장" );		titleCell21.setCellStyle(headerStyle);/////
			titleCell22 = row.createCell(21);	titleCell22.setCellValue( "자동확장" );		titleCell22.setCellStyle(headerStyle);/////

			row = sheet.createRow(2);
			titleCell1 = row.createCell(0);		titleCell1.setCellValue( "번호" );			titleCell1.setCellStyle(headerStyle);
			titleCell2 = row.createCell(1);		titleCell2.setCellValue( "자원풀코드" );	titleCell2.setCellStyle(headerStyle);
			titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터수" );	titleCell3.setCellStyle(headerStyle);
			titleCell4 = row.createCell(3);		titleCell4.setCellValue( "서버수" );		titleCell4.setCellStyle(headerStyle);
			titleCell5 = row.createCell(4);		titleCell5.setCellValue( "Core" );			titleCell5.setCellStyle(headerStyle);
			titleCell6 = row.createCell(5);		titleCell6.setCellValue( "MEM(GB)" );		titleCell6.setCellStyle(headerStyle);
			titleCell7 = row.createCell(6);		titleCell7.setCellValue( "SAN(GB)" );		titleCell7.setCellStyle(headerStyle);
			titleCell8 = row.createCell(7);		titleCell8.setCellValue( "가상서버수" );	titleCell8.setCellStyle(headerStyle);
			titleCell9 = row.createCell(8);		titleCell9.setCellValue( "vCore" );			titleCell9.setCellStyle(headerStyle);
			titleCell10 = row.createCell(9);	titleCell10.setCellValue( "MEM(GB)" );		titleCell10.setCellStyle(headerStyle);
			titleCell11 = row.createCell(10);	titleCell11.setCellValue( "SAN(GB)" );		titleCell11.setCellStyle(headerStyle);
			titleCell12 = row.createCell(11);	titleCell12.setCellValue( "서비스수" );		titleCell12.setCellStyle(headerStyle);/////
			titleCell13 = row.createCell(12);	titleCell13.setCellValue( "Core" );			titleCell13.setCellStyle(headerStyle);/////
			titleCell14 = row.createCell(13);	titleCell14.setCellValue( "MEM(GB)" );		titleCell14.setCellStyle(headerStyle);/////
			titleCell15 = row.createCell(14);	titleCell15.setCellValue( "스토리지(GB)" );	titleCell15.setCellStyle(headerStyle);/////
			titleCell16 = row.createCell(15);	titleCell16.setCellValue( "CPU" );			titleCell16.setCellStyle(headerStyle);/////
			titleCell17 = row.createCell(16);	titleCell17.setCellValue( "MEM" );			titleCell17.setCellStyle(headerStyle);/////
			titleCell18 = row.createCell(17);	titleCell18.setCellValue( "CPU" );			titleCell18.setCellStyle(headerStyle);/////
			titleCell19 = row.createCell(18);	titleCell19.setCellValue( "MEM" );			titleCell19.setCellStyle(headerStyle);/////
			titleCell20 = row.createCell(19);	titleCell20.setCellValue( "SAN" );			titleCell20.setCellStyle(headerStyle);/////
			titleCell21 = row.createCell(20);	titleCell21.setCellValue( "CPU" );			titleCell21.setCellStyle(headerStyle);/////
			titleCell22 = row.createCell(21);	titleCell22.setCellValue( "MEM" );		titleCell22.setCellStyle(headerStyle);/////

			sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//번호
			sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//자원풀코드
			sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//클러스터수

			sheet.addMergedRegion(new CellRangeAddress(0,0,3,6));//물리자원 보유량
			sheet.addMergedRegion(new CellRangeAddress(1,2,3,3));//서버수
			sheet.addMergedRegion(new CellRangeAddress(1,2,4,4));//CORE
			sheet.addMergedRegion(new CellRangeAddress(1,2,5,5));//MEM
			sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//SAN

			sheet.addMergedRegion(new CellRangeAddress(0,0,7,10));//논리자원 할당량
			sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//가상서버수
			sheet.addMergedRegion(new CellRangeAddress(1,2,8,8));//vCore
			sheet.addMergedRegion(new CellRangeAddress(1,2,9,9));//MEM
			sheet.addMergedRegion(new CellRangeAddress(1,2,10,10));//SAN

			sheet.addMergedRegion(new CellRangeAddress(0,0,11,14));//자동확장 할당량
			sheet.addMergedRegion(new CellRangeAddress(1,2,11,11));//서비스수
			sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));//Core
			sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//MEM(GB)
			sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));//스토리지(GB)

			sheet.addMergedRegion(new CellRangeAddress(0,0,15,21));//최빈시 자원 사용률(%) 평균
			sheet.addMergedRegion(new CellRangeAddress(1,1,15,16));//물리서버
			sheet.addMergedRegion(new CellRangeAddress(1,1,17,19));//가상서버
			sheet.addMergedRegion(new CellRangeAddress(1,1,20,21));//자동확장


		}else{
			Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "번호" );					titleCell1.setCellStyle(headerStyle);
			Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "자원풀코드" );			titleCell2.setCellStyle(headerStyle);
			Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );			titleCell3.setCellStyle(headerStyle);
			Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "클러스터" );				titleCell4.setCellStyle(headerStyle);
			Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "물리자원 보유량" );		titleCell5.setCellStyle(headerStyle);
			Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "물리자원 보유량" );		titleCell6.setCellStyle(headerStyle);
			Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리자원 보유량" );		titleCell7.setCellStyle(headerStyle);
			Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "물리자원 보유량" );		titleCell8.setCellStyle(headerStyle);
			Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "논리자원 할당량" );		titleCell9.setCellStyle(headerStyle);
			Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "논리자원 할당량" );		titleCell10.setCellStyle(headerStyle);
			Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "논리자원 할당량" );		titleCell11.setCellStyle(headerStyle);
			Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "논리자원 할당량" );				titleCell12.setCellStyle(headerStyle);
			Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "자동확장 할당량" );				titleCell13.setCellStyle(headerStyle);/////
			Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "자동확장 할당량" );				titleCell14.setCellStyle(headerStyle);/////
			Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "자동확장 할당량" );				titleCell15.setCellStyle(headerStyle);/////
			Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "자동확장 할당량" );				titleCell16.setCellStyle(headerStyle);/////
			Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell17.setCellStyle(headerStyle);/////
			Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell18.setCellStyle(headerStyle);/////
			Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell19.setCellStyle(headerStyle);/////
			Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell20.setCellStyle(headerStyle);/////
			Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell21.setCellStyle(headerStyle);/////
			Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell22.setCellStyle(headerStyle);/////
			Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell23.setCellStyle(headerStyle);/////

			row = sheet.createRow(1);
			titleCell1 = row.createCell(0);		titleCell1.setCellValue( "번호" );			titleCell1.setCellStyle(headerStyle);
			titleCell2 = row.createCell(1);		titleCell2.setCellValue( "자원풀코드" );	titleCell2.setCellStyle(headerStyle);
			titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터수" );	titleCell3.setCellStyle(headerStyle);
			titleCell4 = row.createCell(3);		titleCell4.setCellValue( "클러스터" );		titleCell4.setCellStyle(headerStyle);
			titleCell5 = row.createCell(4);		titleCell5.setCellValue( "서버수" );		titleCell5.setCellStyle(headerStyle);
			titleCell6 = row.createCell(5);		titleCell6.setCellValue( "Core" );			titleCell6.setCellStyle(headerStyle);
			titleCell7 = row.createCell(6);		titleCell7.setCellValue( "MEM(GB)" );		titleCell7.setCellStyle(headerStyle);
			titleCell8 = row.createCell(7);		titleCell8.setCellValue( "SAN(GB)" );		titleCell8.setCellStyle(headerStyle);
			titleCell9 = row.createCell(8);		titleCell9.setCellValue( "가상서버수" );	titleCell9.setCellStyle(headerStyle);
			titleCell10 = row.createCell(9);	titleCell10.setCellValue( "vCore" );		titleCell10.setCellStyle(headerStyle);
			titleCell11 = row.createCell(10);	titleCell11.setCellValue( "MEM(GB)" );		titleCell11.setCellStyle(headerStyle);
			titleCell12 = row.createCell(11);	titleCell12.setCellValue( "SAN(GB)" );		titleCell12.setCellStyle(headerStyle);
			titleCell13 = row.createCell(12);	titleCell13.setCellValue( "서비스수" );		titleCell13.setCellStyle(headerStyle);/////
			titleCell14 = row.createCell(13);	titleCell14.setCellValue( "Core" );			titleCell14.setCellStyle(headerStyle);/////
			titleCell15 = row.createCell(14);	titleCell15.setCellValue( "MEM(GB)" );		titleCell15.setCellStyle(headerStyle);/////
			titleCell16 = row.createCell(15);	titleCell16.setCellValue( "스토리지(GB)" );	titleCell16.setCellStyle(headerStyle);/////
			titleCell17 = row.createCell(16);	titleCell17.setCellValue( "물리서버" );		titleCell17.setCellStyle(headerStyle);/////
			titleCell18 = row.createCell(17);	titleCell18.setCellValue( "물리서버" );		titleCell18.setCellStyle(headerStyle);/////
			titleCell19 = row.createCell(18);	titleCell19.setCellValue( "가상서버" );		titleCell19.setCellStyle(headerStyle);/////
			titleCell20 = row.createCell(19);	titleCell20.setCellValue( "가상서버" );		titleCell20.setCellStyle(headerStyle);/////
			titleCell21 = row.createCell(20);	titleCell21.setCellValue( "가상서버" );		titleCell21.setCellStyle(headerStyle);/////
			titleCell22 = row.createCell(21);	titleCell22.setCellValue( "자동확장" );		titleCell22.setCellStyle(headerStyle);/////
			titleCell23 = row.createCell(22);	titleCell23.setCellValue( "자동확장" );		titleCell23.setCellStyle(headerStyle);/////

			row = sheet.createRow(2);
			titleCell1 = row.createCell(0);		titleCell1.setCellValue( "번호" );			titleCell1.setCellStyle(headerStyle);
			titleCell2 = row.createCell(1);		titleCell2.setCellValue( "자원풀코드" );	titleCell2.setCellStyle(headerStyle);
			titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터수" );	titleCell3.setCellStyle(headerStyle);
			titleCell4 = row.createCell(3);		titleCell4.setCellValue( "클러스터" );		titleCell4.setCellStyle(headerStyle);
			titleCell5 = row.createCell(4);		titleCell5.setCellValue( "서버수" );		titleCell5.setCellStyle(headerStyle);
			titleCell6 = row.createCell(5);		titleCell6.setCellValue( "Core" );			titleCell6.setCellStyle(headerStyle);
			titleCell7 = row.createCell(6);		titleCell7.setCellValue( "MEM(GB)" );		titleCell7.setCellStyle(headerStyle);
			titleCell8 = row.createCell(7);		titleCell8.setCellValue( "SAN(GB)" );		titleCell8.setCellStyle(headerStyle);
			titleCell9 = row.createCell(8);		titleCell9.setCellValue( "가상서버수" );	titleCell9.setCellStyle(headerStyle);
			titleCell10 = row.createCell(9);	titleCell10.setCellValue( "vCore" );		titleCell10.setCellStyle(headerStyle);
			titleCell11 = row.createCell(10);	titleCell11.setCellValue( "MEM(GB)" );		titleCell11.setCellStyle(headerStyle);
			titleCell12 = row.createCell(11);	titleCell12.setCellValue( "SAN(GB)" );		titleCell12.setCellStyle(headerStyle);
			titleCell13 = row.createCell(12);	titleCell13.setCellValue( "서비스수" );		titleCell13.setCellStyle(headerStyle);/////
			titleCell14 = row.createCell(13);	titleCell14.setCellValue( "Core" );			titleCell14.setCellStyle(headerStyle);/////
			titleCell15 = row.createCell(14);	titleCell15.setCellValue( "MEM(GB)" );		titleCell15.setCellStyle(headerStyle);/////
			titleCell16 = row.createCell(15);	titleCell16.setCellValue( "스토리지(GB)" );	titleCell16.setCellStyle(headerStyle);/////
			titleCell17 = row.createCell(16);	titleCell17.setCellValue( "CPU" );			titleCell17.setCellStyle(headerStyle);/////
			titleCell18 = row.createCell(17);	titleCell18.setCellValue( "MEM" );			titleCell18.setCellStyle(headerStyle);/////
			titleCell19 = row.createCell(18);	titleCell19.setCellValue( "CPU" );			titleCell19.setCellStyle(headerStyle);/////
			titleCell20 = row.createCell(19);	titleCell20.setCellValue( "MEM" );			titleCell20.setCellStyle(headerStyle);/////
			titleCell21 = row.createCell(20);	titleCell21.setCellValue( "SAN" );			titleCell21.setCellStyle(headerStyle);/////
			titleCell22 = row.createCell(21);	titleCell22.setCellValue( "CPU" );			titleCell22.setCellStyle(headerStyle);/////
			titleCell23 = row.createCell(22);	titleCell23.setCellValue( "MEM" );		titleCell23.setCellStyle(headerStyle);/////

			sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//번호
			sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//자원풀코드
			sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//클러스터수
			sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//클러스터

			sheet.addMergedRegion(new CellRangeAddress(0,0,4,7));//물리자원 보유량
			sheet.addMergedRegion(new CellRangeAddress(1,2,4,4));//서버수
			sheet.addMergedRegion(new CellRangeAddress(1,2,5,5));//CORE
			sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//MEM
			sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//SAN

			sheet.addMergedRegion(new CellRangeAddress(0,0,8,11));//논리자원 할당량
			sheet.addMergedRegion(new CellRangeAddress(1,2,8,8));//가상서버수
			sheet.addMergedRegion(new CellRangeAddress(1,2,9,9));//vCore
			sheet.addMergedRegion(new CellRangeAddress(1,2,10,10));//MEM
			sheet.addMergedRegion(new CellRangeAddress(1,2,11,11));//SAN

			sheet.addMergedRegion(new CellRangeAddress(0,0,12,15));//자동확장 할당량
			sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));//서비스수
			sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//Core
			sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));//MEM(GB)
			sheet.addMergedRegion(new CellRangeAddress(1,2,15,15));//스토리지(GB)

			sheet.addMergedRegion(new CellRangeAddress(0,0,16,22));//최빈시 자원 사용률(%) 평균
			sheet.addMergedRegion(new CellRangeAddress(1,1,16,17));//물리서버
			sheet.addMergedRegion(new CellRangeAddress(1,1,18,20));//가상서버
			sheet.addMergedRegion(new CellRangeAddress(1,1,21,22));//자동확장
		}

		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,21));
			list = new ArrayList<RsrcUseStteClstrVo>();
		}
		for(int i=0; i<list.size(); i++){
			RsrcUseStteClstrVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
			if(searchVo.getDtlGubun().equals("sumy")){
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(i+1);
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getClstrSeq()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getPmSeq()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getLastVSrvrQty()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnStrgCapa()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getAutoLastServc()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getAutoLastCoreQty()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getAutoLastMemCapa()));
				Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getAutoLastStrgCpa()));
				Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt()));
				Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt()));
				Cell dataCell17 = dataRow.createCell(17);	 dataCell17.setCellValue(DateUtil.stringValueOf(vo.getVmMaxCpuUseRt()));
				Cell dataCell18 = dataRow.createCell(18);	 dataCell18.setCellValue(DateUtil.stringValueOf(vo.getVmMaxMemUseRt()));
				Cell dataCell19 = dataRow.createCell(19);	 dataCell19.setCellValue(DateUtil.stringValueOf(vo.getVmMaxStrgUseRt()));
				Cell dataCell20 = dataRow.createCell(20);	 dataCell20.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxCpuUseRt()));
				Cell dataCell21 = dataRow.createCell(21);	 dataCell21.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxMemUseRt()));

			}else{
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(i+1);
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getClstrSeq()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getClstrNm()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getPmSeq()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getLastVSrvrQty()));
				Cell dataCell9 = dataRow.createCell(9);	     dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));
				Cell dataCell10 = dataRow.createCell(10);    dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnStrgCapa()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getAutoLastServc()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getAutoLastCoreQty()));
				Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getAutoLastMemCapa()));
				Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getAutoLastStrgCpa()));
				Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt()));
				Cell dataCell17 = dataRow.createCell(17);	 dataCell17.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt()));
				Cell dataCell18 = dataRow.createCell(18);	 dataCell18.setCellValue(DateUtil.stringValueOf(vo.getVmMaxCpuUseRt()));
				Cell dataCell19 = dataRow.createCell(19);	 dataCell19.setCellValue(DateUtil.stringValueOf(vo.getVmMaxMemUseRt()));
				Cell dataCell20 = dataRow.createCell(20);	 dataCell20.setCellValue(DateUtil.stringValueOf(vo.getVmMaxStrgUseRt()));
				Cell dataCell21 = dataRow.createCell(21);	 dataCell21.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxCpuUseRt()));
				Cell dataCell22 = dataRow.createCell(22);	 dataCell22.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxMemUseRt()));


			}

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자원사용현황 - 클러스터별").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


	    }


}

