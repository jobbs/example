/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.vo;

import ncis.cmn.entity.CmAlrm;

/**
 * @author 최진호
 *
 */
public class AlrmVo extends CmAlrm {

	/**
	 * 담당자 이름
	 */
	private String chargerNm;

	/**
	 * 상태 이름
	 */
	private String statNm;
	/**
	 * @return the chargerNm
	 */
	public String getChargerNm() {
		return chargerNm;
	}

	/**
	 * @param chargerNm the chargerNm to set
	 */
	public void setChargerNm(String chargerNm) {
		this.chargerNm = chargerNm;
	}

	public String getStatNm() {
		return statNm;
	}

	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}
}
