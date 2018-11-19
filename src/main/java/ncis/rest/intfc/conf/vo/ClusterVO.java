/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClusterVO.java
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
package ncis.rest.intfc.conf.vo;


/**
 * 클러스터 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class ClusterVO {

	private String clConfId;           /* 클러스터 구성ID */
	private String managingKey;        /* 클러스터 UUID   */
	private String zoneName;           /* 존 이름         */
	private String clusterName;        /* 클러스터 이름   */
	private Integer pmCnt;             /* 물리서버 개수   */
	private Integer vmCnt;             /* 가상서버 개수   */
	private String parentManagingKey;  /* 상위 존 UUID    */


	public String getClConfId() {
		return clConfId;
	}
	public void setClConfId(String clConfId) {
		this.clConfId = clConfId;
	}
	public String getManagingKey() {
		return managingKey;
	}
	public void setManagingKey(String managingKey) {
		this.managingKey = managingKey;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public Integer getPmCnt() {
		return pmCnt;
	}
	public void setPmCnt(Integer pmCnt) {
		this.pmCnt = pmCnt;
	}
	public Integer getVmCnt() {
		return vmCnt;
	}
	public void setVmCnt(Integer vmCnt) {
		this.vmCnt = vmCnt;
	}
	public String getParentManagingKey() {
		return parentManagingKey;
	}
	public void setParentManagingKey(String parentManagingKey) {
		this.parentManagingKey = parentManagingKey;
	}
}
