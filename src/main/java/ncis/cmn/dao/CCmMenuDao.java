/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmMenuDao.java
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
import ncis.cmn.entity.CmMenuRole;
import ncis.cpt.sys.menu.vo.MenuVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cCmMenuDao")
public class CCmMenuDao {

	@Autowired SqlSession sqlSession;

	public void insertMenu(MenuVo menu) {
		sqlSession.insert("ncis.sql.cmn.menu.insertMenu", menu);
	}

	public void updateMenu(MenuVo menu) {
		sqlSession.update("ncis.sql.cmn.menu.updateMenu", menu);
	}

	public void deleteMenu(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.deleteMenu", menuSeq);
	}

	public void insertMenuRole(CmMenuRole menuRole) {
		sqlSession.insert("ncis.sql.cmn.menu.insertMenuRole", menuRole);
	}

	/** <pre>
	 * 순서를 위로 이동시 이동하려는 메뉴  앞에 존재하는 메뉴의 순서를 아래로 이동시킨다.
	 * </pre>
	 *
	 * @param menuId
	 */
	public void updateMenuDownOrderByUp(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.updateMenuDownOrderByUp", menuSeq);
	}

	/** <pre>
	 * 메뉴의 순서를 위로 이동시킨다.
	 * </pre>
	 *
	 * @param menuId
	 */
	public void updateMenuUpOrder(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.updateMenuUpOrder", menuSeq);
	}

	/** <pre>
	 * 아래로 이동하려는 메뉴의 바로 뒤에 있는 메뉴에 대한 순서를 앞으로 이동시킨다.
	 * </pre>
	 *
	 * @param menuId
	 */
	public void updateMenuUpOrderByDown(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.updateMenuUpOrderByDown", menuSeq);
	}

	/** <pre>
	 * 메뉴의 순서를 아래로 이동시킨다.
	 * </pre>
	 *
	 * @param menuId
	 * @param parentId
	 */
	public void updateMenuDownOrder(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.updateMenuDownOrder", menuSeq);
	}

	/**
	 * 메뉴 복제
	 * SourceMenuId의 권한을 TargetMenuId로 복제한다.
	 * @param sourceMenuId	제공 메뉴 아이디
	 * @param targetMenuId	대상 메뉴 아이디
	 * @param regId			등록자 아이디
	 * @param modId			수정자 아이디
	 */
	public void updateMenuCopyRoleList(Long sourceMenuSeq, Long targetMenuSeq, String regUserId, String updtUserId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("sourceMenuSeq", sourceMenuSeq);
		param.put("targetMenuSeq", targetMenuSeq);
		param.put("regUserId", regUserId);
		param.put("updtUserId", updtUserId);
		sqlSession.update("ncis.sql.cmn.menu.updateMenuCopyRoleList", param);
	}

	/**
	 * 메뉴에 속한 권한 목록 삭제
	 * @param targetMenuId
	 */
	public void deleteMenuRole(Long menuSeq) {
		sqlSession.update("ncis.sql.cmn.menu.deleteMenuRole", menuSeq);
	}

}
