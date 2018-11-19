/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MessageUtil.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Component
public class MessageUtil {

	@Resource
	private MessageSource messageSource;

	/** <pre>
	 * Errors 에 담긴 에러에 대한 메시지 정보 목록을 리턴한다.
	 * </pre>
	 *
	 * @param errors
	 * @return
	 */
	public List<String> getFieldErrorMessageList(
			Errors errors){
		List<String> errMessage = new ArrayList<String>();
		for(FieldError err: errors.getFieldErrors()){
			errMessage.add(messageSource.getMessage(err, Locale.getDefault()));
		}
		return errMessage;
	}

	/** <pre>
	 * 해당 코드에 대한 메시지를 리턴한다.
	 * </pre>
	 *
	 * @param code
	 * @param locale
	 * @return
	 */
	public String getMessage(String code, Locale locale){
		return messageSource.getMessage(code, null, locale);
	}

	/** <pre>
	 * 해당 코드에 대한 메시지를 리턴한다.
	 * </pre>
	 *
	 * @param code
	 * @return
	 */
	public String getMessage(String code){
		return getMessage(code, Locale.KOREA);
	}

	/** <pre>해당 코드에 대한 메시지를 리턴한다.</pre>
	 *
	 * @param code
	 * @param args
	 * @param locale
	 * @return
	 */
	public String getMessage(String code, Object[] args, Locale locale){
		return messageSource.getMessage(code, args, locale);
	}

	public String getMessage(String code, Object[] args){
		return messageSource.getMessage(code, args, Locale.KOREA);
	}
}
