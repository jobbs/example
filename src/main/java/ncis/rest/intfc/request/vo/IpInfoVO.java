/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NicInfoVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * 네크워크인터페이스 구성정보
 * @author ShinKeeBong
 *
 */
@JsonInclude(Include.NON_NULL)
public class IpInfoVO {
	@ApiModelProperty(value = "IP 용도코드", required = false)
	private String nicTypeCode;		/*IP 용도코드*/
	@ApiModelProperty(value = "IP 대역 SEQ", required = false)
	private String ipBndSeq;		/*	IP 주소*/
	@ApiModelProperty(value = "IP 주소", required = false)
	private String ipAddress;		/*	IP 주소*/
	@ApiModelProperty(value = "공인 IP 사용여부", required = false)
	private String userPublicIP;	/*	공인 IP 사용여부*/
	@ApiModelProperty(value = "공인 IP", required = false)
	private String publicIP;		/*	공인 IP*/
	@ApiModelProperty(value = "VIP 사용여부", required = false)
	private String useVip;			/*	VIP 사용여부*/
	@ApiModelProperty(value = "VIP", required = false)
	private String vip;				/*	VIP*/
	@ApiModelProperty(value = "IP(VIP) 사용여부", required = false)
	private String userPublicVIP;	/*	공인 IP(VIP) 사용여부*/
	@ApiModelProperty(value = "공인 IP(VIP)", required = false)
	private String publicVIP;		/*	공인 IP(VIP)*/
	/**
	 * @return the nicTypeCode
	 */
	public String getNicTypeCode() {
		return nicTypeCode;
	}
	/**
	 * @param nicTypeCode the nicTypeCode to set
	 */
	public void setNicTypeCode(String nicTypeCode) {
		this.nicTypeCode = nicTypeCode;
	}
	/**
	 * @return the ipBndSeq
	 */
	public String getIpBndSeq()
	{
		return ipBndSeq;
	}
	/**
	 * @param ipBndSeq the ipBndSeq to set
	 */
	public void setIpBndSeq(String ipBndSeq)
	{
		this.ipBndSeq = ipBndSeq;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the userPublicIP
	 */
	public String getUserPublicIP() {
		return userPublicIP;
	}
	/**
	 * @param userPublicIP the userPublicIP to set
	 */
	public void setUserPublicIP(String userPublicIP) {
		this.userPublicIP = userPublicIP;
	}
	/**
	 * @return the publicIP
	 */
	public String getPublicIP() {
		return publicIP;
	}
	/**
	 * @param publicIP the publicIP to set
	 */
	public void setPublicIP(String publicIP) {
		this.publicIP = publicIP;
	}
	/**
	 * @return the useVip
	 */
	public String getUseVip() {
		return useVip;
	}
	/**
	 * @param useVip the useVip to set
	 */
	public void setUseVip(String useVip) {
		this.useVip = useVip;
	}
	/**
	 * @return the vip
	 */
	public String getVip() {
		return vip;
	}
	/**
	 * @param vip the vip to set
	 */
	public void setVip(String vip) {
		this.vip = vip;
	}
	/**
	 * @return the userPublicVIP
	 */
	public String getUserPublicVIP() {
		return userPublicVIP;
	}
	/**
	 * @param userPublicVIP the userPublicVIP to set
	 */
	public void setUserPublicVIP(String userPublicVIP) {
		this.userPublicVIP = userPublicVIP;
	}
	/**
	 * @return the publicVIP
	 */
	public String getPublicVIP() {
		return publicVIP;
	}
	/**
	 * @param publicVIP the publicVIP to set
	 */
	public void setPublicVIP(String publicVIP) {
		this.publicVIP = publicVIP;
	}



}
