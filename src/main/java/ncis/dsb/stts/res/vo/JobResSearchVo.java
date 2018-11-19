/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResSearchVo.java
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
 *
 */
package ncis.dsb.stts.res.vo;

import java.util.List;
import java.util.Map;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class JobResSearchVo extends CommonSearchVo {

	private List<String> institutionId;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	private String institutionNm;

	private String jobId;
	private Long servcSeq;
	private String podId;
	private Long vmSeq;
	private String vmNm;
	private String jobNm;
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
	private List<Map<String,String>> vmList;
	private List<Map<String,String>> podList;
	
	// 2017.11.15 업무자원현황(온나라)전용
	private List<String> vmListNm; // 가상서버명 목록
	private List<String> vmListId; // 가상서버Seq 목록
	private String weeklyDatePicker; // 날짜(?)
	private String searchTime; // 시간간격
	private String searchType; // 전체, CPU, Memory
	private List<Long> vmSeqList;
	private List<Long> axSeqList;
	
	/**
	 * @return the vmSeqList
	 */
	public List<Long> getVmSeqList() {
		return vmSeqList;
	}
	/**
	 * @param vmSeqList the vmSeqList to set
	 */
	public void setVmSeqList(List<Long> vmSeqList) {
		this.vmSeqList = vmSeqList;
	}
	/**
	 * @return the axSeqList
	 */
	public List<Long> getAxSeqList() {
		return axSeqList;
	}
	/**
	 * @param axSeqList the axSeqList to set
	 */
	public void setAxSeqList(List<Long> axSeqList) {
		this.axSeqList = axSeqList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobResSearchVo [institutionId=" + institutionId
				+ ", institutionNm=" + institutionNm + ", jobId=" + jobId
				+ ", servcSeq=" + servcSeq + ", vmSeq=" + vmSeq + ", vmNm="
				+ vmNm + ", jobNm=" + jobNm + ", servcNm=" + servcNm
				+ ", searchTrmCd=" + searchTrmCd + ", strtDt=" + strtDt
				+ ", endDt=" + endDt + ", year=" + year + ", quarterCd="
				+ quarterCd + ", halfCd=" + halfCd + ", searchMmCd="
				+ searchMmCd + ", searchQqCd=" + searchQqCd + ", searchHhCd="
				+ searchHhCd + ", date=" + date + ", allRsrcPoolAuth="
				+ allRsrcPoolAuth + ", colctCd=" + colctCd + ", column="
				+ column + ", lastDay=" + lastDay + ", vmList=" + vmList
				+ ", podList=" + podList + ", vmListNm=" + vmListNm
				+ ", vmListId=" + vmListId + ", weeklyDatePicker="
				+ weeklyDatePicker + ", searchTime=" + searchTime
				+ ", searchType=" + searchType + "]";
	}
	/**
	 * @return the vmListNm
	 */
	public List<String> getVmListNm() {
		return vmListNm;
	}
	/**
	 * @param vmListNm the vmListNm to set
	 */
	public void setVmListNm(List<String> vmListNm) {
		this.vmListNm = vmListNm;
	}
	/**
	 * @return the vmListId
	 */
	public List<String> getVmListId() {
		return vmListId;
	}
	/**
	 * @param vmListId the vmListId to set
	 */
	public void setVmListId(List<String> vmListId) {
		this.vmListId = vmListId;
	}
	/**
	 * @return the weeklyDatePicker
	 */
	public String getWeeklyDatePicker() {
		return weeklyDatePicker;
	}
	/**
	 * @param weeklyDatePicker the weeklyDatePicker to set
	 */
	public void setWeeklyDatePicker(String weeklyDatePicker) {
		this.weeklyDatePicker = weeklyDatePicker;
	}
	/**
	 * @return the searchTime
	 */
	public String getSearchTime() {
		return searchTime;
	}
	/**
	 * @param searchTime the searchTime to set
	 */
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public List<String> getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(List<String> institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Long getServcSeq() {
		return servcSeq;
	}
	public void setServcSeq(Long servcSeq) {
		this.servcSeq = servcSeq;
	}
	public String getPodId() {
		return podId;
	}
	public void setPodId(String podId) {
		this.podId = podId;
	}
	public Long getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}
	public String getVmNm() {
		return vmNm;
	}
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	public String getServcNm() {
		return servcNm;
	}
	public void setServcNm(String servcNm) {
		this.servcNm = servcNm;
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
	public List<Map<String,String>> getVmList() {
		return vmList;
	}
	public void setVmList(List<Map<String,String>> vmList) {
		this.vmList = vmList;
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
