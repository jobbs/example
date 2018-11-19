/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuRoleVo.java
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
package ncis.cpt.sys.menu.vo;

import ncis.cmn.entity.CmMenuRole;

public class MenuRoleVo extends CmMenuRole {

	private String roleNm;

	/**
	 * @return the roleName
	 */
	public String getRoleNm() {
		return roleNm;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}
}
