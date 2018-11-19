/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndPrposVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import ncis.cmn.entity.RnIpBndPrpos;

/**
 * @author 신재훈
 *
 */
public class IpBndPrposVo extends RnIpBndPrpos {
    private String prposClCdNm;

    public String getPrposClCdNm() {
        return prposClCdNm;
    }

    public void setPrposClCdNm(String prposClCdNm) {
        this.prposClCdNm = prposClCdNm;
    }
}
