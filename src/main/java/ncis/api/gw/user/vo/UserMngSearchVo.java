/**
 * copyright 2016 NCIS Cloud api-Gateway System
 * @description
 * <pre></pre>
 *
 * @filename UserMngSearchVo.java
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
package ncis.api.gw.user.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박희택
 *
 */
public class UserMngSearchVo extends CommonSearchVo {

	private String searchRegionId;
	private String searchSysCd;
	private String searchReqUsrNm;
	private String searchStatCd;

	/**
	 * @return the searchRegionId
	 */
	public String getSearchRegionId() {
		return searchRegionId;
	}
	/**
	 * @param searchRegionId the searchRegionId to set
	 */
	public void setSearchRegionId(String searchRegionId) {
		this.searchRegionId = searchRegionId;
	}
	/**
	 * @return the searchSysCd
	 */
	public String getSearchSysCd() {
		return searchSysCd;
	}
	/**
	 * @param searchSysCd the searchSysCd to set
	 */
	public void setSearchSysCd(String searchSysCd) {
		this.searchSysCd = searchSysCd;
	}
	/**
	 * @return the searchReqUsrNm
	 */
	public String getSearchReqUsrNm() {
		return searchReqUsrNm;
	}
	/**
	 * @param searchReqUsrNm the searchReqUsrNm to set
	 */
	public void setSearchReqUsrNm(String searchReqUsrNm) {
		this.searchReqUsrNm = searchReqUsrNm;
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

}
