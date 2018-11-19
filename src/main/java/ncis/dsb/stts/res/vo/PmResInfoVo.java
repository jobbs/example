/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmResInfoVo.java
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

/**
 * @author 이현일
 *
 */
public class PmResInfoVo extends CommonSearchVo {

	private long clCnt;
	private long pmCnt;
	private long rhevCnt;
	private long vmwareCnt;
	private long ibmCnt;
	private long hpCnt;
	private long openstackCnt;
	private long dockerCnt;
	private long ovmCnt;
	private long lastCpuCorQty;
	private long lastMemSumCapa;
	private long lastStrgSumCapa;

	/**
	 * @return the clCnt
	 */
	public long getClCnt()
	{
		return clCnt;
	}
	/**
	 * @param clCnt the clCnt to set
	 */
	public void setClCnt(long clCnt)
	{
		this.clCnt = clCnt;
	}
	/**
	 * @return the pmCnt
	 */
	public long getPmCnt()
	{
		return pmCnt;
	}
	/**
	 * @param pmCnt the pmCnt to set
	 */
	public void setPmCnt(long pmCnt)
	{
		this.pmCnt = pmCnt;
	}
	/**
	 * @return the rhevCnt
	 */
	public long getRhevCnt()
	{
		return rhevCnt;
	}
	/**
	 * @param rhevCnt the rhevCnt to set
	 */
	public void setRhevCnt(long rhevCnt)
	{
		this.rhevCnt = rhevCnt;
	}
	/**
	 * @return the vmwareCnt
	 */
	public long getVmwareCnt()
	{
		return vmwareCnt;
	}
	/**
	 * @param vmwareCnt the vmwareCnt to set
	 */
	public void setVmwareCnt(long vmwareCnt)
	{
		this.vmwareCnt = vmwareCnt;
	}
	/**
	 * @return the ibmCnt
	 */
	public long getIbmCnt()
	{
		return ibmCnt;
	}
	/**
	 * @param ibmCnt the ibmCnt to set
	 */
	public void setIbmCnt(long ibmCnt)
	{
		this.ibmCnt = ibmCnt;
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
	 * @return the openstackCnt
	 */
	public long getOpenstackCnt()
	{
		return openstackCnt;
	}
	/**
	 * @param openstackCnt the openstackCnt to set
	 */
	public void setOpenstackCnt(long openstackCnt)
	{
		this.openstackCnt = openstackCnt;
	}
	/**
	 * @return the dockerCnt
	 */
	public long getDockerCnt()
	{
		return dockerCnt;
	}
	/**
	 * @param dockerCnt the dockerCnt to set
	 */
	public void setDockerCnt(long dockerCnt)
	{
		this.dockerCnt = dockerCnt;
	}
	/**
	 * @return the ovmCnt
	 */
	public long getOvmCnt() {
		return ovmCnt;
	}
	/**
	 * @param ovmCnt the ovmCnt to set
	 */
	public void setOvmCnt(long ovmCnt) {
		this.ovmCnt = ovmCnt;
	}
	/**
	 * @return the lastCpuCorQty
	 */
	public long getLastCpuCorQty()
	{
		return lastCpuCorQty;
	}
	/**
	 * @param lastCpuCorQty the lastCpuCorQty to set
	 */
	public void setLastCpuCorQty(long lastCpuCorQty)
	{
		this.lastCpuCorQty = lastCpuCorQty;
	}
	/**
	 * @return the lastMemSumCapa
	 */
	public long getLastMemSumCapa()
	{
		return lastMemSumCapa;
	}
	/**
	 * @param lastMemSumCapa the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(long lastMemSumCapa)
	{
		this.lastMemSumCapa = lastMemSumCapa;
	}
	/**
	 * @return the lastStrgSumCapa
	 */
	public long getLastStrgSumCapa()
	{
		return lastStrgSumCapa;
	}
	/**
	 * @param lastStrgSumCapa the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(long lastStrgSumCapa)
	{
		this.lastStrgSumCapa = lastStrgSumCapa;
	}

}
