package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 서버관련운영서비스 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcSrvrOprServc {

    /**
     * 클러스터SEQ
     */
    @NotEmpty(message = "클러스터SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal clstrSeq;

    /**
     * 운영서비스구분코드
     */
    @NotEmpty(message = "운영서비스구분코드는(은) 필수입력 항목입니다.")
    private String oprServcClCd;

    /**
     * 업무ID
     */
    @NotEmpty(message = "업무ID는(은) 필수입력 항목입니다.")
    private String jobId;

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

    public String getOprServcClCd() {
        return oprServcClCd;
    }

    public void setOprServcClCd(String oprServcClCd) {
        this.oprServcClCd = oprServcClCd;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

}
