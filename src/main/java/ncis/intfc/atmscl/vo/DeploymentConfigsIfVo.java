/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DeploymentConfigsIfVo.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 27.
 * @lastmodified 2017. 06. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 27.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

import java.util.List;



/**
 * @author x
 *
 */
public class DeploymentConfigsIfVo {

	private String name;
	private Integer replicas;
	private String namespaceId;
	private String serviceName;
	private String imgId;
	private String baseImgId;
	private String defaultYn;
	private String imgRepoAddr;

	List<ContainersPortsIfVo> ports;
	List<EnvIfVo> envList;


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
	 * @return the replicas
	 */
	public Integer getReplicas() {
		return replicas;
	}
	/**
	 * @param replicas the replicas to set
	 */
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
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
	 * @return the imgId
	 */
	public String getImgId() {
		return imgId;
	}
	/**
	 * @param imgId the imgId to set
	 */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	/**
	 * @return the ports
	 */
	public List<ContainersPortsIfVo> getPorts() {
		return ports;
	}
	/**
	 * @param ports the ports to set
	 */
	public void setPorts(List<ContainersPortsIfVo> ports) {
		this.ports = ports;
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
	 * @return the defaultYn
	 */
	public String getDefaultYn() {
		return defaultYn;
	}
	/**
	 * @param defaultYn the defaultYn to set
	 */
	public void setDefaultYn(String defaultYn) {
		this.defaultYn = defaultYn;
	}
	/**
	 * @return the envList
	 */
	public List<EnvIfVo> getEnvList() {
		return envList;
	}
	/**
	 * @param envList the envList to set
	 */
	public void setEnvList(List<EnvIfVo> envList) {
		this.envList = envList;
	}
	/**
	 * @return the imgRepoAddr
	 */
	public String getImgRepoAddr() {
		return imgRepoAddr;
	}
	/**
	 * @param imgRepoAddr the imgRepoAddr to set
	 */
	public void setImgRepoAddr(String imgRepoAddr) {
		this.imgRepoAddr = imgRepoAddr;
	}


}
