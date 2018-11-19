/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkSearchVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박봉춘
 *
 */
public class BtchWrkSearchVo extends CommonSearchVo{

	private String searchBtchWrkNm;

	private String searchBtchWrkId;

	private String searchStat;

	private String searchJobStatus;

	private String searchJobStatusLast;

	private String searchCycle;

	/**
	 * 배치 작업명
	 * @return the searchBtchWrkNm
	 */
	public String getSearchBtchWrkNm() {
		return searchBtchWrkNm;
	}

	/**
	 * 배치 작업명
	 * @param searchBtchWrkNm the searchBtchWrkNm to set
	 */
	public void setSearchBtchWrkNm(String searchBtchWrkNm) {
		this.searchBtchWrkNm = searchBtchWrkNm;
	}

	/**
	 * 배치 상태
	 * @return the searchStat
	 */
	public String getSearchStat() {
		return searchStat;
	}

	/**
	 * 배치 상태
	 * @param searchStat the searchStat to set
	 */
	public void setSearchStat(String searchStat) {
		this.searchStat = searchStat;
	}

    /**
     * @return the searchJobStatus
     */
    public String getSearchJobStatus() {
        return searchJobStatus;
    }

    /**
     * @param searchJobStatus the searchJobStatus to set
     */
    public void setSearchJobStatus(String searchJobStatus) {
        this.searchJobStatus = searchJobStatus;
    }

    /**
     * @return the searchJobStatusLast
     */
    public String getSearchJobStatusLast() {
        return searchJobStatusLast;
    }

    /**
     * @param searchJobStatusLast the searchJobStatusLast to set
     */
    public void setSearchJobStatusLast(String searchJobStatusLast) {
        this.searchJobStatusLast = searchJobStatusLast;
    }

    /**
     * 주기 검색
     * @return
     */
	public String getSearchCycle() {
		return searchCycle;
	}
	/**
	 * 주기 검색
	 * @param searchCycle
	 */
	public void setSearchCycle(String searchCycle) {
		this.searchCycle = searchCycle;
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


}
