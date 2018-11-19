/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NodeIfVo.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 21.
 * @lastmodified 2017. 06. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 21.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;


/**
 * @author x
 *
 */
public class NodeIfVo {

	private String loginId;
	private String loginPassword;
	private String machineIp;
	private String targetNodeDomainName;
	private String targetNodeIp;

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}
	/**
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	/**
	 * @return the machineIp
	 */
	public String getMachineIp() {
		return machineIp;
	}
	/**
	 * @param machineIp the machineIp to set
	 */
	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}
	/**
	 * @return the targetNodeDomainName
	 */
	public String getTargetNodeDomainName() {
		return targetNodeDomainName;
	}
	/**
	 * @param targetNodeDomainName the targetNodeDomainName to set
	 */
	public void setTargetNodeDomainName(String targetNodeDomainName) {
		this.targetNodeDomainName = targetNodeDomainName;
	}
	/**
	 * @return the targetNodeIp
	 */
	public String getTargetNodeIp() {
		return targetNodeIp;
	}
	/**
	 * @param targetNodeIp the targetNodeIp to set
	 */
	public void setTargetNodeIp(String targetNodeIp) {
		this.targetNodeIp = targetNodeIp;
	}

}
