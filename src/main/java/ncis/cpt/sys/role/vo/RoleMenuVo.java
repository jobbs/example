/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleMenuVo.java
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
package ncis.cpt.sys.role.vo;

import ncis.cmn.entity.CmMenuRole;
import ncis.cpt.sys.menu.vo.MenuVo;

public class RoleMenuVo extends MenuVo {

	private CmMenuRole menuRole;

	/**
	 * @return the menuRole
	 */
	public CmMenuRole getMenuRole() {
		return menuRole;
	}

	/**
	 * @param menuRole the menuRole to set
	 */
	public void setMenuRole(CmMenuRole menuRole) {
		this.menuRole = menuRole;
	}

}
