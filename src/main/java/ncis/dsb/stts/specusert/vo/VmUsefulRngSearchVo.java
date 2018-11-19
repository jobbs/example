/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmUsefulRngSearchVo.java
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
package ncis.dsb.stts.specusert.vo;

import ncis.cmn.vo.CommonSearchVo;
import java.util.List;


public class VmUsefulRngSearchVo extends CommonSearchVo {
	private List<String> region;
	private String year;
	private String mm;
	private String search;
	private String userData;

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

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMm() {
		return mm;
	}
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
	public String getUserData() {
		return userData;
	}
	/**
	 * @param search the search to set
	 */
	public void setUserData(String userData) {
		this.search = userData;
	}
}
