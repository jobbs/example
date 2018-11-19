/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmRoleDao.java
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
import ncis.cmn.entity.CmRole;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 롤정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmRoleDao")
public class CCmRoleDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 롤정보 등록
	 * @param cmRole
	 */
	public void insertCmRole(CmRole cmRole) {
		sqlSession.insert("ncis.sql.cmn.cmRole.insertCmRole", cmRole);
	}

	/**
	 * 롤정보 수정
	 * @param cmRole
	 */
	public void updateCmRole(CmRole cmRole) {
		sqlSession.update("ncis.sql.cmn.cmRole.updateCmRole", cmRole);
	}

	/**
	 * 메뉴에 팹핑되어 있는 권한 삭제
	 * @param roleCode
	 */
	public void deleteMenuRole(String roleCode) {
		sqlSession.delete("ncis.sql.cmn.cmRole.deleteMenuRole", roleCode);
	}

	/**
	 * 사용자에 맵핑되어 있는 권한 삭제
	 * @param roleCode
	 */
	public void deleteUserRole(String roleCode) {
		sqlSession.delete("ncis.sql.cmn.cmRole.deleteUserRole", roleCode);
	}

	/**
	 * 롤 삭제
	 * @param roleCode
	 */
	public void deleteCmRole(String roleCode) {
		sqlSession.delete("ncis.sql.cmn.cmRole.deleteCmRole", roleCode);
	}

	/**
	 * 메뉴 롤 등록
	 * @param menuRole
	 */
	public void updateRoleMenu(CmMenuRole menuRole) {
		sqlSession.update("ncis.sql.cmn.cmRole.updateRoleMenu", menuRole);
	}
}
