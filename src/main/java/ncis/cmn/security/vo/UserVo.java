/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserVo.java
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ncis.cmn.entity.CmUsr;
import ncis.cmn.entity.CmUsrUiConf;
import ncis.cpt.sys.menu.vo.MenuRoleVo;
import ncis.cpt.sys.menu.vo.MenuVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author kamsi76
 *
 */
public class UserVo extends CmUsr implements UserDetails {

	private static final long serialVersionUID = 8364969647936483680L;

	private final Logger logger = LoggerFactory.getLogger(UserVo.class);

	@SuppressWarnings("unused")
    private String superposeRoleNm;

	private List<Grant> roleList;				//사용자의 권한 목록

	private Date ncmsRcntLoginDttm;

	private Set<GrantedAuthority> authorities;

	private List<MenuVo> menuList;

	private List<CmUsrUiConf> uiConfs;         // 사용자가 화면에서 컴포넌트 관련 상태 저장 목록

	private UserMenuMap menuMap;				//사용자가 접근가능한 메뉴 정보

	public Collection<? extends GrantedAuthority> getAuthorities() {
		if( authorities == null ) {
			authorities = new HashSet<GrantedAuthority>();
			for (Grant grant : getRoleList()) {
				authorities.add(grant);
			}
		}
		return authorities;
	}

	public String getPassword() {
		return getPasswd();
	}

	public String getUsername() {
		return getUserId();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the roleList
	 */
	public List<Grant> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<Grant> roleList) {
		this.roleList = roleList;
	}

	/**
	 *  사용자가 사용간ㅇ한 메뉴 정보 set
	 * @param menus
	 */
	public void setMenuList(List<MenuVo> menus) {
		menuMap = new UserMenuMap(menus);
	}

	public List<MenuVo> getMenuList() {
		return menuList;
	}

	public MenuVo getCurrentMenu(Long menuId) {
		return menuMap.getCurrentMenu(menuId);
	}

	public MenuVo getCurrentMenu(String path) {
		return menuMap.getCurrentMenu(path);
	}

	public MenuVo getTopMenu(Long menuId){
		MenuVo menu = menuMap.getTopMenu(menuId);
		return menu;
	}

	public List<MenuVo> getSubMenuList(Long menuId) throws Exception {
		return menuMap.getSubMenuList(menuId);
	}

	public List<MenuRoleVo> getMenuRoleList(String pattern){
		MenuVo menu = getCurrentMenu(pattern);
		if(menu == null){
			return null;
		}
		return menu.getMenuRoleList();
	}

	public List<String> getMenuWriteRoleList(String pattern) {
		List<MenuRoleVo> roleList = getMenuRoleList(pattern);

		if( null == roleList ) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		for (MenuRoleVo menuRoleVo : roleList) {
			if( "Y".equals(menuRoleVo.getWriteYn()) ) {
				list.add(menuRoleVo.getRoleCd());
			}
		}

		return list;
	}

	public List<String> getMenuReadRoleList(String pattern) {
		List<MenuRoleVo> roleList = getMenuRoleList(pattern);

		if( null == roleList ) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		for (MenuRoleVo menuRoleVo : roleList) {
			if( "Y".equals(menuRoleVo.getReadYn()) ) {
				list.add(menuRoleVo.getRoleCd());
			}
		}

		return list;
	}

	public List<String> getMenuActRoleList(String pattern) {
		List<MenuRoleVo> roleList = getMenuRoleList(pattern);

		if( null == roleList ) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		for (MenuRoleVo menuRoleVo : roleList) {
			if( "Y".equals(menuRoleVo.getActYn()) ) {
				list.add(menuRoleVo.getRoleCd());
			}
		}

		return list;
	}

    /**
     * @return the ncmsRcntLoginDttm
     */
    public Date getNcmsRcntLoginDttm() {
        return ncmsRcntLoginDttm;
    }

    /**
     * @param ncmsRcntLoginDttm the ncmsRcntLoginDttm to set
     */
    public void setNcmsRcntLoginDttm(Date ncmsRcntLoginDttm) {
        this.ncmsRcntLoginDttm = ncmsRcntLoginDttm;
    }

    public List<String> selectUserRoleList() {
    	List<String> strGrant = new ArrayList<String>();
        for (Grant grant : this.roleList) {
            strGrant.add(grant.getRoleTyCd());
        }

        return strGrant;
    }

    public boolean isSysAdm() {
    	List<String> strGrant = selectUserRoleList();
    	return strGrant.contains("SYSADM");
    }

    public boolean isOprAdm() {
    	List<String> strGrant = selectUserRoleList();
    	return strGrant.contains("OPRADM");
    }

    public boolean isOprChr() {
    	List<String> strGrant = selectUserRoleList();
    	return strGrant.contains("OPRCHR");
    }
    
    public boolean isBldAdm() {
    	List<String> strGrant = selectUserRoleList();
    	return strGrant.contains("BLDADM");
    }

    /**
     * 사용자의 권한 중 상위 권한을 체크한다.
     * 시스템관리자, 운영자, 담당자가 아닐경우 null을 리턴한다.
     * @return
     */
    public String getSuperposedUserRole() {

    	List<String> strGrant = selectUserRoleList();

        if( strGrant.contains("SYSADM") ) {
            return "SYSADM";
        } else if( strGrant.contains("OPRADM") ) {
            return "OPRADM";
        } else if( strGrant.contains("OPRCHR") ) {
            return "OPRCHR";
        } else if( strGrant.contains("BLDADM") ) {
                return "BLDADM";
        } else {
            Iterator<GrantedAuthority> itr = this.authorities.iterator();
            if( itr.hasNext() ) {
            	String role = ((Grant)itr.next()).getRoleTyCd();
            	return role;
            } else {
            	return null;
            }
        }
    }

    /**
     * @return the superposeRoleNm
     */
    public String getSuperposeRoleNm() {
        String roleCd = getSuperposedUserRole();
        String roleNm = null;

        for (Grant grant : this.roleList) {
            if( roleCd.equals(grant.getRoleTyCd()) ) {
                roleNm = grant.getRoleNm();
            }
        }

        return roleNm;
    }

    /**
     * @return the uiConfs
     * @throws JsonProcessingException
     */
    public String getUiConfJson() {

        if( null != uiConfs ) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(uiConfs);
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }

        return "[]";

    }

    /**
     * @param uiConfs the uiConfs to set
     */
    public void setUiConfs(List<CmUsrUiConf> uiConfs) {
        this.uiConfs = uiConfs;
    }

    public void updateUiConf(CmUsrUiConf uiConf) {

    	boolean isExist = false;

        for( int i = 0; i < uiConfs.size(); i++ ) {
            if( uiConf.getConfCd().equals(uiConfs.get(i).getConfCd()) ) {
                uiConfs.get(i).setConfVl(uiConf.getConfVl());

                isExist = true;
                break;
            }
        }

        if( !isExist ) {
        	uiConfs.add(uiConf);
        }
    }

    public void updateUiConf(String confCd, String confVl) {

    	boolean isExist = false;

        for( int i = 0; i < uiConfs.size(); i++ ) {
            if( confCd.equals(uiConfs.get(i).getConfCd()) ) {
                uiConfs.get(i).setConfVl(confVl);

                isExist = true;
                break;
            }
        }

        if( !isExist ) {
        	CmUsrUiConf uiConf = new CmUsrUiConf();
        	uiConf.setConfCd(confCd);
        	uiConf.setConfVl(confVl);

        	uiConfs.add(uiConf);
        }

    }

}
