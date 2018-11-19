/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobVmStteVo.java
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
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;


public class JobVmStteVo {
	private String institutionNm;
	private String institutionId;
	private BigDecimal institutionCnt;
	private String jobNm;
	private String jobId;
	private BigDecimal jobCnt;
	private BigDecimal vmSeq;
	private BigDecimal vmCnt;
	private BigDecimal rnCnt;
	private BigDecimal jobAvgCpuUseRt;
	private BigDecimal jobAvgMemUseRt;
	private BigDecimal jobAvgStrgUseRt;
	private String cdNm;
	private String cd;
	private String cdCnt;
	private BigDecimal cdLastVcoreQty;
	private BigDecimal cdAvgCpuUseRt;
	private BigDecimal cdLastMemSumCapa;
	private BigDecimal cdAvgMemUseRt;
	private BigDecimal cdLastStrgSumCapa;
	private BigDecimal cdAvgStrgUseRt;
	private String vmNm;
	private String vmCompId;
	private String hstNm;
	private BigDecimal lastVcoreQty;
	private BigDecimal avgCpuUseRt;
	private BigDecimal lastMemSumCapa;
	private BigDecimal avgMemUseRt;
	private BigDecimal lastStrgSumCapa;
	private BigDecimal avgStrgUseRt;
	private BigDecimal avgInTrfic;
	private BigDecimal avgOutTrfic;
	private String regionNm;
	private String zoneNm;
	private String netNm;
	private String rsrcPoolNm;
	private String clstrNm;
	private String pmNm;
	private String pmCompId;
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
	 * @return the institutionCnt
	 */
	public BigDecimal getInstitutionCnt() {
		return institutionCnt;
	}
	/**
	 * @param institutionCnt the institutionCnt to set
	 */
	public void setInstitutionCnt(BigDecimal institutionCnt) {
		this.institutionCnt = institutionCnt;
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
	 * @return the jobCnt
	 */
	public BigDecimal getJobCnt() {
		return jobCnt;
	}
	/**
	 * @param jobCnt the jobCnt to set
	 */
	public void setJobCnt(BigDecimal jobCnt) {
		this.jobCnt = jobCnt;
	}
	/**
	 * @return the vmSeq
	 */
	public BigDecimal getVmSeq() {
		return vmSeq;
	}
	/**
	 * @param vmSeq the vmSeq to set
	 */
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}
	/**
	 * @return the vmCnt
	 */
	public BigDecimal getVmCnt() {
		return vmCnt;
	}
	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(BigDecimal vmCnt) {
		this.vmCnt = vmCnt;
	}

