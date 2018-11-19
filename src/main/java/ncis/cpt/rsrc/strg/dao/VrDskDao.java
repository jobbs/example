/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrDskDao.java
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
package ncis.cpt.rsrc.strg.dao;

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.rsrc.strg.vo.VrDskSearchVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("vrDskDao")
public class VrDskDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 검색조건에 해당하는 가상스토리지 수량 조회
     *
     * @param searchVo
     * @return
     */
    public int selectVrDskListTotCnt(VrDskSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.vrDsk.selectVrDskListTotCnt", searchVo);
    }

    /**
     * 검색조건에 해당하는 가상스토리지 목록 조회
     *
     * @param searchVo
     * @return
     */
    public List<VrDskVo> selectVrDskList(VrDskSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.vrDsk.selectVrDskList", searchVo);
    }

    public VrDskVo selectVrDsk(BigDecimal vrDskSeq){
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.vrDsk.selectVrDsk", vrDskSeq);
    }
}
