/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestInterceptor.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.rest.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ncis.cmn.rest.service.RestService;
import ncis.cmn.rest.vo.RestInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author 최진호
 *
 */
public class RestInterceptor extends HandlerInterceptorAdapter {

    @Resource(name="restService") RestService restService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String regionId = request.getHeader("regionId");
        String authorization = request.getHeader("authorization");

        if( StringUtils.isEmpty(regionId) || StringUtils.isEmpty(authorization) ) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }

        RestInfo info = restService.selectConnectInfo(regionId);

        if( !authorization.equals(info.getToken() ) ) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }
}
