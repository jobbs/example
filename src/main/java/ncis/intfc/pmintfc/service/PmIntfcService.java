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
package ncis.intfc.pmintfc.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.pmintfc.vo.PmCtrlResultBodyVO;
import ncis.intfc.pmintfc.vo.PmStatusResultBodyVO;

/**
 * @author ShinKeeBong
 *
 */
public interface PmIntfcService {

	/**
	 * 물리서버 활성화
	 * @param uuid
	 * @param header
	 * @param bodyVo
	 * @return
	 */
	PmCtrlResultBodyVO active(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 물리서버 비활성화
	 * @param uuid
	 * @param header
	 * @return
	 */
	PmCtrlResultBodyVO deactive(String uuid, RestHeaders headers) throws Exception;

	/**
	 * 물리서버 상태 조회
	 * @param uuid
	 * @param header
	 * @return
	 */
	PmStatusResultBodyVO status(String uuid, RestHeaders headers) throws Exception;

}
