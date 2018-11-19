/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmDetailResultBodyVO.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 2. 1.
 * @lastmodified 2017. 2. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 2. 1.     selim         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author ihjang
 *
 */
public class VmDetailResultBodyVO
{
	private String id;    				//가상 서버ID
	private String clusterId;			//상위 클러스터  ID
	private String physicalServerId;	//상위 쿨리서버  ID
	private String name;  //가상 서버명
	private String description;			// 설명
	private String created;				// 생성일자
	private String started; 			//기동일시
	private String hostName;			// cloud-init 설정 호스트명
	private List<NicConfiguration> nicConfigurations; // cloud-init 설정  네트워크 정보
	private String osType;				// OS 종류
	private String os;					// OS 명
	private String status;				// 상태
	private String memory;				// 메모리
	private List<Volume> volumes;		// 가상서버 볼륨 정보
	private String cpu;					// CPU
	private String cpuArchitecture;		// CPU 아키텍쳐
	private String cpuSpeed;			// CPU 속도
	private List<Nic> nics;				// 가상서버 네트워크 인터페이스
	private List<Meter> meters;
	private DisplayVO display;


	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/**
	 * @return the clusterId
	 */
	public String getClusterId()
	{
		return clusterId;
	}


	/**
	 * @param clusterId the clusterId to set
	 */
	public void setClusterId(String clusterId)
	{
		this.clusterId = clusterId;
	}


	/**
	 * @return the physicalServerId
	 */
	public String getPhysicalServerId()
	{
		return physicalServerId;
	}


	/**
	 * @param physicalServerId the physicalServerId to set
	 */
	public void setPhysicalServerId(String physicalServerId)
	{
		this.physicalServerId = physicalServerId;
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}


	/**
	 * @return the created
	 */
	public String getCreated()
	{
		return created;
	}


	/**
	 * @param created the created to set
	 */
	public void setCreated(String created)
	{
		this.created = created;
	}


	/**
	 * @return the started
	 */
	public String getStarted()
	{
		return started;
	}


	/**
	 * @param started the started to set
	 */
	public void setStarted(String started)
	{
		this.started = started;
	}


	/**
	 * @return the hostName
	 */
	public String getHostName()
	{
		return hostName;
	}


	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName)
	{
		this.hostName = hostName;
	}


	/**
	 * @return the nicConfigurations
	 */
	public List<NicConfiguration> getNicConfigurations()
	{
		return nicConfigurations;
	}


	/**
	 * @param nicConfigurations the nicConfigurations to set
	 */
	public void setNicConfigurations(List<NicConfiguration> nicConfigurations)
	{
		this.nicConfigurations = nicConfigurations;
	}


	/**
	 * @return the osType
	 */
	public String getOsType()
	{
		return osType;
	}


	/**
	 * @param osType the osType to set
	 */
	public void setOsType(String osType)
	{
		this.osType = osType;
	}


	/**
	 * @return the os
	 */
	public String getOs()
	{
		return os;
	}


	/**
	 * @param os the os to set
	 */
	public void setOs(String os)
	{
		this.os = os;
	}


	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}


	/**
	 * @return the memory
	 */
	public String getMemory()
	{
		return memory;
	}


	/**
	 * @param memory the memory to set
	 */
	public void setMemory(String memory)
	{
		this.memory = memory;
	}


	/**
	 * @return the volumes
	 */
	public List<Volume> getVolumes()
	{
		return volumes;
	}


	/**
	 * @param volumes the volumes to set
	 */
	public void setVolumes(List<Volume> volumes)
	{
		this.volumes = volumes;
	}


	/**
	 * @return the cpu
	 */
	public String getCpu()
	{
		return cpu;
	}


	/**
	 * @param cpu the cpu to set
	 */
	public void setCpu(String cpu)
	{
		this.cpu = cpu;
	}


	/**
	 * @return the cpuArchitecture
	 */
	public String getCpuArchitecture()
	{
		return cpuArchitecture;
	}


	/**
	 * @param cpuArchitecture the cpuArchitecture to set
	 */
	public void setCpuArchitecture(String cpuArchitecture)
	{
		this.cpuArchitecture = cpuArchitecture;
	}


	/**
	 * @return the cpuSpeed
	 */
	public String getCpuSpeed()
	{
		return cpuSpeed;
	}


	/**
	 * @param cpuSpeed the cpuSpeed to set
	 */
	public void setCpuSpeed(String cpuSpeed)
	{
		this.cpuSpeed = cpuSpeed;
	}


	/**
	 * @return the nics
	 */
	public List<Nic> getNics()
	{
		return nics;
	}


	/**
	 * @param nics the nics to set
	 */
	public void setNics(List<Nic> nics)
	{
		this.nics = nics;
	}


	/**
	 * @return the meters
	 */
	public List<Meter> getMeters()
	{
		return meters;
	}


	/**
	 * @param meters the meters to set
	 */
	public void setMeters(List<Meter> meters)
	{
		this.meters = meters;
	}


	/**
	 * @return the display
	 */
	public DisplayVO getDisplay()
	{
		return display;
	}


	/**
	 * @param display the display to set
	 */
	public void setDisplay(DisplayVO display)
	{
		this.display = display;
	}


	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
