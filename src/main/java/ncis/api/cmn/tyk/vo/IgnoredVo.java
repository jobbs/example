/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IgnoredVo.java
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
public class IgnoredVo {
	private String path="/healthcheck";
	private MethodActionsVo method_actions;

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
	 * @return the method_actions
	 */
	public MethodActionsVo getMethod_actions() {
		return method_actions;
	}
	/**
	 * @param method_actions the method_actions to set
	 */
	public void setMethod_actions(MethodActionsVo method_actions) {
		this.method_actions = method_actions;
	}
}
