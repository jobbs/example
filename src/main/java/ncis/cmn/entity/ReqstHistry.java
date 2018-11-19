/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename reqstHist.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import ncis.cmn.entity.couch.CmnCouchVo;


/**
 * @author 박희택
 *
 */
public class ReqstHistry extends CmnCouchVo{

	private String reqHstryId;				// couchDB의 Key(Pk)
	private String rev;						// couchDB 문서 reversion
	private String sysCd;					// 사용신청과 매핑
	private String reqHstryNm;				// 신청이력명
	private String reqHstrystatCd;			// 신청이력상태코드
	private String reqhstryUsrNm;			// 신청이력신청자명
	private String chargerNm;				// 담당자명
	private String reqHstryDt;				// 신청이력신청일자

	/**
	 * @return the reqHstryId
	 */
	public String getReqHstryId() {
		return reqHstryId;
	}
	/**
	 * @param reqHstryId the reqHstryId to set
	 */
	public void setReqHstryId(String reqHstryId) {
		this.reqHstryId = reqHstryId;
	}
	/**
	 * @return the rev
	 */
	public String getRev() {
		return rev;
	}
	/**
	 * @param rev the rev to set
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	/**
	 * @return the sysCd
	 */
	public String getSysCd() {
		return sysCd;
	}
	/**
	 * @param sysCd the sysCd to set
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	/**
	 * @return the reqHstryNm
	 */
	public String getReqHstryNm() {
		return reqHstryNm;
	}
	/**
	 * @param reqHstryNm the reqHstryNm to set
	 */
	public void setReqHstryNm(String reqHstryNm) {
		this.reqHstryNm = reqHstryNm;
	}
	/**
	 * @return the reqHstrystatCd
	 */
	public String getReqHstrystatCd() {
		return reqHstrystatCd;
	}
	/**
	 * @param reqHstrystatCd the reqHstrystatCd to set
	 */
	public void setReqHstrystatCd(String reqHstrystatCd) {
		this.reqHstrystatCd = reqHstrystatCd;
	}
	/**
	 * @return the reqhstryUsrNm
	 */
	public String getReqhstryUsrNm() {
		return reqhstryUsrNm;
	}
	/**
	 * @param reqhstryUsrNm the reqhstryUsrNm to set
	 */
	public void setReqhstryUsrNm(String reqhstryUsrNm) {
		this.reqhstryUsrNm = reqhstryUsrNm;
	}
	/**
	 * @return the chargerNm
	 */
	public String getChargerNm() {
		return chargerNm;
	}
	/**
	 * @param chargerNm the chargerNm to set
	 */
	public void setChargerNm(String chargerNm) {
		this.chargerNm = chargerNm;
	}
	/**
	 * @return the reqHstryDt
	 */
	public String getReqHstryDt() {
		return reqHstryDt;
	}
	/**
	 * @param reqHstryDt the reqHstryDt to set
	 */
	public void setReqHstryDt(String reqHstryDt) {
		this.reqHstryDt = reqHstryDt;
	}

}
