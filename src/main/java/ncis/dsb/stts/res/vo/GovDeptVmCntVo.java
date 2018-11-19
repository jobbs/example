/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptVmCntVo.java
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
import java.math.BigDecimal;

public class GovDeptVmCntVo extends CommonSearchVo {

	private BigDecimal total;
	private BigDecimal web;
	private BigDecimal was;
	private BigDecimal db;
	private BigDecimal win;
	private BigDecimal test;
	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	/**
	 * @return the web
	 */
	public BigDecimal getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(BigDecimal web) {
		this.web = web;
	}
	/**
	 * @return the was
	 */
	public BigDecimal getWas() {
		return was;
	}
	/**
	 * @param was the was to set
	 */
	public void setWas(BigDecimal was) {
		this.was = was;
	}
	/**
	 * @return the db
	 */
	public BigDecimal getDb() {
		return db;
	}
	/**
	 * @param db the db to set
	 */
	public void setDb(BigDecimal db) {
		this.db = db;
	}
	/**
	 * @return the win
	 */
	public BigDecimal getWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public void setWin(BigDecimal win) {
		this.win = win;
	}
	/**
	 * @return the test
	 */
	public BigDecimal getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(BigDecimal test) {
		this.test = test;
	}


}
