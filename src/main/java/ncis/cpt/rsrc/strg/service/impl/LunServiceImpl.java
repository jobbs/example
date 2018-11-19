/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LunServiceImpl.java
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
package ncis.cpt.rsrc.strg.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cpt.rsrc.strg.dao.LunDao;
import ncis.cpt.rsrc.strg.service.LunService;
import ncis.cpt.rsrc.strg.vo.LunSearchVo;
import ncis.cpt.rsrc.strg.vo.LunVo;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */
@Service("lunService")
public class LunServiceImpl implements LunService {

    @Resource(name = "lunDao")
    private LunDao lunDao;

    /**
     * Lun 목록조회
     */
    @Override
    public List<LunVo> selectLunList(LunSearchVo searchVo) {
        List<LunVo> list = null;
        int totalCount = lunDao.selectLunListTotCnt(searchVo);
        if (totalCount > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
            list = lunDao.selectLunList(searchVo);
        }
        return list;
    }

}
