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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.config.OpenShiftJsonConstant;
import ncis.cmn.config.OpenShiftPathConstant;
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.service.ServcAreaAPIService;
import ncis.intfc.atmscl.utils.AtmSclUtil;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.LimitrangesIfVo;
import ncis.intfc.atmscl.vo.NamespaceIfVo;
import ncis.intfc.atmscl.vo.ProjectRequestsIfVo;
import ncis.intfc.atmscl.vo.ResourceQuotasIfVo;

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
@Service("servcAreaAPIService")
public class ServcAreaAPIServiceImpl implements ServcAreaAPIService {

	@Resource(name="restSender") private RestSender restSender;
	private DocumentContext context;

	/**
	 * 서비스영역 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo projectRequestsPost(RestHeaders headers, ProjectRequestsIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-134-0001"},"displayName":"서비스영역","description":"서비스영역입니다."}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PROJECTREQUESTS);

		Map<String, Object> reqMap = new HashMap<String, Object>(); //요청정보

		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DISPLAY_NAME, vo.getDisplayName()); //서비스영역명
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DESCRIPTION, vo.getDescription());  //서비스영역설명

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		//서비스영역 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 쿼터 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo resourceQuotasPost(RestHeaders headers, ResourceQuotasIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-134-0001"},"spec":{"hard":{"requests.memory":"4Gi","requests.cpu":"4","limits.cpu":"5","limits.memory":"5Gi","pods":"10"}}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_RESOURCEQUOTAS, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		//쿼터 수정 정보 구성
		Map<String, Object> hardMap = new HashMap<String, Object>();
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTS_CPU, vo.getRequestsCpu()); //요청 CPU
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTS_MEMORY, vo.getRequestsMemory()+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_GI); //요청 메모리
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LIMITS_CPU, vo.getLimitsCpu()); //제한 CPU
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LIMITS_MEMORY, vo.getLimitsMemory()+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_GI); //제한 메모리
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PODS, vo.getPods()); //POD 수

		//쿼터 정보를 반영
		AtmSclUtil.putSpecInfo(reqMap, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_HARD, hardMap );

		//서비스영역 쿼터 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 제한 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	public AtmSclResultIfVo limitrangesPost(RestHeaders headers, LimitrangesIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-134-0001"},
		       "spec":{"limits":[
		       					  {
		       					  	"min":{"memory":"1024Mi","cpu":"1000m"},
		                           	"max":{"memory":"3072Mi","cpu":"3000m"},
		                           	"type":"Pod"
		                          },
		                          {
		                          	"default":{"memory":"1024Mi","cpu":"1000m"},
		                            "min":{"memory":"1024Mi","cpu":"1000m"},
		                            "max":{"memory":"3072Mi","cpu":"3000m"},
		                            "type":"Container",
		                            "defaultRequest":{"memory":"1024Mi","cpu":"1000m"}
		                          }
		                        ]}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_LIMITRANGES, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보
		Map<String, Object> limitsMap = new HashMap<String, Object>();
		Map<String, Object> limitsPodMap = new HashMap<String, Object>();
		Map<String, Object> limitsContainerMap = new HashMap<String, Object>();
		Map<String, Object> maxMap = new HashMap<String, Object>();
		Map<String, Object> minMap = new HashMap<String, Object>();
		Map<String, Object> defaultMinMap = new HashMap<String, Object>();
		List<Map<String, Object>> limitsList = new ArrayList<Map<String, Object>>();

		maxMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, vo.getMaxCpu());  //최대CPU
		maxMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY, vo.getMaxMemory());  //최대메모리

		minMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU);  //최소CPU
		minMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY);  //최소메모리

		defaultMinMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, vo.getMinCpu());  //최소CPU
		defaultMinMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,vo.getMinMemory());  //최소메모리

		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_PODS);
		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MAX, maxMap);
		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MIN, minMap);

		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_CONTAINER);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MAX, maxMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MIN, minMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DEFAULT, defaultMinMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DEFAULTREQUEST, defaultMinMap);

		limitsList.add(limitsPodMap);
		limitsList.add(limitsContainerMap);

		limitsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_LIMITS, limitsList);

		//메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		//스펙 정보를 반영
		AtmSclUtil.putSpecInfo(reqMap, limitsMap );

		//서비스영역 제한 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}



	/**
	 * 서비스영역 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public AtmSclResultIfVo deleteNamespaces(RestHeaders headers, String namespaceId) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_PARAM, namespaceId);

		//서비스영역 삭제 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, null, headers, Map.class, HttpMethod.DELETE).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 수정
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public AtmSclResultIfVo nameSpacesPut(RestHeaders headers, NamespaceIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_PARAM, vo.getNamespaceId());

		//서비스영역 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		// Annotation 정보를 구성한다.
		Map<String, String> annotationsMap = new HashMap<String, String>();
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DESCRIPTION, vo.getDescription());  // 설명
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DISPLAY_NAME, vo.getDisplayName()); //이름
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTER, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_REQUESTER); //등록자

		// Labels 정보를 구성한다.
		Map<String, String> labelsMap = null;

		if(vo.getInstitutionId() != null) {
			labelsMap = new HashMap<String, String>();
			labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_INSTITUTION_ID, vo.getInstitutionId());  //부서 ID
			labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_JOB_ID, vo.getJobId()); //업무 ID
		}

		// Annotation 정보를 반영
		AtmSclUtil.addAnnotationLabel(reqMap, annotationsMap, labelsMap);

		//서비스영역 수정 API 호출
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 쿼터 수정
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public AtmSclResultIfVo resourceQuotasPut(RestHeaders headers, ResourceQuotasIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_RESOURCEQUOTAS_PARAM, vo.getNamespaceId(), vo.getName());

		//서비스영역 쿼터 조회 API 호출
		Map<String, Object> reqMap = restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		//쿼터 수정 정보 구성
		Map<String, Object> hardMap = new HashMap<String, Object>();
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTS_CPU, vo.getRequestsCpu()); //요청 CPU
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTS_MEMORY, vo.getRequestsMemory()+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_GI); //요청 메모리
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LIMITS_CPU, vo.getLimitsCpu()); //제한 CPU
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LIMITS_MEMORY, vo.getLimitsMemory()+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ADD_GI); //제한 메모리
		hardMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PODS, vo.getPods()); //POD 수

		//쿼터 정보를 반영
		AtmSclUtil.putSpecInfo(reqMap, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_HARD, hardMap );

		//서비스영역 쿼터 수정 API 호출
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 제한 수정
	 * @param header
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public AtmSclResultIfVo limitrangesPut(RestHeaders headers, LimitrangesIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_NAMESPACES_LIMITRANGES_PARAM, vo.getNamespaceId(), vo.getName());

		//서비스영역 제한 조회 API 호출
		Map<String, Object> reqMap = restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		Map<String, Object> limitsMap = new HashMap<String, Object>();
		Map<String, Object> limitsPodMap = new HashMap<String, Object>();
		Map<String, Object> limitsContainerMap = new HashMap<String, Object>();
		Map<String, Object> maxMap = new HashMap<String, Object>();
		Map<String, Object> minMap = new HashMap<String, Object>();
		Map<String, Object> defaultMinMap = new HashMap<String, Object>();
		List<Map<String, Object>> limitsList = new ArrayList<Map<String, Object>>();

		maxMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, vo.getMaxCpu());  //최대CPU
		maxMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY, vo.getMaxMemory());  //최대메모리

		minMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_CPU);  //최소CPU
		minMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,OpenShiftJsonConstant.OPENSHIFT_JSON_VAR_MIN_MEMORY);  //최소메모리

		defaultMinMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CPU, vo.getMinCpu());  //최소CPU
		defaultMinMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MEMORY,vo.getMinMemory());  //최소메모리

		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_PODS);
		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MAX, maxMap);
		limitsPodMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MIN, minMap);

		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_CONTAINER);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MAX, maxMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_MIN, minMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DEFAULT, defaultMinMap);
		limitsContainerMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DEFAULTREQUEST, defaultMinMap);

		limitsList.add(limitsPodMap);
		limitsList.add(limitsContainerMap);
		limitsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_LIMITS, limitsList);

		//스펙정보 반영
		AtmSclUtil.putSpecInfo(reqMap, limitsMap );

		//서비스영역 제한 수정 API 호출
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 계정 생성
	 * @param header
	 * @param namespaceId
	 * @return
	 */
	@Override
	public AtmSclResultIfVo serviceAccountsPost(RestHeaders headers, String namespaceId) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-134-0001"}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_SERVICEACCOUNTS, namespaceId);

