/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmProcssMsgVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 11. 18.
 * @lastmodified 2016. 11. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 18.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;

/**
 * @author 심원보
 *
 */
public class VmProcssMsgVo {

    private BigDecimal procssInstSeq;

    private String rsrcReqNo;

    private BigDecimal rsrcReqSeq;

    private String procssClCd;

    private String procssClCdNm;

    public BigDecimal getProcssInstSeq() {
        return procssInstSeq;
    }

    public void setProcssInstSeq(BigDecimal procssInstSeq) {
        this.procssInstSeq = procssInstSeq;
    }

    public String getRsrcReqNo() {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo) {
        this.rsrcReqNo = rsrcReqNo;
    }

    public BigDecimal getRsrcReqSeq() {
        return rsrcReqSeq;
    }

    public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
        this.rsrcReqSeq = rsrcReqSeq;
    }

    public String getProcssClCd() {
        return procssClCd;
    }

    public void setProcssClCd(String procssClCd) {
        this.procssClCd = procssClCd;
    }

    public String getProcssClCdNm() {
        return procssClCdNm;
    }

    public void setProcssClCdNm(String procssClCdNm) {
        this.procssClCdNm = procssClCdNm;
    }

}
