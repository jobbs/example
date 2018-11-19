/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcVrSwtchDao.java
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
package ncis.cpt.opr.ip.dao;

import java.util.List;
import ncis.cpt.opr.ip.vo.VrSwtchSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rcVrSwtchDao")
public class RcVrSwtchDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 가상스위치 정보 수량 조회
     *
     * @param searchVo
     * @return
     */
    public int selectVrSwtchTotCnt(VrSwtchSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rcVrSwtch.selectVrSwtchTotCnt", searchVo);
    }

    /**
     * 가상스위치 정보 조회 (전체)
     *
     * @param searchVo
     * @return
     */
    public List<VrSwtchVo> selectVrSwtchList(VrSwtchSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rcVrSwtch.selectVrSwtchList", searchVo);
    }
}
