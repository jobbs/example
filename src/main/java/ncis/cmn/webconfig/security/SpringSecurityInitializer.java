/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpringSecurityInitializer.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.webconfig.security;

import javax.servlet.ServletContext;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

@Order(1)
public class SpringSecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer#beforeSpringSecurityFilterChain(javax.servlet.ServletContext)
	 */
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		super.beforeSpringSecurityFilterChain(servletContext);
		insertFilters(servletContext, new MultipartFilter());
	}
}
