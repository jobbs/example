/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OprStatController.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 12. 7.
 * @lastmodified 2017. 12. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 12. 7.     selim         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.web;

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
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.etc.service.OprStatService;
import ncis.dsb.stts.etc.vo.OprStatSearchVo;
import ncis.dsb.stts.etc.vo.PmStatInfoVo;
import ncis.dsb.stts.etc.vo.PoolStatInfoVo;
import ncis.dsb.stts.etc.vo.VmStatInfoVo;

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
 * @author ihjang
 *
 */

@Controller("oprStatController")
@RequestMapping("/dsb/stts/etc/oprStat")
public class OprStatController extends BaseController
{

	@Resource(name = "oprStatService")
	OprStatService oprStatService;

    @Resource(name = "rsrcPoolService")
    RsrcPoolService rsrcPoolService;

	/**
	 * 운영요청 통계 조회 조건 화면
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectOprStatListP.do")
	public String selectOprStatListP(HttpServletRequest request, Model model , OprStatSearchVo searchVo, HttpServletResponse response) throws Exception
	{
		if( null == searchVo)
		{
			searchVo = new OprStatSearchVo();
		}

		if(searchVo.getSearchTrmCd() == null)
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}


		List<RsrcPoolVo> list = rsrcPoolService.selectRsrcPoolList(searchVo);

        model.addAttribute("title", "자원풀 정보");
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
        model.addAttribute("list", list);

		return popup(request);
	}

	/**
	 * 요청 페이지 증가량
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectOprStatXlsDown.do")
	public void selectOprStatXlsDown(HttpServletRequest request, Model model, OprStatSearchVo searchVo, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, IOException, Exception
	{
		String fileNm = null;
		String searchPeriod = null;
		String currentDate = DateUtil.getCurrentDate("yyyy.MM.dd");
		String currentDate2 = DateUtil.getCurrentDate("yyyyMMdd");

		if( null == searchVo)
		{
			searchVo = new OprStatSearchVo();
		}

		if(searchVo.getSearchTrmCd() == null)
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}

		if(searchVo.getSearchTrmCd().equals("DD"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getDate()+"_"+currentDate2;
			searchPeriod = searchVo.getDate();
		}
		else if(searchVo.getSearchTrmCd().equals("MM"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getSearchMmCd()+"_"+currentDate2;
			searchPeriod = searchVo.getSearchMmCd()+"월";
		}
		else if(searchVo.getSearchTrmCd().equals("QQ"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getSearchQqCd()+"_"+currentDate2;
			searchPeriod = searchVo.getSearchQqCd()+"분기";
		}
		else if(searchVo.getSearchTrmCd().equals("HH"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getSearchHhCd()+"_"+currentDate2;
			searchPeriod = searchVo.getSearchHhCd()+"분기";
		}
		else if(searchVo.getSearchTrmCd().equals("YY"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getYear()+"_"+currentDate2;
			searchPeriod = searchVo.getYear()+"년";
		}
		else if(searchVo.getSearchTrmCd().equals("DI"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getStrtDt() +"_"+searchVo.getEndDt()+"_"+currentDate2;
			searchPeriod = searchVo.getStrtDt() +"~"+searchVo.getEndDt();
		}

		List<PoolStatInfoVo> poolList = null;
		List<VmStatInfoVo> vmList = null;
		List<PmStatInfoVo> pmList = null;

		poolList = oprStatService.selectOprStatPoolList(searchVo);
		vmList = oprStatService.selectOprStatVmList(searchVo);
		pmList = oprStatService.selectOprStatPmList(searchVo);

		// CusomSheet 생성
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet1 = workBook.createSheet("월간 현황 보고 양식");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setWrapText(true);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

        CellStyle headerStyle2 = workBook.createCellStyle();
        headerStyle2.setAlignment(CellStyle.ALIGN_RIGHT);


		Row row = sheet1.createRow(0);
		Cell titleNameCell1 = row.createCell(0);	titleNameCell1.setCellValue( "G-클라우드 시스템 자원풀별 운영현황("+searchPeriod+")" );	titleNameCell1.setCellStyle(headerStyle);

		row = sheet1.createRow(1);

		Cell defaultDayCell0 = row.createCell(0);	defaultDayCell0.setCellValue( currentDate+" 기준");		defaultDayCell0.setCellStyle(headerStyle2);
		Cell defaultDayCell17 = row.createCell(16);	defaultDayCell17.setCellValue( currentDate+" 기준");	defaultDayCell17.setCellStyle(headerStyle2);


		row = sheet1.createRow(2);
		Cell titleCell0 = row.createCell(0);	titleCell0.setCellValue( "구분" );		titleCell0.setCellStyle(headerStyle);
		Cell titleCell1 = row.createCell(1);	titleCell1.setCellValue( "가상화종류" );			titleCell1.setCellStyle(headerStyle);
		Cell titleCell2 = row.createCell(2);	titleCell2.setCellValue( "망구분" );			titleCell2.setCellStyle(headerStyle);
		Cell titleCell3 = row.createCell(3);	titleCell3.setCellValue( "구축년도" );		titleCell3.setCellStyle(headerStyle);
		Cell titleCell4 = row.createCell(4);	titleCell4.setCellValue( "물리서버수" );	titleCell4.setCellStyle(headerStyle);
		Cell titleCell5 = row.createCell(5);	titleCell5.setCellValue( "가상서버수" );	titleCell5.setCellStyle(headerStyle);
		Cell titleCell6 = row.createCell(6);	titleCell6.setCellValue( "가상화율(%)" );		titleCell6.setCellStyle(headerStyle);
		Cell titleCell7 = row.createCell(7);	titleCell7.setCellValue( "보유량" );		titleCell7.setCellStyle(headerStyle);
		Cell titleCell8 = row.createCell(8);	titleCell8.setCellValue( "보유량" );		titleCell8.setCellStyle(headerStyle);
		Cell titleCell9 = row.createCell(9);	titleCell9.setCellValue( "보유량" );		titleCell9.setCellStyle(headerStyle);
		Cell titleCell10 = row.createCell(10);	titleCell10.setCellValue( "할당량" );	titleCell10.setCellStyle(headerStyle);
		Cell titleCell11 = row.createCell(11);	titleCell11.setCellValue( "할당량" );		titleCell11.setCellStyle(headerStyle);
		Cell titleCell12 = row.createCell(12);	titleCell12.setCellValue( "할당량" );		titleCell12.setCellStyle(headerStyle);
		Cell titleCell13 = row.createCell(13);	titleCell13.setCellValue( "할당률(%)" );		titleCell13.setCellStyle(headerStyle);
		Cell titleCell14 = row.createCell(14);	titleCell14.setCellValue( "할당률(%)" );		titleCell14.setCellStyle(headerStyle);
		Cell titleCell15 = row.createCell(15);	titleCell15.setCellValue( "할당률(%)" );		titleCell15.setCellStyle(headerStyle);
		Cell titleCell16 = row.createCell(16);	titleCell16.setCellValue( "비고" );		titleCell16.setCellStyle(headerStyle);

		row = sheet1.createRow(3);
		titleCell0 = row.createCell(0);	titleCell0.setCellValue( "구분" );		titleCell0.setCellStyle(headerStyle);
		titleCell1 = row.createCell(1);	titleCell1.setCellValue( "가상화종류" );			titleCell1.setCellStyle(headerStyle);
		titleCell2 = row.createCell(2);	titleCell2.setCellValue( "망구분" );			titleCell2.setCellStyle(headerStyle);
		titleCell3 = row.createCell(3);	titleCell3.setCellValue( "구축년도" );		titleCell3.setCellStyle(headerStyle);
		titleCell4 = row.createCell(4);	titleCell4.setCellValue( "물리서버수" );	titleCell4.setCellStyle(headerStyle);
		titleCell5 = row.createCell(5);	titleCell5.setCellValue( "가상서버수" );	titleCell5.setCellStyle(headerStyle);
		titleCell6 = row.createCell(6);	titleCell6.setCellValue( "가상화율(%)" );		titleCell6.setCellStyle(headerStyle);

		titleCell7 = row.createCell(7);	titleCell7.setCellValue( "CPU(vCore)" );		titleCell7.setCellStyle(headerStyle);
		titleCell8 = row.createCell(8);	titleCell8.setCellValue( "MEM(GB)" );		titleCell8.setCellStyle(headerStyle);
		titleCell9 = row.createCell(9);	titleCell9.setCellValue( "SAN(TB)" );		titleCell9.setCellStyle(headerStyle);

		titleCell10 = row.createCell(10);	titleCell10.setCellValue( "CPU(vCore)" );		titleCell10.setCellStyle(headerStyle);
		titleCell11 = row.createCell(11);	titleCell11.setCellValue( "MEM(GB)" );		titleCell11.setCellStyle(headerStyle);
		titleCell12 = row.createCell(12);	titleCell12.setCellValue( "SAN(TB)" );		titleCell12.setCellStyle(headerStyle);

		titleCell13 = row.createCell(13);	titleCell13.setCellValue( "CPU" );		titleCell13.setCellStyle(headerStyle);
		titleCell14 = row.createCell(14);	titleCell14.setCellValue( "MEM" );		titleCell14.setCellStyle(headerStyle);
		titleCell15 = row.createCell(15);	titleCell15.setCellValue( "SAN" );		titleCell15.setCellStyle(headerStyle);

		titleCell16 = row.createCell(16);	titleCell16.setCellValue( "비고" );		titleCell16.setCellStyle(headerStyle);

		sheet1.addMergedRegion(new CellRangeAddress(0,0,0,16));//타이틀
		sheet1.addMergedRegion(new CellRangeAddress(1,1,0,16));//기준일자
		sheet1.addMergedRegion(new CellRangeAddress(2,3,0,0));//구분
		sheet1.addMergedRegion(new CellRangeAddress(2,3,1,1));//가상화종류
		sheet1.addMergedRegion(new CellRangeAddress(2,3,2,2));//망구분
		sheet1.addMergedRegion(new CellRangeAddress(2,3,3,3));//구축년도
		sheet1.addMergedRegion(new CellRangeAddress(2,3,4,4));//물리서버수
		sheet1.addMergedRegion(new CellRangeAddress(2,3,5,5));//가상서버수
		sheet1.addMergedRegion(new CellRangeAddress(2,3,6,6));//가상화율
		sheet1.addMergedRegion(new CellRangeAddress(2,2,7,9));//보유량
		sheet1.addMergedRegion(new CellRangeAddress(2,2,10,12));//할당량
		sheet1.addMergedRegion(new CellRangeAddress(2,2,13,15));//할당률
		sheet1.addMergedRegion(new CellRangeAddress(2,3,16,16));//비고

		for(int i = 0 ; i < 17 ;i++)
		{
			sheet1.autoSizeColumn(i);
			sheet1.setColumnWidth(i, (sheet1.getColumnWidth(i) + 1024 ) );
		}

		PoolStatInfoVo vo = null;

		Row dataRow = null;
		if( null == poolList || poolList.size() == 0){
			Row tmpRow = sheet1.createRow(4);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet1.addMergedRegion(new CellRangeAddress(4,4,0,16));
			poolList = new ArrayList<PoolStatInfoVo>();
		}
		else
		{
			int rowCnt = 4;
			PoolStatInfoVo totalVo = new PoolStatInfoVo();
			for(int i=0; i < poolList.size(); i++){
				vo = poolList.get(i);
				dataRow = sheet1.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(vo.getRegionNm());  // 구분
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(vo.getVirtualType()); // 가상화종류
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(vo.getNetNm()); // 망구분
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue("");  // 구축년도
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(vo.getPmCnt()); // 물리서버수
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(vo.getVmCnt()); // 가상서버수

				Cell dataCell6 = dataRow.createCell(6);		dataCell6.setCellValue(DateUtil.stringValueOf(vo.getVirtRate())); // 가상화율

				Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(DateUtil.stringValueOf(vo.getTotVcore())); // CPU 보유량
				Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(DateUtil.stringValueOf(vo.getTotMem())); // MEM 보유량
				Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(DateUtil.stringValueOf(vo.getTotStrg()));  // SAN 보유량

				Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(vo.getAsgnVcore())); // CPU 할당량
				Cell dataCell11 = dataRow.createCell(11); 	dataCell11.setCellValue(DateUtil.stringValueOf(vo.getAsgnMem())); // MEM 할당량

				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vo.getAsgnStrg())); // SAN 할당량

				Cell dataCell13 = dataRow.createCell(13);   dataCell13.setCellValue(DateUtil.stringValueOf(vo.getAsgnVcoreRate())); // CPU 할당률
				Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vo.getAsgnMemRate())); // MEM 할당률
				Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vo.getAsgnStrgRate())); // SAN 할당률

				Cell dataCell16 = dataRow.createCell(16);	 dataCell16.setCellValue(DateUtil.stringValueOf(vo.getRsrcPoolNm())); // 비고 ( 자원풀 명 )

				if(!StringUtils.isEmpty(totalVo.getRegionNm()) && !totalVo.getRegionNm().equals(vo.getRegionNm()))
				{
					// 소계
					rowCnt++;
					dataRow = sheet1.createRow(rowCnt + i );

					Cell totalCell0 = dataRow.createCell(0);	 	totalCell0.setCellValue(totalVo.getRegionNm());
					Cell totalCell1 = dataRow.createCell(1);	 	totalCell1.setCellValue("소계");
					Cell totalCell2 = dataRow.createCell(2);	 	totalCell2.setCellValue("소계");
					Cell totalCell3 = dataRow.createCell(3);	 	totalCell3.setCellValue("소계");
					Cell totalCell4 = dataRow.createCell(4);	 	totalCell4.setCellValue(totalVo.getPmCnt());
					Cell totalCell5 = dataRow.createCell(5);	 	totalCell5.setCellValue(totalVo.getVmCnt());

					Cell totalCell6 = dataRow.createCell(6);		totalCell6.setCellValue(DateUtil.stringValueOf(totalVo.getVirtRate()));

					Cell totalCell7 = dataRow.createCell(7);	 	totalCell7.setCellValue(DateUtil.stringValueOf(totalVo.getTotVcore()));
					Cell totalCell8 = dataRow.createCell(8);	 	totalCell8.setCellValue(DateUtil.stringValueOf(totalVo.getTotMem()));
					Cell totalCell9 = dataRow.createCell(9);	 	totalCell9.setCellValue(DateUtil.stringValueOf(totalVo.getTotStrg()));

					Cell totalCell10 = dataRow.createCell(10);		totalCell10.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnVcore()));
					Cell totalCell11 = dataRow.createCell(11); 		totalCell11.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnMem()));
					Cell totalCell12 = dataRow.createCell(12);	 	totalCell12.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnStrg()));

					Cell totalCell13 = dataRow.createCell(13); 		totalCell13.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnVcoreRate()));
					Cell totalCell14 = dataRow.createCell(14); 		totalCell14.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnMemRate()));
					Cell totalCell15 = dataRow.createCell(15); 		totalCell15.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnStrgRate()));

					Cell totalCell16 = dataRow.createCell(16);	 	totalCell16.setCellValue("");

					sheet1.addMergedRegion(new CellRangeAddress(rowCnt+i,rowCnt+i,1,3));//타이틀
					sheet1.addMergedRegion(new CellRangeAddress(rowCnt,rowCnt+i,0,0));//타이틀

					// 소계 초기화
					totalVo = new PoolStatInfoVo();
				}

				totalVo.setRegionNm(vo.getRegionNm());
				totalVo.addPmCnt(vo.getPmCnt());
				totalVo.addVmCnt(vo.getVmCnt());

				totalVo.addTotVcore(vo.getTotVcore());
				totalVo.addTotMem(vo.getTotMem());
				totalVo.addTotStrg(vo.getTotStrg());

				totalVo.addAsgnVcore(vo.getAsgnVcore());
				totalVo.addAsgnMem(vo.getAsgnMem());
				totalVo.addAsgnStrg(vo.getAsgnStrg());
			}

			if( !StringUtils.isEmpty(totalVo.getRegionNm()) )
			{
				// 소계
				rowCnt += poolList.size();
				dataRow = sheet1.createRow( rowCnt );

				Cell totalCell0 = dataRow.createCell(0);	 	totalCell0.setCellValue(totalVo.getRegionNm());
				Cell totalCell1 = dataRow.createCell(1);	 	totalCell1.setCellValue("소계");
				Cell totalCell2 = dataRow.createCell(2);	 	totalCell2.setCellValue("소계");
				Cell totalCell3 = dataRow.createCell(3);	 	totalCell3.setCellValue("소계");
				Cell totalCell4 = dataRow.createCell(4);	 	totalCell4.setCellValue(totalVo.getPmCnt());
				Cell totalCell5 = dataRow.createCell(5);	 	totalCell5.setCellValue(totalVo.getVmCnt());
				Cell totalCell6 = dataRow.createCell(6);		totalCell6.setCellValue(DateUtil.stringValueOf(totalVo.getVirtRate()));

				Cell totalCell7 = dataRow.createCell(7);	 	totalCell7.setCellValue(DateUtil.stringValueOf(totalVo.getTotVcore()));
				Cell totalCell8 = dataRow.createCell(8);	 	totalCell8.setCellValue(DateUtil.stringValueOf(totalVo.getTotMem()));
				Cell totalCell9 = dataRow.createCell(9);	 	totalCell9.setCellValue(DateUtil.stringValueOf(totalVo.getTotStrg()));

				Cell totalCell10 = dataRow.createCell(10);	totalCell10.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnVcore()));
				Cell totalCell11 = dataRow.createCell(11); 	totalCell11.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnMem()));
				Cell totalCell12 = dataRow.createCell(12);	 totalCell12.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnStrg()));

				Cell totalCell13 = dataRow.createCell(13); totalCell13.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnVcoreRate()));
				Cell totalCell14 = dataRow.createCell(14); totalCell14.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnMemRate()));
				Cell totalCell15 = dataRow.createCell(15); totalCell15.setCellValue(DateUtil.stringValueOf(totalVo.getAsgnStrgRate()));

				Cell totalCell16 = dataRow.createCell(16);	 totalCell16.setCellValue("");

				sheet1.addMergedRegion(new CellRangeAddress(rowCnt,rowCnt,1,3));//타이틀
				sheet1.addMergedRegion(new CellRangeAddress(rowCnt,rowCnt,0,0));//타이틀
			}
		}

		// 두번째 Sheet setting
		Sheet sheet2 = workBook.createSheet("월간&분기별 요구자료(가상서버)");

		row = sheet2.createRow(0);
		Cell vmTitleCell1 = row.createCell(0);		vmTitleCell1.setCellValue( "센터\r\n구분" );				vmTitleCell1.setCellStyle(headerStyle);
		Cell vmTitleCell2 = row.createCell(1);		vmTitleCell2.setCellValue( "가상서버\r\n구성ID" );			vmTitleCell2.setCellStyle(headerStyle);
		Cell vmTitleCell3 = row.createCell(2);		vmTitleCell3.setCellValue( "기관명" );					vmTitleCell3.setCellStyle(headerStyle);
		Cell vmTitleCell4 = row.createCell(3);		vmTitleCell4.setCellValue( "업무명" );					vmTitleCell4.setCellStyle(headerStyle);
		Cell vmTitleCell5 = row.createCell(4);		vmTitleCell5.setCellValue( "가상서버 ID" );				vmTitleCell5.setCellStyle(headerStyle);
		Cell vmTitleCell6 = row.createCell(5);		vmTitleCell6.setCellValue( "가상서버명" );				vmTitleCell6.setCellStyle(headerStyle);
		Cell vmTitleCell7 = row.createCell(6);		vmTitleCell7.setCellValue( "Zone" );				vmTitleCell7.setCellStyle(headerStyle);
		Cell vmTitleCell8 = row.createCell(7);		vmTitleCell8.setCellValue( "생성일자" );				vmTitleCell8.setCellStyle(headerStyle);
		Cell vmTitleCell9 = row.createCell(8);		vmTitleCell9.setCellValue( "VM운영부서" );				vmTitleCell9.setCellStyle(headerStyle);
		Cell vmTitleCell10 = row.createCell(9);		vmTitleCell10.setCellValue( "VM운영담당자\r\n(공무원)" );	vmTitleCell10.setCellStyle(headerStyle);
		Cell vmTitleCell11 = row.createCell(10);	vmTitleCell11.setCellValue( "VM운영사업자\r\n(위탁운영자)");vmTitleCell11.setCellStyle(headerStyle);
//		Cell vmTitleCell12 = row.createCell(11);	vmTitleCell12.setCellValue( "vCore 평균할당량" );		vmTitleCell12.setCellStyle(headerStyle);
//		Cell vmTitleCell13 = row.createCell(12);	vmTitleCell13.setCellValue( "vCore 현재할당량" );		vmTitleCell13.setCellStyle(headerStyle);
//		Cell vmTitleCell14 = row.createCell(13);	vmTitleCell14.setCellValue( "MEM 평균할당량(GB)" );		vmTitleCell14.setCellStyle(headerStyle);
//		Cell vmTitleCell15 = row.createCell(14);	vmTitleCell15.setCellValue( "MEM 현재할당량(GB)" );		vmTitleCell15.setCellStyle(headerStyle);
//		Cell vmTitleCell16 = row.createCell(15);	vmTitleCell16.setCellValue( "SAN 평균할당량(GB)" );		vmTitleCell16.setCellStyle(headerStyle);
//		Cell vmTitleCell17 = row.createCell(16);	vmTitleCell17.setCellValue( "SAN 현재할당량(GB)" );		vmTitleCell17.setCellStyle(headerStyle);
//		Cell vmTitleCell18 = row.createCell(17);	vmTitleCell18.setCellValue( "vCore 최빈시평균사용률(%)");	vmTitleCell18.setCellStyle(headerStyle);
//		Cell vmTitleCell19 = row.createCell(18);	vmTitleCell19.setCellValue( "MEM 최빈시 평균사용률(%)");	vmTitleCell19.setCellStyle(headerStyle);
//		Cell vmTitleCell20 = row.createCell(19);	vmTitleCell20.setCellValue( "SAN 최빈시 평균사용률(%)");	vmTitleCell20.setCellStyle(headerStyle);
//		Cell vmTitleCell21 = row.createCell(20);	vmTitleCell21.setCellValue( "SAN 최빈시 평균사용량(GB)");	vmTitleCell21.setCellStyle(headerStyle);
//		Cell vmTitleCell22 = row.createCell(21);	vmTitleCell22.setCellValue( "vCore 최대사용률(%)");		vmTitleCell22.setCellStyle(headerStyle);
//		Cell vmTitleCell23 = row.createCell(22);	vmTitleCell23.setCellValue( "MEM 최대사용률(%)" );		vmTitleCell23.setCellStyle(headerStyle);
//		Cell vmTitleCell24 = row.createCell(23);	vmTitleCell24.setCellValue( "SAN 최대사용률 (%)" );		vmTitleCell24.setCellStyle(headerStyle);
//		Cell vmTitleCell25 = row.createCell(24);	vmTitleCell25.setCellValue( "SAN 최대사용량(GB)" );		vmTitleCell25.setCellStyle(headerStyle);

		Cell vmTitleCell12 = row.createCell(11);	vmTitleCell12.setCellValue( "vCore\r\n할당량" );		vmTitleCell12.setCellStyle(headerStyle);
		Cell vmTitleCell13 = row.createCell(12);	vmTitleCell13.setCellValue( "MEM\r\n할당량(GB)" );		vmTitleCell13.setCellStyle(headerStyle);
		Cell vmTitleCell14 = row.createCell(13);	vmTitleCell14.setCellValue( "SAN\r\n할당량(GB)" );		vmTitleCell14.setCellStyle(headerStyle);
		Cell vmTitleCell15 = row.createCell(14);	vmTitleCell15.setCellValue( "vCore\r\n평균사용률(%)" );		vmTitleCell15.setCellStyle(headerStyle);
		Cell vmTitleCell16 = row.createCell(15);	vmTitleCell16.setCellValue( "MEM\r\n평균사용률(%)" );		vmTitleCell16.setCellStyle(headerStyle);
		Cell vmTitleCell17 = row.createCell(16);	vmTitleCell17.setCellValue( "vCore\r\n최대사용률(%)" );		vmTitleCell17.setCellStyle(headerStyle);
		Cell vmTitleCell18 = row.createCell(17);	vmTitleCell18.setCellValue( "MEM\r\n최대사용률(%)");	vmTitleCell18.setCellStyle(headerStyle);

		for(int i = 0 ; i < 19  ;i++)
		{
			sheet2.autoSizeColumn(i);
			sheet2.setColumnWidth(i, (sheet2.getColumnWidth(i) + 1024 ) );
		}


		VmStatInfoVo vmVo = null;
		if(null == vmList || vmList.size() == 0){
			Row tmpRow = sheet2.createRow(1);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet2.addMergedRegion(new CellRangeAddress(1,1,0,24));
		}
		else
		{
			dataRow = null;
			int rowCnt = 1;
			for(int i=0; i<vmList.size(); i++){
				vmVo = vmList.get(i);
				dataRow = sheet2.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(vmVo.getRegionNm()); // 센터구분
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(vmVo.getVmConfId()); // 가상서버 구성 ID
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(vmVo.getInstitutionNm()); // 기관명
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(vmVo.getJobNm()); // 업무명
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(vmVo.getVmId()); // 가상서버 ID
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(vmVo.getVmNm()); // 가상서버명
				Cell dataCell6 = dataRow.createCell(6);	 	dataCell6.setCellValue(vmVo.getZoneNm()); // Zone 이름
				Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(vmVo.getCreDt()); // 생성일자

				Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(vmVo.getOprNm()); // VM 운영부서
				Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(vmVo.getOprUserNm()); // VM 운영담당자
				Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(vmVo.getOprUser2Nm()); // VM 운영사업자

//				Cell dataCell11 = dataRow.createCell(11); 	dataCell11.setCellValue(DateUtil.stringValueOf(vmVo.getAvgCpuVcorQty()));  // vCore 평균할당량
//				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnVcorQty())); // vCore 현재할당량
//				Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(DateUtil.stringValueOf(vmVo.getAvgMemCapa()));  // MEM 평균할당량
//				Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnMemCapa())); // MEM 현재 할당량
//				Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vmVo.getAvgStrgCapa())); // SAN 평균할당량
//				Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnStrgCapa())); // SAN 현재할당량
//
//				Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vmVo.getBuzAsgnVcorQtyRat())); // vCore 최빈시 평균사용률
//				Cell dataCell18 = dataRow.createCell(18);	dataCell18.setCellValue(DateUtil.stringValueOf(vmVo.getBuzAsgnMemCapaRat())); // MEM 최빈시 평균사용률
//				Cell dataCell19 = dataRow.createCell(19);	dataCell19.setCellValue(DateUtil.stringValueOf(vmVo.getBuzAsgnStrgCapaRat())); // SAN 최빈시 평균사용률
//				Cell dataCell20 = dataRow.createCell(20);	dataCell20.setCellValue(DateUtil.stringValueOf(vmVo.getBuzAsgnStrgCapa()));  // SAN 최빈시 평균샤용량
//
//				Cell dataCell21 = dataRow.createCell(21);	dataCell21.setCellValue(DateUtil.stringValueOf(vmVo.getMaxAsgnVcorQtyRat())); // vCore 최대사용률
//				Cell dataCell22 = dataRow.createCell(22);	dataCell22.setCellValue(DateUtil.stringValueOf(vmVo.getMaxAsgnMemCapaRat())); // MEM 최대사용률
//				Cell dataCell23 = dataRow.createCell(23);	dataCell23.setCellValue(DateUtil.stringValueOf(vmVo.getMaxAsgnStrgCapaRat())); // SAN 최대사용율
//				Cell dataCell24 = dataRow.createCell(24);	dataCell24.setCellValue(DateUtil.stringValueOf(vmVo.getBuzAsgnStrgCapa())); // SAN 최대사용량

				Cell dataCell11 = dataRow.createCell(11); 	dataCell11.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnVcorQty()));  // vCore 할당량
				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnMemCapa())); // MEM 할당량
				Cell dataCell13 = dataRow.createCell(13);	dataCell13.setCellValue(DateUtil.stringValueOf(vmVo.getAvgAsgnStrgCapa()));  // SAN 할당량

				Cell dataCell14 = dataRow.createCell(14);	dataCell14.setCellValue(DateUtil.stringValueOf(vmVo.getAvgVcorQtyRat())); // vCore 평균사용률
				Cell dataCell15 = dataRow.createCell(15);	dataCell15.setCellValue(DateUtil.stringValueOf(vmVo.getAvgMemCapaRat())); // MEM 평균사용률

				Cell dataCell16 = dataRow.createCell(16);	dataCell16.setCellValue(DateUtil.stringValueOf(vmVo.getMaxAsgnVcorQtyRat())); // vCore 최대사용률
				Cell dataCell17 = dataRow.createCell(17);	dataCell17.setCellValue(DateUtil.stringValueOf(vmVo.getMaxAsgnMemCapaRat())); // MEM 최대사용률
			}
		}



		// 세번째 Sheet setting
		Sheet sheet3 = workBook.createSheet("월간&분기별 요구자료(물리서버)");

		row = sheet3.createRow(0);
		Cell pmTitleCell0 = row.createCell(0);	pmTitleCell0.setCellValue( "센터구분" );		pmTitleCell0.setCellStyle(headerStyle);
		Cell pmTitleCell1 = row.createCell(1);	pmTitleCell1.setCellValue( "물리서버\r\n구성ID" );			pmTitleCell1.setCellStyle(headerStyle);
		Cell pmTitleCell2 = row.createCell(2);	pmTitleCell2.setCellValue( "Zone명" );			pmTitleCell2.setCellStyle(headerStyle);
		Cell pmTitleCell3 = row.createCell(3);	pmTitleCell3.setCellValue( "클러스터" );		pmTitleCell3.setCellStyle(headerStyle);
		Cell pmTitleCell4 = row.createCell(4);	pmTitleCell4.setCellValue( "CPU\r\n평균보유량" );	pmTitleCell4.setCellStyle(headerStyle);
		Cell pmTitleCell5 = row.createCell(5);	pmTitleCell5.setCellValue( "MEM\r\n평균보유량(GB)" );	pmTitleCell5.setCellStyle(headerStyle);
//		Cell pmTitleCell6 = row.createCell(6);	pmTitleCell6.setCellValue( "vCore 평균할당량" );		pmTitleCell6.setCellStyle(headerStyle);
//		Cell pmTitleCell7 = row.createCell(7);	pmTitleCell7.setCellValue( "MEM 평균할당량(GB)" );		pmTitleCell7.setCellStyle(headerStyle);
//		Cell pmTitleCell8 = row.createCell(8);	pmTitleCell8.setCellValue( "vCore 최빈시 평균사용률" );		pmTitleCell8.setCellStyle(headerStyle);
//		Cell pmTitleCell9 = row.createCell(9);	pmTitleCell9.setCellValue( "MEM 최빈시 평균사용률" );		pmTitleCell9.setCellStyle(headerStyle);
//		Cell pmTitleCell10 = row.createCell(10);	pmTitleCell10.setCellValue( "vCore 최대사용률" );	pmTitleCell10.setCellStyle(headerStyle);
//		Cell pmTitleCell11 = row.createCell(11);	pmTitleCell11.setCellValue( "MEM 최대사용률" );		pmTitleCell11.setCellStyle(headerStyle);
//		Cell pmTitleCell12 = row.createCell(12);	pmTitleCell12.setCellValue( "비고" );		pmTitleCell12.setCellStyle(headerStyle);

		Cell pmTitleCell6 = row.createCell(6);	pmTitleCell6.setCellValue( "vCore\r\n평균사용률" );		pmTitleCell6.setCellStyle(headerStyle);
		Cell pmTitleCell7 = row.createCell(7);	pmTitleCell7.setCellValue( "MEM\r\n평균사용률" );		pmTitleCell7.setCellStyle(headerStyle);
		Cell pmTitleCell8 = row.createCell(8);	pmTitleCell8.setCellValue( "vCore\r\n최대사용률" );		pmTitleCell8.setCellStyle(headerStyle);
		Cell pmTitleCell9 = row.createCell(9);	pmTitleCell9.setCellValue( "MEM\r\n최대사용률" );		pmTitleCell9.setCellStyle(headerStyle);
		Cell pmTitleCell10 = row.createCell(10);	pmTitleCell10.setCellValue( "비고" );	pmTitleCell10.setCellStyle(headerStyle);

		for(int i = 0 ; i < 11  ;i++)
		{
			sheet3.autoSizeColumn(i);
			sheet3.setColumnWidth(i, (sheet3.getColumnWidth(i) + 1024 ));
		}


		PmStatInfoVo pmVo = null;
		if(null == pmList || pmList.size() == 0){
			Row tmpRow = sheet3.createRow(1);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet3.addMergedRegion(new CellRangeAddress(1,1,0,11));
			poolList = new ArrayList<PoolStatInfoVo>();
		}
		else
		{
			dataRow = null;
			int rowCnt = 1;
			for(int i=0; i<pmList.size(); i++){
				pmVo = pmList.get(i);
				dataRow = sheet3.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(pmVo.getRegionNm()); // 센터구분
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(pmVo.getPmCompId()); // 물리서버 구성 ID
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(pmVo.getZoneNm()); // Zone
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(pmVo.getClstrNm()); // 자원풀명
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(DateUtil.stringValueOf(pmVo.getAvgVcorQty())); // CPU 평균보유량
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(DateUtil.stringValueOf(pmVo.getAvgMemCapa())); // MEM 평균보유량
//				Cell dataCell6 = dataRow.createCell(6);	 	dataCell6.setCellValue(DateUtil.stringValueOf(pmVo.getAvgAsgnVcorQty())); // vCore 평균 할당량
//				Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(DateUtil.stringValueOf(pmVo.getAvgAsgnMemCapa())); // MEM 평균 할당량
//				Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(DateUtil.stringValueOf(pmVo.getBuzAvgCpuUseRt())); // vCore 최빈시 평균 사용률
//				Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(DateUtil.stringValueOf(pmVo.getBuzAvgMemUseRt())); // MEM 최빈시 평균사용률
//				Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgCpuUseRt())); // vCore 최대 사용률
//				Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgMemUseRt())); // MEM 최대사용률
//				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(pmVo.getRmk())); // 비고

				Cell dataCell6 = dataRow.createCell(6);	 	dataCell6.setCellValue(DateUtil.stringValueOf(pmVo.getAvgCpuUseRt())); // vCore 평균 사용률
				Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(DateUtil.stringValueOf(pmVo.getAvgMemUseRt())); // MEM 평균 사용률
				Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgCpuUseRt())); // vCore 최대 사용률
				Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgMemUseRt())); // MEM 최대 사용률
				Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(pmVo.getRmk())); // 비고
			}
		}

		// Excel 생성
		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}

	/**
	 * 물리서버 최소
	 *
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectOprStatHvMinXlsDown.do")
	public void selectOprStatPmMinXlsDown(HttpServletRequest request, Model model, OprStatSearchVo searchVo, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, IOException, Exception
	{

		String fileNm = null;
		String currentDate = DateUtil.getCurrentDate("yyyyMMdd");

		if( null == searchVo)
		{
			searchVo = new OprStatSearchVo();
		}

		if(searchVo.getSearchTrmCd() == null)
		{
			searchVo.setSearchTrmCd("DD");
			searchVo.setDate(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}

		if(searchVo.getSearchTrmCd().equals("DD"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getDate()+"_최소_"+currentDate;
		}
		else if(searchVo.getSearchTrmCd().equals("MM"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getSearchMmCd()+"_최소_"+currentDate;
		}
		else if(searchVo.getSearchTrmCd().equals("QQ"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getQuarterCd()+"_최소_"+currentDate;
		}
		else if(searchVo.getSearchTrmCd().equals("YY"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getYear()+"_최소_"+currentDate;
		}
		else if(searchVo.getSearchTrmCd().equals("DI"))
		{
			fileNm = "G-CMS2_기간별통계_"+searchVo.getStrtDt() +"_최소_"+currentDate;
		}

		List<PmStatInfoVo> list = null;

		list = oprStatService.selectOprStatPmMinList(searchVo);
		if (list == null)
		{
			list = new ArrayList<PmStatInfoVo>();
		}


		// CusomSheet 생성
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("월간&분기별 (물리서버)");

		CellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Font font = workBook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFont(font);

		Row row = sheet.createRow(0);
		Cell pmTitleCell0 = row.createCell(0);	pmTitleCell0.setCellValue( "센터구분" );		pmTitleCell0.setCellStyle(headerStyle);
		Cell pmTitleCell1 = row.createCell(1);	pmTitleCell1.setCellValue( "물리서버구성ID" );			pmTitleCell1.setCellStyle(headerStyle);
		Cell pmTitleCell2 = row.createCell(2);	pmTitleCell2.setCellValue( "Zone명" );			pmTitleCell2.setCellStyle(headerStyle);
		Cell pmTitleCell3 = row.createCell(3);	pmTitleCell3.setCellValue( "클러스터" );		pmTitleCell3.setCellStyle(headerStyle);
		Cell pmTitleCell4 = row.createCell(4);	pmTitleCell4.setCellValue( "CPU\r\n평균보유량" );	pmTitleCell4.setCellStyle(headerStyle);
		Cell pmTitleCell5 = row.createCell(5);	pmTitleCell5.setCellValue( "MEM\r\n평균보유량(GB)" );	pmTitleCell5.setCellStyle(headerStyle);
		Cell pmTitleCell6 = row.createCell(6);	pmTitleCell6.setCellValue( "vCore\r\n평균할당량" );		pmTitleCell6.setCellStyle(headerStyle);
		Cell pmTitleCell7 = row.createCell(7);	pmTitleCell7.setCellValue( "MEM\r\n평균할당량(GB)" );		pmTitleCell7.setCellStyle(headerStyle);
		Cell pmTitleCell8 = row.createCell(8);	pmTitleCell8.setCellValue( "vCore\r\n평균사용률" );		pmTitleCell8.setCellStyle(headerStyle);
		Cell pmTitleCell9 = row.createCell(9);	pmTitleCell9.setCellValue( "MEM\r\n평균사용률" );		pmTitleCell9.setCellStyle(headerStyle);
		Cell pmTitleCell10 = row.createCell(10);	pmTitleCell10.setCellValue( "vCore\r\n최대사용률" );	pmTitleCell10.setCellStyle(headerStyle);
		Cell pmTitleCell11 = row.createCell(11);	pmTitleCell11.setCellValue( "MEM\r\n최대사용률" );		pmTitleCell11.setCellStyle(headerStyle);
		Cell pmTitleCell12 = row.createCell(12);	pmTitleCell12.setCellValue( "비고" );		pmTitleCell12.setCellStyle(headerStyle);

		for(int i = 0 ; i < 11  ;i++)
		{
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i) + 1024 ));
		}

		PmStatInfoVo pmVo = null;
		if(null == null || list.size() == 0){
			Row tmpRow = sheet.createRow(1);
			Cell tmpDataCell = tmpRow.createCell(0);
			tmpDataCell.setCellValue("데이터가 존재하지 않습니다.");
			sheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
			list = new ArrayList<PmStatInfoVo>();
		}
		else
		{
			int rowCnt = 1;
			Row dataRow = null;
			for(int i=0; i<list.size(); i++){
				pmVo = list.get(i);
				dataRow = sheet.createRow(rowCnt+i);
				Cell dataCell0 = dataRow.createCell(0);	 	dataCell0.setCellValue(pmVo.getRegionNm());
				Cell dataCell1 = dataRow.createCell(1);	 	dataCell1.setCellValue(pmVo.getPmCompId());
				Cell dataCell2 = dataRow.createCell(2);	 	dataCell2.setCellValue(pmVo.getZoneNm());
				Cell dataCell3 = dataRow.createCell(3);	 	dataCell3.setCellValue(pmVo.getClstrNm());
				Cell dataCell4 = dataRow.createCell(4);	 	dataCell4.setCellValue(DateUtil.stringValueOf(pmVo.getAvgVcorQty()));
				Cell dataCell5 = dataRow.createCell(5);	 	dataCell5.setCellValue(DateUtil.stringValueOf(pmVo.getAvgMemCapa()));
				Cell dataCell6 = dataRow.createCell(6);	 	dataCell6.setCellValue(DateUtil.stringValueOf(pmVo.getAvgAsgnVcorQty()));
				Cell dataCell7 = dataRow.createCell(7);	 	dataCell7.setCellValue(DateUtil.stringValueOf(pmVo.getAvgAsgnMemCapa()));
				Cell dataCell8 = dataRow.createCell(8);	 	dataCell8.setCellValue(DateUtil.stringValueOf(pmVo.getBuzAvgCpuUseRt()));
				Cell dataCell9 = dataRow.createCell(9);	 	dataCell9.setCellValue(DateUtil.stringValueOf(pmVo.getBuzAvgMemUseRt()));
				Cell dataCell10 = dataRow.createCell(10);	dataCell10.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgCpuUseRt()));
				Cell dataCell11 = dataRow.createCell(11);	dataCell11.setCellValue(DateUtil.stringValueOf(pmVo.getMaxAvgMemUseRt()));
				Cell dataCell12 = dataRow.createCell(12);	dataCell12.setCellValue(DateUtil.stringValueOf(pmVo.getRmk()));
			}
		}

		// Excel 생성
		OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
	}
}
