/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteVo.java
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
 */


package ncis.dsb.stts.rsrcuse.vo;


public class JobRsrcStteVo  {
	private String institutionNm;
	private String institutionId;
	private String jobId;
	private String jobNm;
	private Long com;
	private String netwk;
	private Long autoCom;
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
	 * @return the com
	 */
	public Long getCom() {
		return com;
	}
	/**
	 * @param com the com to set
	 */
	public void setCom(Long com) {
		this.com = com;
	}
	/**
	 * @return the netwk
	 */
	public String getNetwk() {
		return netwk;
	}
	/**
	 * @param netwk the netwk to set
	 */
	public void setNetwk(String netwk) {
		this.netwk = netwk;
	}
	/**
	 * @return the autoCom
	 */
	public Long getAutoCom() {
		return autoCom;
	}
	/**
	 * @param autoCom the autoCom to set
	 */
	public void setAutoCom(Long autoCom) {
		this.autoCom = autoCom;
	}



}
