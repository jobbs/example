/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResponseLineExtractor.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

public abstract class ResponseLineExtractor<T> implements ResponseExtractor<T> {

	@Override
	public T extractData(ClientHttpResponse response) throws IOException {

		String line;
		BufferedReader is = new BufferedReader(new InputStreamReader(response.getBody()));
		while ((line = is.readLine()) != null) {
			readLine(line);
		}

		return null;
	}

	public abstract void readLine(String line);
}
