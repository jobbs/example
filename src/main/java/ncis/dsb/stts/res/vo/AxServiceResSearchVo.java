/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import java.util.List;
import java.util.Map;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class AxServiceResSearchVo extends CommonSearchVo {

	private String regionId;
	private String zoneId;
	private String netId;
	private String rsrcPoolId;
	private String servcSeq;
	private String servcNm;

	private String searchTrmCd;
	//검색시작일자
	private String strtDt;
	//검색종료일자
	private String endDt;
	private String year;
	//분기코드
	private String quarterCd;
	//반기코드
	private String halfCd;
	private String searchMmCd;
	private String searchQqCd;
	private String searchHhCd;
	private String date;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;
	private String colctCd;
	private String column;
	private String lastDay;
	private List<Map<String,String>> podList;


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
	public String getServcSeq() {
		return servcSeq;
	}
	public void setServcSeq(String servcSeq) {
		this.servcSeq = servcSeq;
	}

	public String getServcNm() {
		return servcNm;
	}
	public void setServcNm(String servcNm) {
		this.servcNm = servcNm;
	}

	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	public String getSearchTrmCd() {
		return searchTrmCd;
	}
	public void setSearchTrmCd(String searchTrmCd) {
		this.searchTrmCd = searchTrmCd;
	}
	public String getStrtDt() {
		return strtDt;
	}
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuarterCd() {
		return quarterCd;
	}
	public void setQuarterCd(String quarterCd) {
		this.quarterCd = quarterCd;
	}
	public String getHalfCd() {
		return halfCd;
	}
	public void setHalfCd(String halfCd) {
		this.halfCd = halfCd;
	}
	public String getSearchMmCd() {
		return searchMmCd;
	}
	public void setSearchMmCd(String searchMmCd) {
		this.searchMmCd = searchMmCd;
	}
	public String getSearchQqCd() {
		return searchQqCd;
	}
	public void setSearchQqCd(String searchQqCd) {
		this.searchQqCd = searchQqCd;
	}
	public String getSearchHhCd() {
		return searchHhCd;
	}
	public void setSearchHhCd(String searchHhCd) {
		this.searchHhCd = searchHhCd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}

	public String getColctCd() {
		return colctCd;
	}
	public void setColctCd(String colctCd) {
		this.colctCd = colctCd;
	}
	public List<Map<String,String>> getPodList() {
		return podList;
	}
	public void setPodList(List<Map<String,String>> podList) {
		this.podList = podList;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getLastDay() {
		return lastDay;
	}
	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}

}
