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
package ncis.dsb.stts.res.web;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.res.service.PmResStteService;
import ncis.dsb.stts.res.vo.PmResSearchVo;
import ncis.dsb.stts.res.vo.PmResStteVo;

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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("pmResStteController")
@RequestMapping("/dsb/stts/res/pmResStte")
public class PmResStteController extends BaseController {


	@Resource(name="pmResStteService")
	PmResStteService pmResStteService;

	/**
	 * 물리서버자원현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPmResStteList.do")
	public String selectPmResStteList( PmResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<PmResStteVo> list = null;
		if(searchVo.getSearchTrmCd()!=null){
			list = pmResStteService.selectPmResStteList(searchVo);

		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}

		if(list!=null && list.size()>0){
			searchVo.getPaginationInfo().setTotalRecordCount(list.get(0).getCnt());	// 페이지 처리위한 count
		}
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"selectPmResStteList");
	}
	/**
	 * 가상서버 시간대별 자원사용률 팝업
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	/*//20161124 시간대별/10분별/일자별로 조회가능하도록 요청에 의해 백업
	 * @RequestMapping(value="/selectPmTimeResUseRtP.do")
	public String selectPmTimeResUseRtP(
			PmResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{
		List<PmTimeResUseRtVo> cpuList = pmResStteService.selectPmTimeResUseRtCpu(searchVo);
		List<PmTimeResUseRtVo> memList = pmResStteService.selectPmTimeResUseRtMem(searchVo);
		List<PmTimeResUseRtVo> sanList = pmResStteService.selectPmTimeResUseRtSan(searchVo);

		model.addAttribute("cpuList",cpuList);
		model.addAttribute("memList",memList);
		model.addAttribute("sanList",sanList);
		model.addAttribute("title", "시간대별 자원사용률");

		return popup(request,"selectPmTimeResUseRtP");
	}*/
	@RequestMapping(value="/selectPmTimeResUseRtP.do")
	public String selectPmTimeResUseRtP(
			PmResSearchVo searchVo,
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


		List<Map<String,String>> vmList = pmResStteService.selectPmResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);
		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);


		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuList",cpuList);
		model.addAttribute("vmList",vmList);
		model.addAttribute("memList",memList);
		model.addAttribute("sanList",sanList);
		model.addAttribute("title", "자원사용률");


