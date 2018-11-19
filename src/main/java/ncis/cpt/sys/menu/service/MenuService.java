/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuService.java
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
package ncis.cpt.sys.menu.service;

import java.util.List;

import ncis.cmn.vo.Tree;
import ncis.cpt.sys.menu.vo.MenuRoleVo;
import ncis.cpt.sys.menu.vo.MenuVo;

public interface MenuService {

	/**
	 * 메뉴 트리구조 호출
	 * @param parentSeq
	 * @param isLazy
	 * @return
	 */
	Tree<Long, MenuVo> selectMenuListTree(Long parentSeq, boolean isLazy);

	/**
	 * 메뉴 상세 조회
	 * @param menuSeq
	 * @return
	 */
	MenuVo selectMenu(Long menuSeq);

	/**
	 * 메뉴 등록
	 * @param menu
	 */
	void insertMenu(MenuVo menu);

	/**
	 * 메뉴 수정
	 * @param menu
	 */
	void updateMenu(MenuVo menu);

	/**
	 * 메뉴 삭제
	 * @param menuSeq
	 */
	void deleteMenu(Long menuSeq);

	/**
	 * 메뉴 패턴이 존재하는지 여부 확인
	 * @param resourceSeq
	 * @param menuSeq
	 * @return
	 */
	boolean selectExistsPattern(String menuPattern, Long menuSeq);

	/**
	 * 메뉴에 속한 권한 목록 조회
	 * @param menuSeq
	 * @return
	 */
	List<MenuRoleVo> selectMenuRoleList(Long menuSeq);

	/**
	 * 메뉴에 권한 등록
	 * @param menu
	 */
	void insertMenuRole(MenuVo menu);

	/**
	 * 메뉴 위로 이동
	 * @param menuSeq
	 * @param parentSeq
	 */
	void updateMenuOrderUp(Long menuSeq, Long parentSeq);

	/**
	 * 메뉴 아래로 이동
	 * @param menuSeq
	 * @param parentSeq
	 */
	void updateMenuOrderDown(Long menuSeq, Long parentSeq);

	/**
	 * 메뉴 복제
	 * @param sourceMenuSeq    복제대상 메뉴 ID
	 * @param targetMenuSeq    복제할 메뉴 ID
	 * @param userId           복제자 ID
	 */
	void updateCopyMenuRole(Long sourceMenuSeq, Long targetMenuSeq, String userId);

	/**
	 * 메뉴의 자식
	 * @param menuSeq
	 * @return
	 */
	List<MenuVo> selectChildMenu(Long menuSeq);

}
