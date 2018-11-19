/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UploadFileSizeExceededException.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 11. 24.
 * @lastmodified 2016. 11. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.exception;

import java.text.DecimalFormat;

/**
 * @author 최진호
 *
 */
@SuppressWarnings("serial")
public class UploadFileSizeExceededException extends RuntimeException {

	private Long maxFileSize;

	private String message;

	public UploadFileSizeExceededException(Long maxFileSize) {
		this.maxFileSize = maxFileSize;
		setMessage("");

	}

	public UploadFileSizeExceededException(String msg, Long maxFileSize) {
		this.maxFileSize = maxFileSize;
		setMessage(msg);
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {

		if( null != message && !"".equals(message)) {
			this.message = message;
		} else {
			DecimalFormat df = new DecimalFormat("#,###");
			String strMaxFileSize = df.format(maxFileSize / 1024);
			this.message = "첨부파일 용량을 초과 하였습니다.<br />첨부파일 최대 용량은 " + strMaxFileSize + "KB 입니다.";
		}
	}

}
