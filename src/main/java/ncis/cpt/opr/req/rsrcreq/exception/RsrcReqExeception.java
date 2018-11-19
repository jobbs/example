/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqExeception.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 11. 9.
 * @lastmodified 2016. 11. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 9.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.exception;

/**
 * 자원요청 예외 Class
 * @author 김봉민
 *
 */
@SuppressWarnings("serial")
public class RsrcReqExeception extends Exception {

	public RsrcReqExeception() {
		super();
	}
	public RsrcReqExeception(String message){
		super(message);
	}

	public RsrcReqExeception(Throwable t){
		super(t);
	}
	public RsrcReqExeception(String messsage, Throwable t){
		super(messsage, t);
	}
}
