/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SRoutService.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service;

import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.opr.ip.vo.SRoutVo;

/**
 * @author 신재훈
 *
 */
public interface SRoutService {
    /**
     * 스태틱라우터 목록조회
     *
     * @param bndSeq
     * @return
     */
    List<SRoutVo> selectSRoutList(BigDecimal bndSeq);

    /**
     * 스태틱라우터 추가
     *
     * @param sRoutVoList
     */
    void insertSRout(List<SRoutVo> sRoutVoList);

    /**
     * 스태틱라우터 삭제
     *
     * @param sRoutVo
     */
    void deleteSRout(SRoutVo sRoutVo);

    /**
     * 스태틱라우터 수정 (추가/삭제 동시수행)
     *
     * @param sRoutVoList
     * @param sRoutVo
     */
    void updateSRout(List<SRoutVo> sRoutVoList, SRoutVo sRoutVo);
}
