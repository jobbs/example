/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NotificationsVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     이제율        	 v1.0    	         최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

/**
 * @author 이제율
 *
 */
public class NotificationsVo {
	private String shared_secret;
	private String oauth_on_keychange_url;
	/**
	 * @return the shared_secret
	 */
	public String getShared_secret() {
		return shared_secret;
	}
	/**
	 * @param shared_secret the shared_secret to set
	 */
	public void setShared_secret(String shared_secret) {
		this.shared_secret = shared_secret;
	}
	/**
	 * @return the oauth_on_keychange_url
	 */
	public String getOauth_on_keychange_url() {
		return oauth_on_keychange_url;
	}
	/**
	 * @param oauth_on_keychange_url the oauth_on_keychange_url to set
	 */
	public void setOauth_on_keychange_url(String oauth_on_keychange_url) {
		this.oauth_on_keychange_url = oauth_on_keychange_url;
	}
}
