/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteClstrVo.java
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

package ncis.dsb.stts.rsrcuse.vo;
import java.math.BigDecimal;

public class RsrcUseStteClstrVo  {
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
	private BigDecimal lastAsgnStrgCapa;
	private BigDecimal maxCpuUseRt;
	private BigDecimal maxMemUseRt;
	private BigDecimal vmMaxCpuUseRt;
	private BigDecimal vmMaxMemUseRt;
	private BigDecimal vmMaxStrgUseRt;
	private BigDecimal autoLastServc;
	private BigDecimal autoLastCoreQty;
	private BigDecimal autoLastMemCapa;
	private BigDecimal autoLastStrgCpa;
	private BigDecimal autoMaxCpuUseRt;
	private BigDecimal autoMaxMemUseRt;

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
	 * @return the maxCpuUseRt
	 */
	public BigDecimal getMaxCpuUseRt() {
		return maxCpuUseRt;
	}
	/**
	 * @param maxCpuUseRt the maxCpuUseRt to set
	 */
	public void setMaxCpuUseRt(BigDecimal maxCpuUseRt) {
		this.maxCpuUseRt = maxCpuUseRt;
	}
	/**
	 * @return the maxMemUseRt
	 */
	public BigDecimal getMaxMemUseRt() {
		return maxMemUseRt;
	}
	/**
	 * @param maxMemUseRt the maxMemUseRt to set
	 */
	public void setMaxMemUseRt(BigDecimal maxMemUseRt) {
		this.maxMemUseRt = maxMemUseRt;
	}
	/**
	 * @return the vmMaxCpuUseRt
	 */
	public BigDecimal getVmMaxCpuUseRt() {
		return vmMaxCpuUseRt;
	}
	/**
	 * @param vmMaxCpuUseRt the vmMaxCpuUseRt to set
	 */
	public void setVmMaxCpuUseRt(BigDecimal vmMaxCpuUseRt) {
		this.vmMaxCpuUseRt = vmMaxCpuUseRt;
	}
	/**
	 * @return the vmMaxMemUseRt
	 */
	public BigDecimal getVmMaxMemUseRt() {
		return vmMaxMemUseRt;
	}
	/**
	 * @param vmMaxMemUseRt the vmMaxMemUseRt to set
	 */
	public void setVmMaxMemUseRt(BigDecimal vmMaxMemUseRt) {
		this.vmMaxMemUseRt = vmMaxMemUseRt;
	}
	/**
	 * @return the vmMaxStrgUseRt
	 */
	public BigDecimal getVmMaxStrgUseRt() {
		return vmMaxStrgUseRt;
	}
	/**
	 * @param vmMaxStrgUseRt the vmMaxStrgUseRt to set
	 */
	public void setVmMaxStrgUseRt(BigDecimal vmMaxStrgUseRt) {
		this.vmMaxStrgUseRt = vmMaxStrgUseRt;
	}
	/**
	 * @return the autoLastServc
	 */
	public BigDecimal getAutoLastServc() {
		return autoLastServc;
	}
	/**
	 * @param autoLastServc the autoLastServc to set
	 */
	public void setAutoLastServc(BigDecimal autoLastServc) {
		this.autoLastServc = autoLastServc;
	}
	/**
	 * @return the autoLastCoreQty
	 */
	public BigDecimal getAutoLastCoreQty() {
		return autoLastCoreQty;
	}
	/**
	 * @param autoLastCoreQty the autoLastCoreQty to set
	 */
	public void setAutoLastCoreQty(BigDecimal autoLastCoreQty) {
		this.autoLastCoreQty = autoLastCoreQty;
	}
	/**
	 * @return the autoLastMemCapa
	 */
	public BigDecimal getAutoLastMemCapa() {
		return autoLastMemCapa;
	}
	/**
	 * @param autoLastMemCapa the autoLastMemCapa to set
	 */
	public void setAutoLastMemCapa(BigDecimal autoLastMemCapa) {
		this.autoLastMemCapa = autoLastMemCapa;
	}
	/**
	 * @return the autoLastStrgCpa
	 */
	public BigDecimal getAutoLastStrgCpa() {
		return autoLastStrgCpa;
	}
	/**
	 * @param autoLastStrgCpa the autoLastStrgCpa to set
	 */
	public void setAutoLastStrgCpa(BigDecimal autoLastStrgCpa) {
		this.autoLastStrgCpa = autoLastStrgCpa;
	}
	/**
	 * @return the autoMaxCpuUseRt
	 */
	public BigDecimal getAutoMaxCpuUseRt() {
		return autoMaxCpuUseRt;
	}
	/**
	 * @param autoMaxCpuUseRt the autoMaxCpuUseRt to set
	 */
	public void setAutoMaxCpuUseRt(BigDecimal autoMaxCpuUseRt) {
		this.autoMaxCpuUseRt = autoMaxCpuUseRt;
	}
	/**
	 * @return the autoMaxMemUseRt
	 */
	public BigDecimal getAutoMaxMemUseRt() {
		return autoMaxMemUseRt;
	}
	/**
	 * @param autoMaxMemUseRt the autoMaxMemUseRt to set
	 */
	public void setAutoMaxMemUseRt(BigDecimal autoMaxMemUseRt) {
		this.autoMaxMemUseRt = autoMaxMemUseRt;
	}



}
