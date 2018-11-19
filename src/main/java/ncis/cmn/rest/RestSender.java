/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestSender.java
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

import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.util.PropertiesUtil;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="prototype")
public class RestSender extends AbstractRestSender {

	@Override
	public <V, T> ResponseEntity<T> send(String url, V sendObj, RestHeaders headers, Class<T> responseType, HttpMethod method) {

	    initializeRest(headers);
	    String strUrl = new StringBuffer()
                            .append(restInfo.getHost())
                            .append(url)
                            .toString();
		return restUtil.send(strUrl, sendObj, responseType, method);
	}


	@Override
	public <V, T> ResponseEntity<T> send(String url, V sendObj, RestHeaders headers, Class<T> responseType, HttpMethod method, int readTimeout, int connectTimeout) {


	    initializeRest(headers);
	    String strUrl = new StringBuffer()
                            .append(restInfo.getHost())
                            .append(url)
                            .toString();

	    restUtil.setConnectTimeout(connectTimeout);
	    restUtil.setReadTimeout(readTimeout);

		return restUtil.send(strUrl, sendObj, responseType, method);
	}


	@Override
	public <V, T> ResponseEntity<T> send(String url, RestHeaders headers, Class<T> responseType, HttpMethod method) {

	    initializeRest(headers);
	    String strUrl = new StringBuffer()
	                        .append(restInfo.getHost())
	                        .append(url)
	                        .toString();

		return restUtil.send(strUrl, responseType, method);
	}

	public <V, T> ResponseEntity<T> sendNtops(String url, RestHeaders headers, Class<T> responseType, HttpMethod method) {

        initializeRest(headers);
        String strUrl = new StringBuffer()
                            .append(restInfo.getHost())
                            .append(url)
                            .append("&key=").append(PropertiesUtil.getProperty("gateway.key"))
                            .toString();

        return restUtil.send(strUrl, responseType, method);
    }
}
