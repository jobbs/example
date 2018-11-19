/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmVO.java
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
 * 물리서버 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class PmVO {

	private String pmConfId;          /* 물리서버 구성ID   */
	private String managingKey;       /* 물리서버 UUID     */
	private String ipAddress;         /* IP주소            */
	private String osType;            /* 운영체제 명       */
	private Integer cpuCoreCnt;       /* CPU 코어 개수     */
	private Integer memorySize;       /* 메모리 용량       */
	private String hypervisorTypeCode;    /* 하이퍼바이저 타입코드 */
	private String hypervisorType;    /* 하이퍼바이저 타입 */
	private String clusterConfId;     /* 클러스터 구성ID   */
	private String parentManagingKey; /* 상위 존 UUID      */


	public String getPmConfId() {
		return pmConfId;
	}
	public void setPmConfId(String pmConfId) {
		this.pmConfId = pmConfId;
	}
	public String getManagingKey() {
		return managingKey;
	}
	public void setManagingKey(String managingKey) {
		this.managingKey = managingKey;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public Integer getCpuCoreCnt() {
		return cpuCoreCnt;
	}
	public void setCpuCoreCnt(Integer cpuCoreCnt) {
		this.cpuCoreCnt = cpuCoreCnt;
	}
	public Integer getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}
	public String getHypervisorTypeCode()
	{
		return hypervisorTypeCode;
	}
	public void setHypervisorTypeCode(String hypervisorTypeCode)
	{
		this.hypervisorTypeCode = hypervisorTypeCode;
	}
	public String getHypervisorType() {
		return hypervisorType;
	}
	public void setHypervisorType(String hypervisorType) {
		this.hypervisorType = hypervisorType;
	}
	public String getClusterConfId() {
		return clusterConfId;
	}
	public void setClusterConfId(String clusterConfId) {
		this.clusterConfId = clusterConfId;
	}
	public String getParentManagingKey() {
		return parentManagingKey;
	}
	public void setParentManagingKey(String parentManagingKey) {
		this.parentManagingKey = parentManagingKey;
	}
}
