/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZErrRpt.java
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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 최진호
 *
 */
public class ZErrRpt {

    private Long errRptSeq;

    @NotEmpty(message="에러 제목을 입력하세요.")
    @Size(max=200, message="에러 제목은 최대 200자 까지 가능합니다.")
    private String errTitle;

    @NotEmpty(message="에러 내용을 입력하세요")
    private String errCont;

    @NotEmpty(message="에러 카테고리를 선택하세요")
    private String errCateCd;

    private String procssStatCd;

    @NotEmpty(message="에러 타입을 선택하세요")
    private String errTyCd;

    private String chargeId;

    private String regUsrId;

    private Date regDttm;

    private String updtUsrId;

    private Date updtDttm;

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
     * @return the errTitle
     */
    public String getErrTitle() {
        return errTitle;
    }

    /**
     * @param errTitle the errTitle to set
     */
    public void setErrTitle(String errTitle) {
        this.errTitle = errTitle;
    }

    /**
     * @return the errCont
     */
    public String getErrCont() {
        return errCont;
    }

    /**
     * @param errCont the errCont to set
     */
    public void setErrCont(String errCont) {
        this.errCont = errCont;
    }

    /**
     * @return the errCateCd
     */
    public String getErrCateCd() {
        return errCateCd;
    }

    /**
     * @param errCateCd the errCateCd to set
     */
    public void setErrCateCd(String errCateCd) {
        this.errCateCd = errCateCd;
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
     * @return the errTyCd
     */
    public String getErrTyCd() {
        return errTyCd;
    }

    /**
     * @param errTyCd the errTyCd to set
     */
    public void setErrTyCd(String errTyCd) {
        this.errTyCd = errTyCd;
    }

    /**
     * @return the chargeId
     */
    public String getChargeId() {
        return chargeId;
    }

    /**
     * @param chargeId the chargeId to set
     */
    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
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
