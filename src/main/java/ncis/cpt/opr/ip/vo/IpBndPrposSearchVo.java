/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ipBndPrposSearchVo.java
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

import java.math.BigDecimal;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 신재훈
 *
 */
public class IpBndPrposSearchVo extends CommonSearchVo {
    private BigDecimal searchBndSeq;
    private String searchPrposClCd;

    public String getSearchPrposClCd() {
        return searchPrposClCd;
    }

    public void setSearchPrposClCd(String searchPrposClCd) {
        this.searchPrposClCd = searchPrposClCd;
    }

    public BigDecimal getSearchBndSeq() {
        return searchBndSeq;
    }

    public void setSearchBndSeq(BigDecimal searchBndSeq) {
        this.searchBndSeq = searchBndSeq;
    }

}
