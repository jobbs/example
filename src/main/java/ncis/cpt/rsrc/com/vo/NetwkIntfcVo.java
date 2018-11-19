/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkIntfcVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 7.
 * @lastmodified 2016. 10. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 7.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import ncis.cmn.entity.RcNetwkIntfc;

/**
 * @author 신재훈, 심원보
 *
 */
public class NetwkIntfcVo extends RcNetwkIntfc {

    private String netwkNm;

    private String nicPrposCdNm;

    public String getNetwkNm() {
        return netwkNm;
    }

    public void setNetwkNm(String netwkNm) {
        this.netwkNm = netwkNm;
    }

    public String getNicPrposCdNm() {
        return nicPrposCdNm;
    }

    public void setNicPrposCdNm(String nicPrposCdNm) {
        this.nicPrposCdNm = nicPrposCdNm;
    }

}
