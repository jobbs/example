/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VersionsVo.java
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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 이제율
 *
 */
public class VersionsVo {
	@JsonProperty("Default")
	private VersionNameVo verName;

	/**
	 * @return the verName
	 */
	public VersionNameVo getVerName() {
		return verName;
	}

	/**
	 * @param verName the verName to set
	 */
	public void setVerName(VersionNameVo verName) {
		this.verName = verName;
	}


}
