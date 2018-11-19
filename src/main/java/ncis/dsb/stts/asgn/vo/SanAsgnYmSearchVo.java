/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanAsgnYmSearchVo.java
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


package ncis.dsb.stts.asgn.vo;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class SanAsgnYmSearchVo extends CommonSearchVo {
	   private List<String> region;
	   private String trm;
	   private String year;
	   private String mm;
	   private String search;
	   private String rsrcPoolId;
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
	 * @return the mm
	 */
	public String getTrm() {
		return trm;
	}
	/**
	 * @param mm the mm to set
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
	 * @return the year
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param year the year to set
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
	 * @return the search
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param search the search to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}


}
