/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneNetVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.vo;

import ncis.cmn.entity.RcZoneNetMatrix;

/**
 * @author 최진호
 *
 */
public class ZoneNetVo extends RcZoneNetMatrix {

    // 삭제 수정처리를 위해
    private String prevNetId;

    private ZoneVo zone;

    /**
     * @return the zone
     */
    public ZoneVo getZone() {
        return zone;
    }

    /**
     * @param zone the zone to set
     */
    public void setZone(ZoneVo zone) {
        this.zone = zone;
    }

    /**
     * @return the prevNetId
     */
    public String getPrevNetId() {
        return prevNetId;
    }

    /**
     * @param prevNetId the prevNetId to set
     */
    public void setPrevNetId(String prevNetId) {
        this.prevNetId = prevNetId;
    }


}
