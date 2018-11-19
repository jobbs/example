/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.api.stack.btch.web.BtchController;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.rest.util.RestUtil;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.btch.service.BtchHistService;
import ncis.cpt.sys.btch.service.BtchWrkService;
import ncis.cpt.sys.btch.vo.BtchHistVo;
import ncis.cpt.sys.btch.vo.BtchWrkSearchVo;
import ncis.cpt.sys.btch.vo.BtchWrkVo;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

/**
 * @author 박봉춘
 *
 */
@Controller
@RequestMapping(value = "/cpt/sys/btch/btchwrk")
public class BtchWrkController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(BtchController.class);

    private final String REST_URL = PropertiesUtil.getProperty("duplexing.batch.run.url");
    private final String REST_TOKEN = PropertiesUtil.getProperty("duplexing.server.token");

	@Resource(name = "btchWrkService")
	private BtchWrkService btchWrkService;

	@Resource(name = "btchHistService")
	private BtchHistService btchHistService;

	@Resource(name = "commonService")
	private CommonService commonService;



	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		binder.registerCustomEditor(Date.class, "exeRsrvDttm", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "stopRsrvDttm", new CustomDateEditor(dateFormat, true));
	}

	/**
	 * 배치 목록 조회
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/selectBtchWrkList.do")
	public String selectBtchWrkList(HttpServletRequest request, Model model, BtchWrkSearchVo searchVo) {
		List<BtchWrkVo> list = btchWrkService.selectBtchWrkList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 배치 상세 조회
	 *
	 * @param request
	 * @param model
	 * @param btchWrkSeq
	 * @return
	 */
	@RequestMapping(value = "/selectBtchWrk.do")
	public String selectBtchWrk(HttpServletRequest request, Model model, @RequestParam("btchWrkSeq") Long btchWrkSeq) {
		BtchWrkVo btchwrk = btchWrkService.selectBtchWrk(btchWrkSeq);
		if( null == btchwrk )
		    throw new DataNotFoundException("존재하지 않는 데이터 입니다.");


		BtchHistVo btchHistVo = btchHistService.selectBtchHistById(btchwrk.getBtchWrkId());
		List<BtchHistVo> histStepListVo = null;
		if( null != btchHistVo ) {
			histStepListVo = btchHistService.selectBtchJobHistList(btchHistVo.getJobExecutionId());
		}

		model.addAttribute("vo", btchwrk);
		model.addAttribute("histVo", btchHistVo);
		model.addAttribute("histStepListVo", histStepListVo);

		return portalTilesView(request);
	}

	/**
	 * 배치 등록 화면 호출
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/insertBtchWrk.do")
	public String insertBtchWrkView(HttpServletRequest request, Model model) {
		BtchWrkVo btchwrk = new BtchWrkVo();
		btchwrk.setTimeType("C");
		btchwrk.setStat("Y");
		model.addAttribute("title", "배치 등록");
		model.addAttribute("vo", btchwrk);
		return portalTilesView(request, "formBtchWrk");
	}

	/**
	 * 배치 등록 프로세스
	 *
	 * @param btchWrkVo
	 * @param bindResult
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertBtchWrk.do", method = RequestMethod.POST)
	@OperateLog(action = "배치 관리 등록", desc = "배치관리 내용 등록", params = { "btchWrkNm" }, actionType = ActionType.INSERT)
	@ResponseBody
	public ProcResultVo insertBtchWrk(@ModelAttribute("vo") BtchWrkVo btchWrkVo, BindingResult bindResult) throws IOException {

		ProcResultVo result = getBindingResult(btchWrkVo, bindResult, InsertProc.class);

		if( result.isSuccess() ) {

			//배치 ID 체크
			if(btchWrkService.selectBtchWrkIdCnt(null, btchWrkVo.getBtchWrkId()) > 0){
				return getFailProcResult("동일한 배치 JOB ID가 등록되어 있습니다.");
			}

			btchWrkVo.setRegUserId(getUserId());
			btchWrkService.insertBtchWrk(btchWrkVo);
		}

		result.setProcType("insert");

		return result;
	}

	/**
	 * 배치 수정 화면 호출
	 *
	 * @param request
	 * @param model
	 * @param btchWrkSeq
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value = "/updateBtchWrk.do", method = RequestMethod.GET)
	public String updateBtchWrkView(HttpServletRequest request, Model model, @RequestParam("btchWrkSeq") Long btchWrkSeq, BtchWrkSearchVo searchVo) {
		BtchWrkVo vo = btchWrkService.selectBtchWrk(btchWrkSeq);
		if( null == vo )
            throw new DataNotFoundException("존재하지 않는 데이터 입니다.");
		model.addAttribute("title", "배치 수정");
		model.addAttribute("vo", vo);
		return portalTilesView(request, "formBtchWrk");
	}

	/**
	 * 배치 수정 프로세스
	 *
	 * @param btchWrkVo
	 * @param bindResult
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateBtchWrk.do", method = RequestMethod.POST)
	@OperateLog(action = "배치 정보 수정", desc = "배치정보 내용 수정처리", params = { "btchWrkNm" }, actionType = ActionType.UPDATE)
	@ResponseBody
	public ProcResultVo updateBtchWrk(@ModelAttribute("vo") BtchWrkVo btchWrkVo, BindingResult bindResult) {

		ProcResultVo result = getBindingResult(btchWrkVo, bindResult, InsertProc.class);

		if (result.isSuccess()) {

			//배치 ID 체크
			if(btchWrkService.selectBtchWrkIdCnt(btchWrkVo.getBtchWrkSeq(), btchWrkVo.getBtchWrkId()) > 1){
				return getFailProcResult("동일한 배치 JOB ID가 등록되어 있습니다.");
			}

			btchWrkService.updateBtchWrk(btchWrkVo);
		}

		result.setProcType("update");
		return result;
	}

	/**
	 * 배치 삭제
	 * @param btchwrkvo
	 * @return
	 */
	@RequestMapping(value = "/deleteBtchWrk.do", method = RequestMethod.POST)
	@OperateLog(action = "배치 삭제", params={"btchWrkSeq"}, desc = " 배치 내용 삭제 처리")
	@ResponseBody
	public ProcResultVo delete( @RequestParam(required=true) Long btchWrkSeq){
		btchWrkService.deleteBtchWrk(btchWrkSeq);
	    return getSuccessProcResult("배치정보를 삭제하였습니다.", "delete");
	}


	/**
     * 배치 실행 프로세스
     *
     * @param btchWrkVo
     * @param bindResult
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/executeBtchWrk.do")
    @OperateLog(action = "배치 실행", desc = "배치 수동 실행 처리", params = { "btchWrkSeq" }, actionType = ActionType.ACTION)
    @ResponseBody
    public ProcResultVo executeBtchWrk(@RequestParam(required=true) Long btchWrkSeq) {

    	try {

	        BtchWrkVo vo = btchWrkService.selectBtchWrk(btchWrkSeq);
	        if( null == vo )
	            return getFailProcResult("존재하지 않는 데이터 입니다.");

		    RestUtil restUtil = new RestUtil();

		    RestHeaders headers = new RestHeaders();
	        headers.setAuthorization(REST_TOKEN);
		    restUtil.setHeader(headers);

		    String url = REST_URL + "/" + vo.getBtchWrkId();

		    ProcResultVo result = restUtil.send(url, ProcResultVo.class, HttpMethod.GET).getBody();
		    if( result.isSuccess() ) {
		    	result.addMessage("배치를 실행하였습니다.");
		    } else {
		    	logger.debug(result.getMessageList().get(0));
		    }

		    return result;

    	} catch (RestClientException e) {
    		logger.error(e.getMessage(), e);
    		return getFailProcResult("배치 실행에 실패하였습니다.");
    	}


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
	@RequestMapping(value="/selectBtchWrkListXlsDwnl.do")
    public void selectBtchWrkListXlsDwnl(HttpServletResponse response, Model model, BtchWrkSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("btchWrkNm","배치 작업 명");
        header.put("cycleExeTime","주기/시점");
        header.put("btchWrkId","배치 JOB ID");
        header.put("btchWrkFileNm","배치 작업 파일");
        header.put("exeOptn","실행 옵션");
        header.put("jobStatusStat","상태");
        header.put("jobCreateTimePattern","최종작업일시");
        header.put("jobStatus","최종작업상태");
        header.put("stat","사용여부");

        List<BtchWrkVo> list = btchWrkService.selectBtchWrkListXlsDwnl(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("배치관리 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("배치관리목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

}
