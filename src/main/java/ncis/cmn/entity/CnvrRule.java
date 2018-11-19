/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CnvrRule.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.entity;


/**
 * @author 박희택
 *
 */
public class CnvrRule {

	private String cnvrRuleStackClCd;			//스택분류
	private String cnvrRuleApiId;				//API ID
	private int targtSeq;						//호출 시퀀스
	private String targtMethodCd;				//호출Method
	private String targtUri;					//호출 URI
	private String mngrClCd;					//매니저분류
	private String mngrVerCd;					//매니저버전
	private String apiVerCd;					//API버전
	private String cnvrScript;					//변환 스크립트

	/**
	 * @return the cnvrRuleStackClCd
	 */
	public String getCnvrRuleStackClCd() {
		return cnvrRuleStackClCd;
	}
	/**
	 * @param cnvrRuleStackClCd the cnvrRuleStackClCd to set
	 */
	public void setCnvrRuleStackClCd(String cnvrRuleStackClCd) {
		this.cnvrRuleStackClCd = cnvrRuleStackClCd;
	}
	/**
	 * @return the cnvrRuleApiId
	 */
	public String getCnvrRuleApiId() {
		return cnvrRuleApiId;
	}
	/**
	 * @param cnvrRuleApiId the cnvrRuleApiId to set
	 */
	public void setCnvrRuleApiId(String cnvrRuleApiId) {
		this.cnvrRuleApiId = cnvrRuleApiId;
	}
	/**
	 * @return the targtSeq
	 */
	public int getTargtSeq() {
		return targtSeq;
	}
	/**
	 * @param targtSeq the targtSeq to set
	 */
	public void setTargtSeq(int targtSeq) {
		this.targtSeq = targtSeq;
	}
	/**
	 * @return the targtMethodCd
	 */
	public String getTargtMethodCd() {
		return targtMethodCd;
	}
	/**
	 * @param targtMethodCd the targtMethodCd to set
	 */
	public void setTargtMethodCd(String targtMethodCd) {
		this.targtMethodCd = targtMethodCd;
	}
	/**
	 * @return the targtUri
	 */
	public String getTargtUri() {
		return targtUri;
	}
	/**
	 * @param targtUri the targtUri to set
	 */
	public void setTargtUri(String targtUri) {
		this.targtUri = targtUri;
	}
	/**
	 * @return the mngrClCd
	 */
	public String getMngrClCd() {
		return mngrClCd;
	}
	/**
	 * @param mngrClCd the mngrClCd to set
	 */
	public void setMngrClCd(String mngrClCd) {
		this.mngrClCd = mngrClCd;
	}
	/**
	 * @return the mngrVerCd
	 */
	public String getMngrVerCd() {
		return mngrVerCd;
	}
	/**
	 * @param mngrVerCd the mngrVerCd to set
	 */
	public void setMngrVerCd(String mngrVerCd) {
		this.mngrVerCd = mngrVerCd;
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
	 * @return the cnvrScript
	 */
	public String getCnvrScript() {
		return cnvrScript;
	}
	/**
	 * @param cnvrScript the cnvrScript to set
	 */
	public void setCnvrScript(String cnvrScript) {
		this.cnvrScript = cnvrScript;
	}

}
