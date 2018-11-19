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


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OpenShiftPathConstant;
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.entity.RxDistrbConf;
import ncis.cmn.entity.RxMnulScl;
import ncis.cmn.entity.RxPvc;
import ncis.cmn.entity.RxRsrvSclng;
import ncis.cmn.exception.CommonException;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.intfc.atmscl.service.AtmsclDistrbAPIService;
import ncis.intfc.atmscl.utils.AtmSclUtil;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.DocumentContext;

/**
 * @author x
 *
 */
@Service("atmsclDistrbAPIService")
public class AtmsclDistrbAPIServiceImpl implements AtmsclDistrbAPIService {

	@Resource(name="restSender") private RestSender restSender;

	private DocumentContext context;

	@Override
	public AtmSclResultIfVo pvcCre(RestHeaders headers, RxPvc rxPvc) throws Exception {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PERSISTENTVOLUMECLAIMS,rxPvc.getServcAreaId());
		AtmSclResultIfVo atmSclResultIfVo = new AtmSclResultIfVo();
		String accCodeNm = "";
		if("01".equals(rxPvc.getAccssModeClCd())){
			accCodeNm = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_RWO;
		}else if("02".equals(rxPvc.getAccssModeClCd())){
			accCodeNm = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_RWM;
		}else if("03".equals(rxPvc.getAccssModeClCd())){
			accCodeNm = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ROM;
		}
		if(!"".equals(accCodeNm) || !accCodeNm.isEmpty()){
			Map<String, Object> reqMap = new HashMap<String, Object>();
			Map<String, Object> specInfoMap = new HashMap<String, Object>();
			//메타데이터에 이름을 추가한다.
			AtmSclUtil.putMapMetaDataId(reqMap, rxPvc.getPvcId());

			//스펙 정보를 반영
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_VOLUME_NAME, rxPvc.getPvId());
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_RESOURCES, addResourceInfo( OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_REQUESTS, rxPvc.getReqStrgCapa()));
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ACCESSMODES, Arrays.asList(accCodeNm));

			reqMap = AtmSclUtil.putSpecInfo(reqMap, specInfoMap);

			//PVC API 호출
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

			atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);
			return atmSclResultIfVo;
		}else{
			atmSclResultIfVo.setSuccYn("N");
			return atmSclResultIfVo;
		}
	}
	public Map<String, Object> addResourceInfo( String reqNm,Integer storage) {

		Map<String, Object> toMap = new HashMap<String, Object>();
		Map<String, Object> midMap = new HashMap<String, Object>();
		String atStorage = storage+"Gi";
		midMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STORAGE,atStorage);
		toMap.put(reqNm, midMap);

		return toMap;
	}

	@Override
	public AtmSclResultIfVo pvcInfo(RestHeaders headers, RxPvc rxPvc) throws Exception {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PERSISTENTVOLUMECLAIMS,rxPvc.getServcAreaId());
		url+="/"+rxPvc.getServcAreaId();
		AtmSclResultIfVo atmSclResultIfVo = new AtmSclResultIfVo();

		//PVC API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, headers, Map.class, HttpMethod.GET).getBody();
		atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);
		return atmSclResultIfVo;
	}

	@Override
	public AtmSclResultIfVo deployConf(RestHeaders headers, RxPvc rxPvc) throws Exception {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,rxPvc.getServcAreaId(),rxPvc.getDistrbConfId());


		AtmSclResultIfVo atmSclDistrbConfResultInfo =new AtmSclResultIfVo();
		//deployConfigs 조회  API 호출 (GET)

		String jsonStr = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();

		List<Map<String, Object>> volumesMap = AtmSclUtil.getMapListInfo(jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_VOLUMES);

		if(!ObjectUtils.isEmpty(volumesMap) || volumesMap != null){
			// 기존
			List<Map<String, Object>> volList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> map : volumesMap) {
				Map<String, Object> oldVolMap = new HashMap<String, Object>();
				oldVolMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME));
				oldVolMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM,map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM));
				volList.add(oldVolMap);
			}
			Map<String, Object> claimMap = new HashMap<String, Object>();
			Map<String, Object> volumesInfoMap = new HashMap<String, Object>();
			claimMap .put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CLAIMNAME,rxPvc.getPvcId());
			volumesInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxPvc.getVolumeNm());
			volumesInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM,claimMap);
			volList.add(volumesInfoMap);

			String reqStr  = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_SPEC, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMES, volList);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(reqStr);
			JsonArray jsonArr = element.getAsJsonArray();

			if(!reqStr.isEmpty()){
				List<Map<String, Object>> containersMap = AtmSclUtil.getMapListInfo(jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS);

				if(!ObjectUtils.isEmpty(containersMap))
				for (Map<String, Object> map : containersMap) {
					List<Map<String, Object>> volMountList = new ArrayList<Map<String, Object>>();
					@SuppressWarnings("unchecked")
					ArrayList<Map<String,Object>> volumeMountsMap = (ArrayList<Map<String, Object>>) map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS);

					if (volumeMountsMap != null) {

						for (Map<String, Object> volInfoMap : volumeMountsMap) {

							Map<String,Object> volMountInfoMap = new HashMap<String, Object>();
							volMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,volInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME));
							volMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH,volInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH));

							volMountList.add(volMountInfoMap);

						}
						Map<String,Object> newVolMountInfoMap = new HashMap<String, Object>();
						newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxPvc.getVolumeNm());
						newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH,rxPvc.getMountPath());
						volMountList.add(newVolMountInfoMap);

						String volMountAddResult  = AtmSclUtil.putMapInfo(this.context, jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS, volMountList);

						JsonParser volParser = new JsonParser();
						JsonElement volElement = volParser.parse(volMountAddResult);
						JsonArray volJsonArr = volElement.getAsJsonArray();

						String reqVolJson = volJsonArr.get(0).toString();
						ObjectMapper obj = new ObjectMapper();
						Map<String,Object> readValue = obj.readValue(reqVolJson, new TypeReference<Map<String,Object>>(){});

						//deployConf 수정 API 호출
						String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, rxPvc.getServcAreaId(), rxPvc.getDistrbConfId());
						@SuppressWarnings("unchecked")
						Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
						atmSclDistrbConfResultInfo = AtmSclUtil.setAtmSclResultInfo(resDeployConf);
					}
				}

			}


		}else{

			// 최초
			List<Map<String, Object>> volList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> newVolMountList = new ArrayList<Map<String, Object>>();
			Map<String,Object> volumesInfoMap = new HashMap<String, Object>();
			Map<String,Object> pvcMap = new HashMap<String, Object>();
			Map<String,Object> newVolMountInfoMap = new HashMap<String, Object>();
			Map<String,Object> volMountMap = new HashMap<String, Object>();
			pvcMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CLAIMNAME,rxPvc.getPvcId());
			volumesInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM,pvcMap);
			volumesInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxPvc.getVolumeNm());
			volList.add(volumesInfoMap);
			String reqStr = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_SPEC, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMES, volList);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(reqStr);
			JsonArray jsonArr = element.getAsJsonArray();


			newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxPvc.getVolumeNm());
			newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH,rxPvc.getMountPath());
			newVolMountList.add(newVolMountInfoMap);
			volMountMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS,newVolMountList);
			String volMountAddResult  = AtmSclUtil.putMapInfo(this.context, jsonArr.get(0).toString(),OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS, newVolMountList);
