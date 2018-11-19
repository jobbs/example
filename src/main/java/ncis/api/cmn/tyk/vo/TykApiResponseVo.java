/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykApiResponseVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 11. 1.
 * @lastmodified 2016. 11. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 1.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

/**
 * @author 이제율
 *
 */
public class TykApiResponseVo {
	private String status;
	private String error;
	private String key;

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
