/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Api.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import ncis.cmn.entity.couch.CmnCouchVo;

/**
 * @author 박희택
 *
 */
public class Api extends CmnCouchVo {

	private String keyId;						// couchDB의 Key(Pk)
	private String rev;							// couchDB 문서 reversion
	private String apiId;						//APIID
	private String apiNm;						//API명
	private String apiVerCd;					//API버전코드
	private String methodCd;					//Method코드
	private String stackClCd;					//스택분류코드
	private String stackClNm;					//스택분류코드명
	private String uri;							//URI
	private String dc;							//설명
	private String regUserNm;					//등록자명
	private String regDt;						//등록일자

	/**
	 * @return the keyId
	 */
	public String getKeyId() {
		return keyId;
	}
	/**
	 * @param keyId the keyId to set
	 */
	public void setKeyId(String keyId) {
		this.keyId = keyId;
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
	 * @return the apiId
	 */
	public String getApiId() {
		return apiId;
	}
	/**
	 * @param apiId the apiId to set
	 */
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
	/**
	 * @return the apiNm
	 */
	public String getApiNm() {
		return apiNm;
	}
	/**
	 * @param apiNm the apiNm to set
	 */
	public void setApiNm(String apiNm) {
		this.apiNm = apiNm;
	}
	/**
	 * @return the apiVerCd
	 */
	public String getApiVerCd() {
		return apiVerCd;
	}
	/**
	 * @param apiVerCd the apiVerCd to set
	 */
	public void setApiVerCd(String apiVerCd) {
		this.apiVerCd = apiVerCd;
	}
	/**
	 * @return the methodCd
	 */
	public String getMethodCd() {
		return methodCd;
	}
	/**
	 * @param methodCd the methodCd to set
	 */
	public void setMethodCd(String methodCd) {
		this.methodCd = methodCd;
	}
	/**
	 * @return the stackClCd
	 */
	public String getStackClCd() {
		return stackClCd;
	}
	/**
	 * @param stackClCd the stackClCd to set
	 */
	public void setStackClCd(String stackClCd) {
		this.stackClCd = stackClCd;
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
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
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

}