//
			JsonParser volParser = new JsonParser();
			JsonElement volElement = volParser.parse(volMountAddResult);
			JsonArray volJsonArr = volElement.getAsJsonArray();

			String reqVolJson = volJsonArr.get(0).toString();
			ObjectMapper obj = new ObjectMapper();
			Map<String,Object> readValue = obj.readValue(reqVolJson, new TypeReference<Map<String,Object>>(){});
			//deployConf 수정 API 호출
			String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, rxPvc.getServcAreaId(), rxPvc.getDistrbConfId());
			@SuppressWarnings("unchecked")
			Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();

			atmSclDistrbConfResultInfo = AtmSclUtil.setAtmSclResultInfo(resDeployConf);


		}
//		if (atmSclDistrbConfResultInfo == null) {
//			atmSclDistrbConfResultInfo.setSuccYn("N");
//		}
		return atmSclDistrbConfResultInfo;
	}

	@Override
	public AtmSclResultIfVo selectPodCnt(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo) {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,atmsclDistrbVo.getServcAreaId(),atmsclDistrbVo.getDistrbConfId());
		AtmSclResultIfVo atmSclResultIfVo = new AtmSclResultIfVo();

		//DEPLOY API 호출
		String resJson = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();
		Map<String, Object> statInfoMap = AtmSclUtil.getMapInfo(resJson, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_DEPLOYCONF_STATUS);

		if ( null != statInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REPLICAS)) {
			 int podCnt = Integer.parseInt(statInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REPLICAS).toString());
			 int lastVer = Integer.parseInt(statInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LATEST_VERSION).toString());
			 atmSclResultIfVo.setSuccYn("Y");
			atmSclResultIfVo.setPodsCnt(podCnt);
			atmSclResultIfVo.setLatestVersion(lastVer);
		}else{
			atmSclResultIfVo.setSuccYn("N");
		}
		return atmSclResultIfVo;
	}
	@Override
	public AtmSclResultIfVo putReplicasAdd(RestHeaders headers,RxMnulScl rxMnulScl) {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_SCALE,rxMnulScl.getServcAreaId(),rxMnulScl.getDistrbConfId());

		Map<String, Object> metaMap = new HashMap<String, Object>();
		Map<String, Object> baseMap = new HashMap<String, Object>();
		Map<String, Object> specMap = new HashMap<String, Object>();
		Map<String, Object> replicaMap = new HashMap<String, Object>();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		AtmSclResultIfVo atmSclResultIfVo = new AtmSclResultIfVo();

		baseMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxMnulScl.getDistrbConfId());
		baseMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAMESPACE,rxMnulScl.getServcAreaId());
		metaMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA,baseMap);
		replicaMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REPLICAS,rxMnulScl.getChngPodQty());
		specMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC,replicaMap);
		reqMap.putAll(metaMap);
		reqMap.putAll(specMap);

		@SuppressWarnings("unchecked")
		Map<String, Object> resMap = restSender.send(url,reqMap, headers, Map.class, HttpMethod.PUT).getBody();
		String stat = resMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS).toString();

		if(!"Failure".equals(stat) && null != stat){
			atmSclResultIfVo.setSuccYn("Y");
		}else{
			atmSclResultIfVo.setSuccYn("N");
		}

		return atmSclResultIfVo;
	}


	@Override
	public AtmSclResultIfVo updateRsrcLtApi(RestHeaders headers,RxDistrbConf disConf)  throws Exception {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,disConf.getServcAreaId(),disConf.getDistrbConfId());

		AtmSclResultIfVo atmSclDistrbConfResultInfo = new AtmSclResultIfVo();
		//deployConfigs 조회  API 호출 (GET)
		String jsonStr = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();

			Map<String, Object> limitMap = new HashMap<String, Object>();
			Map<String, Object> resoMap = new HashMap<String, Object>();
			Map<String, Object> reqsMap = new HashMap<String, Object>();
			Map<String, Object> lmMap = new HashMap<String, Object>();
			Map<String, Object> rqMap = new HashMap<String, Object>();
			//제한
			String lmttCpu = changeVal(disConf.getLmttCpuCorQty(),"01");
			String lmttMem = changeVal(disConf.getLmttMemCapa(),"02");
			//요청
			String reqCpu = changeVal(disConf.getReqCpuCorQty(),"01");
			String reqMem = changeVal(disConf.getReqMemCapa(),"02");

			//제한
			limitMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU,lmttCpu);
			limitMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,lmttMem);
			//요청
			reqsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU,reqCpu);
			reqsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,reqMem);


			lmMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_LIMITS,limitMap);
			rqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_REQUESTS,reqsMap);

			resoMap.putAll(lmMap);
			resoMap.putAll(rqMap);

			String reqStr = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_RESOURCES,resoMap );

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(reqStr);
			JsonArray jsonArr = element.getAsJsonArray();

			String reqJson = jsonArr.get(0).toString();

			ObjectMapper obj = new ObjectMapper();
			HashMap<String,Object> readValue = obj.readValue(reqJson,  new TypeReference<Map<String,Object>>(){});

			//deployConf 수정 API 호출
			String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS, disConf.getServcAreaId(), disConf.getDistrbConfId());
			@SuppressWarnings("unchecked")
			Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
			atmSclDistrbConfResultInfo = AtmSclUtil.setAtmSclResultInfo(resDeployConf);

		return atmSclDistrbConfResultInfo;
	}
	@Override
	public AtmSclResultIfVo updateDistrbConfApi(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo, List<DistrbEnvConfVo> selectDistrbEnvConfExcept) throws Exception {
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,atmsclDistrbVo.getServcAreaId(),atmsclDistrbVo.getDistrbConfId());

		AtmSclResultIfVo atmSclDistrbConfResultInfo = new AtmSclResultIfVo();
		//deployConfigs 조회  API 호출 (GET)
		String jsonStr = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();
		List<Map<String, Object>> mapListInfo = AtmSclUtil.getMapListInfo(jsonStr,OpenShiftPathConstant.OPENSHIFT_JSON_PATH_DEPLOYCONF_ENV);
		Integer lastVer = AtmSclUtil.getMapIntInfo(jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_LATESTVERSION);
		if(ObjectUtils.isEmpty(lastVer)){
			lastVer = 0;
		}
		int latestVersion = 1;


		List<Map<String, Object>> envNewList = new ArrayList<Map<String, Object>>();
		if("01".equals(atmsclDistrbVo.getCheckCd())){
			if(lastVer > 0) {
				latestVersion = lastVer+1;
			}
		}else{
			if(lastVer > 0) {
				latestVersion = lastVer;
			}
		}



		if(atmsclDistrbVo.getDistrbEnvConfList() != null){
			List<DistrbEnvConfVo> distrbEnvConfList = atmsclDistrbVo.getDistrbEnvConfList();
			for (DistrbEnvConfVo disConfVo : distrbEnvConfList) {
				Map<String,Object> map = new HashMap<String, Object>();
				map.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,disConfVo.getEnvVarNm());
				map.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_VALUE,disConfVo.getEnvVarVl());
				envNewList.add(map);
			}
		}
		if (selectDistrbEnvConfExcept != null) {
			for (DistrbEnvConfVo oldDistbConfVo : selectDistrbEnvConfExcept) {
				for (Map<String, Object> exMap : mapListInfo) {
					if(oldDistbConfVo.getEnvVarNm().equals(exMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME))){
						envNewList.add(exMap);
					}
				}
			}
		}
		String lastVerAddJson = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_DEPLOYCONF_STATUS,OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LATEST_VERSION, latestVersion );
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(lastVerAddJson);
		JsonArray jsonArr = element.getAsJsonArray();
		String reqJson = jsonArr.get(0).toString();

		String reqStr = AtmSclUtil.putMapInfo(this.context, reqJson, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ENV,envNewList );

		JsonElement parEle = parser.parse(reqStr);
		JsonArray jsonArrResult = parEle.getAsJsonArray();

		String reqJsonResult = jsonArrResult.get(0).toString();
		ObjectMapper obj = new ObjectMapper();
		HashMap<String,Object> readValue = obj.readValue(reqJsonResult,  new TypeReference<Map<String,Object>>(){});

		//deployConf 수정 API 호출
		String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS, atmsclDistrbVo.getServcAreaId(), atmsclDistrbVo.getDistrbConfId());
		@SuppressWarnings("unchecked")
		Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
		atmSclDistrbConfResultInfo = AtmSclUtil.setAtmSclResultInfo(resDeployConf);
		return atmSclDistrbConfResultInfo;
	}

	/*
	 * 배포 상태 코드 조회
	 * */
	@Override
	public AtmSclResultIfVo selectDistrbStat(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo) throws Exception {
		AtmSclResultIfVo resRst = new AtmSclResultIfVo();
		String buildId = atmsclDistrbVo.getDistrbConfId()+"-"+atmsclDistrbVo.getLastDistrbVer();
		String distrbStatUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_REPLICATIONCONTROLLERS_PARAM, atmsclDistrbVo.getServcAreaId(), buildId);
		String originRes = restSender.send(distrbStatUrl, headers, String.class, HttpMethod.GET).getBody();
		Map<String, Object> resMap = AtmSclUtil.getMapInfo(originRes, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT);
		Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(originRes, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_REPLICATION_STATUS);
		if("Failure".equals(resMap.get("status"))){
			resRst.setSuccYn("N");
		}else{
			if(!mapInfo.isEmpty()){

				String phase = mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_PHASE).toString();
				resRst.setSuccYn("Y");
				String cancelPhase = "";
				if(!ObjectUtils.isEmpty(mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_CANCELLED))){
					cancelPhase = mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_CANCELLED).toString();
				}
				if ("" != cancelPhase || null != cancelPhase) {
					if("true".equals(cancelPhase) && "Failed".equals(cancelPhase)){
						resRst.setStatCd("04"); //Cancelled
					}
				}

				if("Running".equals(phase)){
					resRst.setStatCd("01"); //Running
				}
				if ("Complete".equals(phase)) {
					resRst.setStatCd("02"); //Active
				}
				if ("Failed".equals(phase)) {
					resRst.setStatCd("03"); //Failed
				}
				if ("Pending".equals(phase)) {
					resRst.setStatCd("05"); //Pending
				}
				if ("New".equals(phase)) {
					resRst.setStatCd("06"); //New
				}
				if ("other".equals(phase)) {
					resRst.setStatCd("07"); //other
				}

			}else{
				resRst.setSuccYn("N");
			}
		}



		return resRst;
	}

	//자원 제한 단위를 위한 함수
		private String changeVal(double doubleVal, String type) {

			String rtnVal = null;
			String unitStr = "";

			if("01".equals(type)) {  //CPU일경우
				unitStr = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_M;
				rtnVal =Long.toString(Math.round(doubleVal*1000))+unitStr;
			}else if("02".equals(type)) {  //메모리일경우
				unitStr = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_MI;
				rtnVal =Long.toString(Math.round(doubleVal*1024))+unitStr;
			}

			return rtnVal;
		}

		/*
		 *오토 스케일링 설정 수정
		 * */
		@Override
		public AtmSclResultIfVo updateDistrbAutoConf(RestHeaders headers,RxRsrvSclng rxRsrvSclng) throws Exception {
			AtmSclResultIfVo atmSclDistrbConfResultInfo =new AtmSclResultIfVo();
			//GET
			String getUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS_PARAM, rxRsrvSclng.getServcAreaId(), rxRsrvSclng.getServcId());
			//스케일팩터 GET
			String result = restSender.send(getUrl, headers, String.class, HttpMethod.GET).getBody();
			Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_SPEC);
			mapInfo.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MIN_REPLICAS,rxRsrvSclng.getMinPodQty());
			mapInfo.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MAX_REPLICAS,rxRsrvSclng.getMaxPodQty());
			@SuppressWarnings("unchecked")
			Map<String, Object> cpuMap = (Map<String, Object>) mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU_UTILIZATION);
			cpuMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TARGET_PERCENTAGE,rxRsrvSclng.getEndThresVl());

			mapInfo.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU_UTILIZATION,cpuMap);

			String putMapInfo = AtmSclUtil.putMapInfo(this.context, result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC, mapInfo);
			// mapInfo 수정한 내용

			JsonParser volParser = new JsonParser();
			JsonElement volElement = volParser.parse(putMapInfo);
			JsonArray volJsonArr = volElement.getAsJsonArray();

			String reqVolJson = volJsonArr.get(0).toString();
			ObjectMapper obj = new ObjectMapper();
			Map<String,Object> readValue = obj.readValue(reqVolJson, new TypeReference<Map<String,Object>>(){});

			//PUT
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS_PARAM, rxRsrvSclng.getServcAreaId(),rxRsrvSclng.getServcId());


			//오토스케일 등록 API
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = restSender.send(url, readValue, headers, Map.class, HttpMethod.PUT).getBody();
			String stat = responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS).toString();

			if(!"Failure".equals(stat)){
				atmSclDistrbConfResultInfo.setSuccYn("Y");
			}else{
				atmSclDistrbConfResultInfo.setSuccYn("N");
			}
			return atmSclDistrbConfResultInfo;
		}
		// 오토스케일링 설정
		@Override
		public AtmSclResultIfVo insertDistrbAutoConf(RestHeaders headers,RxRsrvSclng rxRsrvSclng) throws Exception {
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS, rxRsrvSclng.getServcAreaId());
			AtmSclResultIfVo atmSclDistrbConfResultInfo =new AtmSclResultIfVo();

			Map<String, Object> metaMap = new HashMap<String, Object>();
			Map<String, Object> metaInfoMap = new HashMap<String, Object>();
			Map<String, Object> metaInfoLblMap = new HashMap<String, Object>();
			Map<String, Object> cpuPerMap = new HashMap<String, Object>();
			Map<String, Object> specMap = new HashMap<String, Object>();
			Map<String, Object> scaleRefMap = new HashMap<String, Object>();
			Map<String, Object> scaleRefInfoMap = new HashMap<String, Object>();

			metaInfoLblMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP,rxRsrvSclng.getServcId());
			metaInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_LABELS,metaInfoLblMap);
			metaInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxRsrvSclng.getServcId());
			metaMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA,metaInfoMap);
			cpuPerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TARGET_PERCENTAGE,rxRsrvSclng.getEndThresVl());
			scaleRefInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND,OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_DEPLOYMENT_CONFIG);
			scaleRefInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxRsrvSclng.getServcId());
			scaleRefInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_API_VERSION,OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_EXTENSIONS_V1BETA1);
			scaleRefInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_SUBRESOURCE,OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SCALE);
			scaleRefMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_SCALE_REF,scaleRefInfoMap);
			specMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MIN_REPLICAS,rxRsrvSclng.getMinPodQty());
			specMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MAX_REPLICAS,rxRsrvSclng.getMaxPodQty());
			specMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU_UTILIZATION,cpuPerMap);
			specMap.putAll(scaleRefMap);
			metaMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC,specMap);


			//오토스케일 등록 API
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = restSender.send(url, metaMap, headers, Map.class, HttpMethod.POST).getBody();
			String stat = responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS).toString();

			if(!"Failure".equals(stat)){
				atmSclDistrbConfResultInfo.setSuccYn("Y");
			}else{
				atmSclDistrbConfResultInfo.setSuccYn("N");
			}
			return atmSclDistrbConfResultInfo;
		}

		@Override
		public AtmSclResultIfVo deleteDistrbAutoSclConf(RestHeaders headers,RxRsrvSclng rxRsrvSclng) throws Exception {
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS_PARAM, rxRsrvSclng.getServcAreaId(),rxRsrvSclng.getServcId());
			AtmSclResultIfVo atmSclDistrbConfResultInfo =new AtmSclResultIfVo();
			//오토스케일 삭제 API
			@SuppressWarnings("unchecked")
			Map<String, Object> responseMap = restSender.send(url, headers, Map.class, HttpMethod.DELETE).getBody();
			String stat = responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS).toString();
			if("Success".equals(stat)){
				atmSclDistrbConfResultInfo.setSuccYn("Y");
			}else{
				atmSclDistrbConfResultInfo.setSuccYn("N");
			}
			return atmSclDistrbConfResultInfo;
		}
		/* (non-Javadoc)
		 * @see ncis.intfc.atmscl.service.AtmsclDistrbAPIService#updateInitRsrcLtApi(ncis.cmn.rest.vo.RestHeaders, ncis.cmn.entity.RxDistrbConf)
		 */
		@Override
		public AtmSclResultIfVo updateInitRsrcLtApi(RestHeaders headers,RxDistrbConf disConf) throws Exception {
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,disConf.getServcAreaId(),disConf.getDistrbConfId());

			AtmSclResultIfVo atmSclDistrbConfResultInfo = new AtmSclResultIfVo();
			//deployConfigs 조회  API 호출 (GET)
			String jsonStr = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();

				Map<String, Object> resoMap = new HashMap<String, Object>();

				String reqStr = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_RESOURCES,resoMap );

				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(reqStr);
				JsonArray jsonArr = element.getAsJsonArray();

				String reqJson = jsonArr.get(0).toString();

				ObjectMapper obj = new ObjectMapper();
				HashMap<String,Object> readValue = obj.readValue(reqJson,  new TypeReference<Map<String,Object>>(){});

				//deployConf 수정 API 호출
				String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS, disConf.getServcAreaId(), disConf.getDistrbConfId());
				@SuppressWarnings("unchecked")
				Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
				atmSclDistrbConfResultInfo = AtmSclUtil.setAtmSclResultInfo(resDeployConf);

			return atmSclDistrbConfResultInfo;
		}

		@Override
		public AtmSclResultIfVo deletePvc(RestHeaders headers, RxPvc rxPvc) throws Exception {
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PERSISTENTVOLUMECLAIMS_PARAM,rxPvc.getServcAreaId(),rxPvc.getPvcId());
			AtmSclResultIfVo atmsclDelPvcResult = new AtmSclResultIfVo();
			//스토리지 삭제 API
			String resResult= restSender.send(url, headers, String.class, HttpMethod.DELETE).getBody();
			Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(resResult, OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS);

			if(!ObjectUtils.isEmpty(mapInfo)){
				String phaseStat = (String) mapInfo.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PHASE);
				if("Bound".equals(phaseStat)){
					//deployconf 조회 API
					String deployConfUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,rxPvc.getServcAreaId(),rxPvc.getDistrbConfId());
					String jsonStr = restSender.send(deployConfUrl, headers, String.class, HttpMethod.GET).getBody();
					List<Map<String, Object>> volumesMap = AtmSclUtil.getMapListInfo(jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_VOLUMES);
					if(!ObjectUtils.isEmpty(volumesMap) || volumesMap != null){
						// 기존
						List<Map<String, Object>> volList = new ArrayList<Map<String, Object>>();
						String volNm = rxPvc.getVolumeNm();
						for (Map<String, Object> map : volumesMap) {
							Map<String, Object> oldVolMap = new HashMap<String, Object>();
							if(!volNm.equals(map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME))){
								oldVolMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME));
								oldVolMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM,map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERSISTENTVOLUMECLAIM));
								volList.add(oldVolMap);
							}
						}
						if(0 == volList.size()){ // 삭제한 볼륨을 제외하고 볼륨이 없을 경우
							String volDelInfo = AtmSclUtil.delMapInfo(this.context,jsonStr,OpenShiftPathConstant.OPENSHIFT_JSON_PATH_VOLUMES);
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(volDelInfo);
							JsonArray jsonArr = element.getAsJsonArray();

							String volMtDelInfo = AtmSclUtil.delMapInfo(context, jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_VOLUMEMOUNTS_ARRAY);

							JsonParser finParser = new JsonParser();
							JsonElement finElement = finParser.parse(volMtDelInfo);
							JsonArray finJsonArr = finElement.getAsJsonArray();

							String reqVolJson = finJsonArr.get(0).toString();
							ObjectMapper obj = new ObjectMapper();
							Map<String,Object> readValue = obj.readValue(reqVolJson, new TypeReference<Map<String,Object>>(){});

							//deployConf 수정 API 호출
							String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, rxPvc.getServcAreaId(), rxPvc.getDistrbConfId());
							@SuppressWarnings("unchecked")
							Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
							AtmSclResultIfVo atmSclDistrbConfResultInfo  = AtmSclUtil.setAtmSclResultInfo(resDeployConf);
							atmsclDelPvcResult.setSuccYn(atmSclDistrbConfResultInfo.getSuccYn());

						}else{ // 삭제한 볼륨을 제외하고 볼륨이 있을 경우
							String reqStr  = AtmSclUtil.putMapInfo(this.context, jsonStr, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_SPEC, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMES, volList);

							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(reqStr);
							JsonArray jsonArr = element.getAsJsonArray();

							if(!reqStr.isEmpty()){
								List<Map<String, Object>> containersMap = AtmSclUtil.getMapListInfo(jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS);

								if(!ObjectUtils.isEmpty(containersMap))
									for (Map<String, Object> map : containersMap) {
										List<Map<String, Object>> volMountList = new ArrayList<Map<String, Object>>();
										@SuppressWarnings("unchecked")
										ArrayList<Map<String,Object>> volumeMountsMap = (ArrayList<Map<String, Object>>) map.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS);

										if (volumeMountsMap != null) {

											for (Map<String, Object> volInfoMap : volumeMountsMap) {

												Map<String,Object> volMountInfoMap = new HashMap<String, Object>();
												if(!volNm.equals(volInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME))){
													volMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,volInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME));
													volMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH,volInfoMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH));
													volMountList.add(volMountInfoMap);
												}

											}
