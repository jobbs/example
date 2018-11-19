package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 채번정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SeqNumInfo {

    /**
     * 채번구분
     */
    @NotEmpty(message = "채번구분는(은) 필수입력 항목입니다.")
    private String seqNumCl;

    /**
     * 채번설명
     */
    @NotEmpty(message = "채번설명는(은) 필수입력 항목입니다.")
    private String seqNumDc;

    public String getSeqNumCl() {
        return seqNumCl;
    }

    public void setSeqNumCl(String seqNumCl) {
        this.seqNumCl = seqNumCl;
    }

    public String getSeqNumDc() {
        return seqNumDc;
    }

    public void setSeqNumDc(String seqNumDc) {
        this.seqNumDc = seqNumDc;
    }

}
