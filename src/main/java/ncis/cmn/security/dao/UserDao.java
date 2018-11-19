/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.security.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("securityUserDao")
public class UserDao {

	@Autowired SqlSessionTemplate sqlSession;

	public UserDetails selectUser(String username) {
		return sqlSession.selectOne("ncis.sql.cmn.security.getUser", username);
	}

    /**
     * @param username
     * @return
     */
    public UserDetails selectUserByDn(String username) {
        return sqlSession.selectOne("ncis.sql.cmn.security.selectUserByDn", username);
    }

}
