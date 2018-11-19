/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleServiceImpl.java
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
package ncis.cpt.sys.role.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmMenuDao;
import ncis.cmn.dao.CCmRoleDao;
import ncis.cmn.entity.CmMenuRole;
import ncis.cpt.sys.menu.vo.MenuVo;
import ncis.cpt.sys.role.dao.RoleDao;
import ncis.cpt.sys.role.service.RoleService;
import ncis.cpt.sys.role.vo.RoleMenuVo;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource(name="cCmRoleDao") private CCmRoleDao cCmRoleDao;
	@Resource(name="roleDao") private RoleDao roleDao;

	@Resource(name="cCmMenuDao") private CCmMenuDao cCmMenuDao;

	@Override
	public List<RoleVo> selectRoleList(RoleSearchVo searchVo) {
		List<RoleVo> list = null;

		int totalCount = roleDao.selectRoleTotCnt(searchVo);

        if( totalCount > 0 ) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount);   // 페이지 처리위한 count
            list = roleDao.selectRoleList(searchVo);
        }

        return list;
	}

	@Override
	public List<RoleVo> selectRoleAllList(RoleSearchVo searchVo) {
	    return roleDao.selectRoleAllList(searchVo);
	}

	@Override
	public RoleVo selectRole(String roleCode) {
		return roleDao.selectRole(roleCode);
	}

	@Override
	public void insertRole(RoleVo roleVo) {
		cCmRoleDao.insertCmRole(roleVo);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		cCmRoleDao.updateCmRole(roleVo);
	}

	@Override
	public void deleteRole(String roleCode) {
		//메뉴에 맵핑되어 잇는 권한 삭제
		cCmRoleDao.deleteMenuRole(roleCode);
		//사용자에 맵핑되어 잇는 권한 삭제
		cCmRoleDao.deleteUserRole(roleCode);
		//롤 삭제
		cCmRoleDao.deleteCmRole(roleCode);
	}

	@Override
	public List<MenuVo> selectRoleMenu(String roleCode) {
		List<RoleMenuVo> menus = roleDao.selectRoleMenuList(roleCode);

		Map<Long, MenuVo> menuMap = new HashMap<Long, MenuVo>();

		if( !CollectionUtils.isEmpty(menus) ) {
			for (MenuVo menu : menus) {
				if( !menuMap.containsKey(menu.getMenuSeq())) {
					if( menu.getParentSeq() != null ) {
						MenuVo parent = menuMap.get(menu.getParentSeq());
						if( parent != null ) {
							parent.addSubMenu(menu);
						}
					}
					menuMap.put(menu.getMenuSeq(), menu);
				}
			}
		}

		return menuMap.get(new Long(0)).getSubMenuList();
	}

	@Override
	public void updateRoleMenu(RoleVo roleVo) {


		List<CmMenuRole> menuRoles = roleVo.getMenuRoles();
		for (CmMenuRole menuRole : menuRoles) {
		    menuRole.setRoleCd(roleVo.getRoleCd());
		    menuRole.setUpdtUserId(roleVo.getRegUserId());
		    menuRole.setRegUserId(roleVo.getRegUserId());
		    cCmMenuDao.insertMenuRole(menuRole);
		}

	}

}
