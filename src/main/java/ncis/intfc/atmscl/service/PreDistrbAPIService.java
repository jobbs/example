/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.vo.PreDistrbBodyVO;

/**
 * @author x
 *
 */
public interface PreDistrbAPIService {

	/**
	 * 사전배포 생성
	 * @param header
	 * @param preDistrbBodyVo
	 * @return
	 */
	PreDistrbBodyVO insertPreDistrbApi(RestHeaders headers, PreDistrbBodyVO preDistrbBodyVo) throws Exception;

	/**
	 * @param headers
	 * @param preDistrbBodyVo
	 */
	PreDistrbBodyVO selectPreDistrbApi(RestHeaders headers, PreDistrbBodyVO preDistrbBodyVo) throws Exception;

	/**
	 * @param headers
	 * @param preDistrbBodyVo
	 * @return
	 */
	PreDistrbBodyVO reInsertPreDistrbApi(RestHeaders headers,PreDistrbBodyVO preDistrbBodyVo) throws Exception;





}
