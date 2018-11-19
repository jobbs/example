/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NamespaceVO.java
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
public class NamespaceIfVo {

	private String displayName; //서비스영역 명
	private String description;  //서비스영역 설명
	private String requester; //서비스영역 요청자
	private String name; //서비스영역 ID

	private String pods; //Pod 수
	private String requestsCpu;  //요청 CPU
	private String requestsMemory; //요청 메모리
	private String limitsCpu; //제한 CPU
	private String limitsMemory; //제한 메모리

	private String maxCpu; //최대 CPU
	private String maxMemory;  //최대 메모리
	private String minCpu; //최소 CPU
	private String minMemory; //최소 메모리

	private String institutionId;  //부처Id
	private String jobId;  //업무Id

	private String namespaceId; //namespaceId


	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the requester
	 */
	public String getRequester() {
		return requester;
	}
	/**
	 * @param requester the requester to set
	 */
	public void setRequester(String requester) {
		this.requester = requester;
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
	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
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

}
