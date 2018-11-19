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
package ncis.intfc.vmintfc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.pmintfc.service.impl.PmIntfcServiceImpl;
import ncis.intfc.vmintfc.service.VmIntfcService;
import ncis.intfc.vmintfc.vo.DisplayVO;
import ncis.intfc.vmintfc.vo.GraphicConsoleResultBodyVO;
import ncis.intfc.vmintfc.vo.ProxyTicketVO;
import ncis.intfc.vmintfc.vo.TicketVO;
import ncis.intfc.vmintfc.vo.VmCtrlEmptyBodyVO;
import ncis.intfc.vmintfc.vo.VmCtrlResultBodyVO;
import ncis.intfc.vmintfc.vo.VmCtrlStartBodyVO;
import ncis.intfc.vmintfc.vo.VmDetailResultBodyVO;
import ncis.intfc.vmintfc.vo.VmInfoVO;
import ncis.intfc.vmintfc.vo.VmStatusResultBodyVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author ShinKeeBong
 *
 */
@Service("vmIntfcService")
public class VmIntfcServiceImpl implements VmIntfcService {

	private final Logger logger = LoggerFactory.getLogger(PmIntfcServiceImpl.class);

	@Resource(name="restSender") private RestSender restSender;

	/**
	 * 가상서버 시작
	 * @param uuid
	 * @param headers
	 * @param vo
	 * @return
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * Body	    useCloudInit	   cloud-init 사용여부	                      Boolean		Y
	 * Body	    hostName	       CloudInit 설정 Guest OS 호스트네임	      String		N
	 * Body	    dnsServers	       CloudInit 설정 Guest OS 도메인 서버	      String		N
	 * Body	    nicConfigurations  CloudInit 설정 Guest OS 네트워크 설정 정보 Collection	N
	 * Body	       name	           CloudInit 설정 Guest OS NIC 이름	          String		N
	 * Body	       ip	           CloudInit 설정 Guest OS IP주소	          String		N
	 * Body	       netmask	       CloudInit 설정 Guest OS Net Mask	          String		N
	 * Body	       gateway	       CloudInit 설정 Guest OS 게이트웨이 주소	  String		N
	 * Body	       bootProtocol	   CloudInit 설정 Guest OS IP 할당 유형	      String		N
	 * Body	       onBoot	       CloudInit 설정 Guest OS 부팅시 시작 설정	  Boolean		N
	 * Body	    customScript	   사용자 스크립트	                          String		N
	 *
	 */
	@Override
	public VmCtrlResultBodyVO start(String uuid, RestHeaders headers, VmCtrlStartBodyVO bodyVo) throws Exception {

		try {
			String url = "/machines/"+uuid;
			headers.setAction("start");
			if(bodyVo == null)
			{
			    bodyVo = new VmCtrlStartBodyVO();
			    bodyVo.setUseCloudInit(false);
			}
			return restSender.send(url, bodyVo, headers, VmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
	}

	/**
	 * 가상서버 강제종료
	 * @param uuid
	 * @param headers
	 * @return
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 */
	@Override
	public VmCtrlResultBodyVO shutdown(String uuid, RestHeaders headers) throws Exception {

		String url = "/machines/"+uuid;
		headers.setAction("shutdown");
		VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
		emptyVO.setEmpty(" ");
		return restSender.send(url, emptyVO, headers, VmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
	}

	/**
	 * 가상서버 정지
	 * @param uuid
	 * @param headers
	 * @return
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 */
	@Override
	public VmCtrlResultBodyVO stop(String uuid, RestHeaders headers) throws Exception {

		String url = "/machines/"+uuid;
		headers.setAction("stop");
		VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
        emptyVO.setEmpty(" ");
		return restSender.send(url, emptyVO, headers, VmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
	}


	/**
	 * 가상서버 재시작
	 * @param uuid
	 * @param headers
	 * @return
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 */
	@Override
	public VmCtrlResultBodyVO restart(String uuid, RestHeaders headers) throws Exception {

		String url = "/machines/"+uuid;
		headers.setAction("restart");
		VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
        emptyVO.setEmpty(" ");
		return restSender.send(url, emptyVO, headers, VmCtrlResultBodyVO.class, HttpMethod.POST).getBody();
	}


	/**
	 * 가상서버 상태조회
	 * @param uuid
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 *   id    가상 서버ID
	 *   name  가상 서버명
	 *   state 상태
	 *              unassigned/down/up/powering_up/paused/migrating/unknown/
     *              not_responding/wait_for_launch/reboot_in_progress/saving_state/
     *              restoring_state/suspended/image_locked/powering_down
	 */
	public VmStatusResultBodyVO status(String uuid, RestHeaders headers) throws Exception {

		String url = "/machines/" + uuid + "/status";
		headers.setSeq(" ");
		return restSender.send(url, headers, VmStatusResultBodyVO.class, HttpMethod.GET).getBody();
	}


	/**
	 * 가상서버 상세조회
	 * @param uuid
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 *    가상서버 상세 정보
	 */
	public VmDetailResultBodyVO selectVmDetail(String uuid, RestHeaders headers) throws Exception {

		String url = "/machines/" + uuid;
		headers.setSeq(" ");
		return restSender.send(url, headers, VmDetailResultBodyVO.class, HttpMethod.GET).getBody();
	}

	/**
	 * 가상서버 삭제
	 * @param uuid
	 * @param headers
	 * @return
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 */
	@Override
	public VmCtrlResultBodyVO delete(String uuid, RestHeaders headers) throws Exception {

		try {
			String url = "/machines/"+uuid;
			VmCtrlEmptyBodyVO emptyVO = new VmCtrlEmptyBodyVO();
	        emptyVO.setEmpty(" ");
			return restSender.send(url, emptyVO, headers, VmCtrlResultBodyVO.class, HttpMethod.DELETE).getBody();
		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
	}



	/**
	 * 가상서버 콘솔용 Ticket 정보조회
	 * @param uuid
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          vmid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public String selectTicket4VmConsole(String vmid, RestHeaders headers)
			throws Exception {

		String url = "/machines/" + vmid + "/ticket";

		return restSender.send(url, headers, TicketVO.class, HttpMethod.POST).getBody().getTicket();
	}

	/**
	 * 그래픽 콘솔 정보조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	@Override
	public GraphicConsoleResultBodyVO selectGraphicsConsoles(String vmid, RestHeaders headers) throws Exception {

		String url = "/machines/" + vmid + "/graphicsconsoles";

		headers.setSeq(" ");
		return restSender.send(url, headers, GraphicConsoleResultBodyVO.class, HttpMethod.GET).getBody();
	}

	/**
	 * 프락시티켓 정보조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	@Override
	public String selectProxyTicket(String vmid, String graphicConsoleId, RestHeaders headers) throws Exception {

		String url = "/machines/" + vmid + "/graphicsconsoles/" + graphicConsoleId + "/proxyticket";

		return restSender.send(url, headers, ProxyTicketVO.class, HttpMethod.POST).getBody().getProxyTicket();

	}

	/**
	 * 가상서버 콘솔 접속정보 요청
	 * @param uuid
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * ------------------------------------------------------------------------------------------
	 *          uuid               가상서버 UUID
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public List<DisplayVO> requestConsoleConnectionInfo(String uuid,
			RestHeaders headers) throws Exception {

		String url = "/machines/" + uuid;

		headers.setSeq(" ");
		return restSender.send(url, headers, VmInfoVO.class, HttpMethod.GET).getBody().getDisplay();

	}

}
