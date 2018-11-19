/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqVmConsoleTokenService.java
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
package ncis.intfc.vmintfc.service;

import java.util.List;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.vmintfc.vo.DisplayVO;
import ncis.intfc.vmintfc.vo.GraphicConsoleResultBodyVO;
import ncis.intfc.vmintfc.vo.VmCtrlResultBodyVO;
import ncis.intfc.vmintfc.vo.VmCtrlStartBodyVO;
import ncis.intfc.vmintfc.vo.VmDetailResultBodyVO;
import ncis.intfc.vmintfc.vo.VmStatusResultBodyVO;

/**
 * @author ShinKeeBong
 *
 */
public interface VmIntfcService {

	/**
	 * 가상서버 시작
	 * @param uuid
	 * @param header
	 * @param bodyVo
	 * @return
	 */
	VmCtrlResultBodyVO start(String uuid, RestHeaders headers, VmCtrlStartBodyVO bodyVo) throws Exception;

	/**
	 * 가상서버 강제종료
	 * @param uuid
	 * @param header
	 * @return
	 */
	VmCtrlResultBodyVO shutdown(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 정지
	 * @param uuid
	 * @param header
	 * @return
	 */
	VmCtrlResultBodyVO stop(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 재시작
	 * @param uuid
	 * @param header
	 * @return
	 */
	VmCtrlResultBodyVO restart(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 상태조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	VmStatusResultBodyVO status(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 상태조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	VmDetailResultBodyVO selectVmDetail(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 삭제
	 * @param uuid
	 * @param header
	 * @param bodyVo
	 * @return
	 */
	VmCtrlResultBodyVO delete(String uuid, RestHeaders headers) throws Exception;


	/**
	 * 가상서버 콘솔용 Ticket 정보조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	String selectTicket4VmConsole(String vmid, RestHeaders headers) throws Exception;

	/**
	 * 그래픽 콘솔 정보조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	GraphicConsoleResultBodyVO selectGraphicsConsoles(String vmid, RestHeaders headers) throws Exception;

	/**
	 * 프락시티켓 정보조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	String selectProxyTicket(String vmid, String graphicConsoleId, RestHeaders headers) throws Exception;


	/**
	 * 가상서버 콘솔 접속정보 요청
	 * @param uuid
	 * @param header
	 * @return
	 */
	List<DisplayVO> requestConsoleConnectionInfo(String uuid, RestHeaders headers) throws Exception;


}
