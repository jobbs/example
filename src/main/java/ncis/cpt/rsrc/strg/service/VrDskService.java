/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrDskService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service;

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.rsrc.strg.vo.VrDskSearchVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;

/**
 * @author 신재훈
 *
 */
public interface VrDskService {
    List<VrDskVo> selectVrDskList(VrDskSearchVo searchVo);

    VrDskVo selectVrDsk(BigDecimal vrDskSeq);
}
