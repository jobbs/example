/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.asgnUseful.web;

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
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.asgnUseful.service.UsefulService;
import ncis.dsb.stts.asgnUseful.vo.UsefulSearchVo;
import ncis.dsb.stts.asgnUseful.vo.UsefulVo;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller("UsefulController")
@RequestMapping("/dsb/stts/asgnUseful/useful")
public class UsefulController extends BaseController {


	@Resource(name="usefulService")
	UsefulService usefulService;

	@Resource(name = "regionService")
    RegionService regionService;

	/**
	 * 가상서버 생성 가용량 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectUsefulList.do")
	public String selectUsefulList( HttpServletRequest request,
			Model model, UsefulSearchVo searchVo) throws Exception{

		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String mm = Integer.toString(t.get(Calendar.MONTH));

		if(mm.length() < 2) mm = "0"+ mm;

		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getMm() == null) searchVo.setMm(mm);

		List<UsefulVo> list = null;
		List<RegionVo> regionVoList = regionService.selectRegionAllList();

		List<String> mmList = new ArrayList<String>();
		String tm = "";
		for(int i = 1; i<=12; i++){
			if(i < 10) tm = "0"+ Integer.toString(i);
			else tm = Integer.toString(i);
			mmList.add(tm);
		}

		if(searchVo.getSearch() != null){
			list = usefulService.selectUsefulList(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);
		model.addAttribute("mmList", mmList);

		return dashTilesView(request,"selectUsefulList");
	}


	/**
	 * 가상서버 생성 가용량 상세 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insetUsefulView.do")
	public String insetUsefulView( HttpServletRequest request,
			Model model, UsefulSearchVo searchVo) throws Exception{

		String yearmm = DateUtil.addMonth(-1);
		String year = yearmm.substring(0, 4);
		String mm = yearmm.substring(5, 7);

		List<UsefulVo> list = null;
		List<RegionVo> regionVoList = regionService.selectRegionAllList();
		if(searchVo.getYear() == null) searchVo.setYear(year);
		if(searchVo.getMm() == null) searchVo.setMm(mm);

		if(searchVo.getClstrUuid() != null && !searchVo.getClstrUuid().equals("")){
			list = usefulService.selectUsefulView(searchVo);
		}else{
			list = usefulService.selectUsefulAdd(searchVo);
		}

		model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		model.addAttribute("regionVoList", regionVoList);


		return dashTilesView(request,"insertUseful");
	}

	/**
	 * 가상서버 생성 가용량 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectUsefulXlsDown.do")
	public void selectUsefulXlsDown(
			UsefulSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);
		List<UsefulVo> list = null;
		if(searchVo.getSearch() != null){
			list = usefulService.selectUsefulList(searchVo);
		}

		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("가상서버 생성 가용량");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell titleCell1 = row.createCell(0);	titleCell1.setCellValue( "망" );							titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(1);	titleCell2.setCellValue( "자원풀코드" );					titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(2);	titleCell3.setCellValue( "클러스터" );					titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(3);	titleCell4.setCellValue( "보유량" );				titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(4);	titleCell5.setCellValue( "보유량" );				titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(5);	titleCell6.setCellValue( "최대 할당률" );				titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(6);	titleCell7.setCellValue( "최대 할당률" );				titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(7);	titleCell8.setCellValue( "최대 할당량" );				titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(8);	titleCell9.setCellValue( "최대 할당량" );				titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(9);	titleCell10.setCellValue( "현재 할당량" );				titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(10);	titleCell11.setCellValue( "현재 할당량" );				titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(11);	titleCell12.setCellValue( "여유량" );				titleCell12.setCellStyle(headerStyle);/////
		Cell titleCell13 = row.createCell(12);	titleCell13.setCellValue( "여유량" );				titleCell13.setCellStyle(headerStyle);/////
		Cell titleCell14 = row.createCell(13);	titleCell14.setCellValue( "가상서버 평균사양" );				titleCell14.setCellStyle(headerStyle);/////
		Cell titleCell15 = row.createCell(14);	titleCell15.setCellValue( "가상서버 평균사양" );				titleCell15.setCellStyle(headerStyle);/////
		Cell titleCell16 = row.createCell(15);	titleCell16.setCellValue( "가상서버 할당가능 수량" );				titleCell16.setCellStyle(headerStyle);/////



		row = sheet.createRow(1);
		titleCell1 = row.createCell(0);		titleCell1.setCellValue( "망" );					titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(1);		titleCell2.setCellValue( "자원풀코드" );				titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(2);		titleCell3.setCellValue( "클러스터" );			titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(3);		titleCell4.setCellValue( "Core" );		titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(4);		titleCell5.setCellValue( "MEM" );		titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(5);		titleCell6.setCellValue( "vCore" );		titleCell6.setCellStyle(headerStyle);
		titleCell7 = row.createCell(6);		titleCell7.setCellValue( "MEM" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(7);		titleCell8.setCellValue( "vCore" );		titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(8);		titleCell9.setCellValue( "MEM" );		titleCell9.setCellStyle(headerStyle);
		titleCell10 = row.createCell(9);	titleCell10.setCellValue( "vCore" );		titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(10);	titleCell11.setCellValue( "MEM" );					titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(11);	titleCell12.setCellValue( "vCore" );				titleCell12.setCellStyle(headerStyle);/////
		titleCell13 = row.createCell(12);	titleCell13.setCellValue( "MEM" );				titleCell13.setCellStyle(headerStyle);/////
		titleCell14 = row.createCell(13);	titleCell14.setCellValue( "vCore" );			titleCell14.setCellStyle(headerStyle);/////
		titleCell15 = row.createCell(14);	titleCell15.setCellValue( "MEM" );				titleCell15.setCellStyle(headerStyle);/////
		titleCell16 = row.createCell(15);	titleCell16.setCellValue( "가상서버 할당가능 수량" );					titleCell16.setCellStyle(headerStyle);/////

		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));//망
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));//자원풀코드
		sheet.addMergedRegion(new CellRangeAddress(0,1,2,2));//클러스터
		sheet.addMergedRegion(new CellRangeAddress(0,0,3,4));//보유량
		sheet.addMergedRegion(new CellRangeAddress(0,0,5,6));//최대 할당률
		sheet.addMergedRegion(new CellRangeAddress(0,0,7,8));//최대 할당량
		sheet.addMergedRegion(new CellRangeAddress(0,0,9,10));//현재 할당량
		sheet.addMergedRegion(new CellRangeAddress(0,0,11,12));//여유량
		sheet.addMergedRegion(new CellRangeAddress(0,0,13,14));//가상서버 평균사양
		sheet.addMergedRegion(new CellRangeAddress(0,1,15,15));//가상서버 할당가능 수량


		sheet.addMergedRegion(new CellRangeAddress(1,1,3,3));//core
		sheet.addMergedRegion(new CellRangeAddress(1,1,4,4));//mem
		sheet.addMergedRegion(new CellRangeAddress(1,1,5,5));//vCore
		sheet.addMergedRegion(new CellRangeAddress(1,1,6,6));//MEM
		sheet.addMergedRegion(new CellRangeAddress(1,1,7,7));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,8,8));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,9,9));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,10,10));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,11,11));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,12,12));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,13,13));//SAN
		sheet.addMergedRegion(new CellRangeAddress(1,1,14,14));//SAN


		if(list==null){
			Row dataRow = sheet.createRow(2);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,15));
			list = new ArrayList<UsefulVo>();
		}
		for(int i=0; i<list.size(); i++){
			UsefulVo vo = list.get(i);
			Row dataRow = sheet.createRow(2+i);
				Cell dataCell0 = dataRow.createCell(0);		 dataCell0.setCellValue(vo.getNetNm());
				Cell dataCell1 = dataRow.createCell(1);	     dataCell1.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm()));
				Cell dataCell2 = dataRow.createCell(2);	     dataCell2.setCellValue(DateUtil.stringValueOf(vo.getClstrUuid()));
				Cell dataCell3 = dataRow.createCell(3);	     dataCell3.setCellValue(DateUtil.stringValueOf(vo.getLastCpuCorQty()));
				Cell dataCell4 = dataRow.createCell(4);	     dataCell4.setCellValue(DateUtil.stringValueOf(vo.getLastMemSumCapa()));
				Cell dataCell5 = dataRow.createCell(5);	     dataCell5.setCellValue(DateUtil.stringValueOf(vo.getMaxVcoreAsgnRt()));
				Cell dataCell6 = dataRow.createCell(6);	     dataCell6.setCellValue(DateUtil.stringValueOf(vo.getMaxMemAsgnRt()));
				Cell dataCell7 = dataRow.createCell(7);	     dataCell7.setCellValue(DateUtil.stringValueOf(vo.getMaxVcoreAsgn()));
				Cell dataCell8 = dataRow.createCell(8);	     dataCell8.setCellValue(DateUtil.stringValueOf(vo.getMaxMemAsgn()));
				Cell dataCell9 = dataRow.createCell(9);	     dataCell9.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnVcorQty()));
				Cell dataCell10 = dataRow.createCell(10);	 dataCell10.setCellValue(DateUtil.stringValueOf(vo.getLastAsgnMemCapa()));
				Cell dataCell11 = dataRow.createCell(11);    dataCell11.setCellValue(DateUtil.stringValueOf(vo.getMarginVcoreCapa()));
				Cell dataCell12 = dataRow.createCell(12);	 dataCell12.setCellValue(DateUtil.stringValueOf(vo.getMarginMemCapa()));
				Cell dataCell13 = dataRow.createCell(13);	 dataCell13.setCellValue(DateUtil.stringValueOf(vo.getVmVcoreAvgSpec()));
				Cell dataCell14 = dataRow.createCell(14);	 dataCell14.setCellValue(DateUtil.stringValueOf(vo.getVmMemAvgSpec()));
				Cell dataCell15 = dataRow.createCell(15);	 dataCell15.setCellValue(DateUtil.stringValueOf(vo.getVmAsgnQty()));


		}


		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(("가상서버 생성 가용량").getBytes("KSC5601"),"8859_1")+"_"+DateUtil.getCurrentDate() + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();


    }
	/**
	 * 가상서버 생성 가용량 삭제
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteUseful.do")
	@OperateLog(action="가상서버 생성 가용량 삭제", desc="가상서버 생성 가용량을 삭제한다.",		params={"rsrcPoolId","ym","clstrSeq"}, actionType=ActionType.UPDATE)
	public  @ResponseBody ProcResultVo deleteUseful(
			@RequestBody List<UsefulVo> voList ,
			HttpServletRequest request,
			Model model) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("delete");
		result.setSuccess(true);
		try{
			usefulService.deleteUseful(voList);
		}catch(Exception e){
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}

		return result;
	}


	/**
	 * 가상서버 생성 가용량 입력 또는 수정
	 * @param request
	 * @param model
	 * @param WthdrwStVo
	 * @return
	 */
	@RequestMapping(value="/insertUseful.do", method=RequestMethod.POST)
	@OperateLog(action="가상서버 생성 가용량 등록 수정", desc="가상서버 생성 가용량을 등록 수정 한다.",	params={"rsrcPoolId","ym","clstrSeq"}, actionType=ActionType.UPDATE)

	public @ResponseBody ProcResultVo insertUseful(HttpServletRequest request, Model model, @RequestBody List<UsefulVo> insertVoList) throws Exception{
		ProcResultVo result = new ProcResultVo();
		result.setProcType("insert");
		result.setSuccess(true);
		try{
			usefulService.insertUseful(insertVoList);
		}catch(Exception e){
			result.setSuccess(false);
			result.addMessage(e.getMessage());
		}
		return result;
	}
}
