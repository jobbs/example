/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptFileVo.java
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
package ncis.cpt.sys.errrpt.vo;

import ncis.cmn.vo.CommonFileVo;

/**
 * @author 최진호
 *
 */
public class ErrRptFileVo extends CommonFileVo {

    private Long errRptSeq;

    /**
     * @return the errRptSeq
     */
    public Long getErrRptSeq() {
        return errRptSeq;
    }

    /**
     * @param errRptSeq the errRptSeq to set
     */
    public void setErrRptSeq(Long errRptSeq) {
        this.errRptSeq = errRptSeq;
    }
}
