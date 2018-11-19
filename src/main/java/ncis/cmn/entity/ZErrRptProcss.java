/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZErrRptProcss.java
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
package ncis.cmn.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 최진호
 *
 */
public class ZErrRptProcss {

    private Long errRptProcssSeq;

    @NotNull(message="올바르지 않은 접근입니다.")
    private Long errRptSeq;

    @NotEmpty(message="처리 내용을 입력하시기 바랍니다.")
    private String procssCont;

    @NotEmpty(message="처리 상태를 선택하여 주시기 바랍니다.")
    private String procssStatCd;

    private String regUsrId;

    private Date regDttm;

    private String updtUsrId;

    private Date updtDttm;

    /**
     * @return the errRptProcssSeq
     */
    public Long getErrRptProcssSeq() {
        return errRptProcssSeq;
    }

    /**
     * @param errRptProcssSeq the errRptProcssSeq to set
     */
    public void setErrRptProcssSeq(Long errRptProcssSeq) {
        this.errRptProcssSeq = errRptProcssSeq;
    }

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

    /**
     * @return the procssCont
     */
    public String getProcssCont() {
        return procssCont;
    }

    /**
     * @param procssCont the procssCont to set
     */
    public void setProcssCont(String procssCont) {
        this.procssCont = procssCont;
    }

    /**
     * @return the procssStatCd
     */
    public String getProcssStatCd() {
        return procssStatCd;
    }

    /**
     * @param procssStatCd the procssStatCd to set
     */
    public void setProcssStatCd(String procssStatCd) {
        this.procssStatCd = procssStatCd;
    }

    /**
     * @return the regUsrId
     */
    public String getRegUsrId() {
        return regUsrId;
    }

    /**
     * @param regUsrId the regUsrId to set
     */
    public void setRegUsrId(String regUsrId) {
        this.regUsrId = regUsrId;
    }

    /**
     * @return the regDttm
     */
    public Date getRegDttm() {
        return regDttm;
    }

    /**
     * @param regDttm the regDttm to set
     */
    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    /**
     * @return the updtUsrId
     */
    public String getUpdtUsrId() {
        return updtUsrId;
    }

    /**
     * @param updtUsrId the updtUsrId to set
     */
    public void setUpdtUsrId(String updtUsrId) {
        this.updtUsrId = updtUsrId;
    }

    /**
     * @return the updtDttm
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }

    /**
     * @param updtDttm the updtDttm to set
     */
    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
    }



}
