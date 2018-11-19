/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrService.java
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
import ncis.cpt.rsrc.com.vo.ClstrPrposVo;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;

/**
 * @author 심원보
 *
 */
public interface ClstrService {

    /**
     * 클러스터 목록 조회 페이징
     *
     * @param clstrSearchVo
     * @return
     */
    List<ClstrVo> selectClstrListPaging(ClstrSearchVo clstrSearchVo);

    /**
     * 클러스터 목록 조회
     *
     * @param clstrSearchVo
     * @return
     */
    List<ClstrVo> selectClstrList(ClstrSearchVo clstrSearchVo);

    /**
     * 클러스터 상세 조회
     *
     * @param clstrSeq
     * @return
     */
    ClstrVo selectClstr(BigDecimal clstrSeq);

    /**
     * 클러스터 정보 수정
     *
     * @param clstrVo
     * @return
     */
    void updateClstr(ClstrVo clstrVo);

    /**
     * 클러스터 정보 수정(용도 포함)
     *
     * @param clstrVo
     * @param clstrPrposVoList
     */
    void updateClstrAndClstrPrposList(ClstrVo clstrVo, List<ClstrPrposVo> clstrPrposVoList);

    /**
     * 클러스터 존재 여부
     *
     * @param clstrSeq
     * @return
     */
    boolean isExistsClstr(BigDecimal clstrSeq);

    /**
     * 클러스터 구성ID 존재 여부
     *
     * @param clstrCompId
     * @return
     */
    boolean isExistsClstrCompId(String clstrCompId);

}