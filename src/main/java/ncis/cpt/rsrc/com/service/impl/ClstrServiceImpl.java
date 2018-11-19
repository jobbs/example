/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrServiceImpl.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CRcClstrDao;
import ncis.cmn.dao.CRcClstrPrposDao;
import ncis.cpt.rsrc.com.dao.ClstrDao;
import ncis.cpt.rsrc.com.dao.ClstrPrposDao;
import ncis.cpt.rsrc.com.service.ClstrService;
import ncis.cpt.rsrc.com.vo.ClstrPrposSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrPrposVo;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("clstrService")
public class ClstrServiceImpl implements ClstrService {

    @Resource(name = "cRcClstrDao")
    private CRcClstrDao cRcClstrDao;

    @Resource(name = "clstrDao")
    private ClstrDao clstrDao;

    @Resource(name = "cRcClstrPrposDao")
    private CRcClstrPrposDao cRcClstrPrposDao;

    @Resource(name = "clstrPrposDao")
    private ClstrPrposDao clstrPrposDao;

    /**
     * 클러스터 목록 조회 페이징
     *
     * @param clstrSearchVo
     * @return
     */
    @Override
    public List<ClstrVo> selectClstrListPaging(ClstrSearchVo clstrSearchVo) {

        List<ClstrVo> clstrList = null;

        int clstrTotalCount = clstrDao.selectClstrTotCnt(clstrSearchVo);

        if (clstrTotalCount > 0) {
            clstrSearchVo.getPaginationInfo().setTotalRecordCount(clstrTotalCount); // 페이지 처리위한 count

            clstrList = clstrDao.selectClstrListPaging(clstrSearchVo);
        }

        return clstrList;

    }

    /**
     * 클러스터 목록 조회
     *
     * @param clstrSearchVo
     * @return
     */
    @Override
    public List<ClstrVo> selectClstrList(ClstrSearchVo clstrSearchVo) {

        return clstrDao.selectClstrList(clstrSearchVo);

    }

    /**
     * 클러스터 상세 조회
     *
     * @param clstrSeq
     * @return
     */
    @Override
    public ClstrVo selectClstr(BigDecimal clstrSeq) {

        return clstrDao.selectClstr(clstrSeq);

    }

    /**
     * 클러스터 정보 수정
     *
     * @param clstrVo
     * @return
     */
    @Override
    public void updateClstr(ClstrVo clstrVo) {

        cRcClstrDao.updateRcClstr(clstrVo);

    }

    /**
     * 클러스터 정보 수정(용도 포함)
     *
     * @param clstrVo
     * @param clstrPrposVoList
     */
    @Override
    public void updateClstrAndClstrPrposList(ClstrVo clstrVo, List<ClstrPrposVo> clstrPrposVoList) {

        cRcClstrDao.updateRcClstr(clstrVo);

        ClstrPrposSearchVo clstrPrposSearchVo = new ClstrPrposSearchVo();
        clstrPrposSearchVo.setSearchClstrSeq(clstrVo.getClstrSeq());

        List<ClstrPrposVo> clstrPrposVoListForDelete = clstrPrposDao.selectClstrPrposList(clstrPrposSearchVo);

        for (ClstrPrposVo clstrPrposVoForInsert : clstrPrposVoList) {
            boolean contains = false;
            for (ClstrPrposVo clstrPrposVoForDelete : clstrPrposVoListForDelete) {
                if (clstrPrposVoForDelete.getPrposClCd().equals(clstrPrposVoForInsert.getPrposClCd())) {
                    contains = true;
                    clstrPrposVoListForDelete.remove(clstrPrposVoForDelete);
                    break;
                }
            }
            if (!contains) {
                cRcClstrPrposDao.insertRcClstrPrpos(clstrPrposVoForInsert);
            }
        }

        for (ClstrPrposVo clstrPrposVoForDelete : clstrPrposVoListForDelete) {
            cRcClstrPrposDao.deleteRcClstrPrpos(clstrPrposVoForDelete);
        }

    }

    /**
     * 클러스터 존재 여부
     *
     * @param clstrSeq
     * @return
     */
    @Override
    public boolean isExistsClstr(BigDecimal clstrSeq) {

        if (clstrDao.selectClstrTotCntByClstrSeq(clstrSeq) == 0) {
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * 클러스터 구성ID 존재 여부
     *
     * @param clstrCompId
     * @return
     */
    @Override
    public boolean isExistsClstrCompId(String clstrCompId) {

        if (clstrDao.selectClstrTotCntByClstrCompId(clstrCompId) == 0) {
            return false;
        }
        else {
            return true;
        }

    }

}
