package nciaProject;

import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.entity.CmUsr;
import ncis.cmn.rest.util.RestUtil;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.rsrc.atmscl.dao.AtmsclDistrbDao;
import ncis.cpt.sys.btch.vo.BtchWrkVo;
import ncis.cpt.sys.user.vo.UserVo;

import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class RestTest {

	private static final String BASE_URL = "http://localhost:8080/inrest";

	@Resource(name="atmsclDistrbDao")
	private static AtmsclDistrbDao atmscldistrbDao;
	@SuppressWarnings("unused")
	private static DocumentContext context;
	public static void main(String[] args) throws Exception  {

		runSchedule();
//		getTest();
//		System.out.println();
//		postTest();
//		System.out.println();
//		putTest();
//		System.out.println();
//		deleteTest();

	}


	@SuppressWarnings("unchecked")
	private static void runSchedule() {

//		try {



//			RestUtil restUtil = new RestUtil();
//
//			RestHeaders headers = new RestHeaders();
//			headers.setSeq("GWJob0000001558");
//			headers.setAreaId("DJ");
//			headers.setZoneId("03");
//			headers.setNetworkId("A");
//			headers.setManagerId("DJ_03_A_ATS_OCP_3.4_001");
////			headers.setAuthorization("rnezSXe9y1yGDKm94oWl8HYvmFeiBGN2mgeFeYmw6uM");
//			String url = AtmSclUtil.getAtmSclDeployAPIURL(OpenShiftURIConstant.OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS,"nctc","nctc");
//			AtmSclResultIfVo atmSclDistrbConfResultInfo = new AtmSclResultIfVo();
//			//deployConfigs 조회  API 호출 (GET)
//			String jsonStr = restUtil.send(url, headers, String.class, HttpMethod.GET).getBody();
//			System.out.println(jsonStr);
//			System.out.println("This is upgrade method");
//			String json = "{  'kind': 'DeploymentConfig',  'apiVersion': 'v1',  'metadata': {    'name': 'ncms-0009-00000002',    'namespace': 'ncms-0009',    'selfLink': '/oapi/v1/namespaces/ncms-0009/deploymentconfigs/ncms-0009-00000002',    'uid': '1709a669-6768-11e7-a092-001a4a160153',    'resourceVersion': '2057724',    'generation': 4,    'creationTimestamp': '2017-07-13T01:10:41Z',    'labels': {      'app': 'jboss-eap70-openshift',      'application': 'ncms-0009-00000002'    }  },  'spec': {    'strategy': {      'type': 'Rolling',      'rollingParams': {        'updatePeriodSeconds': 1,        'intervalSeconds': 1,        'timeoutSeconds': 600,        'maxUnavailable': '25%',        'maxSurge': '0%'      },      'resources': {}    },    'triggers': [      {        'type': 'ConfigChange'      }    ],    'replicas': 1,    'test': false,    'selector': {      'deploymentConfig': 'ncms-0009-00000002'    },    'template': {      'metadata': {        'creationTimestamp': null,        'labels': {          'application': 'ncms-0009-00000002',          'deploymentConfig': 'ncms-0009-00000002'        }      },      'spec': {        'containers': [          {            'name': 'ncms-0009-00000002',            'image': '172.30.0.2:5000/ncms-0009/ncms-0009-00000002:latest',            'ports': [              {                'containerPort': 8080,                'protocol': 'TCP'              },              {                'containerPort': 8888,                'protocol': 'TCP'              }            ],            'env': [              {                'name': 'OPENSHIFT_KUBE_PING_LABELS',                'value': 'application=ncms-0009-00000002'              },              {                'name': 'OPENSHIFT_KUBE_PING_NAMESPACE',                'valueFrom': {                  'fieldRef': {                    'apiVersion': 'v1',                    'fieldPath': 'metadata.namespace'                  }                }              },              {                'name': 'MQ_CLUSTER_PASSWORD',                'value': 'PTRFnSwN'              },              {                'name': 'MQ_QUEUES'              },              {                'name': 'MQ_TOPICS'              },              {                'name': 'JGROUPS_CLUSTER_PASSWORD',                'value': 'DWmIHIL1'              }            ],            'resources': {},            'terminationMessagePath': '/dev/termination-log',            'imagePullPolicy': 'Always'          }        ],        'restartPolicy': 'Always',        'terminationGracePeriodSeconds': 30,        'dnsPolicy': 'ClusterFirst',        'securityContext': {}      }    }  },  'status': {    'latestVersion': 2,    'observedGeneration': 4,    'replicas': 1,    'updatedReplicas': 1,    'unavailableReplicas': 1,    'details': {      'message': 'config change',      'causes': [        {          'type': 'ConfigChange'        }      ]    },    'conditions': [      {        'type': 'Available',        'status': 'False',        'lastTransitionTime': '2017-07-13T01:10:41Z',        'message': 'Deployment config does not have minimum availability.'      },      {        'type': 'Progressing',        'status': 'Unknown',        'lastTransitionTime': '2017-07-13T01:16:43Z',        'message': 'Replication controller \'ncms-0009-00000002-2\' is waiting for pod \'ncms-0009-00000002-2-deploy\' to run'      }    ]  }}";
//
//			List<Map<String, Object>> mapListInfo = AtmSclUtil.getMapListInfo(json, "$.spec.template.spec.containers[*].env[*]");
//
//			List<Map<String, Object>> envList = new ArrayList<Map<String, Object>>();
//			for (Map<String, Object> map : mapListInfo) {
//				for (Map.Entry<String,Object> entry: map.entrySet()) {
//					System.out.println(entry.getKey());
//					System.out.println(entry.getValue());
//				}
//			}



			RestUtil restUtil = new RestUtil();

	        RestHeaders restHeaders = new RestHeaders();
	        restHeaders.setSeq("GWJob0000001558");
	        restHeaders.setAreaId("DJ");
	        restHeaders.setZoneId("03");
	        restHeaders.setNetworkId("A");
	        restHeaders.setManagerId("DJ_03_A_ATS_OCP_3.4_001");
			restUtil.setHeader(restHeaders);
//			String roleGetUrl = "http://10.180.245.29:8081/autoscale/namespaces/ns-a-200-0002/rolebindings/system:image-pullers";



//			String url = "http://10.180.245.29:8081/autoscale/namespaces/ncms-0019/deploymentconfigs/ncms-0019-00000001";
//			String url = "http://10.180.245.29:8081/autoscale/namespaces/test-nctc/deploymentconfigs/nctcapp";
			String url = "http://10.180.245.29:8081/autoscale/namespaces/ncms-0019/builds/ncms-0019-00000001-9";
			//"http://localhost:8081/batch/run/vmSpecChangeProcessJob"
			Map<String,Object> result = restUtil.send(url,restHeaders, Map.class, HttpMethod.GET).getBody();
//
			System.out.println("get ========================================================================");
			System.out.println(result);

			//Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(result, "$.spec.source");
			Map<String, Object> mapInfo = JsonPath.parse(result).read("$.spec.source");
			Map<String,Object> st = (Map<String, Object>) mapInfo.get("git");
			System.out.println(mapInfo.get("type"));
			System.out.println(st.get("uri"));
			System.out.println(st.get("ref"));
			String sname = JsonPath.parse(result).read("$.spec.output.to.name");
			String[] split = sname.split(":");

			System.out.println(split[0]);
			System.out.println(split[1]);
//			AtmSclResultIfVo setAtmSclResultInfo = AtmSclUtil.setAtmSclResultInfo(result);
//
//			System.out.println(setAtmSclResultInfo.getDeploymentPhase());


//yyyy-MM-dd hh:mm:ss.SSS
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
//			Date parsedDate;
//			try {
//				parsedDate = dateFormat.parse("20170918 110559");
//				Timestamp ts = new Timestamp(parsedDate.getTime());
//				System.out.println(ts);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			//System.out.println(result);
//			String delMapInfo = AtmSclUtil.delMapInfo(context, result, "$.metadata.resourceVersion");
//			//System.out.println(delMapInfo);
//			Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(result, "$");
//			String upCheck = String.valueOf(mapInfo.get("status"));
//			System.out.println(upCheck);
//			if(upCheck == null)
//			{
//				System.out.println(123);
//			}
//			System.out.println(ObjectUtils.isEmpty((mapInfo.get("status"))));
			//호출결과 셋팅
//			if(ObjectUtils.isEmpty(upCheck)){
//				atmSclUpdatResultIfVo.setSuccYn("Y");
//			}else{
//				atmSclUpdatResultIfVo.setSuccYn("N");
//			}
			/*
			List<String> list = new ArrayList<String>();
			list.add("system:serviceaccount:openshift:default12313213123");
			String putMapInfoRole = AtmSclUtil.putMapInfoRole(context, result, "$", "userNames", list);
			System.out.println(putMapInfoRole);
//			System.out.println(jsonArr2.get(0));
//			String delMapInfo = AtmSclUtil.delMapInfo(context, result,  "$.spec.template.spec.volumes");
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(putMapInfoRole);
			JsonArray jsonArr = element.getAsJsonArray();
			Map<String,Object> saMap = new HashMap<String, Object>();
			saMap.put("kind", "ServiceAccount");
			saMap.put("namespace", "openshift");
			saMap.put("name", "default");
			List<Map<String, Object>> mapListInfo = AtmSclUtil.getMapListInfo(result, "$.subjects");

			mapListInfo.add(saMap);
			String putMapInfo = AtmSclUtil.putMapInfo(context, jsonArr.get(0).toString(), "$", "subjects", mapListInfo);
			System.out.println(putMapInfo);
*/
			//AtmSclUtil.setMapInfo(context, jsonArr.get(0).toString(), "$", "subjects", list);

//
//			String delMapInfo2 = AtmSclUtil.delMapInfo(context, jsonArr.get(0).toString(),  "$.spec.template.spec.containers[*].volumeMounts");
//			System.out.println(delMapInfo2);
//			Map<String, Object> cpuUtilMap = new HashMap<String, Object>();
//			Map<String, Object> cpuUtilInfoMap = new HashMap<String, Object>();
//
//			Map<String, Object> replicaMap = new HashMap<String, Object>();
//
//			cpuUtilInfoMap.put("targetPercentage","값");
//			cpuUtilMap.put("cpuUtilization",cpuUtilInfoMap);
//
//			replicaMap.put("maxReplicas","값");
//			replicaMap.put("minReplicas","값");


//			String setMapInfo = AtmSclUtil.putMapInfo(context, result, "$","spec", replicaMap );
//			System.out.println(setMapInfo);

//Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(result, "$.spec");
//System.out.println(mapInfo);
//			mapInfo.put("minReplicas",0);
//			mapInfo.put("maxReplicas",0);
//			Map<String, Object> cpuMap = (Map<String, Object>) mapInfo.get("cpuUtilization");
//			cpuMap.put("targetPercentage",100);
//
//			mapInfo.put("cpuUtilization",cpuMap);
//
//			System.out.println(mapInfo);
//
//			String putMapInfo = AtmSclUtil.putMapInfo(context, result, "$", "spec", mapInfo);
//			System.out.println(putMapInfo);
//			AtmSclUtil.setMapInfo(context, result, "$.spec", "maxReplicas", "값" );

//			Map<String, Object> gitMap = new HashMap<String, Object>();
//			Map<String, Object> sourceMap = new HashMap<String, Object>();
//			Map<String, Object> strategyMap = new HashMap<String, Object>();
//
//			gitMap.put("uri", "test");
//			gitMap.put("ref","test");
//			sourceMap.put("name","11");
//			strategyMap.put("name","open:1.4");
//			 AtmSclUtil.putMapInfo(context, result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_SOURCE, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_GIT, gitMap );
//			 AtmSclUtil.putMapInfo(context, result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_SOURCE, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_SOURCESECRET, sourceMap );
//			 Map<String, Object> mapInfo = AtmSclUtil.getMapInfo(result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_STRATEGY_FROM);
//
//			 mapInfo.put("name","open:1.4");
//
//			 String putMapInfo = AtmSclUtil.putMapInfo(context, result, OpenShiftPathConstant.OPENSHIFT_JSON_PATH_BUILD_STRATEGY, OpenShiftJsonConstant.OPENSHIFT_JSON_OBJ_FROM, mapInfo );
//
//			JsonParser parser = new JsonParser();
//			JsonElement element = parser.parse(putMapInfo);
//			JsonArray jsonArr = element.getAsJsonArray();




/*		Map<String, Object> metaMap = new HashMap<String, Object>();
		Map<String, Object> metaInfoMap = new HashMap<String, Object>();
		Map<String, Object> metaInfoLblMap = new HashMap<String, Object>();

		metaInfoLblMap.put("app","서비스값");
		metaInfoMap.put("labels",metaInfoLblMap);
		metaInfoMap.put("name","서비스값");
		metaMap.put("metadata",metaInfoMap);

		Map<String, Object> cpuPerMap = new HashMap<String, Object>();
		Map<String, Object> specMap = new HashMap<String, Object>();
		Map<String, Object> scaleRefMap = new HashMap<String, Object>();
		Map<String, Object> scaleRefInfoMap = new HashMap<String, Object>();


		cpuPerMap.put("targetPercentage","값");
		scaleRefInfoMap.put("kind","DeploymentConfig");
		scaleRefInfoMap.put("name","값");
		scaleRefInfoMap.put("apiVersion","extensions/v1beta1");
		scaleRefInfoMap.put("subresource","scale");
		scaleRefMap.put("scaleRef",scaleRefInfoMap);
		specMap.put("minReplicas","값");
		specMap.put("maxReplicas","값");
		specMap.put("cpuUtilization",cpuPerMap);
		specMap.putAll(scaleRefMap);
		metaMap.put("spec",specMap);

		System.out.println(metaMap);
*/



//
//			List<Map<String, Object>> mapListInfo = AtmSclUtil.getMapListInfo(result, "$.spec.template.spec.containers[*].env[*]");
//
//			List<Map<String, Object>> envNewList = new ArrayList<Map<String, Object>>();
//
//						DistrbEnvConfVo disConf = new DistrbEnvConfVo();
//						List<DistrbEnvConfVo> list = new ArrayList<DistrbEnvConfVo>();
//						disConf.setEnvVarNm("BB");
//						disConf.setEnvVarVl("11");
//						list.add(disConf);
//						disConf = new DistrbEnvConfVo();
//						disConf.setEnvVarNm("AUTO_DEPLOY_EXPLODED");
//						disConf.setEnvVarVl("false");
//						list.add(disConf);
//						disConf = new DistrbEnvConfVo();
//						disConf.setEnvVarNm("JGROUPS_CLUSTER_PASSWORD");
//						disConf.setEnvVarVl("S0MhsTEO");
//						list.add(disConf);
//						disConf = new DistrbEnvConfVo();
//						disConf.setEnvVarNm("MQ_CLUSTER_PASSWORD");
//						disConf.setEnvVarVl("FxLjlTN3");
//						list.add(disConf);
//						disConf = new DistrbEnvConfVo();
//						disConf.setEnvVarNm("OPENSHIFT_KUBE_PING_LABELS");
//						disConf.setEnvVarVl("application=test-lyh");
//						list.add(disConf);
//						disConf = new DistrbEnvConfVo();
//						for (DistrbEnvConfVo distrbEnvConfVo : list) {
//							Map<String,Object> map = new HashMap<String, Object>();
//							map.put("name",distrbEnvConfVo.getEnvVarNm());
//							map.put("value", distrbEnvConfVo.getEnvVarVl());
//							envNewList.add(map);
//						}
//
//						DistrbEnvConfVo exConf = new DistrbEnvConfVo();
//						List<DistrbEnvConfVo> exlist = new ArrayList<DistrbEnvConfVo>();
//						exConf.setEnvVarNm("MQ_QUEUES");
//						exConf.setEnvVarVl("");
//						exlist.add(exConf);
//						exConf = new DistrbEnvConfVo();
//						exConf.setEnvVarNm("MQ_TOPICS");
//						exConf.setEnvVarVl("");
//						exlist.add(exConf);
//						exConf = new DistrbEnvConfVo();
//						exConf.setEnvVarNm("OPENSHIFT_KUBE_PING_NAMESPACE");
//						exConf.setEnvVarVl("{fieldRef={apiVersion=v1, fieldPath=metadata.namespace}}");
//						exlist.add(exConf);
//						exConf = new DistrbEnvConfVo();
//
//						for (DistrbEnvConfVo exVo : exlist) {
//							System.out.println("new ::"+exVo.getEnvVarNm());
//							for (Map<String, Object> exMap : mapListInfo) {
//
//								if(exMap.get("name").equals(exVo.getEnvVarNm())){
//									envNewList.add(exMap);
//								}
//
//							}
//						}
//
//
//						System.out.println(envNewList);
//
//
//			//System.out.println("USER ID : " + result.getBody().getProcType());
//		} catch (HttpStatusCodeException e ) {
//			System.out.println(e.getResponseBodyAsString());
//		}

	}

	@SuppressWarnings("unused")
	private static void getTest() {

		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<UserVo> result = restTemplate.exchange(BASE_URL + "/user/admin", HttpMethod.GET, getEntity(), UserVo.class);
		//UserVo user = restTemplate.getForObject(BASE_URL + "/user/admin", UserVo.class);
		System.out.println("GET ========================================================================");
		System.out.println("USER ID : " + result.getBody().getUserId());
		System.out.println("USER NAME : " + result.getBody().getUserNm());

	}

	@SuppressWarnings("unused")
	private static void postTest() {

//		CmUsr user = new CmUsr();
//		user.setUserId("admin");
//		user.setUserNm("관리자");

		BtchWrkVo wrkVo = new BtchWrkVo();
        wrkVo.setBtchWrkFileNm("/test/test.sh");
        wrkVo.setExeOptn("-DJava=1.8");

		RestUtil restUtil = new RestUtil();
		RestHeaders headers = new RestHeaders();
        headers.setAuthorization(PropertiesUtil.getProperty("duplexing.server.token"));
		restUtil.setHeader(headers);
//		ResponseEntity<ProcResultVo> result = restUtil.send("http://localhost:8080/ncms/rest/batch/executeShell", wrkVo, ProcResultVo.class, HttpMethod.POST);

		CmUsr user = new CmUsr();
		user.setUserId("admin");
		user.setUserNm("관리자");
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<ProcResultVo> result = restTemplate.exchange(BASE_URL + "/user", HttpMethod.POST, getEntity(user), ProcResultVo.class);
		//ProcResultVo result = restTemplate.postForObject(BASE_URL + "/user", user, ProcResultVo.class);
		System.out.println("Post ========================================================================");
		System.out.println(result.getBody());
	}

	@SuppressWarnings("unused")
	private static void putTest() {
		RestTemplate restTemplate = getRestTemplate();

//		CmUsr user = new CmUsr();
//		user.setUserId("admin");
//		user.setUserNm("관리자");

		BtchWrkVo wrkVo = new BtchWrkVo();
		wrkVo.setBtchWrkFileNm("/test/test.sh");
		wrkVo.setExeOptn("-DJava=1.8");



		ResponseEntity<ProcResultVo> result = restTemplate.exchange(BASE_URL + "/cmn/component/batch/executeShell", HttpMethod.POST, getEntity(wrkVo), ProcResultVo.class);
		System.out.println("PUT ========================================================================");
		System.out.println(result.getBody());
	}

	@SuppressWarnings("unused")
	private static void deleteTest() {
		RestTemplate restTemplate = getRestTemplate();

		ResponseEntity<ProcResultVo> result = restTemplate.exchange(BASE_URL + "/user/admin", HttpMethod.DELETE, getEntity(), ProcResultVo.class);
		System.out.println("DELETE ========================================================================");
		System.out.println(result.getBody());
	}

	private static <T> HttpEntity<T> getEntity(T obj) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("RegionId", "DJ");
		headers.add("ManageId", "managerId");
		headers.add("NetworkId", "NetworkId");
        headers.add("Authorization", "9afb5efac99c495f5ddb4de6aef68693");
		HttpEntity<T> entity = new HttpEntity<T>(obj, headers);
		return entity;
	}

	private static HttpEntity<String> getEntity() {
		return getEntity("");
	}


	private static ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        factory.setReadTimeout(2000);
        factory.setConnectTimeout(2000);
        return factory;
    }

	private static RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML));
//		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);


//		//Header 설정
//		List<ClientHttpRequestInterceptor> headers = new ArrayList<ClientHttpRequestInterceptor>();
//		headers.add(new ClientHttpRequestInterceptor() {
//			@Override
//		    public ClientHttpResponse intercept(
//		            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//		            throws IOException {
//
//		        HttpHeaders headers = request.getHeaders();
//		        headers.add("Authorization", "9afb5efac99c495f5ddb4de6aef68693");
//		        return execution.execute(request, body);
//		    }
//		});
//		restTemplate.setInterceptors(headers);

		return restTemplate;
	}



}
