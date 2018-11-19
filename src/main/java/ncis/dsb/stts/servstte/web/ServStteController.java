/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServStteController.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.servstte.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.web.BaseController;
import ncis.dsb.stts.servstte.service.ServStteService;
import ncis.dsb.stts.servstte.vo.ServStteCvo;
import ncis.dsb.stts.servstte.vo.ServStteSearchVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("servStteController")
@RequestMapping("/dsb/stts/servstte")
public class ServStteController extends BaseController {


	@Resource(name="servStteService")
	ServStteService servStteService;


	/**
	 * 가상서버 로그 조회
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectServStteList.do")
	public String selectServStteList( HttpServletRequest request,
			Model model, ServStteSearchVo searchVo) throws Exception{

		ServStteCvo list = servStteService.selectServStteList(searchVo);


		model.addAttribute("ServStteCvo", list);
		model.addAttribute("searchVo", searchVo);

		return dashIndexTilesView(request);
	}


}
