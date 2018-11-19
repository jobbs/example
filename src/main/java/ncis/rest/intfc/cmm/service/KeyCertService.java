/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename KeyCertService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.cmm.service;

import java.io.UnsupportedEncodingException;

/**
 * 접근키 인증 Service
 *
 * @author ShinKeeBong
 *
 */
public interface KeyCertService {


	/**
	 * 접근키에 대한 유효성 체크
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	Boolean isCertifiedKey(String key) throws UnsupportedEncodingException;

}
