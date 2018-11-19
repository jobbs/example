package ncis.dsb.cmn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.util.MessageUtil;
import ncis.cmn.web.BaseController;
import ncis.dsb.cmn.vo.MainSearchVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("dsbCmnController")
public class DsbCmnController extends BaseController {

	@Resource
	private MessageUtil messageUtil;

	/**
	 * 사용자 index 화면 호출
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value={"/dsb/","/dsb/index.do"})
	public String selectMainList(HttpServletRequest request,  Model model, @ModelAttribute MainSearchVo searchVo) throws Exception {

		if( null == getUser() ) {
			return redirect("/login.do");
		}
		boolean mainRsrcView = false;
		boolean mainIncView = false;
		List<String> list = selectUserRoleList();
		if(list != null){
			for(int i =0; i<list.size();i++){
				String UserRole = (String)list.get(i);
				if("SYSADM".equals(UserRole) || "OPRADM".equals(UserRole)) mainRsrcView = true;
				if("SYSADM".equals(UserRole) || "OPRCHR".equals(UserRole)) mainIncView = true;

			}

		}

		model.addAttribute("searchVo", searchVo);
		model.addAttribute("mainRsrcView", mainRsrcView);
		model.addAttribute("mainIncView", mainIncView);

		return "dashIndex";
	}
	
	/**
	 * 사용자 index 화면 호출
	 *
	 * @param request
	 * @param model
	 * @param searchVo
	 * @return
	 */
	@RequestMapping(value={"/dsb/onnara/","/dsb/onnara/index.do"})
	public String selectMainListByOnnara(HttpServletRequest request,  Model model, @ModelAttribute MainSearchVo searchVo) throws Exception {

		if( null == getUser() ) {
			return redirect("/login.do");
		}
		boolean mainRsrcView = false;
		boolean mainIncView = false;
		List<String> list = selectUserRoleList();
		if(list != null){
			for(int i =0; i<list.size();i++){
				String UserRole = (String)list.get(i);
				if("SYSADM".equals(UserRole) || "OPRADM".equals(UserRole)) mainRsrcView = true;
				if("SYSADM".equals(UserRole) || "OPRCHR".equals(UserRole)) mainIncView = true;

			}

		}

		model.addAttribute("searchVo", searchVo);
		model.addAttribute("mainRsrcView", mainRsrcView);
		model.addAttribute("mainIncView", mainIncView);

		return "dashIndex2";
	}

}
