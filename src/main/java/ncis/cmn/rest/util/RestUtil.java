/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestUtil.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.rest.util;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.util.PropertiesUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;


public class RestUtil {


	private int readTimeout;

	private int connectTimeout;

	private RestHeaders header;

	public RestUtil() {
		readTimeout = Integer.valueOf(PropertiesUtil.getProperty("rest.readTimeout"));
		connectTimeout = Integer.valueOf(PropertiesUtil.getProperty("rest.connectTimeout"));
	}

	/**
	 * POST, PUT 처리
	 * @param url                       접속경로
	 * @param sendObj                전송 Object
	 * @param responseType         결과 Type Object
	 * @param method                 HttpMethod.POST, HttpMethod.PUT
	 * @return
	 */
	public <V, T> ResponseEntity<T> send(String url, V sendObj, Class<T> responseType, HttpMethod method) {
		RestTemplate restTemplate = getRestTemplate();
		return restTemplate.exchange(url, method, getEntity(sendObj), responseType);
	}

	/**
	 * GET, DELETE 처리
	 * @param url                    접속경로
	 * @param responseType      결과 Type Object
	 * @param method              HttpMethod.GET, HttpMethod.DELETE
	 * @return
	 */
	public <V, T> ResponseEntity<T> send(String url, Class<T> responseType, HttpMethod method) {
		RestTemplate restTemplate = getRestTemplate();
		return restTemplate.exchange(url, method, getEntity(), responseType);
	}

	/**
	 * Header 정보 설정
	 * @param obj
	 * @return
	 */
	private <T> HttpEntity<T> getEntity(T obj) {
		HttpEntity<T> entity = new HttpEntity<T>(obj, getHttpHeaders());
		return entity;
	}

	/**
	 * Header 정보 설정
	 * @return
	 */
	private HttpEntity<String> getEntity() {
		return getEntity("");
	}

	/**
	 * 접속 관련 기본정보 설정
	 * @return
	 */
	private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(readTimeout);
        factory.setConnectTimeout(connectTimeout);
        return factory;
    }

	/**
	 * RestTemplate 초기화
	 * @return
	 */
	private RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		return restTemplate;
	}


	/**
	 * @return the readTimeout
	 */
	public int getReadTimeout() {
		return readTimeout;
	}


	/**
	 * @param readTimeout the readTimeout to set
	 */
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}


	/**
	 * @return the connectTimeout
	 */
	public int getConnectTimeout() {
		return connectTimeout;
	}


	/**
	 * @param connectTimeout the connectTimeout to set
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

    /**
     * @return the header
     */
    public RestHeaders getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(RestHeaders header) {
        this.header = header;
    }

    /**
     * 사용자가 전송한 Header 정보 Mapping
     * @return
     */
    private HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();

        if( null == this.header )
            this.header = new RestHeaders();

        httpHeaders.add("AreaId", this.header.getAreaId());
        httpHeaders.add("Authorization", this.header.getAuthorization());

        if( !StringUtils.isEmpty(this.header.getZoneId()) )
            httpHeaders.add("ZoneId", this.header.getZoneId());

        if( !StringUtils.isEmpty(this.header.getNetworkId()) )
            httpHeaders.add("NetworkId", this.header.getNetworkId());

//        if( !StringUtils.isEmpty(this.header.getSeq()) )
            httpHeaders.add("Seq", this.header.getSeq());

        if( !StringUtils.isEmpty(this.header.getAction()) )
            httpHeaders.add("Action", this.header.getAction());

        if( !StringUtils.isEmpty(this.header.getManagerId()) )
            httpHeaders.add("ManagerId", this.header.getManagerId());

        if( !StringUtils.isEmpty(this.header.getMachineIp()) )
            httpHeaders.add("MachineIp", this.header.getMachineIp());

        if( !StringUtils.isEmpty(this.header.getxTykAuthorization()) )
            httpHeaders.add("x-tyk-authorization", this.header.getxTykAuthorization());

        return httpHeaders;
    }

}
