/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrDao.java
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
package ncis.cpt.rsrc.com.dao;

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("clstrDao")
public class ClstrDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 클러스터 목록 수 조회
     *
     * @param clstrSearchVo
     * @return
     */
    public int selectClstrTotCnt(ClstrSearchVo clstrSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.clstr.selectClstrTotCnt", clstrSearchVo);

    }

    /**
     * 클러스터 목록 조회
     *
     * @param clstrSearchVo
     * @return
     */
    public List<ClstrVo> selectClstrListPaging(ClstrSearchVo clstrSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.clstr.selectClstrListPaging", clstrSearchVo);

    }

    /**
     * 클러스터 목록 조회
     *
     * @param clstrSearchVo
     * @return
     */
    public List<ClstrVo> selectClstrList(ClstrSearchVo clstrSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.clstr.selectClstrList", clstrSearchVo);

    }

    /**
     * 클러스터 상세 정보 조회
     *
     * @param clstrSeq
     * @return
     */
    public ClstrVo selectClstr(BigDecimal clstrSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.clstr.selectClstr", clstrSeq);

    }

    /**
     * 클러스터 상세 정보 조회
     *
     * @param clstrSeq
     * @return
     */
    public ClstrVo selectClstrByClstrSearchVo(ClstrSearchVo clstrSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.clstr.selectClstrByClstrSearchVo", clstrSearchVo);

    }

    /**
     * 클러스터 존재여부 확인
     *
     * @param clstrSearchVo
     * @return
     */
    public int selectClstrTotCntByClstrSeq(BigDecimal clstrSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.clstr.selectClstrTotCntByClstrSeq", clstrSeq);

    }

    /**
     * 클러스터 구성ID 존재 여부
     *
     * @param clstrCompId
     * @return
     */
    public int selectClstrTotCntByClstrCompId(String clstrCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.clstr.selectClstrTotCntByClstrCompId", clstrCompId);

    }

}
