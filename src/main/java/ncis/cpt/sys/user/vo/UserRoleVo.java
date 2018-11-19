/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserRoleVo.java
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
package ncis.cpt.sys.user.vo;

import ncis.cmn.entity.CmUsrRole;

public class UserRoleVo extends CmUsrRole {

	/**
	 * 롤 명
	 */
	private String roleNm;

	/**
	 * 롤타입
	 */
	private String roleTyCd;

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

	/**
	 * @return the roleTyCd
	 */
	public String getRoleTyCd() {
		return roleTyCd;
	}

	/**
	 * @param roleTyCd the roleTyCd to set
	 */
	public void setRoleTyCd(String roleTyCd) {
		this.roleTyCd = roleTyCd;
	}
}
