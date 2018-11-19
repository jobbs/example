/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthVo.java
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
 * 2016. 10. 31.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

/**
 * @author 이제율
 *
 */
public class AuthVo {
	private boolean use_param = false;
	private String param_name;
	private boolean use_cookie = false;
	private String cookie_name;
	private String auth_header_name = "Authorization";
	/**
	 * @return the use_param
	 */
	public boolean isUse_param() {
		return use_param;
	}
	/**
	 * @param use_param the use_param to set
	 */
	public void setUse_param(boolean use_param) {
		this.use_param = use_param;
	}
	/**
	 * @return the param_name
	 */
	public String getParam_name() {
		return param_name;
	}
	/**
	 * @param param_name the param_name to set
	 */
	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	/**
	 * @return the use_cookie
	 */
	public boolean isUse_cookie() {
		return use_cookie;
	}
	/**
	 * @param use_cookie the use_cookie to set
	 */
	public void setUse_cookie(boolean use_cookie) {
		this.use_cookie = use_cookie;
	}
	/**
	 * @return the cookie_name
	 */
	public String getCookie_name() {
		return cookie_name;
	}
	/**
	 * @param cookie_name the cookie_name to set
	 */
	public void setCookie_name(String cookie_name) {
		this.cookie_name = cookie_name;
	}
	/**
	 * @return the auth_header_name
	 */
	public String getAuth_header_name() {
		return auth_header_name;
	}
	/**
	 * @param auth_header_name the auth_header_name to set
	 */
	public void setAuth_header_name(String auth_header_name) {
		this.auth_header_name = auth_header_name;
	}
}
