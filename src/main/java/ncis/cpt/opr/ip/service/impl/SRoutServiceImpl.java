/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SRoutServiceImpl.java
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
package ncis.cpt.opr.ip.service.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CRnSRoutDao;
import ncis.cpt.opr.ip.dao.RnSRoutDao;
import ncis.cpt.opr.ip.service.SRoutService;
import ncis.cpt.opr.ip.vo.SRoutVo;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */
@Service("sRoutService")
public class SRoutServiceImpl implements SRoutService {
    @Resource(name = "cRnSRoutDao")
    private CRnSRoutDao cRnSRoutDao;

    @Resource(name = "rnSRoutDao")
    private RnSRoutDao rnSRoutDao;

    /**
     * 스태틱라우터 정보 조회 (by bndSeq)
     */
    @Override
    public List<SRoutVo> selectSRoutList(BigDecimal bndSeq) {
        return rnSRoutDao.selectSRoutList(bndSeq);
    }

    /**
     * 스태틱라우터 정보 추가
     */
    @Override
    public void insertSRout(List<SRoutVo> sRoutVoList) {
        for (SRoutVo sRoutVo : sRoutVoList) {
            cRnSRoutDao.insertRnSRout(sRoutVo);
        }
    }

    /**
     * 스태틱라우터 정보 삭제
     */
    @Override
    public void deleteSRout(SRoutVo sRoutVo) {
        cRnSRoutDao.deleteRnSRout(sRoutVo);
    }

    /**
     * 스태틱라우터 정보 수정
     */
    @Override
    public void updateSRout(List<SRoutVo> sRoutVoList, SRoutVo sRoutVo) {
        // 삭제
        cRnSRoutDao.deleteRnSRout(sRoutVo);

        // 수정
        for (SRoutVo vo : sRoutVoList) {
            cRnSRoutDao.insertRnSRout(vo);
        }

    }

}
