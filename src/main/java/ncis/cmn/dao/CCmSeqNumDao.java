/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmSeqNumDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import java.util.HashMap;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cCmSeqNumDao")
public class CCmSeqNumDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public void updateSeqNum(String classfy, String prefix) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("classfy", classfy);
        map.put("prefix", prefix);

        sqlSession.update("ncis.sql.cmn.cmSeqnum.updateSeqNum", map);
    }

    public void selectForUpdate(String classfy, String prefix) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("classfy", classfy);
        map.put("prefix", prefix);

        sqlSession.selectOne("ncis.sql.cmn.cmSeqnum.selectForUpdate", map);
    }

    public String selectSeqNum(String classfy, String prefix) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("classfy", classfy);
        map.put("prefix", prefix);

        return sqlSession.selectOne("ncis.sql.cmn.cmSeqnum.selectSeqNum", map);
    }

}
