/**
t * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CORSVo.java
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

import java.util.List;

/**
 * @author 이제율
 *
 */
public class CORSVo {
	private boolean enable;
    private List<String> allowed_origins;
    private List<String> allowed_methods;
    private List<String> allowed_headers;
    private List<String>  exposed_headers;
    private boolean allow_credentials = false;
    private Integer max_age = 24;
    private boolean options_passthrough = false;
    private boolean debug = false;
	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	/**
	 * @return the allowed_origins
	 */
	public List<String> getAllowed_origins() {
		return allowed_origins;
	}
	/**
	 * @param allowed_origins the allowed_origins to set
	 */
	public void setAllowed_origins(List<String> allowed_origins) {
		this.allowed_origins = allowed_origins;
	}
	/**
	 * @return the allowed_methods
	 */
	public List<String> getAllowed_methods() {
		return allowed_methods;
	}
	/**
	 * @param allowed_methods the allowed_methods to set
	 */
	public void setAllowed_methods(List<String> allowed_methods) {
		this.allowed_methods = allowed_methods;
	}
	/**
	 * @return the allowed_headers
	 */
	public List<String> getAllowed_headers() {
		return allowed_headers;
	}
	/**
	 * @param allowed_headers the allowed_headers to set
	 */
	public void setAllowed_headers(List<String> allowed_headers) {
		this.allowed_headers = allowed_headers;
	}
	/**
	 * @return the exposed_headers
	 */
	public List<String> getExposed_headers() {
		return exposed_headers;
	}
	/**
	 * @param exposed_headers the exposed_headers to set
	 */
	public void setExposed_headers(List<String> exposed_headers) {
		this.exposed_headers = exposed_headers;
	}
	/**
	 * @return the allow_credentials
	 */
	public boolean isAllow_credentials() {
		return allow_credentials;
	}
	/**
	 * @param allow_credentials the allow_credentials to set
	 */
	public void setAllow_credentials(boolean allow_credentials) {
		this.allow_credentials = allow_credentials;
	}
	/**
	 * @return the max_age
	 */
	public Integer getMax_age() {
		return max_age;
	}
	/**
	 * @param max_age the max_age to set
	 */
	public void setMax_age(Integer max_age) {
		this.max_age = max_age;
	}
	/**
	 * @return the options_passthrough
	 */
	public boolean isOptions_passthrough() {
		return options_passthrough;
	}
	/**
	 * @param options_passthrough the options_passthrough to set
	 */
	public void setOptions_passthrough(boolean options_passthrough) {
		this.options_passthrough = options_passthrough;
	}
	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}
	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
