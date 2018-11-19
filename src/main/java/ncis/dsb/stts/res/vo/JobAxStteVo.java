/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobAxStteVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;

public class JobAxStteVo {
	private String institutionNm;
	private String institutionId;
	private BigDecimal institutionCnt;
	private String jobNm;
	private String jobId;
	private BigDecimal jobCnt;
	private String servcNm;
	private BigDecimal servcSeq;
	private BigDecimal servcCnt;
	private BigDecimal podQty;
	private BigDecimal servcCpuCorQty;
	private BigDecimal servcAvgCpuUseRt;
	private BigDecimal servcMemTotCapa;
	private BigDecimal servcAvgMemUseRt;
	private BigDecimal servcStrgTotCapa;
	private BigDecimal servcAvgInTrfic;
	private BigDecimal servcAvgOutTrfic;
	private BigDecimal podCpuCorQty;
	private BigDecimal podAvgCpuUseRt;
	private BigDecimal podMemTotCapa;
	private BigDecimal podAvgMemUseRt;
	private BigDecimal podStrgTotCapa;
	private BigDecimal podAvgInTrfic;
	private BigDecimal podAvgOutTrfic;

	private String podNm;
	private String podId;
	private String regionNm;
	private String zoneNm;
	private String netNm;
	private String rsrcPoolNm;
	private String atmsclNodeNm;
	private String atmsclNodeId;
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
	 * @return the servcNm
	 */
	public String getServcNm() {
		return servcNm;
	}
	/**
	 * @param servcNm the servcNm to set
	 */
	public void setServcNm(String servcNm) {
		this.servcNm = servcNm;
	}
	/**
	 * @return the servcSeq
	 */
	public BigDecimal getServcSeq() {
		return servcSeq;
	}
	/**
	 * @param servcSeq the servcSeq to set
	 */
	public void setServcSeq(BigDecimal servcSeq) {
		this.servcSeq = servcSeq;
	}
	/**
	 * @return the servcCnt
	 */
	public BigDecimal getServcCnt() {
		return servcCnt;
	}
	/**
	 * @param servcCnt the servcCnt to set
	 */
	public void setServcCnt(BigDecimal servcCnt) {
		this.servcCnt = servcCnt;
	}
	/**
	 * @return the podQty
	 */
	public BigDecimal getPodQty() {
		return podQty;
	}
	/**
	 * @param podQty the podQty to set
	 */
	public void setPodQty(BigDecimal podQty) {
		this.podQty = podQty;
	}
	/**
	 * @return the servcCpuCorQty
	 */
	public BigDecimal getServcCpuCorQty() {
		return servcCpuCorQty;
	}
	/**
	 * @param servcCpuCorQty the servcCpuCorQty to set
	 */
	public void setServcCpuCorQty(BigDecimal servcCpuCorQty) {
		this.servcCpuCorQty = servcCpuCorQty;
	}
	/**
	 * @return the servcAvgCpuUseRt
	 */
	public BigDecimal getServcAvgCpuUseRt() {
		return servcAvgCpuUseRt;
	}
	/**
	 * @param servcAvgCpuUseRt the servcAvgCpuUseRt to set
	 */
	public void setServcAvgCpuUseRt(BigDecimal servcAvgCpuUseRt) {
		this.servcAvgCpuUseRt = servcAvgCpuUseRt;
	}
	/**
	 * @return the servcMemTotCapa
	 */
	public BigDecimal getServcMemTotCapa() {
		return servcMemTotCapa;
	}
	/**
	 * @param servcMemTotCapa the servcMemTotCapa to set
	 */
	public void setServcMemTotCapa(BigDecimal servcMemTotCapa) {
		this.servcMemTotCapa = servcMemTotCapa;
	}
	/**
	 * @return the servcAvgMemUseRt
	 */
	public BigDecimal getServcAvgMemUseRt() {
		return servcAvgMemUseRt;
	}
	/**
	 * @param servcAvgMemUseRt the servcAvgMemUseRt to set
	 */
	public void setServcAvgMemUseRt(BigDecimal servcAvgMemUseRt) {
		this.servcAvgMemUseRt = servcAvgMemUseRt;
	}
	/**
	 * @return the servcStrgTotCapa
	 */
	public BigDecimal getServcStrgTotCapa() {
		return servcStrgTotCapa;
	}
	/**
	 * @param servcStrgTotCapa the servcStrgTotCapa to set
	 */
	public void setServcStrgTotCapa(BigDecimal servcStrgTotCapa) {
		this.servcStrgTotCapa = servcStrgTotCapa;
	}
	/**
	 * @return the servcAvgInTrfic
	 */
	public BigDecimal getServcAvgInTrfic() {
		return servcAvgInTrfic;
	}
	/**
	 * @param servcAvgInTrfic the servcAvgInTrfic to set
	 */
	public void setServcAvgInTrfic(BigDecimal servcAvgInTrfic) {
		this.servcAvgInTrfic = servcAvgInTrfic;
	}
	/**
	 * @return the servcAvgOutTrfic
	 */
	public BigDecimal getServcAvgOutTrfic() {
		return servcAvgOutTrfic;
	}
	/**
	 * @param servcAvgOutTrfic the servcAvgOutTrfic to set
	 */
	public void setServcAvgOutTrfic(BigDecimal servcAvgOutTrfic) {
		this.servcAvgOutTrfic = servcAvgOutTrfic;
	}
	/**
	 * @return the podCpuCorQty
	 */
	public BigDecimal getPodCpuCorQty() {
		return podCpuCorQty;
	}
	/**
	 * @param podCpuCorQty the podCpuCorQty to set
	 */
	public void setPodCpuCorQty(BigDecimal podCpuCorQty) {
		this.podCpuCorQty = podCpuCorQty;
	}
	/**
	 * @return the podAvgCpuUseRt
	 */
	public BigDecimal getPodAvgCpuUseRt() {
		return podAvgCpuUseRt;
	}
	/**
	 * @param podAvgCpuUseRt the podAvgCpuUseRt to set
	 */
	public void setPodAvgCpuUseRt(BigDecimal podAvgCpuUseRt) {
		this.podAvgCpuUseRt = podAvgCpuUseRt;
	}
	/**
	 * @return the podMemTotCapa
	 */
	public BigDecimal getPodMemTotCapa() {
		return podMemTotCapa;
	}
	/**
	 * @param podMemTotCapa the podMemTotCapa to set
	 */
	public void setPodMemTotCapa(BigDecimal podMemTotCapa) {
		this.podMemTotCapa = podMemTotCapa;
	}
	/**
	 * @return the podAvgMemUseRt
	 */
	public BigDecimal getPodAvgMemUseRt() {
		return podAvgMemUseRt;
	}
	/**
	 * @param podAvgMemUseRt the podAvgMemUseRt to set
	 */
	public void setPodAvgMemUseRt(BigDecimal podAvgMemUseRt) {
		this.podAvgMemUseRt = podAvgMemUseRt;
	}
	/**
	 * @return the podStrgTotCapa
	 */
	public BigDecimal getPodStrgTotCapa() {
		return podStrgTotCapa;
	}
	/**
	 * @param podStrgTotCapa the podStrgTotCapa to set
	 */
	public void setPodStrgTotCapa(BigDecimal podStrgTotCapa) {
		this.podStrgTotCapa = podStrgTotCapa;
	}
	/**
	 * @return the podAvgInTrfic
	 */
	public BigDecimal getPodAvgInTrfic() {
		return podAvgInTrfic;
	}
	/**
	 * @param podAvgInTrfic the podAvgInTrfic to set
	 */
	public void setPodAvgInTrfic(BigDecimal podAvgInTrfic) {
		this.podAvgInTrfic = podAvgInTrfic;
	}
	/**
	 * @return the podAvgOutTrfic
	 */
	public BigDecimal getPodAvgOutTrfic() {
		return podAvgOutTrfic;
	}
	/**
	 * @param podAvgOutTrfic the podAvgOutTrfic to set
	 */
	public void setPodAvgOutTrfic(BigDecimal podAvgOutTrfic) {
		this.podAvgOutTrfic = podAvgOutTrfic;
	}
	/**
	 * @return the podNm
	 */
	public String getPodNm() {
		return podNm;
	}
	/**
	 * @param podNm the podNm to set
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	/**
	 * @return the podId
	 */
	public String getPodId() {
		return podId;
	}
	/**
	 * @param podId the podId to set
	 */
	public void setPodId(String podId) {
		this.podId = podId;
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
	 * @return the atmsclNodeNm
	 */
	public String getAtmsclNodeNm() {
		return atmsclNodeNm;
	}
	/**
	 * @param atmsclNodeNm the atmsclNodeNm to set
	 */
	public void setAtmsclNodeNm(String atmsclNodeNm) {
		this.atmsclNodeNm = atmsclNodeNm;
	}
	/**
	 * @return the atmsclNodeId
	 */
	public String getAtmsclNodeId() {
		return atmsclNodeId;
	}
	/**
	 * @param atmsclNodeId the atmsclNodeId to set
	 */
	public void setAtmsclNodeId(String atmsclNodeId) {
		this.atmsclNodeId = atmsclNodeId;
	}


}
