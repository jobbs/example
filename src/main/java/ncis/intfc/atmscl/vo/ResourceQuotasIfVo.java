/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResourceQuotasIfVo.java
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
public class ResourceQuotasIfVo {

	private String namespaceId; //namespaceId
	private String name; //쿼터 ID
	private String pods; //Pod 수
	private String requestsCpu;  //요청 CPU
	private String requestsMemory; //요청 메모리
	private String limitsCpu; //제한 CPU
	private String limitsMemory; //제한 메모리


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
	 * @return the pods
	 */
	public String getPods() {
		return pods;
	}
	/**
	 * @param pods the pods to set
	 */
	public void setPods(String pods) {
		this.pods = pods;
	}
	/**
	 * @return the requestsCpu
	 */
	public String getRequestsCpu() {
		return requestsCpu;
	}
	/**
	 * @param requestsCpu the requestsCpu to set
	 */
	public void setRequestsCpu(String requestsCpu) {
		this.requestsCpu = requestsCpu;
	}
	/**
	 * @return the requestsMemory
	 */
	public String getRequestsMemory() {
		return requestsMemory;
	}
	/**
	 * @param requestsMemory the requestsMemory to set
	 */
	public void setRequestsMemory(String requestsMemory) {
		this.requestsMemory = requestsMemory;
	}
	/**
	 * @return the limitsCpu
	 */
	public String getLimitsCpu() {
		return limitsCpu;
	}
	/**
	 * @param limitsCpu the limitsCpu to set
	 */
	public void setLimitsCpu(String limitsCpu) {
		this.limitsCpu = limitsCpu;
	}
	/**
	 * @return the limitsMemory
	 */
	public String getLimitsMemory() {
		return limitsMemory;
	}
	/**
	 * @param limitsMemory the limitsMemory to set
	 */
	public void setLimitsMemory(String limitsMemory) {
		this.limitsMemory = limitsMemory;
	}



}
