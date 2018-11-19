/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmResInfoVo.java
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

public class VmResInfoVo extends CommonSearchVo {

	private long total;
	private long linuxCnt;
	private long hpCnt;
	private long aixCnt;
	private long winCnt;
	private long solarisCnt;
	private long etcCnt;
	private long lastAsgnVcorQty;
	private long lastAsgnMemCapa;
	private long lastAsgnStrgCapa;
	/**
	 * @return the total
	 */
	public long getTotal()
	{
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total)
	{
		this.total = total;
	}
	/**
	 * @return the linuxCnt
	 */
	public long getLinuxCnt()
	{
		return linuxCnt;
	}
	/**
	 * @param linuxCnt the linuxCnt to set
	 */
	public void setLinuxCnt(long linuxCnt)
	{
		this.linuxCnt = linuxCnt;
	}
	/**
	 * @return the hpCnt
	 */
	public long getHpCnt()
	{
		return hpCnt;
	}
	/**
	 * @param hpCnt the hpCnt to set
	 */
	public void setHpCnt(long hpCnt)
	{
		this.hpCnt = hpCnt;
	}
	/**
	 * @return the aixCnt
	 */
	public long getAixCnt()
	{
		return aixCnt;
	}
	/**
	 * @param aixCnt the aixCnt to set
	 */
	public void setAixCnt(long aixCnt)
	{
		this.aixCnt = aixCnt;
	}
	/**
	 * @return the winCnt
	 */
	public long getWinCnt()
	{
		return winCnt;
	}
	/**
	 * @param winCnt the winCnt to set
	 */
	public void setWinCnt(long winCnt)
	{
		this.winCnt = winCnt;
	}
	/**
	 * @return the solarisCnt
	 */
	public long getSolarisCnt() {
		return solarisCnt;
	}
	/**
	 * @param solarisCnt the solarisCnt to set
	 */
	public void setSolarisCnt(long solarisCnt) {
		this.solarisCnt = solarisCnt;
	}
	/**
	 * @return the etcCnt
	 */
	public long getEtcCnt()
	{
		return etcCnt;
	}
	/**
	 * @param etcCnt the etcCnt to set
	 */
	public void setEtcCnt(long etcCnt)
	{
		this.etcCnt = etcCnt;
	}
	/**
	 * @return the lastAsgnVcorQty
	 */
	public long getLastAsgnVcorQty()
	{
		return lastAsgnVcorQty;
	}
	/**
	 * @param lastAsgnVcorQty the lastAsgnVcorQty to set
	 */
	public void setLastAsgnVcorQty(long lastAsgnVcorQty)
	{
		this.lastAsgnVcorQty = lastAsgnVcorQty;
	}
	/**
	 * @return the lastAsgnMemCapa
	 */
	public long getLastAsgnMemCapa()
	{
		return lastAsgnMemCapa;
	}
	/**
	 * @param lastAsgnMemCapa the lastAsgnMemCapa to set
	 */
	public void setLastAsgnMemCapa(long lastAsgnMemCapa)
	{
		this.lastAsgnMemCapa = lastAsgnMemCapa;
	}
	/**
	 * @return the lastAsgnStrgCapa
	 */
	public long getLastAsgnStrgCapa()
	{
		return lastAsgnStrgCapa;
	}
	/**
	 * @param lastAsgnStrgCapa the lastAsgnStrgCapa to set
	 */
	public void setLastAsgnStrgCapa(long lastAsgnStrgCapa)
	{
		this.lastAsgnStrgCapa = lastAsgnStrgCapa;
	}

}
