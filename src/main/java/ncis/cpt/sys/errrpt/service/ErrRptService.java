/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.service;

import java.util.List;
import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.sys.errrpt.vo.ErrRptProcssVo;
import ncis.cpt.sys.errrpt.vo.ErrRptSearchVo;
import ncis.cpt.sys.errrpt.vo.ErrRptVo;

/**
 * @author 최진호
 *
 */
public interface ErrRptService {

    /**
     * @param searchVo
     * @return
     */
    List<ErrRptVo> selectErrRptList(ErrRptSearchVo searchVo);

    /**
     * @param errRptVo
     */
    void insertErrRpt(ErrRptVo errRptVo);

    /**
     * @param errRptSeq
     * @return
     */
    ErrRptVo selectErrRpt(Long errRptSeq);

    /**
     * @param errRptVo
     */
    void updateErrRpt(ErrRptVo errRptVo);

    /**
     * @param seq
     * @return
     */
    CommonFileVo selectErrRptFile(Long seq);

    /**
     * @param errRptSeq
     */
    void deleteErrRpt(Long errRptSeq);

    /**
     * @param errRptProcss
     */
    void insertErrRptProcss(ErrRptProcssVo errRptProcss);

    /**
     * @param errRptProcss
     */
    void updateErrRptProcss(ErrRptProcssVo errRptProcss);

    /**
     * @param errRptProcssSeq
     * @return
     */
    ErrRptProcssVo selectErrRptProcss(Long errRptProcssSeq);

    /**
     * @param errRptProcssSeq
     */
    void deleteErrRptProcss(Long errRptProcssSeq);

}
