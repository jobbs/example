/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseController.java
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
 * 2017. 05. 21   양정순         v2.0             자동확장 추가
 *
 */
package ncis.dsb.stts.etc.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.util.DsbUtil;
import ncis.dsb.stts.etc.service.MmSttsCloseService;
import ncis.dsb.stts.etc.vo.MmSttsCloseSearchVo;
import ncis.dsb.stts.etc.vo.MmSttsCloseVo;
import ncis.dsb.stts.etc.vo.AxMmSttsCloseVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("mmSttsCloseController")
@RequestMapping("/dsb/stts/etc/mmSttsClose")
public class MmSttsCloseController extends BaseController {


	@Resource(name="mmSttsCloseService")
	MmSttsCloseService mmSttsCloseService;

	/**
	 * 월별 통계마감 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMmSttsCloseList.do")
	public String selectMmSttsCloseList( HttpServletRequest request,
			Model model, MmSttsCloseSearchVo searchVo) throws Exception{

		List<?> list = null;

		String year = searchVo.getYear();

		if(year == null){
			searchVo.setMonth(DateUtil.getCurrentDate("MM"));
		}else{
			searchVo.setCloseMonth(searchVo.getYear() + searchVo.getMonth());

			if(searchVo.getMonth().equals("01")){
				searchVo.setPreMonth(Integer.toString(Integer.parseInt(searchVo.getYear())-1) + "-12");
			}else{
				searchVo.setPreMonth(searchVo.getYear() + DsbUtil.lpad(Integer.toString(Integer.parseInt(searchVo.getMonth())-1), 2, "0"));
			}
			if(searchVo.getSearchServer().equals("AX")){
				list = mmSttsCloseService.selectAxMmSttsCloseList(searchVo);
			}else{
				list = mmSttsCloseService.selectMmSttsCloseList(searchVo);
			}
		}



        model.addAttribute("yearCdList", DsbUtil.getYearCd(7));
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectMmSttsCloseList");
	}

	/**
	 * VM별 마감조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmCloseList.do")
	public String selectVmCloseList( HttpServletRequest request,
			Model model, @RequestParam("pmSeq") int pmSeq, MmSttsCloseSearchVo searchVo) throws Exception{
		searchVo.setPmSeq(pmSeq);
		List<MmSttsCloseVo> list = mmSttsCloseService.selectVmCloseList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectVmCloseList");
	}

	/**
	 * 자동확장 마감조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxCloseList.do")
	public String selectAxCloseList( HttpServletRequest request,
			Model model, @RequestParam("servcSeq") int servcSeq, MmSttsCloseSearchVo searchVo) throws Exception{
		searchVo.setServcSeq(servcSeq);
		List<AxMmSttsCloseVo> list = mmSttsCloseService.selectAxCloseList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);


		return dashTilesView(request,"selectAxCloseList");
	}

	/**
	 * 월별 통계마감 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMmSttsCloseXlsDown.do")
	public void selectMmSttsCloseXlsDown(
			MmSttsCloseSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<?> list = null;

		String year = searchVo.getYear();

		if(year != null){
			searchVo.setCloseMonth(searchVo.getYear() + searchVo.getMonth());

			if(searchVo.getMonth().equals("01")){
				searchVo.setPreMonth(Integer.toString(Integer.parseInt(searchVo.getYear())-1) + "-12");
			}else{
				searchVo.setPreMonth(searchVo.getYear() + DsbUtil.lpad(Integer.toString(Integer.parseInt(searchVo.getMonth())-1), 2, "0"));
			}

			if(searchVo.getSearchServer().equals("AX")){
				list = mmSttsCloseService.selectAxMmSttsCloseList(searchVo);
			}else{
				list = mmSttsCloseService.selectMmSttsCloseList(searchVo);
			}
		}

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    if(searchVo.getSearchServer().equals("AX")){
	        header.put("colctDt", "마감월");
	        header.put("srvrCl", "대상");
	        header.put("regionNm", "센터");
	        header.put("zoneNm", "존");
	        header.put("netNm", "망구분");
	        header.put("rsrcPoolNm", "자원풀");
	        header.put("servcNm", "서비스명");
	        header.put("podId", "PODID");
	        header.put("podNm", "POD명");
	        header.put("avgCpuUseRt", "cpu사용율(%)(전월대비 증감)");
	        header.put("cpuCorQty", "논리적 코어 개수(전월대비 증감)");
	        header.put("strgTotCapa", "스토리지 총용량(Gbyte)(전월대비 증감)");
	        header.put("memTotCapa", "메모리 총용량(Gbyte)(전월대비 증감)");
	        header.put("avgMemUseRt", "메모리 사용율(%)(전월대비 증감)");
	    }else{
	    	header.put("colctDt", "마감월");
	        header.put("srvrCl", "대상");
	        header.put("regionNm", "센터");
	        header.put("zoneNm", "존");
	        header.put("netNm", "망구분");
	        header.put("rsrcPoolNm", "자원풀");
	        header.put("clstrNm", "클러스터");
	        header.put("pmId", "구성ID");
	        header.put("avgCpuUseRt", "cpu사용율(%)(전월대비 증감)");
	        header.put("avgCpuCorQty", "논리적 코어 개수(전월대비 증감)");
	        header.put("avgStrgSumCapa", "디스크 총용량(Gbyte)(전월대비 증감)");
	        header.put("avgStrgUseCapa", "FileSystems 사용량(Gbyte)(전월대비 증감)");
	        header.put("avgMemSumCapa", "메모리 총용량(Gbyte)(전월대비 증감)");
	    }

        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("월별통계마감");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "월별통계마감_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * VM별 마감조회 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmCloseXlsDown.do")
	public void selectVmCloseXlsDown(@RequestParam("pmSeq") int pmSeq,
			MmSttsCloseSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		searchVo.setPmSeq(pmSeq);
		List<MmSttsCloseVo> list = mmSttsCloseService.selectVmCloseList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("colctDt", "일자");
        header.put("pmId", "구성ID");
        header.put("avgCpuUseRt", "cpu사용율(%)");
        header.put("lastCpuCorQty", "논리적 코어 개수");
        header.put("lastStrgSumCapa", "디스크 총용량(Gbyte)");
        header.put("avgStrgUseCapa", "FileSystems 사용량(Gbyte)");
        header.put("lastMemSumCapa", "메모리 총용량(Gbyte)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("VM별 마감 조회");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "VM별 마감 조회_"+DateUtil.getCurrentDate(), sheets);
    }

	/**
	 * 자동확장 마감조회 엑셀다운로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxCloseXlsDown.do")
	public void selectAxCloseXlsDown(@RequestParam("servcSeq") int servcSeq,
			MmSttsCloseSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		searchVo.setServcSeq(servcSeq);
		List<AxMmSttsCloseVo> list = mmSttsCloseService.selectAxCloseList(searchVo);

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("colctDt", "일자");
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망구분");
        header.put("rsrcPoolNm", "자원풀");
        header.put("servcNm", "서비스명");
        header.put("podId", "PODID");
        header.put("avgCpuUseRt", "cpu사용율(%)");
        header.put("cpuCorQty", "코어 개수");
        header.put("strgTotCapa", "스토리지 총용량(Gbyte)");
        header.put("memTotCapa", "메모리 총용량(Gbyte)");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장 POD별 마감 조회");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장 POD별 마감 조회_"+DateUtil.getCurrentDate(), sheets);
    }
}
