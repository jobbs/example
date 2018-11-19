/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.menu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.menu.vo.MenuRoleVo;
import ncis.cpt.sys.menu.vo.MenuSearchVo;
import ncis.cpt.sys.menu.vo.MenuVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public class MenuDao {

	@Autowired SqlSession sqlSession;

	/**
	 * 검색 조건에 해당하는 메뉴 조회 수 호출
	 * @param searchVo
	 * @return
	 */
	public int selectMenuTotCnt(MenuSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.menu.selectMenuTotCnt", searchVo);
	}

	/**
	 * 조회 조건에 해당하는 메뉴 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<MenuVo> selectMenuList(MenuSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.menu.selectMenuList", searchVo);
	}

	/**
	 * 메뉴 상세정보 조회
	 * @param menuSeq
	 * @return
	 */
	public MenuVo selectMenu(Long menuSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.menu.selectMenu", menuSeq);
	}

	/**
	 * 메뉴 목록을 Tree 형태로 조회
	 * @param parentSeq
	 * @param state
	 * @return
	 */
	public List<TreeNode<Long, MenuVo>> selectMenuListTree(Long parentSeq, String state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentSeq);
		params.put("state", state);
		return sqlSession.selectList("ncis.sql.cpt.menu.selectMenuListTree",params);
	}

	/**
	 * 자식 메뉴 호출
	 * @param menuSeq
	 * @return
	 */
	public List<MenuVo> selectChildMenu(Long menuSeq) {
		return sqlSession.selectList("ncis.sql.cpt.menu.selectChildMenu",menuSeq);
	}

	/**
	 * 메뉴 패턴이 동일한 항목이 있는지 개수 확인
	 * @param menuPattern
	 * @param menuSeq
	 * @return
	 */
	public int selectExistsPattern(String menuPattern, Long menuSeq) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("menuPattern", menuPattern);
		params.put("menuSeq", menuSeq);
		return sqlSession.selectOne("ncis.sql.cpt.menu.getExistsPattern", params);
	}

	/**
	 * 메뉴에 속한 롤 목록
	 * @param menuSeq
	 * @return
	 */
	public List<MenuRoleVo> selectMenuRoleList(Long menuSeq) {
		return sqlSession.selectList("ncis.sql.cpt.menu.selectMenuRoleList", menuSeq);
	}

	/** <pre>
	 * 입력된 메뉴의 자식메뉴 중 가장 마지막 에 위치한 메뉴의 순서를 조회한다.
	 * </pre>
	 *
	 * @param parentSeq
	 * @return
	 */
	public Integer selectMaxOrder(Long parentSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.menu.selectMaxOrder", parentSeq);
	}



}
