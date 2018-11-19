/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmSnapReqVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;

/**
 * @author 최경철
 *
 */
public class VmSnapReqVo {

    private String regionId;

    private String zoneId;

    private String netClCd;

    private String rsrcPoolId;

    private String vmUuid;

    private String snapshtNm;

    private BigDecimal snapshtSeq;

    private BigDecimal vmSeq;

    private String rmk;

    private String uuid;

    private String statGrpCd;

    private String netId;

    private String vmId;

    private String userId;



    /**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
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
     * @return the vmUuid
     */
    public String getVmUuid() {
        return vmUuid;
    }

    /**
     * @param vmUuid the vmUuid to set
     */
    public void setVmUuid(String vmUuid) {
        this.vmUuid = vmUuid;
    }

    /**
     * @return the snapshtNm
     */
    public String getSnapshtNm() {
        return snapshtNm;
    }

    /**
     * @param snapshtNm the snapshtNm to set
     */
    public void setSnapshtNm(String snapshtNm) {
        this.snapshtNm = snapshtNm;
    }

    /**
     * @return the snapshtSeq
     */
    public BigDecimal getSnapshtSeq() {
        return snapshtSeq;
    }

    /**
     * @param snapshtSeq the snapshtSeq to set
     */
    public void setSnapshtSeq(BigDecimal snapshtSeq) {
        this.snapshtSeq = snapshtSeq;
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
     * @return the rmk
     */
    public String getRmk() {
        return rmk;
    }

    /**
     * @param rmk the rmk to set
     */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VmSnapReqVo [regionId=" + regionId + ", zoneId=" + zoneId
                + ", netClCd=" + netClCd + ", rsrcPoolId=" + rsrcPoolId
                + ", vmUuid=" + vmUuid + ", snapshtNm=" + snapshtNm
                + ", snapshtSeq=" + snapshtSeq + ", vmSeq=" + vmSeq + ", rmk="
                + rmk + ", uuid=" + uuid + "]";
    }

    /**
     * @return the statGrpCd
     */
    public String getStatGrpCd() {
        return statGrpCd;
    }

    /**
     * @param statGrpCd the statGrpCd to set
     */
    public void setStatGrpCd(String statGrpCd) {
        this.statGrpCd = statGrpCd;
    }

	/**
	 * @return the vmId
	 */
	public String getVmId() {
		return vmId;
	}

	/**
	 * @param vmId the vmId to set
	 */
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
