/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomWebSecurityExpresstionRoot.java
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
package ncis.cmn.security.access.expression;

import java.util.List;
import ncis.cmn.security.util.AuthorizeUtil;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.sys.menu.vo.MenuVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.util.StringUtils;

public class CustomWebSecurityExpresstionRoot extends WebSecurityExpressionRoot {

	public CustomWebSecurityExpresstionRoot(Authentication a, FilterInvocation fi) {
		super(a, fi);
	}

	public boolean hasCustomRole() {

		Object principal = getPrincipal();
		if(!(principal instanceof UserVo)){
			return false;
		}

		//슈퍼관리자의 경우 무조건 패스~~
		if( "SYSADM".equals(RequestUtils.getSuperposedUserRole() ) ) {
		    return true;
		}


		String regex = null;
		if( null == request.getContextPath() || "".equals(request.getContextPath()) ) {
			regex = "((/[^/]+){1}/*$)";
		} else {
			regex = "(^" + request.getContextPath() + ")|((/[^/]+){1}/*$)";
		}

		String requestUrlPattern = request.getRequestURI().replaceAll(regex, "")+"/";

		if("/".equals(requestUrlPattern)){
			return true;
		}

		if(StringUtils.isEmpty(requestUrlPattern)){
			return false;
		}

		String requestName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);

		UserVo user = (UserVo)principal;

		//사용자의 메뉴 중에서 패턴에 해당하는 메뉴의 권한이 있는지 여부를 판단한다.
		MenuVo menu = user.getCurrentMenu(requestUrlPattern);

		if( null == menu ) {
			return false;
		}

		//읽기 권한이 있을 경우
		else if( requestName.startsWith("index")
				|| requestName.startsWith("select")
				|| requestName.startsWith("download") ) {

			return AuthorizeUtil.hasReadRole(menu);

		} else if( requestName.startsWith("execute") ) {

		    return AuthorizeUtil.hasActRole(menu);

		}else {

		    return AuthorizeUtil.hasWriteRole(menu);

		}
	}

	public boolean isUser() {
		Object principal = getPrincipal();
		if( !( principal instanceof UserVo ) ) {
			return false;
		}

		return true;
	}

	public boolean isSystemAdmin() {
		Object principal = getPrincipal();
		if( !( principal instanceof UserVo ) ) {
			return false;
		}

		@SuppressWarnings("unchecked")
		List<GrantedAuthority> grantList = (List<GrantedAuthority>) authentication.getAuthorities();

		boolean isAdmin = false;
		for(GrantedAuthority auth:grantList){
			if(PropertiesUtil.getProperty("auth.manager.system").equals(auth.getAuthority())){
				isAdmin = true;
			}
		}

		return isAdmin;
	}
}
