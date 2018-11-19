/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DisplayVO.java
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
public class DisplayVO {

	private String type;             //그래픽 프로토콜
	private String address;          //접속IP
	private String port;             //접속PORT
	private String securePort;       //접속 SECURE PORT
	private String singleQxlPci;   //그래픽 유형

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getSecurePort() {
		return securePort;
	}
	public void setSecurePort(String securePort) {
		this.securePort = securePort;
	}
	public String getSingleQxlPci() {
		return singleQxlPci;
	}
	public void setSingleQxlPci(String singleQxlPci) {
		this.singleQxlPci = singleQxlPci;
	}



}
