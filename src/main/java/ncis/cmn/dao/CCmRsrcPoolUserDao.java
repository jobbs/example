/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmRsrcPoolUserDao.java
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

import ncis.cmn.entity.CmRsrcPoolUser;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원풀사용자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmRsrcPoolUserDao")
public class CCmRsrcPoolUserDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원풀사용자 등록
	 * @param siRsrcPoolUser
	 */
	public void insertCmRsrcPoolUser(CmRsrcPoolUser cmRsrcPoolUser) {
		sqlSession.insert("ncis.sql.cmn.cmRsrcPoolUser.insertCmRsrcPoolUser", cmRsrcPoolUser);
	}

	/**
	 * 자원풀사용자 수정
	 * @param siRsrcPoolUser
	 */
	public void updateCmRsrcPoolUser(CmRsrcPoolUser cmRsrcPoolUser) {
		sqlSession.update("ncis.sql.cmn.cmRsrcPoolUser.updateCmRsrcPoolUser", cmRsrcPoolUser);
	}

	/**
	 * 자원풀사용자 삭제
	 * @param siRsrcPoolUser
	 */
	public void deleteCmRsrcPoolUser(CmRsrcPoolUser cmRsrcPoolUser) {
		sqlSession.update("ncis.sql.cmn.cmRsrcPoolUser.deleteCmRsrcPoolUser", cmRsrcPoolUser);
	}

}
