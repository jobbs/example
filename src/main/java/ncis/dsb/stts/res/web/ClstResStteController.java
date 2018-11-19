/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteController.java
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
import ncis.dsb.stts.res.service.ClstResStteService;
import ncis.dsb.stts.res.vo.ClstResInfoVo;
import ncis.dsb.stts.res.vo.ClstResStteCvo;
import ncis.dsb.stts.res.vo.ClstResStteSearchVo;

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

@Controller("clstResStteController")
@RequestMapping("/dsb/stts/res/clstResStte")
public class ClstResStteController extends BaseController {


	@Resource(name="clstResStteService")
	ClstResStteService clstResStteService;

	/**
	 * 자원풀 자원현황 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstResStteList.do")
	public String selectClstResStteList( HttpServletRequest request,
			Model model, ClstResStteSearchVo searchVo) throws Exception{

		ClstResStteCvo clstResStteCvo = null;
		if(searchVo.getSearchTrmCd()!=null){
			clstResStteCvo = clstResStteService.selectClstResStteList(searchVo);	// 게시글list 가져오기
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		model.addAttribute("ClstResStteCvo", clstResStteCvo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"selectClstResStteList");
	}

	/**
	 * 자원풀 자원현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstResStteListXlsDown.do")
	public void selectClstResStteListXlsDown(
			ClstResStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		ClstResStteCvo clstResStteCvo = null;
		List<ClstResInfoVo> list = null;
		if(searchVo.getSearchTrmCd()!=null){
			clstResStteCvo = clstResStteService.selectClstResStteList(searchVo);
			list = clstResStteCvo.getClstResInfoList();
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자원풀자원현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "센터" );			titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "존" );			titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "망" );			titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "자원풀명" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "클러스터명" );	titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "클러스터 용도" );	titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리서버" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "물리서버" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "물리서버" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "물리서버" );		titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "하이퍼바이저" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "가상서버" );		titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "가상서버" );		titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "가상서버" );		titleCell14.setCellStyle(headerStyle);/////
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "가상서버" );		titleCell15.setCellStyle(headerStyle);
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "가상서버" );		titleCell16.setCellStyle(headerStyle);
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "가상서버" );		titleCell17.setCellStyle(headerStyle);
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "가상서버" );		titleCell18.setCellStyle(headerStyle);
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "자원할당량" );	titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "자원할당량" );	titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "자원할당량" );	titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "가상화율" );		titleCell22.setCellStyle(headerStyle);
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "가상화율" );		titleCell23.setCellStyle(headerStyle);
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "자동자원확장" );	titleCell24.setCellStyle(headerStyle);
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "자동자원확장" );	titleCell25.setCellStyle(headerStyle);
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "자동자원확장" );	titleCell26.setCellStyle(headerStyle);
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "자동자원확장" );	titleCell27.setCellStyle(headerStyle);
		Cell titleCell28 = row.createCell(27);	titleCell28.setCellValue( "자동자원확장" );	titleCell28.setCellStyle(headerStyle);


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "센터" );			titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "존" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "망" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "자원풀명" );		titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "클러스터명" );	titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "클러스터 용도" );	titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "수량" );			titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "CPU(코어)" );		titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "메모리(GB)" );	titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "스토리지(TB)" );	titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "하이퍼바이저" );	titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "총수량" );		titleCell12.setCellStyle(headerStyle);

		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "LINUX" );		titleCell13.setCellStyle(headerStyle);//
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "HP-UX" );		titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "AIX" );			titleCell15.setCellStyle(headerStyle);
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "WIN" );			titleCell16.setCellStyle(headerStyle);//
		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "SOLARIS" );			titleCell17.setCellStyle(headerStyle);//
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "기타" );			titleCell18.setCellStyle(headerStyle);
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "CPU(vCore)" );	titleCell19.setCellStyle(headerStyle);//

		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "메모리(GB)" );	titleCell20.setCellStyle(headerStyle);//
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "스토리지(TB)" );	titleCell21.setCellStyle(headerStyle);
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "CPU(%)" );		titleCell22.setCellStyle(headerStyle);
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "메모리(%)" );	titleCell23.setCellStyle(headerStyle);//
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "수량" );			titleCell24.setCellStyle(headerStyle);//
		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "수량" );			titleCell25.setCellStyle(headerStyle);//

		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "자원할당량" );	titleCell26.setCellStyle(headerStyle);//
		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "자원할당량" );	titleCell27.setCellStyle(headerStyle);//
		titleCell28 = row.createCell(27);		titleCell28.setCellValue( "자원할당량" );	titleCell28.setCellStyle(headerStyle);//

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "센터" );			titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "존" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "망" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "자원풀명" );		titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "클러스터명" );	titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "클러스터 용도" );	titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "수량" );			titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "CPU(코어)" );		titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "메모리(GB)" );	titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "스토리지(TB)" );	titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "하이퍼바이저" );	titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "총수량" );		titleCell12.setCellStyle(headerStyle);

		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "LINUX" );		titleCell13.setCellStyle(headerStyle);//
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "HP-UX" );		titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "AIX" );			titleCell15.setCellStyle(headerStyle);
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "WIN" );			titleCell16.setCellStyle(headerStyle);//
		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "SOLARIS" );			titleCell17.setCellStyle(headerStyle);//
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "기타" );			titleCell18.setCellStyle(headerStyle);
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "CPU(vCore)" );	titleCell19.setCellStyle(headerStyle);//

		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "메모리(GB)" );	titleCell20.setCellStyle(headerStyle);//
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "스토리지(TB)" );	titleCell21.setCellStyle(headerStyle);
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "CPU(%)" );		titleCell22.setCellStyle(headerStyle);
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "메모리(%)" );	titleCell23.setCellStyle(headerStyle);//
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "서비스수" );			titleCell24.setCellStyle(headerStyle);//
		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "POD수" );			titleCell25.setCellStyle(headerStyle);//

		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "CPU(Core)" );	titleCell26.setCellStyle(headerStyle);//
		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "메모리(GB)" );	titleCell27.setCellStyle(headerStyle);//
		titleCell28 = row.createCell(27);		titleCell28.setCellValue( "스토리지(GB)" );	titleCell28.setCellStyle(headerStyle);//

		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//존
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//망
		sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//자원풀명
		sheet.addMergedRegion(new CellRangeAddress(0,2,4,4));//클러스터명
		sheet.addMergedRegion(new CellRangeAddress(0,2,5,5));//클러스터용도
		sheet.addMergedRegion(new CellRangeAddress(0,0,6,9));//물리서버
		sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//수량
		sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//cpu
		sheet.addMergedRegion(new CellRangeAddress(1,2,8,8));//메모리
		sheet.addMergedRegion(new CellRangeAddress(1,2,9,9));//스토리지
		sheet.addMergedRegion(new CellRangeAddress(0,2,10,10));//하이퍼바이저
		sheet.addMergedRegion(new CellRangeAddress(0,0,11,17));//가상서버
		sheet.addMergedRegion(new CellRangeAddress(1,2,11,11));//총수량
		sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));//linux
		sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//hp
		sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));//aix
		sheet.addMergedRegion(new CellRangeAddress(1,2,15,15));//win
		sheet.addMergedRegion(new CellRangeAddress(1,2,16,16));//Solaris
		sheet.addMergedRegion(new CellRangeAddress(1,2,17,17));//기타

		sheet.addMergedRegion(new CellRangeAddress(0,0,18,20));//자원할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,18,18));//cpu
		sheet.addMergedRegion(new CellRangeAddress(1,2,19,19));//메모리
		sheet.addMergedRegion(new CellRangeAddress(1,2,20,20));//스토리지
		sheet.addMergedRegion(new CellRangeAddress(0,0,21,22));//가상화율
		sheet.addMergedRegion(new CellRangeAddress(1,2,21,21));//cpu
		sheet.addMergedRegion(new CellRangeAddress(1,2,22,22));//메모리
		sheet.addMergedRegion(new CellRangeAddress(0,0,23,27));//자동자원확장
		sheet.addMergedRegion(new CellRangeAddress(1,1,23,24));//수량
		sheet.addMergedRegion(new CellRangeAddress(1,1,25,27));//자원할당량



		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,27));
			list = new ArrayList<ClstResInfoVo>();
		}
		for(int i=0; i<list.size(); i++){
			ClstResInfoVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
			Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(vo.getRegionNm());
			Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(vo.getZoneNm());
			Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(vo.getNetNm());
			Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(vo.getRsrcPoolNm());
			Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(vo.getClstrNm());
			Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(vo.getPrposNm());
			Cell dataCell6 = dataRow.createCell(6);	 	dataCell6.setCellValue(DateUtil.stringValueOf(vo.getPmCnt()));
			Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
			Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
			Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
			Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(vo.getHipervisor()));
			Cell dataCell11 = dataRow.createCell(11); 	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getVmCnt()));

			Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getLinuxCnt()));
			Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getHpCnt()));
			Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getAixCnt()));
			Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getWinCnt()));
			Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getSolarisCnt()));
			Cell dataCell17 = dataRow.createCell(17);	 dataCell17.setCellValue(DateUtil.stringValueOf(vo.getEtcCnt()));
			Cell dataCell18 = dataRow.createCell(18);	 dataCell18.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));

			Cell dataCell19 = dataRow.createCell(19);	 dataCell19.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
			Cell dataCell20 = dataRow.createCell(20);	 dataCell20.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnStrgCapa()));
			Cell dataCell21 = dataRow.createCell(21);	 dataCell21.setCellValue(DateUtil.stringValueOf(vo.getCpuVirtRt()));
			Cell dataCell22 = dataRow.createCell(22);	 dataCell22.setCellValue(DateUtil.stringValueOf(vo.getMemVirtRt()));
			Cell dataCell23 = dataRow.createCell(23);	 dataCell23.setCellValue(DateUtil.stringValueOf(vo.getServcCnt()));
			Cell dataCell24 = dataRow.createCell(24);	 dataCell24.setCellValue(DateUtil.stringValueOf(vo.getPodQty()));
			Cell dataCell25 = dataRow.createCell(25);	 dataCell25.setCellValue(DateUtil.stringValueOf(vo.getCpuCorQty()));
			Cell dataCell26 = dataRow.createCell(26);	 dataCell26.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa()));
			Cell dataCell27 = dataRow.createCell(27);	 dataCell27.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa()));

		}

		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자원풀자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

    }


}
