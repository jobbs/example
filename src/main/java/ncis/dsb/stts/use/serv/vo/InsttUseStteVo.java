/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttUseStteVo.java
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

package ncis.dsb.stts.use.serv.vo;

import java.math.BigDecimal;

public class InsttUseStteVo  {
	private String regionNm;
	private String mm;
	private String institutionNm;
	private BigDecimal jobId;
	private BigDecimal jobPer;
	private String vmSeq;
	private BigDecimal vmPer;
	private BigDecimal jobMin;
	private BigDecimal jobMax;
	private BigDecimal lastVcoreQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	private BigDecimal cpuAsgnCapa;
	private BigDecimal memTotCapa;
	private BigDecimal strgTotCapa;
	private String servcAreaSeq;
	private BigDecimal servcAreaPer;


	/**
	 * @return the mm
	 */
	public String getRegionNm() {
		return regionNm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	/**
	 *
	 */
	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
	}
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
	 * @return the jobId
	 */
	public BigDecimal getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(BigDecimal jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the jobPer
	 */
	public BigDecimal getJobPer() {
		return jobPer;
	}
	/**
	 * @param jobPer the jobPer to set
	 */
	public void setJobPer(BigDecimal jobPer) {
		this.jobPer = jobPer;
	}
	/**
	 * @return the vmId
	 */
	public String getVmSeq() {
		return vmSeq;
	}
	/**
	 * @param vmId the vmId to set
	 */
	public void setVmSeq(String vmSeq) {
		this.vmSeq = vmSeq;
	}
	/**
	 * @return the vmPer
	 */
	public BigDecimal getVmPer() {
		return vmPer;
	}
	/**
	 * @param vmPer the vmPer to set
	 */
	public void setVmPer(BigDecimal vmPer) {
		this.vmPer = vmPer;
	}
	/**
	 * @return the jobMin
	 */
	public BigDecimal getJobMin() {
		return jobMin;
	}
	/**
	 * @param jobMin the jobMin to set
	 */
	public void setJobMin(BigDecimal jobMin) {
		this.jobMin = jobMin;
	}
	/**
	 * @return the jobMax
	 */
	public BigDecimal getJobMax() {
		return jobMax;
	}
	/**
	 * @param jobMax the jobMax to set
	 */
	public void setJobMax(BigDecimal jobMax) {
		this.jobMax = jobMax;
	}
	/**
	 * @return the lastVcoreQty
	 */
	public BigDecimal getLastVcoreQty() {
		return lastVcoreQty;
	}
	/**
	 * @param lastVcoreQty the lastVcoreQty to set
	 */
	public void setLastVcoreQty(BigDecimal lastVcoreQty) {
		this.lastVcoreQty = lastVcoreQty;
	}
	/**
	 * @return the lastMemSumCapa
	 */
	public BigDecimal getLastMemSumCapa() {
		return lastMemSumCapa;
	}
	/**
	 * @param lastMemSumCapa the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(BigDecimal lastMemSumCapa) {
		this.lastMemSumCapa = lastMemSumCapa;
	}
	/**
	 * @return the lastStrgSumCapa
	 */
	public BigDecimal getLastStrgSumCapa() {
		return lastStrgSumCapa;
	}
	/**
	 * @param lastStrgSumCapa the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(BigDecimal lastStrgSumCapa) {
		this.lastStrgSumCapa = lastStrgSumCapa;
	}
	/**
	 * @return the cpuAsgnCapa
	 */
	public BigDecimal getCpuAsgnCapa() {
		return cpuAsgnCapa;
	}
	/**
	 * @param cpuAsgnCapa the cpuAsgnCapa to set
	 */
	public void setCpuAsgnCapa(BigDecimal cpuAsgnCapa) {
		this.cpuAsgnCapa = cpuAsgnCapa;
	}
	/**
	 * @return the memTotCapa
	 */
	public BigDecimal getMemTotCapa() {
		return memTotCapa;
	}
	/**
	 * @param memTotCapa the memTotCapa to set
	 */
	public void setMemTotCapa(BigDecimal memTotCapa) {
		this.memTotCapa = memTotCapa;
	}
	/**
	 * @return the strgTotCapa
	 */
	public BigDecimal getStrgTotCapa() {
		return strgTotCapa;
	}
	/**
	 * @param strgTotCapa the strgTotCapa to set
	 */
	public void setStrgTotCapa(BigDecimal strgTotCapa) {
		this.strgTotCapa = strgTotCapa;
	}
	/**
	 * @return the servcAreaSeq
	 */
	public String getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(String servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	/**
	 * @return the servcAreaPer
	 */
	public BigDecimal getServcAreaPer() {
		return servcAreaPer;
	}
	/**
	 * @param servcAreaPer the servcAreaPer to set
	 */
	public void setServcAreaPer(BigDecimal servcAreaPer) {
		this.servcAreaPer = servcAreaPer;
	}
}
