/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneService.java
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
package ncis.cpt.rsrc.zone.service;

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.rsrc.zone.vo.ZoneSearchVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;

/**
 * @author 심원보
 *
 */
public interface ZoneService {


    /**
     * 존 목록 조회(전체)
     *
     * @param zoneSearchVo
     * @return
     */
    List<ZoneVo> selectZoneAllList();

    /**
     * 존 상세 조회
     *
     * @param zoneSeq
     * @return
     */
    ZoneVo selectZone(BigDecimal zoneSeq);

    /**
     * @param regionId
     * @return
     */
    List<ZoneVo> selectZoneListByRegion(ZoneSearchVo zoneSearchVo);

}