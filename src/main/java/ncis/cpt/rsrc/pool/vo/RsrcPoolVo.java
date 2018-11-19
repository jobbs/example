/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolVo.java
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
package ncis.cpt.rsrc.pool.vo;

import ncis.cmn.entity.RcRsrcPool;

/**
 * @author 심원보
 *
 */
public class RsrcPoolVo extends RcRsrcPool {
    // 자원풀
    private String regionNm; // 센터명
    private String zoneNm; // / 존명
    private String netNm; // 망명
    private String vrlzSwTyCdNm; // 가상화SW명
    private String userId;

    // 가상스토리지
    private String wholeAsgnCapa; // 전체량
    private String StrgUseCapa; // 사용량
    private String vmAsgnCapa; // VM할당량
    private String StrMrgnCapa; // 여유량
    private String tmplatAsgnCapa; // 템플릿사용량

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

    public String getVrlzSwTyCdNm() {
        return vrlzSwTyCdNm;
    }

    public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
        this.vrlzSwTyCdNm = vrlzSwTyCdNm;
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

    public String getWholeAsgnCapa() {
        return wholeAsgnCapa;
    }

    public void setWholeAsgnCapa(String wholeAsgnCapa) {
        this.wholeAsgnCapa = wholeAsgnCapa;
    }

    public String getStrgUseCapa() {
        return StrgUseCapa;
    }

    public void setStrgUseCapa(String strgUseCapa) {
        StrgUseCapa = strgUseCapa;
    }

    public String getVmAsgnCapa() {
        return vmAsgnCapa;
    }

    public void setVmAsgnCapa(String vmAsgnCapa) {
        this.vmAsgnCapa = vmAsgnCapa;
    }

    public String getStrMrgnCapa() {
        return StrMrgnCapa;
    }

    public void setStrMrgnCapa(String strMrgnCapa) {
        StrMrgnCapa = strMrgnCapa;
    }

    public String getTmplatAsgnCapa() {
        return tmplatAsgnCapa;
    }

    public void setTmplatAsgnCapa(String tmplatAsgnCapa) {
        this.tmplatAsgnCapa = tmplatAsgnCapa;
    }

}
