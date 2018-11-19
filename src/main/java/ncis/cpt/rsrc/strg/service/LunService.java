/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LunService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service;

import java.util.List;

import ncis.cpt.rsrc.strg.vo.LunSearchVo;
import ncis.cpt.rsrc.strg.vo.LunVo;

/**
 * @author 신재훈
 *
 */
public interface LunService {
    List<LunVo> selectLunList(LunSearchVo searchVo);
}
