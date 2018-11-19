/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CRnIpBndInstDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 12. 14.
 * @lastmodified 2016. 12. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 14.     신재훈         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import java.math.BigDecimal;
import ncis.cmn.entity.RnIpBndInst;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * IP대역부처 DAO - 공통(등록/수정/삭제)
 *
 * @author 신재훈
 *
 */

@Repository("cRnIpBndInstDao")
public class CRnIpBndInstDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP대역부처 등록
     *
     * @param rnIpBndInst
     */
    public void insertRnIpBndInst(RnIpBndInst rnIpBndInst) {
        sqlSession.insert("ncis.sql.cmn.rnIpBndInst.insertRnIpBndInst", rnIpBndInst);
    }

    /**
     * IP대역 할당 부처 삭제 (IP대역 수정용)
     *
     * @param rnIpBndInst
     */
    public void deleteRnIpBndInst(RnIpBndInst rnIpBndInst) {
        sqlSession.update("ncis.sql.cmn.rnIpBndInst.deleteRnIpBndInst", rnIpBndInst);
    }

    /**
     * IP대역 할당 부처 삭제 (IP대역 삭제용)
     *
     * @param bndSeq
     */
    public void deleteRnIpBndInstByBndSeq(BigDecimal bndSeq) {
        sqlSession.update("ncis.sql.cmn.rnIpBndInst.deleteRnIpBndInstByBndSeq", bndSeq);
    }

}
