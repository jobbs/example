/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SessionPersistenceVO.java
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
public class SessionPersistenceVO {

    private String type;        //세션유지 방법의 타입
    private String cookieName;  //쿠키명


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}


}
