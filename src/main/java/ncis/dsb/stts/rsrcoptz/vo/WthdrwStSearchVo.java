/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStSearchVo.java
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

package ncis.dsb.stts.rsrcoptz.vo;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class WthdrwStSearchVo extends CommonSearchVo {
	private List<String> region;
	private String year;
	private String quarter;
	private String search;
	private String rsrcPoolId;
	private String cmd;

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
	public String getQuarter() {
		return quarter;
	}
	/**
	 * @param year the year to set
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
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
	/**
	 * @return the cmd
	 */
	public String getCmd() {
		return cmd;
	}
	/**
	 * @param search the search to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

}
