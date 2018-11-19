/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomAuthenticationSuccessHandler.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.security.authentication;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.CmUsrConnHist;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.sys.hist.service.UserConnHistService;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	@Resource(name="userConnHistService")
	private UserConnHistService userConnHistService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {

		UserVo user = (UserVo)authentication.getPrincipal();

		CmUsrConnHist cmUsrConnHist = new CmUsrConnHist();
		cmUsrConnHist.setUserId(user.getUserId());
		cmUsrConnHist.setUserNm(user.getUserNm());
		cmUsrConnHist.setConnIp(RequestUtils.getRemoteIP(request));

		userConnHistService.insertUSerConnHist(cmUsrConnHist);

		redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
	}
}
