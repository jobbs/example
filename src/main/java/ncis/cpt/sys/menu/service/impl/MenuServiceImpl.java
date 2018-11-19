/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MenuServiceImpl.java
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
package ncis.cpt.sys.menu.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmMenuDao;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.menu.dao.MenuDao;
import ncis.cpt.sys.menu.service.MenuService;
import ncis.cpt.sys.menu.vo.MenuRoleVo;
import ncis.cpt.sys.menu.vo.MenuVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Resource(name="cCmMenuDao") CCmMenuDao cCmMenuDao;
	@Resource(name="menuDao") MenuDao menuDao;

	@Override
	public Tree<Long, MenuVo> selectMenuListTree(Long parentSeq, boolean isLazy) {
		return this.selectMenuListTree(parentSeq, null, isLazy);
	}

	public Tree<Long, MenuVo> selectMenuListTree(Long parentSeq, String state, boolean isLazy) {
		Tree<Long,MenuVo> tree = new Tree<Long, MenuVo>(new TreeNode<Long,MenuVo>(parentSeq,"root",null),isLazy);
		tree.addChilds(menuDao.selectMenuListTree(parentSeq, state));
		return tree;
	}

	@Override
	public MenuVo selectMenu(Long menuSeq) {
		return menuDao.selectMenu(menuSeq);
	}

	@Override
	public void insertMenu(MenuVo menu) {
		cCmMenuDao.insertMenu(menu);
		//메뉴 등록 후 상위 메뉴의 권한을 복제 한다.
		cCmMenuDao.updateMenuCopyRoleList(menu.getParentSeq(), menu.getMenuSeq(), menu.getRegUserId(), menu.getUpdtUserId());
	}

	@Override
	public void updateCopyMenuRole(Long sourceMenuSeq, Long targetMenuSeq, String userId) {
		//해당 권한 삭제
		cCmMenuDao.deleteMenuRole(targetMenuSeq);
		//권한 복제
		cCmMenuDao.updateMenuCopyRoleList(sourceMenuSeq, targetMenuSeq, userId, userId);
	}

	@Override
	public void updateMenu(MenuVo menu) {
		cCmMenuDao.updateMenu(menu);
	}

	@Override
	public void deleteMenu(Long menuSeq) {
		//메뉴의 롤 삭제
		cCmMenuDao.deleteMenuRole(menuSeq);
		//메뉴 삭제
		cCmMenuDao.deleteMenu(menuSeq);
	}

	@Override
	public List<MenuVo> selectChildMenu(Long menuSeq) {
		return menuDao.selectChildMenu(menuSeq);
	}

	@Override
	public boolean selectExistsPattern(String menuPattern, Long menuSeq) {
		return menuDao.selectExistsPattern(menuPattern, menuSeq)>0?true:false;
	}

	@Override
	public List<MenuRoleVo> selectMenuRoleList(Long menuSeq) {
		return menuDao.selectMenuRoleList(menuSeq);
	}

	@Override
	public void insertMenuRole(MenuVo menu) {
		if(CollectionUtils.isEmpty(menu.getMenuRoleList())){
			return;
		}

		for(MenuRoleVo menuRole : menu.getMenuRoleList()){
			menuRole.setMenuSeq(menu.getMenuSeq());
			menuRole.setRegUserId(menu.getUpdtUserId());
			menuRole.setUpdtUserId(menu.getUpdtUserId());
			cCmMenuDao.insertMenuRole(menuRole);
		}
	}

	@Override
	public void updateMenuOrderUp(Long menuSeq, Long parentSeq) {
		cCmMenuDao.updateMenuDownOrderByUp(menuSeq);
		cCmMenuDao.updateMenuUpOrder(menuSeq);
	}

	@Override
	public void updateMenuOrderDown(Long menuSeq, Long parentSeq) {
		if(menuDao.selectMenu(menuSeq).getMenuOrder().intValue() == menuDao.selectMaxOrder(parentSeq).intValue()){
			return;
		}
		cCmMenuDao.updateMenuUpOrderByDown(menuSeq);
		cCmMenuDao.updateMenuDownOrder(menuSeq);
	}

}
