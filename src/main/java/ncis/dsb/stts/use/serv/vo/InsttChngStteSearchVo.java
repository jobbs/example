/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttChngStteSearchVo.java
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
package ncis.dsb.stts.use.serv.vo;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class InsttChngStteSearchVo extends CommonSearchVo {
	   private List<String> region;
	   private String year;
	   private String search;

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
	public String getSearch() {
		return search;
	}
	/**
	 * @param year the year to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}


}
