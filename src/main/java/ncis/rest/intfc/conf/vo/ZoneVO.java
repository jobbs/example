/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneVO.java
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
 * 존 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class ZoneVO {

	private String znConfId;       /* 존 구성ID     */
	private String managingKey;    /* 존 UUID       */
	private String zoneName;       /* 존 이름       */
	private Integer clusterCnt;    /* 클러스터 개수 */
	private Integer pmCnt;         /* 물리서버 개수 */
	private Integer vmCnt;         /* 가상서버 개수 */


	public String getZnConfId() {
		return znConfId;
	}
	public void setZnConfId(String znConfId) {
		this.znConfId = znConfId;
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
	public Integer getClusterCnt() {
		return clusterCnt;
	}
	public void setClusterCnt(Integer clusterCnt) {
		this.clusterCnt = clusterCnt;
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


}
