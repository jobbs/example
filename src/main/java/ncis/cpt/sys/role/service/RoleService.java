/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleService.java
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
package ncis.cpt.sys.role.service;

import java.util.List;
import ncis.cpt.sys.menu.vo.MenuVo;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;

public interface RoleService {

	/**
	 * 롤 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<RoleVo> selectRoleList(RoleSearchVo searchVo);

	/**
	 * 페이징 처리 헚이 모든 롤 정보 조회
	 * @param searchVo
	 * @return
	 */
	List<RoleVo> selectRoleAllList(RoleSearchVo searchVo);

	/**
	 * 롤 상세 조회
	 * @param roleCode
	 * @return
	 */
	RoleVo selectRole(String roleCode);

	/**
	 * 롤 등록
	 * @param roleVo
	 */
	void insertRole(RoleVo roleVo);

	/**
	 * 롤 수정
	 * @param roleVo
	 */
	void updateRole(RoleVo roleVo);

	/**
	 * 롤정보 삭제
	 * @param roleCode
	 */
	void deleteRole(String roleCode);

	/**
	 * 롤에 속한 메뉴 정보 호출
	 * @param roleCode
	 * @return
	 */
	List<MenuVo> selectRoleMenu(String roleCode);


	/**
	 * 롤에 해당하는 메뉴 권한 등록
	 * @param roleVo
	 */
	void updateRoleMenu(RoleVo roleVo);



}
