/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NodeAPIService.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 21.
 * @lastmodified 2017. 06. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 21.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.NodeIfVo;

/**
 * @author x
 *
 */
public interface NodeAPIService {

	/**
	 * 노드 생성
	 * @param header
	 * @param nodeIfVo
	 * @return
	 */
	AtmSclResultIfVo addOSNodesPost(RestHeaders headers, NodeIfVo nodeIfVo) throws Exception;


	/**
	 * 노드 조회
	 * @param header
	 * @param nodeIfVo
	 * @return
	 */
	AtmSclResultIfVo nodesGet(RestHeaders headers, NodeIfVo nodeIfVo) throws Exception;

}
