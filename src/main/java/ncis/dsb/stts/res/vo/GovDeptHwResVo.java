/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptHwResVo.java
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

public class GovDeptHwResVo extends CommonSearchVo {

	private BigDecimal lastVcoreQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	/**
	 * @return the lastVcoreQty
	 */
	public BigDecimal getLastVcoreQty() {
		return lastVcoreQty;
	}
	/**
	 * @param lastVcoreQty the lastVcoreQty to set
	 */
	public void setLastVcoreQty(BigDecimal lastVcoreQty) {
		this.lastVcoreQty = lastVcoreQty;
	}
	/**
	 * @return the lastMemSumCapa
	 */
	public BigDecimal getLastMemSumCapa() {
		return lastMemSumCapa;
	}
	/**
	 * @param lastMemSumCapa the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(BigDecimal lastMemSumCapa) {
		this.lastMemSumCapa = lastMemSumCapa;
	}
	/**
	 * @return the lastStrgSumCapa
	 */
	public BigDecimal getLastStrgSumCapa() {
		return lastStrgSumCapa;
	}
	/**
	 * @param lastStrgSumCapa the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(BigDecimal lastStrgSumCapa) {
		this.lastStrgSumCapa = lastStrgSumCapa;
	}



}
