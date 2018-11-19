/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackServiceImpl.java
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
package ncis.intfc.atmscl.service.impl;




import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.config.OprConstant;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.intfc.atmscl.service.PreDistrbAPIService;
import ncis.intfc.atmscl.vo.PreDistrbBodyVO;
import ncis.intfc.pmintfc.service.impl.PmIntfcServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * @author x
 *
 */
@Service("preDistrbAPIService")
public class PreDistrbAPIServiceImpl implements PreDistrbAPIService {

	private final Logger logger = LoggerFactory.getLogger(PmIntfcServiceImpl.class);

	@Resource(name="restSender") private RestSender restSender;

	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="preDistrbAPIService")
	PreDistrbAPIService preDistrbAPIService;

	@SuppressWarnings("unchecked")
	@Override
	public PreDistrbBodyVO insertPreDistrbApi(RestHeaders headers,PreDistrbBodyVO preDistrbBodyVo) throws Exception {
		String url = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + "/namespaces/"+OprConstant.DEMONSET_OPENSHIFT+"/daemonsets";
		PreDistrbBodyVO preBodyVo = new PreDistrbBodyVO();
		try {

			Map<String, Object> responseMap = restSender.send(url, preDistrbBodyVo, headers, Map.class, HttpMethod.POST).getBody();

			if(!ObjectUtils.isEmpty(responseMap)){
				Map<String, Object> metaMap = (Map<String, Object>) responseMap.get("metadata");
				Map<String, Object> statusMap = (Map<String, Object>) responseMap.get("status");
				if(!ObjectUtils.isEmpty(metaMap) && !ObjectUtils.isEmpty(statusMap)){
					preBodyVo.setName(metaMap.get("name").toString());
					preBodyVo.setNamespace(metaMap.get("namespace").toString());

					preBodyVo.setCurrentNumberScheduled(((Integer)statusMap.get("currentNumberScheduled")));
					preBodyVo.setNumberMisscheduled(((Integer)statusMap.get("numberMisscheduled")));
					preBodyVo.setDesiredNumberScheduled(((Integer)statusMap.get("desiredNumberScheduled")));
					preBodyVo.setRunningPods(((Integer)statusMap.get("runningPods")));
					preBodyVo.setWaitingPods(((Integer)statusMap.get("waitingPods")));
					preBodyVo.setFailedPods(((Integer)statusMap.get("failedPods")));
				}
			}

		} catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}

		return preBodyVo;

	}


	@SuppressWarnings("unchecked")
	@Override
	public PreDistrbBodyVO selectPreDistrbApi(RestHeaders headers,PreDistrbBodyVO preDistrbBodyVo) throws Exception {
			String url = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + "/namespaces/"+OprConstant.DEMONSET_OPENSHIFT+"/daemonsets/"+preDistrbBodyVo.getName();
			PreDistrbBodyVO preBodyVo = new PreDistrbBodyVO();
			try {
				Map<String, Object> responseMap = restSender.send(url, preDistrbBodyVo, headers, Map.class, HttpMethod.GET).getBody();
				if(!ObjectUtils.isEmpty(responseMap)){
					Map<String, Object> statusMap = (Map<String, Object>) responseMap.get("status");
					if(!ObjectUtils.isEmpty(statusMap)){
						preBodyVo.setCurrentNumberScheduled(((Integer)statusMap.get("currentNumberScheduled")));
						preBodyVo.setNumberMisscheduled(((Integer)statusMap.get("numberMisscheduled")));
						preBodyVo.setDesiredNumberScheduled(((Integer)statusMap.get("desiredNumberScheduled")));
						preBodyVo.setRunningPods(((Integer)statusMap.get("runningPods")));
						preBodyVo.setWaitingPods(((Integer)statusMap.get("waitingPods")));
						preBodyVo.setFailedPods(((Integer)statusMap.get("failedPods")));
					}
				}

			}  catch (HttpStatusCodeException e) {
				logger.debug(e.getResponseBodyAsString(), e);
				throw e;
			}
		return preBodyVo;
	}


	@Override
	public PreDistrbBodyVO reInsertPreDistrbApi(RestHeaders headers,PreDistrbBodyVO preDistrbBodyVo) throws Exception {
		String url = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + "/namespaces/"+OprConstant.DEMONSET_OPENSHIFT+"/daemonsets/"+preDistrbBodyVo.getName();
		PreDistrbBodyVO preBodyVo = new PreDistrbBodyVO();
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = restSender.send(url, preDistrbBodyVo, headers, Map.class, HttpMethod.DELETE).getBody();

			if(!ObjectUtils.isEmpty(responseMap)){

				if(!ObjectUtils.isEmpty(responseMap.get("status"))){
					if (responseMap.get("status") != null) {
						preBodyVo.setStatus(responseMap.get("status").toString());
					}
					if (responseMap.get("reason") != null) {
						preBodyVo.setReason(responseMap.get("reason").toString());
					}
				}
			}

		}  catch (HttpStatusCodeException e) {
			logger.debug(e.getResponseBodyAsString(), e);
			throw e;
		}
	return preBodyVo;
	}



}
