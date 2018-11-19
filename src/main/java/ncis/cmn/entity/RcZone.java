/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RcZone.java
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
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.validation.groups.UpdateProc;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */
public class RcZone {

    @NotEmpty(message="존ID는 필수항목입니다.")
    @Size(max=10, groups={InsertProc.class, UpdateProc.class})
    private String zoneId; /* 존ID */

    @NotEmpty(message="존명은 필수항목입니다.")
    @Size(max=30, groups={InsertProc.class, UpdateProc.class})
    private String zoneNm; /* 존명 */

    @NotEmpty(message="센터ID는 필수항목입니다.")
    private String regionId; /* 리전ID */

    private Date regDttm;

    private String regUserId;

    private Date updtDttm;

    private String updtUserId;

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneNm() {
        return zoneNm;
    }

    public void setZoneNm(String zoneNm) {
        this.zoneNm = zoneNm;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
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
