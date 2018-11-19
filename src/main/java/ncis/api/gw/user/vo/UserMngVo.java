/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename userMngVo.java
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
package ncis.api.gw.user.vo;

import java.util.List;

import ncis.cmn.entity.Api;
import ncis.cmn.entity.ApiGwUser;
import ncis.cmn.entity.ReqstHistry;

/**
 * @author 박희택
 *
 */
public class UserMngVo extends ApiGwUser {

	private List<ReqstHistry> reqHistry;	// 신청이력리스트
	private String sysNm;					// 시스템명
	private String statNm;					// 상태명
	private String regionNm;
	private List<String> delKey;			// 목록의 체크박스 Key : OpenAPI ID
	private List<String> delRev;  	  		// 목록의 체크박스 Rev : couchDB 문서 Reversion
	private List<Api> apis;					// API List
	/**
	 * @return the reqHistry
	 */
	public List<ReqstHistry> getReqHistry() {
		return reqHistry;
	}
	/**
	 * @param reqHistry the reqHistry to set
	 */
	public void setReqHistry(List<ReqstHistry> reqHistry) {
		this.reqHistry = reqHistry;
	}
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
	 * @return the statNm
	 */
	public String getStatNm() {
		return statNm;
	}
	/**
	 * @param statNm the statNm to set
	 */
	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}
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
	 * @return the apis
	 */
	public List<Api> getApis() {
		return apis;
	}
	/**
	 * @param apis the apis to set
	 */
	public void setApis(List<Api> apis) {
		this.apis = apis;
	}

}
