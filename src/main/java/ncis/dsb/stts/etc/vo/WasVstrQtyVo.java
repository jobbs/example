/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasVstrQtyVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.vo;

import java.math.BigDecimal;


public class WasVstrQtyVo{
	private String checkDatetime;
	private BigDecimal avgCncrtUsertQty;
	private BigDecimal minCncrtUsertQty;
	private BigDecimal maxCncrtUsertQty;
	private BigDecimal avgDailyVstrQty;
	private BigDecimal minDailyVstrQty;
	private BigDecimal maxDailyVstrQty;
	private String objName;
	private int cnt;

	public String getCheckDatetime() {
		return checkDatetime;
	}
	public void setCheckDatetime(String checkDatetime) {
		this.checkDatetime = checkDatetime;
	}
	public BigDecimal getAvgCncrtUsertQty() {
		return avgCncrtUsertQty;
	}
	public void setAvgCncrtUsertQty(BigDecimal avgCncrtUsertQty) {
		this.avgCncrtUsertQty = avgCncrtUsertQty;
	}
	public BigDecimal getMinCncrtUsertQty() {
		return minCncrtUsertQty;
	}
	public void setMinCncrtUsertQty(BigDecimal minCncrtUsertQty) {
		this.minCncrtUsertQty = minCncrtUsertQty;
	}
	public BigDecimal getMaxCncrtUsertQty() {
		return maxCncrtUsertQty;
	}
	public void setMaxCncrtUsertQty(BigDecimal maxCncrtUsertQty) {
		this.maxCncrtUsertQty = maxCncrtUsertQty;
	}
	public BigDecimal getAvgDailyVstrQty() {
		return avgDailyVstrQty;
	}
	public void setAvgDailyVstrQty(BigDecimal avgDailyVstrQty) {
		this.avgDailyVstrQty = avgDailyVstrQty;
	}
	public BigDecimal getMinDailyVstrQty() {
		return minDailyVstrQty;
	}
	public void setMinDailyVstrQty(BigDecimal minDailyVstrQty) {
		this.minDailyVstrQty = minDailyVstrQty;
	}
	public BigDecimal getMaxDailyVstrQty() {
		return maxDailyVstrQty;
	}
	public void setMaxDailyVstrQty(BigDecimal maxDailyVstrQty) {
		this.maxDailyVstrQty = maxDailyVstrQty;
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
