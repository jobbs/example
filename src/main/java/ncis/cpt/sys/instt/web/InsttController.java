/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DepartController.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.instt.web;

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
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cmn.util.excel.ExcelUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.annotation.OperateLog.ActionType;
import ncis.cpt.sys.instt.service.InsttService;
import ncis.cpt.sys.instt.vo.InsttSearchVo;
import ncis.cpt.sys.instt.vo.InsttVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최경철
 *
 */
@Controller
@RequestMapping(value="/cpt/sys/instt")
public class InsttController extends BaseController {

	@Resource(name="insttService")
	InsttService insttService;

	/**
	 * 부처 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectInsttList.do")
	public String selectInsttList(HttpServletRequest request, Model model, InsttSearchVo searchVo) {

		List<InsttVo> list = insttService.selectInsttList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * Excel 다운로드
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	@RequestMapping(value="/selectInsttListXlsDwnl.do")
    public void selectInsttListXlsDwnl(HttpServletResponse response, Model model, InsttSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

	    List<CustomSheet> sheets = new ArrayList<CustomSheet>();

	    // Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("institutionId","부처ID");
        header.put("institutionNm","부처명");
        header.put("useYn","사용여부");

        List<InsttVo> list = insttService.selectInsttListXlsDwnl(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("부처 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("부처목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 부처 상세 조회
	 * @param request
	 * @param model
	 * @param institutionId
	 * @return
	 */
	@RequestMapping(value="/selectInstt.do")
	public String selectInsttList(HttpServletRequest request, Model model, @RequestParam("institutionId") String institutionId) {

		InsttVo insttVo = insttService.selectInstt(institutionId);
		if( ObjectUtils.isEmpty(insttVo) ) {
		    throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
		}

		model.addAttribute("insttVo", insttVo);
		return portalTilesView(request);
	}

	 /**
	  * 부처 정보 수정
	 * @param insttVo
	 * @return
	 */
	@RequestMapping(value = "/updateInstt.do", method = RequestMethod.POST)
	@OperateLog(action="부처 정보 수정", desc="부처 사용여부 정보 수정", params={"institutionId", "useYn"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateInstt(InsttVo insttVo) {

    	insttService.updateInstt(insttVo);
    	return getSuccessProcResult("부처 정보를 변경하엿습니다.", "update");
    }
}
