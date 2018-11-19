/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmnCouchVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity.couch;

/**
 * @author 박봉춘
 *
 */
public class CmnCouchVo {

	/**
	 * _id : couchDB ID(key)
	 */
	private String _id;

	/**
	 * 카우치 DB 문서 버전
	 */
	private String _rev;

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * @return the _rev
	 */
	public String get_rev() {
		return _rev;
	}

	/**
	 * @param _rev the _rev to set
	 */
	public void set_rev(String _rev) {
		this._rev = _rev;
	}

}
