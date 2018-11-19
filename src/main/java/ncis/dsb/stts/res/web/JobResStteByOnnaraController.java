/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobResStteByOnnaraController.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 11. 6.
 * @lastmodified 2017. 11. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 11. 6.     selim         v1.0             최초생성
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
import ncis.dsb.stts.res.service.JobResStteByOnnaraService;
import ncis.dsb.stts.res.vo.JobResSearchVo;

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

/**
 * @author selim
 *
 */

@Controller("JobResStteByOnnaraController")
@RequestMapping("/dsb/stts/res/jobResStteByOnnara")

public class JobResStteByOnnaraController extends BaseController{

	@Resource(name="jobResStteByOnnaraService")
	JobResStteByOnnaraService jobResStteByOnnaraService;

	/**
	 * 업무자원현황 목록조회 (온나라)
	 */
	@RequestMapping(value="/selectJobResStteListByOnnara.do")
	public String selectJobResStteListByOnnara( JobResSearchVo searchVo, HttpServletRequest request, Model model) throws Exception{
		if("DW".equals(searchVo.getSearchTrmCd())){ // 주간선택시 날짜~날짜 형식으로 넘어옴.
			String[] date = searchVo.getWeeklyDatePicker().split("~");
			searchVo.setStrtDt(date[0].trim());
			searchVo.setEndDt(date[1].trim());
		}
		else if("MM".equals(searchVo.getSearchTrmCd())){
			searchVo.setLastDay(DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()), Integer.parseInt(searchVo.getSearchMmCd()))+"");
		}
		
		// 업무가상서버현황
		List<Map<String,String>> vmList = null;
		List<Map<String,String>> useRtVmList = null;
		List<Map<String,String>> useRtTopVmList = null;

		// 자동확장 서비스 현황
		List<Map<String,String>> axList = null;
		List<Map<String,String>> useRtAxList = null;
		List<Map<String,String>> useRtTopAxList = null;

		List<Long> vmSeqList = new ArrayList<Long>(); // 가상서버 Seq 리스트
		List<Long> axSeqList = new ArrayList<Long>(); // 자동화서비스 Seq 리스트

