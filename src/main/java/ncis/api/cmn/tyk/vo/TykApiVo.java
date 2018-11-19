/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykApiVo.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     이제율        	 v1.0    	         최초생성
 *
 */
package ncis.api.cmn.tyk.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 이제율
 *
 */
public class TykApiVo {
	private String id = "57b58da93283560a57000001";
	private String name;
	private String slug;
	private String api_id;
	private String org_id = "57849d033283560a63000001";
	private boolean use_keyless = false;
	private boolean use_oauth2 = false;
	private boolean use_openid = false;
	private OpenidOptionsVo openid_options;
	private OauthMetaVo oauth_meta;
	private AuthVo auth;
	private boolean use_basic_auth = false;
	private boolean enable_jwt = false;
	private String jwt_signing_method;
	private String jwt_source;
	private String jwt_identity_base_field;
	private String jwt_client_base_field;
	private String jwt_policy_field_name;
	private NotificationsVo notifications;
	private boolean enable_signature_checking = false;
	private Integer hmac_allowed_clock_skew = -1;
	private DefinitionVo definition;
	private VersionDataVo version_data;
	private UptimeTestsVo uptime_tests;
	private ProxyVo proxy;
	private CustomMiddlewareVo custom_middleware;
	private CacheOptionsVo cache_options;
	private Integer session_lifetime = 0;
	private boolean active = true;
	private AuthProviderVo auth_provider;
	private SessionProviderVo session_provider;
	private EventHandlersVo event_handlers;
	private boolean enable_batch_request_support = false;
	private boolean enable_ip_whitelisting = false;
	private List<String> allowed_ips;
	private boolean dont_set_quota_on_create = false;
	private Integer expire_analytics_after = 0;
	private List<String> response_processors;
	@JsonProperty("CORS")
	private CORSVo cors;
	private String domain;
	private boolean do_not_track;
	private List<String> tags;
	private boolean enable_context_vars = false;
	/** url구분자 */
	private String urlType;
	private String listenPath;
	/** 서비스디스커버리 사용여부 */
	private String svcDscvryYn;
	private String svcDscvryQueryEp;
	/** 사용자의 승인여부 */
	private String userConfirm;
	/** resion정보 */
	private String regionId;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * @return the api_id
	 */
	public String getApi_id() {
		return api_id;
	}
	/**
	 * @param api_id the api_id to set
	 */
	public void setApi_id(String api_id) {
		this.api_id = api_id;
	}
	/**
	 * @return the org_id
	 */
	public String getOrg_id() {
		return org_id;
	}
	/**
	 * @param org_id the org_id to set
	 */
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	/**
	 * @return the use_keyless
	 */
	public boolean isUse_keyless() {
		return use_keyless;
	}
	/**
	 * @param use_keyless the use_keyless to set
	 */
	public void setUse_keyless(boolean use_keyless) {
		this.use_keyless = use_keyless;
	}
	/**
	 * @return the use_oauth2
	 */
	public boolean isUse_oauth2() {
		return use_oauth2;
	}
	/**
	 * @param use_oauth2 the use_oauth2 to set
	 */
	public void setUse_oauth2(boolean use_oauth2) {
		this.use_oauth2 = use_oauth2;
	}
	/**
	 * @return the use_openid
	 */
	public boolean isUse_openid() {
		return use_openid;
	}
	/**
	 * @param use_openid the use_openid to set
	 */
	public void setUse_openid(boolean use_openid) {
		this.use_openid = use_openid;
	}
	/**
	 * @return the openid_options
	 */
	public OpenidOptionsVo getOpenid_options() {
		return openid_options;
	}
	/**
	 * @param openid_options the openid_options to set
	 */
	public void setOpenid_options(OpenidOptionsVo openid_options) {
		this.openid_options = openid_options;
	}
	/**
	 * @return the oauth_meta
	 */
	public OauthMetaVo getOauth_meta() {
		return oauth_meta;
	}
	/**
	 * @param oauth_meta the oauth_meta to set
	 */
	public void setOauth_meta(OauthMetaVo oauth_meta) {
		this.oauth_meta = oauth_meta;
	}
	/**
	 * @return the auth
	 */
	public AuthVo getAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(AuthVo auth) {
		this.auth = auth;
	}
	/**
	 * @return the use_basic_auth
	 */
	public boolean isUse_basic_auth() {
		return use_basic_auth;
	}
	/**
	 * @param use_basic_auth the use_basic_auth to set
	 */
	public void setUse_basic_auth(boolean use_basic_auth) {
		this.use_basic_auth = use_basic_auth;
	}
	/**
	 * @return the enable_jwt
	 */
	public boolean isEnable_jwt() {
		return enable_jwt;
	}
	/**
	 * @param enable_jwt the enable_jwt to set
	 */
	public void setEnable_jwt(boolean enable_jwt) {
		this.enable_jwt = enable_jwt;
	}
	/**
	 * @return the jwt_signing_method
	 */
	public String getJwt_signing_method() {
		return jwt_signing_method;
	}
	/**
	 * @param jwt_signing_method the jwt_signing_method to set
	 */
	public void setJwt_signing_method(String jwt_signing_method) {
		this.jwt_signing_method = jwt_signing_method;
	}
	/**
	 * @return the jwt_source
	 */
	public String getJwt_source() {
		return jwt_source;
	}
	/**
	 * @param jwt_source the jwt_source to set
	 */
	public void setJwt_source(String jwt_source) {
		this.jwt_source = jwt_source;
	}
	/**
	 * @return the jwt_identity_base_field
	 */
	public String getJwt_identity_base_field() {
		return jwt_identity_base_field;
	}
	/**
	 * @param jwt_identity_base_field the jwt_identity_base_field to set
	 */
	public void setJwt_identity_base_field(String jwt_identity_base_field) {
		this.jwt_identity_base_field = jwt_identity_base_field;
	}
	/**
	 * @return the jwt_client_base_field
	 */
	public String getJwt_client_base_field() {
		return jwt_client_base_field;
	}
	/**
	 * @param jwt_client_base_field the jwt_client_base_field to set
	 */
	public void setJwt_client_base_field(String jwt_client_base_field) {
		this.jwt_client_base_field = jwt_client_base_field;
	}
	/**
	 * @return the jwt_policy_field_name
	 */
	public String getJwt_policy_field_name() {
		return jwt_policy_field_name;
	}
	/**
	 * @param jwt_policy_field_name the jwt_policy_field_name to set
	 */
	public void setJwt_policy_field_name(String jwt_policy_field_name) {
		this.jwt_policy_field_name = jwt_policy_field_name;
	}
	/**
	 * @return the notifications
	 */
	public NotificationsVo getNotifications() {
		return notifications;
	}
	/**
	 * @param notifications the notifications to set
	 */
	public void setNotifications(NotificationsVo notifications) {
		this.notifications = notifications;
	}
	/**
	 * @return the enable_signature_checking
	 */
	public boolean isEnable_signature_checking() {
		return enable_signature_checking;
	}
	/**
	 * @param enable_signature_checking the enable_signature_checking to set
	 */
	public void setEnable_signature_checking(boolean enable_signature_checking) {
		this.enable_signature_checking = enable_signature_checking;
	}
	/**
	 * @return the hmac_allowed_clock_skew
	 */
	public Integer getHmac_allowed_clock_skew() {
		return hmac_allowed_clock_skew;
	}
	/**
	 * @param hmac_allowed_clock_skew the hmac_allowed_clock_skew to set
	 */
	public void setHmac_allowed_clock_skew(Integer hmac_allowed_clock_skew) {
		this.hmac_allowed_clock_skew = hmac_allowed_clock_skew;
	}
	/**
	 * @return the definition
	 */
	public DefinitionVo getDefinition() {
		return definition;
	}
	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(DefinitionVo definition) {
		this.definition = definition;
	}
	/**
	 * @return the version_data
	 */
	public VersionDataVo getVersion_data() {
		return version_data;
	}
	/**
	 * @param version_data the version_data to set
	 */
	public void setVersion_data(VersionDataVo version_data) {
		this.version_data = version_data;
	}
	/**
	 * @return the uptime_tests
	 */
	public UptimeTestsVo getUptime_tests() {
		return uptime_tests;
	}
	/**
	 * @param uptime_tests the uptime_tests to set
	 */
	public void setUptime_tests(UptimeTestsVo uptime_tests) {
		this.uptime_tests = uptime_tests;
	}
	/**
	 * @return the proxy
	 */
	public ProxyVo getProxy() {
		return proxy;
	}
	/**
	 * @param proxy the proxy to set
	 */
	public void setProxy(ProxyVo proxy) {
		this.proxy = proxy;
	}
	/**
	 * @return the custom_middleware
	 */
	public CustomMiddlewareVo getCustom_middleware() {
		return custom_middleware;
	}
	/**
	 * @param custom_middleware the custom_middleware to set
	 */
	public void setCustom_middleware(CustomMiddlewareVo custom_middleware) {
		this.custom_middleware = custom_middleware;
	}
	/**
	 * @return the cache_options
	 */
	public CacheOptionsVo getCache_options() {
		return cache_options;
	}
	/**
	 * @param cache_options the cache_options to set
	 */
	public void setCache_options(CacheOptionsVo cache_options) {
		this.cache_options = cache_options;
	}
	/**
	 * @return the session_lifetime
	 */
	public Integer getSession_lifetime() {
		return session_lifetime;
	}
	/**
	 * @param session_lifetime the session_lifetime to set
	 */
	public void setSession_lifetime(Integer session_lifetime) {
		this.session_lifetime = session_lifetime;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the auth_provider
	 */
	public AuthProviderVo getAuth_provider() {
		return auth_provider;
	}
	/**
	 * @param auth_provider the auth_provider to set
	 */
	public void setAuth_provider(AuthProviderVo auth_provider) {
		this.auth_provider = auth_provider;
	}
	/**
	 * @return the session_provider
	 */
	public SessionProviderVo getSession_provider() {
		return session_provider;
	}
	/**
	 * @param session_provider the session_provider to set
	 */
	public void setSession_provider(SessionProviderVo session_provider) {
		this.session_provider = session_provider;
	}
	/**
	 * @return the event_handlers
	 */
	public EventHandlersVo getEvent_handlers() {
		return event_handlers;
	}
	/**
	 * @param event_handlers the event_handlers to set
	 */
	public void setEvent_handlers(EventHandlersVo event_handlers) {
		this.event_handlers = event_handlers;
	}
	/**
	 * @return the enable_batch_request_support
	 */
	public boolean isEnable_batch_request_support() {
		return enable_batch_request_support;
	}
	/**
	 * @param enable_batch_request_support the enable_batch_request_support to set
	 */
	public void setEnable_batch_request_support(boolean enable_batch_request_support) {
		this.enable_batch_request_support = enable_batch_request_support;
	}
	/**
	 * @return the enable_ip_whitelisting
	 */
	public boolean isEnable_ip_whitelisting() {
		return enable_ip_whitelisting;
	}
	/**
	 * @param enable_ip_whitelisting the enable_ip_whitelisting to set
	 */
	public void setEnable_ip_whitelisting(boolean enable_ip_whitelisting) {
		this.enable_ip_whitelisting = enable_ip_whitelisting;
	}
	/**
	 * @return the allowed_ips
	 */
	public List<String> getAllowed_ips() {
		return allowed_ips;
	}
	/**
	 * @param allowed_ips the allowed_ips to set
	 */
	public void setAllowed_ips(List<String> allowed_ips) {
		this.allowed_ips = allowed_ips;
	}
	/**
	 * @return the dont_set_quota_on_create
	 */
	public boolean isDont_set_quota_on_create() {
		return dont_set_quota_on_create;
	}
	/**
	 * @param dont_set_quota_on_create the dont_set_quota_on_create to set
	 */
	public void setDont_set_quota_on_create(boolean dont_set_quota_on_create) {
		this.dont_set_quota_on_create = dont_set_quota_on_create;
	}
	/**
	 * @return the expire_analytics_after
	 */
	public Integer getExpire_analytics_after() {
		return expire_analytics_after;
	}
	/**
	 * @param expire_analytics_after the expire_analytics_after to set
	 */
	public void setExpire_analytics_after(Integer expire_analytics_after) {
		this.expire_analytics_after = expire_analytics_after;
	}
	/**
	 * @return the response_processors
	 */
	public List<String> getResponse_processors() {
		return response_processors;
	}
	/**
	 * @param response_processors the response_processors to set
	 */
	public void setResponse_processors(List<String> response_processors) {
		this.response_processors = response_processors;
	}
	/**
	 * @return the cORS
	 */
	public CORSVo getCors() {
		return cors;
	}
	/**
	 * @param cORS the cORS to set
	 */
	public void setCors(CORSVo cors) {
		this.cors = cors;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the do_not_track
	 */
	public boolean isDo_not_track() {
		return do_not_track;
	}
	/**
	 * @param do_not_track the do_not_track to set
	 */
	public void setDo_not_track(boolean do_not_track) {
		this.do_not_track = do_not_track;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**
	 * @return the enable_context_vars
	 */
	public boolean isEnable_context_vars() {
		return enable_context_vars;
	}
	/**
	 * @param enable_context_vars the enable_context_vars to set
	 */
	public void setEnable_context_vars(boolean enable_context_vars) {
		this.enable_context_vars = enable_context_vars;
	}
	/**
	 * @return the urlType
	 */
	public String getUrlType() {
		return urlType;
	}
	/**
	 * @param urlType the urlType to set
	 */
	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}
	/**
	 * @return the listenPath
	 */
	public String getListenPath() {
		return listenPath;
	}
	/**
	 * @param listenPath the listenPath to set
	 */
	public void setListenPath(String listenPath) {
		this.listenPath = listenPath;
	}
	/**
	 * @return the svcDscvryYn
	 */
	public String getSvcDscvryYn() {
		return svcDscvryYn;
	}
	/**
	 * @param svcDscvryYn the svcDscvryYn to set
	 */
	public void setSvcDscvryYn(String svcDscvryYn) {
		this.svcDscvryYn = svcDscvryYn;
	}
	/**
	 * @return the svcDscvryQueryEp
	 */
	public String getSvcDscvryQueryEp() {
		return svcDscvryQueryEp;
	}
	/**
	 * @param svcDscvryQueryEp the svcDscvryQueryEp to set
	 */
	public void setSvcDscvryQueryEp(String svcDscvryQueryEp) {
		this.svcDscvryQueryEp = svcDscvryQueryEp;
	}
	/**
	 * @return the userConfirm
	 */
	public String getUserConfirm() {
		return userConfirm;
	}
	/**
	 * @param userConfirm the userConfirm to set
	 */
	public void setUserConfirm(String userConfirm) {
		this.userConfirm = userConfirm;
	}
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}



}
