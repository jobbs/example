/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Authr.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.util.List;

import ncis.cmn.entity.couch.CmnCouchVo;

/**
 * @author 박희택
 *
 */
public class Authr extends CmnCouchVo {

	private String authrId;						// couchDB의 Key(Pk)
	private String rev;							// couchDB 문서 reversion
	private String authrNm;						//권한명
	private List<String> apiMapng; 				//apiMapng 매핑정보
	private String regUserNm; 					// 등록자명
	private String regDt;						// 등록일자
	private String dc;							// 설명

	/**
	 * @return the authrId
	 */
	public String getAuthrId() {
		return authrId;
	}
	/**
	 * @param authrId the authrId to set
	 */
	public void setAuthrId(String authrId) {
		this.authrId = authrId;
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
	 * @return the authrNm
	 */
	public String getAuthrNm() {
		return authrNm;
	}
	/**
	 * @param authrNm the authrNm to set
	 */
	public void setAuthrNm(String authrNm) {
		this.authrNm = authrNm;
	}
	/**
	 * @return the apiMapng
	 */
	public List<String> getApiMapng() {
		return apiMapng;
	}
	/**
	 * @param apiMapng the apiMapng to set
	 */
	public void setApiMapng(List<String> apiMapng) {
		this.apiMapng = apiMapng;
	}
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
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}
	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}
	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

}
