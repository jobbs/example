/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmLogVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.vmLog.vo;



public class VmLogVo{
	private String jobNm;
	private String eqpLogColctDttm;
	private String vmCompId;
	private String vmNm;
	private String hstNm;
	private String eqpIpAddr;
	private String logMsg;

	/**
	 * @return the eqpLogColctDttm
	 */
	public String getJobNm() {
		return jobNm;
	}
	/**
	 * @param eqpLogColctDttm the eqpLogColctDttm to set
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}

	/**
	 * @return the eqpLogColctDttm
	 */
	public String getEqpLogColctDttm() {
		return eqpLogColctDttm;
	}
	/**
	 * @param eqpLogColctDttm the eqpLogColctDttm to set
	 */
	public void setEqpLogColctDttm(String eqpLogColctDttm) {
		this.eqpLogColctDttm = eqpLogColctDttm;
	}
	/**
	 * @return the vmCompId
	 */
	public String getVmCompId() {
		return vmCompId;
	}
	/**
	 * @param vmCompId the vmCompId to set
	 */
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	/**
	 * @return the vmNm
	 */
	public String getVmNm() {
		return vmNm;
	}
	/**
	 * @param vmNm the vmNm to set
	 */
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
	/**
	 * @return the hstNm
	 */
	public String getHstNm() {
		return hstNm;
	}
	/**
	 * @param hstNm the hstNm to set
	 */
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
	}
	/**
	 * @return the eqpIpAddr
	 */
	public String getEqpIpAddr() {
		return eqpIpAddr;
	}
	/**
	 * @param eqpIpAddr the eqpIpAddr to set
	 */
	public void setEqpIpAddr(String eqpIpAddr) {
		this.eqpIpAddr = eqpIpAddr;
	}
	/**
	 * @return the logMsg
	 */
	public String getLogMsg() {
		return logMsg;
	}
	/**
	 * @param logMsg the logMsg to set
	 */
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}


}
