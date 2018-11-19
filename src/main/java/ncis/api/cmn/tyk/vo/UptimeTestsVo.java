/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UptimeTestsVo.java
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
public class UptimeTestsVo {
	private List<String> check_list;
	private ConfigVo config;
	/**
	 * @return the check_list
	 */
	public List<String> getCheck_list() {
		return check_list;
	}
	/**
	 * @param check_list the check_list to set
	 */
	public void setCheck_list(List<String> check_list) {
		this.check_list = check_list;
	}
	/**
	 * @return the config
	 */
	public ConfigVo getConfig() {
		return config;
	}
	/**
	 * @param config the config to set
	 */
	public void setConfig(ConfigVo config) {
		this.config = config;
	}
}
