/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VirtualtVo.java
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

/**
 * @author 이제율
 *
 */
public class VirtualPathVo {
	private String response_function_name;
    private String function_source_type;
    private String function_source_uri;
    private String path;
    private String method;
	/**
	 * @return the response_function_name
	 */
	public String getResponse_function_name() {
		return response_function_name;
	}
	/**
	 * @param response_function_name the response_function_name to set
	 */
	public void setResponse_function_name(String response_function_name) {
		this.response_function_name = response_function_name;
	}
	/**
	 * @return the function_source_type
	 */
	public String getFunction_source_type() {
		return function_source_type;
	}
	/**
	 * @param function_source_type the function_source_type to set
	 */
	public void setFunction_source_type(String function_source_type) {
		this.function_source_type = function_source_type;
	}
	/**
	 * @return the function_source_uri
	 */
	public String getFunction_source_uri() {
		return function_source_uri;
	}
	/**
	 * @param function_source_uri the function_source_uri to set
	 */
	public void setFunction_source_uri(String function_source_uri) {
		this.function_source_uri = function_source_uri;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
}
