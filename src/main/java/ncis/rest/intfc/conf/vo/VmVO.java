/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmVO.java
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

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 가상서버 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class VmVO {

	private String managingKey;      /* 가상서버 UUID     */
	private String hostName;         /* 호스트 명         */
	@ApiModelProperty(value = "가상서버 구성ID", required = true)
	private String vmConfId;         /* 가상서버 구성ID   */
	private String rprsntIpAddress;  /* IP주소            */
	private String osTypeCode;           /* 운영체제 명       */
	private String osType;           /* 운영체제 명       */
	private String cpuCoreCnt;       /* CPU 코어 개수     */
	private String memorySize;       /* 메모리 용량       */
	private String diskSize;         /* 디스크 용량       */
	private String pmConfId;         /* 물리서버 구성ID   */
	private String clusterConfId;    /* 클러스터 구성ID   */

	private List<NicInfoVO> nicInfos; /* 네트워크인터페이스 정보 */


	public String getManagingKey() {
		return managingKey;
	}
	public void setManagingKey(String managingKey) {
		this.managingKey = managingKey;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getVmConfId() {
		return vmConfId;
	}
	public void setVmConfId(String vmConfId) {
		this.vmConfId = vmConfId;
	}
	public String getRprsntIpAddress() {
		return rprsntIpAddress;
	}
	public void setRprsntIpAddress(String rprsntIpAddress) {
		this.rprsntIpAddress = rprsntIpAddress;
	}
	public String getOsTypeCode()
	{
		return osTypeCode;
	}
	public void setOsTypeCode(String osTypeCode)
	{
		this.osTypeCode = osTypeCode;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getCpuCoreCnt() {
		return cpuCoreCnt;
	}
	public void setCpuCoreCnt(String cpuCoreCnt) {
		this.cpuCoreCnt = cpuCoreCnt;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public String getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}
	public String getPmConfId() {
		return pmConfId;
	}
	public void setPmConfId(String pmConfId) {
		this.pmConfId = pmConfId;
	}
	public String getClusterConfId() {
		return clusterConfId;
	}
	public void setClusterConfId(String clusterConfId) {
		this.clusterConfId = clusterConfId;
	}
	public List<NicInfoVO> getNicInfos() {
		return nicInfos;
	}
	public void setNicInfos(List<NicInfoVO> nicInfos) {
		this.nicInfos = nicInfos;
	}


}
