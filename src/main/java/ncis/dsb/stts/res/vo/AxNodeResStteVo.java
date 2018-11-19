/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResStteVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 05. 10
 * @lastmodified2017. 05. 10
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


public class AxNodeResStteVo {

	//센터명
	private String regionNm;
	//존명
	private String zoneNm;
	//망명
	private String netNm;
	//자원풀 명
	private String rsrcPoolNm;
	private String rsrcPoolId;
	private String atmsclNodeNm;
	private String atmsclNodeId;

	private BigDecimal podQty;
	private BigDecimal cpu;
	private BigDecimal cpuRt;
	private BigDecimal mem;
	private BigDecimal memRt;
	private BigDecimal strg;
	private BigDecimal netwkIn;
	private BigDecimal netwkOut;


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
	 * @return the atmsclNodeId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param atmsclNodeId the atmsclNodeId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the atmsclNodeNm
	 */
	public String getAtmsclNodeNm() {
		return atmsclNodeNm;
	}
	/**
	 * @param atmsclNodeNm the atmsclNodeNm to set
	 */
	public void setAtmsclNodeNm(String atmsclNodeNm) {
		this.atmsclNodeNm = atmsclNodeNm;
	}

	/**
	 * @return the atmsclNodeId
	 */
	public String getAtmsclNodeId() {
		return atmsclNodeId;
	}
	/**
	 * @param atmsclNodeNm the atmsclNodeId to set
	 */
	public void setAtmsclNodeId(String atmsclNodeId) {
		this.atmsclNodeId = atmsclNodeId;
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
	 * @return the cpu
	 */
	public BigDecimal getCpu() {
		return cpu;
	}
	/**
	 * @param cpu the cpu to set
	 */
	public void setCpu(BigDecimal cpu) {
		this.cpu = cpu;
	}
	/**
	 * @return the cpuRt
	 */
	public BigDecimal getCpuRt() {
		return cpuRt;
	}
	/**
	 * @param cpuRt the cpuRt to set
	 */
	public void setCpuRt(BigDecimal cpuRt) {
		this.cpuRt = cpuRt;
	}
	/**
	 * @return the mem
	 */
	public BigDecimal getMem() {
		return mem;
	}
	/**
	 * @param mem the mem to set
	 */
	public void setMem(BigDecimal mem) {
		this.mem = mem;
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
	 * @return the strg
	 */
	public BigDecimal getStrg() {
		return strg;
	}
	/**
	 * @param strg the strg to set
	 */
	public void setStrg(BigDecimal strg) {
		this.strg = strg;
	}
	/**
	 * @return the netwkIn
	 */
	public BigDecimal getNetwkIn() {
		return netwkIn;
	}
	/**
	 * @param netwkIn the netwkIn to set
	 */
	public void setNetwkIn(BigDecimal netwkIn) {
		this.netwkIn = netwkIn;
	}
	/**
	 * @return the netwkOut
	 */
	public BigDecimal getNetwkOut() {
		return netwkOut;
	}
	/**
	 * @param netwkOut the netwkOut to set
	 */
	public void setNetwkOut(BigDecimal netwkOut) {
		this.netwkOut = netwkOut;
	}

}
