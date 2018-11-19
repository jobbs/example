/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmCntVo.java
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

import ncis.cmn.vo.CommonSearchVo;

public class PmCntVo extends CommonSearchVo {

	private long total;
	private long db;
	private long web;
	private long was;
	private long windows;
	private long test;
	private long etc;
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the db
	 */
	public long getDb() {
		return db;
	}
	/**
	 * @param db the db to set
	 */
	public void setDb(long db) {
		this.db = db;
	}
	/**
	 * @return the web
	 */
	public long getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(long web) {
		this.web = web;
	}
	/**
	 * @return the was
	 */
	public long getWas() {
		return was;
	}
	/**
	 * @param was the was to set
	 */
	public void setWas(long was) {
		this.was = was;
	}
	/**
	 * @return the windows
	 */
	public long getWindows() {
		return windows;
	}
	/**
	 * @param windows the windows to set
	 */
	public void setWindows(long windows) {
		this.windows = windows;
	}
	/**
	 * @return the test
	 */
	public long getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(long test) {
		this.test = test;
	}
	/**
	 * @return the etc
	 */
	public long getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(long etc) {
		this.etc = etc;
	}



}
