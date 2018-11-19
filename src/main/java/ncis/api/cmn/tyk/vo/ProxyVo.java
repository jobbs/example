/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProxyVo.java
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
public class ProxyVo {
	private boolean preserve_host_header=true;
	private String listen_path;
	private String target_url;
	private boolean strip_listen_path=true;
	private boolean enable_load_balancing;
	private List<String> target_list;
	private boolean check_host_against_uptime_tests;
	private ServiceDiscoveryVo service_discovery;
	/**
	 * @return the preserve_host_header
	 */
	public boolean isPreserve_host_header() {
		return preserve_host_header;
	}
	/**
	 * @param preserve_host_header the preserve_host_header to set
	 */
	public void setPreserve_host_header(boolean preserve_host_header) {
		this.preserve_host_header = preserve_host_header;
	}
	/**
	 * @return the listen_path
	 */
	public String getListen_path() {
		return listen_path;
	}
	/**
	 * @param listen_path the listen_path to set
	 */
	public void setListen_path(String listen_path) {
		this.listen_path = listen_path;
	}
	/**
	 * @return the target_url
	 */
	public String getTarget_url() {
		return target_url;
	}
	/**
	 * @param target_url the target_url to set
	 */
	public void setTarget_url(String target_url) {
		this.target_url = target_url;
	}
	/**
	 * @return the strip_listen_path
	 */
	public boolean isStrip_listen_path() {
		return strip_listen_path;
	}
	/**
	 * @param strip_listen_path the strip_listen_path to set
	 */
	public void setStrip_listen_path(boolean strip_listen_path) {
		this.strip_listen_path = strip_listen_path;
	}
	/**
	 * @return the enable_load_balancing
	 */
	public boolean isEnable_load_balancing() {
		return enable_load_balancing;
	}
	/**
	 * @param enable_load_balancing the enable_load_balancing to set
	 */
	public void setEnable_load_balancing(boolean enable_load_balancing) {
		this.enable_load_balancing = enable_load_balancing;
	}
	/**
	 * @return the target_list
	 */
	public List<String> getTarget_list() {
		return target_list;
	}
	/**
	 * @param target_list the target_list to set
	 */
	public void setTarget_list(List<String> target_list) {
		this.target_list = target_list;
	}
	/**
	 * @return the check_host_against_uptime_tests
	 */
	public boolean isCheck_host_against_uptime_tests() {
		return check_host_against_uptime_tests;
	}
	/**
	 * @param check_host_against_uptime_tests the check_host_against_uptime_tests to set
	 */
	public void setCheck_host_against_uptime_tests(
			boolean check_host_against_uptime_tests) {
		this.check_host_against_uptime_tests = check_host_against_uptime_tests;
	}
	/**
	 * @return the service_discovery
	 */
	public ServiceDiscoveryVo getService_discovery() {
		return service_discovery;
	}
	/**
	 * @param service_discovery the service_discovery to set
	 */
	public void setService_discovery(ServiceDiscoveryVo service_discovery) {
		this.service_discovery = service_discovery;
	}
}
