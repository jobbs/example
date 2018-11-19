/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserConnRecSearchVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.vo;

import ncis.cmn.vo.CommonSearchVo;

public class UserConnHistSearchVo extends CommonSearchVo {

	private String firstSearch;

	private String searchUserId;

	private String searchUserNm;

	private String searchConnIp;

	private String searchStartDate;

	private String searchEndDate;

	/**
	 * @return the firstSearch
	 */
	public String getFirstSearch() {
		return firstSearch;
	}

	/**
	 * @param firstSearch the firstSearch to set
	 */
	public void setFirstSearch(String firstSearch) {
		this.firstSearch = firstSearch;
	}

	/**
	 * @return the searchUserId
	 */
	public String getSearchUserId() {
		return searchUserId;
	}

	/**
	 * @param searchUserId the searchUserId to set
	 */
	public void setSearchUserId(String searchUserId) {
		this.searchUserId = searchUserId;
	}

	/**
	 * @return the searchUserName
	 */
	public String getSearchUserNm() {
		return searchUserNm;
	}

	/**
	 * @param searchUserName the searchUserName to set
	 */
	public void setSearchUserNm(String searchUserNm) {
		this.searchUserNm = searchUserNm;
	}

	/**
	 * @return the searchStartDate
	 */
	public String getSearchStartDate() {
		return searchStartDate;
	}

	/**
	 * @param searchStartDate the searchStartDate to set
	 */
	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	/**
	 * @return the searchEndDate
	 */
	public String getSearchEndDate() {
		return searchEndDate;
	}

	/**
	 * @param searchEndDate the searchEndDate to set
	 */
	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	/**
	 * @return the searchConnIp
	 */
	public String getSearchConnIp() {
		return searchConnIp;
	}

	/**
	 * @param searchConnIp the searchConnIp to set
	 */
	public void setSearchConnIp(String searchConnIp) {
		this.searchConnIp = searchConnIp;
	}
}
