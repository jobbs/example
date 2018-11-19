/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteController.java
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
import ncis.dsb.stts.rsrcuse.service.RsrcUseStteService;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteVo;

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

@Controller("rsrcUseStteController")
@RequestMapping("/dsb/stts/rsrcuse/trm")
public class RsrcUseStteController extends BaseController {


	@Resource(name="rsrcUseStteService")
	RsrcUseStteService rsrcUseStteService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 자원사용현황 - 기간별
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcUseStteList.do")

	public String selectRsrcUseStteList( HttpServletRequest request,RsrcUseStteSearchVo searchVo,
			Model model) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));

		if(searchVo.getTrm() == null) searchVo.setTrm("mm");
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getRegion() == null) searchVo.setRegion(new ArrayList<String>());

		List<RegionVo> regionVoList = regionService.selectRegionAllList();


		List<RsrcUseStteVo> list = null;

		if(searchVo.getSearch() != null){
				list = rsrcUseStteService.selectRsrcUseStteList(searchVo);	// 게시글list 가져오기
		}
		model.addAttribute("list", list);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectRsrcUseStteList");
	}

	/**
	 * 자원사용현황 - 기간별 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectRsrcUseStteXlsDown.do")
	public void selecInsttChngStteXlsDown(
			RsrcUseStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);


		List<RsrcUseStteVo> list = null;

		if(searchVo.getSearch() != null){
				list = rsrcUseStteService.selectRsrcUseStteList(searchVo);	// 게시글list 가져오기
		}
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자원사용현황 - 기간별");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );							titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "지원풀수" );						titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );					titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "물리자원 보유량" );				titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "물리자원 보유량" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "물리자원 보유량" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리자원 보유량" );				titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "물리자원 보유량" );				titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "물리자원 보유량" );				titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "물리자원 보유량" );				titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "물리자원 보유량" );				titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "물리자원 보유량" );				titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "물리자원 보유량" );				titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "물리자원 보유량" );				titleCell14.setCellStyle(headerStyle);/////
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "물리자원 보유량" );				titleCell15.setCellStyle(headerStyle);/////
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "논리자원 할당량" );				titleCell16.setCellStyle(headerStyle);/////
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "논리자원 할당량" );				titleCell17.setCellStyle(headerStyle);/////
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "논리자원 할당량" );				titleCell18.setCellStyle(headerStyle);/////
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "논리자원 할당량" );				titleCell19.setCellStyle(headerStyle);/////
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "자동확장 할당량" );				titleCell20.setCellStyle(headerStyle);/////
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "자동확장 할당량" );				titleCell21.setCellStyle(headerStyle);/////
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "자동확장 할당량" );				titleCell22.setCellStyle(headerStyle);/////
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "자동확장 할당량" );				titleCell23.setCellStyle(headerStyle);/////
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell24.setCellStyle(headerStyle);/////
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell25.setCellStyle(headerStyle);/////
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell26.setCellStyle(headerStyle);/////
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell27.setCellStyle(headerStyle);/////
		Cell titleCell28 = row.createCell(27);	titleCell28.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell28.setCellStyle(headerStyle);/////
		Cell titleCell29 = row.createCell(28);	titleCell29.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell29.setCellStyle(headerStyle);/////
		Cell titleCell30 = row.createCell(29);	titleCell30.setCellValue( "최빈시 자원 사용률(%) 평균" );	titleCell30.setCellStyle(headerStyle);/////


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);		titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);		titleCell2.setCellValue( "지원풀수" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터수" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);		titleCell4.setCellValue( "서버수(가상화SW)" );		titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);		titleCell5.setCellValue( "서버수(가상화SW)" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);		titleCell6.setCellValue( "서버수(가상화SW)" );		titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);		titleCell7.setCellValue( "서버수(가상화SW)" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);		titleCell8.setCellValue( "서버수(가상화SW)" );		titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);		titleCell9.setCellValue( "서버수(가상화SW)" );		titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "서버수(가상화SW)" );		titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "서버수(가상화SW)" );		titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "서버수(가상화SW)" );		titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "Core" );					titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "MEM(GB)" );				titleCell14.setCellStyle(headerStyle);/////
		titleCell15 = row.createCell(14);	titleCell15.setCellValue( "SAN(GB)" );				titleCell15.setCellStyle(headerStyle);/////


		titleCell16 = row.createCell(15);	titleCell16.setCellValue( "가상서버수" );			titleCell16.setCellStyle(headerStyle);/////
		titleCell17 = row.createCell(16);	titleCell17.setCellValue( "vCore" );				titleCell17.setCellStyle(headerStyle);/////
		titleCell18 = row.createCell(17);	titleCell18.setCellValue( "MEM" );					titleCell18.setCellStyle(headerStyle);/////
		titleCell19 = row.createCell(18);	titleCell19.setCellValue( "SAN" );					titleCell19.setCellStyle(headerStyle);/////

		titleCell20 = row.createCell(19);	titleCell20.setCellValue( "서비스수" );				titleCell20.setCellStyle(headerStyle);/////
		titleCell21 = row.createCell(20);	titleCell21.setCellValue( "Core" );					titleCell21.setCellStyle(headerStyle);/////
		titleCell22 = row.createCell(21);	titleCell22.setCellValue( "MEM(GB)" );				titleCell22.setCellStyle(headerStyle);/////
		titleCell23 = row.createCell(22);	titleCell23.setCellValue( "스토리지(GB)" );				titleCell23.setCellStyle(headerStyle);/////

		titleCell24 = row.createCell(23);	titleCell24.setCellValue( "물리서버" );				titleCell24.setCellStyle(headerStyle);/////
		titleCell25 = row.createCell(24);	titleCell25.setCellValue( "물리서버" );				titleCell25.setCellStyle(headerStyle);/////
		titleCell26 = row.createCell(25);	titleCell26.setCellValue( "가상서버" );				titleCell26.setCellStyle(headerStyle);/////
		titleCell27 = row.createCell(26);	titleCell27.setCellValue( "가상서버" );				titleCell27.setCellStyle(headerStyle);/////
		titleCell28 = row.createCell(27);	titleCell28.setCellValue( "가상서버" );				titleCell28.setCellStyle(headerStyle);/////
		titleCell29 = row.createCell(28);	titleCell29.setCellValue( "자동확장" );				titleCell29.setCellStyle(headerStyle);/////
		titleCell30 = row.createCell(29);	titleCell30.setCellValue( "자동확장" );				titleCell30.setCellStyle(headerStyle);/////

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);	titleCell1.setCellValue( "구분" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);	titleCell2.setCellValue( "지원풀수" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터수" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);	titleCell4.setCellValue( "계" );					titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);	titleCell5.setCellValue( "RHEV" );					titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);	titleCell6.setCellValue( "VMWare" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);	titleCell7.setCellValue( "IBM VM" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);	titleCell8.setCellValue( "HP VM" );					titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);	titleCell9.setCellValue( "OPENSTACK" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "DOCKER" );			titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "ORACLE VM" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "OPENSHIFT" );		titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "Core" );				titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "MEM(GB)" );			titleCell14.setCellStyle(headerStyle);/////
		titleCell15 = row.createCell(14);	titleCell15.setCellValue( "SAN(GB)" );			titleCell15.setCellStyle(headerStyle);/////

		titleCell16 = row.createCell(15);	titleCell16.setCellValue( "가상서버수" );		titleCell16.setCellStyle(headerStyle);/////
		titleCell17 = row.createCell(16);	titleCell17.setCellValue( "vCore" );			titleCell17.setCellStyle(headerStyle);/////
		titleCell18 = row.createCell(17);	titleCell18.setCellValue( "MEM" );				titleCell18.setCellStyle(headerStyle);/////
		titleCell19 = row.createCell(18);	titleCell19.setCellValue( "SAN" );				titleCell19.setCellStyle(headerStyle);/////


		titleCell20 = row.createCell(23);	titleCell20.setCellValue( "CPU" );				titleCell20.setCellStyle(headerStyle);/////
		titleCell21 = row.createCell(24);	titleCell21.setCellValue( "MEM" );				titleCell21.setCellStyle(headerStyle);/////
		titleCell22 = row.createCell(25);	titleCell22.setCellValue( "CPU" );				titleCell22.setCellStyle(headerStyle);/////
		titleCell23 = row.createCell(26);	titleCell23.setCellValue( "MEM" );				titleCell23.setCellStyle(headerStyle);/////
		titleCell24 = row.createCell(27);	titleCell24.setCellValue( "SAN" );				titleCell24.setCellStyle(headerStyle);/////

		titleCell25 = row.createCell(28);	titleCell25.setCellValue( "CPU" );				titleCell25.setCellStyle(headerStyle);/////
		titleCell26 = row.createCell(29);	titleCell26.setCellValue( "MEM" );			titleCell26.setCellStyle(headerStyle);/////


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//구분
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//지원풀수
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//클러스터수
		sheet.addMergedRegion(new CellRangeAddress(1,1,3,11));//서버수(가상화SW)
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,14));//물리자원 보유량
		sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));//CORE
		sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));//SAN


		sheet.addMergedRegion(new CellRangeAddress(0,0,15,18));//논리자원 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,15,15));//가상서버수
		sheet.addMergedRegion(new CellRangeAddress(1,2,16,16));//vCore
		sheet.addMergedRegion(new CellRangeAddress(1,2,17,17));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,2,18,18));//SAN

		sheet.addMergedRegion(new CellRangeAddress(0,0,19,22));//자동확장 할당량
		sheet.addMergedRegion(new CellRangeAddress(1,2,19,19));//서비스수
		sheet.addMergedRegion(new CellRangeAddress(1,2,20,20));//Core
		sheet.addMergedRegion(new CellRangeAddress(1,2,21,21));//MEM(GB)
		sheet.addMergedRegion(new CellRangeAddress(1,2,22,22));//스토리지(GB)

		sheet.addMergedRegion(new CellRangeAddress(0,0,23,29));//최빈시 자원 사용률(%) 평균
		sheet.addMergedRegion(new CellRangeAddress(1,1,23,24));//물리서버
		sheet.addMergedRegion(new CellRangeAddress(1,1,25,27));//가상서버
		sheet.addMergedRegion(new CellRangeAddress(1,1,28,29));//자동확장



		if(list==null){
			Row dataRow = sheet.createRow(3);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,29));
			list = new ArrayList<RsrcUseStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			RsrcUseStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(vo.getMm());
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
				Cell dataCell11 = dataRow.createCell(11);    dataCell11.setCellValue(DateUtil.stringValueOf(vo.getOpenshift()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
				Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getLastVSrvrQty()));
				Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));
				Cell dataCell17 = dataRow.createCell(17);	 dataCell17.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
				Cell dataCell18 = dataRow.createCell(18);	 dataCell18.setCellValue(DateUtil.stringValueOf(vo.getVmLastAsgnStrgCapa()));

				Cell dataCell19 = dataRow.createCell(19);	 dataCell19.setCellValue(DateUtil.stringValueOf(vo.getAutoLastServc()));
				Cell dataCell20 = dataRow.createCell(20);	 dataCell20.setCellValue(DateUtil.stringValueOf(vo.getAutoLastCoreQty()));
				Cell dataCell21 = dataRow.createCell(21);	 dataCell21.setCellValue(DateUtil.stringValueOf(vo.getAutoLastMemCapa()));
				Cell dataCell22 = dataRow.createCell(22);	 dataCell22.setCellValue(DateUtil.stringValueOf(vo.getAutoLastStrgCpa()));

				Cell dataCell23 = dataRow.createCell(23);	 dataCell23.setCellValue(DateUtil.stringValueOf(vo.getMaxCpuUseRt()));
				Cell dataCell24 = dataRow.createCell(24);	 dataCell24.setCellValue(DateUtil.stringValueOf(vo.getMaxMemUseRt()));
				Cell dataCell25 = dataRow.createCell(25);	 dataCell25.setCellValue(DateUtil.stringValueOf(vo.getVmMaxCpuUseRt()));
				Cell dataCell26 = dataRow.createCell(26);	 dataCell26.setCellValue(DateUtil.stringValueOf(vo.getVmMaxMemUseRt()));
				Cell dataCell27 = dataRow.createCell(27);	 dataCell27.setCellValue(DateUtil.stringValueOf(vo.getVmMaxStrgUseRt()));
				Cell dataCell28 = dataRow.createCell(28);	 dataCell28.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxCpuUseRt()));
				Cell dataCell29 = dataRow.createCell(29);	 dataCell29.setCellValue(DateUtil.stringValueOf(vo.getAutoMaxMemUseRt()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자원사용현황 - 기간별별").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }


}

