/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ServiceDiscoveryVo.java
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
public class ServiceDiscoveryVo {
	private boolean use_discovery_service = false;
	private String query_endpoint;
	private boolean use_nested_query = false;
	private String parent_data_path = "application.instance";
	private String data_path = "hostName";
	private String port_data_path = "port.$";
	private String target_path;
	private boolean use_target_list = true;
	private Integer cache_timeout = 60;
	private boolean endpoint_returns_list = false;
	/**
	 * @return the use_discovery_service
	 */
	public boolean isUse_discovery_service() {
		return use_discovery_service;
	}
	/**
	 * @param use_discovery_service the use_discovery_service to set
	 */
	public void setUse_discovery_service(boolean use_discovery_service) {
		this.use_discovery_service = use_discovery_service;
	}
	/**
	 * @return the query_endpoint
	 */
	public String getQuery_endpoint() {
		return query_endpoint;
	}
	/**
	 * @param query_endpoint the query_endpoint to set
	 */
	public void setQuery_endpoint(String query_endpoint) {
		this.query_endpoint = query_endpoint;
	}
	/**
	 * @return the use_nested_query
	 */
	public boolean isUse_nested_query() {
		return use_nested_query;
	}
	/**
	 * @param use_nested_query the use_nested_query to set
	 */
	public void setUse_nested_query(boolean use_nested_query) {
		this.use_nested_query = use_nested_query;
	}
	/**
	 * @return the parent_data_path
	 */
	public String getParent_data_path() {
		return parent_data_path;
	}
	/**
	 * @param parent_data_path the parent_data_path to set
	 */
	public void setParent_data_path(String parent_data_path) {
		this.parent_data_path = parent_data_path;
	}
	/**
	 * @return the data_path
	 */
	public String getData_path() {
		return data_path;
	}
	/**
	 * @param data_path the data_path to set
	 */
	public void setData_path(String data_path) {
		this.data_path = data_path;
	}
	/**
	 * @return the port_data_path
	 */
	public String getPort_data_path() {
		return port_data_path;
	}
	/**
	 * @param port_data_path the port_data_path to set
	 */
	public void setPort_data_path(String port_data_path) {
		this.port_data_path = port_data_path;
	}
	/**
	 * @return the target_path
	 */
	public String getTarget_path() {
		return target_path;
	}
	/**
	 * @param target_path the target_path to set
	 */
	public void setTarget_path(String target_path) {
		this.target_path = target_path;
	}
	/**
	 * @return the use_target_list
	 */
	public boolean isUse_target_list() {
		return use_target_list;
	}
	/**
	 * @param use_target_list the use_target_list to set
	 */
	public void setUse_target_list(boolean use_target_list) {
		this.use_target_list = use_target_list;
	}
	/**
	 * @return the cache_timeout
	 */
	public Integer getCache_timeout() {
		return cache_timeout;
	}
	/**
	 * @param cache_timeout the cache_timeout to set
	 */
	public void setCache_timeout(Integer cache_timeout) {
		this.cache_timeout = cache_timeout;
	}
	/**
	 * @return the endpoint_returns_list
	 */
	public boolean isEndpoint_returns_list() {
		return endpoint_returns_list;
	}
	/**
	 * @param endpoint_returns_list the endpoint_returns_list to set
	 */
	public void setEndpoint_returns_list(boolean endpoint_returns_list) {
		this.endpoint_returns_list = endpoint_returns_list;
	}
}
