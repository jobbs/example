/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename HealthMonitorVO.java
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
public class HealthMonitorVO {

    private String type;      //헬스체크 타입
    private int delay;       //헬스체크 주기
    private int timeOut;     //헬스체크 타임아웃
    private int maxRetries;  //헬스체크 최대재시도 수
    private String urlPath;   //헬스체크 URI 경로


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public int getMaxRetries() {
		return maxRetries;
	}
	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}


}
