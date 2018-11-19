/**
 * copyright 2016 NCIS Cloud api-Gateway System
 * @description
 * <pre></pre>
 *
 * @filename AuthrSearchVo.java
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
package ncis.api.opapi.authr.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박희택
 *
 */
public class AuthrSearchVo extends CommonSearchVo {

	private String searchAuthrId;
	private String searchAuthrNm;

	/** openApi권한에서 조회하는 조회 값 */
	private String searchGubun;
	private String searchNm;

	/**
	 * @return the searchAuthrId
	 */
	public String getSearchAuthrId() {
		return searchAuthrId;
	}
	/**
	 * @param searchAuthrId the searchAuthrId to set
	 */
	public void setSearchAuthrId(String searchAuthrId) {
		this.searchAuthrId = searchAuthrId;
	}
	/**
	 * @return the searchAuthrNm
	 */
	public String getSearchAuthrNm() {
		return searchAuthrNm;
	}
	/**
	 * @param searchAuthrNm the searchAuthrNm to set
	 */
	public void setSearchAuthrNm(String searchAuthrNm) {
		this.searchAuthrNm = searchAuthrNm;
	}
	/**
	 * @return the searchGubun
	 */
	public String getSearchGubun() {
		return searchGubun;
	}
	/**
	 * @param searchGubun the searchGubun to set
	 */
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	/**
	 * @return the searchNm
	 */
	public String getSearchNm() {
		return searchNm;
	}
	/**
	 * @param searchNm the searchNm to set
	 */
	public void setSearchNm(String searchNm) {
		this.searchNm = searchNm;
	}

}
