/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnSRoutDao.java
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

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.opr.ip.vo.SRoutVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rnSRoutDao")
public class RnSRoutDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * Static Router 정보 조회 (by bndSeq)
     * @param bndSeq
     * @return
     */
    public List<SRoutVo> selectSRoutList(BigDecimal bndSeq) {
        return sqlSession.selectList("ncis.sql.cpt.rnSRout.selectSRoutListByBndSeq", bndSeq);
    }


}
