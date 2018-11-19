/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteVo.java
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

public class RsrcUseStteVo  {
	private String mm;
	private BigDecimal rsrcPoolId;
	private BigDecimal clstrSeq;
	private BigDecimal vrlzSwTyCd;
	private BigDecimal rhev;
	private BigDecimal vmware;
	private BigDecimal ibm;
	private BigDecimal hp;
	private BigDecimal openstack;
	private BigDecimal docker;
	private BigDecimal ovm;
	private BigDecimal openshift;
	private BigDecimal lastCpuCorQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal lastStrgSumCapa;
	private BigDecimal lastVSrvrQty;
	private BigDecimal lastAsgnVcorQty;
	private BigDecimal lastAsgnMemCapa;
	private BigDecimal vmLastAsgnStrgCapa;
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
	 * @return the rsrcPoolId
	 */
	public BigDecimal getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(BigDecimal rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
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
	 * @return the vrlzSwTyCd
	 */
	public BigDecimal getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	/**
	 * @param vrlzSwTyCd the vrlzSwTyCd to set
	 */
	public void setVrlzSwTyCd(BigDecimal vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}
	/**
	 * @return the rhev
	 */
	public BigDecimal getRhev() {
		return rhev;
	}
	/**
	 * @param rhev the rhev to set
	 */
	public void setRhev(BigDecimal rhev) {
		this.rhev = rhev;
	}
	/**
	 * @return the vmware
	 */
	public BigDecimal getVmware() {
		return vmware;
	}
	/**
	 * @param vmware the vmware to set
	 */
	public void setVmware(BigDecimal vmware) {
		this.vmware = vmware;
	}
	/**
	 * @return the ibm
	 */
	public BigDecimal getIbm() {
		return ibm;
	}
	/**
	 * @param ibm the ibm to set
	 */
	public void setIbm(BigDecimal ibm) {
		this.ibm = ibm;
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
	 * @return the openstack
	 */
	public BigDecimal getOpenstack() {
		return openstack;
	}
	/**
	 * @param openstack the openstack to set
	 */
	public void setOpenstack(BigDecimal openstack) {
		this.openstack = openstack;
	}
	/**
	 * @return the docker
	 */
	public BigDecimal getDocker() {
		return docker;
	}
	/**
	 * @param docker the docker to set
	 */
	public void setDocker(BigDecimal docker) {
		this.docker = docker;
	}
	/**
	 * @return the ovm
	 */
	public BigDecimal getOvm() {
		return ovm;
	}
	/**
	 * @param ovm the ovm to set
	 */
	public void setOvm(BigDecimal ovm) {
		this.ovm = ovm;
	}
	/**
	 * @return the openshift
	 */
	public BigDecimal getOpenshift() {
		return openshift;
	}
	/**
	 * @param openshift the openshift to set
	 */
	public void setOpenshift(BigDecimal openshift) {
		this.openshift = openshift;
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
	public BigDecimal getVmLastAsgnStrgCapa() {
		return vmLastAsgnStrgCapa;
	}
	/**
	 * @param lastAsgnStrgCapa the lastAsgnStrgCapa to set
	 */
	public void setVmLastAsgnStrgCapa(BigDecimal vmLastAsgnStrgCapa) {
		this.vmLastAsgnStrgCapa = vmLastAsgnStrgCapa;
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
