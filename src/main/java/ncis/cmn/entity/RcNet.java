/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcNet.java
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
package ncis.cmn.entity;

import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */
public class RcNet {

    private String netId; /* 망ID */

    @NotEmpty(message="망명을 입력하세요.")
    @Size(max=30, message="망명은 30를 초과할 수 없습니다.")
    private String netNm; /* 망명 */

    @NotEmpty(message="망구분코드를 입력하세요.")
    private String netClCd; /* 망구분코드 */

    private Date regDttm;

    private String regUserId;

    private Date updtDttm;

    private String updtUserId;

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
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
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * @param regUserId the regUserId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
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

    /**
     * @return the updtUserId
     */
    public String getUpdtUserId() {
        return updtUserId;
    }

    /**
     * @param updtUserId the updtUserId to set
     */
    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

}