		return popup(request,"selectPmTimeResUseRtP");
	}


	/**
	 * 물리서버 시간대별 자원사용률 팝업
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstrTimeResUseRtP.do")
	public String selectClstrTimeResUseRtP(
			PmResSearchVo searchVo,
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


		List<Map<String,String>> vmList = pmResStteService.selectClstrResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);

		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);


		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuList",cpuList);
		model.addAttribute("vmList",vmList);
		model.addAttribute("memList",memList);
		model.addAttribute("sanList",sanList);
		model.addAttribute("title", "자원사용률");


		return popup(request,"selectClstrTimeResUseRtP");
	}


	/**
	 * 물리서버자원현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPmResStteListXlsDown.do")
	public void selectPmResStteListXlsDown( PmResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{
		List<PmResStteVo> list = null;
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		if(searchVo.getSearchTrmCd()!=null){
			list = pmResStteService.selectPmResStteList(searchVo);
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("물리서버 자원현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "센터" );						titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "존" );						titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "망구분" );						titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "자원풀명" );					titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "클러스터명" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "물리서버명" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "물리서버구성ID" );			titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "가상서버수" );				titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "물리서버가상화율" );			titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "물리서버가상화율" );			titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "물리서버할당량/사용률" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "물리서버할당량/사용률" );	titleCell12.setCellStyle(headerStyle);/////

		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "물리서버할당량/사용률" );	titleCell13.setCellStyle(headerStyle);
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "물리서버할당량/사용률" );	titleCell14.setCellStyle(headerStyle);
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "물리서버할당량/사용률" );	titleCell15.setCellStyle(headerStyle);
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "물리서버할당량/사용률" );	titleCell16.setCellStyle(headerStyle);
		Cell titleCell17 = row.createCell(16);	titleCell17.setCellValue( "가상서버 할당량/사용률" );	titleCell17.setCellStyle(headerStyle);
		Cell titleCell18 = row.createCell(17);	titleCell18.setCellValue( "가상서버 할당량/사용률" );	titleCell18.setCellStyle(headerStyle);
		Cell titleCell19 = row.createCell(18);	titleCell19.setCellValue( "가상서버 할당량/사용률" );	titleCell19.setCellStyle(headerStyle);
		Cell titleCell20 = row.createCell(19);	titleCell20.setCellValue( "가상서버 할당량/사용률" );	titleCell20.setCellStyle(headerStyle);
		Cell titleCell21 = row.createCell(20);	titleCell11.setCellValue( "가상서버 할당량/사용률" );	titleCell21.setCellStyle(headerStyle);
		Cell titleCell22 = row.createCell(21);	titleCell22.setCellValue( "가상서버 할당량/사용률" );	titleCell22.setCellStyle(headerStyle);
		Cell titleCell23 = row.createCell(22);	titleCell23.setCellValue( "가상서버 할당량/사용률" );	titleCell23.setCellStyle(headerStyle);
		Cell titleCell24 = row.createCell(23);	titleCell24.setCellValue( "가상서버 할당량/사용률" );	titleCell24.setCellStyle(headerStyle);
		Cell titleCell25 = row.createCell(24);	titleCell25.setCellValue( "가상서버 할당량/사용률" );	titleCell25.setCellStyle(headerStyle);
		Cell titleCell26 = row.createCell(25);	titleCell26.setCellValue( "가상서버 할당량/사용률" );	titleCell26.setCellStyle(headerStyle);
		Cell titleCell27 = row.createCell(26);	titleCell27.setCellValue( "가상서버 할당량/사용률" );	titleCell27.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "센터" );							titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "존" );							titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "망" );							titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "자원풀명" );						titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "클러스터명" );					titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "물리서버명" );					titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "물리서버구성ID" );				titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "가상서버수" );					titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "CPU(%)" );							titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "메모리(%)" );						titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "CPU(vCore)" );					titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "CPU 사용률(%)" );				titleCell12.setCellStyle(headerStyle);//

		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "메모리(GB)" );					titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(13);		titleCell14.setCellValue( "메모리 사용률(%)" );				titleCell14.setCellStyle(headerStyle);//
		titleCell15 = row.createCell(14);		titleCell15.setCellValue( "스토리지(GB)" );					titleCell15.setCellStyle(headerStyle);
		titleCell16 = row.createCell(15);		titleCell16.setCellValue( "스토리지 사용률(%)" );			titleCell16.setCellStyle(headerStyle);//

		titleCell17 = row.createCell(16);		titleCell17.setCellValue( "가상서버명" );					titleCell17.setCellStyle(headerStyle);
		titleCell18 = row.createCell(17);		titleCell18.setCellValue( "가상서버 구성ID" );				titleCell18.setCellStyle(headerStyle);
		titleCell19 = row.createCell(18);		titleCell19.setCellValue( "호스트명" );						titleCell19.setCellStyle(headerStyle);
		titleCell20 = row.createCell(19);		titleCell20.setCellValue( "부처명" );						titleCell20.setCellStyle(headerStyle);
		titleCell21 = row.createCell(20);		titleCell21.setCellValue( "업무명" );						titleCell21.setCellStyle(headerStyle);
		titleCell22 = row.createCell(21);		titleCell22.setCellValue( "CPU(vCore)" );					titleCell22.setCellStyle(headerStyle);
		titleCell23 = row.createCell(22);		titleCell23.setCellValue( "CPU 사용률(%)" );				titleCell23.setCellStyle(headerStyle);//
		titleCell24 = row.createCell(23);		titleCell24.setCellValue( "메모리(GB)" );					titleCell24.setCellStyle(headerStyle);
		titleCell25 = row.createCell(24);		titleCell25.setCellValue( "메모리 사용률(%)" );				titleCell25.setCellStyle(headerStyle);//
		titleCell26 = row.createCell(25);		titleCell26.setCellValue( "스토리지(GB)" );					titleCell26.setCellStyle(headerStyle);
		titleCell27 = row.createCell(26);		titleCell27.setCellValue( "스토리지 사용률(%)" );			titleCell27.setCellStyle(headerStyle);//

		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));//존
		sheet.addMergedRegion(new CellRangeAddress(0,1,2,2));//망
		sheet.addMergedRegion(new CellRangeAddress(0,1,3,3));//풀
		sheet.addMergedRegion(new CellRangeAddress(0,1,4,4));//클러스터
		sheet.addMergedRegion(new CellRangeAddress(0,1,5,5));//물리서버명
		sheet.addMergedRegion(new CellRangeAddress(0,1,6,6));//물리서버구성ID
		sheet.addMergedRegion(new CellRangeAddress(0,1,7,7));//물리서버구성ID
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,9));//물리서버가상화율
		sheet.addMergedRegion(new CellRangeAddress(0,0,10,15));//물리서버 할당량/사용률
		sheet.addMergedRegion(new CellRangeAddress(0,0,16,26));//가상서버 할당량/사용률
		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,20));
			list = new ArrayList<PmResStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			PmResStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
			Cell dataCell0 = dataRow.createCell(0);	dataCell0.setCellValue(vo.getRegionNm() );
			Cell dataCell1 = dataRow.createCell(1);	dataCell1.setCellValue(vo.getZoneNm());
			Cell dataCell2 = dataRow.createCell(2);	dataCell2.setCellValue(vo.getNetNm());
			Cell dataCell3 = dataRow.createCell(3);	dataCell3.setCellValue(vo.getRsrcPoolNm());
			Cell dataCell4 = dataRow.createCell(4);	dataCell4.setCellValue(vo.getClstrNm());
			Cell dataCell5 = dataRow.createCell(5);	dataCell5.setCellValue(vo.getPmNm());
			Cell dataCell6 = dataRow.createCell(6);	dataCell6.setCellValue(vo.getPmCompId());
			Cell dataCell7 = dataRow.createCell(7);	dataCell7.setCellValue(vo.getPmLastVSrvrQty());
			Cell dataCell8 = dataRow.createCell(8);	dataCell8.setCellValue(ObjectUtils.getDisplayString(vo.getPmCpuVRt()));
			Cell dataCell9 = dataRow.createCell(9);	dataCell9.setCellValue(ObjectUtils.getDisplayString(vo.getPmMemVRt()));

			Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(ObjectUtils.getDisplayString(vo.getPmLastAsgnVcorQty()));
			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(ObjectUtils.getDisplayString(vo.getPmAvgCpuUseRt()));

			Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(ObjectUtils.getDisplayString(vo.getPmLastAsgnMemCapa()));
			Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(ObjectUtils.getDisplayString(vo.getPmMemUseRt()));

			Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(ObjectUtils.getDisplayString(vo.getPmLastStrgSumCapa()));
			Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(ObjectUtils.getDisplayString(vo.getPmStrgUseRt()));

			Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(vo.getVmNm());
			Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(vo.getVmCompId());
			Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(vo.getHstNm());
			Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(vo.getInstitutionNm());
			Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(vo.getJobNm());
			Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(ObjectUtils.getDisplayString(vo.getVmLastVcoreQty()));
			Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(ObjectUtils.getDisplayString(vo.getVmAvgCpuUseRt()));
			Cell dataCell23 = dataRow.createCell(23);	dataCell23.setCellValue(ObjectUtils.getDisplayString(vo.getVmLastMemSumCapa()));
			Cell dataCell24 = dataRow.createCell(24);	dataCell24.setCellValue(ObjectUtils.getDisplayString(vo.getVmMemUseRt()));
			Cell dataCell25 = dataRow.createCell(25);	dataCell25.setCellValue(ObjectUtils.getDisplayString(vo.getVmLastStrgSumCapa()));
			Cell dataCell26 = dataRow.createCell(26);	dataCell26.setCellValue(ObjectUtils.getDisplayString(vo.getVmStrgUseRt()));

		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("물리서버자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

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
	 * 가상서버자원현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPmTimeResUseRtPXlsDown.do")
	public void selectPmTimeResUseRtPXlsDown( PmResSearchVo searchVo,
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


		List<Map<String,String>> vmList = pmResStteService.selectPmResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);
		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = pmResStteService.selectPmTimeResUseRtPivot(searchVo);

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

		Cell cpuTitleCell1 = cpuRow.createCell(0);	cpuTitleCell1.setCellValue( "기간" );						cpuTitleCell1.setCellStyle(headerStyle);
		int num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell cpuTitleCell = cpuRow.createCell(num++);	cpuTitleCell.setCellValue( vmMap.get("vm_nm"));						cpuTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<cpuList.size(); i++){
			num=0;
			Map<String,String> cpuMap = cpuList.get(i);
			Row cpuDataRow = cpuSheet.createRow(1+i);
			Cell cpuDataCell = cpuDataRow.createCell(num++);	cpuDataCell.setCellValue(cpuMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell cpuDataCell1 = cpuDataRow.createCell(num++);	cpuDataCell1.setCellValue(getObject2String(cpuMap.get( getObject2String(vmMap.get("vm_seq")))));
			}

		}
		/** DATA end*/

		/** TITLE start*/
		Sheet memSheet = workBook.createSheet("MEM 자원사용률");


		Row memRow = memSheet.createRow(0);

		Cell memTitleCell1 = memRow.createCell(0);	memTitleCell1.setCellValue( "기간" );						memTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell memTitleCell = memRow.createCell(num++);	memTitleCell.setCellValue( vmMap.get("vm_nm"));						memTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<memList.size(); i++){
			num=0;
			Map<String,String> memMap = memList.get(i);
			Row memDataRow = memSheet.createRow(1+i);
			Cell memDataCell = memDataRow.createCell(num++);	memDataCell.setCellValue(memMap.get("dt"));
			for(Map<String,String> vmMap: vmList){
				Cell memDataCell1 = memDataRow.createCell(num++);	memDataCell1.setCellValue(getObject2String(memMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet sanSheet = workBook.createSheet("SAN 자원사용률");


		Row sanRow = sanSheet.createRow(0);

		Cell sanTitleCell1 = sanRow.createCell(0);	sanTitleCell1.setCellValue( "기간" );						sanTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell sanTitleCell = sanRow.createCell(num++);	sanTitleCell.setCellValue( vmMap.get("vm_nm"));						sanTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<sanList.size(); i++){
			num=0;
			Map<String,String> sanMap = sanList.get(i);
			Row sanDataRow = sanSheet.createRow(1+i);
			Cell sanDataCell = sanDataRow.createCell(num++);	sanDataCell.setCellValue(sanMap.get("dt"));
			for(Map<String,String> vmMap: vmList){
				Cell sanDataCell1 = sanDataRow.createCell(num++);	sanDataCell1.setCellValue(getObject2String(sanMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("물리서버자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}
	
	/**
	 * 물리서버현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectClstrTimeResUseRtPXlsDown.do")
	public void selectClstrTimeResUseRtPXlsDown( PmResSearchVo searchVo,
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


		List<Map<String,String>> vmList = pmResStteService.selectClstrResStteVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);
		searchVo.setColumn("SAN");
		List<Map<String,String>> sanList = pmResStteService.selectClstrTimeResUseRtPivot(searchVo);

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

		Cell cpuTitleCell1 = cpuRow.createCell(0);	cpuTitleCell1.setCellValue( "기간" );						cpuTitleCell1.setCellStyle(headerStyle);
		int num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell cpuTitleCell = cpuRow.createCell(num++);	cpuTitleCell.setCellValue( vmMap.get("vm_nm"));						cpuTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<cpuList.size(); i++){
			num=0;
			Map<String,String> cpuMap = cpuList.get(i);
			Row cpuDataRow = cpuSheet.createRow(1+i);
			Cell cpuDataCell = cpuDataRow.createCell(num++);	cpuDataCell.setCellValue(cpuMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell cpuDataCell1 = cpuDataRow.createCell(num++);	cpuDataCell1.setCellValue(getObject2String(cpuMap.get( getObject2String(vmMap.get("vm_seq")))));
			}

		}
		/** DATA end*/

		/** TITLE start*/
		Sheet memSheet = workBook.createSheet("MEM 자원사용률");


		Row memRow = memSheet.createRow(0);

		Cell memTitleCell1 = memRow.createCell(0);	memTitleCell1.setCellValue( "기간" );						memTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell memTitleCell = memRow.createCell(num++);	memTitleCell.setCellValue( vmMap.get("vm_nm"));						memTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<memList.size(); i++){
			num=0;
			Map<String,String> memMap = memList.get(i);
			Row memDataRow = memSheet.createRow(1+i);
			Cell memDataCell = memDataRow.createCell(num++);	memDataCell.setCellValue(memMap.get("dt"));
			for(Map<String,String> vmMap: vmList){
				Cell memDataCell1 = memDataRow.createCell(num++);	memDataCell1.setCellValue(getObject2String(memMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/

		/** TITLE start*/
		Sheet sanSheet = workBook.createSheet("SAN 자원사용률");


		Row sanRow = sanSheet.createRow(0);

		Cell sanTitleCell1 = sanRow.createCell(0);	sanTitleCell1.setCellValue( "기간" );						sanTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> vmMap: vmList){
        	Cell sanTitleCell = sanRow.createCell(num++);	sanTitleCell.setCellValue( vmMap.get("vm_nm"));						sanTitleCell.setCellStyle(headerStyle);
        }
		/** TITLE end */
		/** DATA start*/

		for(int i=0; i<sanList.size(); i++){
			num=0;
			Map<String,String> sanMap = sanList.get(i);
			Row sanDataRow = sanSheet.createRow(1+i);
			Cell sanDataCell = sanDataRow.createCell(num++);	sanDataCell.setCellValue(sanMap.get("dt"));
			for(Map<String,String> vmMap: vmList){
				Cell sanDataCell1 = sanDataRow.createCell(num++);	sanDataCell1.setCellValue(getObject2String(sanMap.get(getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("물리서버현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}
}
