/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmCtrlResultBodyVO.java
 *
 * @author spa
 * @lastmodifier spa
 * @created 2016. 12. 5.
 * @lastmodified 2016. 12. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 5.     spa         v1.0             최초생성
 *
 */
package ncis.intfc.pmintfc.vo;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

/**
 * @author ihjang
 *
 */
public class PmStatusResultBodyVO extends SerializableSerializer{

	private static final long serialVersionUID = 1L;


	private String id; 							//물리 서버 ID
	private String status;	   					//물리서버상태
	private String name; 						// 물리서버명
	private String clusterId;					// 클러스터 ID
	private String clusterName;					// 클러스터명
	private String hypervisorKind;				// Hypervisor 종류
	private String virtualServerCount;			// 가상서버수
	private String cpuUseRate;					// CPU 사용율
	private String cpuVirtualRate;				// CPU 가상화율
	private String cpuEntitlement;				// CPU Entitlement
	private String cpuCore;						// CPU Core
	private String memoryUseRate;				// 메모리 사용율
	private String memoryVirtualRate;			// 메모리 가상화율
	private String memoryAllQuantity;			// 메모리 전체량

	private String statusCode;	   					//물리서버상태코드


	public String getId() {
		return id;
	}
	public void setId(String physicalServerId) {
		this.id = physicalServerId;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getClusterId()
	{
		return clusterId;
	}
	public void setClusterId(String clusterId)
	{
		this.clusterId = clusterId;
	}
	public String getClusterName()
	{
		return clusterName;
	}
	public void setClusterName(String clusterName)
	{
		this.clusterName = clusterName;
	}
	public String getHypervisorKind()
	{
		return hypervisorKind;
	}
	public void setHypervisorKind(String hypervisorKind)
	{
		this.hypervisorKind = hypervisorKind;
	}
	public String getVirtualServerCount()
	{
		return virtualServerCount;
	}
	public void setVirtualServerCount(String virtualServerCount)
	{
		this.virtualServerCount = virtualServerCount;
	}
	public String getCpuUseRate()
	{
		return cpuUseRate;
	}
	public void setCpuUseRate(String cpuUseRate)
	{
		this.cpuUseRate = cpuUseRate;
	}
	public String getCpuVirtualRate()
	{
		return cpuVirtualRate;
	}
	public void setCpuVirtualRate(String cpuVirtualRate)
	{
		this.cpuVirtualRate = cpuVirtualRate;
	}
	public String getCpuEntitlement()
	{
		return cpuEntitlement;
	}
	public void setCpuEntitlement(String cpuEntitlement)
	{
		this.cpuEntitlement = cpuEntitlement;
	}
	public String getCpuCore()
	{
		return cpuCore;
	}
	public void setCpuCore(String cpuCore)
	{
		this.cpuCore = cpuCore;
	}
	public String getMemoryUseRate()
	{
		return memoryUseRate;
	}
	public void setMemoryUseRate(String memoryUseRate)
	{
		this.memoryUseRate = memoryUseRate;
	}
	public String getMemoryVirtualRate()
	{
		return memoryVirtualRate;
	}
	public void setMemoryVirtualRate(String memoryVirtualRate)
	{
		this.memoryVirtualRate = memoryVirtualRate;
	}
	public String getMemoryAllQuantity()
	{
		return memoryAllQuantity;
	}
	public void setMemoryAllQuantity(String memoryAllQuantity)
	{
		this.memoryAllQuantity = memoryAllQuantity;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
