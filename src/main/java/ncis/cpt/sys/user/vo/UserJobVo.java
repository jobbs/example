/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserRoleVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.user.vo;

import ncis.cmn.entity.CmJob;

public class UserJobVo extends CmJob {

    private String institutionNm;

    private String regionNm;

    private String userId;

    /**
     * @return the institutionNm
     */
    public String getInstitutionNm() {
        return institutionNm;
    }

    /**
     * @param institutionNm the institutionNm to set
     */
    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    /**
     * @return the regionNm
     */
    public String getRegionNm() {
        return regionNm;
    }

    /**
     * @param regionNm the regionNm to set
     */
    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
