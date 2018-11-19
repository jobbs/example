/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetPmService.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.rsrc.net.vo.NetPmSearchVo;
import ncis.cpt.rsrc.net.vo.NetPmVo;

/**
 * @author 최경철
 *
 */
public interface NetPmService {

    /**
     * 네트워크 물리서버 목록 조회
     *
     * @param netPmSearchVo
     * @return
     */
    List<NetPmVo> selectNetPmList(NetPmSearchVo netPmSearchVo, boolean isPagination);

    /**
     * 네트워크 물리서버 상세 조회
     *
     * @param pmSeq
     * @return
     */
    NetPmVo selectNetPm(BigDecimal pmSeq);

    /**
     * 물리서버 정보 수정
     *
     * @param netPmVo
     * @return
     */
    void updateNetPm(NetPmVo netPmVo);

    /**
     * 물리서버 구성ID 존재 여부
     *
     * @param pmCompId
     * @return
     */
    boolean isExistsPmCompId(String pmCompId);


}
