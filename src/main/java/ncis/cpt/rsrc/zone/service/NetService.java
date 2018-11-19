/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetService.java
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

import ncis.cpt.rsrc.zone.vo.NetSearchVo;
import ncis.cpt.rsrc.zone.vo.NetVo;

/**
 * @author 심원보
 *
 */
public interface NetService {

    /**
     * 망 목록 조회
     *
     * @param netSearchVo
     * @return
     */
    List<NetVo> selectNetAllList();

    /**
     * 망 상세 조회
     *
     * @param netSeq
     * @return
     */
    NetVo selectNet(String netId);

    /**
     * @param zoneId
     * @return
     */
    List<NetVo> selectNetListByZone(NetSearchVo netSearchVo);

}