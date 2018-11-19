/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykApiServiceImpl.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 11. 1.
 * @lastmodified 2016. 11. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 1.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.api.cmn.tyk.service.TykApiService;
import ncis.api.cmn.tyk.vo.AuthProviderVo;
import ncis.api.cmn.tyk.vo.AuthVo;
import ncis.api.cmn.tyk.vo.CORSVo;
import ncis.api.cmn.tyk.vo.CacheOptionsVo;
import ncis.api.cmn.tyk.vo.DefinitionVo;
import ncis.api.cmn.tyk.vo.EventHandlersVo;
import ncis.api.cmn.tyk.vo.ExtendedPathsVo;
import ncis.api.cmn.tyk.vo.GlobalheadersVo;
import ncis.api.cmn.tyk.vo.IgnoreGetVo;
import ncis.api.cmn.tyk.vo.IgnoredHeadersVo;
import ncis.api.cmn.tyk.vo.IgnoredVo;
import ncis.api.cmn.tyk.vo.MethodActionsVo;
import ncis.api.cmn.tyk.vo.ProxyVo;
import ncis.api.cmn.tyk.vo.ServiceDiscoveryVo;
import ncis.api.cmn.tyk.vo.SessionProviderVo;
import ncis.api.cmn.tyk.vo.TykApiResponseVo;
import ncis.api.cmn.tyk.vo.TykApiVo;
import ncis.api.cmn.tyk.vo.TykKeyVo;
import ncis.api.cmn.tyk.vo.VersionDataVo;
import ncis.api.cmn.tyk.vo.VersionNameVo;
import ncis.api.cmn.tyk.vo.VersionsVo;
import ncis.api.cmn.tyk.vo.VirtualPathVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.service.RestService;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.rest.vo.RestInfo;
import ncis.cmn.util.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


/**
 * @author 이제율
 *
 */
@Service("tykApiService")
public class TykApiServiceImpl implements TykApiService{
	private static final String BASE_URL = "/tyk";
	private final ParameterizedTypeReference<TykApiResponseVo> KEY_RESPONSE = new ParameterizedTypeReference<TykApiResponseVo>() {};
	protected RestInfo restInfo;
	//private static final Logger LOGGER = LoggerFactory.getLogger(TykApiServiceImpl.class);

	@Autowired
	private CouchDBRestTemplate template;

	@Resource(name="restSender")
	private RestSender restSender;

	@Resource(name="restService")
	private RestService restService;

