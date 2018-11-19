/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrDskServiceImpl.java
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
package ncis.cpt.rsrc.strg.service.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ncis.cpt.rsrc.strg.dao.VrDskDao;
import ncis.cpt.rsrc.strg.service.VrDskService;
import ncis.cpt.rsrc.strg.vo.VrDskSearchVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;

/**
 * @author 신재훈
 *
 */
@Service("vrDskService")
public class VrDskServiceImpl implements VrDskService {
    @Resource(name = "vrDskDao")
    private VrDskDao vrDskDao;

    /**
     * 가상디스크 조회
     */
    @Override
    public List<VrDskVo> selectVrDskList(VrDskSearchVo searchVo) {
        int totalCount = vrDskDao.selectVrDskListTotCnt(searchVo);
        searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        return vrDskDao.selectVrDskList(searchVo);
    }

    /**
     * 가상디스크 상세 조회
     */
    @Override
    public VrDskVo selectVrDsk(BigDecimal vrDskSeq) {
        return vrDskDao.selectVrDsk(vrDskSeq);
    }

}
