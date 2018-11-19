/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.asgnUseful.vo;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class UsefulSearchVo extends CommonSearchVo {
	   private List<String> region;
	   private String trm;
	   private String year;
	   private String mm;
	   private String search;
	   private String now;
	   private String rsrcPoolId;
	   private String clstrUuid;
	/**
	 * @return the region
	 */
	public List<String> getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(List<String> region) {
		this.region = region;
	}
	/**
	 * @return the trm
	 */
	public String getTrm() {
		return trm;
	}
	/**
	 * @param trm the trm to set
	 */
	public void setTrm(String trm) {
		this.trm = trm;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
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
	/**
	 * @return the now
	 */
	public String getNow() {
		return now;
	}
	/**
	 * @param now the now to set
	 */
	public void setNow(String now) {
		this.now = now;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the clstrUuid
	 */
	public String getClstrUuid() {
		return clstrUuid;
	}
	/**
	 * @param clstrUuid the clstrUuid to set
	 */
	public void setClstrUuid(String clstrUuid) {
		this.clstrUuid = clstrUuid;
	}



}
