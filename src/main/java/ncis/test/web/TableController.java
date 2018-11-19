/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TableController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 11. 15.
 * @lastmodified 2016. 11. 15.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 15.     최진호         v1.0             최초생성
 *
 */
package ncis.test.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ncis.cmn.web.BaseController;

/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value="/cpt/test")
public class TableController extends BaseController {

	@RequestMapping(value="/table/selectTable.do", method=RequestMethod.GET)
	public String testForm(HttpServletRequest request, Model model){

		return portalTilesView(request);
	}

	@RequestMapping(value="/loding/selectLoding.do", method=RequestMethod.GET)
	public String selectLoding(HttpServletRequest request, Model model){

		return portalTilesView(request);
	}

}
