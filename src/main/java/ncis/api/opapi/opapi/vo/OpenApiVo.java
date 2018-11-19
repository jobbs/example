/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiVo.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
 */
package ncis.api.opapi.opapi.vo;

import java.util.List;

import ncis.cmn.entity.OpenApi;

/**
 * @author 박희택
 *
 */
public class OpenApiVo extends OpenApi {

	private List<String> delKey;	// 목록의 체크박스 Key : OpenAPI ID
	private List<String> delRev;    // 목록의 체크박스 Rev : couchDB 문서 Reversion
	private String regionNm;

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

}
