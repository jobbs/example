/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndInstSearchVo.java
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

import java.math.BigDecimal;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 신재훈
 *
 */
public class IpBndInstSearchVo extends CommonSearchVo {
    private BigDecimal searchBndSeq; // 대역SEQ
    private String searchInstitutionId; // 부처ID

    public BigDecimal getSearchBndSeq() {
        return searchBndSeq;
    }

    public void setSearchBndSeq(BigDecimal searchBndSeq) {
        this.searchBndSeq = searchBndSeq;
    }

    public String getSearchInstitutionId() {
        return searchInstitutionId;
    }

    public void setSearchInstitutionId(String searchInstitutionId) {
        this.searchInstitutionId = searchInstitutionId;
    }

}
