/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssVo.java
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

import ncis.cmn.entity.RnSRoutingScript;

/**
 * @author 이화영
 *
 */
public class RoutingScriptVo extends RnSRoutingScript {

	private String osTyNm;

	private String regUserNm;

	/**
	 * @return the osTyNm
	 */
	public String getOsTyNm() {
		return osTyNm;
	}

	/**
	 * @param osTyNm the osTyNm to set
	 */
	public void setOsTyNm(String osTyNm) {
		this.osTyNm = osTyNm;
	}

	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}

	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

}
