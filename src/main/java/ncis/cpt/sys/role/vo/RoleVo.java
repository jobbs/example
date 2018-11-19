/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleVo.java
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

import java.util.List;

import ncis.cmn.entity.CmMenuRole;
import ncis.cmn.entity.CmRole;

public class RoleVo extends CmRole {

	private String roleTyNm;

	List<CmMenuRole> menuRoles;

	/**
	 * @return the menuRoles
	 */
	public List<CmMenuRole> getMenuRoles() {
		return menuRoles;
	}

	/**
	 * @param menuRoles the menuRoles to set
	 */
	public void setMenuRoles(List<CmMenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	/**
	 * @return the roleTyNm
	 */
	public String getRoleTyNm() {
		return roleTyNm;
	}

	/**
	 * @param roleTyNm the roleTyNm to set
	 */
	public void setRoleTyNm(String roleTyNm) {
		this.roleTyNm = roleTyNm;
	}

}
