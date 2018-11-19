/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmThrdConfController.java
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
import ncis.dsb.thrd.thrdConf.service.VmThrdConfService;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 가상서버 임계치 설정
 *
 */
@Controller("vmThrdConfController")
@RequestMapping("/dsb/thrd/thrdConf/vmThrd")
public class VmThrdConfController extends BaseController {


	@Resource(name="vmThrdConfService")
	VmThrdConfService vmThrdConfService;

	/**
	 * 가상서버 임계치 설정 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value="/selectVmThrdList.do")
	public String selectDfltThrdConfList( HttpServletRequest request,
			Model model) throws Exception{

		List list = vmThrdConfService.selectVmThrdConfList();	// 게시글list 가져오기

		model.addAttribute("list", list);


		return dashTilesView(request,"selectVmThrdList");
	}*/
	/**
	 * 가상서버 임계치 설정 목록조회 화면 호출
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmThrdView.do")
	public String selectVmThrdView(
			HttpServletRequest request,
			Model model) throws Exception{

		return dashTilesView(request,"selectVmThrdList");
	}

	/**
	 * 가상서버 임계치 설정 목록조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectVmThrdConfList.do")
	public String selectVmThrdConfList(
			HttpServletRequest request,
			@ModelAttribute VmThrdConfSearchVo searchVo,
			Model model) throws Exception{

		List<VmThrdConfVo> list = vmThrdConfService.selectVmThrdConfList(searchVo);	// 게시글list 가져오기

		model.addAttribute("list", list);
		model.addAttribute("searchVo", searchVo);

		return jstlView(request,"selectVmThrdTableList");
	}

}
