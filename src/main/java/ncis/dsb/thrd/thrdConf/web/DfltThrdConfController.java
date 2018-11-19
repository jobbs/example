/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DfltThrdConfController.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.web.BaseController;
import ncis.dsb.thrd.thrdConf.service.DfltThrdConfService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 기본서버 임계치 설정
 *
 */
@Controller("dfltThrdConfController")
@RequestMapping("/dsb/thrd/thrdConf/dfltThrd")
public class DfltThrdConfController extends BaseController {


	@Resource(name="dfltThrdConfService")
	DfltThrdConfService dfltThrdConfService;

	/**
	 * 기본임계치 설정 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectDfltThrdConfList.do")
	public String selectDfltThrdConfList( HttpServletRequest request,
			Model model) throws Exception{

		List<Object> list = dfltThrdConfService.selectDfltThrdConfList();	// 게시글list 가져오기

		model.addAttribute("list", list);


		return dashTilesView(request,"selectDfltThrdConfList");
	}




}