		Map<String, Object> reqMap = new HashMap<String, Object>(); //요청정보

		//메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, namespaceId);

		//서비스영역 계정 생성 API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스영역 롤 적용
	 * @param header
	 * @param namespaceId
	 * @return
	 */
	@Override
	public AtmSclResultIfVo rollBindingsPost(RestHeaders headers, String namespaceId) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-134-0001"},
		       "subjects":[
		       				{"kind":"ServiceAccount","namespace":"ns-a-134-0001","name":"ns-a-134-0001"}
		       			  ],
		       "userNames":[
		       				"system:serviceaccount:ns-a-134-0001:ns-a-134-0001"
		       			   ],
		       "roleRef":{"name":"view"}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_ROLLBINDINGS, namespaceId);

		Map<String, Object> reqMap = new HashMap<String, Object>(); //요청정보

		//메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, namespaceId);

		setRollBindingUserName(reqMap, namespaceId);
		setRollBindingSubject(reqMap, namespaceId);
		setRollBindingRef(reqMap);

		//서비스영역 롤 생성 API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();


		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		AtmSclResultIfVo atmSclUpdatResultIfVo = new AtmSclResultIfVo();
		if("Y".equals(atmSclResultIfVo.getSuccYn())){
			String name = "system:image-pullers";
			String roleGetUrl = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_ROLLBINDINGS_PARAM, namespaceId,name);

			//서비스영역 롤 조회 API 호출
			String resMap =  restSender.send(roleGetUrl, headers, String.class, HttpMethod.GET).getBody();
			Map<String, Object> statMap = AtmSclUtil.getMapInfo(resMap, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT);

			if(!ObjectUtils.isEmpty(statMap)){ //서비스영역 롤 조회 성공

				//openshift의 system:image-pullers 권한 추가
				List<String> list = new ArrayList<String>();
				list.add(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ROLEBINDINGS_USERNAMES);
				String updateUserNmMap = AtmSclUtil.putMapInfoRole(this.context, resMap, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_USERNAMES, list);
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(updateUserNmMap);
				JsonArray jsonArr = element.getAsJsonArray();

				Map<String,Object> saMap = new HashMap<String, Object>();
				saMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SERVICE_ACCOUNT);
				saMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAMESPACE,OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BASE_NAMESPACE );
				saMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME,OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DEFAULT);

				List<Map<String, Object>> subListMap = AtmSclUtil.getMapListInfo(jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_ROLEBINDS_SUBJECTS);
				subListMap.add(saMap);
				String putMapInfo = AtmSclUtil.putMapInfo(this.context, jsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SUBJECTS, subListMap);
				JsonParser putParser = new JsonParser();
				JsonElement putElement = putParser.parse(putMapInfo);
				JsonArray putJsonArr = putElement.getAsJsonArray();
				String delMapInfo = AtmSclUtil.delMapInfo(this.context, putJsonArr.get(0).toString(), OpenShiftPathConstant.OPENSHIFT_JSON_PATH_ROLEBINDS_METADATA_RESOURCEVERSION);
				JsonParser delParser = new JsonParser();
				JsonElement delElement = delParser.parse(delMapInfo);
				JsonArray delJsonArr = delElement.getAsJsonArray();

				String reqRoleJson = delJsonArr.get(0).toString();

				ObjectMapper obj = new ObjectMapper();
				Map<String,Object> readValue = obj.readValue(reqRoleJson, new TypeReference<Map<String,Object>>(){});

				//서비스영역 롤 수정 API 호출
				@SuppressWarnings("unchecked")
				Map<String, Object> updatResMap =  restSender.send(roleGetUrl, readValue, headers, Map.class, HttpMethod.PUT).getBody();
				@SuppressWarnings("unused")
				String upCheck = String.valueOf(updatResMap.get("status"));
				//호출결과 셋팅
				if(ObjectUtils.isEmpty(updatResMap.get("status"))){
					atmSclUpdatResultIfVo.setSuccYn("Y");
				}else{
					atmSclUpdatResultIfVo.setSuccYn("N");
				}

				return atmSclUpdatResultIfVo;

			}else{ //서비스영역 롤 조회 실패
				atmSclUpdatResultIfVo.setSuccYn("N");
				return atmSclUpdatResultIfVo;
			}


		}else{
			atmSclUpdatResultIfVo.setSuccYn("N");
			return atmSclUpdatResultIfVo;
		}

	}


	/**
	 * RollBindingUserName
	 * @param reqMap
	 * @param namespaceId
	 * @return
	 */
	private void setRollBindingUserName(Map<String, Object> reqMap, String namespaceId) {
		String userNames[] = new String[1];
		userNames[0]  = OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SYSTEM+":"+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SERVICEACCOUNT+":"+namespaceId+":"+namespaceId;
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_USERNAMES, userNames);
	}


	/**
	 * RollBindingSubject
	 * @param reqMap
	 * @param namespaceId
	 * @return
	 */
	private void setRollBindingSubject(Map<String, Object> reqMap, String namespaceId) {
		List<Map<String, String>> subjectsList = new ArrayList<Map<String, String>>();
		Map<String, String> subjectsMap  = new HashMap<String, String>();
		subjectsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SERVICE_ACCOUNT);
		subjectsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAMESPACE, namespaceId);
		subjectsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, namespaceId);
		subjectsList.add(subjectsMap);
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SUBJECTS , subjectsList);
	}


	/**
	 * RollBindingRef
	 * @param reqMap
	 * @param namespaceId
	 * @return
	 */
	private void setRollBindingRef(Map<String, Object> reqMap) {
		Map<String, String> roleRefMap  = new HashMap<String, String>();
		roleRefMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_ROLE_VIEW);
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ROLEREF, roleRefMap);
	}

}
