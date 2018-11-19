package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버 업무 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcVmJob {

    /**
     * 가상서버 SEQ
     */
    @NotEmpty(message = "가상서버 SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 업무 ID
     */
    @NotEmpty(message = "업무 ID는(은) 필수입력 항목입니다.")
    private String jobId;

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

}
