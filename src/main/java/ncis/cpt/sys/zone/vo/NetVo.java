/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVo.java
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

import ncis.cmn.entity.RcNet;

/**
 * @author 최진호
 *
 */
public class NetVo extends RcNet {

    private String netClNm;

    private ZoneNetVo zoneNet;

    /**
     * @return the zoneNet
     */
    public ZoneNetVo getZoneNet() {
        return zoneNet;
    }

    /**
     * @param zoneNet the zoneNet to set
     */
    public void setZoneNet(ZoneNetVo zoneNet) {
        this.zoneNet = zoneNet;
    }

    /**
     * @return the netClNm
     */
    public String getNetClNm() {
        return netClNm;
    }

    /**
     * @param netClNm the netClNm to set
     */
    public void setNetClNm(String netClNm) {
        this.netClNm = netClNm;
    }
}
