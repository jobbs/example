/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmCntVo.java
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

public class VmCntVo extends CommonSearchVo {

	private long total;
	private long win;
	private long linux;
	private long hp;
	private long aix;
	private long etc;
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the win
	 */
	public long getWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public void setWin(long win) {
		this.win = win;
	}
	/**
	 * @return the linux
	 */
	public long getLinux() {
		return linux;
	}
	/**
	 * @param linux the linux to set
	 */
	public void setLinux(long linux) {
		this.linux = linux;
	}
	/**
	 * @return the hp
	 */
	public long getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(long hp) {
		this.hp = hp;
	}
	/**
	 * @return the aix
	 */
	public long getAix() {
		return aix;
	}
	/**
	 * @param aix the aix to set
	 */
	public void setAix(long aix) {
		this.aix = aix;
	}
	/**
	 * @return the etc
	 */
	public long getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(long etc) {
		this.etc = etc;
	}


}
