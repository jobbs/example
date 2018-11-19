/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CloudJobVo.java
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
package ncis.dsb.stts.servstte.vo;
import java.math.BigDecimal;


public class CloudJobVo{
	private String stdrYr;
	private BigDecimal cnt;
	private BigDecimal goalJobQty;
	private BigDecimal rsltJobQty;
	/**
	 * @return the stdrYr
	 */
	public String getStdrYr() {
		return stdrYr;
	}
	/**
	 * @param stdrYr the stdrYr to set
	 */
	public void setStdrYr(String stdrYr) {
		this.stdrYr = stdrYr;
	}
	/**
	 * @return the cnt
	 */
	public BigDecimal getCnt() {
		return cnt;
	}
	/**
	 * @param cnt the cnt to set
	 */
	public void setCnt(BigDecimal cnt) {
		this.cnt = cnt;
	}
	/**
	 * @return the goalJobQty
	 */
	public BigDecimal getGoalJobQty() {
		return goalJobQty;
	}
	/**
	 * @param goalJobQty the goalJobQty to set
	 */
	public void setGoalJobQty(BigDecimal goalJobQty) {
		this.goalJobQty = goalJobQty;
	}
	/**
	 * @return the rsltJobQty
	 */
	public BigDecimal getRsltJobQty() {
		return rsltJobQty;
	}
	/**
	 * @param rsltJobQty the rsltJobQty to set
	 */
	public void setRsltJobQty(BigDecimal rsltJobQty) {
		this.rsltJobQty = rsltJobQty;
	}


}
