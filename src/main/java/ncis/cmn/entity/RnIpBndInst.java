/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnIpBndInst.java
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
package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * IP대역부처(기관) Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 신재훈
 *
 */
public class RnIpBndInst {
    /**
     * 대역SEQ
     */
    @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal bndSeq;

    /**
     * 부처(기관)ID
     */
    @NotEmpty(message = "부처는(은) 필수입력 항목입니다.")
    private String institutionId;

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

}
