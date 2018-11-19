/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserMenuMap.java
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

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ncis.cpt.sys.menu.vo.MenuVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

public class UserMenuMap implements Serializable {

	private static final long serialVersionUID = -8512829025804759703L;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserMenuMap.class);

	private Map<Long, MenuVo> menuMap = new HashMap<Long, MenuVo>();

	public UserMenuMap() {
	}

	public UserMenuMap(List<MenuVo> menus) {
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
	}

	public List<MenuVo> getSubMenuList(Long menuId) throws Exception {
		MenuVo topMenu = getMenuById(menuId);
		if( topMenu == null ) {
			return null;
		}

		return topMenu.getSubMenuList();
	}

	public MenuVo getMenuById(Long menuId) throws Exception {
		MenuVo currentMenu = menuMap.get(menuId);
		if( currentMenu == null ) {
			return null;
		}

		if( currentMenu.getParent() == null ) {
			throw new Exception("최 상위 메뉴 호출시 오류 발생");
		}

		return currentMenu;
	}

	public MenuVo getCurrentMenu(Long menuId) {
		if( menuId == null ) {
			return null;
		}

		return menuMap.get(menuId);
	}

	public MenuVo getCurrentMenu(String path) {

		if( path == null || menuMap == null || menuMap.entrySet() == null ) {
			return null;
		}

		for( Entry<Long, MenuVo> entry : menuMap.entrySet() ) {
			MenuVo menu = entry.getValue();

			if( path.equals(menu.getMenuPattern())) {
				return menu;
			}
		}
		return null;
	}

	public MenuVo getTopMenu(Long menuId) {
		MenuVo curMenu = menuMap.get(menuId);
		if (curMenu == null) {
			return null;
		}

		int level = curMenu.getMenuLevel().intValue();

		if (level < 3) {
			return null;
		} else if (level == 3) {
			return curMenu;
		} else if (curMenu.getParent() == null) {
			return null;
		} else {
			return getTopMenu(curMenu.getParent().getMenuSeq());
		}
	}

}
