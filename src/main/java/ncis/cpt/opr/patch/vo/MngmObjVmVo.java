/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.math.BigDecimal;

import ncis.cmn.entity.RcVm;

/**
 * @author 최경철
 *
 */
public class MngmObjVmVo extends RcVm {

	private String regionId;
	private String regionNm;
	private String netNm;
	private String netClCd;
	private String insttNm;
	private String insttId;
	private String zoneId;
	private String netId;
	private String rsrcPoolId;
	private BigDecimal vmCnt = BigDecimal.ZERO;
	private BigDecimal mngmVmCnt = BigDecimal.ZERO;

	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}

	/**
	 * @param regionNm
	 *            the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}

	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}

	/**
	 * @param netNm
	 *            the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}

	/**
	 * @return the vmCnt
	 */
	public BigDecimal getVmCnt() {
		return vmCnt;
	}

	/**
	 * @param vmCnt
	 *            the vmCnt to set
	 */
	public void setVmCnt(BigDecimal vmCnt) {
		this.vmCnt = vmCnt;
	}

	/**
	 * @return the mngmVmcnt
	 */
	public BigDecimal getMngmVmCnt() {
		return mngmVmCnt;
	}

	/**
	 * @param mngmVmcnt
	 *            the mngmVmcnt to set
	 */
	public void setMngmVmCnt(BigDecimal mngmVmCnt) {
		this.mngmVmCnt = mngmVmCnt;
	}

	/**
	 * @return the insttNm
	 */
	public String getInsttNm() {
		return insttNm;
	}

	/**
	 * @param insttNm the insttNm to set
	 */
	public void setInsttNm(String insttNm) {
		this.insttNm = insttNm;
	}

	/**
	 * @return the insttId
	 */
	public String getInsttId() {
		return insttId;
	}

	/**
	 * @param insttId the insttId to set
	 */
	public void setInsttId(String insttId) {
		this.insttId = insttId;
	}

	/**
	 * @return the netId
	 */
	public String getNetClCd() {
		return netClCd;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
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
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
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



}
