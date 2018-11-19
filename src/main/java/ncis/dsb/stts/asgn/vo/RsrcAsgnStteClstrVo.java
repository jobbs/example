/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteClstrVo.java
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
 */

package ncis.dsb.stts.asgn.vo;
import java.math.BigDecimal;

public class RsrcAsgnStteClstrVo  {
	private String mm;
	private String mmQ;
	private String rsrcPoolNm;
	private BigDecimal clstrSeq;
	private String clstrNm;
	private BigDecimal pmSeq;

	private BigDecimal lastCpuCorQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	private BigDecimal lastVSrvrQty;
	private BigDecimal lastAsgnVcorQty;
	private BigDecimal lastAsgnMemCapa;
	private BigDecimal vmLastAsgnStrgCapa;
	private BigDecimal vrlzRt;
	private BigDecimal vcoreRt;
	private BigDecimal memRt;
	private BigDecimal sanRt;
	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
	}
	/**
	 * @return the mmQ
	 */
	public String getMmQ() {
		return mmQ;
	}
	/**
	 * @param mmQ the mmQ to set
	 */
	public void setMmQ(String mmQ) {
		this.mmQ = mmQ;
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
	 * @return the clstrSeq
	 */
	public BigDecimal getClstrSeq() {
		return clstrSeq;
	}
	/**
	 * @param clstrSeq the clstrSeq to set
	 */
	public void setClstrSeq(BigDecimal clstrSeq) {
		this.clstrSeq = clstrSeq;
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
	 * @return the pmSeq
	 */
	public BigDecimal getPmSeq() {
		return pmSeq;
	}
	/**
	 * @param pmSeq the pmSeq to set
	 */
	public void setPmSeq(BigDecimal pmSeq) {
		this.pmSeq = pmSeq;
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
	 * @return the lastVSrvrQty
	 */
	public BigDecimal getLastVSrvrQty() {
		return lastVSrvrQty;
	}
	/**
	 * @param lastVSrvrQty the lastVSrvrQty to set
	 */
	public void setLastVSrvrQty(BigDecimal lastVSrvrQty) {
		this.lastVSrvrQty = lastVSrvrQty;
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
	 * @return the vmLastAsgnStrgCapa
	 */
	public BigDecimal getVmLastAsgnStrgCapa() {
		return vmLastAsgnStrgCapa;
	}
	/**
	 * @param vmLastAsgnStrgCapa the vmLastAsgnStrgCapa to set
	 */
	public void setVmLastAsgnStrgCapa(BigDecimal vmLastAsgnStrgCapa) {
		this.vmLastAsgnStrgCapa = vmLastAsgnStrgCapa;
	}
	/**
	 * @return the vrlzRt
	 */
	public BigDecimal getVrlzRt() {
		return vrlzRt;
	}
	/**
	 * @param vrlzRt the vrlzRt to set
	 */
	public void setVrlzRt(BigDecimal vrlzRt) {
		this.vrlzRt = vrlzRt;
	}
	/**
	 * @return the vcoreRt
	 */
	public BigDecimal getVcoreRt() {
		return vcoreRt;
	}
	/**
	 * @param vcoreRt the vcoreRt to set
	 */
	public void setVcoreRt(BigDecimal vcoreRt) {
		this.vcoreRt = vcoreRt;
	}
	/**
	 * @return the memRt
	 */
	public BigDecimal getMemRt() {
		return memRt;
	}
	/**
	 * @param memRt the memRt to set
	 */
	public void setMemRt(BigDecimal memRt) {
		this.memRt = memRt;
	}
	/**
	 * @return the sanRt
	 */
	public BigDecimal getSanRt() {
		return sanRt;
	}
	/**
	 * @param sanRt the sanRt to set
	 */
	public void setSanRt(BigDecimal sanRt) {
		this.sanRt = sanRt;
	}


}