	/**
	 * @return the rnCnt
	 */
	public BigDecimal getRnCnt() {
		return rnCnt;
	}
	/**
	 * @param rnCnt the vmCnt to set
	 */
	public void setRnCnt(BigDecimal rnCnt) {
		this.rnCnt = rnCnt;
	}
	/**
	 * @return the jobAvgCpuUseRt
	 */
	public BigDecimal getJobAvgCpuUseRt() {
		return jobAvgCpuUseRt;
	}
	/**
	 * @param jobAvgCpuUseRt the jobAvgCpuUseRt to set
	 */
	public void setJobAvgCpuUseRt(BigDecimal jobAvgCpuUseRt) {
		this.jobAvgCpuUseRt = jobAvgCpuUseRt;
	}
	/**
	 * @return the jobAvgMemUseRt
	 */
	public BigDecimal getJobAvgMemUseRt() {
		return jobAvgMemUseRt;
	}
	/**
	 * @param jobAvgMemUseRt the jobAvgMemUseRt to set
	 */
	public void setJobAvgMemUseRt(BigDecimal jobAvgMemUseRt) {
		this.jobAvgMemUseRt = jobAvgMemUseRt;
	}
	/**
	 * @return the jobAvgStrgUseRt
	 */
	public BigDecimal getJobAvgStrgUseRt() {
		return jobAvgStrgUseRt;
	}
	/**
	 * @param jobAvgStrgUseRt the jobAvgStrgUseRt to set
	 */
	public void setJobAvgStrgUseRt(BigDecimal jobAvgStrgUseRt) {
		this.jobAvgStrgUseRt = jobAvgStrgUseRt;
	}
	/**
	 * @return the cdNm
	 */
	public String getCdNm() {
		return cdNm;
	}
	/**
	 * @param cdNm the cdNm to set
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	/**
	 * @return the cdP
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * @param cdP the cdP to set
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}

	/**
	 * @return the cdCnt
	 */
	public String getCdCnt() {
		return cdCnt;
	}
	/**
	 * @param cdCnt the cdCnt to set
	 */
	public void setCdCnt(String cdCnt) {
		this.cdCnt = cdCnt;
	}
	/**
	 * @return the cdLastVcoreQty
	 */
	public BigDecimal getCdLastVcoreQty() {
		return cdLastVcoreQty;
	}
	/**
	 * @param cdLastVcoreQty the cdLastVcoreQty to set
	 */
	public void setCdLastVcoreQty(BigDecimal cdLastVcoreQty) {
		this.cdLastVcoreQty = cdLastVcoreQty;
	}
	/**
	 * @return the cdAvgCpuUseRt
	 */
	public BigDecimal getCdAvgCpuUseRt() {
		return cdAvgCpuUseRt;
	}
	/**
	 * @param cdAvgCpuUseRt the cdAvgCpuUseRt to set
	 */
	public void setCdAvgCpuUseRt(BigDecimal cdAvgCpuUseRt) {
		this.cdAvgCpuUseRt = cdAvgCpuUseRt;
	}
	/**
	 * @return the cdLastMemSumCapa
	 */
	public BigDecimal getCdLastMemSumCapa() {
		return cdLastMemSumCapa;
	}
	/**
	 * @param cdLastMemSumCapa the cdLastMemSumCapa to set
	 */
	public void setCdLastMemSumCapa(BigDecimal cdLastMemSumCapa) {
		this.cdLastMemSumCapa = cdLastMemSumCapa;
	}
	/**
	 * @return the cdAvgMemUseRt
	 */
	public BigDecimal getCdAvgMemUseRt() {
		return cdAvgMemUseRt;
	}
	/**
	 * @param cdAvgMemUseRt the cdAvgMemUseRt to set
	 */
	public void setCdAvgMemUseRt(BigDecimal cdAvgMemUseRt) {
		this.cdAvgMemUseRt = cdAvgMemUseRt;
	}
	/**
	 * @return the cdLastStrgSumCapa
	 */
	public BigDecimal getCdLastStrgSumCapa() {
		return cdLastStrgSumCapa;
	}
	/**
	 * @param cdLastStrgSumCapa the cdLastStrgSumCapa to set
	 */
	public void setCdLastStrgSumCapa(BigDecimal cdLastStrgSumCapa) {
		this.cdLastStrgSumCapa = cdLastStrgSumCapa;
	}
	/**
	 * @return the cdAvgStrgUseRt
	 */
	public BigDecimal getCdAvgStrgUseRt() {
		return cdAvgStrgUseRt;
	}
	/**
	 * @param cdAvgStrgUseRt the cdAvgStrgUseRt to set
	 */
	public void setCdAvgStrgUseRt(BigDecimal cdAvgStrgUseRt) {
		this.cdAvgStrgUseRt = cdAvgStrgUseRt;
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
	 * @return the avgCpuUseRt
	 */
	public BigDecimal getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	/**
	 * @param avgCpuUseRt the avgCpuUseRt to set
	 */
	public void setAvgCpuUseRt(BigDecimal avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
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
	 * @return the avgMemUseRt
	 */
	public BigDecimal getAvgMemUseRt() {
		return avgMemUseRt;
	}
	/**
	 * @param avgMemUseRt the avgMemUseRt to set
	 */
	public void setAvgMemUseRt(BigDecimal avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
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
	 * @return the avgStrgUseRt
	 */
	public BigDecimal getAvgStrgUseRt() {
		return avgStrgUseRt;
	}
	/**
	 * @param avgStrgUseRt the avgStrgUseRt to set
	 */
	public void setAvgStrgUseRt(BigDecimal avgStrgUseRt) {
		this.avgStrgUseRt = avgStrgUseRt;
	}
	/**
	 * @return the avgInTrfic
	 */
	public BigDecimal getAvgInTrfic() {
		return avgInTrfic;
	}
	/**
	 * @param avgInTrfic the avgInTrfic to set
	 */
	public void setAvgInTrfic(BigDecimal avgInTrfic) {
		this.avgInTrfic = avgInTrfic;
	}
	/**
	 * @return the avgOutTrfic
	 */
	public BigDecimal getAvgOutTrfic() {
		return avgOutTrfic;
	}
	/**
	 * @param avgOutTrfic the avgOutTrfic to set
	 */
	public void setAvgOutTrfic(BigDecimal avgOutTrfic) {
		this.avgOutTrfic = avgOutTrfic;
	}
	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}
	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	/**
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}
	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}
	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
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
	 * @return the clstrNm
	 */
	public String getClstrNm() {
		return clstrNm;
	}
	/**
	 * @param clstrNm the clstrNm to set
	 */
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
	}
	/**
	 * @return the pmNm
	 */
	public String getPmNm() {
		return pmNm;
	}
	/**
	 * @param pmNm the pmNm to set
	 */
	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
	}
	/**
	 * @return the pmCompId
	 */
	public String getPmCompId() {
		return pmCompId;
	}
	/**
	 * @param pmCompId the pmCompId to set
	 */
	public void setPmCompId(String pmCompId) {
		this.pmCompId = pmCompId;
	}




}
