/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */


package ncis.dsb.stts.asgnUseful.vo;

import java.math.BigDecimal;

public class UsefulVo{
	private String ym;
	private String regionId;
	private String netNm;
	private long netCnt;
	private String rsrcPoolNm;
	private long rsrcPoolIdCnt;
	private String rsrcPoolId;
	private String clstrUuid;
	private BigDecimal lastCpuCorQty;
	private BigDecimal lastMemSumCapa;
	private BigDecimal maxVcoreAsgnRt;
	private BigDecimal maxMemAsgnRt;
	private BigDecimal maxVcoreAsgn;
	private BigDecimal maxMemAsgn;
	private BigDecimal lastAsgnVcorQty;
	private BigDecimal lastAsgnMemCapa;
	private BigDecimal marginVcoreCapa;
	private BigDecimal marginMemCapa;
	private BigDecimal vmVcoreAvgSpec;
	private BigDecimal vmMemAvgSpec;
	private BigDecimal vmAsgnQty;
	private String colctDt;
	private String colctHour;
	private String colctMi;
	/**
	 * @return the ym
	 */
	public String getYm() {
		return ym;
	}
	/**
	 * @param ym the ym to set
	 */
	public void setYm(String ym) {
		this.ym = ym;
	}
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
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
	 * @return the netCnt
	 */
	public long getNetCnt() {
		return netCnt;
	}
	/**
	 * @param netCnt the netCnt to set
	 */
	public void setNetCnt(long netCnt) {
		this.netCnt = netCnt;
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
	 * @return the rsrcPoolIdCnt
	 */
	public long getRsrcPoolIdCnt() {
		return rsrcPoolIdCnt;
	}
	/**
	 * @param rsrcPoolIdCnt the rsrcPoolIdCnt to set
	 */
	public void setRsrcPoolIdCnt(long rsrcPoolIdCnt) {
		this.rsrcPoolIdCnt = rsrcPoolIdCnt;
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
	 * @return the clstrNm
	 */
	public String getClstrUuid() {
		return clstrUuid;
	}
	/**
	 * @param clstrNm the clstrNm to set
	 */
	public void setClstrUuid(String clstrUuid) {
		this.clstrUuid = clstrUuid;
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
	 * @return the maxVcoreAsgnRt
	 */
	public BigDecimal getMaxVcoreAsgnRt() {
		return maxVcoreAsgnRt;
	}
	/**
	 * @param maxVcoreAsgnRt the maxVcoreAsgnRt to set
	 */
	public void setMaxVcoreAsgnRt(BigDecimal maxVcoreAsgnRt) {
		this.maxVcoreAsgnRt = maxVcoreAsgnRt;
	}
	/**
	 * @return the maxMemAsgnRt
	 */
	public BigDecimal getMaxMemAsgnRt() {
		return maxMemAsgnRt;
	}
	/**
	 * @param maxMemAsgnRt the maxMemAsgnRt to set
	 */
	public void setMaxMemAsgnRt(BigDecimal maxMemAsgnRt) {
		this.maxMemAsgnRt = maxMemAsgnRt;
	}
	/**
	 * @return the maxVcoreAsgn
	 */
	public BigDecimal getMaxVcoreAsgn() {
		return maxVcoreAsgn;
	}
	/**
	 * @param maxVcoreAsgn the maxVcoreAsgn to set
	 */
	public void setMaxVcoreAsgn(BigDecimal maxVcoreAsgn) {
		this.maxVcoreAsgn = maxVcoreAsgn;
	}
	/**
	 * @return the maxMemAsgn
	 */
	public BigDecimal getMaxMemAsgn() {
		return maxMemAsgn;
	}
	/**
	 * @param maxMemAsgn the maxMemAsgn to set
	 */
	public void setMaxMemAsgn(BigDecimal maxMemAsgn) {
		this.maxMemAsgn = maxMemAsgn;
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
	 * @return the marginVcoreCapa
	 */
	public BigDecimal getMarginVcoreCapa() {
		return marginVcoreCapa;
	}
	/**
	 * @param marginVcoreCapa the marginVcoreCapa to set
	 */
	public void setMarginVcoreCapa(BigDecimal marginVcoreCapa) {
		this.marginVcoreCapa = marginVcoreCapa;
	}
	/**
	 * @return the marginMemCapa
	 */
	public BigDecimal getMarginMemCapa() {
		return marginMemCapa;
	}
	/**
	 * @param marginMemCapa the marginMemCapa to set
	 */
	public void setMarginMemCapa(BigDecimal marginMemCapa) {
		this.marginMemCapa = marginMemCapa;
	}
	/**
	 * @return the vmVcoreAvgSpec
	 */
	public BigDecimal getVmVcoreAvgSpec() {
		return vmVcoreAvgSpec;
	}
	/**
	 * @param vmVcoreAvgSpec the vmVcoreAvgSpec to set
	 */
	public void setVmVcoreAvgSpec(BigDecimal vmVcoreAvgSpec) {
		this.vmVcoreAvgSpec = vmVcoreAvgSpec;
	}
	/**
	 * @return the vmMemAvgSpec
	 */
	public BigDecimal getVmMemAvgSpec() {
		return vmMemAvgSpec;
	}
	/**
	 * @param vmMemAvgSpec the vmMemAvgSpec to set
	 */
	public void setVmMemAvgSpec(BigDecimal vmMemAvgSpec) {
		this.vmMemAvgSpec = vmMemAvgSpec;
	}
	/**
	 * @return the vmAsgnQty
	 */
	public BigDecimal getVmAsgnQty() {
		return vmAsgnQty;
	}
	/**
	 * @param vmAsgnQty the vmAsgnQty to set
	 */
	public void setVmAsgnQty(BigDecimal vmAsgnQty) {
		this.vmAsgnQty = vmAsgnQty;
	}
	/**
	 * @return the colctDt
	 */
	public String getColctDt() {
		return colctDt;
	}
	/**
	 * @param colctDt the colctDt to set
	 */
	public void setColctDt(String colctDt) {
		this.colctDt = colctDt;
	}
	/**
	 * @return the colctHour
	 */
	public String getColctHour() {
		return colctHour;
	}
	/**
	 * @param colctHour the colctHour to set
	 */
	public void setColctHour(String colctHour) {
		this.colctHour = colctHour;
	}
	/**
	 * @return the colctMi
	 */
	public String getColctMi() {
		return colctMi;
	}
	/**
	 * @param colctMi the colctMi to set
	 */
	public void setColctMi(String colctMi) {
		this.colctMi = colctMi;
	}



}
