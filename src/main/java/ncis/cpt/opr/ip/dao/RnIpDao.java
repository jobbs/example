/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnIpDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.dao;

import java.util.List;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rnIpDao")
public class RnIpDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    public int selectIpListTotCnt(IpSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rnIp.selectIpListTotCnt", searchVo);
    }

    public List<IpVo> selectIpList(IpSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rnIp.selectIpList", searchVo);
    }
}
