/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteController.java
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
import ncis.dsb.stts.rsrcuse.service.JobRsrcStteService;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("jobRsrcStteController")
@RequestMapping("/dsb/stts/rsrcuse/job")
public class JobRsrcStteController extends BaseController {


	@Resource(name="jobRsrcStteService")
	JobRsrcStteService jobRsrcStteService;


	/**
	 * 업무별 자원현황
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobRsrcStteList.do")
	public String selectJobRsrcStteList( HttpServletRequest request,JobRsrcStteSearchVo searchVo,
			Model model) throws Exception{


		List<JobRsrcStteVo> list = jobRsrcStteService.selectJobRsrcStteList(searchVo);	// 게시글list 가져오기
		model.addAttribute("list", list);

		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectJobRsrcStteList");
	}

	/**
	 * 업무별 자원현황 엑셀 다운
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectJobRsrcStteXlsDown.do")
	public void selectJobRsrcStteXlsDown(
			JobRsrcStteSearchVo searchVo,
			HttpServletRequest request,
			HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);


		List<JobRsrcStteVo> list = null;
		if(searchVo.getSearch() != null){
				list = jobRsrcStteService.selectJobRsrcStteList(searchVo);	// 게시글list 가져오기
		}

	    //CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();

	        header.put("institutionNm", "부처명");
	        header.put("jobNm", "업무명");
	        header.put("com", "컴퓨팅");
	        header.put("netwk", "네트워크");


        //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("업무별 자원현황");
        sheet.setDatas(list);
        sheet.setHreader(header);

        sheets.add(sheet);


        //Excel 생성
        ExcelUtil.downloadExcel(response, "업무별 자원현황_"+DateUtil.getCurrentDate(), sheets);
    }


}

