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
public class RemoveVmVmInfoVO {

	@ApiModelProperty(value = "가상서버구성ID", required = true)
	private String vmConfId;     /* 가상서버구성ID   */

	/**
	 * @return the vmConfId
	 */
	public String getVmConfId() {
		return vmConfId;
	}

	/**
	 * @param vmConfId the vmConfId to set
	 */
	public void setVmConfId(String vmConfId) {
		this.vmConfId = vmConfId;
	}

	


}
