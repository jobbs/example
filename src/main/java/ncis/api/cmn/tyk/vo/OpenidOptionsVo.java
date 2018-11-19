/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename openid_optionsVo.java
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

import java.util.List;

/**
 * @author 이제율
 *
 */
public class OpenidOptionsVo {
	private List<String> providers;
	private boolean segregate_by_client = false;
	/**
	 * @return the providers
	 */
	public List<String> getProviders() {
		return providers;
	}
	/**
	 * @param providers the providers to set
	 */
	public void setProviders(List<String> providers) {
		this.providers = providers;
	}
	/**
	 * @return the segregate_by_client
	 */
	public boolean isSegregate_by_client() {
		return segregate_by_client;
	}
	/**
	 * @param segregate_by_client the segregate_by_client to set
	 */
	public void setSegregate_by_client(boolean segregate_by_client) {
		this.segregate_by_client = segregate_by_client;
	}
}
