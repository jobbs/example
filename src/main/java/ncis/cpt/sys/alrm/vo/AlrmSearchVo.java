/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmSearchVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최진호
 *
 */
public class AlrmSearchVo extends CommonSearchVo {

	/**
	 * 처음검색일자
	 */
	private String firstSearch;
	/**
	 * 알람 제목
	 */
	private String searchAlrmSbjct;

	/**
	 * 알람 상태
	 */
    private String searchStatCd;

    /**
     * 확인여부
     */
    private String searchConfirmYn;

    /**
     * 시작일자
     */
	private String searchStartDate;

	/**
	 * 종료일자
	 */
	private String searchEndDate;

	/**
	 * @return the searchAlrmSbjct
	 */
	public String getSearchAlrmSbjct() {
		return searchAlrmSbjct;
	}

	/**
	 * @param searchAlrmSbjct the searchAlrmSbjct to set
	 */
	public void setSearchAlrmSbjct(String searchAlrmSbjct) {
		this.searchAlrmSbjct = searchAlrmSbjct;
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
	 * @return the searchConfirmYn
	 */
	public String getSearchConfirmYn() {
		return searchConfirmYn;
	}

	/**
	 * @param searchConfirmYn the searchConfirmYn to set
	 */
	public void setSearchConfirmYn(String searchConfirmYn) {
		this.searchConfirmYn = searchConfirmYn;
	}

	@Override
	public String getSearchUserId() {
	    return RequestUtils.getUserId();
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
