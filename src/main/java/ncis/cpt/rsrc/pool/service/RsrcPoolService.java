/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolService.java
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
package ncis.cpt.rsrc.pool.service;

import java.util.List;

import ncis.cmn.util.excel.CustomSheet;
import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.dsb.stts.etc.vo.OprStatSearchVo;

/**
 * @author 심원보
 *
 */
public interface RsrcPoolService {

    /**
     * 사용자에 속한 자원풀 목록 조회
     *
     * @param rsrcPoolSearchVo
     * @return
     */
    List<RsrcPoolVo> selectUserRsrcPoolList(RsrcPoolSearchVo rsrcPoolSearchVo);

    /**
     * @param searchVo
     * @return
     */
    List<RsrcPoolVo> selectRsrcPoolList(RsrcPoolSearchVo searchVo);

    /**
     * 자원풀 상세 조회
     *
     * @param rsrcPoolId
     * @return
     */
    RsrcPoolVo selectRsrcPool(String rsrcPoolId);

    /**
     * 자원풀에 속한 가상스토리지 용량정보가 포함된 목록 조회
     *
     * @param vrStrgSearchVo
     * @return
     */
    List<RsrcPoolVrStrgVo> selectVrStrgRsrcPoolList(VrStrgSearchVo searchVo);

    List<CustomSheet> makeVrStrgRsrcPoolListExcelSheets(VrStrgSearchVo searchVo);

	/**
	 * @param searchVo
	 * @return
	 */
	List<RsrcPoolVo> selectRsrcPoolList(OprStatSearchVo searchVo);

}