/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptOsVo.java
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
package ncis.dsb.stts.res.vo;

import ncis.cmn.vo.CommonSearchVo;
import java.math.BigDecimal;

public class GovDeptOsVo extends CommonSearchVo {

	private BigDecimal osWin;
	private BigDecimal osLinux;
	private BigDecimal osHp;
	private BigDecimal osAix;
	private BigDecimal osEtc;
	/**
	 * @return the osWin
	 */
	public BigDecimal getOsWin() {
		return osWin;
	}
	/**
	 * @param osWin the osWin to set
	 */
	public void setOsWin(BigDecimal osWin) {
		this.osWin = osWin;
	}
	/**
	 * @return the osLinux
	 */
	public BigDecimal getOsLinux() {
		return osLinux;
	}
	/**
	 * @param osLinux the osLinux to set
	 */
	public void setOsLinux(BigDecimal osLinux) {
		this.osLinux = osLinux;
	}
	/**
	 * @return the osHp
	 */
	public BigDecimal getOsHp() {
		return osHp;
	}
	/**
	 * @param osHp the osHp to set
	 */
	public void setOsHp(BigDecimal osHp) {
		this.osHp = osHp;
	}
	/**
	 * @return the osAix
	 */
	public BigDecimal getOsAix() {
		return osAix;
	}
	/**
	 * @param osAix the osAix to set
	 */
	public void setOsAix(BigDecimal osAix) {
		this.osAix = osAix;
	}
	/**
	 * @return the osEtc
	 */
	public BigDecimal getOsEtc() {
		return osEtc;
	}
	/**
	 * @param osEtc the osEtc to set
	 */
	public void setOsEtc(BigDecimal osEtc) {
		this.osEtc = osEtc;
	}


}
