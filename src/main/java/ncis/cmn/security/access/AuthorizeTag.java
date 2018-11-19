/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthorizeTag.java
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
package ncis.cmn.security.access;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import ncis.cmn.security.util.AuthorizeUtil;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.RequestUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthorizeTag extends TagSupport {

	private static final long serialVersionUID = 1755588518399793927L;

	private String pattern;
	private String authType;
	private String role;

	private boolean onlySysAdm;
	private boolean onlyOprAdm;
	private boolean onlyOprChr;
	private boolean onlyBldAdm;

	public AuthorizeTag() {
		onlySysAdm = false;
		onlyOprAdm = false;
		onlyOprChr = false;
		onlyBldAdm = false;
	}

	@Override
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		if (pattern == null || pattern.isEmpty()) {
			String requestUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
			String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
			pattern = requestUri.replaceAll("(^" + contextPath	+ ")|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "") + "/";
		}

		return checkAuthorize();
	}

	private int checkAuthorize() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (!(principal instanceof UserVo)) {
			return SKIP_BODY;
		}

		UserVo user = (UserVo) principal;

		//슈퍼관리자의 경우 무조건 패스~~
        if( "SYSADM".equals(RequestUtils.getSuperposedUserRole() ) ) {
            return EVAL_BODY_INCLUDE;
        }

		if( role != null && !role.isEmpty() ) {
			if( !AuthorizeUtil.hasRole(role) ) {
				return SKIP_BODY;
			}
		}

		if( onlySysAdm && !user.isSysAdm()) {
			return SKIP_BODY;
		}

		if( onlyOprAdm && !user.isOprAdm()) {
			return SKIP_BODY;
		}

		if( onlyOprChr && !user.isOprChr()) {
			return SKIP_BODY;
		}
		
		if( onlyBldAdm && !user.isBldAdm()) {
			return SKIP_BODY;
		}

		if( null == authType || "".equals(authType) ) authType = "write";

		if ("write".equals(authType)) {

			if (AuthorizeUtil.hasAnyRole(user.getMenuWriteRoleList(pattern))) {
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}
		} else if ("read".equals(authType)) {
			if (AuthorizeUtil.hasAnyRole(user.getMenuReadRoleList(pattern))) {
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}
		} else if( "act".equals(authType)) {
			if (AuthorizeUtil.hasAnyRole(user.getMenuActRoleList(pattern))) {
				return EVAL_BODY_INCLUDE;
			} else {
				return SKIP_BODY;
			}
		}

		return SKIP_BODY;

	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	/**
	 * @return the onlySysAdm
	 */
	public boolean isOnlySysAdm() {
		return onlySysAdm;
	}

	/**
	 * @param onlySysAdm the onlySysAdm to set
	 */
	public void setOnlySysAdm(boolean onlySysAdm) {
		this.onlySysAdm = onlySysAdm;
	}

	/**
	 * @return the onlyOprAdm
	 */
	public boolean isOnlyOprAdm() {
		return onlyOprAdm;
	}

	/**
	 * @param onlyOprAdm the onlyOprAdm to set
	 */
	public void setOnlyOprAdm(boolean onlyOprAdm) {
		this.onlyOprAdm = onlyOprAdm;
	}

	/**
	 * @return the onlyOprChr
	 */
	public boolean isOnlyOprChr() {
		return onlyOprChr;
	}
	

	/**
	 * @param onlyOprChr the onlyOprChr to set
	 */
	public void setOnlyOprChr(boolean onlyOprChr) {
		this.onlyOprChr = onlyOprChr;
	}

	/**
	 * @return the onlyBldAdm
	 */
	public boolean isOnlyBldAdm() {
		return onlyBldAdm;
	}

	/**
	 * @param onlyBldAdm the onlyBldAdm to set
	 */
	public void setOnlyBldAdm(boolean onlyBldAdm) {
		this.onlyBldAdm = onlyBldAdm;
	}

}
