/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmJobUserDao.java
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

import ncis.cmn.entity.CmJobUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 업무사용자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmJobUserDao")
public class CCmJobUserDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 업무사용자 등록
	 * @param cmJobUser
	 */
	public void insertCmJobUser(CmJobUser cmJobUser) {
	    sqlSession.insert("ncis.sql.cmn.cmJobUser.insertCmJobUser", cmJobUser);
	}

	/**
	 * 업무사용자 수정
	 * @param cmJobUser
	 */
	public void updateCmJobUser(CmJobUser cmJobUser) {
	    sqlSession.update("ncis.sql.cmn.cmJobUser.updateCmJobUser", cmJobUser);
	}

	/**
	 * 업무사용자 삭제
	 * @param cmJobUser
	 */
	public void deleteCmJobUser(CmJobUser cmJobUser) {
	    sqlSession.update("ncis.sql.cmn.cmJobUser.deleteCmJobUser", cmJobUser);
	}

}
