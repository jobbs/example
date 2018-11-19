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
public class CreatePmPmInfoVO {

	@ApiModelProperty(value = "물리서버구성ID", required = true)
	private String pmConfId;     /* 물리서버구성ID   */
	@ApiModelProperty(value = "클러스터구성ID", required = true)
	private String clusterConfId;	/*클러스터구성ID */
	@ApiModelProperty(value = "물리서버 구성자원명", required = true)
	private String pmName;	/*물리서버 구성자원명*/


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

	/**
	 * @return the clusterConfId
	 */
	public String getClusterConfId() {
		return clusterConfId;
	}

	/**
	 * @param clusterConfId the clusterConfId to set
	 */
	public void setClusterConfId(String clusterConfId) {
		this.clusterConfId = clusterConfId;
	}

	/**
	 * @return the pmName
	 */
	public String getPmName() {
		return pmName;
	}

	/**
	 * @param pmName the pmName to set
	 */
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}


}