	/**
	 * tyk api 등록
	 * @param tykApivo tyk api 생성을 위한 json 파라미터
	 */
	@Override
	public TykApiResponseVo insertTykApi(TykApiVo tykApiVo) throws Exception {
//		OpenidOptionsVo openidOptionsVo = new OpenidOptionsVo();
//		OauthMetaVo oauthMetaVo = new OauthMetaVo();
		AuthVo authVo = new AuthVo();

//		NotificationsVo notificationsVo = new NotificationsVo();
		DefinitionVo definitionVo = new DefinitionVo();

		VersionDataVo versionDataVo = new VersionDataVo();
		VersionsVo versionsVo = new VersionsVo();
		VersionNameVo versionNameVo =  new VersionNameVo();
		GlobalheadersVo globalheadersVo = new GlobalheadersVo();
//		PathsVo pathsVo = new PathsVo();

		ExtendedPathsVo extendedPathsVo = new ExtendedPathsVo(); //ignore 추가 필요
//		UptimeTestsVo uptimeTestsVo = new UptimeTestsVo();
//		ConfigVo configVo = new ConfigVo();
//		ServiceDiscoveryVo configServiceDiscoveryVo = new ServiceDiscoveryVo();

		ProxyVo proxyVo = new ProxyVo();
		ServiceDiscoveryVo proxyServiceDiscoveryVo = new ServiceDiscoveryVo();

//		CustomMiddlewareVo customMiddlewareVo = new CustomMiddlewareVo();
		CacheOptionsVo cacheOptionsVo = new CacheOptionsVo();
		AuthProviderVo authProviderVo = new AuthProviderVo();
		SessionProviderVo sessionProviderVo = new SessionProviderVo();

		EventHandlersVo eventHandlersVo = new EventHandlersVo();

		CORSVo corsVo = new CORSVo();

//		tykApiVo.setOpenid_options(openidOptionsVo);
//		tykApiVo.setOauth_meta(oauthMetaVo);
		tykApiVo.setAuth(authVo);
//		tykApiVo.setNotifications(notificationsVo);
		tykApiVo.setDefinition(definitionVo);
		tykApiVo.setVersion_data(versionDataVo);
//		tykApiVo.setUptime_tests(uptimeTestsVo);
		tykApiVo.setProxy(proxyVo);
//		tykApiVo.setCustom_middleware(customMiddlewareVo);
		tykApiVo.setCache_options(cacheOptionsVo);
		tykApiVo.setAuth_provider(authProviderVo);
		tykApiVo.setSession_provider(sessionProviderVo);
		tykApiVo.setEvent_handlers(eventHandlersVo);
		tykApiVo.setCors(corsVo);

		proxyVo.setService_discovery(proxyServiceDiscoveryVo);
//		uptimeTestsVo.setConfig(configVo);
//		configVo.setService_discovery(configServiceDiscoveryVo);
		versionDataVo.setVersions(versionsVo);
		versionsVo.setVerName(versionNameVo);

//		defaultVo.setPaths(pathsVo);
		versionNameVo.setExtended_paths(extendedPathsVo);
		versionNameVo.setGlobal_headers(globalheadersVo);



		/**변경부분 설정(호출쪽에서 입력해야 함) 시작 : API정보 */
		// 처리요 : 나중에 true로 변경해야 함
		tykApiVo.setEnable_ip_whitelisting(false);
		tykApiVo.getProxy().setListen_path(tykApiVo.getListenPath());
		/**변경부분 설정 끝 */

		// 공통 healthcheck
		List<IgnoredVo> ignoredVoList = new ArrayList<IgnoredVo>();
		IgnoredVo ignoredVo = new IgnoredVo();
		MethodActionsVo methodActionsVo = new MethodActionsVo();
		IgnoreGetVo ignoreGetVo = new IgnoreGetVo();
		IgnoredHeadersVo ignoredHeadersVo = new IgnoredHeadersVo();

		ignoredVo.setMethod_actions(methodActionsVo);
		methodActionsVo.setGet(ignoreGetVo);
		ignoreGetVo.setHeaders(ignoredHeadersVo);


		ignoredVoList.add(ignoredVo);

		tykApiVo.getVersion_data().getVersions().getVerName().getExtended_paths().setIgnored(ignoredVoList);


		// 공통 global header 설정
		tykApiVo.getVersion_data().getVersions().getVerName().getGlobal_headers().setAccept("application/json");

		/** URL / 인경우에만 처리   : 시작 조건절 필요*/
		if("root".equals(tykApiVo.getUrlType())){
			// "/" API virtualPath 설정
			List<VirtualPathVo> virtualPathVoList = new ArrayList<VirtualPathVo>();
			VirtualPathVo virtualPathGETVo = new VirtualPathVo();
			VirtualPathVo virtualPathPOSTVo = new VirtualPathVo();
			VirtualPathVo virtualPathPUTVo = new VirtualPathVo();
			VirtualPathVo virtualPathDELETEVo = new VirtualPathVo();

			virtualPathGETVo.setResponse_function_name("virGet");
			virtualPathGETVo.setFunction_source_type("file");
			virtualPathGETVo.setFunction_source_uri("/opt/tyk-gateway/middleware/virFunc.js");
			virtualPathGETVo.setPath("/{path}");
			virtualPathGETVo.setMethod("GET");

			virtualPathPOSTVo.setResponse_function_name("virPost");
			virtualPathPOSTVo.setFunction_source_type("file");
			virtualPathPOSTVo.setFunction_source_uri("/opt/tyk-gateway/middleware/virFunc.js");
			virtualPathPOSTVo.setPath("/{path}");
			virtualPathPOSTVo.setMethod("POST");

			virtualPathPUTVo.setResponse_function_name("virPut");
			virtualPathPUTVo.setFunction_source_type("file");
			virtualPathPUTVo.setFunction_source_uri("/opt/tyk-gateway/middleware/virFunc.js");
			virtualPathPUTVo.setPath("/{path}");
			virtualPathPUTVo.setMethod("PUT");

			virtualPathDELETEVo.setResponse_function_name("virDelete");
			virtualPathDELETEVo.setFunction_source_type("file");
			virtualPathDELETEVo.setFunction_source_uri("/opt/tyk-gateway/middleware/virFunc.js");
			virtualPathDELETEVo.setPath("/{path}");
			virtualPathDELETEVo.setMethod("DELETE");

			virtualPathVoList.add(virtualPathGETVo);
			virtualPathVoList.add(virtualPathPOSTVo);
			virtualPathVoList.add(virtualPathPUTVo);
			virtualPathVoList.add(virtualPathDELETEVo);

			tykApiVo.getVersion_data().getVersions().getVerName().getExtended_paths().setVirtual(virtualPathVoList);
		}
		/** URL / 인경우에만 처리   : 끝*/

		/** 서비스 디스커버리 사용여부   : 시작 조건절 필요*/
		if("Y".equals(tykApiVo.getSvcDscvryYn())){
			// 서비스 디스커버리 사용
			tykApiVo.getProxy().setTarget_url(""); // 공백
			tykApiVo.getProxy().setEnable_load_balancing(true);
			tykApiVo.getProxy().getService_discovery().setUse_discovery_service(true);
			//todo
			tykApiVo.getProxy().getService_discovery().setQuery_endpoint(tykApiVo.getSvcDscvryQueryEp());
		}else{
			// 서비스 디스커버리 미사용
			tykApiVo.getProxy().setTarget_url(tykApiVo.getSvcDscvryQueryEp());
			tykApiVo.getProxy().setEnable_load_balancing(false);
			tykApiVo.getProxy().getService_discovery().setUse_discovery_service(false);
			tykApiVo.getProxy().getService_discovery().setQuery_endpoint("");	// 공백
		}

		/** 서비스 디스커버리 사용여부   : 끝*/

		/** 현재 정의된 API (uri)
		 * stm 연계(외부)	: /					< 제어권한을 가진 시스템의 IP			< 제어권한 필요
		 * stm 연계(내부)	: /dj03i, dj03a		< 127.0.0.1					< 권한 없음(127.0.0.1 만 허용
		 * ntops		: /ntop				< ntops 요청 권한을 가진 시스템의 IP	< tops 요청 권한 필요
		 * portal		: /portals			< 포털 요청권한을 가진 시스템의 IP		< 포털 요청권한 필요
		 */



			/** 사용자의 승인 처리여부   : 시작 조건절 필요*/
			// if api_id = stm 연계(내부)
			//	List<String> allowedIpsList = new ArrayList<String>();
			//	allowedIpsList.add("127.0.0.1");	// 호출쪽에서 세팅
			//tykApiVo.setAllowed_ips(allowedIpsList);
			List<String> allowedIpsList = new ArrayList<String>();
			allowedIpsList = tykApiVo.getAllowed_ips();
			allowedIpsList.add("127.0.0.1");
			tykApiVo.setAllowed_ips(allowedIpsList);


			RestHeaders headers = new RestHeaders();
			headers.setAreaId(tykApiVo.getRegionId());
			headers.setxTykAuthorization(PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));

