/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmDao.java
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
import java.util.Map;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("pmDao")
public class PmDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 물리서버 목록 수 조회
     *
     * @param pmSearchVo
     * @return
     */
    public int selectPmTotCnt(PmSearchVo pmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.pm.selectPmTotCnt", pmSearchVo);

    }

    /**
     * 물리서버 목록 조회
     *
     * @param pmSearchVo
     * @return
     */
    public List<PmVo> selectPmList(PmSearchVo pmSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.pm.selectPmList", pmSearchVo);

    }

    /**
     * 물리서버 상세 정보 조회
     *
     * @param pmSeq
     * @return
     */
    public PmVo selectPm(BigDecimal pmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.pm.selectPm", pmSeq);

    }

    /**
     * 물리서버 구성ID 존재 여부
     *
     * @param pmCompId
     * @return
     */
    public int selectPmTotCntByPmCompId(String pmCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.pm.selectPmTotCntByPmCompId", pmCompId);

    }

    /**
     * IP주소를 통한 pmSeq 조회
     *
     * @param ipAddr
     * @return
     */
    public BigDecimal selectPmSeqByIpAddr(String ipAddr) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.pm.selectPmSeqByIpAddr", ipAddr);

    }

    /**
     * 사용자별 물리서버 통계
     *
     * @param pmSearchVo
     * @return
     */
    public Map<String, Object> selectPmSttsByUser(PmSearchVo pmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.pm.selectPmSttsByUser", pmSearchVo);

    }

}
