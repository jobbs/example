/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RrSw;

/**
 * @author 송승규
 *
 */
public class TmplatSwVo extends RrSw{

	/**
	 * 템플릿ID
	 */
	private Integer tmplatSeq;

	/**
	 * 등록자명
	 */
	private String regUserNm;

	/**
	 * 수정자명
	 */
	private String updtUserNm;

	/**
	 * @return the tmplatSeq
	 */
	public Integer getTmplatSeq() {
		return tmplatSeq;
	}

	/**
	 * @param tmplatSeq the tmplatSeq to set
	 */
	public void setTmplatSeq(Integer tmplatSeq) {
		this.tmplatSeq = tmplatSeq;
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

	/**
	 * @return the updtUserNm
	 */
	public String getUpdtUserNm() {
		return updtUserNm;
	}

	/**
	 * @param updtUserNm the updtUserNm to set
	 */
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
}
