/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 27.
 * @lastmodified 2016. 9. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import ncis.cmn.entity.RcVrSwtch;

/**
 * @author 신재훈
 *
 */
public class VrSwtchVo extends RcVrSwtch {
    private String regionNm; // 리전명
    private String zoneNm; // 존명
    private String netNm; // 망명
    private String rsrcPoolNm; // 자원풀명
    private String vrlzSwTyCdNm; // 가상화구분 명
    private String vrlzSwTyCdId; // 가상화구분 아이디
    private String dataCntrNm; //데이터센터명

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getZoneNm() {
        return zoneNm;
    }

    public void setZoneNm(String zoneNm) {
        this.zoneNm = zoneNm;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public String getRsrcPoolNm() {
        return rsrcPoolNm;
    }

    public void setRsrcPoolNm(String rsrcPoolNm) {
        this.rsrcPoolNm = rsrcPoolNm;
    }

    public String getVrlzSwTyCdNm() {
        return vrlzSwTyCdNm;
    }

    public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
        this.vrlzSwTyCdNm = vrlzSwTyCdNm;
    }

    public String getVrlzSwTyCdId() {
        return vrlzSwTyCdId;
    }

    public void setVrlzSwTyCdId(String vrlzSwTyCdId) {
        this.vrlzSwTyCdId = vrlzSwTyCdId;
    }


    @Override
    public String toString() {
        return "VrSwtchVo [regionNm=" + regionNm + ", zoneNm=" + zoneNm + ", netNm=" + netNm + ", rsrcPoolNm=" + rsrcPoolNm + ", vrlzSwTyCdNm=" + vrlzSwTyCdNm + ", vrlzSwTyCdId=" + vrlzSwTyCdId + ", getVrSwtchSeq()=" + getVrSwtchSeq() + ", getNetwkNm()=" + getNetwkNm() + ", getVrSwtchUuid()=" + getVrSwtchUuid() + ", getVlan()=" + getVlan() + ", getRsrcPoolId()=" + getRsrcPoolId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

	/**
	 * @return the dataCntrNm
	 */
	public String getDataCntrNm() {
		return dataCntrNm;
	}

	/**
	 * @param dataCntrNm the dataCntrNm to set
	 */
	public void setDataCntrNm(String dataCntrNm) {
		this.dataCntrNm = dataCntrNm;
	}

}
