/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqstHistryVo.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.use.vo;

import ncis.cmn.entity.ReqstHistry;

/**
 * @author 박희택
 *
 */
public class ReqstHstryVo extends ReqstHistry{

	private String sysNm; 			// 시스템명
	private String reqHstrystatNm; 	// 신청이력 상태

	/**
	 * @return the sysNm
	 */
	public String getSysNm() {
		return sysNm;
	}
	/**
	 * @param sysNm the sysNm to set
	 */
	public void setSysNm(String sysNm) {
		this.sysNm = sysNm;
	}
	/**
	 * @return the reqHstrystatNm
	 */
	public String getReqHstrystatNm() {
		return reqHstrystatNm;
	}
	/**
	 * @param reqHstrystatNm the reqHstrystatNm to set
	 */
	public void setReqHstrystatNm(String reqHstrystatNm) {
		this.reqHstrystatNm = reqHstrystatNm;
	}


}
