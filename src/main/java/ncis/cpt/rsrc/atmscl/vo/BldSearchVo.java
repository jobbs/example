package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class BldSearchVo extends CommonSearchVo {

    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private String institutionNm; /* 부처명 */
    private String jobNm; /* 업무명 */
    private String lastBldVer; /*빌드 버전 */
    private String bldStatCd; /*상태 코드*/
    private String servcAreaNm; /* 서비스영역명 */
    private Integer servcAreaSeq; /* 서비스영역Seq */
	private String creImgNm; /*생성이미지명*/
	private String servcNm; /*서비스명*/
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}
	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}
	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
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
	 * @return the lastBldVer
	 */
	public String getLastBldVer() {
		return lastBldVer;
	}
	/**
	 * @param lastBldVer the lastBldVer to set
	 */
	public void setLastBldVer(String lastBldVer) {
		this.lastBldVer = lastBldVer;
	}
	/**
	 * @return the bldStatCd
	 */
	public String getBldStatCd() {
		return bldStatCd;
	}
	/**
	 * @param bldStatCd the bldStatCd to set
	 */
	public void setBldStatCd(String bldStatCd) {
		this.bldStatCd = bldStatCd;
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
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	/**
	 * @return the creImgNm
	 */
	public String getCreImgNm() {
		return creImgNm;
	}
	/**
	 * @param creImgNm the creImgNm to set
	 */
	public void setCreImgNm(String creImgNm) {
		this.creImgNm = creImgNm;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BldSearchVo [regionId=" + regionId + ", zoneId=" + zoneId
				+ ", netClCd=" + netClCd + ", rsrcPoolId=" + rsrcPoolId
				+ ", institutionNm=" + institutionNm + ", jobNm=" + jobNm
				+ ", lastBldVer=" + lastBldVer + ", bldStatCd=" + bldStatCd
				+ ", servcAreaNm=" + servcAreaNm + ", servcAreaSeq="
				+ servcAreaSeq + ", creImgNm=" + creImgNm + ", servcNm="
				+ servcNm + "]";
	}






}
