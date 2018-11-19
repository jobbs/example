/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NotAllowedFileExtException.java
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
public class NotAllowedFileExtException extends RuntimeException {

	private String allowedExt;

	private String message;

	public NotAllowedFileExtException(String allowedExt) {
		this.allowedExt = allowedExt;
		setMessage("");
	}

	public NotAllowedFileExtException(String msg, String allowedExt) {
		this.allowedExt = allowedExt;
		setMessage(msg);
    }

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {

        if( null != message && !"".equals(message) ) {
			this.message = message;
		} else {
			this.message = "허용하지 않는 확장자 입니다.<br />허용확장자 [" + allowedExt.replaceAll("\\|", ", ") + "]";
		}
	}

}
