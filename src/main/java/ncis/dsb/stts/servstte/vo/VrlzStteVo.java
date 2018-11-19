/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VrlzStteVo.java
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


public class VrlzStteVo{
	private String cdNm;
	private BigDecimal pmCnt;
	private BigDecimal virRt;
	/**
	 * @return the cdNm
	 */
	public String getCdNm() {
		return cdNm;
	}
	/**
	 * @param cdNm the cdNm to set
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	/**
	 * @return the pmCnt
	 */
	public BigDecimal getPmCnt() {
		return pmCnt;
	}
	/**
	 * @param pmCnt the pmCnt to set
	 */
	public void setPmCnt(BigDecimal pmCnt) {
		this.pmCnt = pmCnt;
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
