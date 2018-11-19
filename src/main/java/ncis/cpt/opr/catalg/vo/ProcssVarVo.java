/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProcssVarVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RrProcssVar;

/**
 * @author 이화영
 *
 */
public class ProcssVarVo extends RrProcssVar{
	private String varTyCdNm;

	public String getVarTyCdNm() {
		return varTyCdNm;
	}

	public void setVarTyCdNm(String varTyCdNm) {
		this.varTyCdNm = varTyCdNm;
	}



}
