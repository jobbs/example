/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestServiceImpl.java
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
package ncis.cmn.rest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ncis.cmn.rest.dao.RestDao;
import ncis.cmn.rest.service.RestService;
import ncis.cmn.rest.vo.RestInfo;

@Service("restService")
public class RestServiceImpl implements RestService {

	@Resource(name="restDao") private RestDao restDao;

	@Override
	public RestInfo selectConnectInfo(String regionId) {
		return restDao.selectConnectInfo(regionId);
	}

}
