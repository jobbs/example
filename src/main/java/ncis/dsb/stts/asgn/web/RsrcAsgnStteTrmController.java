/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteTrmController.java
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


package ncis.dsb.stts.asgn.web;

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
import ncis.dsb.stts.asgn.service.RsrcAsgnStteTrmService;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmVo;

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

@Controller("rsrcAsgnStteTrmController")
@RequestMapping("/dsb/stts/asgn/trm")
public class RsrcAsgnStteTrmController extends BaseController {


	@Resource(name="rsrcAsgnStteTrmService")
	RsrcAsgnStteTrmService rsrcAsgnStteTrmService;

	@Resource(name = "regionService")
    RegionService regionService;
	/**
	 * 자원 보유 및 할당 현황 - 기간별 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcAsgnStteTrmList.do")
	public String selectRsrcAsgnStteTrmList( HttpServletRequest request,RsrcAsgnStteTrmSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getTrm() == null) searchVo.setTrm("mm");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());


		List<RegionVo> regionVoList = regionService.selectRegionAllList();


		List<RsrcAsgnStteTrmVo> list = null;
		if(searchVo.getSearch() != null){
				list = rsrcAsgnStteTrmService.selectRsrcAsgnStteTrmList(searchVo);	// 게시글list 가져오기
		}
		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectRsrcAsgnStteTrmList");
	}

	/**
	 * 자원 보유 및 할당 현황 - 기간별 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcAsgnStteTrmXlsDown.do")
	public void selecInsttChngStteXlsDown(
			RsrcAsgnStteTrmSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{


		List<RsrcAsgnStteTrmVo> list = null;
		if(searchVo.getSearch() != null){
				list = rsrcAsgnStteTrmService.selectRsrcAsgnStteTrmList(searchVo);	// 게시글list 가져오기
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자원 보유 및 할당 현황-기간별");

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
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "지원풀수" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );				titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "물리자원 보유량" );				titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "물리자원 보유량" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "물리자원 보유량" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리자원 보유량" );						titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "물리자원 보유량" );						titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "물리자원 보유량" );						titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "물리자원 보유량" );						titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "물리자원 보유량" );						titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "물리자원 보유량" );		titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "물리자원 보유량" );		titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "물리자원 보유량" );		titleCell14.setCellStyle(headerStyle);/////

		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "논리자원 할당량" );		titleCell15.setCellStyle(headerStyle);/////
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "논리자원 할당량" );		titleCell16.setCellStyle(headerStyle);/////
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "논리자원 할당량" );		titleCell17.setCellStyle(headerStyle);/////
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "논리자원 할당량" );		titleCell18.setCellStyle(headerStyle);/////
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "서버가상화율(%)" );		titleCell19.setCellStyle(headerStyle);/////
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "자원 할당률(%)" );		titleCell20.setCellStyle(headerStyle);/////
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "자원 할당률(%)" );		titleCell21.setCellStyle(headerStyle);/////
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "자원 할당률(%)" );		titleCell22.setCellStyle(headerStyle);/////


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "지원풀수" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "서버수(가상화SW)" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "서버수(가상화SW)" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "서버수(가상화SW)" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "서버수(가상화SW)" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "서버수(가상화SW)" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "서버수(가상화SW)" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "서버수(가상화SW)" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "서버수(가상화SW)" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "Core" );						titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "MEM(GB)" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "SAN(GB)" );		titleCell14.setCellStyle(headerStyle);/////

		titleCell15 = row.createCell(14);	titleCell15.setCellValue( "가상서버수" );		titleCell15.setCellStyle(headerStyle);/////
		titleCell16 = row.createCell(15);	titleCell16.setCellValue( "vCore" );		titleCell16.setCellStyle(headerStyle);/////
		titleCell17 = row.createCell(16);	titleCell17.setCellValue( "MEM(GB)" );		titleCell17.setCellStyle(headerStyle);/////
		titleCell18 = row.createCell(17);	titleCell18.setCellValue( "SAN(GB)" );		titleCell18.setCellStyle(headerStyle);/////
		titleCell19 = row.createCell(18);	titleCell19.setCellValue( "서버가상화율(%)" );		titleCell19.setCellStyle(headerStyle);/////
		titleCell20 = row.createCell(19);	titleCell20.setCellValue( "vCore" );		titleCell20.setCellStyle(headerStyle);/////
		titleCell21 = row.createCell(20);	titleCell21.setCellValue( "MEM" );		titleCell21.setCellStyle(headerStyle);/////
		titleCell22 = row.createCell(21);	titleCell22.setCellValue( "SAN" );		titleCell22.setCellStyle(headerStyle);/////

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "지원풀수" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );				titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "계" );				titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "RHEV" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "VMWare" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "IBM VM" );						titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "HP VM" );						titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "OPENSTACK" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "DOCKER" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "ORACLE VM" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "Core" );						titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "MEM(GB)" );		titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "SAN(GB)" );		titleCell14.setCellStyle(headerStyle);/////

		titleCell15 = row.createCell(14);	titleCell15.setCellValue( "가상서버수" );		titleCell15.setCellStyle(headerStyle);/////
		titleCell16 = row.createCell(15);	titleCell16.setCellValue( "vCore" );		titleCell16.setCellStyle(headerStyle);/////
		titleCell17 = row.createCell(16);	titleCell17.setCellValue( "MEM(GB)" );		titleCell17.setCellStyle(headerStyle);/////
		titleCell18 = row.createCell(17);	titleCell18.setCellValue( "SAN(GB)" );		titleCell18.setCellStyle(headerStyle);/////
		titleCell19 = row.createCell(18);	titleCell19.setCellValue( "서버가상화율(%)" );		titleCell19.setCellStyle(headerStyle);/////
		titleCell20 = row.createCell(19);	titleCell20.setCellValue( "vCore" );		titleCell20.setCellStyle(headerStyle);/////
		titleCell21 = row.createCell(20);	titleCell21.setCellValue( "MEM" );		titleCell21.setCellStyle(headerStyle);/////
		titleCell22 = row.createCell(21);	titleCell22.setCellValue( "SAN" );		titleCell22.setCellStyle(headerStyle);/////


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//구분
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//지원풀수
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//클러스터수
		sheet.addMergedRegion(new CellRangeAddress(1,1,3,10));//서버수(가상화SW)
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,13));//물리자원 보유량
		sheet.addMergedRegion(new CellRangeAddress(1,2,11,11));//CORE
		sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//SAN


		sheet.addMergedRegion(new CellRangeAddress(0,0,14,17));//논리자원 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));//논리자원 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,15,15));//논리자원 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,16,16));//논리자원 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,17,17));//논리자원 할당량


		sheet.addMergedRegion(new CellRangeAddress(0,2,18,18));//서버가상화율
		sheet.addMergedRegion(new CellRangeAddress(0,0,19,21));//자원 할당률
		sheet.addMergedRegion(new CellRangeAddress(1,2,19,19));//자원 할당률
		sheet.addMergedRegion(new CellRangeAddress(1,2,20,20));//자원 할당률
		sheet.addMergedRegion(new CellRangeAddress(1,2,21,21));//자원 할당률





		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,22));
			list = new ArrayList<RsrcAsgnStteTrmVo>();
		}
		for(int i=0; i<list.size(); i++){
			RsrcAsgnStteTrmVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(vo.getMm().toString() );
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolId()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getClstrSeq()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getVrlzSwTyCd()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getRhev()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getVmware()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getIbm()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getHp()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getOpenstack()));
				Cell dataCell9 = dataRow.createCell(9);      dataCell9.setCellValue(DateUtil.stringValueOf(vo.getDocker()));
				Cell dataCell10 = dataRow.createCell(10);      dataCell10.setCellValue(DateUtil.stringValueOf(vo.getOvm()));
				Cell dataCell11 = dataRow.createCell(11);	 dataCell11.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
				Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getLastVSrvrQty()));
				Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));
				Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
				Cell dataCell17 = dataRow.createCell(17);	 dataCell17.setCellValue(DateUtil.stringValueOf(vo.getVmLastAsgnStrgCapa()));
				Cell dataCell18 = dataRow.createCell(18);	 dataCell18.setCellValue(DateUtil.stringValueOf(vo.getVrlzRt()));
				Cell dataCell19 = dataRow.createCell(19);	 dataCell19.setCellValue(DateUtil.stringValueOf(vo.getVcoreRt()));
				Cell dataCell20 = dataRow.createCell(20);	 dataCell20.setCellValue(DateUtil.stringValueOf(vo.getMemRt()));
				Cell dataCell21 = dataRow.createCell(21);	 dataCell21.setCellValue(DateUtil.stringValueOf(vo.getSanRt()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자원 보유 및 할당 현황-기간별").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }


}
