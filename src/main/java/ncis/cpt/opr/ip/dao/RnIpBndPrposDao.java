/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename rnIpBndPrposDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.dao;

import java.util.List;
import ncis.cpt.opr.ip.vo.IpBndPrposSearchVo;
import ncis.cpt.opr.ip.vo.IpBndPrposVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */
@Repository("rnIpBndPrposDao")
public class RnIpBndPrposDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP대역 용도조회
     *
     * @param searchVo
     * @return
     */
    public List<IpBndPrposVo> selectIpBndPrposList(IpBndPrposSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rnIpBndPrpos.selectIpBndPrposList", searchVo);
    }
}
