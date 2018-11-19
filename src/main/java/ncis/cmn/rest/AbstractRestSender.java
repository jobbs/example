/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AbstractRestSender.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 19.
 * @lastmodified 2016. 9. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.rest;

import javax.annotation.Resource;

import ncis.cmn.rest.service.RestService;
import ncis.cmn.rest.util.RestUtil;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.rest.vo.RestInfo;
import ncis.cmn.util.MessageUtil;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Component
public abstract class AbstractRestSender {

    @Resource
    protected MessageUtil messageUtil;

	@Resource(name="restService")
	protected RestService restService;

	protected RestInfo restInfo;

	protected RestUtil restUtil;

	public AbstractRestSender() {
		restUtil = new RestUtil();
	}

	/**
	 * Database에서 GW 접속정보를 확인한다.
	 * @param code
	 */
	protected void initializeRest(RestHeaders headers) throws RuntimeException {

	    if(  ObjectUtils.isEmpty(headers) )
	        throw new RuntimeException("API-Gateway Header 정보가 존재하지 않습니다.");

	    if( StringUtils.isEmpty( headers.getAreaId() ) )
	        throw new RuntimeException("API-Gateway AreaId 정보가 존재하지 않습니다.");

	    String regionId = headers.getAreaId();
		restInfo = restService.selectConnectInfo(regionId);

		if( null == restInfo )
			throw new RuntimeException("API-Gateway 접속정보가 존재하지 않습니다.");

		headers.setAuthorization(restInfo.getToken());
		restUtil.setHeader(headers);
	}

	/**
	 * API-Gateway 접속정보 에서 정보를 호출 한 후 webservice 호출한다.(POST, PUT)
	 * @param code			API-Gateway 접속 정보 코드
	 * @param url			API-Gateway 접속정보 이후의 URL
	 * @param sendObj		POST. PUT 시 전송하고자 하는 Object
	 * @param responseType	Return Type
	 * @param method		HttpMethod의 POST, PUT 형태, 또는 Delete시 Object 형태일때도 사용
	 * @return
	 */
	public abstract <V, T> ResponseEntity<T> send(String url, V sendObj, RestHeaders headers, Class<T> responseType, HttpMethod method);


	/**
	 * API-Gateway 접속정보 에서 정보를 호출 한 후 webservice 호출한다.(POST, PUT)
	 * @param code			API-Gateway 접속 정보 코드
	 * @param url			API-Gateway 접속정보 이후의 URL
	 * @param sendObj		POST. PUT 시 전송하고자 하는 Object
	 * @param responseType	Return Type
	 * @param method		HttpMethod의 POST, PUT 형태, 또는 Delete시 Object 형태일때도 사용
	 * @param readTimeout	readTimeout
	 * @param connectTimeout connectTimeout
	 * @return
	 */
	public abstract <V, T> ResponseEntity<T> send(String url, V sendObj, RestHeaders headers, Class<T> responseType, HttpMethod method, int readTimeout, int connectTimeout);


	/**
	 * API-Gateway 접속정보 에서 정보를 호출 한 후 webservice 호출한다.(GET, DELETE)
	 * @param code			API-Gateway 접속 정보 코드
	 * @param url			API-Gateway 접속정보 이후의 URL
	 * @param responseType	Return Type
	 * @param method		HttpMethod의 GET, DELETE 형태
	 * @return
	 */
	public abstract <V, T> ResponseEntity<T> send(String url, RestHeaders headers, Class<T> responseType, HttpMethod method);

}
