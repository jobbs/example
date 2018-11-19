/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetPmDao.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.rsrc.net.vo.NetPmSearchVo;
import ncis.cpt.rsrc.net.vo.NetPmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최경철
 *
 */
@Repository("netPmDao")
public class NetPmDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 네트워크 물리서버 목록 수 조회
     *
     * @param netPmSearchVo
     * @return
     */
    public int selectNetPmTotCnt(NetPmSearchVo netPmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.net.pm.selectNetPmTotCnt", netPmSearchVo);

    }

    /**
     * 네트워크 물리서버 목록 조회
     *
     * @param netPmSearchVo
     * @return
     */
    public List<NetPmVo> selectPmList(NetPmSearchVo netPmSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.net.pm.selectNetPmList", netPmSearchVo);

    }

    /**
     * 네트워크 물리서버 상세 정보 조회
     *
     * @param pmSeq
     * @return
     */
    public NetPmVo selectNetPm(BigDecimal pmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.net.pm.selectNetPm", pmSeq);

    }

    /**
     * 물리서버 구성ID 존재 여부
     *
     * @param pmCompId
     * @return
     */
    public int selectPmTotCntByPmCompId(String pmCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.net.pm.selectPmTotCntByPmCompId", pmCompId);

    }

}
