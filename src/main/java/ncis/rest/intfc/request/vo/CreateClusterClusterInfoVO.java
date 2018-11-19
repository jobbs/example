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
public class CreateClusterClusterInfoVO {

	@ApiModelProperty(value = "클러스터구성자원명", required = true)
	private String clusterConfId;     /* 클러스터구성ID   */
	
	@ApiModelProperty(value = "클러스터구성자원명", required = false)
	private String clusterName;    /* 클러스터구성자원명 */
	@ApiModelProperty(value = "망구분코드", required = false)
	private String networkCode;    /* 망구분             */
	@ApiModelProperty(value = "용도", required = false)
	private String purposeCode;    /* 용도               */

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
	 * @return the clusterName
	 */
	public String getClusterName() {
		return clusterName;
	}

	/**
	 * @param clusterName the clusterName to set
	 */
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	/**
	 * @return the networkCode
	 */
	public String getNetworkCode() {
		return networkCode;
	}

	/**
	 * @param networkCode the networkCode to set
	 */
	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	/**
	 * @return the purposeCode
	 */
	public String getPurposeCode() {
		return purposeCode;
	}

	/**
	 * @param purposeCode the purposeCode to set
	 */
	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

}
