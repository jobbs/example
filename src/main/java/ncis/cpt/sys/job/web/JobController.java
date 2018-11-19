/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobController.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.job.web;

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
import ncis.cpt.sys.job.service.JobService;
import ncis.cpt.sys.job.vo.JobSearchVo;
import ncis.cpt.sys.job.vo.JobVo;
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
@RequestMapping(value="/cpt/sys/job")
public class JobController extends BaseController {

	@Resource(name="jobService")
	JobService jobService;

	/**
	 * 부처 목록 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectJobList.do")
	public String selectJobList(HttpServletRequest request, Model model, JobSearchVo searchVo) {

		List<JobVo> list = jobService.selectJobList(searchVo);

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);
		return portalTilesView(request);
	}

	/**
	 * 부처목록 조회(Excel Down)
	 * @param response
	 * @param model
	 * @param searchVo
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value="/selectJobListXlsDwnl.do")
    public void selectJobListXlsDwnl(HttpServletResponse response, Model model, JobSearchVo searchVo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("regionNm","센터");
        header.put("institutionNm","부처명");
        header.put("jobNm","업무");
        header.put("vmCnt","VM수");
        header.put("cludJob","클라우드업무여부");
        header.put("vmAsgnYn","가상서버할당여부");
        header.put("atmsclAsgnYn","자동확장할당여부");
        header.put("useYn","사용여부");

        List<JobVo> list = jobService.selectJobListXlsDwnl(searchVo);

        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("부처업무 목록");
        sheet.setDatas(list);
        sheet.setHreader(header);
        sheets.add(sheet);

        ExcelUtil.downloadExcel(response,String.format("부처업무목록_%s", (new SimpleDateFormat("yyyyMMdd")).format(new Date())), sheets);
    }

	/**
	 * 부처 업무 상세 조회
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value="/selectJob.do")
	public String selectJob(HttpServletRequest request, Model model, @RequestParam("jobId") String jobId) {

		JobVo jobVo = jobService.selectJob(jobId);
		if(ObjectUtils.isEmpty(jobVo)){
			throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
		}

		model.addAttribute("jobVo", jobVo);
		return portalTilesView(request);
	}
	/**
	 * 부처 업무 수정
	 * @param jobVo
	 * @return
	 */
	@RequestMapping(value = "/updateJob.do", method = RequestMethod.POST)
	@OperateLog(action="부처 업무 정보 수정", desc="부처 업무 사용여부 정보 수정", params={"jobId", "useYn"}, actionType=ActionType.UPDATE)
    @ResponseBody
    public ProcResultVo updateJob(JobVo jobVo) {

	    jobService.updateJob(jobVo);
    	return getSuccessProcResult("부처 업무 정보를 변경하엿습니다.", "update");

    }

}
