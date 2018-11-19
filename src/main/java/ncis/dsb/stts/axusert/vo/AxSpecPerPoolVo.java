/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxSpecPerPoolVo.java
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
package ncis.dsb.stts.axusert.vo;
import java.math.BigDecimal;

public class AxSpecPerPoolVo{
	private long no;
	private String rsrcPoolId;
	private String rsrcPoolNm;
	private BigDecimal minCpuCorQty;
	private BigDecimal avgCpuCorQty;
	private BigDecimal maxCpuCorQty;
	private BigDecimal minMemTotCapa;
	private BigDecimal avgMemTotCapa;
	private BigDecimal maxMemTotCapa;
	private BigDecimal minStrgTotCapa;
	private BigDecimal avgStrgTotCapa;
	private BigDecimal maxStrgTotCapa;
	/**
	 * @return the no
	 */
	public long getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(long no) {
		this.no = no;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
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
	 * @return the minCpuCorQty
	 */
	public BigDecimal getMinCpuCorQty() {
		return minCpuCorQty;
	}
	/**
	 * @param minCpuCorQty the minCpuCorQty to set
	 */
	public void setMinCpuCorQty(BigDecimal minCpuCorQty) {
		this.minCpuCorQty = minCpuCorQty;
	}
	/**
	 * @return the avgCpuCorQty
	 */
	public BigDecimal getAvgCpuCorQty() {
		return avgCpuCorQty;
	}
	/**
	 * @param avgCpuCorQty the avgCpuCorQty to set
	 */
	public void setAvgCpuCorQty(BigDecimal avgCpuCorQty) {
		this.avgCpuCorQty = avgCpuCorQty;
	}
	/**
	 * @return the maxCpuCorQty
	 */
	public BigDecimal getMaxCpuCorQty() {
		return maxCpuCorQty;
	}
	/**
	 * @param maxCpuCorQty the maxCpuCorQty to set
	 */
	public void setMaxCpuCorQty(BigDecimal maxCpuCorQty) {
		this.maxCpuCorQty = maxCpuCorQty;
	}
	/**
	 * @return the minMemTotCapa
	 */
	public BigDecimal getMinMemTotCapa() {
		return minMemTotCapa;
	}
	/**
	 * @param minMemTotCapa the minMemTotCapa to set
	 */
	public void setMinMemTotCapa(BigDecimal minMemTotCapa) {
		this.minMemTotCapa = minMemTotCapa;
	}
	/**
	 * @return the avgMemTotCapa
	 */
	public BigDecimal getAvgMemTotCapa() {
		return avgMemTotCapa;
	}
	/**
	 * @param avgMemTotCapa the avgMemTotCapa to set
	 */
	public void setAvgMemTotCapa(BigDecimal avgMemTotCapa) {
		this.avgMemTotCapa = avgMemTotCapa;
	}
	/**
	 * @return the maxMemTotCapa
	 */
	public BigDecimal getMaxMemTotCapa() {
		return maxMemTotCapa;
	}
	/**
	 * @param maxMemTotCapa the maxMemTotCapa to set
	 */
	public void setMaxMemTotCapa(BigDecimal maxMemTotCapa) {
		this.maxMemTotCapa = maxMemTotCapa;
	}
	/**
	 * @return the minStrgTotCapa
	 */
	public BigDecimal getMinStrgTotCapa() {
		return minStrgTotCapa;
	}
	/**
	 * @param minStrgTotCapa the minStrgTotCapa to set
	 */
	public void setMinStrgTotCapa(BigDecimal minStrgTotCapa) {
		this.minStrgTotCapa = minStrgTotCapa;
	}
	/**
	 * @return the avgStrgTotCapa
	 */
	public BigDecimal getAvgStrgTotCapa() {
		return avgStrgTotCapa;
	}
	/**
	 * @param avgStrgTotCapa the avgStrgTotCapa to set
	 */
	public void setAvgStrgTotCapa(BigDecimal avgStrgTotCapa) {
		this.avgStrgTotCapa = avgStrgTotCapa;
	}
	/**
	 * @return the maxStrgTotCapa
	 */
	public BigDecimal getMaxStrgTotCapa() {
		return maxStrgTotCapa;
	}
	/**
	 * @param maxStrgTotCapa the maxStrgTotCapa to set
	 */
	public void setMaxStrgTotCapa(BigDecimal maxStrgTotCapa) {
		this.maxStrgTotCapa = maxStrgTotCapa;
	}



}
