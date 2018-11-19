/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnIpBndInstDao.java
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
package ncis.cpt.opr.ip.dao;

import java.util.List;
import ncis.cpt.opr.ip.vo.IpBndInstSearchVo;
import ncis.cpt.opr.ip.vo.IpBndInstVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rnIpBndInstDao")
public class RnIpBndInstDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP대역 부처조회
     *
     * @param searchVo
     * @return
     */
    public List<IpBndInstVo> selectIpBndInstList(IpBndInstSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rnIpBndInst.selectIpBndInstList", searchVo);
    }
}
