/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.web;

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
import ncis.dsb.stts.log.axLog.service.AxLogService;
import ncis.dsb.stts.log.axLog.vo.AxLogSearchVo;
import ncis.dsb.stts.log.axLog.vo.AxLogVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller("axLogController")
@RequestMapping("/dsb/stts/log/axLog")
public class AxLogController extends BaseController {


	@Resource(name="axLogService")
	AxLogService axLogService;


	/**
	 * 자동확장 로그 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxServcLogList.do")
	public String selectAxServcLogList( HttpServletRequest request,
			Model model, AxLogSearchVo searchVo) throws Exception{

		List<AxLogVo> list = null;

		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = axLogService.selectAxLogList(searchVo);

		}
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectAxServcLogList");
	}
	/**
	 * 자동확장 로그 엑셀 다운 로드
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxServcLogXlsDown.do")
	public void selectAxServcLogXlsDown( HttpServletRequest request,
			HttpServletResponse response, AxLogSearchVo searchVo) throws Exception{

		/***/
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(1);
		paginationInfo.setRecordCountPerPage(1000000);
		searchVo.setPaginationInfo(paginationInfo);

		List<AxLogVo> list = null;

		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = axLogService.selectAxLogList(searchVo);

		}
		//CusomSheet 생성
	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    //첫번째 Sheet Header 생성
	    Map<String, String> header = new LinkedHashMap<String, String>();
	    header.put("institutionNm", "부처명");
        header.put("jobNm", "업무명");
        header.put("logColctDttm", "로그수집 시간");
        header.put("servcAreaCompId", "서비스영역 구성ID");
        header.put("servcAreaNm", "서비스영역명");
        header.put("logMsg", "로그 메시지");

      //첫번째 Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자동확장 로그조회");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        //Excel 생성
        ExcelUtil.downloadExcel(response, "자동확장 로그조회_"+DateUtil.getCurrentDate(), sheets);
	}


}
