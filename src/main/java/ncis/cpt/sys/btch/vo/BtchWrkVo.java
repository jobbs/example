/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.vo;

import ncis.cmn.entity.CmBtchWrk;

/**
 * @author 박봉춘
 *
 */
public class BtchWrkVo extends CmBtchWrk{
	/**
	 * 사용자 이름
	 */
	private String regUserNm;

	/**
	 * 주기 이름
	 */
	private String cycleNm;

    private String exeTime;

    private String cycleExeTime;

	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}

	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

	/**
	 * @return the cycleNm
	 */
	public String getCycleNm() {
		return cycleNm;
	}

	/**
	 * @param cycleNm the cycleNm to set
	 */
	public void setCycleNm(String cycleNm) {
		this.cycleNm = cycleNm;
	}

	/**
	 * @return the exeTime
	 */
	public String getExeTime() {
		return exeTime;
	}

	/**
	 * @param exeTime the exeTime to set
	 */
	public void setExeTime(String exeTime) {
		this.exeTime = exeTime;
	}

	/**
	 * @return the cycleExeTime
	 */
	public String getCycleExeTime() {
		return cycleExeTime;
	}

	/**
	 * @param cycleExeTime the cycleExeTime to set
	 */
	public void setCycleExeTime(String cycleExeTime) {
		this.cycleExeTime = cycleExeTime;
	}
}
