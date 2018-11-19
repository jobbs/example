/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndIntfcAsgnVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import ncis.cmn.entity.RcMacBndIntfcAsgn;

/**
 * @author 송승규
 *
 */
public class MacBndIntfcAsgnVo extends RcMacBndIntfcAsgn {

	/**
	 * 업무명
	 */
	private String institutionNm;

	/**
	 * 자원풀ID
	 */
	private String poolId;

	/**
	 * 자원풀명
	 */
	private String rsrcPoolNm;

	/**
	 * 가상서버명
	 */
	private String vmNm;

	/**
	 * 가상서버구성ID
	 */
	private String vmCompId;

	/**
	 * 네트워크인터페이스명
	 */
	private String netwkIntfcNm;

	/**
	 * 업무 for excel
	 */
	private String job;

	/**
	 * 할당일시 for excel
	 */
	private String asgnDate;

	/**
	 * 가상서버업무
	 */
	private String vmJob;

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
	 * @return the poolId
	 */
	public String getPoolId() {
		return poolId;
	}

	/**
	 * @param poolId the poolId to set
	 */
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}

	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
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
	 * @return the netwkIntfcNm
	 */
	public String getNetwkIntfcNm() {
		return netwkIntfcNm;
	}

	/**
	 * @param netwkIntfcNm the netwkIntfcNm to set
	 */
	public void setNetwkIntfcNm(String netwkIntfcNm) {
		this.netwkIntfcNm = netwkIntfcNm;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the asgnDate
	 */
	public String getAsgnDate() {
		return asgnDate;
	}

	/**
	 * @param asgnDate the asgnDate to set
	 */
	public void setAsgnDate(String asgnDate) {
		this.asgnDate = asgnDate;
	}

	/**
	 * @return the vmJob
	 */
	public String getVmJob() {
		return vmJob;
	}

	/**
	 * @param vmJob the vmJob to set
	 */
	public void setVmJob(String vmJob) {
		this.vmJob = vmJob;
	}
}
