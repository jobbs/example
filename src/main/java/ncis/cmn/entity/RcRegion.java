/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcRegion.java
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
public class RcRegion {

    @NotEmpty(message="센터ID는 필수항목입니다.")
    @Size(max=10)
    private String regionId; /* 리전ID */

    @NotEmpty(message="센터명은 필수항목입니다.")
    @Size(max=30)
    private String regionNm; /* 리전명 */

    @Size(max=100)
    private String regionLocaNm; /* 리전위치명 */

    private Date regDttm;

    private String regUserId;

    private Date updtDttm;

    private String updtUserId;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getRegionLocaNm() {
        return regionLocaNm;
    }

    public void setRegionLocaNm(String regionLocaNm) {
        this.regionLocaNm = regionLocaNm;
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
