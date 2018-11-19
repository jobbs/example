/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomControllerInterceptor.java
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
package ncis.cmn.webconfig.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.UploadFileSizeExceededException;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author 최진호
 *
 */
public class CustomControllerInterceptor extends HandlerInterceptorAdapter {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// CustomMultipartResolver 에서 체크된 첨부파일 최대 용량 체크하여 Exception 처리
		if( null != request.getAttribute("MaxUPloadSizeExceededException") ) {
			MaxUploadSizeExceededException muse = (MaxUploadSizeExceededException) request.getAttribute("MaxUPloadSizeExceededException");
			throw new UploadFileSizeExceededException(muse.getMaxUploadSize());
    	}

        return true;
    }
}
