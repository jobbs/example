/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResStteController.java
 *
 * @author
 * @lastmodifier 양정순
 * @created 2017. 05. 10
 * @lastmodified2017. 05. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 10   양정순         v1.0             최초생성
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
import ncis.dsb.stts.res.service.AxNodeResStteService;
import ncis.dsb.stts.res.vo.AxNodeResSearchVo;
import ncis.dsb.stts.res.vo.AxNodeResStteVo;

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

@Controller("AxNodeResStteController")
@RequestMapping("/dsb/stts/res/axNodeResStte")
public class AxNodeResStteController extends BaseController {


	@Resource(name="axNodeResStteService")
	AxNodeResStteService axNodeResStteService;

	/**
	 * 업무자원현황 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxNodeResStteList.do")
	public String selectAxNodeResStteList( AxNodeResSearchVo searchVo,
			HttpServletRequest request,
			Model model) throws Exception{

		List<AxNodeResStteVo> list = null;
		if(searchVo.getSearchTrmCd()!=null){
			list = axNodeResStteService.selectAxNodeResStteList(searchVo);

		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));

		return dashTilesView(request,"selectAxNodeResStteList");
	}
	/**
	 * 업무자원현황 시간대별 자원사용률 팝업
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectAxNodeTimeResUseRtP.do")
	public String selectAxNodeTimeResUseRtP(
			AxNodeResSearchVo searchVo,
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

		List<Map<String,String>> nodeList = axNodeResStteService.selectAxNodeResStteNodeList(searchVo);
		String graphNode="";
		searchVo.setNodeList(nodeList);

		if(nodeList.size() <= 0){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("atmscl_node_id",null);
			nodeList.add(map);
			graphNode = "emty";
		}
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETIN");
		List<Map<String,String>> netInList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETOUT");
		List<Map<String,String>> netOutList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("cpuList",cpuList);
		model.addAttribute("nodeList",nodeList);
		model.addAttribute("graphNode",graphNode);
		model.addAttribute("memList",memList);
		model.addAttribute("netInList",netInList);
		model.addAttribute("netOutList",netOutList);
		if(searchVo.getAtmsclNodeId() != null && !"".equals(searchVo.getAtmsclNodeId())){
			model.addAttribute("title", "노드 시간대별 자원사용률");
		}else{
			model.addAttribute("title", "노드별 시간대별 자원사용률");
		}



		return popup(request,"selectAxNodeTimeResUseRtP");
	}

	/**
	 * 업무자원현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectAxNodeResStteListXlsDown.do")
	public void selectAxNodeResStteListXlsDown( AxNodeResSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception{

		List<AxNodeResStteVo> list = null;
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		if(searchVo.getSearchTrmCd()!=null){
			list = axNodeResStteService.selectAxNodeResStteList(searchVo);
		}else{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("자원확장 노드별 자원현황");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

        Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "센터" );							titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "존" );							titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "망" );							titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "자원풀" );						titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "노드명" );						titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "POD수" );							titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "자동자원확장(할당량/사용률)" );	titleCell13.setCellStyle(headerStyle);

		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "센터" );							titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "존" );							titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "망" );							titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "자원풀" );						titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "노드명" );						titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "POD수" );							titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "CPU" );					titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "CPU 사용률(%)" );					titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "메모리(GB)" );					titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "메모리 사용률(%)" );				titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "스토리지(GB)" );					titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "네트워크(In/Out)" );				titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "네트워크(In/Out)" );				titleCell13.setCellStyle(headerStyle);

		row = sheet.createRow(2);
		titleCell1 = row.createCell(0);			titleCell1.setCellValue( "센터" );							titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);			titleCell2.setCellValue( "존" );							titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);			titleCell3.setCellValue( "망" );							titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);			titleCell4.setCellValue( "자원풀" );						titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);			titleCell5.setCellValue( "노드명" );						titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);			titleCell6.setCellValue( "POD수" );							titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);			titleCell7.setCellValue( "CPU" );					titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);			titleCell8.setCellValue( "CPU 사용률(%)" );					titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);			titleCell9.setCellValue( "메모리(GB)" );					titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);		titleCell10.setCellValue( "메모리 사용률(%)" );				titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);		titleCell11.setCellValue( "스토리지(GB)" );					titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);		titleCell12.setCellValue( "In(KB/s)" );						titleCell12.setCellStyle(headerStyle);
		titleCell13 = row.createCell(12);		titleCell13.setCellValue( "Out(KB/s)" );					titleCell13.setCellStyle(headerStyle);


		sheet.addMergedRegion(new CellRangeAddress(0,2,0,0));//센터
		sheet.addMergedRegion(new CellRangeAddress(0,2,1,1));//존
		sheet.addMergedRegion(new CellRangeAddress(0,2,2,2));//망
		sheet.addMergedRegion(new CellRangeAddress(0,2,3,3));//자원풀
		sheet.addMergedRegion(new CellRangeAddress(0,2,4,4));//노드명
		sheet.addMergedRegion(new CellRangeAddress(0,2,5,5));//POD수
		sheet.addMergedRegion(new CellRangeAddress(0,0,6,12));//자동자원확장(할당량/사용률)
		sheet.addMergedRegion(new CellRangeAddress(1,2,6,6));//CPU(vCore)
		sheet.addMergedRegion(new CellRangeAddress(1,2,7,7));//CPU 사용률(%)
		sheet.addMergedRegion(new CellRangeAddress(1,2,8,8));//메모리(GB)
		sheet.addMergedRegion(new CellRangeAddress(1,2,9,9));//메모리 사용률(%)
		sheet.addMergedRegion(new CellRangeAddress(1,2,10,10));//스토리지(GB)
		sheet.addMergedRegion(new CellRangeAddress(1,1,11,12));//네트워크(In/Out)
		sheet.addMergedRegion(new CellRangeAddress(2,2,11,11));//In(KB/s)
		sheet.addMergedRegion(new CellRangeAddress(2,2,12,12));//Out(KB/s)

		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(3,3,0,12));
			list = new ArrayList<AxNodeResStteVo>();
		}
		for(int i=0; i<list.size(); i++){
			AxNodeResStteVo vo = list.get(i);
			Row dataRow = sheet.createRow(3+i);

			Cell dataCell0 = dataRow.createCell(0);	dataCell0.setCellValue(vo.getRegionNm() );
			Cell dataCell1 = dataRow.createCell(1);	dataCell1.setCellValue(DateUtil.stringValueOf(vo.getZoneNm()));
			Cell dataCell2 = dataRow.createCell(2);	dataCell2.setCellValue(DateUtil.stringValueOf(vo.getNetNm()));
			Cell dataCell3 = dataRow.createCell(3);	dataCell3.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
			Cell dataCell4 = dataRow.createCell(4);	dataCell4.setCellValue(DateUtil.stringValueOf(vo.getAtmsclNodeNm()));
			Cell dataCell5 = dataRow.createCell(5);	dataCell5.setCellValue(DateUtil.stringValueOf(vo.getPodQty()));
			Cell dataCell6 = dataRow.createCell(6);	dataCell6.setCellValue(DateUtil.stringValueOf(vo.getCpu()));
			Cell dataCell7 = dataRow.createCell(7);	dataCell7.setCellValue(DateUtil.stringValueOf(vo.getCpuRt()));
			Cell dataCell8 = dataRow.createCell(8);	dataCell8.setCellValue(DateUtil.stringValueOf(vo.getMem()));
			Cell dataCell9 = dataRow.createCell(9);	dataCell9.setCellValue(DateUtil.stringValueOf(vo.getMemRt()));
			Cell dataCell10 = dataRow.createCell(10); dataCell10.setCellValue(DateUtil.stringValueOf(vo.getStrg()));

			Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getNetwkIn()));
			Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getNetwkOut()));
		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자동확장 노드별 자원현황").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

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
	 * 물리서버자원현황 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxNodeTimeResUseRtPXlsDown.do")
	public void selectAxNodeTimeResUseRtPXlsDown( AxNodeResSearchVo searchVo,
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

		List<Map<String,String>> nodeList = axNodeResStteService.selectAxNodeResStteNodeList(searchVo);
		searchVo.setNodeList(nodeList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETIN");
		List<Map<String,String>> netInList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);
		searchVo.setColumn("NETOUT");
		List<Map<String,String>> netOutList = axNodeResStteService.selectAxNodeTimeResUseRtPivot(searchVo);

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
		for(Map<String,String> nodeMap: nodeList){
        	Cell cpuTitleCell = cpuRow.createCell(num++);
        	     cpuTitleCell.setCellValue( nodeMap.get("atmscl_node_nm"));
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
			for(Map<String, String> nodeMap: nodeList){
				Cell cpuDataCell1 = cpuDataRow.createCell(num++);
				cpuDataCell1.setCellValue(getObject2String(cpuMap.get( getObject2String(nodeMap.get("atmscl_node_id")))));
			}

		}
		/** DATA end*/

