/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomMultipartResolver.java
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
package ncis.cmn.webconfig.multipart;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author 최진호
 *
 */
public class CustomMultipartResolver extends CommonsMultipartResolver {

	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request)
			throws MultipartException {

		try {
			return super.parseRequest(request);
		} catch (MultipartException e) {
			request.setAttribute("MaxUPloadSizeExceededException", e);
			return parseFileItems(Collections.<FileItem> emptyList(), null);
		}

	}
}
