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
 * 2016. 10. 10   김동훈         v1.0             최초생성
 * 2017. 06. 10   양정순         v1.0             자동확장
 *
 */
package ncis.dsb.stts.res.web;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.res.service.JobResStteService;
import ncis.dsb.stts.res.vo.JobResSearchVo;
import ncis.dsb.stts.res.vo.JobResStteVo;
import ncis.dsb.stts.res.vo.JobVmStteVo;
import ncis.dsb.stts.res.vo.JobAxStteVo;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("JobResStteController")
@RequestMapping("/dsb/stts/res/jobResStte")
public class JobResStteController extends BaseController {


	@Resource(name="jobResStteService")
	JobResStteService jobResStteService;

	/**
	 * 업무자원현황 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobResStteList.do")
	public String selectJobResStteList( JobResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		List<JobResStteVo> list = null;
		List<JobVmStteVo> listVm = null;
		List<JobAxStteVo> listAx = null;
		if(searchVo.getSearchTrmCd()!=null){
			list = jobResStteService.selectJobResStteList(searchVo);
			listVm = jobResStteService.selectJobVmStteList(searchVo);
			listAx = jobResStteService.selectJobAxStteList(searchVo);

		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		model.addAttribute("list", list);
		model.addAttribute("listVm", listVm);
		model.addAttribute("listAx", listAx);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"selectJobResStteList");
	}

	/**
	 * 업무자원현황 시간대별 자원사용률 팝업
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	/*
	@RequestMapping(value="/selectJobTimeResUseRtP.do")
	public String selectJobTimeResUseRtP(
			JobResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<JobTimeResUseRtVo> cpuList = jobResStteService.selectJobTimeResUseRtCpu(searchVo);
		List<JobTimeResUseRtVo> memList = jobResStteService.selectJobTimeResUseRtMem(searchVo);
		List<JobTimeResUseRtVo> sanList = jobResStteService.selectJobTimeResUseRtSan(searchVo);

		model.addAttribute("cpuList",cpuList);
		model.addAttribute("memList",memList);
		model.addAttribute("sanList",sanList);
		model.addAttribute("title", "시간대별 자원사용률");

		return popup(request,"selectJobTimeResUseRtP");
	}
	*/
	@RequestMapping(value="/selectJobTimeResUseRtP.do")
	public String selectJobTimeResUseRtP(
			JobResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");

		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}


		List<Map<String,String>> vmList = jobResStteService.selectJobResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NET");
		List<Map<String,String>> netList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuList",cpuList);
		model.addAttribute("vmList",vmList);
		model.addAttribute("memList",memList);
		model.addAttribute("sanList",sanList);
		model.addAttribute("netList",netList);
		model.addAttribute("title", "자원사용률");


