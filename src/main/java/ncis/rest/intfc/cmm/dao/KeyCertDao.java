/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename KeyCertDao.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.cmm.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 접근키 인증 DAO
 *
 * @author ShinKeeBong
 *
 */

@Repository("keyCertDao")
public class KeyCertDao {

	@Autowired
	private SqlSessionTemplate sqlSession;


	/**
	 * 접근키에 대한 유효성 체크
	 * @param key
	 * @return
	 */
	public Boolean isCertifiedKey(String key) {

		int cnt = sqlSession.selectOne("ncis.sql.rest.keycert.selectGatewayKeyCnt", key);

		if( cnt == 1) return true;

		return false;
	}

}
