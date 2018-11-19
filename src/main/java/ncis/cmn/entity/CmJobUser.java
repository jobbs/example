package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 업무사용자 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmJobUser {

    /**
     * 업무ID
     */
    @NotEmpty(message = "업무ID는(은) 필수입력 항목입니다.")
    private String jobId;

    /**
     * 사용자ID
     */
    @NotEmpty(message = "사용자ID는(은) 필수입력 항목입니다.")
    private String userId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
