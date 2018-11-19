/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RemoveClusterVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wisecom
 *
 */
public class RemovePmPmInfoVO {

	@ApiModelProperty(value = "물리서버구성ID", required = true)
	private String pmConfId;     /* 물리서버구성ID   */

	/**
	 * @return the pmConfId
	 */
	public String getPmConfId() {
		return pmConfId;
	}

	/**
	 * @param pmConfId the pmConfId to set
	 */
	public void setPmConfId(String pmConfId) {
		this.pmConfId = pmConfId;
	}


}
