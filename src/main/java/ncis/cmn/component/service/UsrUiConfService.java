/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UsrUiConfService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.component.service;

import ncis.cmn.entity.CmUsrUiConf;

/**
 * @author 최진호
 *
 */
public interface UsrUiConfService {

    /**
     * @param confVo
     */
    void updateCmUsrUiConf(CmUsrUiConf confVo);

}
