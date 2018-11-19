/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserRoleVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.user.vo;

import ncis.cmn.entity.RcNet;
import ncis.cmn.entity.RcRegion;
import ncis.cmn.entity.RcRsrcPool;
import ncis.cmn.entity.RcZone;

public class UserPoolVo extends RcRsrcPool {

    private RcRegion region;

    private RcZone zone;

    private RcNet net;

    private String userId;

    /**
     * @return the region
     */
    public RcRegion getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(RcRegion region) {
        this.region = region;
    }

    /**
     * @return the zone
     */
    public RcZone getZone() {
        return zone;
    }

    /**
     * @param zone the zone to set
     */
    public void setZone(RcZone zone) {
        this.zone = zone;
    }

    /**
     * @return the net
     */
    public RcNet getNet() {
        return net;
    }

    /**
     * @param net the net to set
     */
    public void setNet(RcNet net) {
        this.net = net;
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
