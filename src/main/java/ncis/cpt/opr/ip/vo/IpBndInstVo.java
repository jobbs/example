/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndInstVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 12. 14.
 * @lastmodified 2016. 12. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 14.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import ncis.cmn.entity.RnIpBndInst;

/**
 * @author 신재훈
 *
 */
public class IpBndInstVo extends RnIpBndInst {
    private String institutionNm; // 부처명

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

}
