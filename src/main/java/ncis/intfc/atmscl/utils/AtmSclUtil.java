/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AtmSclUtil.java
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
package ncis.intfc.atmscl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.exception.CommonException;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import net.minidev.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;



public class AtmSclUtil {

	private static Logger logger = LoggerFactory.getLogger(AtmSclUtil.class);

	public AtmSclUtil() {}



	/**
	 * API 호출 URL을 리턴한다.
	 * @param url
	 * @param namespaceId
	 * @return
	 */
	public static String getAtmSclAPIURL(String uri) {

		String rtnUrl = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + uri;
		return rtnUrl;
	}


	/**
	 * API 호출 URL을 리턴한다.
	 * @param url
	 * @param namespaceId
	 * @return
	 */
	public static String getAtmSclAPIURL(String uri, String namespaceId) {

		String rtnUrl = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + uri;

		if(!StringUtils.isEmpty(namespaceId)) {
			rtnUrl = rtnUrl.replace(OpenShiftURIConstant.OPENSHIFT_STR_NAMESPACES, namespaceId);
		}

		return rtnUrl;
	}

	/**
	 * API 호출 URL을 리턴한다.
	 * @param url
	 * @param namespaceId
	 * @return
	 */
	public static String getAtmSclAPIURL(String uri, String namespaceId, String name) {

		String rtnUrl = OpenShiftURIConstant.OPENSHIFT_URI_BASE_CONTEXT + uri;

		if(!StringUtils.isEmpty(namespaceId)) {
			rtnUrl =rtnUrl.replace(OpenShiftURIConstant.OPENSHIFT_STR_NAMESPACES, namespaceId);
		}

		if(!StringUtils.isEmpty(name)) {
			rtnUrl = rtnUrl.replace(OpenShiftURIConstant.OPENSHIFT_STR_NAME, name);
		}

		return rtnUrl;
	}



