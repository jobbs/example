package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxScrtky;

public class ScrtkyVo extends RxScrtky {

	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private Integer servcAreaSeq; /* 서비스영역SEQ */
    private String servcAreaId; /* 서비스영역ID */

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
	 * @return the servcAreaId
	 */
	public String getServcAreaId() {
		return servcAreaId;
	}
	/**
	 * @param servcAreaId the servcAreaId to set
	 */
	public void setServcAreaId(String servcAreaId) {
		this.servcAreaId = servcAreaId;
	}

}

