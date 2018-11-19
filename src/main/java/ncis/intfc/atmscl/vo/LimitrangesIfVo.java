/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LimitrangesIfVo.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 31.
 * @lastmodified 2017. 05. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 31.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

/**
 * @author x
 *
 */
public class LimitrangesIfVo {

	private String namespaceId; //namespaceId
	private String name; //제한 ID
	private String maxCpu; //최대 CPU
	private String maxMemory;  //최대 메모리
	private String minCpu; //최소 CPU
	private String minMemory; //최소 메모리

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
	 * @return the maxCpu
	 */
	public String getMaxCpu() {
		return maxCpu;
	}
	/**
	 * @param maxCpu the maxCpu to set
	 */
	public void setMaxCpu(String maxCpu) {
		this.maxCpu = maxCpu;
	}
	/**
	 * @return the maxMemory
	 */
	public String getMaxMemory() {
		return maxMemory;
	}
	/**
	 * @param maxMemory the maxMemory to set
	 */
	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}
	/**
	 * @return the minCpu
	 */
	public String getMinCpu() {
		return minCpu;
	}
	/**
	 * @param minCpu the minCpu to set
	 */
	public void setMinCpu(String minCpu) {
		this.minCpu = minCpu;
	}
	/**
	 * @return the minMemory
	 */
	public String getMinMemory() {
		return minMemory;
	}
	/**
	 * @param minMemory the minMemory to set
	 */
	public void setMinMemory(String minMemory) {
		this.minMemory = minMemory;
	}
}
