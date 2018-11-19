/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmStteVo.java
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
package ncis.dsb.stts.servstte.vo;
import java.math.BigDecimal;


public class VmStteVo{
	private String regionNm;
	private BigDecimal vmCnt;
	private BigDecimal virRt;
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
	 * @return the vmCnt
	 */
	public BigDecimal getVmCnt() {
		return vmCnt;
	}
	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(BigDecimal vmCnt) {
		this.vmCnt = vmCnt;
	}
	/**
	 * @return the virRt
	 */
	public BigDecimal getVirRt() {
		return virRt;
	}
	/**
	 * @param virRt the virRt to set
	 */
	public void setVirRt(BigDecimal virRt) {
		this.virRt = virRt;
	}



}
