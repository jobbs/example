/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UseReqService.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.req.service;

import ncis.api.gw.user.vo.UserMngVo;

/**
 * @author 박희택
 *
 */
public interface UseReqService {

	/**
	 * gateway 사용 등록
	 * @param userMngVo ApiGwUser 내용
	 */
	void insertUseReq(UserMngVo rserMngVo) throws Exception;

}
