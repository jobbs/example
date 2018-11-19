/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

/**
 * @author 신재훈
 *
 */
public interface VrStrgService {

    VrStrgVo selectVrStrg(VrStrgSearchVo searchVo);

    List<VrStrgVo> selectVrStrgVm(VmSearchVo searchVo);

    List<VrStrgVo> selectVrStrgTmplat(TmplatSvo searchVo);

    /**
     * 가상서버가 할당 된 가상스토리지 도메인 가용용량 및 디스크할당용량 조회
     * @param vmSeq
     * @return
     */
    List<VrStrgVo> selectVrStrgAsgnInfoOfVm(BigDecimal vmSeq);
}
