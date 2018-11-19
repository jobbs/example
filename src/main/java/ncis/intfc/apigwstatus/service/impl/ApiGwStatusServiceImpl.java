/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ApiGwStatusServiceImpl.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * ---------------------------------------------------------------------
 * 		Date         	author           ver            Description
 * ---------------------------------------------------------------------
 * 2016. 10. 28.     ShinKeeBong         v1.0			    최초생성
 * 2016. 12. 09.     	정승용         		 v1.1		 스택 매니저 상태/삭제 호출
 *
 */
package ncis.intfc.apigwstatus.service.impl;

import javax.annotation.Resource;

import ncis.api.stack.mngr.vo.MngrVo;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.apigwstatus.service.ApiGwStatusService;
import ncis.intfc.apigwstatus.vo.ResultHealthCheckVO;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author ShinKeeBong
 *
 */
@Service("apiGwStatusService")
public class ApiGwStatusServiceImpl implements ApiGwStatusService {

    @Resource(name="restSender") private RestSender restSender;

	/**
	 * api-gatway 상태 조회
	 * @param headers
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * @return
	 */
	@Override
	public ResultHealthCheckVO healthCheck(RestHeaders headers)
			throws Exception {

		String url = "/healthcheck";

		headers.setSeq(" ");
		return restSender.send(url, headers, ResultHealthCheckVO.class, HttpMethod.GET).getBody();
	}

	/**
	 * 매니저 상태 호출
     * @param headers
     * @return
     */
	@Override
	public MngrVo mngrHealthCheck(RestHeaders headers)
			throws Exception {

		String url = "/manager/health";

		headers.setSeq(" ");
		return restSender.send(url, headers, MngrVo.class, HttpMethod.GET).getBody();
	}

	/**
	 * 매니저 삭제 호출
     * @param headers
     * @return
     */
	@Override
	public MngrVo mngrDeleteCheck(RestHeaders headers)
			throws Exception {

		String url = "/manager";

		headers.setSeq(" ");
		return restSender.send(url, headers, MngrVo.class, HttpMethod.DELETE).getBody();

	}

}
