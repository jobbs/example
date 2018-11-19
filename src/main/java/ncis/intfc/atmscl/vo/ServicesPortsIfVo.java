/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ServicesPortsIfVo.java
 *
 * @author x
 * @lastmodifier ServicesPortsIfVo
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
public class ServicesPortsIfVo {

	private Integer port;
	private Integer targetPort;
	private String protocol;
	private String name;

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the targetPort
	 */
	public Integer getTargetPort() {
		return targetPort;
	}
	/**
	 * @param targetPort the targetPort to set
	 */
	public void setTargetPort(Integer targetPort) {
		this.targetPort = targetPort;
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
