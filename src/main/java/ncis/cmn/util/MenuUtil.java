/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuUtil.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.util.List;
import ncis.cmn.security.util.AuthorizeUtil;
import ncis.cmn.security.vo.UserVo;
import ncis.cpt.sys.menu.vo.MenuVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class MenuUtil {

	public static final Long SYSTEM_MENU_ID = new Long(-1);
	public static final Long CUSTOMER_MENU_ID = new Long(0);

	public static MenuVo getCurrentMenu(Integer menuId) {
		return getCurrentMenu(menuId.longValue());
	}

	public static MenuVo getCurrentMenu(Long menuId) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( !(principal instanceof UserDetails) ) {
			return null;
		}

		UserVo user = (UserVo)principal;
		return user.getCurrentMenu(menuId);
	}

	public static MenuVo getCurrentMenu(String path, String contextPath) {
		Object principal =  (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( !(principal instanceof UserDetails) ) {
			return null;
		}

		UserVo user = (UserVo)principal;
		String pattern = path.replaceAll("(^" + contextPath + ")|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "") + "/";
		return user.getCurrentMenu(pattern);
	}

	public static MenuVo getTopMenu(Long menuId){
		Object principal =  (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!(principal instanceof UserDetails)){
			return null;
		}
		UserVo user = (UserVo)principal;
		return user.getTopMenu(menuId);
	}

	public static boolean hasAuthWrite( String path, String contextPath ) {

	    Object principal =  (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if( !(principal instanceof UserDetails) ) {
            return false;
        }

        UserVo user = (UserVo)principal;

        if( user.isSysAdm())
        	return true;

        String pattern = path.replaceAll("(^" + contextPath + ")|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "") + "/";

        List<String> roleList = user.getMenuWriteRoleList(pattern);

        return AuthorizeUtil.hasAnyRole(roleList);
	}

	public static boolean hasAuthAct( String path, String contextPath ) {

        Object principal =  (Object)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if( !(principal instanceof UserDetails) ) {
            return false;
        }

        UserVo user = (UserVo)principal;

        if( user.isSysAdm() )
        	return true;

        String pattern = path.replaceAll("(^" + contextPath + ")|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "") + "/";

        List<String> roleList = user.getMenuActRoleList(pattern);

        return AuthorizeUtil.hasAnyRole(roleList);
    }

}
