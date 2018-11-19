/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Nic.java
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

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 가상서버 네트워크 인터페이스
 * @author ihjang
 *
 */
public class Nic
{
	private String id;			// 가상서버  NIC ID
	private String name;		// 가상서버 NIC 명
	private String state;		// 가상서버 상태
	private String mac;			// 가상서버 MAC
	private String ip;			// 가상서버  IP 주소
	private String inNet;		// 초당 네트워크 수신량
	private String outNet;		// 초당 네트워크 송신량
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
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	/**
	 * @return the mac
	 */
	public String getMac()
	{
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac)
	{
		this.mac = mac;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIp()
	{
		return ip;
	}
	/**
	 * @param ipAddress the ip to set
	 */
	public void setIp(String ipAddress)
	{
		this.ip = ipAddress;
	}
	/**
	 * @return the inNet
	 */
	public String getInNet()
	{
		return inNet;
	}
	/**
	 * @param inNet the inNet to set
	 */
	public void setInNet(String inNet)
	{
		this.inNet = inNet;
	}
	/**
	 * @return the outNet
	 */
	public String getOutNet()
	{
		return outNet;
	}
	/**
	 * @param outNet the outNet to set
	 */
	public void setOutNet(String outNet)
	{
		this.outNet = outNet;
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
