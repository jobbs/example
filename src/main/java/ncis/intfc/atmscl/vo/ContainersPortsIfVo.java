/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ContainersPortsIfVo.java
 *
 * @author x
 * @lastmodifier ContainersPortsIfVo
 * @created 2017. 06. 11.
 * @lastmodified 2017. 06. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 11.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;


/**
 * @author x
 *
 */
public class ContainersPortsIfVo {

	private Integer containerPort;
	private String protocol;

	/**
	 * @return the containerPort
	 */
	public Integer getContainerPort() {
		return containerPort;
	}
	/**
	 * @param containerPort the containerPort to set
	 */
	public void setContainerPort(Integer containerPort) {
		this.containerPort = containerPort;
	}
	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}
	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}



}
