/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkIntfcDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 7.
 * @lastmodified 2016. 10. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 7.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.dao;

import java.util.List;
import ncis.cpt.rsrc.com.vo.NetwkIntfcVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈, 심원보
 *
 */

@Repository("netwkIntfcDao")
public class NetwkIntfcDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 가상서버에 할당된 네트워크 인터페이스 목록 조회
     *
     * @param vmSeq
     * @return
     */
    public List<NetwkIntfcVo> selectNetwkIntfcList(NetwkIntfcVo vo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.netwkIntfc.selectNetwkIntfcList", vo);
    }

}
