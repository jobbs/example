/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CouchDBRestTemplate.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.couch;

import java.io.IOException;
import java.net.URI;

import lombok.extern.slf4j.Slf4j;
import ncis.cmn.entity.couch.QueryParamVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

@SuppressWarnings("unused")
@Slf4j
@Component
public class CouchDBRestTemplate implements RequestCallback {

	private static final Logger LOGGER = LoggerFactory.getLogger(CouchDBRestTemplate.class);

	private static final Gson gson = new Gson();

	@Override
	public void doWithRequest(ClientHttpRequest request) throws IOException {
		decorateHttpHeaders(request.getHeaders());
	}

	private HttpHeaders createHeaders() {
		return decorateHttpHeaders(new HttpHeaders());
	}

	private HttpHeaders decorateHttpHeaders(HttpHeaders headers) {
		headers.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return headers;
	}

	/**
	 * GET
	 *
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param responseType
	 *            response type
	 * @return {@code T} response body
	 */
	public <T> T get(String url, QueryParamVo params, ParameterizedTypeReference<T> responseType) throws IOException {
		return exchange(HttpMethod.GET, url, params, null, responseType);
	}

	/**
	 * POST
	 *
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param responseType
	 *            response type
	 * @return {@code T} response body
	 */
	public <T> T post(String url, QueryParamVo params, Object requestBody, ParameterizedTypeReference<T> responseType)
			throws IOException {
		return exchange(HttpMethod.POST, url, params, requestBody, responseType);
	}

	/**
	 * POST
	 *
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param responseType
	 *            response type
	 * @return {@code T} response body
	 */
	public <T> T post(String url, QueryParamVo params, Object requestBody, ParameterizedTypeReference<T> responseType, HttpHeaders headers)
			throws IOException {
		return exchange(HttpMethod.POST, url, params, requestBody, responseType, headers);
	}

	/**
	 * PUT
	 *
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param responseType
	 *            response type
	 * @return {@code T} response body
	 */
	public <T> T put(String url, QueryParamVo params, Object requestBody, ParameterizedTypeReference<T> responseType)
			throws IOException {
		return exchange(HttpMethod.PUT, url, params, requestBody, responseType);
	}

	/**
	 * DELETE
	 *
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param responseType
	 *            response type
	 * @return {@code String} response body
	 */
	public <T> T delete(String url, QueryParamVo params, ParameterizedTypeReference<T> responseType)
			throws IOException {
		return exchange(HttpMethod.DELETE, url, params, null, responseType);
	}

	/**
	 * GET STREAM
	 *
	 * @param url
	 * @param params
	 * @param extractor
	 */
	public void readLine(String url, QueryParamVo params, ResponseLineExtractor<String> extractor) {
		execute(HttpMethod.GET, url, params, extractor);
	}

	/**
	 * HTTP 요청
	 *
	 * @param method
	 *            request HTTP Method
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param type
	 *            response type
	 * @return {@code String} response body
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private <T> T exchange(HttpMethod method, String url, QueryParamVo params, Object requestBody,
			ParameterizedTypeReference<T> responseType)
			throws RestClientException, JsonParseException, JsonMappingException, IOException {

		if (params == null) {
			params = new QueryParamVo();
		}

		HttpEntity<Object> requestEntity = null;
		if (requestBody == null) {
			requestEntity = new HttpEntity<Object>(createHeaders());
		}
		else {
			requestEntity = new HttpEntity<Object>(gson.toJson(requestBody), createHeaders());
		}

		URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(params.toEncodedParamMap()).build().toUri();

		LOGGER.info("##############################");
		LOGGER.info("exchange - method : " + method + ", url : " + uri + ", requestEntity :" + requestEntity);
		LOGGER.info("##############################");

		ResponseEntity<T> responseEntity = new RestTemplate().exchange(uri, method, requestEntity, responseType);

		return responseEntity.getBody();
	}

	/**
	 * HTTP 요청
	 *
	 * @param method
	 *            request HTTP Method
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param requestBody
	 *            request body
	 * @param type
	 *            response type
	 * @return {@code String} response body
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private <T> T exchange(HttpMethod method, String url, QueryParamVo params, Object requestBody,
			ParameterizedTypeReference<T> responseType, HttpHeaders headers)
			throws RestClientException, JsonParseException, JsonMappingException, IOException {

		if (params == null) {
			params = new QueryParamVo();
		}

		HttpEntity<Object> requestEntity = null;
		if (requestBody == null) {
			requestEntity = new HttpEntity<Object>(createHeaders());
		}
		else {
			requestEntity = new HttpEntity<Object>(gson.toJson(requestBody), headers);
		}

		URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(params.toEncodedParamMap()).build().toUri();

		LOGGER.debug("##############################");
		LOGGER.debug("exchange - method : " + method + ", url : " + uri + ", requestEntity :" + requestEntity);
		LOGGER.debug("##############################");

		ResponseEntity<T> responseEntity = new RestTemplate().exchange(uri, method, requestEntity, responseType);

		return responseEntity.getBody();
	}

	/**
	 * HTTP 요청 - Stream read line
	 *
	 * @param method
	 *            request HTTP Method
	 * @param url
	 *            request URL
	 * @param params
	 *            request parameters
	 * @param extractor
	 *            response extractor
	 * @throws RestClientException
	 */
	private void execute(HttpMethod method, String url, QueryParamVo params, ResponseLineExtractor<String> extractor)
			throws RestClientException {

		if (params == null) {
			params = new QueryParamVo();
		}

		URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(params.toEncodedParamMap()).build().toUri();

		//log.info("exchange - method : " + method + ", url : " + uri);

		new RestTemplate().execute(uri, HttpMethod.GET, this, extractor);
	}

}