//											Map<String,Object> newVolMountInfoMap = new HashMap<String, Object>();
//											newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,rxPvc.getVolumeNm());
//											newVolMountInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MOUNTPATH,rxPvc.getMountPath());
//											volMountList.add(newVolMountInfoMap);

											String volMountAddResult  = AtmSclUtil.putMapInfo(this.context, jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_VOLUMEMOUNTS, volMountList);

											JsonParser volParser = new JsonParser();
											JsonElement volElement = volParser.parse(volMountAddResult);
											JsonArray volJsonArr = volElement.getAsJsonArray();

											String reqVolJson = volJsonArr.get(0).toString();
											ObjectMapper obj = new ObjectMapper();
											Map<String,Object> readValue = obj.readValue(reqVolJson, new TypeReference<Map<String,Object>>(){});

											//deployConf 수정 API 호출
											String deployConfurl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, rxPvc.getServcAreaId(), rxPvc.getDistrbConfId());
											@SuppressWarnings("unchecked")
											Map<String,Object> resDeployConf = restSender.send(deployConfurl,readValue, headers, Map.class, HttpMethod.PUT).getBody();
											AtmSclResultIfVo atmSclDistrbConfResultInfo  = AtmSclUtil.setAtmSclResultInfo(resDeployConf);
											atmsclDelPvcResult.setSuccYn(atmSclDistrbConfResultInfo.getSuccYn());
										}else{
											atmsclDelPvcResult.setSuccYn("N");
										}
									} //for
							} //req EMPTY
						}//volList.size

					} //volMap empty
				}else{
					atmsclDelPvcResult.setSuccYn("N");
				}
			}else{
				atmsclDelPvcResult.setSuccYn("N");
			}
			return atmsclDelPvcResult;
		}
		//배포 동기화
		@Override
		public AtmSclResultIfVo updateDistrbSync(RestHeaders headers,AtmsclDistrbVo atmsclDistrbVo) throws Exception {
			String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,atmsclDistrbVo.getServcAreaId(),atmsclDistrbVo.getDistrbConfId());

			AtmSclResultIfVo distrbSyncResult =new AtmSclResultIfVo();

			//deployConfigs 조회  API 호출 (GET)
			String resultJson = restSender.send(url, headers, String.class, HttpMethod.GET).getBody();

			Map<String, Object> distrbConfResult = AtmSclUtil.getMapInfo(resultJson, "$.status");
			Integer replicas = AtmSclUtil.getMapIntInfo(resultJson, "$.replicas");

			if(!ObjectUtils.isEmpty(distrbConfResult.get("latestVersion"))){
				String checkVer = distrbConfResult.get("latestVersion").toString();
				String lastDistrbVer = atmsclDistrbVo.getLastDistrbVer();
				if(!checkVer.equals(lastDistrbVer)){
					//동기화 필요 (o)
					distrbSyncResult.setSuccYn("Y");
					int lastVer = Integer.valueOf(checkVer);
					distrbSyncResult.setLatestVersion(lastVer);
					distrbSyncResult.setReplicas(replicas);
				}else{
					//동기화 필요 (x)
					distrbSyncResult.setSuccYn("N");
				}
			}else{
				//동기화 필요 (x)
				distrbSyncResult.setSuccYn("N");
			}

			return distrbSyncResult;
		}
		//배포 동기화
		@Override
		public AtmSclResultIfVo distrbHstrySync(RestHeaders headers,AtmsclDistrbVo atmsclDistVo) throws Exception {

			String buildId = atmsclDistVo.getDistrbConfId()+"-"+atmsclDistVo.getLastDistrbVer();
			String distrbStatUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_REPLICATIONCONTROLLERS_PARAM, atmsclDistVo.getServcAreaId(), buildId);
			@SuppressWarnings("unchecked")
			Map<String,Object> responseMap = restSender.send(distrbStatUrl, headers, Map.class, HttpMethod.GET).getBody();
			AtmSclResultIfVo setAtmSclResultInfo = AtmSclUtil.setAtmSclResultInfo(responseMap);
			@SuppressWarnings("unchecked")
			Map<String,Object> statusReq = (Map<String, Object>) responseMap.get("status");
			int replicas = 0;

			if(!ObjectUtils.isEmpty(statusReq.get("replicas"))){
				replicas = Integer.valueOf(statusReq.get("replicas").toString()) ;
			}
			 setAtmSclResultInfo.setReplicas(replicas);
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
				Date parsedDate = dateFormat.parse(setAtmSclResultInfo.getCreationTime());
				Timestamp ts = new Timestamp(parsedDate.getTime());
				setAtmSclResultInfo.setLastDistrbDttm(ts);
			} catch (ParseException e) {
				throw new CommonException("생성일자 변환시 오류가 발생했습니다."+e.getMessage());
			}
			return setAtmSclResultInfo;
		}


}
