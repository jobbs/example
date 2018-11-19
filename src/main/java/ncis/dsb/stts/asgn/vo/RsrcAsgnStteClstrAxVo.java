/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteClstrAxVo.java
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
 */

package ncis.dsb.stts.asgn.vo;
import java.math.BigDecimal;

public class RsrcAsgnStteClstrAxVo  {
	private String rsrcPoolNm;
	private BigDecimal nodeQty;
	private BigDecimal cpuCorQty;
	private BigDecimal memTotCapa;

	private BigDecimal strgTotCapa;
	private BigDecimal quotaPodQty;
	private BigDecimal quotaCpuCorQty;
	private BigDecimal quotaMemTotCapa;
	private BigDecimal asgnCpuRt;
	private BigDecimal asgnMemRt;
	private BigDecimal lastPodQty;
	private BigDecimal cpuUseCapa;
	private BigDecimal memUseCapa;
	private BigDecimal nodeUseCpuRt;
	private BigDecimal nodeUseMemRt;
	private BigDecimal quotaUsePodRt;
	private BigDecimal quotaUseCpuRt;
	private BigDecimal quotaUseMemRt;
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
	 * @return the nodeQty
	 */
	public BigDecimal getNodeQty() {
		return nodeQty;
	}
	/**
	 * @param nodeQty the nodeQty to set
	 */
	public void setNodeQty(BigDecimal nodeQty) {
		this.nodeQty = nodeQty;
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
	/**
	 * @return the quotaPodQty
	 */
	public BigDecimal getQuotaPodQty() {
		return quotaPodQty;
	}
	/**
	 * @param quotaPodQty the quotaPodQty to set
	 */
	public void setQuotaPodQty(BigDecimal quotaPodQty) {
		this.quotaPodQty = quotaPodQty;
	}
	/**
	 * @return the quotaCpuCorQty
	 */
	public BigDecimal getQuotaCpuCorQty() {
		return quotaCpuCorQty;
	}
	/**
	 * @param quotaCpuCorQty the quotaCpuCorQty to set
	 */
	public void setQuotaCpuCorQty(BigDecimal quotaCpuCorQty) {
		this.quotaCpuCorQty = quotaCpuCorQty;
	}
	/**
	 * @return the quotaMemTotCapa
	 */
	public BigDecimal getQuotaMemTotCapa() {
		return quotaMemTotCapa;
	}
	/**
	 * @param quotaMemTotCapa the quotaMemTotCapa to set
	 */
	public void setQuotaMemTotCapa(BigDecimal quotaMemTotCapa) {
		this.quotaMemTotCapa = quotaMemTotCapa;
	}
	/**
	 * @return the asgnCpuRt
	 */
	public BigDecimal getAsgnCpuRt() {
		return asgnCpuRt;
	}
	/**
	 * @param asgnCpuRt the asgnCpuRt to set
	 */
	public void setAsgnCpuRt(BigDecimal asgnCpuRt) {
		this.asgnCpuRt = asgnCpuRt;
	}
	/**
	 * @return the asgnMemRt
	 */
	public BigDecimal getAsgnMemRt() {
		return asgnMemRt;
	}
	/**
	 * @param asgnMemRt the asgnMemRt to set
	 */
	public void setAsgnMemRt(BigDecimal asgnMemRt) {
		this.asgnMemRt = asgnMemRt;
	}
	/**
	 * @return the lastPodQty
	 */
	public BigDecimal getLastPodQty() {
		return lastPodQty;
	}
	/**
	 * @param lastPodQty the lastPodQty to set
	 */
	public void setLastPodQty(BigDecimal lastPodQty) {
		this.lastPodQty = lastPodQty;
	}
	/**
	 * @return the cpuUseCapa
	 */
	public BigDecimal getCpuUseCapa() {
		return cpuUseCapa;
	}
	/**
	 * @param cpuUseCapa the cpuUseCapa to set
	 */
	public void setCpuUseCapa(BigDecimal cpuUseCapa) {
		this.cpuUseCapa = cpuUseCapa;
	}
	/**
	 * @return the memUseCapa
	 */
	public BigDecimal getMemUseCapa() {
		return memUseCapa;
	}
	/**
	 * @param memUseCapa the memUseCapa to set
	 */
	public void setMemUseCapa(BigDecimal memUseCapa) {
		this.memUseCapa = memUseCapa;
	}
	/**
	 * @return the nodeUseCpuRt
	 */
	public BigDecimal getNodeUseCpuRt() {
		return nodeUseCpuRt;
	}
	/**
	 * @param nodeUseCpuRt the nodeUseCpuRt to set
	 */
	public void setNodeUseCpuRt(BigDecimal nodeUseCpuRt) {
		this.nodeUseCpuRt = nodeUseCpuRt;
	}
	/**
	 * @return the nodeUseMemRt
	 */
	public BigDecimal getNodeUseMemRt() {
		return nodeUseMemRt;
	}
	/**
	 * @param nodeUseMemRt the nodeUseMemRt to set
	 */
	public void setNodeUseMemRt(BigDecimal nodeUseMemRt) {
		this.nodeUseMemRt = nodeUseMemRt;
	}
	/**
	 * @return the quotaUsePodRt
	 */
	public BigDecimal getQuotaUsePodRt() {
		return quotaUsePodRt;
	}
	/**
	 * @param quotaUsePodRt the quotaUsePodRt to set
	 */
	public void setQuotaUsePodRt(BigDecimal quotaUsePodRt) {
		this.quotaUsePodRt = quotaUsePodRt;
	}
	/**
	 * @return the quotaUseCpuRt
	 */
	public BigDecimal getQuotaUseCpuRt() {
		return quotaUseCpuRt;
	}
	/**
	 * @param quotaUseCpuRt the quotaUseCpuRt to set
	 */
	public void setQuotaUseCpuRt(BigDecimal quotaUseCpuRt) {
		this.quotaUseCpuRt = quotaUseCpuRt;
	}
	/**
	 * @return the quotaUseMemRt
	 */
	public BigDecimal getQuotaUseMemRt() {
		return quotaUseMemRt;
	}
	/**
	 * @param quotaUseMemRt the quotaUseMemRt to set
	 */
	public void setQuotaUseMemRt(BigDecimal quotaUseMemRt) {
		this.quotaUseMemRt = quotaUseMemRt;
	}



}
