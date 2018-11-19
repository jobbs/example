/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WordDicarySearchVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.worddicary.vo;

import ncis.cmn.vo.CommonSearchVo;

public class WordDicarySearchVo extends CommonSearchVo {

	private String searchKr;

	private String searchEn;

	private String searchAbrv;

	private String searchProhibitYn;

	private String searchDiv;

	private String prohibitYn;

	/**
	 * @return the searchDiv
	 */
	public String getSearchDiv() {
		return searchDiv;
	}

	/**
	 * @param searchDiv the searchDiv to set
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	/**
	 * @return the prohibitYn
	 */
	public String getProhibitYn() {
		return prohibitYn;
	}

	/**
	 * @param prohibitYn the prohibitYn to set
	 */
	public void setProhibitYn(String prohibitYn) {
		this.prohibitYn = prohibitYn;
	}

	/**
	 * @return the searchKr
	 */
	public String getSearchKr() {
		return searchKr;
	}

	/**
	 * @param searchKr the searchKr to set
	 */
	public void setSearchKr(String searchKr) {
		this.searchKr = searchKr;
	}

	/**
	 * @return the searchEn
	 */
	public String getSearchEn() {
		return searchEn;
	}

	/**
	 * @param searchEn the searchEn to set
	 */
	public void setSearchEn(String searchEn) {
		this.searchEn = searchEn;
	}

	/**
	 * @return the searchAbrv
	 */
	public String getSearchAbrv() {
		return searchAbrv;
	}

	/**
	 * @param searchAbrv the searchAbrv to set
	 */
	public void setSearchAbrv(String searchAbrv) {
		this.searchAbrv = searchAbrv;
	}

	/**
	 * @return the searchProhibitYn
	 */
	public String getSearchProhibitYn() {
		return searchProhibitYn;
	}

	/**
	 * @param searchProhibitYn the searchProhibitYn to set
	 */
	public void setSearchProhibitYn(String searchProhibitYn) {
		this.searchProhibitYn = searchProhibitYn;
	}
}
