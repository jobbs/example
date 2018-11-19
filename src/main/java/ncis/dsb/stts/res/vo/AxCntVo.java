/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxCntVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

public class AxCntVo extends CommonSearchVo {

	private long servcCnt;
	private long podQty;
	private BigDecimal cpuCorQty;
	private BigDecimal memTotCapa;
	private BigDecimal strgTotCapa;
	/**
	 * @return the servcCnt
	 */
	public long getServcCnt() {
		return servcCnt;
	}
	/**
	 * @param servcCnt the servcCnt to set
	 */
	public void setServcCnt(long servcCnt) {
		this.servcCnt = servcCnt;
	}
	/**
	 * @return the podQty
	 */
	public long getPodQty() {
		return podQty;
	}
	/**
	 * @param podQty the podQty to set
	 */
	public void setPodQty(long podQty) {
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
