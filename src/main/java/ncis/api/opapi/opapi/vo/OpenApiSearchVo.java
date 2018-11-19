/**
 * copyright 2016 NCIS Cloud Api Gateway System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiSearchVo.java
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
package ncis.api.opapi.opapi.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박희택
 *
 */
public class OpenApiSearchVo extends CommonSearchVo {

	private String searchOpenApiNm;
	private String searchStatCd;
	private String searchUri;

	/** openApi권한에서 조회하는 조회 값 */
	private String searchGubun;
	private String searchNm;

	/**
	 * @return the searchOpenApiNm
	 */
	public String getSearchOpenApiNm() {
		return searchOpenApiNm;
	}
	/**
	 * @param searchOpenApiNm the searchOpenApiNm to set
	 */
	public void setSearchOpenApiNm(String searchOpenApiNm) {
		this.searchOpenApiNm = searchOpenApiNm;
	}
	/**
	 * @return the searchStatCd
	 */
	public String getSearchStatCd() {
		return searchStatCd;
	}
	/**
	 * @param searchStatCd the searchStatCd to set
	 */
	public void setSearchStatCd(String searchStatCd) {
		this.searchStatCd = searchStatCd;
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
