/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchAsgnSearchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.math.BigDecimal;

/**
 * @author 신재훈
 *
 */
public class VrSwtchAsgnSearchVo {
    private BigDecimal searchBndSeq;
    private BigDecimal searchVrSwtchSeq;

    public BigDecimal getSearchVrSwtchSeq() {
        return searchVrSwtchSeq;
    }

    public void setSearchVrSwtchSeq(BigDecimal searchVrSwtchSeq) {
        this.searchVrSwtchSeq = searchVrSwtchSeq;
    }

    public BigDecimal getSearchBndSeq() {
        return searchBndSeq;
    }

    public void setSearchBndSeq(BigDecimal searchBndSeq) {
        this.searchBndSeq = searchBndSeq;
    }

}
