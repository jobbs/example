/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchServiceImpl.java
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

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CRcVrSwtchDao;
import ncis.cpt.opr.ip.dao.RcVrSwtchDao;
import ncis.cpt.opr.ip.service.VrSwtchService;
import ncis.cpt.opr.ip.vo.VrSwtchSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchVo;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */

@Service("vrSwtchService")
public class VrSwtchServiceImpl implements VrSwtchService {
    @Resource(name = "cRcVrSwtchDao")
    private CRcVrSwtchDao cRcVrSwtchDao;

    @Resource(name = "rcVrSwtchDao")
    private RcVrSwtchDao rcVrSwtchDao;

    /**
     * 가상스위치 조회 (전체)
     */
    @Override
    public List<VrSwtchVo> selectVrSwtchList(VrSwtchSearchVo searchVo) {
        List<VrSwtchVo> list = null;

        int totalCount = rcVrSwtchDao.selectVrSwtchTotCnt(searchVo);
        if (totalCount > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = rcVrSwtchDao.selectVrSwtchList(searchVo);
        }
        return list;
    }
}
