/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmService.java
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

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;

/**
 * @author 심원보
 *
 */
public interface PmService {

    /**
     * 물리서버 목록 조회
     *
     * @param pmSearchVo
     * @return
     */
    List<PmVo> selectPmList(PmSearchVo pmSearchVo, boolean isPagination);

    /**
     * 물리서버 상세 조회
     *
     * @param pmSeq
     * @return
     */
    PmVo selectPm(BigDecimal pmSeq);

    /**
     * 물리서버 정보 수정
     *
     * @param pmVo
     * @return
     */
    void updatePm(PmVo pmVo);

    /**
     * 물리서버 구성ID 존재 여부
     *
     * @param pmCompId
     * @return
     */
    boolean isExistsPmCompId(String pmCompId);

    /**
     * IP주소를 통한 pmSeq 조회
     *
     * @param ipAddr
     * @return
     */
    BigDecimal selectPmSeqByIpAddr(String ipAddr);

    /**
     * 물리서버 상태수정
     * @param pmVo
     */
    void updateRcPmStat(PmVo pmVo);
}