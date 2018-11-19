/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ModAuthTag.java
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

public class ModAuthTag extends TagSupport {

	private static final long serialVersionUID = -1909648906013339537L;

	private String pattern;
	private String regId; //등록자ID

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		if(pattern == null || pattern.isEmpty()){
			String requestUri = (String)request.getAttribute("javax.servlet.forward.request_uri");
			String contextPath = (String)request.getAttribute("javax.servlet.forward.context_path");
			pattern = requestUri.replaceAll("(^" + contextPath + ")|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/";
		}
		return checkAuthorize();
	}


	private int checkAuthorize() {
		// 인증되지 않은 상태인 경우 접근 불가
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!(principal instanceof UserVo)){
			return SKIP_BODY;
		}

		if( "SYSADM".equals(RequestUtils.getSuperposedUserRole() ) ) {
			return EVAL_BODY_INCLUDE;
		}

		if(AuthorizeUtil.hasModifyAuthorize(pattern, regId)){
			return EVAL_BODY_INCLUDE;
		}

		return SKIP_BODY;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	public void setRegId(String regId) {
		this.regId = regId;
	}

}
