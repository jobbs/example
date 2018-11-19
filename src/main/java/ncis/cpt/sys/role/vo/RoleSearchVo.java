/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleSearchVo.java
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
package ncis.cpt.sys.role.vo;

import ncis.cmn.vo.CommonSearchVo;

public class RoleSearchVo extends CommonSearchVo {

    private String searchRoleCd;

    private String searchRoleNm;

    /**
     * @return the searchRoleCd
     */
    public String getSearchRoleCd() {
        return searchRoleCd;
    }

    /**
     * @param searchRoleCd the searchRoleCd to set
     */
    public void setSearchRoleCd(String searchRoleCd) {
        this.searchRoleCd = searchRoleCd;
    }

    /**
     * @return the searchRoleNm
     */
    public String getSearchRoleNm() {
        return searchRoleNm;
    }

    /**
     * @param searchRoleNm the searchRoleNm to set
     */
    public void setSearchRoleNm(String searchRoleNm) {
        this.searchRoleNm = searchRoleNm;
    }

}
