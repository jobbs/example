/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OauthMetaVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     이제율        	 v1.0    	         최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

/**
 * @author 이제율
 *
 */
public class OauthMetaVo {
	private List<String> allowed_access_types;
	private List<String> allowed_authorize_types;
	private String auth_login_redirect;
	/**
	 * @return the allowed_access_types
	 */
	public List<String> getAllowed_access_types() {
		return allowed_access_types;
	}
	/**
	 * @param allowed_access_types the allowed_access_types to set
	 */
	public void setAllowed_access_types(List<String> allowed_access_types) {
		this.allowed_access_types = allowed_access_types;
	}
	/**
	 * @return the allowed_authorize_types
	 */
	public List<String> getAllowed_authorize_types() {
		return allowed_authorize_types;
	}
	/**
	 * @param allowed_authorize_types the allowed_authorize_types to set
	 */
	public void setAllowed_authorize_types(List<String> allowed_authorize_types) {
		this.allowed_authorize_types = allowed_authorize_types;
	}
	/**
	 * @return the auth_login_redirect
	 */
	public String getAuth_login_redirect() {
		return auth_login_redirect;
	}
	/**
	 * @param auth_login_redirect the auth_login_redirect to set
	 */
	public void setAuth_login_redirect(String auth_login_redirect) {
		this.auth_login_redirect = auth_login_redirect;
	}
}
