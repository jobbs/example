/**
 * copyright 2016 NCIS Cloud api-Gateway System
 * @description
 * <pre></pre>
 *
 * @filename UseSearchVo.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.api.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박희택
 *
 */
public class ApiSearchVo extends CommonSearchVo {

	private String searchApiId;
	private String searchApiNm;
	private String searchApiVerCd;
	private String searchMethodCd;
	private String searchStackClCd;
	private String searchUri;
	private String searchDc;

	/**
	 * @return the searchApiId
	 */
	public String getSearchApiId() {
		return searchApiId;
	}
	/**
	 * @param searchApiId the searchApiId to set
	 */
	public void setSearchApiId(String searchApiId) {
		this.searchApiId = searchApiId;
	}
	/**
	 * @return the searchApiNm
	 */
	public String getSearchApiNm() {
		return searchApiNm;
	}
	/**
	 * @param searchApiNm the searchApiNm to set
	 */
	public void setSearchApiNm(String searchApiNm) {
		this.searchApiNm = searchApiNm;
	}
	/**
	 * @return the searchApiVerCd
	 */
	public String getSearchApiVerCd() {
		return searchApiVerCd;
	}
	/**
	 * @param searchApiVerCd the searchApiVerCd to set
	 */
	public void setSearchApiVerCd(String searchApiVerCd) {
		this.searchApiVerCd = searchApiVerCd;
	}
	/**
	 * @return the searchMethodCd
	 */
	public String getSearchMethodCd() {
		return searchMethodCd;
	}
	/**
	 * @param searchMethodCd the searchMethodCd to set
	 */
	public void setSearchMethodCd(String searchMethodCd) {
		this.searchMethodCd = searchMethodCd;
	}
	/**
	 * @return the searchStackClCd
	 */
	public String getSearchStackClCd() {
		return searchStackClCd;
	}
	/**
	 * @param searchStackClCd the searchStackClCd to set
	 */
	public void setSearchStackClCd(String searchStackClCd) {
		this.searchStackClCd = searchStackClCd;
	}
	/**
	 * @return the searchUri
	 */
	public String getSearchUri() {
		return searchUri;
	}
	/**
	 * @param searchUri the searchUri to set
	 */
	public void setSearchUri(String searchUri) {
		this.searchUri = searchUri;
	}
	/**
	 * @return the searchDc
	 */
	public String getSearchDc() {
		return searchDc;
	}
	/**
	 * @param searchDc the searchDc to set
	 */
	public void setSearchDc(String searchDc) {
		this.searchDc = searchDc;
	}

}
