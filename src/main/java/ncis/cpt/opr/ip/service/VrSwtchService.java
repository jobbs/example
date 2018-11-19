/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service;

import java.util.List;
import ncis.cpt.opr.ip.vo.VrSwtchSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchVo;

/**
 * @author 신재훈
 *
 */
public interface VrSwtchService {
    List<VrSwtchVo> selectVrSwtchList(VrSwtchSearchVo searchVo);

}
