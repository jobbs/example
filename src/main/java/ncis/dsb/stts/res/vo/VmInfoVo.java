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

public class VmInfoVo extends CommonSearchVo {

	private String regionNm;
	private String zoneNm;
	private String netNm;
	private String rsrcPoolNm;
	private String clstrNm;
	private String prposNm;
	private BigDecimal pmTotal;
	private BigDecimal lastCpuCorQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	private String hipervisor;
	private BigDecimal vmTotal;
	private BigDecimal win;
	private BigDecimal linux;
	private BigDecimal hp;
	private BigDecimal aix;
	private BigDecimal etc;
	private BigDecimal lastAsgnVcorQty;
	private BigDecimal lastAsgnMemCapa;
	private BigDecimal lastAsgnStrgCapa;
	private BigDecimal cpuVirtRt;
	private BigDecimal memVirtRt;
	private BigDecimal servcCnt;
	private BigDecimal podQty;
	private BigDecimal cpuCorQty;
	private BigDecimal memTotCapa;
	private BigDecimal strgTotCapa;
	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}
	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	/**
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}
	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}
	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	/**
	 * @return the clstrNm
	 */
	public String getClstrNm() {
		return clstrNm;
	}
	/**
	 * @param clstrNm the clstrNm to set
	 */
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
	}
	/**
	 * @return the prposNm
	 */
	public String getPrposNm() {
		return prposNm;
	}
	/**
	 * @param prposNm the prposNm to set
	 */
	public void setPrposNm(String prposNm) {
		this.prposNm = prposNm;
	}
	/**
	 * @return the pmTotal
	 */
	public BigDecimal getPmTotal() {
		return pmTotal;
	}
	/**
	 * @param pmTotal the pmTotal to set
	 */
	public void setPmTotal(BigDecimal pmTotal) {
		this.pmTotal = pmTotal;
	}
	/**
	 * @return the lastCpuCorQty
	 */
	public BigDecimal getLastCpuCorQty() {
		return lastCpuCorQty;
	}
	/**
	 * @param lastCpuCorQty the lastCpuCorQty to set
	 */
	public void setLastCpuCorQty(BigDecimal lastCpuCorQty) {
		this.lastCpuCorQty = lastCpuCorQty;
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
	/**
	 * @return the hipervisor
	 */
	public String getHipervisor() {
		return hipervisor;
	}
	/**
	 * @param hipervisor the hipervisor to set
	 */
	public void setHipervisor(String hipervisor) {
		this.hipervisor = hipervisor;
	}
	/**
	 * @return the vmTotal
	 */
	public BigDecimal getVmTotal() {
		return vmTotal;
	}
	/**
	 * @param vmTotal the vmTotal to set
	 */
	public void setVmTotal(BigDecimal vmTotal) {
		this.vmTotal = vmTotal;
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
	 * @return the linux
	 */
	public BigDecimal getLinux() {
		return linux;
	}
	/**
	 * @param linux the linux to set
	 */
	public void setLinux(BigDecimal linux) {
		this.linux = linux;
	}
	/**
	 * @return the hp
	 */
	public BigDecimal getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}
	/**
	 * @return the aix
	 */
	public BigDecimal getAix() {
		return aix;
	}
	/**
	 * @param aix the aix to set
	 */
	public void setAix(BigDecimal aix) {
		this.aix = aix;
	}
	/**
	 * @return the etc
	 */
	public BigDecimal getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(BigDecimal etc) {
		this.etc = etc;
	}
	/**
	 * @return the lastAsgnVcorQty
	 */
	public BigDecimal getLastAsgnVcorQty() {
		return lastAsgnVcorQty;
	}
	/**
	 * @param lastAsgnVcorQty the lastAsgnVcorQty to set
	 */
	public void setLastAsgnVcorQty(BigDecimal lastAsgnVcorQty) {
		this.lastAsgnVcorQty = lastAsgnVcorQty;
	}
	/**
	 * @return the lastAsgnMemCapa
	 */
	public BigDecimal getLastAsgnMemCapa() {
		return lastAsgnMemCapa;
	}
	/**
	 * @param lastAsgnMemCapa the lastAsgnMemCapa to set
	 */
	public void setLastAsgnMemCapa(BigDecimal lastAsgnMemCapa) {
		this.lastAsgnMemCapa = lastAsgnMemCapa;
	}
	/**
	 * @return the lastAsgnStrgCapa
	 */
	public BigDecimal getLastAsgnStrgCapa() {
		return lastAsgnStrgCapa;
	}
	/**
	 * @param lastAsgnStrgCapa the lastAsgnStrgCapa to set
	 */
	public void setLastAsgnStrgCapa(BigDecimal lastAsgnStrgCapa) {
		this.lastAsgnStrgCapa = lastAsgnStrgCapa;
	}
	/**
	 * @return the cpuVirtRt
	 */
	public BigDecimal getCpuVirtRt() {
		return cpuVirtRt;
	}
	/**
	 * @param cpuVirtRt the cpuVirtRt to set
	 */
	public void setCpuVirtRt(BigDecimal cpuVirtRt) {
		this.cpuVirtRt = cpuVirtRt;
	}
	/**
	 * @return the memVirtRt
	 */
	public BigDecimal getMemVirtRt() {
		return memVirtRt;
	}
	/**
	 * @param memVirtRt the memVirtRt to set
	 */
	public void setMemVirtRt(BigDecimal memVirtRt) {
		this.memVirtRt = memVirtRt;
	}
	/**
	 * @return the servcCnt
	 */
	public BigDecimal getServcCnt() {
		return servcCnt;
	}
	/**
	 * @param servcCnt the servcCnt to set
	 */
	public void setServcCnt(BigDecimal servcCnt) {
		this.servcCnt = servcCnt;
	}
	/**
	 * @return the podQty
	 */
	public BigDecimal getPodQty() {
		return podQty;
	}
	/**
	 * @param podQty the podQty to set
	 */
	public void setPodQty(BigDecimal podQty) {
		this.podQty = podQty;
	}
	/**
	 * @return the cpuCorQty
	 */
	public BigDecimal getCpuCorQty() {
		return cpuCorQty;
	}
	/**
	 * @param cpuCorQty the cpuCorQty to set
	 */
	public void setCpuCorQty(BigDecimal cpuCorQty) {
		this.cpuCorQty = cpuCorQty;
	}
	/**
	 * @return the memTotCapa
	 */
	public BigDecimal getMemTotCapa() {
		return memTotCapa;
	}
	/**
	 * @param memTotCapa the memTotCapa to set
	 */
	public void setMemTotCapa(BigDecimal memTotCapa) {
		this.memTotCapa = memTotCapa;
	}
	/**
	 * @return the strgTotCapa
	 */
	public BigDecimal getStrgTotCapa() {
		return strgTotCapa;
	}
	/**
	 * @param strgTotCapa the strgTotCapa to set
	 */
	public void setStrgTotCapa(BigDecimal strgTotCapa) {
		this.strgTotCapa = strgTotCapa;
	}




}
