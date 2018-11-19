/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ConfigVo.java
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
 * 2016. 10. 31.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

/**
 * @author 이제율
 *
 */
public class ConfigVo {
	private Integer expire_utime_after = 0;
	private ServiceDiscoveryVo service_discovery;
	private Integer recheck_wait;
	/**
	 * @return the expire_utime_after
	 */
	public Integer getExpire_utime_after() {
		return expire_utime_after;
	}
	/**
	 * @param expire_utime_after the expire_utime_after to set
	 */
	public void setExpire_utime_after(Integer expire_utime_after) {
		this.expire_utime_after = expire_utime_after;
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
	/**
	 * @return the recheck_wait
	 */
	public Integer getRecheck_wait() {
		return recheck_wait;
	}
	/**
	 * @param recheck_wait the recheck_wait to set
	 */
	public void setRecheck_wait(Integer recheck_wait) {
		this.recheck_wait = recheck_wait;
	}
}
