/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmLogController.java
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
package ncis.dsb.stts.log.vmLog.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.util.DateUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.stts.log.vmLog.service.VmLogService;
import ncis.dsb.stts.log.vmLog.vo.VmLogSearchVo;
import ncis.dsb.stts.log.vmLog.vo.VmLogVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("vmLogController")
@RequestMapping("/dsb/stts/log/vmLog")
public class VmLogController extends BaseController {


	@Resource(name="vmLogService")
	VmLogService vmLogService;


	/**
	 * 가상서버 로그 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmLogList.do")
	public String selectVmLogList( HttpServletRequest request,
			Model model, VmLogSearchVo searchVo) throws Exception{

		List<VmLogVo> list = null;

		if(searchVo.getStrtDt()==null){
			searchVo.setStrtDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
			searchVo.setEndDt(DateUtil.dateToString(DateUtil.plusDate(DateUtil.getCurrentDate(), -1),"yyyy-MM-dd"));
		}else{
			list = vmLogService.selectVmLogList(searchVo);

		}
		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return dashTilesView(request,"selectVmLogList");
	}


}
