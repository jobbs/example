/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestService.java
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
package ncis.cmn.rest.service;

import ncis.cmn.rest.vo.RestInfo;


/**
 * @author selim
 *
 */
public interface RestService {

    /**
     *
     * @param regionId
     * @return
     */
	RestInfo selectConnectInfo(String regionId);

}
