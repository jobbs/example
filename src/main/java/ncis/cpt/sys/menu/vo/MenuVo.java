/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuVo.java
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

import java.util.ArrayList;
import java.util.List;

import ncis.cmn.entity.CmMenu;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;

public class MenuVo extends CmMenu {

	private MenuVo parent;				//부모 메뉴 정보
	private List<MenuVo> subMenuList;	//자식 메뉴 정보

	private List<MenuRoleVo> menuRoleList;

	/**
	 * @return the parent
	 */
	public MenuVo getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(MenuVo parent) {
		this.parent = parent;
	}

	/**
	 * @return the subMenuList
	 */
	public List<MenuVo> getSubMenuList() {
		return subMenuList;
	}

	/**
	 * @param subMenuList the subMenuList to set
	 */
	public void setSubMenuList(List<MenuVo> subMenuList) {

		for( MenuVo subMenu: subMenuList ) {
			subMenu.setParent(this);
		}

		this.subMenuList = subMenuList;
	}

	public void addSubMenu(MenuVo subMenu) {
		if( this.subMenuList == null ) {
			this.subMenuList = new ArrayList<MenuVo>();
		}
		subMenuList.add(subMenu);
		subMenu.setParent(this);
	}

	public String getRealUrl(){
		if(CollectionUtils.isEmpty(subMenuList)){
			return combineUrl(this);
		}
		return combineUrl(subMenuList.get(0));
	}

	private String combineUrl(MenuVo menu) {
		if( menu != null ) {

			if(!CollectionUtils.isEmpty(menu.getSubMenuList())){
				return combineUrl(menu.getSubMenuList().get(0));
			}

			return new StringBuffer().append(menu.getMenuPattern()).append(menu.getMenuFile()).toString();
		}

		return null;
	}

	public MenuVo[] getLocation(){
		MenuVo[] result = new MenuVo[getMenuLevel()];
		setLocation(result, this);
		return result;
	}

	private void setLocation(MenuVo[] result, MenuVo menu){
		result[menu.getMenuLevel()-1] = menu;
		if(menu.getParent() != null){
			setLocation(result, menu.getParent());
		}
	}

	/**
	 * @return the menuRoleList
	 */
	public List<MenuRoleVo> getMenuRoleList() {
		return menuRoleList;
	}

	/**
	 * @param menuRoleList the menuRoleList to set
	 */
	public void setMenuRoleList(List<MenuRoleVo> menuRoleList) {
		this.menuRoleList = menuRoleList;
	}

	/**
	 * 상위 메뉴 패턴과 동일힌지 여부 확인
	 * @param errors
	 */
	public void validatePatternUrl(Errors errors){

		if(getMenuPattern() != null && !getMenuPattern().isEmpty()
				&& getMenuPattern() != null && !getMenuPattern().isEmpty()
				&& !getMenuPattern().startsWith(getParent().getMenuPattern())){
			errors.rejectValue("menuPattern", "상위 메뉴와 동일한 패턴이 아닙니다.");
		}
	}

	/**
	 * 읽기 권한 목록
	 * @return
	 */
	public List<String> getReadRoleList() {
		List<String> list = new ArrayList<String>();
		for( MenuRoleVo role : menuRoleList ) {
			if( "Y".equals(role.getReadYn()) ) {
				list.add(role.getRoleCd());
			}
		}

		return list;
	}

	/**
	 * 쓰기(등록, 수정, 삭제) 권한 목록
	 * @return
	 */
	public List<String> getWriteRoleList() {
		List<String> list = new ArrayList<String>();
		for( MenuRoleVo role : menuRoleList ) {
			if( "Y".equals(role.getWriteYn()) ) {
				list.add(role.getRoleCd());
			}
		}

		return list;
	}

	/**
	 * 실행권한 목록
	 * @return
	 */
	public List<String> getActRoleList() {
		List<String> list = new ArrayList<String>();
		for( MenuRoleVo role : menuRoleList ) {
			if( "Y".equals(role.getActYn()) ) {
				list.add(role.getRoleCd());
			}
		}

		return list;
	}

}
