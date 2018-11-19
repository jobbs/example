/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxThrdConfController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.web.BaseController;
import ncis.dsb.thrd.thrdConf.service.AxThrdConfService;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 자동확장 임계치 설정
 *
 */
@Controller("axThrdConfController")
@RequestMapping("/dsb/thrd/thrdConf/axThrd")
public class AxThrdConfController extends BaseController {


	@Resource(name="axThrdConfService")
	AxThrdConfService axThrdConfService;


	/**
	 * 자동확장 임계치 설정 목록조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxThrdView.do")
	public String selectVmThrdView(
			HttpServletRequest request,
			Model model) throws Exception{

		return dashTilesView(request,"selectAxThrdList");
	}

	/**
	 * 자동확장 임계치 설정 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAxThrdConfList.do")
	public String selectAxThrdConfList(
			HttpServletRequest request,
			@ModelAttribute AxThrdConfSearchVo searchVo,
			Model model) throws Exception{

		List<AxThrdConfVo> list = axThrdConfService.selectAxThrdConfList(searchVo);	// 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectAxThrdTableList");
	}

}
