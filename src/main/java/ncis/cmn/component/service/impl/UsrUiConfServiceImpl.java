/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UsrUiConfServiceImpl.java
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
package ncis.cmn.component.service.impl;

import javax.annotation.Resource;
import ncis.cmn.component.service.UsrUiConfService;
import ncis.cmn.dao.CCmUsrUiConfDao;
import ncis.cmn.entity.CmUsrUiConf;
import org.springframework.stereotype.Service;

/**
 * @author 최진호
 *
 */
@Service("usrUiConfService")
public class UsrUiConfServiceImpl implements UsrUiConfService {

    @Resource(name="cCmUsrUiConfDao") private CCmUsrUiConfDao cCmUsrUiConfDao;

    @Override
    public void updateCmUsrUiConf(CmUsrUiConf confVo) {
        cCmUsrUiConfDao.updateCmUsrUiConf(confVo);
    }

}
