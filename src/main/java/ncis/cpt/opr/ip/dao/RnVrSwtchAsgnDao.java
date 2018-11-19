/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnVrSwtchAsgnDao.java
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

import java.util.List;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rnVrSwtchAsgnDao")
public class RnVrSwtchAsgnDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    public List<VrSwtchAsgnVo> selectVrSwtchAsgnList(VrSwtchAsgnSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rnVrSwtchAsgn.selectVrSwtchAsgnList", searchVo);
    }

}
