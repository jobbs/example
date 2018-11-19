/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class RoutingScriptSearchVo extends CommonSearchVo {

	private String searchOSType;

	private String searchOSVer;

	private String searchUseYn;

	/**
	 * @return the searchOSType
	 */
	public String getSearchOSType() {
		return searchOSType;
	}

	/**
	 * @param searchOSType the searchOSType to set
	 */
	public void setSearchOSType(String searchOSType) {
		this.searchOSType = searchOSType;
	}

	/**
	 * @return the searchOSVer
	 */
	public String getSearchOSVer() {
		return searchOSVer;
	}

	/**
	 * @param searchOSVer the searchOSVer to set
	 */
	public void setSearchOSVer(String searchOSVer) {
		this.searchOSVer = searchOSVer;
	}

	/**
	 * @return the searchUseYn
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * @param searchUseYn the searchUseYn to set
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}


}
