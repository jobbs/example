/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqVmConsoleTokenServiceImpl.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.pmintfc.service.impl;

import javax.annotation.Resource;

import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.pmintfc.service.PmIntfcService;
import ncis.intfc.pmintfc.vo.PmCtrlResultBodyVO;
import ncis.intfc.pmintfc.vo.PmStatusResultBodyVO;
import ncis.intfc.vmintfc.vo.VmCtrlEmptyBodyVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author ShinKeeBong
 *
 */
@Service("pmIntfcService")
public class PmIntfcServiceImpl implements PmIntfcService {

	private final Logger logger = LoggerFactory.getLogger(PmIntfcServiceImpl.class);

	@Resource(name="restSender") private RestSender restSender;

	/* 물리서버 확성화 ACTION uri*/
	private static String PHYSICAL_SERVER_ACTIVE = "activate";


	/* 물리서버 비확성화 ACTION uri */
	private static String PHYSICAL_SERVER_DEACTIVE = "deactivate";


	/**
	 *
	 * 	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *     uuid               물리서버  UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * */
	@Override
	public PmCtrlResultBodyVO active(String uuid, RestHeaders headers)
			throws Exception {

		try {
			String url = "/physicalServers/"+uuid;
			headers.setAction(PHYSICAL_SERVER_ACTIVE);
			VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
			emptyVO.setEmpty(" ");
			return restSender.send(url, emptyVO, headers, PmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}

	}



	/**
	 *
	 * 	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *     uuid               물리서버  UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * */
	@Override
	public PmCtrlResultBodyVO deactive(String uuid, RestHeaders headers)
			throws Exception {
		try {
			String url = "/physicalServers/"+uuid;
			headers.setAction(PHYSICAL_SERVER_DEACTIVE);
			VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
			emptyVO.setEmpty(" ");
			return restSender.send(url, emptyVO, headers, PmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
	}

	/**
	 * 물리서버 상태 조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	@Override
	public PmStatusResultBodyVO status(String uuid, RestHeaders headers) throws Exception
	{
		try {
			String url = "/physicalServers/"+uuid;
			VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
			emptyVO.setEmpty(" ");
			return restSender.send(url, emptyVO, headers, PmStatusResultBodyVO.class, HttpMethod.GET).getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
	}
}
