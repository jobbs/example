/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteClstrSearchVo.java
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
 */

package ncis.dsb.stts.asgn.vo;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class RsrcAsgnStteClstrSearchVo extends CommonSearchVo {
	private List<String> region;
	   private String mm;
	   private String year;
	   private String search;
	   private String dtlGubun;
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
	 * @return the dtl_gubun
	 */
	public String getDtlGubun() {
		return dtlGubun;
	}
	/**
	 * @param dtl_gubun the dtl_gubun to set
	 */
	public void setDtlGubun(String dtlGubun) {
		this.dtlGubun = dtlGubun;
	}


}

