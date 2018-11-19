package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class PreDistrbSearchVo extends CommonSearchVo {


	private String regionId; /* 리전ID */
	private String zoneId; /* 존ID */
	private String netClCd; /* 망구분코드 */
	private String rsrcPoolId; /* 자원풀ID */
	private String institutionNm; /* 부처명 */
    private String jobNm; /* 업무명 */
    private String imgNm; /*이미지명*/
    private String imgVer; /*이미지 버전*/
    private String ctlTrgtYn;
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
	 * @return the imgNm
	 */
	public String getImgNm() {
		return imgNm;
	}
	/**
	 * @param imgNm the imgNm to set
	 */
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	/**
	 * @return the imgVer
	 */
	public String getImgVer() {
		return imgVer;
	}
	/**
	 * @param imgVer the imgVer to set
	 */
	public void setImgVer(String imgVer) {
		this.imgVer = imgVer;
	}
	/**
	 * @return the ctlTrgtYn
	 */
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}
	/**
	 * @param ctlTrgtYn the ctlTrgtYn to set
	 */
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreDistrbSearchVo [regionId=" + regionId + ", zoneId=" + zoneId
				+ ", netClCd=" + netClCd + ", rsrcPoolId=" + rsrcPoolId
				+ ", institutionNm=" + institutionNm + ", jobNm=" + jobNm
				+ ", imgNm=" + imgNm + ", imgVer=" + imgVer + ", ctlTrgtYn="
				+ ctlTrgtYn + "]";
	}




}
