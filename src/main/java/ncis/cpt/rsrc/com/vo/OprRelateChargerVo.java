/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OprRelateChargerVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import ncis.cmn.entity.SiOprRelateCharger;

/**
 * @author 심원보
 *
 */
public class OprRelateChargerVo extends SiOprRelateCharger {

    private String userNm;

    private String telno;

    private String email;

    private String relaterClCdNm;

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelaterClCdNm() {
        return relaterClCdNm;
    }

    public void setRelaterClCdNm(String relaterClCdNm) {
        this.relaterClCdNm = relaterClCdNm;
    }

}
