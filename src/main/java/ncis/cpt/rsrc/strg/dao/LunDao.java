/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LunDao.java
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
package ncis.cpt.rsrc.strg.dao;

import java.util.List;

import ncis.cpt.rsrc.strg.vo.LunSearchVo;
import ncis.cpt.rsrc.strg.vo.LunVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("lunDao")
public class LunDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    public int selectLunListTotCnt(LunSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.lun.selectLunListTotCnt", searchVo);
    }

    /**
     * 검색조건에 해당하는 가상스토리지 목록 조회
     *
     * @param searchVo
     * @return
     */
    public List<LunVo> selectLunList(LunSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.lun.selectLunList", searchVo);
    }

}