		return popup(request,"selectJobTimeResUseRtP");
	}

	@RequestMapping(value="/selectAxTimeResUseRtP.do")
	public String selectAxTimeResUseRtP(
			JobResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");

		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}

		if("MM".equals(searchVo.getSearchTrmCd()))
			searchVo.setLastDay(DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()), Integer.parseInt(searchVo.getSearchMmCd()))+"");
		List<Map<String,String>> podList = jobResStteService.selectAxResSttePodList(searchVo);

		searchVo.setPodList(podList);
		String graphNode="";
		if(podList.size() <= 0){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("pod_id",null);
			podList.add(map);
			graphNode = "emty";
		}
		searchVo.setColumn("CPU");

		List<Map<String,String>> cpuList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETIN");
		List<Map<String,String>> netInList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETOUT");
		List<Map<String,String>> netOutList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuList",cpuList);
		model.addAttribute("podList",podList);
		model.addAttribute("graphNode",graphNode);
		model.addAttribute("memList",memList);
		model.addAttribute("netInList",netInList);
		model.addAttribute("netOutList",netOutList);
		model.addAttribute("title", "업무별 시간대별 자원사용률");


		return popup(request,"selectAxTimeResUseRtP");
	}

	/**
	 * 업무자원현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectJobResStteListXlsDown.do")
	public void selectJobResStteListXlsDown( JobResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<JobResStteVo> list = null;
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		if(searchVo.getSearchTrmCd()!=null){
			list = jobResStteService.selectJobResStteList(searchVo);
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("업무자원현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "업무명" );					titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "가상서버수" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "가상서버수" );				titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "가상서버수" );				titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "가상서버수" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "가상서버수" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "자동확장수" );				titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "자동확장수" );				titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "O/S" );						titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "O/S" );						titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "O/S" );						titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "O/S" );						titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "O/S" );						titleCell13.setCellStyle(headerStyle);
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "O/S" );						titleCell14.setCellStyle(headerStyle);
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "WEB(할당량/사용률)" );		titleCell15.setCellStyle(headerStyle);/////
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "WEB(할당량/사용률)" );		titleCell16.setCellStyle(headerStyle);/////
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "WEB(할당량/사용률)" );		titleCell17.setCellStyle(headerStyle);
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "WEB(할당량/사용률)" );		titleCell18.setCellStyle(headerStyle);
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "WEB(할당량/사용률)" );		titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "WEB(할당량/사용률)" );		titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "WAS(할당량/사용률)" );		titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "WAS(할당량/사용률)" );		titleCell22.setCellStyle(headerStyle);
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "WAS(할당량/사용률)" );		titleCell23.setCellStyle(headerStyle);
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "WAS(할당량/사용률)" );		titleCell24.setCellStyle(headerStyle);
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "WAS(할당량/사용률)" );		titleCell25.setCellStyle(headerStyle);
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "WAS(할당량/사용률)" );		titleCell26.setCellStyle(headerStyle);
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "DB(할당량/사용률)" );		titleCell27.setCellStyle(headerStyle);
		Cell titleCell28 = row.createCell(27);	titleCell28.setCellValue( "DB(할당량/사용률)" );		titleCell28.setCellStyle(headerStyle);
		Cell titleCell29 = row.createCell(28);	titleCell29.setCellValue( "DB(할당량/사용률)" );		titleCell29.setCellStyle(headerStyle);
		Cell titleCell30 = row.createCell(29);	titleCell30.setCellValue( "DB(할당량/사용률)" );		titleCell30.setCellStyle(headerStyle);
		Cell titleCell31 = row.createCell(30);	titleCell31.setCellValue( "DB(할당량/사용률)" );		titleCell31.setCellStyle(headerStyle);
		Cell titleCell32 = row.createCell(31);	titleCell32.setCellValue( "DB(할당량/사용률)" );		titleCell32.setCellStyle(headerStyle);
		Cell titleCell33 = row.createCell(32);	titleCell33.setCellValue( "WIN(할당량/사용률)" );		titleCell33.setCellStyle(headerStyle);
		Cell titleCell34 = row.createCell(33);	titleCell34.setCellValue( "WIN(할당량/사용률)" );		titleCell34.setCellStyle(headerStyle);
		Cell titleCell35 = row.createCell(34);	titleCell35.setCellValue( "WIN(할당량/사용률)" );		titleCell35.setCellStyle(headerStyle);
		Cell titleCell36 = row.createCell(35);	titleCell36.setCellValue( "WIN(할당량/사용률)" );		titleCell36.setCellStyle(headerStyle);
		Cell titleCell37 = row.createCell(36);	titleCell37.setCellValue( "WIN(할당량/사용률)" );		titleCell37.setCellStyle(headerStyle);
		Cell titleCell38 = row.createCell(37);	titleCell38.setCellValue( "WIN(할당량/사용률)" );		titleCell38.setCellStyle(headerStyle);
		Cell titleCell39 = row.createCell(38);	titleCell39.setCellValue( "TEST(할당량/사용률)" );		titleCell39.setCellStyle(headerStyle);
		Cell titleCell40 = row.createCell(39);	titleCell40.setCellValue( "TEST(할당량/사용률)" );		titleCell40.setCellStyle(headerStyle);
		Cell titleCell41 = row.createCell(40);	titleCell41.setCellValue( "TEST(할당량/사용률)" );		titleCell41.setCellStyle(headerStyle);
		Cell titleCell42 = row.createCell(41);	titleCell42.setCellValue( "TEST(할당량/사용률)" );		titleCell42.setCellStyle(headerStyle);
		Cell titleCell43 = row.createCell(42);	titleCell43.setCellValue( "TEST(할당량/사용률)" );		titleCell43.setCellStyle(headerStyle);
		Cell titleCell44 = row.createCell(43);	titleCell44.setCellValue( "TEST(할당량/사용률)" );		titleCell44.setCellStyle(headerStyle);
		Cell titleCell45 = row.createCell(44);	titleCell45.setCellValue( "자동확장(할당량/사용률)" );		titleCell45.setCellStyle(headerStyle);
		Cell titleCell46 = row.createCell(45);	titleCell46.setCellValue( "자동확장(할당량/사용률)" );		titleCell46.setCellStyle(headerStyle);
		Cell titleCell47 = row.createCell(46);	titleCell47.setCellValue( "자동확장(할당량/사용률)" );		titleCell47.setCellStyle(headerStyle);
		Cell titleCell48 = row.createCell(47);	titleCell48.setCellValue( "자동확장(할당량/사용률)" );		titleCell48.setCellStyle(headerStyle);
		Cell titleCell49 = row.createCell(48);	titleCell49.setCellValue( "자동확장(할당량/사용률)" );		titleCell49.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "업무명" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "WEB" );						titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "WAS" );						titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "DB" );						titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "WIN" );						titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "TEST" );						titleCell6.setCellStyle(headerStyle);

		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "서비스수" );					titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "POD수" );						titleCell8.setCellStyle(headerStyle);

		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "LINUX" );						titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "HP-UX" );					titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "AIX" );						titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "WINDOWS" );					titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "SOLARIS" );					titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "ETC" );						titleCell14.setCellStyle(headerStyle);

		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "CPU(vCore)" );				titleCell15.setCellStyle(headerStyle);//
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "CPU 사용률(%)" );			titleCell16.setCellStyle(headerStyle);
		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "메모리(GB)" );				titleCell17.setCellStyle(headerStyle);
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "메모리 사용률(%)" );			titleCell18.setCellStyle(headerStyle);//
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "스토리지(TB)" );				titleCell19.setCellStyle(headerStyle);
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "스토리지 사용률(%)" );		titleCell20.setCellStyle(headerStyle);//

		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "CPU(vCore)" );				titleCell21.setCellStyle(headerStyle);//
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "CPU 사용률(%)" );			titleCell22.setCellStyle(headerStyle);
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "메모리(GB)" );				titleCell23.setCellStyle(headerStyle);
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "메모리 사용률(%)" );			titleCell24.setCellStyle(headerStyle);//
		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "스토리지(TB)" );				titleCell25.setCellStyle(headerStyle);
		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "스토리지 사용률(%)" );		titleCell26.setCellStyle(headerStyle);//

		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "CPU(vCore)" );				titleCell27.setCellStyle(headerStyle);//
		titleCell28 = row.createCell(27);		titleCell28.setCellValue( "CPU 사용률(%)" );			titleCell28.setCellStyle(headerStyle);
		titleCell29 = row.createCell(28);		titleCell29.setCellValue( "메모리(GB)" );				titleCell29.setCellStyle(headerStyle);
		titleCell30 = row.createCell(29);		titleCell30.setCellValue( "메모리 사용률(%)" );			titleCell30.setCellStyle(headerStyle);//
		titleCell31 = row.createCell(30);		titleCell31.setCellValue( "스토리지(TB)" );				titleCell31.setCellStyle(headerStyle);
		titleCell32 = row.createCell(31);		titleCell32.setCellValue( "스토리지 사용률(%)" );		titleCell32.setCellStyle(headerStyle);//

		titleCell33 = row.createCell(32);		titleCell33.setCellValue( "CPU(vCore)" );				titleCell33.setCellStyle(headerStyle);//
		titleCell34 = row.createCell(33);		titleCell34.setCellValue( "CPU 사용률(%)" );			titleCell34.setCellStyle(headerStyle);
		titleCell35 = row.createCell(34);		titleCell35.setCellValue( "메모리(GB)" );				titleCell35.setCellStyle(headerStyle);
		titleCell36 = row.createCell(35);		titleCell36.setCellValue( "메모리 사용률(%)" );			titleCell36.setCellStyle(headerStyle);//
		titleCell37 = row.createCell(36);		titleCell37.setCellValue( "스토리지(TB)" );				titleCell37.setCellStyle(headerStyle);
		titleCell38 = row.createCell(37);		titleCell38.setCellValue( "스토리지 사용률(%)" );		titleCell38.setCellStyle(headerStyle);//

		titleCell39 = row.createCell(38);		titleCell39.setCellValue( "CPU(vCore)" );				titleCell39.setCellStyle(headerStyle);//
		titleCell40 = row.createCell(39);		titleCell40.setCellValue( "CPU 사용률(%)" );			titleCell40.setCellStyle(headerStyle);
		titleCell41 = row.createCell(40);		titleCell41.setCellValue( "메모리(GB)" );				titleCell41.setCellStyle(headerStyle);
		titleCell42 = row.createCell(41);		titleCell42.setCellValue( "메모리 사용률(%)" );			titleCell42.setCellStyle(headerStyle);//
		titleCell43 = row.createCell(42);		titleCell43.setCellValue( "스토리지(TB)" );				titleCell43.setCellStyle(headerStyle);
		titleCell44 = row.createCell(43);		titleCell44.setCellValue( "스토리지 사용률(%)" );		titleCell44.setCellStyle(headerStyle);//

		titleCell45 = row.createCell(44);		titleCell45.setCellValue( "CPU(Core)" );				titleCell45.setCellStyle(headerStyle);//
		titleCell46 = row.createCell(45);		titleCell46.setCellValue( "CPU 사용률(%)" );			titleCell46.setCellStyle(headerStyle);
		titleCell47 = row.createCell(46);		titleCell47.setCellValue( "메모리(GB)" );				titleCell47.setCellStyle(headerStyle);
		titleCell48 = row.createCell(47);		titleCell48.setCellValue( "메모리 사용률(%)" );			titleCell48.setCellStyle(headerStyle);//
		titleCell49 = row.createCell(48);		titleCell49.setCellValue( "스토리지(GB)" );				titleCell49.setCellStyle(headerStyle);


		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,5));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,6,7));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,13));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,14,19));//web
		sheet.addMergedRegion(new CellRangeAddress(0,0,20,25));//클러스터
		sheet.addMergedRegion(new CellRangeAddress(0,0,26,31));//물리서버명
		sheet.addMergedRegion(new CellRangeAddress(0,0,32,37));
		sheet.addMergedRegion(new CellRangeAddress(0,0,38,43));//물리서버구성ID
		sheet.addMergedRegion(new CellRangeAddress(0,0,44,48));//물리서버구성ID

		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,42));
			list = new ArrayList<JobResStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			JobResStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
			Cell dataCell0 = dataRow.createCell(0);		dataCell0.setCellValue(vo.getJobNm() );
			Cell dataCell1 = dataRow.createCell(1);		dataCell1.setCellValue(DateUtil.stringValueOf(vo.getWeb()));
			Cell dataCell2 = dataRow.createCell(2);		dataCell2.setCellValue(DateUtil.stringValueOf(vo.getWas()));
			Cell dataCell3 = dataRow.createCell(3);		dataCell3.setCellValue(DateUtil.stringValueOf(vo.getDb()));
			Cell dataCell4 = dataRow.createCell(4);		dataCell4.setCellValue(DateUtil.stringValueOf(vo.getWin()));
			Cell dataCell5 = dataRow.createCell(5);		dataCell5.setCellValue(DateUtil.stringValueOf(vo.getTest()));
			Cell dataCell6 = dataRow.createCell(6);		dataCell6.setCellValue(DateUtil.stringValueOf(vo.getServcCnt()));
			Cell dataCell7 = dataRow.createCell(7);		dataCell7.setCellValue(DateUtil.stringValueOf(vo.getPodQty()));
			Cell dataCell8 = dataRow.createCell(8);		dataCell8.setCellValue(DateUtil.stringValueOf(vo.getOsLinux()));
			Cell dataCell9 = dataRow.createCell(9);		dataCell9.setCellValue(DateUtil.stringValueOf(vo.getOsHp()));
			Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(vo.getOsAix()));
			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getOsWin()));
			Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getOsSolaris()));
			Cell dataCell13 = dataRow.createCell(13); 	dataCell13.setCellValue(DateUtil.stringValueOf(vo.getOsEtc()));

			Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vo.getWebVcore()));
			Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vo.getWebCpuRt()));
			Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vo.getWebMem()));
			Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vo.getWebMemRt()));
			Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(DateUtil.stringValueOf(vo.getWebStrg()));
			Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(DateUtil.stringValueOf(vo.getWebStrgRt()));

			Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(DateUtil.stringValueOf(vo.getWasVcore()));
			Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(DateUtil.stringValueOf(vo.getWasCpuRt()));
			Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(DateUtil.stringValueOf(vo.getWasMem()));
			Cell dataCell23 = dataRow.createCell(23);	dataCell23.setCellValue(DateUtil.stringValueOf(vo.getWasMemRt()));
			Cell dataCell24 = dataRow.createCell(24);	dataCell24.setCellValue(DateUtil.stringValueOf(vo.getWasStrg()));
			Cell dataCell25 = dataRow.createCell(25);	dataCell25.setCellValue(DateUtil.stringValueOf(vo.getWasStrgRt()));

			Cell dataCell26 = dataRow.createCell(26);	dataCell26.setCellValue(DateUtil.stringValueOf(vo.getDbVcore()));
			Cell dataCell27 = dataRow.createCell(27);	dataCell27.setCellValue(DateUtil.stringValueOf(vo.getDbCpuRt()));
			Cell dataCell28 = dataRow.createCell(28);	dataCell28.setCellValue(DateUtil.stringValueOf(vo.getDbMem()));
			Cell dataCell29 = dataRow.createCell(29);	dataCell29.setCellValue(DateUtil.stringValueOf(vo.getDbMemRt()));
			Cell dataCell30 = dataRow.createCell(30);	dataCell30.setCellValue(DateUtil.stringValueOf(vo.getDbStrg()));
			Cell dataCell31 = dataRow.createCell(31);	dataCell31.setCellValue(DateUtil.stringValueOf(vo.getDbStrgRt()));

			Cell dataCell32 = dataRow.createCell(32);	dataCell32.setCellValue(DateUtil.stringValueOf(vo.getWinVcore()));
			Cell dataCell33 = dataRow.createCell(33);	dataCell33.setCellValue(DateUtil.stringValueOf(vo.getWinCpuRt()));
			Cell dataCell34 = dataRow.createCell(34);	dataCell34.setCellValue(DateUtil.stringValueOf(vo.getWinMem()));
			Cell dataCell35 = dataRow.createCell(35);	dataCell35.setCellValue(DateUtil.stringValueOf(vo.getWinMemRt()));
			Cell dataCell36 = dataRow.createCell(36);	dataCell36.setCellValue(DateUtil.stringValueOf(vo.getWinStrg()));
			Cell dataCell37 = dataRow.createCell(37);	dataCell37.setCellValue(DateUtil.stringValueOf(vo.getWinStrgRt()));


			Cell dataCell38 = dataRow.createCell(38);	dataCell38.setCellValue(DateUtil.stringValueOf(vo.getTestVcore()));
			Cell dataCell39 = dataRow.createCell(39);	dataCell39.setCellValue(DateUtil.stringValueOf(vo.getTestCpuRt()));
			Cell dataCell40 = dataRow.createCell(40);	dataCell40.setCellValue(DateUtil.stringValueOf(vo.getTestMem()));
			Cell dataCell41 = dataRow.createCell(41);	dataCell41.setCellValue(DateUtil.stringValueOf(vo.getTestMemRt()));
			Cell dataCell42 = dataRow.createCell(42);	dataCell42.setCellValue(DateUtil.stringValueOf(vo.getTestStrg()));
			Cell dataCell43 = dataRow.createCell(43);	dataCell43.setCellValue(DateUtil.stringValueOf(vo.getTestStrgRt()));

			Cell dataCell44 = dataRow.createCell(44);	dataCell44.setCellValue(DateUtil.stringValueOf(vo.getCpuCorQty()));
			Cell dataCell45 = dataRow.createCell(45);	dataCell45.setCellValue(DateUtil.stringValueOf(vo.getAvgCpuUseRt()));
			Cell dataCell46 = dataRow.createCell(46);	dataCell46.setCellValue(DateUtil.stringValueOf(vo.getMemTotCapa()));
			Cell dataCell47 = dataRow.createCell(47);	dataCell47.setCellValue(DateUtil.stringValueOf(vo.getAvgMemUseRt()));
			Cell dataCell48 = dataRow.createCell(48);	dataCell48.setCellValue(DateUtil.stringValueOf(vo.getStrgTotCapa()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("업무자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}

	/**
	 * 업무가상서버현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectVmResStteListXlsDown.do")
	public void selectVmResStteListXlsDown( JobResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<JobVmStteVo> list = null;
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		if(searchVo.getSearchTrmCd()!=null){
			list = jobResStteService.selectJobVmStteList(searchVo);
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("업무가상서버현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "부처명" );				titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "업무명" );				titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "가상서버수" );			titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "업무별평균사용율" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "업무별평균사용율" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "업무별평균사용율" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "용도" );					titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "용도별 평균 사용률" );	titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "용도별 평균 사용률" );	titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "용도별 평균 사용률" );	titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "용도별 평균 사용률" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "용도별 평균 사용률" );	titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "용도별 평균 사용률" );	titleCell13.setCellStyle(headerStyle);/////

		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "업무사용률" );			titleCell14.setCellStyle(headerStyle);
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "업무사용률" );			titleCell15.setCellStyle(headerStyle);
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "업무사용률" );			titleCell16.setCellStyle(headerStyle);
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "업무사용률" );			titleCell17.setCellStyle(headerStyle);
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "업무사용률" );			titleCell18.setCellStyle(headerStyle);
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "업무사용률" );			titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "업무사용률" );			titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "업무사용률" );			titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "업무사용률" );			titleCell22.setCellStyle(headerStyle);
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "업무사용률" );			titleCell23.setCellStyle(headerStyle);
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "업무사용률" );			titleCell24.setCellStyle(headerStyle);
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "센터" );					titleCell25.setCellStyle(headerStyle);
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "Zone" );					titleCell26.setCellStyle(headerStyle);
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "망" );					titleCell27.setCellStyle(headerStyle);
		Cell titleCell28 = row.createCell(27);	titleCell28.setCellValue( "자원풀명" );				titleCell28.setCellStyle(headerStyle);
		Cell titleCell29 = row.createCell(28);	titleCell29.setCellValue( "자원풀용도" );			titleCell29.setCellStyle(headerStyle);
		Cell titleCell30 = row.createCell(29);	titleCell30.setCellValue( "물리서버명" );			titleCell30.setCellStyle(headerStyle);
		Cell titleCell31 = row.createCell(30);	titleCell31.setCellValue( "구성ID" );				titleCell31.setCellStyle(headerStyle);


		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "부처명" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "업무명" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "가상서버수" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "CPU" );					titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "메모리" );				titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "스토리지" );				titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "용도" );					titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "CPU(vCore)" );			titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "CPU 사용률(%)" );			titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "메모리(GB)" );			titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "메모리 사용률(%)" );		titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "스토리지(TB)" );			titleCell12.setCellStyle(headerStyle);//
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "스토리지 사용률(%)" );	titleCell13.setCellStyle(headerStyle);

		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "가상서버명" );			titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "구성ID" );				titleCell15.setCellStyle(headerStyle);//
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "호스트명" );				titleCell16.setCellStyle(headerStyle);

		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "CPU(vCore)" );			titleCell17.setCellStyle(headerStyle);//
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "CPU 사용률(%)" );		titleCell18.setCellStyle(headerStyle);//
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "메모리(GB)" );			titleCell19.setCellStyle(headerStyle);
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "메모리 사용률(%)" );		titleCell20.setCellStyle(headerStyle);
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "스토리지(TB)" );			titleCell21.setCellStyle(headerStyle);
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "스토리지 사용률(%)" );	titleCell22.setCellStyle(headerStyle);//

		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "네트워크(In)(KB/s)" );	titleCell23.setCellStyle(headerStyle);//
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "네트워크(Out)(KB/s)" );	titleCell24.setCellStyle(headerStyle);

		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "센터" );					titleCell25.setCellStyle(headerStyle);
		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "Zone" );					titleCell26.setCellStyle(headerStyle);//
		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "망" );					titleCell27.setCellStyle(headerStyle);
		titleCell28 = row.createCell(27);		titleCell28.setCellValue( "자원풀명" );				titleCell28.setCellStyle(headerStyle);//

		titleCell29 = row.createCell(28);		titleCell29.setCellValue( "자원풀용도" );			titleCell29.setCellStyle(headerStyle);//
		titleCell30 = row.createCell(29);		titleCell30.setCellValue( "물리서버명" );			titleCell30.setCellStyle(headerStyle);
		titleCell31 = row.createCell(30);		titleCell31.setCellValue( "구성ID" );				titleCell31.setCellStyle(headerStyle);



		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));//
		sheet.addMergedRegion(new CellRangeAddress(0,1,2,2));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,5));//업무별평균사용율
		sheet.addMergedRegion(new CellRangeAddress(0,1,6,6));//용도
		sheet.addMergedRegion(new CellRangeAddress(0,0,7,12));//
		sheet.addMergedRegion(new CellRangeAddress(0,0,13,23));
		sheet.addMergedRegion(new CellRangeAddress(0,1,24,24));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,1,25,25));//
		sheet.addMergedRegion(new CellRangeAddress(0,1,26,26));//
		sheet.addMergedRegion(new CellRangeAddress(0,1,27,27));//자원풀
		sheet.addMergedRegion(new CellRangeAddress(0,1,28,28));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,1,29,29));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,1,30,30));//센터


		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,30));
			list = new ArrayList<JobVmStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			JobVmStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
			Cell dataCell0 = dataRow.createCell(0);	dataCell0.setCellValue(vo.getInstitutionNm());
			Cell dataCell1 = dataRow.createCell(1);	dataCell1.setCellValue(vo.getJobNm());
			Cell dataCell2 = dataRow.createCell(2);	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getVmCnt()));
			Cell dataCell3 = dataRow.createCell(3);	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getJobAvgCpuUseRt()));
			Cell dataCell4 = dataRow.createCell(4);	  dataCell4.setCellValue(DateUtil.stringValueOf(vo.getJobAvgMemUseRt()));
			Cell dataCell5 = dataRow.createCell(5);	  dataCell5.setCellValue(DateUtil.stringValueOf(vo.getJobAvgStrgUseRt()));
			Cell dataCell6 = dataRow.createCell(6);	  dataCell6.setCellValue(DateUtil.stringValueOf(vo.getCdNm()));
			Cell dataCell7 = dataRow.createCell(7);	  dataCell7.setCellValue(DateUtil.stringValueOf(vo.getCdLastVcoreQty()));
			Cell dataCell8 = dataRow.createCell(8);	  dataCell8.setCellValue(DateUtil.stringValueOf(vo.getCdAvgCpuUseRt()));
			Cell dataCell9 = dataRow.createCell(9);	  dataCell9.setCellValue(DateUtil.stringValueOf(vo.getCdLastMemSumCapa()));
			Cell dataCell10 = dataRow.createCell(10); dataCell10.setCellValue(DateUtil.stringValueOf(vo.getCdAvgMemUseRt()));

			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getCdLastStrgSumCapa()));
			Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getCdAvgStrgUseRt()));
			Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(DateUtil.stringValueOf(vo.getVmNm()));
			Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vo.getVmCompId()));
			Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vo.getHstNm()));
			Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vo.getLastVcoreQty()));

			Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vo.getAvgCpuUseRt()));
			Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
			Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(DateUtil.stringValueOf(vo.getAvgMemUseRt()));
			Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(DateUtil.stringValueOf(vo.getLastStrgSumCapa()));
			Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(DateUtil.stringValueOf(vo.getAvgStrgUseRt()));
			Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(DateUtil.stringValueOf(vo.getAvgInTrfic()));

			Cell dataCell23 = dataRow.createCell(23);	dataCell23.setCellValue(DateUtil.stringValueOf(vo.getAvgOutTrfic()));
			Cell dataCell24 = dataRow.createCell(24);	dataCell24.setCellValue(DateUtil.stringValueOf(vo.getRegionNm()));
			Cell dataCell25 = dataRow.createCell(25);	dataCell25.setCellValue(DateUtil.stringValueOf(vo.getZoneNm()));
			Cell dataCell26 = dataRow.createCell(26);	dataCell26.setCellValue(DateUtil.stringValueOf(vo.getNetNm()));
			Cell dataCell27 = dataRow.createCell(27);	dataCell27.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
			Cell dataCell28 = dataRow.createCell(28);	dataCell28.setCellValue(DateUtil.stringValueOf(vo.getClstrNm()));

			Cell dataCell29 = dataRow.createCell(29);	dataCell29.setCellValue(DateUtil.stringValueOf(vo.getPmNm()));
			Cell dataCell30 = dataRow.createCell(30);	dataCell30.setCellValue(DateUtil.stringValueOf(vo.getPmCompId()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("업무가상서버현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}

	/**
	 * 자동확장 서비스 현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectAxResStteListXlsDown.do")
	public void selectAxResStteListXlsDown( JobResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<JobAxStteVo> list = null;
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		if(searchVo.getSearchTrmCd()!=null){
			list = jobResStteService.selectJobAxStteList(searchVo);
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자동확장 서비스 현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "부처명" );						titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "서비스명" );						titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "POD수" );							titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "서비스별할당량/평균사용율" );		titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "서비스별할당량/평균사용율" );		titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "서비스별할당량/평균사용율" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "서비스별할당량/평균사용율" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "서비스별할당량/평균사용율" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "서비스별할당량/평균사용율" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "서비스별할당량/평균사용율" );	titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "POD할당량/평균사용률" );			titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "POD할당량/평균사용률" );			titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "POD할당량/평균사용률" );			titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "POD할당량/평균사용률" );			titleCell14.setCellStyle(headerStyle);
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "POD할당량/평균사용률" );			titleCell15.setCellStyle(headerStyle);
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "POD할당량/평균사용률" );			titleCell16.setCellStyle(headerStyle);
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "POD할당량/평균사용률" );			titleCell17.setCellStyle(headerStyle);
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "POD할당량/평균사용률" );			titleCell18.setCellStyle(headerStyle);

		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "센터" );							titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "존" );							titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell21.setCellValue( "망" );							titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "자원풀명" );						titleCell22.setCellStyle(headerStyle);
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "서비스노드명" );					titleCell23.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "부처명" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "서비스명" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "POD수" );					titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "CPU" );					titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "CPU 사용률(%)" );			titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "메모리(GB)" );			titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "메모리 사용률(%)" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "스토리지(GB)" );			titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "네트워크(In/Out)" );		titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "네트워크(In/Out)" );		titleCell10.setCellStyle(headerStyle);

		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "CPU(Core)" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "CPU 사용률(%)" );		titleCell12.setCellStyle(headerStyle);//
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "메모리(GB)" );			titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "메모리 사용률(%)" );		titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "스토리지(GB)" );			titleCell15.setCellStyle(headerStyle);//
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "네트워크(In/Out)" );		titleCell16.setCellStyle(headerStyle);
		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "네트워크(In/Out)" );		titleCell17.setCellStyle(headerStyle);//
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "POD명" );				titleCell18.setCellStyle(headerStyle);//

		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "센터" );					titleCell19.setCellStyle(headerStyle);
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "존" );					titleCell20.setCellStyle(headerStyle);
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "망" );					titleCell21.setCellStyle(headerStyle);//
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "자원풀명" );				titleCell22.setCellStyle(headerStyle);//
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "서비스노드명" );			titleCell23.setCellStyle(headerStyle);


		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "부처명" );				titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "서비스명" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "POD수" );					titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "CPU" );					titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "CPU 사용률(%)" );			titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "메모리(GB)" );			titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "메모리 사용률(%)" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "스토리지(GB)" );			titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "In(KB/s)" );				titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "Out(KB/s)" );			titleCell10.setCellStyle(headerStyle);

		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "CPU(Core)" );			titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "CPU 사용률(%)" );		titleCell12.setCellStyle(headerStyle);//
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "메모리(GB)" );			titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "메모리 사용률(%)" );		titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "스토리지(GB)" );			titleCell15.setCellStyle(headerStyle);//
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "In(KB/s)" );				titleCell16.setCellStyle(headerStyle);
		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "Out(KB/s)" );			titleCell17.setCellStyle(headerStyle);//
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "POD명" );				titleCell18.setCellStyle(headerStyle);//

		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "센터" );					titleCell19.setCellStyle(headerStyle);
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "존" );					titleCell20.setCellStyle(headerStyle);
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "망" );					titleCell21.setCellStyle(headerStyle);//
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "자원풀명" );				titleCell22.setCellStyle(headerStyle);//
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "서비스노드명" );			titleCell23.setCellStyle(headerStyle);


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//부처명
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//서비스명
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//POD수
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,9));//업무별평균사용율
		sheet.addMergedRegion(new CellRangeAddress(1,2,3,3));// cpu
		sheet.addMergedRegion(new CellRangeAddress(1,2,4,4));// CPU 사용률
		sheet.addMergedRegion(new CellRangeAddress(1,2,5,5));// 메모리
		sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));// 메모리사용률
		sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));// 스토리지
		sheet.addMergedRegion(new CellRangeAddress(1,1,8,9));// in
		sheet.addMergedRegion(new CellRangeAddress(0,0,10,17));//POD할달량/평균사용률
		sheet.addMergedRegion(new CellRangeAddress(1,2,10,10));//cpu
		sheet.addMergedRegion(new CellRangeAddress(1,2,11,11));// CPU 사용률
		sheet.addMergedRegion(new CellRangeAddress(1,2,12,12));// 메모리
		sheet.addMergedRegion(new CellRangeAddress(1,2,13,13));// 메모리사용률
		sheet.addMergedRegion(new CellRangeAddress(1,2,14,14));// 스토리지
		sheet.addMergedRegion(new CellRangeAddress(1,1,15,16));// in
		sheet.addMergedRegion(new CellRangeAddress(1,2,17,17));// pod명

		sheet.addMergedRegion(new CellRangeAddress(0,2,18,18));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,2,19,19));//존
		sheet.addMergedRegion(new CellRangeAddress(0,2,20,20));//망
		sheet.addMergedRegion(new CellRangeAddress(0,2,21,21));//자원풀
		sheet.addMergedRegion(new CellRangeAddress(0,2,22,22));//서비스노드명


		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,30));
			list = new ArrayList<JobAxStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			JobAxStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);
			Cell dataCell0 = dataRow.createCell(0);	dataCell0.setCellValue(vo.getInstitutionNm());
			Cell dataCell1 = dataRow.createCell(1);	dataCell1.setCellValue(vo.getServcNm());
			Cell dataCell2 = dataRow.createCell(2);	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getPodQty()));
			Cell dataCell3 = dataRow.createCell(3);	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getServcCpuCorQty()));
			Cell dataCell4 = dataRow.createCell(4);	  dataCell4.setCellValue(DateUtil.stringValueOf(vo.getServcAvgCpuUseRt()));
			Cell dataCell5 = dataRow.createCell(5);	  dataCell5.setCellValue(DateUtil.stringValueOf(vo.getServcMemTotCapa()));
			Cell dataCell6 = dataRow.createCell(6);	  dataCell6.setCellValue(DateUtil.stringValueOf(vo.getServcAvgMemUseRt()));
			Cell dataCell7 = dataRow.createCell(7);	  dataCell7.setCellValue(DateUtil.stringValueOf(vo.getServcStrgTotCapa()));
			Cell dataCell8 = dataRow.createCell(8);	  dataCell8.setCellValue(DateUtil.stringValueOf(vo.getServcAvgInTrfic()));
			Cell dataCell9 = dataRow.createCell(9);	  dataCell9.setCellValue(DateUtil.stringValueOf(vo.getServcAvgOutTrfic()));
			Cell dataCell10 = dataRow.createCell(10); dataCell10.setCellValue(DateUtil.stringValueOf(vo.getPodCpuCorQty()));

			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getPodAvgCpuUseRt()));
			Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getPodMemTotCapa()));
			Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(DateUtil.stringValueOf(vo.getPodAvgMemUseRt()));
			Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vo.getPodStrgTotCapa()));
			Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vo.getPodAvgInTrfic()));
			Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vo.getPodAvgOutTrfic()));
			Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vo.getPodNm()));
			Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(DateUtil.stringValueOf(vo.getRegionNm()));
			Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(DateUtil.stringValueOf(vo.getZoneNm()));
			Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(DateUtil.stringValueOf(vo.getNetNm()));
			Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
			Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(DateUtil.stringValueOf(vo.getAtmsclNodeNm()));


		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자동확장 서비스 현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}
	private String getObject2String(Object o){
		if(o==null){
			return "";
		}
		return o.toString();
	}
	/**
	 * 업무별 시간대별 자원사용률 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobTimeResUseRtPXlsDown.do")
	public void selectJobTimeResUseRtPXlsDown( JobResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{
		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");

		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}


		List<Map<String,String>> vmList = jobResStteService.selectJobResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NET");
		List<Map<String,String>> netList = jobResStteService.selectJobTimeResUseRtPivot(searchVo);

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("dt", "기간");


        Workbook workBook = new XSSFWorkbook();
		Sheet cpuSheet = workBook.createSheet("CPU 자원사용률");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);
        /** TITLE start*/
		Row cpuRow = cpuSheet.createRow(0);

		Cell cpuTitleCell1 = cpuRow.createCell(0);
		     cpuTitleCell1.setCellValue( "기간" );
		     cpuTitleCell1.setCellStyle(headerStyle);
		int num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell cpuTitleCell = cpuRow.createCell(num++);
        	     cpuTitleCell.setCellValue( vmMap.get("vm_comp_id"));
        	     cpuTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<cpuList.size(); i++){
			num=0;
			Map<String, String> cpuMap = cpuList.get(i);
			Row cpuDataRow = cpuSheet.createRow(1+i);
			Cell cpuDataCell = cpuDataRow.createCell(num++);
			     cpuDataCell.setCellValue(cpuMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell cpuDataCell1 = cpuDataRow.createCell(num++);
				cpuDataCell1.setCellValue(getObject2String(cpuMap.get( getObject2String(vmMap.get("vm_seq")))));
			}

		}
		/** DATA end*/

		/** TITLE start*/
		Sheet memSheet = workBook.createSheet("MEM 자원사용률");


		Row memRow = memSheet.createRow(0);

		Cell memTitleCell1 = memRow.createCell(0);	memTitleCell1.setCellValue( "기간" );
		     memTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell memTitleCell = memRow.createCell(num++);
        	memTitleCell.setCellValue( vmMap.get("vm_comp_id"));
        	memTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<memList.size(); i++){
			num=0;
			Map<String,String> memMap = memList.get(i);
			Row memDataRow = memSheet.createRow(1+i);
			Cell memDataCell = memDataRow.createCell(num++);
			     memDataCell.setCellValue(memMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell memDataCell1 = memDataRow.createCell(num++);
				     memDataCell1.setCellValue(getObject2String(memMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet sanSheet = workBook.createSheet("SAN 자원사용률");


		Row sanRow = sanSheet.createRow(0);

		Cell sanTitleCell1 = sanRow.createCell(0);
		     sanTitleCell1.setCellValue( "기간" );
		     sanTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell sanTitleCell = sanRow.createCell(num++);
        	     sanTitleCell.setCellValue( vmMap.get("vm_comp_id"));
        	     sanTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<sanList.size(); i++){
			num=0;
			Map<String,String> sanMap = sanList.get(i);
			Row sanDataRow = sanSheet.createRow(1+i);
			Cell sanDataCell = sanDataRow.createCell(num++);
			     sanDataCell.setCellValue(sanMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell sanDataCell1 = sanDataRow.createCell(num++);
				     sanDataCell1.setCellValue(getObject2String(sanMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet netSheet = workBook.createSheet("네트워크 자원사용률");


		Row netRow = netSheet.createRow(0);

		Cell netTitleCell1 = netRow.createCell(0);
		     netTitleCell1.setCellValue( "기간" );
		     netTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell netTitleCell = netRow.createCell(num++);
        	     netTitleCell.setCellValue( vmMap.get("vm_comp_id"));
        	     netTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<netList.size(); i++){
			num=0;
			Map<String,String> netMap = netList.get(i);
			Row netDataRow = netSheet.createRow(1+i);
			Cell netDataCell = netDataRow.createCell(num++);
			     netDataCell.setCellValue(netMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell netDataCell1 = netDataRow.createCell(num++);
				     netDataCell1.setCellValue(getObject2String(netMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("업무별자원사용률").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}

	/**
	 * 자동확장 시간대별 자원사용률 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxTimeResUseRtPXlsDown.do")
	public void selectAxTimeResUseRtPXlsDown( JobResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{
		if("DD".equals(searchVo.getSearchTrmCd()) && StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("HH");

		}else if("MM".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}else if("QQ".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("HH".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("YY".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("MM");
		}else if("DI".equals(searchVo.getSearchTrmCd())&& StringUtils.isEmpty(searchVo.getColctCd())){
			searchVo.setColctCd("DD");
		}

		if("MM".equals(searchVo.getSearchTrmCd()))
			searchVo.setLastDay(DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()), Integer.parseInt(searchVo.getSearchMmCd()))+"");

		List<Map<String,String>> podList = jobResStteService.selectAxResSttePodList(searchVo);
		searchVo.setPodList(podList);

		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETIN");
		List<Map<String,String>> netInList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETOUT");
		List<Map<String,String>> netOutList = jobResStteService.selectAxTimeResUseRtPivot(searchVo);

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("dt", "기간");


        Workbook workBook = new XSSFWorkbook();
		Sheet cpuSheet = workBook.createSheet("CPU 자원사용률");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);
        /** TITLE start*/
		Row cpuRow = cpuSheet.createRow(0);

		Cell cpuTitleCell1 = cpuRow.createCell(0);
		     cpuTitleCell1.setCellValue( "기간" );
		     cpuTitleCell1.setCellStyle(headerStyle);
		int num=1;
		for(Map<String,String> podMap: podList){
        	Cell cpuTitleCell = cpuRow.createCell(num++);
        	     cpuTitleCell.setCellValue( podMap.get("pod_nm"));
        	     cpuTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<cpuList.size(); i++){
			num=0;
			Map<String, String> cpuMap = cpuList.get(i);
			Row cpuDataRow = cpuSheet.createRow(1+i);
			Cell cpuDataCell = cpuDataRow.createCell(num++);
			     cpuDataCell.setCellValue(cpuMap.get("dt"));
			for(Map<String, String> podMap: podList){
				Cell cpuDataCell1 = cpuDataRow.createCell(num++);
				cpuDataCell1.setCellValue(getObject2String(cpuMap.get( getObject2String(podMap.get("pod_id")))));
			}

		}
		/** DATA end*/

		/** TITLE start*/
		Sheet memSheet = workBook.createSheet("MEM 자원사용률");


		Row memRow = memSheet.createRow(0);

		Cell memTitleCell1 = memRow.createCell(0);	memTitleCell1.setCellValue( "기간" );
		     memTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> podMap: podList){
        	Cell memTitleCell = memRow.createCell(num++);
        	memTitleCell.setCellValue( podMap.get("pod_nm"));
        	memTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<memList.size(); i++){
			num=0;
			Map<String,String> memMap = memList.get(i);
			Row memDataRow = memSheet.createRow(1+i);
			Cell memDataCell = memDataRow.createCell(num++);
			     memDataCell.setCellValue(memMap.get("dt"));
			for(Map<String, String> podMap: podList){
				Cell memDataCell1 = memDataRow.createCell(num++);
				     memDataCell1.setCellValue(getObject2String(memMap.get(getObject2String(podMap.get("pod_id")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet netInSheet = workBook.createSheet("네트워크 IN");


		Row netInRow = netInSheet.createRow(0);

		Cell netInTitleCell1 = netInRow.createCell(0);
			 netInTitleCell1.setCellValue( "기간" );
			 netInTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> podMap: podList){
        	Cell netInTitleCell = netInRow.createCell(num++);
        	     netInTitleCell.setCellValue( podMap.get("pod_nm"));
        	     netInTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<netInList.size(); i++){
			num=0;
			Map<String,String> netInMap = netInList.get(i);
			Row netInDataRow = netInSheet.createRow(1+i);
			Cell netInDataCell = netInDataRow.createCell(num++);
			     netInDataCell.setCellValue(netInMap.get("dt"));
			for(Map<String, String> podMap: podList){
				Cell netInDataCell1 = netInDataRow.createCell(num++);
				     netInDataCell1.setCellValue(getObject2String(netInMap.get(getObject2String(podMap.get("pod_id")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet netOutSheet = workBook.createSheet("네트워크 Out");


		Row netOutRow = netOutSheet.createRow(0);

		Cell netOutTitleCell1 = netOutRow.createCell(0);
		     netOutTitleCell1.setCellValue( "기간" );
		     netOutTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> podMap: podList){
        	Cell netOutTitleCell = netOutRow.createCell(num++);
        	     netOutTitleCell.setCellValue( podMap.get("pod_nm"));
        	     netOutTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<netOutList.size(); i++){
			num=0;
			Map<String,String> netOutMap = netOutList.get(i);
			Row netOutDataRow = netOutSheet.createRow(1+i);
			Cell netOutDataCell = netOutDataRow.createCell(num++);
			     netOutDataCell.setCellValue(netOutMap.get("dt"));
			for(Map<String, String> podMap: podList){
				Cell netOutDataCell1 = netOutDataRow.createCell(num++);
				     netOutDataCell1.setCellValue(getObject2String(netOutMap.get(getObject2String(podMap.get("pod_id")))));
			}
		}
		/** DATA end*/


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자동확장 서비스별 시간대별 자원사용률").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}
}
