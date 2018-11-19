/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MethodActionsVo.java
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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 이제율
 *
 */
public class MethodActionsVo {
	@JsonProperty("GET")
	private IgnoreGetVo get;

	/**
	 * @return the get
	 */
	public IgnoreGetVo getGet() {
		return get;
	}

	/**
	 * @param get the get to set
	 */
	public void setGet(IgnoreGetVo get) {
		this.get = get;
	}
}
