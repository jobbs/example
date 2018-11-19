/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatPrposVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RrTmplatPrpos;

/**
 * @author 송승규
 *
 */
public class TmplatPrposVo extends RrTmplatPrpos{

	private String prposNm;

	public String getPrposNm() {
		return prposNm;
	}

	public void setPrposNm(String prposNm) {
		this.prposNm = prposNm;
	}
}
