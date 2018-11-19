package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxServcRoute;


public class ServcRouteVo extends RxServcRoute {

	private String servcNm;  /* 서비스명 */
	private String servcId;  /* 서비스ID */
	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private String servcAreaId; /* 서비스영역ID */


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
	 * @return the servcId
	 */
	public String getServcId() {
		return servcId;
	}

	/**
	 * @param servcId the servcId to set
	 */
	public void setServcId(String servcId) {
		this.servcId = servcId;
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