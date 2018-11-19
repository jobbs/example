/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomWebSecurityExpressionHandler.java
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

import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class CustomWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {

	private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
	private String defaultRolePrefix = "ROLE_";

	@Override
	protected SecurityExpressionOperations createSecurityExpressionRoot(
			Authentication authentication, FilterInvocation invocation) {
		WebSecurityExpressionRoot root = new CustomWebSecurityExpresstionRoot(authentication, invocation);
		root.setPermissionEvaluator(getPermissionEvaluator());
		root.setTrustResolver(trustResolver);
		root.setRoleHierarchy(getRoleHierarchy());
		root.setDefaultRolePrefix(defaultRolePrefix);
		return root;
	}

	/**
	 * @return the defaultRolePrefix
	 */
	public String getDefaultRolePrefix() {
		return defaultRolePrefix;
	}

	/**
	 * @param defaultRolePrefix the defaultRolePrefix to set
	 */
	public void setDefaultRolePrefix(String defaultRolePrefix) {
		this.defaultRolePrefix = defaultRolePrefix;
	}

}
