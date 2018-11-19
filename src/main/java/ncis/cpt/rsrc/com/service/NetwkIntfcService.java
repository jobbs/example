/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkIntfcService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service;

import java.util.List;
import ncis.cpt.rsrc.com.vo.NetwkIntfcVo;

/**
 * @author 신재훈, 심원보
 *
 */
public interface NetwkIntfcService {

    /**
     * VM에 할당된 네트워크 인터페이스 조회
     */
    List<NetwkIntfcVo> selectNetwkIntfcList(NetwkIntfcVo vo);
}
