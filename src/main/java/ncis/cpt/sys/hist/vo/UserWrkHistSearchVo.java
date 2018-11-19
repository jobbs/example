/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistSearchVo.java
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

public class UserWrkHistSearchVo extends CommonSearchVo {

	private String firstSearch;
	/**
	 * 메뉴명
	 */
    private String searchMenuNm;

    /**
     * 작업정보
     */
    private String searchWrkInfo;

    /**
     * 작업자아이디
     */
    private String searchUserId;

    /**
     * 작업자명
     */
    private String searchUserNm;

    /**
     * 작업일시 시작시간
     */
    private String searchStartDate;

    /**
     * 작업일시 종료시간
     */
	private String searchEndDate;
    /**
     * @return the searchMenuNm
     */
    public String getSearchMenuNm() {
        return searchMenuNm;
    }

    /**
     * @param searchMenuNm the searchMenuNm to set
     */
    public void setSearchMenuNm(String searchMenuNm) {
        this.searchMenuNm = searchMenuNm;
    }

    /**
     * @return the searchWrkInfo
     */
    public String getSearchWrkInfo() {
        return searchWrkInfo;
    }

    /**
     * @param searchWrkInfo the searchWrkInfo to set
     */
    public void setSearchWrkInfo(String searchWrkInfo) {
        this.searchWrkInfo = searchWrkInfo;
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
     * @return the searchUserNm
     */
    public String getSearchUserNm() {
        return searchUserNm;
    }

    /**
     * @param searchUserNm the searchUserNm to set
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

}
