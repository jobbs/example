/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.exception.ExceptionScriptPrint;
import ncis.cmn.exception.ExceptionScriptPrint.ActionType;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.btch.service.BtchHistService;
import ncis.cpt.sys.btch.vo.BtchHistSearchVo;
import ncis.cpt.sys.btch.vo.BtchHistVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 박봉춘
 *
 */
@Controller
@RequestMapping(value = "/cpt/sys/btch/btchhist")
public class BtchHistController extends BaseController {

	@Resource(name = "btchHistService")
	private BtchHistService btchHistService;

	@Resource(name = "commonService")
	private CommonService commonService;

	/**
	 * 배치 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/selectBtchHistList.do")
	public String selectBtchHistList(HttpServletRequest request, Model model, BtchHistSearchVo searchVo) throws ParseException {
		//시작시간 기본 3일 체크
		if( StringUtils.isEmpty(searchVo.getStartTimefirstSearch()) ) {
			searchVo.setSearchBtchStartTimeEnd(DateUtil.getCurrentDate());
			searchVo.setSearchBtchStartTimeStart(DateUtil.dateToString(DateUtil.plusDate(new Date(), -3), "yyyy-MM-dd"));
			searchVo.setStartTimefirstSearch("N");
		}else{
			//시작시간 3일 이상일때
			if(DateUtil.diffOfDate(searchVo.getSearchBtchStartTimeStart(), searchVo.getSearchBtchStartTimeEnd())>3){
				throw new ExceptionScriptPrint("배치 시작일자 검색은 최대 3일까지 가능합니다.", ActionType.DEFAULT);
			}
		}

		List<BtchHistVo> list = btchHistService.selectBtchHistList(searchVo);
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

    /**
     * 배치관리 엑셀 다운로드
     * @param response
     * @param model
     * @param searchVo
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
	@RequestMapping(value="/selectBtchHistListXlsDwnl.do")
    public void selectBtchHistListXlsDwnl(HttpServletResponse response, Model model, BtchHistSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

		List<BtchHistVo> list = btchHistService.selectBtchHistListXlsDwnl(searchVo);
		//엑셀 다운로드 개수 체크
        if(list.size()>65000){
        	throw new ExceptionScriptPrint("엑셀 다운로드 항목 수는 최대 65000건까지 가능합니다.", ActionType.DEFAULT);
        }
        else{
        	 List<CustomSheet> sheets = new ArrayList<CustomSheet>();

             // Header 생성
             Map<String, String> header = new LinkedHashMap<String, String>();
             header.put("btchWrkNm","배치 작업 명");
             header.put("jobName","배치 ID");
             header.put("StartTimePattern","배치 시작시간");
             header.put("EndTimePattern","배치 종료시간");
             header.put("status","배치 상태");
             header.put("exitMessage","배치 종료 메세지");

             CustomSheet sheet = new CustomSheet();
             sheet.setSheetName("배치이력관리 목록");
             sheet.setDatas(list);
             sheet.setHreader(header);
             sheets.add(sheet);
        	 ExcelUtil.downloadExcel(response,String.format("배치이력관리목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
        }
    }

	/**
	 * 배치 수행이력 상세 조회
	 *
	 * @param request
	 * @param model
	 * @param btchWrkSeq
	 * @return
	 */
	@RequestMapping(value = "/selectBtchHist.do")
	public String selectBtchHist(HttpServletRequest request, Model model, @RequestParam("jobExecutionId") int jobExecutionId) {
		BtchHistVo btchhist = btchHistService.selectBtchHist(jobExecutionId);
		List<BtchHistVo> list = btchHistService.selectBtchJobHistList(jobExecutionId);

		if( null == btchhist )
		    throw new DataNotFoundException("존재하지 않는 데이터 입니다.");

		model.addAttribute("vo", btchhist);
		model.addAttribute("list", list);
		return portalTilesView(request);
	}

	@RequestMapping(value = "/selectExitMessageP.do")
	public String selectExitMessageP(HttpServletRequest request, Model model, @RequestParam("stepExecutionId") long stepExecutionId) {


		String message = btchHistService.selectExitMessage(stepExecutionId);

		model.addAttribute("title", "배치 단계 오류메시지");
		model.addAttribute("message", message);
		return popup(request);
	}

}

