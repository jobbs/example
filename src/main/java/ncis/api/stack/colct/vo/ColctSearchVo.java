/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctSearchVo.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최장성
 *
 */
public class ColctSearchVo extends CommonSearchVo {

	private String searchRegionId;

	private String searchZoneId;

	private String searchNetId;

	private String searchStackClCd;

	private String searchMngrClCd;

	private String searchMngrVerCd;

	private String searchNowVerCd;

	private String searchMngrNm;

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
	 * @return the searchZoneId
	 */
	public String getSearchZoneId() {
		return searchZoneId;
	}

	/**
	 * @param searchZoneId the searchZoneId to set
	 */
	public void setSearchZoneId(String searchZoneId) {
		this.searchZoneId = searchZoneId;
	}

	/**
	 * @return the searchNetId
	 */
	public String getSearchNetId() {
		return searchNetId;
	}

	/**
	 * @param searchNetId the searchNetId to set
	 */
	public void setSearchNetId(String searchNetId) {
		this.searchNetId = searchNetId;
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
	 * @return the searchMngrClCd
	 */
	public String getSearchMngrClCd() {
		return searchMngrClCd;
	}

	/**
	 * @param searchMngrClCd the searchMngrClCd to set
	 */
	public void setSearchMngrClCd(String searchMngrClCd) {
		this.searchMngrClCd = searchMngrClCd;
	}

	/**
	 * @return the searchMngrVerCd
	 */
	public String getSearchMngrVerCd() {
		return searchMngrVerCd;
	}

	/**
	 * @param searchMngrVerCd the searchMngrVerCd to set
	 */
	public void setSearchMngrVerCd(String searchMngrVerCd) {
		this.searchMngrVerCd = searchMngrVerCd;
	}

	/**
	 * @return the searchNowVerCd
	 */
	public String getSearchNowVerCd() {
		return searchNowVerCd;
	}

	/**
	 * @param searchNowVerCd the searchNowVerCd to set
	 */
	public void setSearchNowVerCd(String searchNowVerCd) {
		this.searchNowVerCd = searchNowVerCd;
	}

	/**
	 * @return the searchMngrNm
	 */
	public String getSearchMngrNm() {
		return searchMngrNm;
	}

	/**
	 * @param searchMngrNm the searchMngrNm to set
	 */
	public void setSearchMngrNm(String searchMngrNm) {
		this.searchMngrNm = searchMngrNm;
	}

}
