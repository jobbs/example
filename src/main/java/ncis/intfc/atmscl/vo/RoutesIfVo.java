/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LbBodyVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;



/**
 * @author x
 *
 */
public class RoutesIfVo {

	private String name;
	private String host;
	private String namespaceId;
	private String serviceName;
	private String targetPort;
	private String baseImgId;
	private String servcAreaId;

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
	/**
	 * @return the namespaceId
	 */
	public String getNamespaceId() {
		return namespaceId;
	}
	/**
	 * @param namespaceId the namespaceId to set
	 */
	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the targetPort
	 */
	public String getTargetPort() {
		return targetPort;
	}
	/**
	 * @param targetPort the targetPort to set
	 */
	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
	}
	/**
	 * @return the baseImgId
	 */
	public String getBaseImgId() {
		return baseImgId;
	}
	/**
	 * @param baseImgId the baseImgId to set
	 */
	public void setBaseImgId(String baseImgId) {
		this.baseImgId = baseImgId;
	}
	/**
	 * @return the servcAreaId
	 */
	public String getServcAreaId() {
		return servcAreaId;
	}
	/**
	 * @param servcAreaId the servcAreaId to set
	 */
	public void setServcAreaId(String servcAreaId) {
		this.servcAreaId = servcAreaId;
	}

}
