/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.rest.dao;

import ncis.cmn.rest.vo.RestInfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("restDao")
public class RestDao {

	@Autowired SqlSession sqlSession;

	public RestInfo selectConnectInfo(String regionId) {
		return sqlSession.selectOne("ncis.sql.cmn.rest.selectConnectInfo", regionId);
	}

}
