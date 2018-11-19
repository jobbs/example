/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename apiGwUser.java
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

import java.util.List;

import ncis.cmn.entity.couch.CmnCouchVo;

/**
 * @author 박희택
 *
 */
public class ApiGwUser extends CmnCouchVo  {

	private String useReqId;					// 사용신청ID(=_id)
	private String rev;							// couchDB 문서 reversion
	private String regionId;					// 센터정보
	private String reqUsrNm;					// 신청자명
	private String reqDt;						// 신청일자
	private String chargerNm;					// 담당자명
	private String sysCd;						// 시스템코드
	private String statCd;						// 상태코드
	private String accssKey;					// 접근키
	private String passwd;						// 비밀번호
	private String passwdChk;					// 비밀번호확인
	private String changePasswd;				// 변경비밀번호
	private List<String> authrMapng;			// 권한매핑
	private String reqReasn;					// 신청사유
	private String rjctReasn;					// 반려사유
	private List<String> ipAddr;				// Ip List

	/**
	 * @return the useReqId
	 */
	public String getUseReqId() {
		return useReqId;
	}
	/**
	 * @param useReqId the useReqId to set
	 */
	public void setUseReqId(String useReqId) {
		this.useReqId = useReqId;
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
	 * @return the reqUsrNm
	 */
	public String getReqUsrNm() {
		return reqUsrNm;
	}
	/**
	 * @param reqUsrNm the reqUsrNm to set
	 */
	public void setReqUsrNm(String reqUsrNm) {
		this.reqUsrNm = reqUsrNm;
	}
	/**
	 * @return the reqDt
	 */
	public String getReqDt() {
		return reqDt;
	}
	/**
	 * @param reqDt the reqDt to set
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
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
	 * @return the statCd
	 */
	public String getStatCd() {
		return statCd;
	}
	/**
	 * @param statCd the statCd to set
	 */
	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	/**
	 * @return the accssKey
	 */
	public String getAccssKey() {
		return accssKey;
	}
	/**
	 * @param accssKey the accssKey to set
	 */
	public void setAccssKey(String accssKey) {
		this.accssKey = accssKey;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the passwdChk
	 */
	public String getPasswdChk() {
		return passwdChk;
	}
	/**
	 * @param passwdChk the passwdChk to set
	 */
	public void setPasswdChk(String passwdChk) {
		this.passwdChk = passwdChk;
	}
	/**
	 * @return the changePasswd
	 */
	public String getChangePasswd() {
		return changePasswd;
	}
	/**
	 * @param changePasswd the changePasswd to set
	 */
	public void setChangePasswd(String changePasswd) {
		this.changePasswd = changePasswd;
	}
	/**
	 * @return the authrMapng
	 */
	public List<String> getAuthrMapng() {
		return authrMapng;
	}
	/**
	 * @param authrMapng the authrMapng to set
	 */
	public void setAuthrMapng(List<String> authrMapng) {
		this.authrMapng = authrMapng;
	}
	/**
	 * @return the reqReasn
	 */
	public String getReqReasn() {
		return reqReasn;
	}
	/**
	 * @param reqReasn the reqReasn to set
	 */
	public void setReqReasn(String reqReasn) {
		this.reqReasn = reqReasn;
	}
	/**
	 * @return the rjctReasn
	 */
	public String getRjctReasn() {
		return rjctReasn;
	}
	/**
	 * @param rjctReasn the rjctReasn to set
	 */
	public void setRjctReasn(String rjctReasn) {
		this.rjctReasn = rjctReasn;
	}
	/**
	 * @return the ipAddr
	 */
	public List<String> getIpAddr() {
		return ipAddr;
	}
	/**
	 * @param ipAddr the ipAddr to set
	 */
	public void setIpAddr(List<String> ipAddr) {
		this.ipAddr = ipAddr;
	}

}
