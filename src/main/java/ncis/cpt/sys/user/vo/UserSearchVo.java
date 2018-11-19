/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserSearchVo.java
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

import ncis.cmn.vo.CommonSearchVo;

public class UserSearchVo extends CommonSearchVo {

    private String searchUserId;

    private String searchUserNm;

    private String startRnctDt;

    private String endRnctDt;

    private String lngTrmNotAccs;

    private String searchRoleCd;
    
    private String searchInstitutionNm;

    /**
     * @return the searchUserId
     */
    public String getSearchUserId() {
        return searchUserId;
    }

    /**
     * @param searchUserId the searchUserId to set
     */
    public void setSearchUserId(String searchUserId) {
        this.searchUserId = searchUserId;
    }

    /**
     * @return the searchUserNm
     */
    public String getSearchUserNm() {
        return searchUserNm;
    }

    /**
     * @param searchUserNm the searchUserNm to set
     */
    public void setSearchUserNm(String searchUserNm) {
        this.searchUserNm = searchUserNm;
    }

    /**
     * @return the startRnctDt
     */
    public String getStartRnctDt() {
        return startRnctDt;
    }

    /**
     * @param startRnctDt the startRnctDt to set
     */
    public void setStartRnctDt(String startRnctDt) {
        this.startRnctDt = startRnctDt;
    }

    /**
     * @return the endRnctDt
     */
    public String getEndRnctDt() {
        return endRnctDt;
    }

    /**
     * @param endRnctDt the endRnctDt to set
     */
    public void setEndRnctDt(String endRnctDt) {
        this.endRnctDt = endRnctDt;
    }

    /**
     * @return the lngTrmNotAccs
     */
    public String getLngTrmNotAccs() {
        return lngTrmNotAccs;
    }

    /**
     * @param lngTrmNotAccs the lngTrmNotAccs to set
     */
    public void setLngTrmNotAccs(String lngTrmNotAccs) {
        this.lngTrmNotAccs = lngTrmNotAccs;
    }

    /**
     * @return the searchRoleNm
     */
    public String getSearchRoleCd() {
        return searchRoleCd;
    }

    /**
     * @param searchRoleNm the searchRoleNm to set
     */
    public void setSearchRoleCd(String searchRoleCd) {
        this.searchRoleCd = searchRoleCd;
    }

	public String getSearchInstitutionNm() {
		return searchInstitutionNm;
	}

	public void setSearchInstitutionNm(String searchInstitutionNm) {
		this.searchInstitutionNm = searchInstitutionNm;
	}
    
}
