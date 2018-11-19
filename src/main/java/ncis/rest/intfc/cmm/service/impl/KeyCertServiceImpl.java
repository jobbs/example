/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename KeyCertServiceImpl.java
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
package ncis.rest.intfc.cmm.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;

import ncis.rest.intfc.cmm.dao.KeyCertDao;
import ncis.rest.intfc.cmm.service.KeyCertService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 접근키 인증 Service Implement
 *
 * @author ShinKeeBong
 *
 */

@Service("keyCertService")
public class KeyCertServiceImpl implements KeyCertService {

    private final Logger logger = LoggerFactory.getLogger(KeyCertServiceImpl.class);

	@Resource(name="keyCertDao")
	private KeyCertDao keyCertDao;

	/**
	 * 접근키에 대한 유효성 체크
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public Boolean isCertifiedKey(String key) throws UnsupportedEncodingException {


		try {
			key = URLEncoder.encode(key, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			//e.printStackTrace();
			logger.error(e.getMessage(), e);
		}


		String decodedKey = null;

		try {
			decodedKey = URLDecoder.decode(key, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			throw e;
		}

		return keyCertDao.isCertifiedKey(decodedKey);
	}

}
