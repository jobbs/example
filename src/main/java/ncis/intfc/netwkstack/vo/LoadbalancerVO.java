/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LoadbalancerVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.netwkstack.vo;


/**
 * @author ShinKeeBong
 *
 */
public class LoadbalancerVO {

    private String id;                           //LB ID
//    private String vip;                   //가상 IP 주소
    private ListenerVO listener;           //리스너
    private PoolVO pool;                   //멤버풀
    private HealthMonitorVO healthMonitor; //헬스모니터

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getVip() {
//		return vip;
//	}
//	public void setVip(String vip) {
//		this.vip = vip;
//	}
	public ListenerVO getListener() {
		return listener;
	}
	public void setListener(ListenerVO listener) {
		this.listener = listener;
	}
	public PoolVO getPool() {
		return pool;
	}
	public void setPool(PoolVO pool) {
		this.pool = pool;
	}
	public HealthMonitorVO getHealthMonitor() {
		return healthMonitor;
	}
	public void setHealthMonitor(HealthMonitorVO healthMonitor) {
		this.healthMonitor = healthMonitor;
	}



}
