/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrPrposVo.java
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
package ncis.cpt.rsrc.com.vo;

import ncis.cmn.entity.RcClstrPrpos;

/**
 * @author 심원보
 *
 */
public class ClstrPrposVo extends RcClstrPrpos {

    private String prposClCdNm;

    public String getPrposClCdNm() {
        return prposClCdNm;
    }

    public void setPrposClCdNm(String prposClCdNm) {
        this.prposClCdNm = prposClCdNm;
    }

}