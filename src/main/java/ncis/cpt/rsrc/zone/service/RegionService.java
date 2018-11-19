/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegionService.java
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

import java.util.List;

import ncis.cpt.rsrc.zone.vo.RegionSearchVo;
import ncis.cpt.rsrc.zone.vo.RegionVo;

/**
 * @author 심원보
 *
 */
public interface RegionService {

    /**
     * 리전 목록 조회(사용자)
     *
     * @param regionSearchVo
     * @return
     */
    List<RegionVo> selectRegionList(RegionSearchVo regionSearchVo);

    /**
     * 리전 목록 조회(전체)
     *
     * @param regionSearchVo
     * @return
     */
    List<RegionVo> selectRegionAllList();

    /**
     * 리전 상세 조회
     *
     * @param regionId
     * @return
     */
    RegionVo selectRegion(String regionId);

}