//		if(searchVo.getVmSeq()!=null){
		if(null != searchVo.getVmListId()){
			// 2017.11.21 seq뒤에 'V' 와 'P'의 구분자가 들어 있어서, 구분자에 따라 가상서버/자동화서비스 로 나누어 주는 작업을 해줘야함.
			for(String str : searchVo.getVmListId()){
				char c = str.charAt(str.length() - 1);
				if(c == 'V'){ // VM
					str = str.substring(0, str.length() -1);
					vmSeqList.add(Long.parseLong(str));
				}
				else if(c == 'P') { // POD
					str = str.substring(0, str.length() -1);
					axSeqList.add(Long.parseLong(str));
				}
			}
			searchVo.setVmSeqList(vmSeqList);
			searchVo.setAxSeqList(axSeqList);

			if(null != vmSeqList && vmSeqList.size() > 0){
				vmList = jobResStteByOnnaraService.selectJobResStteByOnnaraVmList(searchVo);
				searchVo.setVmList(vmList);
				useRtVmList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtPivot(searchVo);
				useRtTopVmList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtTop(searchVo);
			}

			if(null != axSeqList && axSeqList.size() > 0){
				axList = jobResStteByOnnaraService.selectJobResStteByOnnaraPodList(searchVo);
				searchVo.setPodList(axList);
				useRtAxList = jobResStteByOnnaraService.selectAxTimeResByOnnaraUseRtPivot(searchVo);
				useRtTopAxList = jobResStteByOnnaraService.selectAxTimeResByOnnaraUseRtTop(searchVo);
			}


		} else {
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}
		
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("useRtVmList",useRtVmList);
		model.addAttribute("useRtTopVmList",useRtTopVmList);
		model.addAttribute("vmList",vmList);
		model.addAttribute("axList",axList);
		model.addAttribute("useRtAxList",useRtAxList);
		model.addAttribute("useRtTopAxList",useRtTopAxList);

		return dashTilesView(request,"selectJobResStteListByOnnara");
	}

	private String getObject2String(Object o){
		if(o==null){
			return "";
		}
		return o.toString();
	}


	@RequestMapping(value="/selectJobResStteListByOnnaraVmXlsDown.do")
	public void selectJobResStteListByOnnaraVmXlsDown (JobResSearchVo searchVo, HttpServletRequest request,	HttpServletResponse response, Model model, JobResSearchVo preSearchVo) throws Exception{
		
		if(null != searchVo){
			System.out.println("searchVo toString = " + searchVo.toString());
		}
		if(null != preSearchVo){
			System.out.println("preSearchVo toString = " + preSearchVo.toString());
		}
		
		// 업무가상서버현황 
		List<Map<String,String>> vmList = null;
		List<Map<String,String>> useRtVmList = null;
		List<Map<String,String>> useRtTopVmList = null;
		List<Long> vmSeqList = new ArrayList<Long>(); // 가상서버 Seq 리스트

		if("DW".equals(searchVo.getSearchTrmCd())){ // 주간선택시 날짜~날짜 형식으로 넘어옴.
			String[] date = searchVo.getWeeklyDatePicker().split("~");
			searchVo.setStrtDt(date[0].trim());
			searchVo.setEndDt(date[1].trim());
		}
		else if("MM".equals(searchVo.getSearchTrmCd())){
			searchVo.setLastDay(DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()), Integer.parseInt(searchVo.getSearchMmCd()))+"");
		}

		if(null != searchVo.getVmListId()){
			for(String str : searchVo.getVmListId()){
				char c = str.charAt(str.length() - 1);
				if(c == 'V'){ // VM
					str = str.substring(0, str.length() -1);
					vmSeqList.add(Long.parseLong(str));
				}
			}
			searchVo.setVmSeqList(vmSeqList);

			vmList = jobResStteByOnnaraService.selectJobResStteByOnnaraVmList(searchVo);
			searchVo.setVmList(vmList);
			useRtVmList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtPivot(searchVo);
			useRtTopVmList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtTop(searchVo);
		} else {
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}
		
		boolean dual = (searchVo.getSearchType().equals("A")); // 전체검색인지 판단.
		int listSize = vmList.size();
		
		Workbook workBook = new XSSFWorkbook();
		Sheet jobVmSheet = workBook.createSheet("업무가상서버현황(온나라)");
		
		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);
        
        /** TITLE start*/
		Row row_0 = jobVmSheet.createRow(0);
		
		// 가상서버명
		Cell vmTitleCell1 = row_0.createCell(0);
		vmTitleCell1.setCellValue("");
		vmTitleCell1.setCellStyle(headerStyle);
		int row_0_num=1;
		
		if(dual){ // 전체선택인 경우
			for(int i=0; i<listSize; i++){ 
				if(i % 2 == 0){ // 1-2, 3-4, 5-6, 7-8.....
					jobVmSheet.addMergedRegion(new CellRangeAddress(0, 0, (i+1), (i+2)));
				}
			}
			String temp_vm_comp_id = "";
			for(Map<String,String> vmMap: vmList){
	        	String[] data = vmMap.get("vm_comp_id").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
	        	if(!temp_vm_comp_id.equals(data[0])){
	        		Cell vmTitleCell = row_0.createCell(row_0_num);
	        		vmTitleCell.setCellStyle(headerStyle);
	        		temp_vm_comp_id = data[0];
	        		vmTitleCell.setCellValue(data[0]);
	        		row_0_num = row_0_num + 2;
	        	}
	        }
		}
		else {
			String temp_vm_comp_id = "";
			for(Map<String,String> vmMap: vmList){
	        	String[] data = vmMap.get("vm_comp_id").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
	        	if(!temp_vm_comp_id.equals(data[0])){
	        		Cell vmTitleCell = row_0.createCell(row_0_num++);
	        		vmTitleCell.setCellStyle(headerStyle);
	        		temp_vm_comp_id = data[0];
	        		vmTitleCell.setCellValue(data[0]);
	        	}
	        }
		}
		
		Row row_1 = jobVmSheet.createRow(1);
		
		// CPU, MEM 구분
		Cell vmTitleCell2 = row_1.createCell(0);
		vmTitleCell2.setCellValue("");
		vmTitleCell2.setCellStyle(headerStyle);
		int row_1_num=1;
		for(Map<String,String> vmMap: vmList){
			Cell vmTitleCell = row_1.createCell(row_1_num++);
			String[] data = vmMap.get("vm_comp_id").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
			vmTitleCell.setCellValue(data[1]);
			vmTitleCell.setCellStyle(headerStyle);
		}
		/** TITLE end */
		/** DATA start*/
		
		
		for(int i=0; i<useRtTopVmList.size(); i++){
			int num=0;
			Map<String, String> useRtTopVmMap = useRtTopVmList.get(i);
			Row useRtVmTopRow = jobVmSheet.createRow(2+i);
			Cell useRtTopVmCell = useRtVmTopRow.createCell(num++);
			if(useRtTopVmMap.get("dt").equals("AMIN")){
				useRtTopVmCell.setCellValue("최소");
			}
			else if(useRtTopVmMap.get("dt").equals("BAVG")){
				useRtTopVmCell.setCellValue("평균");
			}
			else if(useRtTopVmMap.get("dt").equals("CMAX")){
				useRtTopVmCell.setCellValue("최대");
			}
			for(Map<String, String> vmMap: vmList){
				Cell useRtVmTopCell1 = useRtVmTopRow.createCell(num++);
				useRtVmTopCell1.setCellValue(getObject2String(useRtTopVmMap.get( getObject2String(vmMap.get("vm_seq")))));
			}
		}

		for(int i=0; i<useRtVmList.size(); i++){
			int num=0;
			Map<String, String> useRtVmMap = useRtVmList.get(i);
			Row useRtVmRow = jobVmSheet.createRow(2+useRtTopVmList.size()+i);
			Cell useRtVmCell = useRtVmRow.createCell(num++);
			useRtVmCell.setCellValue(useRtVmMap.get("dt"));
			for(Map<String, String> vmMap: vmList){
				Cell useRtVmCell1 = useRtVmRow.createCell(num++);
				useRtVmCell1.setCellValue(getObject2String(useRtVmMap.get( getObject2String(vmMap.get("vm_seq")))));
			}
		}
		/** DATA end*/

		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("업무가상서버현황(온나라)").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}

	@RequestMapping(value="/selectJobResStteListByOnnaraAxXlsDown.do")
	public void selectJobResStteListByOnnaraAxXlsDown (JobResSearchVo searchVo, HttpServletRequest request,	HttpServletResponse response, Model model) throws Exception{
		// 자동확장 서비스 현황
		List<Map<String,String>> axList = null;
		List<Map<String,String>> useRtAxList = null;
		List<Map<String,String>> useRtTopAxList = null;
		List<Long> axSeqList = new ArrayList<Long>(); // 자동화서비스 Seq 리스트

		if("DW".equals(searchVo.getSearchTrmCd())){ // 주간선택시 날짜~날짜 형식으로 넘어옴.
			String[] date = searchVo.getWeeklyDatePicker().split("~");
			searchVo.setStrtDt(date[0].trim());
			searchVo.setEndDt(date[1].trim());
		}
		else if("MM".equals(searchVo.getSearchTrmCd())){
			searchVo.setLastDay(DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()), Integer.parseInt(searchVo.getSearchMmCd()))+"");
		}

		if(null != searchVo.getVmListId()){
			for(String str : searchVo.getVmListId()){
				char c = str.charAt(str.length() - 1);
				if(c == 'P') { // POD
					str = str.substring(0, str.length() -1);
					axSeqList.add(Long.parseLong(str));
				}
			}
			searchVo.setAxSeqList(axSeqList);

			axList = jobResStteByOnnaraService.selectJobResStteByOnnaraPodList(searchVo);
			searchVo.setPodList(axList);
			useRtAxList = jobResStteByOnnaraService.selectAxTimeResByOnnaraUseRtPivot(searchVo);
			useRtTopAxList = jobResStteByOnnaraService.selectAxTimeResByOnnaraUseRtTop(searchVo);
		} else {
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}
		
		boolean dual = (searchVo.getSearchType().equals("A")); // 전체검색인지 판단.
		int listSize = axList.size();

		Workbook workBook = new XSSFWorkbook();
		Sheet jobVmSheet = workBook.createSheet("자동확장 서비스 현황(온나라)");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

        /** TITLE start*/
        Row row_0 = jobVmSheet.createRow(0); // 서비스명
        Cell axTitleCell0 = row_0.createCell(0);
		axTitleCell0.setCellValue( "" );
		axTitleCell0.setCellStyle(headerStyle);
		int row_0_num = 1;
        String temp_servc_nm = "";
        
		for(Map<String,String> axMap: axList){
        	String data = axMap.get("servc_nm"); // 가상서버명||CPU, 가상서버명||MEM
        	String str_cnt = String.valueOf(axMap.get("pod_cnt"));
        	int cnt = Integer.parseInt(str_cnt);
//        	int index = 1;
        	if(!temp_servc_nm.equals(data)){
        		if(row_0_num == 1){
        			jobVmSheet.addMergedRegion(new CellRangeAddress(0, 0, row_0_num, cnt));
        		}
        		else {
        			jobVmSheet.addMergedRegion(new CellRangeAddress(0, 0, row_0_num, row_0_num + (cnt-1)));
        		}
        		Cell axTitleCell = row_0.createCell(row_0_num);
        		axTitleCell.setCellStyle(headerStyle);
        		temp_servc_nm = data;
        		axTitleCell.setCellValue(data);
        		row_0_num = row_0_num + cnt;
        	}
        }
        
        
		Row row_1 = jobVmSheet.createRow(1); // POD명
		Cell axTitleCell1 = row_1.createCell(0);
		axTitleCell1.setCellValue( "" );
		axTitleCell1.setCellStyle(headerStyle);
		int row_1_num=1;
		String temp_pod_id = "";
		
		if(dual){ // 전체선택인 경우
			for(int i=0; i<listSize; i++){ 
				if(i % 2 == 0){ // 1-2, 3-4, 5-6, 7-8.....
					jobVmSheet.addMergedRegion(new CellRangeAddress(1, 1, (i+1), (i+2)));
				}
			}
			for(Map<String,String> axMap: axList){
	        	String[] data = axMap.get("pod_nm").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
	        	if(!temp_pod_id.equals(data[0])){
	        		Cell axTitleCell = row_1.createCell(row_1_num);
	        		axTitleCell.setCellStyle(headerStyle);
	        		temp_pod_id = data[0];
	        		axTitleCell.setCellValue(data[0]);
	        		row_1_num = row_1_num + 2;
	        	}
	        }
		}
		else {
			for(Map<String,String> axMap: axList){
	        	String[] data = axMap.get("pod_nm").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
	        	if(!temp_pod_id.equals(data[0])){
	        		Cell axTitleCell = row_1.createCell(row_1_num++);
	        		axTitleCell.setCellStyle(headerStyle);
	        		temp_pod_id = data[0];
	        		axTitleCell.setCellValue(data[0]);
	        	}
	        }
		}
		
		Row row_2 = jobVmSheet.createRow(2); // CPU, MEM
		
		// CPU, MEM 구분
		Cell axTitleCell2 = row_2.createCell(0);
		axTitleCell2.setCellValue("");
		axTitleCell2.setCellStyle(headerStyle);
		int row_2_num=1;
		
		for(Map<String,String> axMap: axList){
			Cell axTitleCell = row_2.createCell(row_2_num++);
			String[] data = axMap.get("pod_nm").split("\\|\\|"); // 가상서버명||CPU, 가상서버명||MEM 
			axTitleCell.setCellValue(data[1]);
			axTitleCell.setCellStyle(headerStyle);
		}
		/** TITLE end */
		/** DATA start*/
		for(int i=0; i<useRtTopAxList.size(); i++){
			int num = 0;
			Map<String, String> useRtTopAxMap = useRtTopAxList.get(i);
			Row useRtAxTopRow = jobVmSheet.createRow(3+i);
			Cell useRtTopAxCell = useRtAxTopRow.createCell(num++);
			if(useRtTopAxMap.get("dt").equals("AMIN")){
				useRtTopAxCell.setCellValue("최소");
			}
			else if(useRtTopAxMap.get("dt").equals("BAVG")){
				useRtTopAxCell.setCellValue("평균");
			}
			else if(useRtTopAxMap.get("dt").equals("CMAX")){
				useRtTopAxCell.setCellValue("최대");
			}
			for(Map<String, String> axMap: axList){
				Cell useRtAxTopCell1 = useRtAxTopRow.createCell(num++);
				useRtAxTopCell1.setCellValue(getObject2String(useRtTopAxMap.get( getObject2String(axMap.get("pod_id")))));
			}
		}

		for(int i=0; i<useRtAxList.size(); i++){
			int num = 0;
			Map<String, String> useRtAxMap = useRtAxList.get(i);
			Row useRtAxRow = jobVmSheet.createRow(3+useRtTopAxList.size()+i);
			Cell useRtAxCell = useRtAxRow.createCell(num++);
			useRtAxCell.setCellValue(useRtAxMap.get("dt"));
			for(Map<String, String> axMap: axList){
				Cell useRtAxCell1 = useRtAxRow.createCell(num++);
				useRtAxCell1.setCellValue(getObject2String(useRtAxMap.get( getObject2String(axMap.get("pod_id")))));
			}
		}
		/** DATA end*/

		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("자동확장서비스현황(온나라)").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}


	/**
	 * 자동확장 서비스 현황 온나라 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/selectJobResStteListByOnnaraXlsDown.do")
	public void selectAxResStteListByOnnaraXlsDown( JobResSearchVo searchVo,
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


		List<Map<String,String>> vmList = jobResStteByOnnaraService.selectJobResStteByOnnaraVmList(searchVo);
		searchVo.setVmList(vmList);
		searchVo.setColumn("CPU");
		List<Map<String,String>> cpuList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtPivot(searchVo);
		searchVo.setColumn("MEM");
		List<Map<String,String>> memList = jobResStteByOnnaraService.selectJobTimeResByOnnaraUseRtPivot(searchVo);

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

		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("업무별자원사용률").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();

	}
}
