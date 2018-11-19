package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class RsrvSclngSearchVo extends CommonSearchVo {

	private String regionId; /* 리전ID */
	private String zoneId; /* 존ID */
	private String netClCd; /* 망구분코드 */
	private String rsrcPoolId; /* 자원풀ID */
    private String institutionNm; /*부처명*/
    private String jobNm; /*업무명*/
    private String jobId; /*업무ID*/
    private String rsrvStrtDt;  /* 예약시작일자 */
    private String rsrvEndDt;  /* 예약종료일자 */
    private String useYn;  /* 사용여부 */
    private String scalrNm;  /* 예약명 */
    private Integer servcSeq;  /* 서비스SEQ */
    private String scalrId;  /* 예약ID */
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
	 * @return the rsrvStrtDt
	 */
	public String getRsrvStrtDt() {
		return rsrvStrtDt;
	}
	/**
	 * @param rsrvStrtDt the rsrvStrtDt to set
	 */
	public void setRsrvStrtDt(String rsrvStrtDt) {
		this.rsrvStrtDt = rsrvStrtDt;
	}
	/**
	 * @return the rsrvEndDt
	 */
	public String getRsrvEndDt() {
		return rsrvEndDt;
	}
	/**
	 * @param rsrvEndDt the rsrvEndDt to set
	 */
	public void setRsrvEndDt(String rsrvEndDt) {
		this.rsrvEndDt = rsrvEndDt;
	}
	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	/**
	 * @return the scalrNm
	 */
	public String getScalrNm() {
		return scalrNm;
	}
	/**
	 * @param scalrNm the scalrNm to set
	 */
	public void setScalrNm(String scalrNm) {
		this.scalrNm = scalrNm;
	}
	/**
	 * @return the servcSeq
	 */
	public Integer getServcSeq() {
		return servcSeq;
	}
	/**
	 * @param servcSeq the servcSeq to set
	 */
	public void setServcSeq(Integer servcSeq) {
		this.servcSeq = servcSeq;
	}
	/**
	 * @return the scalrId
	 */
	public String getScalrId() {
		return scalrId;
	}
	/**
	 * @param scalrId the scalrId to set
	 */
	public void setScalrId(String scalrId) {
		this.scalrId = scalrId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RsrvSclngSearchVo [regionId=" + regionId + ", zoneId=" + zoneId
				+ ", netClCd=" + netClCd + ", rsrcPoolId=" + rsrcPoolId
				+ ", institutionNm=" + institutionNm + ", jobNm=" + jobNm
				+ ", jobId=" + jobId + ", rsrvStrtDt=" + rsrvStrtDt
				+ ", rsrvEndDt=" + rsrvEndDt + ", useYn=" + useYn
				+ ", scalrNm=" + scalrNm + ", servcSeq=" + servcSeq
				+ ", scalrId=" + scalrId + "]";
	}


}
