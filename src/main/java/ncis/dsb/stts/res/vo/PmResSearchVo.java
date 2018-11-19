/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import java.util.List;
import java.util.Map;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class PmResSearchVo extends CommonSearchVo {



	private String regionId;
	private String zoneId;
	private String netId;
	private String rsrcPoolId;
	//내용
	private String pmNm;
	private String clstrNm;
	//검색기간
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
	private Long pmSeq;
	private Long clstrSeq;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;
	private String colctCd;
	private String column;
	private List<Map<String,String>> vmList;

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
	public String getPmNm() {
		return pmNm;
	}
	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
	}
	public String getClstrNm() {
		return clstrNm;
	}
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
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
	public Long getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(Long pmSeq) {
		this.pmSeq = pmSeq;
	}
	public Long getClstrSeq() {
		return clstrSeq;
	}
	public void setClstrSeq(Long clstrSeq) {
		this.clstrSeq = clstrSeq;
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
	public List<Map<String,String>> getVmList() {
		return vmList;
	}
	public void setVmList(List<Map<String,String>> vmList) {
		this.vmList = vmList;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}

}
