/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmMenuRoleDao.java
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

import ncis.cmn.entity.CmMenuRole;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 메뉴롤 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmMenuRoleDao")
public class CCmMenuRoleDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 메뉴롤 등록
	 * @param cmMenuRole
	 */
	public void insertCmMenuRole(CmMenuRole cmMenuRole) {
		sqlSession.insert("ncis.sql.cmn.cmMenuRole.insertCmMenuRole", cmMenuRole);
	}

	/**
	 * 메뉴롤 수정
	 * @param cmMenuRole
	 */
	public void updateCmMenuRole(CmMenuRole cmMenuRole) {
		sqlSession.update("ncis.sql.cmn.cmMenuRole.updateCmMenuRole", cmMenuRole);
	}

	/**
	 * 메뉴롤 삭제
	 * @param cmMenuRole
	 */
	public void deleteCmMenuRole(CmMenuRole cmMenuRole) {
		sqlSession.update("ncis.sql.cmn.cmMenuRole.deleteCmMenuRole", cmMenuRole);
	}

}
