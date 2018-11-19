/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RequestUtils.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.security.vo.UserVo;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUtils {

    private static ShaPasswordEncoder spe = new ShaPasswordEncoder(256);

    /**
     * <pre>
     * Query String 에서 특정 parameter를 삭제
     * </pre>
     *
     * @param queryString
     * @param removeParamName
     * @return
     */
    public static String getQueryString(String queryString, String... removeParamName) {
        queryString = queryString == null ? "" : queryString;
        if (removeParamName != null) {
            for (String name : removeParamName) {
                queryString = queryString.replaceAll(name + "=[^&]*&*", "")
                        .replaceAll("&+$", "");
            }
        }
        if (queryString.length() > 0)
            queryString = "?" + queryString;
        return queryString;
    }

    /**
     * <pre>
     * 요청에 대한 Query String 을 리턴
     * </pre>
     *
     * @param request
     * @param removeParamName Query String 중 제거할 파라미터 이름목록
     * @return
     */
    public static String getQueryString(HttpServletRequest request, String... removeParamName) {
        return getQueryString(request.getQueryString(), removeParamName);
    }

    /**
     * <pre>
     * Object 를 json 형태로 출력한다.
     * </pre>
     *
     * @param response
     * @param object
     * @throws IOException
     */
    public static void printJsonObject(HttpServletResponse response, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(object));
        out.flush();
        out.close();
    }

    /**
     * XSS 처리
     * @param value
     * @return
     */
    public static String cleanXSS(String value) {
        return value.replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("'", "&#39")
                .replaceAll("\"", "&quot;");
    }

    /**
     * <pre>
     * 말줄임
     * </pre>
     *
     * @param str
     * @param len
     * @return
     */
    public static String ellipsis(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return "";
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len).concat("...");
    }

    public static String getEncodePassword(String password) {
        return spe.encodePassword(password, null);
    }

    public static String getTempPass() {
        String tmpPass = getEncodePassword(DateUtil.getTimeStamp()).substring(0, 6);
        return tmpPass;
    }

    public static String getExcelFileName(String fileName) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(fileName)) {
            return "excelConvert.xml";
        }
        return URLEncoder.encode(fileName, "utf-8") + "_" + DateUtil.getCurrentDate("yyyyMMdd") + ".xml";
    }

    public static String replaceBr(String msg) {
        StringBuffer str = new StringBuffer();
        int i;

        if (msg == null)
            return "";

        System.out.println( msg.replaceAll("\n", "<br /><br />"));

        for (i = 0; i < msg.length(); i++) {

            if (msg.charAt(i) == '.') {
                str.append("<br><br>");
            }
            else
            {
                str.append(msg.charAt(i));
            }
        }
        return str.toString();
    }

    public static String nl2br(String msg) {
        if (msg == null)
            return "";

        return cleanXSS(msg).replaceAll("\n", "<br />");
    }

    public static String getQueryString(Map<String, String> param, String removeParamName) throws UnsupportedEncodingException {
        if (param == null || param.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (Entry<String, String> entry : param.entrySet()) {
            String key = (String) entry.getKey();
            String value = entry.getValue() == null ? "" : (String) entry.getValue();
            if (removeParamName == null || removeParamName.isEmpty() || !key.matches(removeParamName)) {
                sb.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(value, "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static String getQueryString(Map<String, String> param, String removeParamName, String seperator) throws UnsupportedEncodingException {
        if (param == null || param.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        String[] params = removeParamName.split(seperator);
        List<String> listParam = new ArrayList<String>(Arrays.asList(params));

        for (Entry<String, String> entry : param.entrySet()) {
            String key = (String) entry.getKey();
            String value = entry.getValue() == null ? "" : (String) entry.getValue();

            if (removeParamName == null || removeParamName.isEmpty() || listParam.indexOf(key) < 0) {
                sb.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(value, "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static String minFromCompareString(String source, String target) {
        int compare = source.compareTo(target);
        return compare > 0 ? target : source;
    }

    public static UserVo getUser() {
        Object principal = (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof UserDetails)) {
            return null;
        }
        return (UserVo) principal;
    }

    public static String getUserName() {
        UserVo user = getUser();
        if (user == null) {
            return null;
        }
        return user.getUserNm();
    }

    public static String getUserId() {

        UserVo user = getUser();
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }

    public static List<String> selectUserRoleList() {
    	UserVo user = getUser();
        if (user == null) {
            return null;
        }
        return user.selectUserRoleList();
    }

    public static String getSuperposedUserRole() {

        UserVo user = getUser();
        if (user == null) {
            return null;
        }
        return user.getSuperposedUserRole();
    }


    /**
     * 접근 아이피 조회
     *
     * @param request
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request) {

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (null == ipAddress || "".equals(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
    /**
     * 모든 자원풀에 대한 권한이 있는지 여부
     * */
    public static boolean isAllRsrcPoolAuth(){
    	return getUser().isSysAdm();
    }
    /**
     * 모든 업무에 대한 권한이 있는지 여부
     * */
    public static boolean isAllJobAuth(){
        return getUser().isSysAdm() ||  getUser().isOprAdm();
    }
}
