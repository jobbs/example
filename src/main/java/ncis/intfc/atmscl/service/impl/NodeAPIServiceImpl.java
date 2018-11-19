/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ServcAreaAPIServiceImpl.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 01.
 * @lastmodified 2017. 06. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 01.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.service.NodeAPIService;
import ncis.intfc.atmscl.utils.AtmSclUtil;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.NodeIfVo;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author x
 *
 */
@Service("nodeAPIService")
public class NodeAPIServiceImpl implements NodeAPIService {

	@Resource(name="restSender") private RestSender restSender;


	/**
	 * 노드 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo addOSNodesPost(RestHeaders headers, NodeIfVo nodeIfVo) throws Exception {

		String url = OpenShiftURIConstant.OPENSHIFT_URI_ADDOSNODES;
		Map<String, Object> responseMap = restSender.send(url, nodeIfVo, headers, Map.class, HttpMethod.POST, OpenShiftJsonConstant.OPENSHIFT_ASYNC_CONNECT_TIMEOUT, OpenShiftJsonConstant.OPENSHIFT_ASYNC_READ_TIMEOUT).getBody();
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);
		return atmSclResultIfVo;
	}



	/**
	 * 노드 조회
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo nodesGet(RestHeaders headers, NodeIfVo nodeIfVo) throws Exception {

		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NODES_PARAM, null, nodeIfVo.getTargetNodeDomainName());
		Map<String, Object> responseMap = restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);
		return atmSclResultIfVo;
	}

}
