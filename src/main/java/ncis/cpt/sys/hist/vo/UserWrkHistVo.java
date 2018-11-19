/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistVo.java
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
package ncis.cpt.sys.hist.vo;

import ncis.cmn.entity.CmUserWrkHist;

public class UserWrkHistVo extends CmUserWrkHist {

	/**
	 * 메뉴 패턴
	 */
	private String menuPattern;

	/**
	 * @return the menuPattern
	 */
	public String getMenuPattern() {
		return menuPattern;
	}

	/**
	 * @param menuPattern the menuPattern to set
	 */
	public void setMenuPattern(String menuPattern) {
		this.menuPattern = menuPattern;
	}


}
