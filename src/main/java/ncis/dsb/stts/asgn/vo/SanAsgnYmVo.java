/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanAsgnYmVo.java
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

package ncis.dsb.stts.asgn.vo;

import java.math.BigDecimal;

public class SanAsgnYmVo{
	private long rn;
	private String yy;
	private String mm;
	private String mmQ;
	private String ym;
	private String regionId;
	private String rsrcPoolId;
	private String rsrcPoolNm;
	private BigDecimal phyCapa;
	private String phyCapaS;
	private BigDecimal keepCapa;
	private BigDecimal totAsgnCapa;
	private BigDecimal vmAsgnCapa;
	private BigDecimal unusedLunCapa;
	private BigDecimal unusedLunQty;
	private BigDecimal marginQty;

	/**
	 * @return the mm
	 */
	public long getRn() {
		return rn;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setRn(long rn) {
		this.rn = rn;
	}

	/**
	 * @return the yy
	 */
	public String getYy() {
		return yy;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setYy(String yy) {
		this.yy = yy;
	}

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
	 * @return the mm
	 */
	public String getMmQ() {
		return mmQ;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMmQ(String mmQ) {
		this.mmQ = mmQ;
	}
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
	 * @return the phyCapa
	 */
	public BigDecimal getPhyCapa() {
		return phyCapa;
	}
	/**
	 * @param phyCapa the phyCapa to set
	 */
	public void setPhyCapa(BigDecimal phyCapa) {
		this.phyCapa = phyCapa;
	}

	/**
	 * @return the phyCapa
	 */
	public String getPhyCapaS() {
		return phyCapaS;
	}
	/**
	 * @param phyCapa the phyCapa to set
	 */
	public void setPhyCapaS(String phyCapaS) {
		this.phyCapaS = phyCapaS;
	}

	/**
	 * @return the keepCapa
	 */
	public BigDecimal getKeepCapa() {
		return keepCapa;
	}
	/**
	 * @param keepCapa the keepCapa to set
	 */
	public void setKeepCapa(BigDecimal keepCapa) {
		this.keepCapa = keepCapa;
	}
	/**
	 * @return the totAsgnCapa
	 */
	public BigDecimal getTotAsgnCapa() {
		return totAsgnCapa;
	}
	/**
	 * @param totAsgnCapa the totAsgnCapa to set
	 */
	public void setTotAsgnCapa(BigDecimal totAsgnCapa) {
		this.totAsgnCapa = totAsgnCapa;
	}
	/**
	 * @return the vmAsgnCapa
	 */
	public BigDecimal getVmAsgnCapa() {
		return vmAsgnCapa;
	}
	/**
	 * @param vmAsgnCapa the vmAsgnCapa to set
	 */
	public void setVmAsgnCapa(BigDecimal vmAsgnCapa) {
		this.vmAsgnCapa = vmAsgnCapa;
	}
	/**
	 * @return the unusedLunCapa
	 */
	public BigDecimal getUnusedLunCapa() {
		return unusedLunCapa;
	}
	/**
	 * @param unusedLunCapa the unusedLunCapa to set
	 */
	public void setUnusedLunCapa(BigDecimal unusedLunCapa) {
		this.unusedLunCapa = unusedLunCapa;
	}
	/**
	 * @return the unusedLunQty
	 */
	public BigDecimal getUnusedLunQty() {
		return unusedLunQty;
	}
	/**
	 * @param unusedLunQty the unusedLunQty to set
	 */
	public void setUnusedLunQty(BigDecimal unusedLunQty) {
		this.unusedLunQty = unusedLunQty;
	}
	/**
	 * @return the marginQty
	 */
	public BigDecimal getMarginQty() {
		return marginQty;
	}
	/**
	 * @param marginQty the marginQty to set
	 */
	public void setMarginQty(BigDecimal marginQty) {
		this.marginQty = marginQty;
	}


}
