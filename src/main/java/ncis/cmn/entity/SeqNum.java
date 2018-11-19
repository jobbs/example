package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 채번테이블 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SeqNum {

    /**
     * 채번PREFIX
     */
    @NotEmpty(message = "채번PREFIX는(은) 필수입력 항목입니다.")
    private String seqNumPrfx;

    /**
     * 채번구분
     */
    @NotEmpty(message = "채번구분는(은) 필수입력 항목입니다.")
    private String seqNumCl;

    /**
     * 채번 시퀀스
     */
    private BigDecimal seqNumOrder;

    public String getSeqNumPrfx() {
        return seqNumPrfx;
    }

    public void setSeqNumPrfx(String seqNumPrfx) {
        this.seqNumPrfx = seqNumPrfx;
    }

    public String getSeqNumCl() {
        return seqNumCl;
    }

    public void setSeqNumCl(String seqNumCl) {
        this.seqNumCl = seqNumCl;
    }

    public BigDecimal getSeqNumOrder() {
        return seqNumOrder;
    }

    public void setSeqNumOrder(BigDecimal seqNumOrder) {
        this.seqNumOrder = seqNumOrder;
    }

}
