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
import ncis.cmn.config.OpenShiftURIConstant;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.service.ServcAPIService;
import ncis.intfc.atmscl.utils.AtmSclUtil;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.BuildConfigsIfVo;
import ncis.intfc.atmscl.vo.ContainersPortsIfVo;
import ncis.intfc.atmscl.vo.DeploymentConfigsIfVo;
import ncis.intfc.atmscl.vo.EnvIfVo;
import ncis.intfc.atmscl.vo.ImagestreamsIfVo;
import ncis.intfc.atmscl.vo.PodIfVo;
import ncis.intfc.atmscl.vo.RoutesIfVo;
import ncis.intfc.atmscl.vo.SecretsIfVo;
import ncis.intfc.atmscl.vo.ServicesIfVo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

/**
 * @author x
 *
 */
@Service("servcAPIService")
public class ServcAPIServiceImpl implements ServcAPIService {

	@Resource(name="restSender") private RestSender restSender;


	Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS, Option.ALWAYS_RETURN_LIST);



	/**
	 * 보안키 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo secretsPost(RestHeaders headers, SecretsIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함. (password, username 은 Base64 인코딩 되어야함. )
		      {"metadata":{"name":"skey"},"data":{"password":"MXEydzNlNHIh","username":"aHNMZWU="},"type":"kubernetes.io/basic-auth"}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_SECRETS, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>(); //요청정보
		Map<String, String> dataMap = new HashMap<String, String>(); //Data 정보

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		dataMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_USERNAME, vo.getUsername()); // 사용자이름(해당 Git 프로젝트의 계정 아이디)
		dataMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PASSWORD, vo.getPassword()); // 패스워드(해당 Git 프로젝트의 계정 패스워드)

		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, vo.getType()); //요청 정보에 Type 정보 추가 (kubernetes.io/basic-auth)
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_DATA, dataMap);  //요청 정보에 Data 정보 추가

		//보안키 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	@Override
	public AtmSclResultIfVo servicesPost(RestHeaders headers, ServicesIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-175-0001-0002",
		      				"annotations":{"openshift.io/display-name":"테스트서비스","openshift.io/description":"테스트서비스 입니다.","openshift.io/requester":"admin"},
		      				"labels":{"app":"jboss-eap70-openshift","application":"ns-a-175-0001-0002"}},
		       "spec":{"selector":{"deploymentConfig":"ns-a-175-0001-0002"},
		               "ports":[{"port":8080,"targetPort":8080,"protocol":"TCP","name":"8080-tcp"}]}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_SERVICES, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보
		Map<String, Object> specInfoMap = new HashMap<String, Object>(); //스펙정보

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		//Labels 정보를 구성한다.
		Map<String, String> labelsMap = new HashMap<String, String>();
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP, vo.getBaseImgId());  //베이스이미지ID
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, vo.getName()); //서비스ID

		//Annotation 정보를 구성한다.
		Map<String, String> annotationsMap = new HashMap<String, String>();
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DESCRIPTION, vo.getDescription());  // 설명
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DISPLAY_NAME, vo.getDisplayName()); //이름
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REQUESTER, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_REQUESTER); //등록자

		//Annotation, Labels 정보를 요청정보에 추가
		AtmSclUtil.addAnnotationLabel(reqMap, annotationsMap, labelsMap);

		//스펙 정보를 반영
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_PORTS, vo.getPorts()); //포트정보 셋팅
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SELECTOR, addDeploymentConfigSelectorInfo(vo.getName())); //SELECTOR 정보 셋팅
		AtmSclUtil.putSpecInfo(reqMap, specInfoMap);

		//서비스 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}



	/**
	 * 서비스 수정
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo servicesPut(RestHeaders headers, ServicesIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_SERVICES_PARAM, vo.getNamespaceId(), vo.getName());

		//서비스영역 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		// Annotation 정보를 구성한다.
		Map<String, String> annotationsMap = new HashMap<String, String>();
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DESCRIPTION, vo.getDescription());  // 설명
		annotationsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AT_DISPLAY_NAME, vo.getDisplayName()); //이름

		// Annotation 정보를 반영
		AtmSclUtil.addAnnotationLabel(reqMap, annotationsMap, null);

		//서비스 수정 API 호출
		Map<String, Object> responseMap =  restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 라우트 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo routesPost(RestHeaders headers, RoutesIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-175-0001-0002-01",
		                   "labels":{"application":"ns-a-175-0001-0002"}},
		       "spec":{"port":{"targetPort":"8080-tcp"},"host":"test1.ncis.go.kr","to":{"name":"ns-a-175-0001-0002"}}}
		*/


		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_ROUTES, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보
		Map<String, Object> specInfoMap = new HashMap<String, Object>();  //스펙정보
		Map<String, String> toMap = new HashMap<String, String>();  //to정보
		Map<String, String> portMap = new HashMap<String, String>();  //port정보
		Map<String, String> labelsMap = new HashMap<String, String>(); //Labels 정보

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		// Labels 정보를 구성한다.
		//labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP, vo.getBaseImgId());  //베이스이미지ID
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, vo.getServiceName()); //서비스ID

		// Labels 정보를 요청정보에 추가
		AtmSclUtil.addAnnotationLabel(reqMap, null, labelsMap);

		toMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, vo.getServiceName());
		portMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TARGETPORT, vo.getTargetPort());

		//스펙 정보를 반영
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_HOST, vo.getHost());
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TO, toMap);
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_PORT, portMap);
		AtmSclUtil.putSpecInfo(reqMap, specInfoMap);

		//라우트 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}



	/**
	 * 이미지스트림 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo imagestreamsPost(RestHeaders headers, ImagestreamsIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-175-0001-0002","labels":{"app":"jboss-eap70-openshift","application":"ns-a-175-0001-0002"}}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_IMAGESTREAMS, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보

		// 메티데이터에 이름을 추가한다.
		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName());

		// Labels 정보를 구성한다.
		Map<String, String> labelsMap = new HashMap<String, String>();
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP, vo.getBaseImgId());  //베이스이미지ID
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, vo.getServiceName()); //서비스ID

		// Labels 정보를  요청정보에 추가
		AtmSclUtil.addAnnotationLabel(reqMap, null, labelsMap);

		//이미지스트림 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 빌드설정 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo buildconfigsPost(RestHeaders headers, BuildConfigsIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-175-0001-0002","labels":{"app":"jboss-eap70-openshift","application":"ns-a-175-0001-0002"}},
		       "spec":{"output":{"to":{"kind":"ImageStreamTag","name":"ns-a-175-0001-0002:latest"}},
		               "source":{"sourceSecret":{"name":"hk1"},"git":{"ref":"master","uri":"http://10.180.245.35/lyh/ncms-test.git"},"type":"Git"},
		               "strategy":{"sourceStrategy":{"forcePull":false,"from":{"kind":"ImageStreamTag","name":"jboss-eap70-openshift:1.4","namespace":"openshift"}},"type":"Source"},
		               "triggers":[{}]}}
		*/

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDCONFIGS, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보
		Map<String, Object> specInfoMap  = new HashMap<String, Object>();  //스펙정보
		Map<String, String> labelsMap = new HashMap<String, String>(); //Labels 정보

		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName()); //MapMetaData ID를 셋팅한다.

		// Labels 정보 셋팅
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP, vo.getBaseImgId());  //베이스이미지ID
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, vo.getServiceName()); //서비스ID
		AtmSclUtil.addAnnotationLabel(reqMap, null, labelsMap);  // Labels 정보를 반영

		//스펙 정보를 반영
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_OUTPUT, setBuildConfigOutputInfo(vo.getServiceName(), OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_IMAGESTREAMTAG));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STRATEGY, setBuildConfigStrategyInfo(vo.getBaseImgId(), vo.getBaseImgVer()));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SOURCE, setBuildConfigSourceInfo(vo.getContextDir(), vo.getUri(), vo.getRef(), vo.getSecret(), vo.getSourceType()));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TRIGGERS, setBuildConfigTriggersInfo(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BUILD_TRIGGERS_TYPE_01));
		AtmSclUtil.putSpecInfo(reqMap, specInfoMap);  //메타데이터의 스펙에 제한 정보를 반영

		//빌드설정 생성 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}



	/**
	 * 빌드
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo instantiatePost(RestHeaders headers, BuildConfigsIfVo vo) throws Exception {


		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_INSTANTIATE_PARAM, vo.getNamespaceId(), vo.getName());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보

		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName()); //MapMetaData ID를 셋팅한다.

		//빌드  호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 빌드설정 수정
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo buildconfigsPut(RestHeaders headers, BuildConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDCONFIGS_PARAM, vo.getNamespaceId(), vo.getName());

		//빌드설정 조회 API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		//빌드 수정 정보 셋팅
		Map<String, Object> specInfoMap  = new HashMap<String, Object>();
		Map<String, Object> statusMap  = new HashMap<String, Object>();
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_OUTPUT, setBuildConfigOutputInfo(vo.getServiceName(), OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_IMAGESTREAMTAG));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STRATEGY, setBuildConfigStrategyInfo(vo.getBaseImgId(), vo.getBaseImgVer()));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SOURCE, setBuildConfigSourceInfo(vo.getContextDir(), vo.getUri(), vo.getRef(), vo.getSecret(), vo.getSourceType()));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TRIGGERS, setBuildConfigTriggersInfo(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BUILD_TRIGGERS_TYPE_01));
		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_STATUS, statusMap);

		AtmSclUtil.putSpecInfo(reqMap, specInfoMap);

		//빌드설정  수정 API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 배포설정 생성
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public AtmSclResultIfVo deploymentConfigsPost(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception {

		/*
		    예시) 아래와 같은 형식으로 구성되어야함.
		      {"metadata":{"name":"ns-a-175-0001-0002","labels":{"app":"jboss-eap70-openshift","application":"ns-a-175-0001-0002"}},
		       "spec":{
		       			"template":{
		       						 "metadata":{"labels":{"deploymentConfig":"ns-a-175-0001-0002","application":"ns-a-175-0001-0002"}},
		       			             "spec":{"containers":[
		       			             						{"image":"172.30.0.2:5000/ns-a-175-0001/ns-a-175-0001-0002:latest",
		       			                                     "name":"ns-a-175-0001-0002",
		       			                                     "readinessProbe":{"failureThreshold":3,"timeoutSeconds":3,"periodSeconds":10,"successThreshold":1,"initialDelaySeconds":60,
		       			                                                       "httpGet":{"path":"/","scheme":"HTTP","port":8080}},
		       			                                                       "ports":[
		       			                                                    		     {"protocol":"TCP","containerPort":8080},
		       			                                                    		     {"protocol":"TCP","containerPort":8888}
		       			                                                    		   ],
		       			                                                       "env":[
		       			                                                    		   {"name":"test1","value":"1"},
		       			                                                    		   {"name":"test2","value":"2"},
		       			                                                    		   {"name":"OPENSHIFT_KUBE_PING_LABELS","value":"application=ns-a-175-0001-0002"},
		       			                                                    		   {"name":"OPENSHIFT_KUBE_PING_NAMESPACE","value":"ns-a-175-0001"}
		       			                                                    		 ]
		       			                                                      }
		       			                                  ]}},
                        "replicas":1,
                        "selector":{"deploymentConfig":"ns-a-175-0001-0002"},
                        "triggers":{},
                        "strategy":{"rollingParams":{"maxSurge":"0%","updatePeriodSeconds":1,"timeoutSeconds":600,"50%":"50%","intervalSeconds":1}}}}
		*/


		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS, vo.getNamespaceId());

		Map<String, Object> reqMap = new HashMap<String, Object>();  //요청정보
		Map<String, Object> specInfoMap  = new HashMap<String, Object>();  //스펙정보
		Map<String, String> labelsMap = new HashMap<String, String>();  //Label정보

		AtmSclUtil.putMapMetaDataId(reqMap, vo.getName()); //MapMetaData ID를 셋팅한다.

		// Labels 정보 셋팅
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APP, vo.getBaseImgId());
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, vo.getName());
		AtmSclUtil.addAnnotationLabel(reqMap, null, labelsMap);  // Labels 정보를 반영

		//스펙 정보를 반영
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REPLICAS, vo.getReplicas());
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SELECTOR, addDeploymentConfigSelectorInfo(vo.getName()));
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TEMPLATE, addDeploymentConfigTemplateInfo(vo.getNamespaceId(), vo.getBaseImgId(), vo.getName(), vo.getImgRepoAddr(), vo.getPorts(), vo.getEnvList()));
		//specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TRIGGERS, setDeploymentConfigTriggersInfo(vo.getName()));  //트리거 설정이 필요할 경우
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TRIGGERS, new HashMap<String, String>());
		specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STRATEGY, setDeploymentConfigStrategyInfo());
		AtmSclUtil.putSpecInfo(reqMap, specInfoMap);

		//배포설정 API 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.POST).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 배포설정 수정
	 * @param header
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo deploymentConfigsPut(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, vo.getNamespaceId(), vo.getName());

		//배포설정 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(reqMap);

		int latestVersion = 1;

		if(!"Y".equals(vo.getDefaultYn())) {

			Map<String, Object> specInfoMap  = (Map<String, Object>)reqMap.get(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SPEC); //스펙정보

			//스펙 정보를 반영
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REPLICAS, vo.getReplicas());
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SELECTOR, addDeploymentConfigSelectorInfo(vo.getName()));
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TEMPLATE, addDeploymentConfigTemplateInfo(vo.getNamespaceId(), vo.getBaseImgId(), vo.getName(), vo.getImgRepoAddr(), vo.getPorts(), vo.getEnvList()));
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TRIGGERS, setDeploymentConfigTriggersInfo(vo.getName()));
			specInfoMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STRATEGY, setDeploymentConfigStrategyInfo());
			AtmSclUtil.putSpecInfo(reqMap, specInfoMap);
		}

		if(atmSclResultIfVo.getLatestVersion() != null) {
			latestVersion = atmSclResultIfVo.getLatestVersion()+1;
		}

		Map<String, Object> statusMap = new HashMap<String, Object>();
		statusMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_LATEST_VERSION, latestVersion);

		reqMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_STATUS, statusMap);

		//배포설정 수정 API 호출
		Map<String, Object> responseMap = restSender.send(url, reqMap, headers, Map.class, HttpMethod.PUT).getBody();

		//호출결과 셋팅
		atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 서비스 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public AtmSclResultIfVo servicesDelete(RestHeaders headers, ServicesIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_SERVICES_PARAM, vo.getNamespaceId(), vo.getName());

		//서비스 삭제 호출
		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = restSender.send(url, null, headers, Map.class, HttpMethod.DELETE).getBody();

		//호출결과 셋팅
		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(responseMap);

		return atmSclResultIfVo;
	}


	/**
	 * 라우트 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void routesDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_ROUTES_PARAM, namespaceId, name);

		//라우트 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}


	/**
	 * 이미지스트림 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void imagestreamsDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_IMAGESTREAMS_PARAM, namespaceId, name);

		//라우트 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();

	}


	/**
	 * 빌드설정 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void buildconfigsDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDCONFIGS_PARAM, namespaceId, name);

		//빌드설정 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}


	/**
	 * 배포설정 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void deploymentConfigsDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM, namespaceId, name);

		//배포설정 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}


	/**
	 * 배포이력 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void replicationcontrollersDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_REPLICATIONCONTROLLERS_PARAM, namespaceId, name);

		//배포이력 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}


	/**
	 * 빌드이력 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void buildsDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDS_PARAM, namespaceId, name);

		//빌드이력 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}


	/**
	 * Pod이력 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	@Override
	public void podsDelete(RestHeaders headers, String namespaceId, String name) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PODS_PARAM, namespaceId, name);

		//Pod 삭제 호출
		restSender.send(url, null, headers, null, HttpMethod.DELETE).getBody();
	}




	/**
	 * Pod정보 조회
	 * @param header
	 * @param vo
	 * @return
	 */
	@Override
	public List<PodIfVo> podsGet(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PODS, vo.getNamespaceId());

		//Pod 조회 API 호출
		String reqJson =  restSender.send(url, null, headers, String.class, HttpMethod.GET).getBody();

		DocumentContext context =  JsonPath.using(configuration).parse(reqJson);

		List<PodIfVo> rtnList = new ArrayList<PodIfVo>();

		List<Object> servcPodList = AtmSclUtil.getJsonInfoList(configuration, context, reqJson, "$.items[*]");

		PodIfVo podIfVo = null;

		boolean servcPodFlag = false;

		for (Object podDetail : servcPodList) {
			context =  JsonPath.using(configuration).parse(podDetail);

			List<Object> labelList = AtmSclUtil.getJsonInfoList(configuration, context, podDetail, "$.metadata.labels");

			servcPodFlag = false;
			for (Object labelObj : labelList) {
				context =  JsonPath.using(configuration).parse(labelObj);
				if(vo.getName().equals(AtmSclUtil.getJsonInfoString(configuration, context, labelObj, "$.deploymentConfig"))) {
					servcPodFlag = true;
				}
			}

			context =  JsonPath.using(configuration).parse(podDetail);
			podIfVo = new PodIfVo();

			String buildPod = AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.metadata.labels.['openshift.io/build.name']");
			String deployPod = AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.metadata.labels.['openshift.io/deployer-pod-for.name']");

			if(buildPod != null){
				podIfVo.setPodType("03"); //빌드
			}else if(deployPod != null){
				podIfVo.setPodType("04"); //디플로이
			}else {
				if(servcPodFlag) {
					podIfVo.setPodType("01"); //서비스
				}else {
					podIfVo.setPodType("02"); //인프라
				}
			}

			podIfVo.setName(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.metadata.name"));

			podIfVo.setUid(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.metadata.uid"));
			podIfVo.setCreationTimestamp(AtmSclUtil.setCreDtDateFormater(AtmSclUtil.setCreDtDateFormater(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.metadata.creationTimestamp"))));
			podIfVo.setNodeName(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.spec.nodeName"));

			String phase = AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.status.phase");

			podIfVo.setPhase(AtmSclUtil.setPodStatCd(phase));
			podIfVo.setHostIP(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.status.hostIP"));
			podIfVo.setPodIP(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.status.podIP"));
			podIfVo.setStartTime(AtmSclUtil.setCreDtDateFormater(AtmSclUtil.setCreDtDateFormater(AtmSclUtil.getJsonInfoString(configuration, context, podDetail, "$.status.startTime"))));

			List<Object> containerStatuses = AtmSclUtil.getJsonInfoList(configuration, context, podDetail, "$.status.containerStatuses[*]");

			for (Object containerStatuse : containerStatuses) {
				context =  JsonPath.using(configuration).parse(containerStatuse);
				podIfVo.setImageID(AtmSclUtil.getJsonInfoString(configuration, context, containerStatuse, "$.imageID").replace("docker-pullable://", ""));
				break;
			}

			rtnList.add(podIfVo);

		}

		return rtnList;
	}


	/**
	 * 빌드상태 조회
	 * @param header
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo buildsGet(RestHeaders headers, BuildConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_BUILDS_PARAM, vo.getNamespaceId(), vo.getName());

		//빌드 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(reqMap);

		return atmSclResultIfVo;
	}


	/**
	 * 배포상태 조회
	 * @param header
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo replicationcontrollersStatGet(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_REPLICATIONCONTROLLERS_PARAM, vo.getNamespaceId(), vo.getName());

		//배포 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(reqMap);

		return atmSclResultIfVo;
	}


	/**
	 * Pod상태 조회
	 * @param header
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AtmSclResultIfVo podsStatGet(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception {

		//API 호출 URL
		String url = AtmSclUtil.getAtmSclAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_PODS, vo.getNamespaceId());

		//Pod 조회 API 호출
		Map<String, Object> reqMap =  restSender.send(url, null, headers, Map.class, HttpMethod.GET).getBody();

		AtmSclResultIfVo atmSclResultIfVo = AtmSclUtil.setAtmSclResultInfo(reqMap);

		return atmSclResultIfVo;
	}

	/**
	 * 빌드설정 Output 정보 셋팅
	 * @param header
	 * @param name
	 * @param kind
	 * @return
	 */
	private Map<String, Object> setBuildConfigOutputInfo(String name, String kind) {

		Map<String, Object> outputMap = new HashMap<String, Object>();
		Map<String, Object> toMap = new HashMap<String, Object>();

		toMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, name+":"+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_LATEST);
		toMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND, kind);
		outputMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_TO, toMap);

		return outputMap;
	}


	/**
	 * 빌드설정 Source 정보 셋팅
	 * @param contextDir
	 * @param uri
	 * @param ref
	 * @param secretId
	 * @param sourceType
	 * @return
	 */
	private Map<String, Object> setBuildConfigSourceInfo(String contextDir, String uri, String ref, String secretId, String sourceType ) {

		Map<String, Object> sourceMap = new HashMap<String, Object>();
		Map<String, String> gitMap = new HashMap<String, String>();
		Map<String, String> sourceSecretMap = new HashMap<String, String>();

		if(!StringUtils.isEmpty(contextDir)) {
			sourceMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CONTEXTDIR, contextDir);
		}

		gitMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_URI, uri);
		gitMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_REF, ref);

		sourceSecretMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, secretId);

		sourceMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_GIT, gitMap);
		sourceMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SOURCESECRET, sourceSecretMap);
		sourceMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, sourceType);

		return sourceMap;
	}


	/**
	 * 빌드설정 Strategy 정보 셋팅
	 * @param baseImgId
	 * @param baseImgVer
	 * @return
	 */
	private Map<String, Object> setBuildConfigStrategyInfo(String baseImgId, String baseImgVer ) {

		Map<String, Object> strategyMap = new HashMap<String, Object>();
		Map<String, Object> sourceStrategyMap = new HashMap<String, Object>();
		Map<String, String> sourceStrategyFromMap = new HashMap<String, String>();

		sourceStrategyMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_FORCEPULL, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_FORCEPULL);
		sourceStrategyFromMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_IMAGESTREAMTAG);
		sourceStrategyFromMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, baseImgId+":"+baseImgVer);
		sourceStrategyFromMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAMESPACE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BASE_NAMESPACE);

		sourceStrategyMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_FROM, sourceStrategyFromMap);

		strategyMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_BUILD_TYPE);
		strategyMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SOURCESTRATEGY, sourceStrategyMap);

		return strategyMap;
	}



	/**
	 * 배포설정의 Strategy 정보를 셋팅
	 * @return
	 */
	private Map<String, Object> setDeploymentConfigStrategyInfo() {

		Map<String, Object> strategyMap = new HashMap<String, Object>();
		Map<String, Object> rollingParams = new HashMap<String, Object>();

		rollingParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_UPDATE_PERIOD_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_UPDATE_PERIOD_SECONDS);
		rollingParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_INTERVAL_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_INTERVAL_SECONDS);
		rollingParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TIMEOUT_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_TIMEOUT_SECONDS);
		rollingParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_MAX_UNAVAILABLE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_MAX_UNAVAILABLE);
		rollingParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_MAX_MAX_SURGE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_MAX_MAX_SURGE);

		strategyMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_ROLLING_PARAMS, rollingParams);

		return strategyMap;
	}


	/**
	 * 빌드설정 Trigger 정보 셋팅
	 * @param type
	 * @return
	 */
	private List<Map<String, String>> setBuildConfigTriggersInfo(String type) {

		List<Map<String, String>> triggersList = new ArrayList<Map<String, String>>();
		Map<String, String> triggersMap = new HashMap<String, String>();

		//설정정보 변경시 트리거 추가  (type이 '01' 일경우 설정정보 변경 트리거 추가)
		if("01".equals(type)) {
			//triggersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_CONFIGCHANGE);
			//triggersList.add(triggersMap);
		}

		triggersList.add(triggersMap); //트리거는 걸지 않는 것으로 의사결정됨.

		return triggersList;
	}



	/**
	 * 배포설정 Trigger 정보 셋팅
	 * @param baseImgId
	 * @param baseImgVer
	 * @return
	 */
	private List<Map<String, Object>> setDeploymentConfigTriggersInfo(String name) {

		List<Map<String, Object>> triggersList = new ArrayList<Map<String, Object>>();
		Map<String, Object> triggersMap = null;
		Map<String, Object> imageChangeParams = new HashMap<String, Object>();
		Map<String, String> fromMap = new HashMap<String, String>();
		String containerNames[] = new String[1];

		containerNames[0] = name;

		imageChangeParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_AUTOMATIC, false);

		fromMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_KIND, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_IMAGESTREAMTAG);
		fromMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, name+":"+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_LATEST);
		imageChangeParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_FROM, fromMap);
		imageChangeParams.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_CONTAINER_NAMES, containerNames);

		triggersMap = new HashMap<String, Object>();
		triggersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_IMAGE_CHANGE);
		triggersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_IMAGE_CHANGE_PARAMS, imageChangeParams);
		triggersList.add(triggersMap);
		//triggersMap = new HashMap<String, Object>();
		//triggersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TYPE, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_CONFIGCHANGE);

		//triggersList.add(triggersMap);

		return triggersList;
	}


	/**
	 * 배포설정 Selector 정보 셋팅
	 * @param name
	 * @return
	 */
	private Map<String, String> addDeploymentConfigSelectorInfo(String name ) {

		Map<String, String> selectorMap = new HashMap<String, String>();

		selectorMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENTCONFIG, name);
		return selectorMap;
	}


	/**
	 * 배포설정 Template 정보 셋팅
	 * @param namespaceId
	 * @param baseImgName
	 * @param name
	 * @param portList
	 * @return
	 */
	private Map<String, Object> addDeploymentConfigTemplateInfo(String namespaceId, String baseImgName, String name, String imgRepoAddr, List<ContainersPortsIfVo> portList, List<EnvIfVo> envList) {

		List<Map<String, Object>> containersList = new ArrayList<Map<String, Object>>();
		Map<String, Object> templateMap = new HashMap<String, Object>();
		Map<String, Object> templateSpecMap = new HashMap<String, Object>();
		Map<String, String> metadataMap = new HashMap<String, String>();
		Map<String, Object> containersMap = new HashMap<String, Object>();
		Map<String, Object> portsMap = null; // 포트정보
		Map<String, Object> readinessProbeMap  = new HashMap<String, Object>();
		Map<String, Object> httpGetMap  = new HashMap<String, Object>();

		httpGetMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PATH, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_DEFAULT_PATH);
		httpGetMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_PORT, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_HTTP_PORT);
		httpGetMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_SCHEME, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_HTTP);

		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_HTTP_GET, httpGetMap);
		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_INITIAL_DELAY_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_INITIAL_DELAY_SECONDS);  // POD 생성 후 최초 대기시간
		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_TIMEOUT_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_READINESS_PROBE_TIMEOUT_SECONDS);  // 타임아웃
		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PERIOD_SECONDS, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_PERIOD_SECONDS);  // 요청 주기
		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_SUCCESS_THRESHOLD, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_SUCCESS_THRESHOLD);   // 성공 횟수
		readinessProbeMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_FAILURE_THRESHOLD, OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_FAILURE_THRESHOLD);  // 재전송 횟수

		List<Map<String, Object>> ports = new ArrayList<Map<String, Object>>();

		//포트정보
		for (ContainersPortsIfVo containersPortsIfVo :portList) {
			portsMap = new HashMap<String, Object>();
			portsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PROTOCOL, containersPortsIfVo.getProtocol());
			portsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CONTAINERPORT, containersPortsIfVo.getContainerPort());
			ports.add(portsMap);
		}

		//containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_IMAGE, namespaceId+"/"+name+":"+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_LATEST);
		//containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_IMAGE, name);
		containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_IMAGE, imgRepoAddr+":"+OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_LATEST);
		containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_NAME, name);
		containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_PORTS, addContainerPingPort(ports));
		//containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ENV, envList);

		//셔션 클러스터 환경변수 추가
		addSessionClustringEnv(containersMap, namespaceId, name, envList);

		//containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_PORTS, portList);

		containersMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_READINESS_PROBE, readinessProbeMap);
		containersList.add(containersMap);

		templateSpecMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_CONTAINERS, containersList);
		AtmSclUtil.putSpecInfo(templateMap,templateSpecMap);

		templateMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_METADATA, metadataMap);

		// Labels 정보를 구성한다.
		Map<String, String> labelsMap = new HashMap<String, String>();
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_APPLICATION, name);
		labelsMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_DEPLOYMENTCONFIG, name);
		AtmSclUtil.addAnnotationLabel(templateMap, null, labelsMap);

		return templateMap;
	}


	/**
	 * 컨테이너 Ping 포트 정보 셋팅
	 * @param portList
	 * @return
	 */
	private List<Map<String, Object>> addContainerPingPort(List<Map<String, Object>> portList) {

		Map<String, Object> pingPortMap = new HashMap<String, Object>();

		pingPortMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_CONTAINERPORT , OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_PING_PORT);
		pingPortMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_STR_PROTOCOL , OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_PROTOCOL_TCP);
		portList.add(pingPortMap);

		return portList;
	}


	/**
	 * 세션클러스터링 env 정보를 반영한다.
	 * @param reqMap
	 * @param annotationsMap
	 * @param labelsMap
	 * @return
	 */
	private  Map<String, Object> addSessionClustringEnv(Map<String, Object> targetMap, String namespaceId, String appId, List<EnvIfVo> envList) {

		EnvIfVo addEvnIfVo = null;

		addEvnIfVo = new EnvIfVo();
		addEvnIfVo.setName(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_OPENSHIFT_KUBE_PING_LABELS);
		addEvnIfVo.setValue("application="+appId);
		envList.add(addEvnIfVo);

		addEvnIfVo = new EnvIfVo();
		addEvnIfVo.setName(OpenShiftJsonConstant.OPENSHIFT_JSON_VAL_OPENSHIFT_KUBE_PING_NAMESPACE);
		addEvnIfVo.setValue(namespaceId);
		envList.add(addEvnIfVo);

		targetMap.put(OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_ENV, envList);

		return targetMap;
	}

}
