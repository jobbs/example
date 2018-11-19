/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AuthrVo.java
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
package ncis.api.opapi.authr.vo;

import java.util.List;

import ncis.cmn.entity.Authr;

/**
 * @author 박희택
 *
 */
public class AuthrVo extends Authr{

	private List<String> delKey;	// 목록의 체크박스 Key : OpenAPI ID
	private List<String> delRev;    // 목록의 체크박스 Rev : couchDB 문서 Reversion

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

}
