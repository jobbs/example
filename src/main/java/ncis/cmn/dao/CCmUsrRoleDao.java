/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmUsrRoleDao.java
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

import ncis.cmn.entity.CmUsrRole;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 사용자롤정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmUsrRoleDao")
public class CCmUsrRoleDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 사용자롤정보 등록
	 * @param cmUsrRole
	 */
	public void insertCmUsrRole(CmUsrRole cmUsrRole) {
		sqlSession.insert("ncis.sql.cmn.cmUsrRole.insertCmUsrRole", cmUsrRole);
	}

	/**
	 * 사용자롤정보 수정
	 * @param cmUsrRole
	 */
	public void updateCmUsrRole(CmUsrRole cmUsrRole) {
		sqlSession.update("ncis.sql.cmn.cmUsrRole.updateCmUsrRole", cmUsrRole);
	}

	/**
	 * 사용자롤정보 삭제
	 * @param cmUsrRole
	 */
	public void deleteCmUsrRole(CmUsrRole cmUsrRole) {
		sqlSession.update("ncis.sql.cmn.cmUsrRole.deleteCmUsrRole", cmUsrRole);
	}

}
