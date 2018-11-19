/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmInfoVo.java
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

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

public class GovDeptResInfoVo extends CommonSearchVo {

	private BigDecimal institutionCnt;
	private BigDecimal jobCnt;
	private BigDecimal vmCnt;
	private BigDecimal linuxCnt;
	private BigDecimal hpCnt;
	private BigDecimal aixCnt;
	private BigDecimal winCnt;
	private BigDecimal solarisCnt;
	private BigDecimal etcCnt;
	private BigDecimal lastVcoreQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	/**
	 * @return the institutionCnt
	 */
	public BigDecimal getInstitutionCnt()
	{
		return institutionCnt;
	}
	/**
	 * @param institutionCnt the institutionCnt to set
	 */
	public void setInstitutionCnt(BigDecimal institutionCnt)
	{
		this.institutionCnt = institutionCnt;
	}
	/**
	 * @return the jobCnt
	 */
	public BigDecimal getJobCnt()
	{
		return jobCnt;
	}
	/**
	 * @param jobCnt the jobCnt to set
	 */
	public void setJobCnt(BigDecimal jobCnt)
	{
		this.jobCnt = jobCnt;
	}
	/**
	 * @return the vmCnt
	 */
	public BigDecimal getVmCnt()
	{
		return vmCnt;
	}
	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(BigDecimal vmCnt)
	{
		this.vmCnt = vmCnt;
	}
	/**
	 * @return the linuxCnt
	 */
	public BigDecimal getLinuxCnt()
	{
		return linuxCnt;
	}
	/**
	 * @param linuxCnt the linuxCnt to set
	 */
	public void setLinuxCnt(BigDecimal linuxCnt)
	{
		this.linuxCnt = linuxCnt;
	}
	/**
	 * @return the hpCnt
	 */
	public BigDecimal getHpCnt()
	{
		return hpCnt;
	}
	/**
	 * @param hpCnt the hpCnt to set
	 */
	public void setHpCnt(BigDecimal hpCnt)
	{
		this.hpCnt = hpCnt;
	}
	/**
	 * @return the aixCnt
	 */
	public BigDecimal getAixCnt()
	{
		return aixCnt;
	}
	/**
	 * @param aixCnt the aixCnt to set
	 */
	public void setAixCnt(BigDecimal aixCnt)
	{
		this.aixCnt = aixCnt;
	}
	/**
	 * @return the winCnt
	 */
	public BigDecimal getWinCnt()
	{
		return winCnt;
	}
	/**
	 * @param winCnt the winCnt to set
	 */
	public void setWinCnt(BigDecimal winCnt)
	{
		this.winCnt = winCnt;
	}	
	/**
	 * @return the solarisCnt
	 */
	public BigDecimal getSolarisCnt() {
		return solarisCnt;
	}
	/**
	 * @param solarisCnt the solarisCnt to set
	 */
	public void setSolarisCnt(BigDecimal solarisCnt) {
		this.solarisCnt = solarisCnt;
	}
	/**
	 * @return the etcCnt
	 */
	public BigDecimal getEtcCnt()
	{
		return etcCnt;
	}
	/**
	 * @param etcCnt the etcCnt to set
	 */
	public void setEtcCnt(BigDecimal etcCnt)
	{
		this.etcCnt = etcCnt;
	}
	/**
	 * @return the lastVcoreQty
	 */
	public BigDecimal getLastVcoreQty()
	{
		return lastVcoreQty;
	}
	/**
	 * @param lastVcoreQty the lastVcoreQty to set
	 */
	public void setLastVcoreQty(BigDecimal lastVcoreQty)
	{
		this.lastVcoreQty = lastVcoreQty;
	}
	/**
	 * @return the lastMemSumCapa
	 */
	public BigDecimal getLastMemSumCapa()
	{
		return lastMemSumCapa;
	}
	/**
	 * @param lastMemSumCapa the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(BigDecimal lastMemSumCapa)
	{
		this.lastMemSumCapa = lastMemSumCapa;
	}
	/**
	 * @return the lastStrgSumCapa
	 */
	public BigDecimal getLastStrgSumCapa()
	{
		return lastStrgSumCapa;
	}
	/**
	 * @param lastStrgSumCapa the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(BigDecimal lastStrgSumCapa)
	{
		this.lastStrgSumCapa = lastStrgSumCapa;
	}

}
