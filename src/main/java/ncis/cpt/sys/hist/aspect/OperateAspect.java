/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OperateAspect.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.aspect;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.security.vo.UserVo;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.sys.hist.annotation.OperateLog;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class OperateAspect {

    @Resource(name = "commonService")
    private CommonService commonService;

    @Before("execution(* ncis..*.*Controller.*(..)) && @annotation(accessLog)")
    public void insertAccessLog(OperateLog accessLog)
    {

        Object principal = (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ((principal instanceof UserDetails)) {

            // 사용자 정보
            UserVo user = (UserVo) principal;

            // 작업자 아이피
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String ipAddress = RequestUtils.getRemoteIP(request);

            // 접근 경로(메뉴 패턴)
            String path = request.getRequestURI()
                    .substring(
                            request.getContextPath().length(),
                            request.getRequestURI().lastIndexOf("/") + 1
                    );

            String[] params = accessLog.params();
            String oprateParams = getValue(request, params);

            // VO 생성
            UserWrkHistVo log = new UserWrkHistVo();
            log.setUserId(user.getUserId());
            log.setUserNm(user.getUserNm());
            log.setWrkInfo(accessLog.action());
            log.setWrkDc(accessLog.desc());
            log.setWrkIP(ipAddress);
            log.setWrkParam(oprateParams);
            log.setWrkTy(accessLog.actionType().name());
            log.setMenuPattern(path);

            commonService.insertUserWrkHist(log);

        }

    }

    private String getValue(HttpServletRequest request, String[] checkParams) {

        List<String> result = new ArrayList<String>();

        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {

            String paramName = (String) params.nextElement();

            for (String checkParam : checkParams) {
                if (paramName.equals(checkParam)) {
                    result.add(new StringBuffer().append(paramName).append(":").append(request.getParameter(paramName)).toString());
                }
            }
        }

        return StringUtils.join(result, ", ");
    }

}
