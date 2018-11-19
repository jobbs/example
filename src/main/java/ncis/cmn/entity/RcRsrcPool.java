/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcRsrcPool.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.util.Date;

/**
 * @author 심원보
 *
 */
public class RcRsrcPool {

    private String rsrcPoolId; /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
	private String rsrcPoolVersion;  /*자원풀 버전*/
    private String vrlzSwTyCd; /* 가상화SW유형코드 */
    private String uuid; /* UUID */
    private Date regDttm; /* 등록일자 */
    private String regUserId; /* 등록자ID */
    private String zoneId; /* 존ID */
    private String netId; /* 망ID */
    private String regionId; /* 리전ID */
    private String mngConnAddr; /* 매니저접속주소 */
    private String mngProxyPort; /* 매니저프록시포트 */
    private String strgCompCd;	/* 스토리지 구성방식코드 */
    private String ctlTrgtYn; /* 제어대상여부 */

    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

	/**
	 * @return the version
	 */
	public String getRsrcPoolVersion()
	{
		return rsrcPoolVersion;
	}

	/**
	 * @param version the version to set
	 */
	public void setRsrcPoolVersion(String version)
	{
		this.rsrcPoolVersion = version;
	}

    public String getVrlzSwTyCd() {
        return vrlzSwTyCd;
    }

    public void setVrlzSwTyCd(String vrlzSwTyCd) {
        this.vrlzSwTyCd = vrlzSwTyCd;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getMngConnAddr() {
        return mngConnAddr;
    }

    public void setMngConnAddr(String mngConnAddr) {
        this.mngConnAddr = mngConnAddr;
    }

    public String getMngProxyPort() {
        return mngProxyPort;
    }

    public void setMngProxyPort(String mngProxyPort) {
        this.mngProxyPort = mngProxyPort;
    }

	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}

	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}

	/**
	 * @return the strgCompCd
	 */
	public String getStrgCompCd() {
		return strgCompCd;
	}

	/**
	 * @param strgCompCd the strgCompCd to set
	 */
	public void setStrgCompCd(String strgCompCd) {
		this.strgCompCd = strgCompCd;
	}

}
