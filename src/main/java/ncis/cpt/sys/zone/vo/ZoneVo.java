/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.vo;

import ncis.cmn.entity.RcZone;

/**
 * @author 최진호
 *
 */
public class ZoneVo extends RcZone {

    private RegionVo region;

    /**
     * @return the region
     */
    public RegionVo getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(RegionVo region) {
        this.region = region;
    }
}
