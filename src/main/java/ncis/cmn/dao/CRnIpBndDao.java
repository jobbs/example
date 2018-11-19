package ncis.cmn.dao;

import java.math.BigDecimal;

import ncis.cmn.entity.RnIpBnd;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * IP대역 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnIpBndDao")
public class CRnIpBndDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP대역 등록
     *
     * @param rnIpBnd
     */
    public void insertRnIpBnd(RnIpBnd rnIpBnd) {
        sqlSession.insert("ncis.sql.cmn.rnIpBnd.insertRnIpBnd", rnIpBnd);
    }

    /**
     * IP대역 수정
     *
     * @param rnIpBnd
     */
    public void updateRnIpBndInfo(RnIpBnd rnIpBnd) {
        sqlSession.update("ncis.sql.cmn.rnIpBnd.updateRnIpBndInfo", rnIpBnd);
    }

    /**
     * IP대역 삭제
     *
     * @param rnIpBnd
     */
    public void deleteRnIpBnd(BigDecimal bndSeq) {
        sqlSession.update("ncis.sql.cmn.rnIpBnd.deleteRnIpBnd", bndSeq);
    }

    /**
     * 선택한 IP대역 IP (할당,미할당,블락) 수정
     *
     * @param IpBndSeq
     */
    public void updateRnIpBndIpQty(Integer IpBndSeq) {
        sqlSession.update("ncis.sql.cmn.rnIpBnd.updateRnIpBndIpQty", IpBndSeq);
    }
}
