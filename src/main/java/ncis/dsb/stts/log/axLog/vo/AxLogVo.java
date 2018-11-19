/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.vo;


public class AxLogVo{
	private String	institutionNm;
	private String jobNm;
	private String logColctDttm;
	private String servcAreaCompId;
	private String servcAreaNm;
	private String logMsg;

	/**
	 * @return the institutionNm
	 */
	public String getInstitutionNm() {
		return institutionNm;
	}
	/**
	 * @param institutionNm the institutionNm to set
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	/**
	 * @return the jobNm
	 */
	public String getJobNm() {
		return jobNm;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	/**
	 * @return the logColctDttm
	 */
	public String getLogColctDttm() {
		return logColctDttm;
	}
	/**
	 * @param logColctDttm the logColctDttm to set
	 */
	public void setLogColctDttm(String logColctDttm) {
		this.logColctDttm = logColctDttm;
	}
	/**
	 * @return the servcAreaCompId
	 */
	public String getServcAreaCompId() {
		return servcAreaCompId;
	}
	/**
	 * @param servcAreaCompId the servcAreaCompId to set
	 */
	public void setServcAreaCompId(String servcAreaCompId) {
		this.servcAreaCompId = servcAreaCompId;
	}
	/**
	 * @return the servcAreaNm
	 */
	public String getServcAreaNm() {
		return servcAreaNm;
	}
	/**
	 * @param servcAreaNm the servcAreaNm to set
	 */
	public void setServcAreaNm(String servcAreaNm) {
		this.servcAreaNm = servcAreaNm;
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
