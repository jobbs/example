package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class PvSearchVo extends CommonSearchVo {

	private Integer servcAreaSeq; /* 서비스영역SEQ */
	private String accssModeClCdNm;  /* 접근모드코드명 */
	private String accssModeClCd;  /* 접근모드코드 */
	private String strgClCdNm; /* 스토리지구분코드명 */
	private String strgClCd; /* 스토리지구분코드 */
	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String zoneNm; /* 존명 */
    private String rsrcPoolId; /* 자원풀ID */
    private String pvNm; /* PV명 */

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
	 * @return the accssModeClCd
	 */
	public String getAccssModeClCd() {
		return accssModeClCd;
	}
	/**
	 * @param accssModeClCd the accssModeClCd to set
	 */
	public void setAccssModeClCd(String accssModeClCd) {
		this.accssModeClCd = accssModeClCd;
	}
	/**
	 * @return the strgClCd
	 */
	public String getStrgClCd() {
		return strgClCd;
	}
	/**
	 * @param strgClCd the strgClCd to set
	 */
	public void setStrgClCd(String strgClCd) {
		this.strgClCd = strgClCd;
	}
	/**
	 * @return the accssModeClCdNm
	 */
	public String getAccssModeClCdNm() {
		return accssModeClCdNm;
	}
	/**
	 * @param accssModeClCdNm the accssModeClCdNm to set
	 */
	public void setAccssModeClCdNm(String accssModeClCdNm) {
		this.accssModeClCdNm = accssModeClCdNm;
	}
	/**
	 * @return the strgClCdNm
	 */
	public String getStrgClCdNm() {
		return strgClCdNm;
	}
	/**
	 * @param strgClCdNm the strgClCdNm to set
	 */
	public void setStrgClCdNm(String strgClCdNm) {
		this.strgClCdNm = strgClCdNm;
	}
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
	 * @return the pvNm
	 */
	public String getPvNm() {
		return pvNm;
	}
	/**
	 * @param pvNm the pvNm to set
	 */
	public void setPvNm(String pvNm) {
		this.pvNm = pvNm;
	}

}
