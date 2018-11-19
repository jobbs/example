/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NicConfiguration.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

/**
 * @author ShinKeeBong
 *
 */
public class NicConfiguration {

	private String name;        //CloudInit 설정 Guest OS NIC 이름
	private String ip;          //CloudInit 설정 Guest OS IP주소
	private String netmask;     //CloudInit 설정 Guest OS Net Mask
	private String gateway;     //CloudInit 설정 Guest OS 게이트웨이 주소
	private String bootProtocol;//CloudInit 설정 Guest OS IP 할당 유형
	private boolean onBoot;    //CloudInit 설정 Guest OS 부팅시 시작 설정


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getBootProtocol() {
		return bootProtocol;
	}
	public void setBootProtocol(String bootProtocol) {
		this.bootProtocol = bootProtocol;
	}
	public boolean isOnBoot() {
		return onBoot;
	}
	public void setOnBoot(boolean onBoot) {
		this.onBoot = onBoot;
	}


}
