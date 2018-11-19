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

/**
 * @author wisecom
 *
 */
public class RemoveClusterClusterInfoVO {

	private String clusterConfId;     /* 클러스터구성ID   */

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

}
