/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ComService.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service;

import java.util.Map;

/**
 * @author 심원보
 *
 */
public interface ComService {

    /**
     * 사용자별 컴퓨팅 자원통계
     *
     * @return
     */
    Map<String, Object> selectComSttsByUser();

}