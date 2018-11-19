/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DownFileNotFoundException.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.exception;


/**
 * <pre></pre>
 *
 * @author kamsi76
 *
 */
@SuppressWarnings("serial")
public class DownFileNotFoundException extends RuntimeException {

	public DownFileNotFoundException(String message) {
		super(message);
	}

}
