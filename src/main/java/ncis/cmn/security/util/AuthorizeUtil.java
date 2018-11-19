/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthorizeUtil.java
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
package ncis.cmn.security.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ncis.cmn.security.vo.UserVo;
import ncis.cpt.sys.menu.vo.MenuVo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthorizeUtil {

	/** <pre>
	 * 해당 메뉴에 대한 수정권한을 가졌는지 여부를 리턴한다.
	 * </pre>
	 *
	 * @param cmPattern
	 * @param regId
	 * @param team
	 * @return
	 */
	public static boolean hasModifyAuthorize(String pattern, String regId){

		Object principal = (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!(principal instanceof UserDetails)){
			return false;
		}
		UserVo user = (UserVo) principal;
		if(!AuthorizeUtil.hasMenuWriteRole(pattern, user)){
			return false;
		}

		if(regId != null && user.getUserId().equals(regId)){
			return true;
		}

		return false;
	}

	/** <pre>
	 * 해당메뉴에 대한 쓰기권한을 가졌는지 여부를 리턴한다.
	 * </pre>
	 *
	 * @param pattern
	 * @return
	 */
	public static boolean hasMenuWriteRole(String pattern, UserVo user){

		return hasAnyRole(user.getMenuWriteRoleList(pattern));
	}

	/** <pre>
	 * 해당 메뉴에 대한 수정권한을 가졌는지 여부를 리턴한다.
	 * </pre>
	 *
	 * @param cmPattern
	 * @param regId
	 * @return
	 */
	public static boolean hasModifyAuthorize(MenuVo menu, String regId){

		Object principal = (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!(principal instanceof UserDetails)){
			return false;
		}
		UserVo user = (UserVo) principal;

		if(regId != null && user.getUserId().equals(regId)){
			return true;
		}

		if(!AuthorizeUtil.hasWriteRole(menu)){
			return false;
		}

		return false;
	}

	/** <pre>
	 * 해당 권한을 가졌는지 여부를 리턴한다.
	 * </pre>
	 *
	 * @param role
	 * @return
	 */
	public static boolean hasRole(String role){
		Collection<? extends GrantedAuthority> userAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		if(userAuthorities == null){
			return false;
		}

		Set<String> roles = AuthorityUtils.authorityListToSet(userAuthorities);

		if(roles == null){
			return false;
		}

		return roles.contains(role);
	}

	/** <pre>
	 * 해당 권한목록 중 하나의 권한이라도 가졌는지 여부를 리턴한다.
	 * </pre>
	 *
	 * @param _roleList
	 * @return
	 */
	public static boolean hasAnyRole(List<String> _roleList){
		Set<String> roles = null;
		Collection<? extends GrantedAuthority> userAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		if(_roleList == null || userAuthorities == null){
			return false;
		}

		roles = AuthorityUtils.authorityListToSet(userAuthorities);

		if(roles == null){
			return false;
		}

		for(String role : _roleList){
			if(roles.contains(role)){
				return true;
			}
		}
		return false;
	}

	public static boolean hasReadRole(MenuVo menu) {
		return hasAnyRole(menu.getReadRoleList());
	}

	public static boolean hasWriteRole(MenuVo menu) {
		return hasAnyRole(menu.getWriteRoleList());
	}

	public static boolean hasActRole(MenuVo menu) {
        return hasAnyRole(menu.getActRoleList());
    }
}
