/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptProcss.java
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
package ncis.cpt.sys.errrpt.vo;

import ncis.cmn.entity.ZErrRptProcss;

/**
 * @author 최진호
 *
 */
public class ErrRptProcssVo extends ZErrRptProcss {

    private String procssStatNm;

    private String regUsrNm;

    /**
     * @return the procssStatNm
     */
    public String getProcssStatNm() {
        return procssStatNm;
    }

    /**
     * @param procssStatNm the procssStatNm to set
     */
    public void setProcssStatNm(String procssStatNm) {
        this.procssStatNm = procssStatNm;
    }

    /**
     * @return the regUsrNm
     */
    public String getRegUsrNm() {
        return regUsrNm;
    }

    /**
     * @param regUsrNm the regUsrNm to set
     */
    public void setRegUsrNm(String regUsrNm) {
        this.regUsrNm = regUsrNm;
    }

}
