/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SoftwareVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;


/**
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class SoftwareVO {

	private Integer swId;        /* 소프트웨어 일련번호 */
	private String swName;       /* 소프트웨어 명       */
	private String swVersion;    /* 소프트웨어 버전     */


	public Integer getSwId() {
		return swId;
	}
	public void setSwId(Integer swId) {
		this.swId = swId;
	}
	public String getSwName() {
		return swName;
	}
	public void setSwName(String swName) {
		this.swName = swName;
	}
	public String getSwVersion() {
		return swVersion;
	}
	public void setSwVersion(String swVersion) {
		this.swVersion = swVersion;
	}


}
