package ncis.cmn.dao;

import java.math.BigDecimal;
import ncis.cmn.entity.RnIpBndPrpos;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * IP대역용도 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnIpBndPrposDao")
public class CRnIpBndPrposDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP대역용도 등록
     *
     * @param rnIpBndPrpos
     */
    public void insertRnIpBndPrpos(RnIpBndPrpos rnIpBndPrpos) {
        sqlSession.insert("ncis.sql.cmn.rnIpBndPrpos.insertRnIpBndPrpos", rnIpBndPrpos);
    }

    /**
     * IP대역 할당 용도 삭제 (IP대역 수정용)
     *
     * @param rnIpBndPrpos
     */
    public void deleteRnIpBndPrpos(RnIpBndPrpos rnIpBndPrpos) {
        sqlSession.update("ncis.sql.cmn.rnIpBndPrpos.deleteRnIpBndPrpos", rnIpBndPrpos);
    }

    /**
     * IP대역 할당 용도 삭제 (IP대역 삭제용)
     *
     * @param bndSeq
     */
    public void deleteRnIpBndPrposByBndSeq(BigDecimal bndSeq) {
        sqlSession.update("ncis.sql.cmn.rnIpBndPrpos.deleteRnIpBndPrposByBndSeq", bndSeq);
    }

}
