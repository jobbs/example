package ncis.api.cmn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ncis.cmn.web.BaseController;
import ncis.cpt.sys.menu.vo.MenuVo;
import ncis.dsb.cmn.vo.MainSearchVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("apiCmnController")
public class ApiCmnController extends BaseController {


	/** <pre>
	 * 사용자 index 화면 호출
	 * </pre>
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/api/","/api/index.do"})
	public String selectMainList(HttpServletRequest request, Model model, MainSearchVo searchVo) throws Exception {

		if( null == getUser() ) {
			return redirect("/login.do");
		}

		String redirectUrl = null;

		List<MenuVo> subMenus = getUser().getSubMenuList(new Long(97));
		if( ObjectUtils.isEmpty(subMenus)) {
			return redirect("/error/accessDenied.do");
		}

		MenuVo childMenu = selectChildMenu(subMenus.get(0));

		redirectUrl = childMenu.getMenuPattern() + childMenu.getMenuFile();

		return redirect(redirectUrl);
	}

	private MenuVo selectChildMenu(MenuVo parentMenu) {

		if( ObjectUtils.isEmpty(parentMenu.getSubMenuList()) ) {
			return parentMenu;
		}

		return selectChildMenu(parentMenu.getSubMenuList().get(0));
	}

}
