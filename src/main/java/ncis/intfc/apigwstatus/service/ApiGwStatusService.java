/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ApiGwStatusService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * ---------------------------------------------------------------------
 * 		Date         	author         	  ver            Description
 * ---------------------------------------------------------------------
 * 2016. 10. 28.     ShinKeeBong         v1.0               최초생성
 * 2016. 12. 09.     	정승용         		 v1.1			  스택 매니저 호출
 *
 */
package ncis.intfc.apigwstatus.service;

import ncis.api.stack.mngr.vo.MngrVo;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.apigwstatus.vo.ResultHealthCheckVO;

/**
 * @author ShinKeeBong
 *
 */
public interface ApiGwStatusService {

	/**
	 * api-gatway 상태 조회
	 * @param headers
	 * @return
	 */
	ResultHealthCheckVO healthCheck(RestHeaders headers) throws Exception;

	/**
	 * 매니저 상태 호출
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	MngrVo mngrHealthCheck(RestHeaders headers) throws Exception;

	/**
	 * 매니저 삭제 호출
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	MngrVo mngrDeleteCheck(RestHeaders headers) throws Exception;

}
