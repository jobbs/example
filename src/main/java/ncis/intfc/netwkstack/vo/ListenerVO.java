/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ListenerVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.netwkstack.vo;

/**
 * @author ShinKeeBong
 *
 */

public class ListenerVO {

	private String vip;                   //가상 IP 주소
    private String protocol;               //프로토콜
    private int port;                      //포트번호
    private String defaultTlsContainerRef; //TLS인증서

	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public String getDefaultTlsContainerRef() {
		return defaultTlsContainerRef;
	}
	public void setDefaultTlsContainerRef(String defaultTlsContainerRef) {
		this.defaultTlsContainerRef = defaultTlsContainerRef;
	}



}