		/** TITLE start*/
		Sheet memSheet = workBook.createSheet("MEM 자원사용률");


		Row memRow = memSheet.createRow(0);

		Cell memTitleCell1 = memRow.createCell(0);	memTitleCell1.setCellValue( "기간" );
		     memTitleCell1.setCellStyle(headerStyle);
		num=1;
		for(Map<String,String> nodeMap: nodeList){
        	Cell memTitleCell = memRow.createCell(num++);
        	memTitleCell.setCellValue( nodeMap.get("atmscl_node_nm"));
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
			for(Map<String, String> nodeMap: nodeList){
				Cell memDataCell1 = memDataRow.createCell(num++);
				     memDataCell1.setCellValue(getObject2String(memMap.get(getObject2String(nodeMap.get("atmscl_node_id")))));
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
		for(Map<String,String> nodeMap: nodeList){
        	Cell netInTitleCell = netInRow.createCell(num++);
        		 netInTitleCell.setCellValue( nodeMap.get("atmscl_node_nm"));
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
			for(Map<String, String> nodeMap: nodeList){
				Cell netInDataCell1 = netInDataRow.createCell(num++);
					 netInDataCell1.setCellValue(getObject2String(netInMap.get(getObject2String(nodeMap.get("atmscl_node_id")))));
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
		for(Map<String,String> nodeMap: nodeList){
        	Cell netOutTitleCell = netOutRow.createCell(num++);
        		 netOutTitleCell.setCellValue( nodeMap.get("atmscl_node_nm"));
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
			for(Map<String, String> nodeMap: nodeList){
				Cell netOutDataCell1 = netOutDataRow.createCell(num++);
				     netOutDataCell1.setCellValue(getObject2String(netOutMap.get(getObject2String(nodeMap.get("atmscl_node_id")))));
			}
		}
		/** DATA end*/


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("노드별 시간대별 자원사용률").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}

}
