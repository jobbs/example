/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResultHealthCheckVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.apigwstatus.vo;

/**
 * @author ShinKeeBong
 *
 */
public class ResultHealthCheckVO {

	private String condition;  //상태

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}


}
