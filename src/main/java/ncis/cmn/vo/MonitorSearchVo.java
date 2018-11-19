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
package ncis.cmn.vo;


public class MonitorSearchVo extends CommonSearchVo {

	private Long pmSeq;

	private Long vmSeq;
	private String vmCompId;
	private String vmNm;
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

	private String colctCd;
	private String lastDay;


	public Long getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}
	/**
	 * @return the pmSeq
	 */
	public Long getPmSeq()
	{
		return pmSeq;
	}
	/**
	 * @param pmSeq the pmSeq to set
	 */
	public void setPmSeq(Long pmSeq)
	{
		this.pmSeq = pmSeq;
	}
	/**
	 * @return the vmCompId
	 */
	public String getVmCompId()
	{
		return vmCompId;
	}
	/**
	 * @param vmCompId the vmCompId to set
	 */
	public void setVmCompId(String vmCompId)
	{
		this.vmCompId = vmCompId;
	}
	public String getVmNm() {
		return vmNm;
	}
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
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
	public String getColctCd() {
		return colctCd;
	}
	public void setColctCd(String colctCd) {
		this.colctCd = colctCd;
	}
	public String getLastDay() {
		return lastDay;
	}
	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
}
