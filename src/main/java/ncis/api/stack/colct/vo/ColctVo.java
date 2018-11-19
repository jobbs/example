/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctVo.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.vo;

import ncis.cmn.entity.Mngr;

/**
 * @author 최장성
 *
 */
public class ColctVo extends Mngr {

	private String regionNm;
	private String zoneNm;
	private String netNm;
	private String stackClNm;
	private String mngrClNm;
	private String mngrVerNm;
	private String nowVerNm;
	private String btchColctCd;
	private String btchColctNm;
	private boolean btchSttus;
	private String btchSttusNm;

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
	 * @return the stackClNm
	 */
	public String getStackClNm() {
		return stackClNm;
	}
	/**
	 * @param stackClNm the stackClNm to set
	 */
	public void setStackClNm(String stackClNm) {
		this.stackClNm = stackClNm;
	}
	/**
	 * @return the mngrClNm
	 */
	public String getMngrClNm() {
		return mngrClNm;
	}
	/**
	 * @param mngrClNm the mngrClNm to set
	 */
	public void setMngrClNm(String mngrClNm) {
		this.mngrClNm = mngrClNm;
	}
	/**
	 * @return the mngrVerNm
	 */
	public String getMngrVerNm() {
		return mngrVerNm;
	}
	/**
	 * @param mngrVerNm the mngrVerNm to set
	 */
	public void setMngrVerNm(String mngrVerNm) {
		this.mngrVerNm = mngrVerNm;
	}
	/**
	 * @return the nowVerNm
	 */
	public String getNowVerNm()	{
		return nowVerNm;
	}
	/**
	 * @param nowVerNm the nowVerNm to set
	 */
	public void setNowVerNm(String nowVerNm) {
		this.nowVerNm = nowVerNm;
	}
	/**
	 * @return the btchColctCd
	 */
	public String getBtchColctCd() {
		return btchColctCd;
	}
	/**
	 * @param btchColctCd the btchColctCd to set
	 */
	public void setBtchColctCd(String btchColctCd) {
		this.btchColctCd = btchColctCd;
	}
	/**
	 * @return the btchColctNm
	 */
	public String getBtchColctNm() {
		return btchColctNm;
	}
	/**
	 * @param btchColctNm the btchColctNm to set
	 */
	public void setBtchColctNm(String btchColctNm) {
		this.btchColctNm = btchColctNm;
	}
	/**
	 * @return the btchSttus
	 */
	public boolean isBtchSttus() {
		return btchSttus;
	}
	/**
	 * @param btchSttus the btchSttus to set
	 */
	public void setBtchSttus(boolean btchSttus) {
		this.btchSttus = btchSttus;
	}
	/**
	 * @return the btchSttusNm
	 */
	public String getBtchSttusNm() {
		return btchSttusNm;
	}
	/**
	 * @param btchSttusNm the btchSttusNm to set
	 */
	public void setBtchSttusNm(String btchSttusNm) {
		this.btchSttusNm = btchSttusNm;
	}
}
