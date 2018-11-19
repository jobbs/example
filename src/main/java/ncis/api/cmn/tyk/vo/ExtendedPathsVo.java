/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ExtendedPathsVo.java
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
public class ExtendedPathsVo {
	private List<IgnoredVo> ignored;
	private List<WhiteListVo> white_list;
	private List<BackListVo> black_list;
	private List<CacheVo> cache;
	private List<TransformVo> transform;
	private List<TransformResponseVo> transform_response;
	private List<TransformHeadersVo> transform_headers;
	private List<TransformResponseHeadersVo> transform_response_headers;
	private List<HardTimeoutsVo> hard_timeouts;
	private List<CircuitBreakersVo> circuit_breakers;
	private List<UrlRewritesVo> url_rewrites;
	private List<VirtualPathVo> virtual;
	private List<SizeLimitsVo> size_limits;
	private List<MethodTransformsVo> method_transforms;
	/**
	 * @return the ignored
	 */
	public List<IgnoredVo> getIgnored() {
		return ignored;
	}
	/**
	 * @param ignored the ignored to set
	 */
	public void setIgnored(List<IgnoredVo> ignored) {
		this.ignored = ignored;
	}
	/**
	 * @return the white_list
	 */
	public List<WhiteListVo> getWhite_list() {
		return white_list;
	}
	/**
	 * @param white_list the white_list to set
	 */
	public void setWhite_list(List<WhiteListVo> white_list) {
		this.white_list = white_list;
	}
	/**
	 * @return the black_list
	 */
	public List<BackListVo> getBlack_list() {
		return black_list;
	}
	/**
	 * @param black_list the black_list to set
	 */
	public void setBlack_list(List<BackListVo> black_list) {
		this.black_list = black_list;
	}
	/**
	 * @return the cache
	 */
	public List<CacheVo> getCache() {
		return cache;
	}
	/**
	 * @param cache the cache to set
	 */
	public void setCache(List<CacheVo> cache) {
		this.cache = cache;
	}
	/**
	 * @return the transform
	 */
	public List<TransformVo> getTransform() {
		return transform;
	}
	/**
	 * @param transform the transform to set
	 */
	public void setTransform(List<TransformVo> transform) {
		this.transform = transform;
	}
	/**
	 * @return the transform_response
	 */
	public List<TransformResponseVo> getTransform_response() {
		return transform_response;
	}
	/**
	 * @param transform_response the transform_response to set
	 */
	public void setTransform_response(List<TransformResponseVo> transform_response) {
		this.transform_response = transform_response;
	}
	/**
	 * @return the transform_headers
	 */
	public List<TransformHeadersVo> getTransform_headers() {
		return transform_headers;
	}
	/**
	 * @param transform_headers the transform_headers to set
	 */
	public void setTransform_headers(List<TransformHeadersVo> transform_headers) {
		this.transform_headers = transform_headers;
	}
	/**
	 * @return the transform_response_headers
	 */
	public List<TransformResponseHeadersVo> getTransform_response_headers() {
		return transform_response_headers;
	}
	/**
	 * @param transform_response_headers the transform_response_headers to set
	 */
	public void setTransform_response_headers(
			List<TransformResponseHeadersVo> transform_response_headers) {
		this.transform_response_headers = transform_response_headers;
	}
	/**
	 * @return the hard_timeouts
	 */
	public List<HardTimeoutsVo> getHard_timeouts() {
		return hard_timeouts;
	}
	/**
	 * @param hard_timeouts the hard_timeouts to set
	 */
	public void setHard_timeouts(List<HardTimeoutsVo> hard_timeouts) {
		this.hard_timeouts = hard_timeouts;
	}
	/**
	 * @return the circuit_breakers
	 */
	public List<CircuitBreakersVo> getCircuit_breakers() {
		return circuit_breakers;
	}
	/**
	 * @param circuit_breakers the circuit_breakers to set
	 */
	public void setCircuit_breakers(List<CircuitBreakersVo> circuit_breakers) {
		this.circuit_breakers = circuit_breakers;
	}
	/**
	 * @return the url_rewrites
	 */
	public List<UrlRewritesVo> getUrl_rewrites() {
		return url_rewrites;
	}
	/**
	 * @param url_rewrites the url_rewrites to set
	 */
	public void setUrl_rewrites(List<UrlRewritesVo> url_rewrites) {
		this.url_rewrites = url_rewrites;
	}
	/**
	 * @return the virtual
	 */
	public List<VirtualPathVo> getVirtual() {
		return virtual;
	}
	/**
	 * @param virtual the virtual to set
	 */
	public void setVirtual(List<VirtualPathVo> virtual) {
		this.virtual = virtual;
	}
	/**
	 * @return the size_limits
	 */
	public List<SizeLimitsVo> getSize_limits() {
		return size_limits;
	}
	/**
	 * @param size_limits the size_limits to set
	 */
	public void setSize_limits(List<SizeLimitsVo> size_limits) {
		this.size_limits = size_limits;
	}
	/**
	 * @return the method_transforms
	 */
	public List<MethodTransformsVo> getMethod_transforms() {
		return method_transforms;
	}
	/**
	 * @param method_transforms the method_transforms to set
	 */
	public void setMethod_transforms(List<MethodTransformsVo> method_transforms) {
		this.method_transforms = method_transforms;
	}

}
