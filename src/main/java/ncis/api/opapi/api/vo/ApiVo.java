/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ApiVo.java
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
package ncis.api.opapi.api.vo;

import java.util.List;

import ncis.cmn.entity.Api;
import ncis.cmn.entity.CnvrRule;
import ncis.cmn.entity.ReqParam;
import ncis.cmn.entity.RspnsResult;

/**
 * @author 박희택
 *
 */
public class ApiVo extends Api{

	private List<String> delKey;			// 목록의 체크박스 Key : OpenAPI ID
	private List<String> delRev;    		// 목록의 체크박스 Rev : couchDB 문서 Reversion

	private List<CnvrRule> cnvrRules;		// 변환룰 List
	private List<ReqParam> reqParams;		// 요청파라미터 List
	private List<RspnsResult> rspnsResults;	// 응답결과 List

	private String apiVerNm;				// api버전 명
	private String methodNm;    			// method 명
	private String stackClNm;    			// 스택분류 명

	/**
	 * @return the delKey
	 */
	public List<String> getDelKey() {
		return delKey;
	}
	/**
	 * @param delKey the delKey to set
	 */
	public void setDelKey(List<String> delKey) {
		this.delKey = delKey;
	}
	/**
	 * @return the delRev
	 */
	public List<String> getDelRev() {
		return delRev;
	}
	/**
	 * @param delRev the delRev to set
	 */
	public void setDelRev(List<String> delRev) {
		this.delRev = delRev;
	}
	/**
	 * @return the cnvrRules
	 */
	public List<CnvrRule> getCnvrRules() {
		return cnvrRules;
	}
	/**
	 * @param cnvrRules the cnvrRules to set
	 */
	public void setCnvrRules(List<CnvrRule> cnvrRules) {
		this.cnvrRules = cnvrRules;
	}
	/**
	 * @return the reqParams
	 */
	public List<ReqParam> getReqParams() {
		return reqParams;
	}
	/**
	 * @param reqParams the reqParams to set
	 */
	public void setReqParams(List<ReqParam> reqParams) {
		this.reqParams = reqParams;
	}
	/**
	 * @return the rspnsResults
	 */
	public List<RspnsResult> getRspnsResults() {
		return rspnsResults;
	}
	/**
	 * @param rspnsResults the rspnsResults to set
	 */
	public void setRspnsResults(List<RspnsResult> rspnsResults) {
		this.rspnsResults = rspnsResults;
	}
	/**
	 * @return the apiVerNm
	 */
	public String getApiVerNm() {
		return apiVerNm;
	}
	/**
	 * @param apiVerNm the apiVerNm to set
	 */
	public void setApiVerNm(String apiVerNm) {
		this.apiVerNm = apiVerNm;
	}
	/**
	 * @return the methodNm
	 */
	public String getMethodNm() {
		return methodNm;
	}
	/**
	 * @param methodNm the methodNm to set
	 */
	public void setMethodNm(String methodNm) {
		this.methodNm = methodNm;
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

}
