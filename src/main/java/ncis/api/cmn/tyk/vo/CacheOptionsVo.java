/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CacheOptionsVo.java
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
public class CacheOptionsVo {
	private Integer cache_timeout = 60;
	private boolean enable_cache = true;
	private boolean cache_all_safe_requests = false;
	private List<String> cache_response_codes;
	private boolean enable_upstream_cache_control = false;
	/**
	 * @return the cache_timeout
	 */
	public Integer getCache_timeout() {
		return cache_timeout;
	}
	/**
	 * @param cache_timeout the cache_timeout to set
	 */
	public void setCache_timeout(Integer cache_timeout) {
		this.cache_timeout = cache_timeout;
	}
	/**
	 * @return the enable_cache
	 */
	public boolean isEnable_cache() {
		return enable_cache;
	}
	/**
	 * @param enable_cache the enable_cache to set
	 */
	public void setEnable_cache(boolean enable_cache) {
		this.enable_cache = enable_cache;
	}
	/**
	 * @return the cache_all_safe_requests
	 */
	public boolean isCache_all_safe_requests() {
		return cache_all_safe_requests;
	}
	/**
	 * @param cache_all_safe_requests the cache_all_safe_requests to set
	 */
	public void setCache_all_safe_requests(boolean cache_all_safe_requests) {
		this.cache_all_safe_requests = cache_all_safe_requests;
	}
	/**
	 * @return the cache_response_codes
	 */
	public List<String> getCache_response_codes() {
		return cache_response_codes;
	}
	/**
	 * @param cache_response_codes the cache_response_codes to set
	 */
	public void setCache_response_codes(List<String> cache_response_codes) {
		this.cache_response_codes = cache_response_codes;
	}
	/**
	 * @return the enable_upstream_cache_control
	 */
	public boolean isEnable_upstream_cache_control() {
		return enable_upstream_cache_control;
	}
	/**
	 * @param enable_upstream_cache_control the enable_upstream_cache_control to set
	 */
	public void setEnable_upstream_cache_control(
			boolean enable_upstream_cache_control) {
		this.enable_upstream_cache_control = enable_upstream_cache_control;
	}
}
