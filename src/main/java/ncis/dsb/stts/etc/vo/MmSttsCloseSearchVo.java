/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 * 2017. 05. 20   양정순         v2.0             자동확장 수정
 */
package ncis.dsb.stts.etc.vo;

import ncis.cmn.vo.CommonSearchVo;

public class MmSttsCloseSearchVo extends CommonSearchVo {
	private String year;
	private String month;
	private String closeMonth;
	private String preMonth;
	private String searchServer;
	private int pmSeq;
	private int servcSeq;
	private String podId;
	private int prvPageNo = 0;
	private String regionId;
	private String zoneId;
	private String netId;
	private String rsrcPoolId;
	private String UserId;
	private String search;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCloseMonth() {
		return closeMonth;
	}

	public void setCloseMonth(String closeMonth) {
		this.closeMonth = closeMonth;
	}

	public String getPreMonth() {
		return preMonth;
	}

	public void setPreMonth(String preMonth) {
		this.preMonth = preMonth;
	}

	public String getSearchServer() {
		return searchServer;
	}

	public void setSearchServer(String searchServer) {
		this.searchServer = searchServer;
	}

	public int getPmSeq() {
		return pmSeq;
	}

	public void setPmSeq(int pmSeq) {
		this.pmSeq = pmSeq;
	}

	public int getServcSeq() {
		return servcSeq;
	}

	public void setServcSeq(int servcSeq) {
		this.servcSeq = servcSeq;
	}

	public String getPodId() {
		return podId;
	}

	public void setPodId(String podId) {
		this.podId = podId;
	}

	public int getPrvPageNo() {
		return prvPageNo;
	}

	public void setPrvPageNo(int prvPageNo) {
		this.prvPageNo = prvPageNo;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

}