		/** 사용자의 승인 처리여부   : 끝*/

		return restSender.send(BASE_URL + "/apis/", tykApiVo, headers, TykApiResponseVo.class, HttpMethod.POST).getBody();
	}

	/**
	 * @author 이제율
	 * @return
	 *
	 */
	@Override
	public TykApiResponseVo insertTykKey(TykKeyVo tykKeyVo) throws Exception {

		// policy 제거
		Map<String, Object> keyApi = new HashMap<String, Object>();
		Map<String, Object> apis = new HashMap<String, Object>();
		Map<String, Object> apiInfo;

		// API정보 세팅
		for(int i=0; i<tykKeyVo.getOpenApiId().size(); i++){	// 권한에 있는 API 갯수
			apiInfo = new HashMap<String, Object>();
			List<String> version = new ArrayList<String>();
			String api_id = tykKeyVo.getOpenApiId().get(i);		// api id - 권한에 속해있는 api들의 id
			version.add("Default");							   	// api version- Default

			apiInfo.put("api_id", api_id);
			apiInfo.put("api_name", api_id);
			apiInfo.put("versions", version);
			apis.put(api_id, apiInfo);
		}

		/** 공통부분  */
		keyApi.put("allowance", 1000);
		keyApi.put("rate", 1000);
		keyApi.put("per", 1);
		keyApi.put("expires", -1);
		keyApi.put("quota_max", -1);
		keyApi.put("quota_renews", 1449051461);
		keyApi.put("quota_remaining", -1);
		keyApi.put("quota_renewal_rate", 60);
		keyApi.put("access_rights", apis);
		/** 공통부분 */

		// 키생성시에는 key정보가 필요없음
		String baseurl = BASE_URL+"/keys/create";

		restInfo = restService.selectConnectInfo(tykKeyVo.getRegionId());// 호스트 정보 디비에서 가져오는 부분.
		String url = new StringBuffer().append(restInfo.getHost()).append(baseurl).toString();

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-tyk-authorization", PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));

		return template.post(url, null, keyApi, KEY_RESPONSE, headers);

	}

	/**
	 * @author 이제율
	 * @return
	 *
	 */
	@Override
	public TykApiResponseVo deleteTykApi(TykApiVo tykApiVo) throws Exception {
		RestHeaders headers = new RestHeaders();
		headers.setAreaId(tykApiVo.getRegionId());
		headers.setxTykAuthorization(PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));
		String apiId = tykApiVo.getApi_id();

		return restSender.send(BASE_URL + "/apis/"+apiId, headers, TykApiResponseVo.class, HttpMethod.DELETE).getBody();
	}

	/**
	 * @author 이제율
	 * @return
	 *
	 */
	@Override
	public TykApiResponseVo updateTykKey(TykKeyVo tykKeyVo) throws Exception {
//		RestHeaders headers = new RestHeaders();
//		headers.setAreaId(tykKeyVo.getRegionId());
//		headers.setxTykAuthorization(PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));
//
//		String key = tykKeyVo.getKeyId();
//
//		return restSender.send(BASE_URL + "/keys/"+key, tykKeyVo, headers, TykApiResponseVo.class, HttpMethod.PUT).getBody();

		// policy 제거
		Map<String, Object> keyApi = new HashMap<String, Object>();
		Map<String, Object> apis = new HashMap<String, Object>();
		Map<String, Object> apiInfo;

		// openAPI정보 세팅
		for(int i=0; i<tykKeyVo.getOpenApiId().size(); i++){	// 권한에 있는 API 갯수
			apiInfo = new HashMap<String, Object>();
			List<String> version = new ArrayList<String>();
			String api_id = tykKeyVo.getOpenApiId().get(i);		// api id - 권한에 속해있는 api들의 id
			version.add("Default");							   	// api version- Default

			apiInfo.put("api_id", api_id);
			apiInfo.put("api_name", api_id);
			apiInfo.put("versions", version);
			apis.put(api_id, apiInfo);
		}

		/** 공통부분 */
		keyApi.put("allowance", 1000);
		keyApi.put("rate", 1000);
		keyApi.put("per", 1);
		keyApi.put("expires", -1);
		keyApi.put("quota_max", -1);
		keyApi.put("quota_renews", 1449051461);
		keyApi.put("quota_remaining", -1);
		keyApi.put("quota_renewal_rate", 60);
		keyApi.put("access_rights", apis);
		/** 공통부분 */

		// 키 가져옴
		String key = tykKeyVo.getKeyId();
		String baseurl = BASE_URL+"/keys/"+key;

		restInfo = restService.selectConnectInfo(tykKeyVo.getRegionId());// 호스트 정보 디비에서 가져오는 부분.
		String url = new StringBuffer().append(restInfo.getHost()).append(baseurl).toString();

		HttpHeaders headers = new HttpHeaders();
		headers.set("x-tyk-authorization", PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));

		return template.post(url, null, keyApi, KEY_RESPONSE, headers);
	}

	/**
	 * @author 이제율
	 *
	 */
	@Override
	public TykApiResponseVo deleteTykKey(TykKeyVo tykKeyVo) throws Exception {
		RestHeaders headers = new RestHeaders();
		headers.setAreaId(tykKeyVo.getRegionId());
		headers.setxTykAuthorization(PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));

		String key = tykKeyVo.getKeyId();

		// /keys/{key}
		return restSender.send(BASE_URL + "/keys/"+key, headers, TykApiResponseVo.class, HttpMethod.DELETE).getBody();
	}

	/**
	 * @author 이제율
	 *
	 */
	@Override
	public TykApiResponseVo reloadTyk(String regionId) throws Exception {
		RestHeaders headers = new RestHeaders();
		headers.setAreaId(regionId);
		headers.setxTykAuthorization(PropertiesUtil.getProperty("gatewy.tyk.CtrlKey"));

		return restSender.send(BASE_URL + "/reload/", headers, TykApiResponseVo.class, HttpMethod.GET).getBody();
	}


}
