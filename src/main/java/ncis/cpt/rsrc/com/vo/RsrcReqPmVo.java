/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqPmVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;

/**
 * @author 최경철
 *
 */
public class RsrcReqPmVo extends RrRsrcReqDtlPRsrc {

    /**
     * 클러스터SEQ
     */
    private BigDecimal clstrSeq;

    /**
     * @return the clstrSeq
     */
    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    /**
     * @param clstrSeq the clstrSeq to set
     */
    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

}