	/**
	 * MetaData의 id을 셋팅한다.
	 * @param metaDataMap
	 * @param displayName
	 * @param description
	 * @return
	 */
	public static Map<String, Object> putMapMetaDataId(Map<String, Object> reqMap, String id) {

		Map<String, Object> metaDataMap = new HashMap<String, Object>();
		metaDataMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, id);
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA, metaDataMap);

		return reqMap;
	}


	/**
	 * Annotation 및 Label 정보를 반영한다.
	 * @param reqMap
	 * @param annotationsMap
	 * @param labelsMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> addAnnotationLabel(Map<String, Object> reqMap, Map<String, String> annotationsMap, Map<String, String> labelsMap) {

		Map<String, Object> metaDataMap =  (Map<String, Object>)reqMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA);

		// Annotation 정보가 있을경우 반영
		if(annotationsMap != null) {
			metaDataMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ANNOTATIONS, annotationsMap);
		}

		// Label 정보가 있을경우 반영
		if(labelsMap != null) {
			metaDataMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_LABELS, labelsMap);
		}

		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA, metaDataMap);

		return reqMap;
	}


	/**
	 * API호출결과 정보를 리턴한다.
	 * @param responseMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static AtmSclResultIfVo setAtmSclResultInfo(Map<String, Object> responseMap) {

		AtmSclResultIfVo atmSclResultIfVo = new AtmSclResultIfVo();

		String succYn = "Y";

		succYn = String.valueOf( responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS));

		if(OpenShiftJsonConstant.OPENSHIFT_STATUS_VAL_OK.equals(succYn) || OpenShiftJsonConstant.OPENSHIFT_STATUS_VAL_SUCCESS.equals(succYn)) {  //노드생성 API는 호출 후 OK로 리턴됨, 삭제 API는 호출 후 Success로 리턴됨
			atmSclResultIfVo.setSuccYn("Y");
		}else {

			if(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_FAIL.equals(succYn)) {
				atmSclResultIfVo.setSuccYn("N");
				atmSclResultIfVo.setMessage((String)responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MESSAGE));
			}else {

				atmSclResultIfVo.setSuccYn("Y");

				Map<String, Object> rtnMetaDataMap  = (Map<String, Object>)responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA);
				Map<String, Object> statusMap  = (Map<String, Object>)responseMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STATUS);

				//메타데이터 관련 셋팅(uid, 생성일자..)
				if(!ObjectUtils.isEmpty(rtnMetaDataMap)) {

					atmSclResultIfVo.setUid((String)rtnMetaDataMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_UID));  //uid를 셋팅
					atmSclResultIfVo.setCreationTime(setCreDtDateFormater((String)rtnMetaDataMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CREATION_TIMESTAMP)));  //생성일자

					Map<String, Object> annotationMap  = (Map<String, Object>)rtnMetaDataMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ANNOTATIONS);

					if(!ObjectUtils.isEmpty(annotationMap)) {
						if(annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_BUILD_NUMBER) != null) {
							atmSclResultIfVo.setBuildNumber((String)annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_BUILD_NUMBER));
						}

						if(annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_PHASE) != null) {
							String cancelledFlag = "";
							if(annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_CANCELLED) != null) {
								cancelledFlag = (String)annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_CANCELLED);
							}

							atmSclResultIfVo.setDeploymentPhase(setDeployStatCd((String)annotationMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENT_PHASE),cancelledFlag));  //배포상태
						}
					}
				}

				//상태정보 관련 셋팅 (빌드설정 버전, ...)
				if(!ObjectUtils.isEmpty(statusMap)) {
					if(statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LASTVERSION) != null) {
						atmSclResultIfVo.setBuildNumber(Integer.toString((Integer)statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LASTVERSION)));
					}

					if(statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DOCKER_IMAGE_REPOSITORY) != null) {
						atmSclResultIfVo.setImgRepoAddr((String)statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DOCKER_IMAGE_REPOSITORY)); //이미지저장소 주소
					}


					if(statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LATEST_VERSION) != null) {
						atmSclResultIfVo.setLatestVersion((Integer)statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LATEST_VERSION)); //배포버전
					}

					if(statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PHASE) != null) {
						atmSclResultIfVo.setBuildPhase(setBuildStatCd((String)statusMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PHASE))); //빌드상태
					}
				}
			}
		}

		return atmSclResultIfVo;
	}


	/**
	 * MetaDatad의 Spec에  정보를 반영한다.
	 * @param metaDataMap
	 * @param displayName
	 * @param description
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> putSpecInfo(Map<String, Object> reqMap, String objName, Map<String, Object> addMap) {

		Map<String, Object> specMap =  (Map<String, Object>)reqMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC);

		if(specMap==null) {
			specMap = new HashMap<String, Object>();
		}

		specMap.put(objName, addMap);
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC, specMap);

		return reqMap;
	}


	/**
	 * MetaDatad의 Spec에  정보를 반영한다.
	 * @param metaDataMap
	 * @param displayName
	 * @param description
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> putSpecInfo(Map<String, Object> reqMap,  Map<String, Object> addMap) {

		Map<String, Object> specMap =  (Map<String, Object>)reqMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC);

		if(specMap==null) {
			specMap = new HashMap<String, Object>();
		}

		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC, addMap);

		return reqMap;

	}


	/**
	 * 생성일자 포맷셋팅.
	 * @param creDt
	 * @return
	 */
	public static String setCreDtDateFormater(String creDt) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			format.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date dt = format.parse(creDt);

			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd HHmmss");
			return format1.format(dt);
		}catch(ParseException pe) {
			return creDt;
		}catch(Exception e) { // NOPMD
			return creDt;
		}
	}


	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static Map<String, Object> getMapInfo(String reqJson, String jsonPath) {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		try {
			infoMap = JsonPath.parse(reqJson).read(jsonPath);
			return infoMap;

		} catch (IllegalArgumentException ie) {
			return null;
		} catch (Exception e) { // NOPMD
			return null;
		}
	}

	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static List<Map<String, Object>> getMapListInfo(String reqJson, String jsonPath) {
		try {
			List<Map<String, Object>> infoMap = JsonPath.parse(reqJson).read(jsonPath);
			return infoMap;

		} catch (IllegalArgumentException ie) {
			return null;
		} catch (Exception e) { // NOPMD
			return null;
		}
	}
	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static Integer getMapIntInfo(String reqJson, String jsonPath) {
		Integer infoStr = new Integer(0);
		try {
			infoStr = JsonPath.parse(reqJson).read(jsonPath);
			return infoStr;

		} catch (IllegalArgumentException ie) {
			return null;
		} catch (Exception e) { // NOPMD
			return null;
		}
	}

	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static List<Map<String, Object>> getMapListInfo(JsonArray reqJson, String jsonPath) {
		try {
			List<Map<String, Object>> infoMap = JsonPath.parse(reqJson).read(jsonPath);
			return infoMap;
		} catch (IllegalArgumentException ie) {
			return null;
		} catch (Exception e) { // NOPMD
			return null;
		}
	}


	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static List<Object> getJsonInfoList(Configuration configuration, DocumentContext context, Object reqJson, String jsonPath) {

		try {

			//context =  JsonPath.using(configuration).parse(reqJson);
			JSONArray obj = (JSONArray)context.read(jsonPath);

			if (obj.size() == 0) {
				return new ArrayList<Object>();
			}
			else {
				List<Object> result = new ArrayList<Object>();
				for (Object object : obj) {
					if (object != null) {
						result.add(object);
					}
				}
				return result;
			}
		} catch (CommonException ce) {
			logger.error("json 조회 오류", ce);
			return new ArrayList<Object>();
		} catch (Exception e) { // NOPMD
			logger.error("json 조회 오류", e);
			return new ArrayList<Object>();
		}
	}



	/**
	 * 해당 Json 경로의 데이터를 리턴한다.
	 * @param reqJson
	 * @param jsonPath
	 * @return
	 */
	public static String getJsonInfoString(Configuration configuration, DocumentContext context, Object reqJson, String jsonPath) {

		//context =  JsonPath.using(configuration).parse(reqJson);
		JSONArray obj = (JSONArray)context.read(jsonPath);

		if (obj.size() == 0) {
			return null;
		}
		else if (obj.size() > 1) {
			return obj.toString();
		}
		else {
			if (obj.get(0) != null) {
				return obj.get(0).toString();
			}
			else {
				return null;
			}
		}

	}


	/**
	 * 해당 Json 경로에  데이터를 셋팅한다.
	 * @param context
	 * @param reqJson
	 * @param jsonPath
	 * @param editMap
	 * @return
	 */
	public static String setMapInfo(DocumentContext context, String reqJson, String jsonPath, Map<String, Object> editMap) {

		Configuration configuration = Configuration.defaultConfiguration();

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
			logger.debug(JsonPath.using(configuration).parse(reqJson).jsonString());
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}

		context.set(jsonPath, editMap);


		return context.read("$").toString();
	}

	/**
	 * 해당 Json 경로에  데이터를 셋팅한다.
	 * @param context
	 * @param reqJson
	 * @param jsonPath
	 * @param editMap
	 * @return
	 */
	public static String setMapInfo(DocumentContext context, String reqJson, String jsonPath, List<Map<String, Object>> editMap) {

		Configuration configuration = Configuration.defaultConfiguration();

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}

		context.set(jsonPath, editMap);

		return context.read("$").toString();
	}

	/**
	 * 해당 Json 경로에  데이터를 반영한다.
	 * @param context
	 * @param reqJson
	 * @param jsonPath
	 * @param editMap
	 * @return
	 */
	public static String putMapInfo(DocumentContext context, String reqJson, String jsonPath, String jsonObjNm, Map<String, Object> editMap) {

		Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);;

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}

		context.put(jsonPath, jsonObjNm, editMap);

		return context.read("$").toString();
	}


	/**
	 * 해당 Json 경로에  데이터를 반영한다.
	 * @param context
	 * @param reqJson
	 * @param jsonPath
	 * @param editMap
	 * @return
	 */
	public static String putMapInfo(DocumentContext context, String reqJson, String jsonPath, String jsonObjNm, List<Map<String, Object>> editMap) {

		Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}
		context.put(jsonPath, jsonObjNm, editMap);
		return context.read("$").toString();
	}


	/**
	 * @param context
	 * @param jsonStr
	 * @param openshiftJsonPathDeployconfStatus
	 * @param openshiftJsonStrLatestVersion
	 * @param latestVersion
	 * @return
	 */
	public static String putMapInfo(DocumentContext context, String reqJson,String jsonPath,String jsonObjNm, int latestVersion) {
		Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}

		context.put(jsonPath, jsonObjNm, latestVersion);
		return context.read("$").toString();
	}

	/**
	 * @param context
	 * @param jsonStr
	 * @param openshiftJsonPathDeployconfStatus
	 * @param openshiftJsonStrLatestVersion
	 * @param latestVersion
	 * @return
	 */
	public static String putMapInfoRole(DocumentContext context, String reqJson,String jsonPath,String jsonObjNm, List<String> editVal) {
		Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}

		context.put(jsonPath, jsonObjNm, editVal);
		return context.read("$").toString();
	}



	/**
	 * 해당 Json 경로에  데이터를 삭제한다.
	 * @param context
	 * @param reqJson
	 * @param jsonPath
	 * @param editMap
	 * @return
	 */
	public static String delMapInfo(DocumentContext context, String reqJson, String jsonPath) {

		Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);

		if (reqJson.getClass() == String.class) {
			context = JsonPath.using(configuration).parse((String) reqJson);
		}
		else {
			context = JsonPath.using(configuration).parse(reqJson);
		}
		context.delete(jsonPath);
		return context.read("$").toString();
	}


	/**
	 * 빌드 상태정보 셋팅.
	 * @param phase
	 * @return
	 */
	public static String setBuildStatCd(String phase) {

		String buildStatCd = "";

		if(phase == null) {
			buildStatCd = "07";
		}else {
			if("Running".equals(phase)) {
				buildStatCd = "01";
			}else if("Complete".equals(phase)) {
				buildStatCd = "02";
			}else if("Failed".equals(phase)) {
				buildStatCd = "03";
			}else if("Cancelled".equals(phase)) {
				buildStatCd = "04";
			}else if("New".equals(phase)) {
				buildStatCd = "05";
			}else if("Pending".equals(phase)) {
				buildStatCd = "06";
			}else if("Error".equals(phase)) {
				buildStatCd = "07";
			}else {
				buildStatCd = "08";
			}
		}

		return buildStatCd;
	}


	/**
	 * 배포 상태정보 셋팅.
	 * @param phase
	 * @return
	 */
	public static String setDeployStatCd(String phase, String cancelledFlag) {

		String deployStatCd = "";

		if(phase == null) {
			deployStatCd = "07";
		}else {
			if("Running".equals(phase)) {
				deployStatCd = "01";
			}else if("Complete".equals(phase)) {
				deployStatCd = "02";
			}else if("Failed".equals(phase) && "true".equals(cancelledFlag)) {
				deployStatCd = "04";
			}else if("Failed".equals(phase)) {
				deployStatCd = "03";
			}else if("Pending".equals(phase)) {
				deployStatCd = "05";
			}else if("New".equals(phase)) {
				deployStatCd = "06";
			}else {
				deployStatCd = "07";
			}
		}

		return deployStatCd;
	}


	/**
	 * Pod 상태정보 셋팅.
	 * @param phase
	 * @return
	 */
	public static String setPodStatCd(String phase) {

		String podStatCd = "";

		if(phase == null) {
			podStatCd = "06";
		}else {
			if("Running".equals(phase)) {
				podStatCd = "01";
			}else if("Succeeded".equals(phase)) {
				podStatCd = "02";
			}else if("Failed".equals(phase)) {
				podStatCd = "03";
			}else if("New".equals(phase)) {
				podStatCd = "04";
			}else if("Pending".equals(phase)) {
				podStatCd = "05";
			}else {
				podStatCd = "06";
			}
		}

		return podStatCd;
	}

}
