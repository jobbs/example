/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneSearchVo.java
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
package ncis.cpt.rsrc.zone.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 심원보
 *
 */
public class ZoneSearchVo extends CommonSearchVo {

    private String searchRegionId;

    public String getSearchRegionId() {
        return searchRegionId;
    }

    public void setSearchRegionId(String searchRegionId) {
        this.searchRegionId = searchRegionId;
    }

}
