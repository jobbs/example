/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Grant.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.security.vo;

import ncis.cpt.sys.user.vo.UserRoleVo;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author kamsi76
 *
 */
public class Grant extends UserRoleVo implements GrantedAuthority {

	private static final long serialVersionUID = 3593809363203666270L;

	@Override
	public String getAuthority() {
		return getRoleCd();
	}

}
