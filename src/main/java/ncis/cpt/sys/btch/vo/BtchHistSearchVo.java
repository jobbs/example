/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistSearchVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박봉춘
 *
 */
public class BtchHistSearchVo extends CommonSearchVo{

	/**
	 * 배치작업명
	 */
	private String searchBtchWrkNm;

	/**
	 * 배치 작업 ID
	 */
	private String searchBtchWrkId;

	/**
	 * 배치 시작시간
	 */
	private String searchBtchStartTimeStart;

	/**
	 * 배치 시작시간
	 */
	private String searchBtchStartTimeEnd;

	/**
	 * 배치 상태
	 */
	private String searchBtchStatus;

	/**
	 *  시작시간 처음검색일자
	 */
	private String startTimefirstSearch;

	/**
	 * @return the searchBtchWrkNm
	 */
	public String getSearchBtchWrkNm() {
		return searchBtchWrkNm;
	}

	/**
	 * @param searchBtchWrkNm the searchBtchWrkNm to set
	 */
	public void setSearchBtchWrkNm(String searchBtchWrkNm) {
		this.searchBtchWrkNm = searchBtchWrkNm;
	}

	/**
	 * @return the searchBtchWrkId
	 */
	public String getSearchBtchWrkId() {
		return searchBtchWrkId;
	}

	/**
	 * @param searchBtchWrkId the searchBtchWrkId to set
	 */
	public void setSearchBtchWrkId(String searchBtchWrkId) {
		this.searchBtchWrkId = searchBtchWrkId;
	}

	/**
	 * @return the searchBtchStartTimeStart
	 */
	public String getSearchBtchStartTimeStart() {
		return searchBtchStartTimeStart;
	}

	/**
	 * @param searchBtchStartTimeStart the searchBtchStartTimeStart to set
	 */
	public void setSearchBtchStartTimeStart(String searchBtchStartTimeStart) {
		this.searchBtchStartTimeStart = searchBtchStartTimeStart;
	}

	/**
	 * @return the searchBtchStartTimeEnd
	 */
	public String getSearchBtchStartTimeEnd() {
		return searchBtchStartTimeEnd;
	}

	/**
	 * @param searchBtchStartTimeEnd the searchBtchStartTimeEnd to set
	 */
	public void setSearchBtchStartTimeEnd(String searchBtchStartTimeEnd) {
		this.searchBtchStartTimeEnd = searchBtchStartTimeEnd;
	}

	/**
	 * @return the searchBtchStatus
	 */
	public String getSearchBtchStatus() {
		return searchBtchStatus;
	}

	/**
	 * @param searchBtchStatus the searchBtchStatus to set
	 */
	public void setSearchBtchStatus(String searchBtchStatus) {
		this.searchBtchStatus = searchBtchStatus;
	}

	/**
	 * @return the startTimefirstSearch
	 */
	public String getStartTimefirstSearch() {
		return startTimefirstSearch;
	}

	/**
	 * @param startTimefirstSearch the startTimefirstSearch to set
	 */
	public void setStartTimefirstSearch(String startTimefirstSearch) {
		this.startTimefirstSearch = startTimefirstSearch;
	}

}
