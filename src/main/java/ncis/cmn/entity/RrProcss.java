package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 프로세스 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrProcss {

    /**
     * 프로세스SEQ
     */
    @NotEmpty(message = "프로세스ID는(은) 필수입력 항목입니다.")
    private int procssSeq;

    /**
     * 프로세스명
     */
    @NotEmpty(message = "프로세스명는(은) 필수입력 항목입니다.")
    private String procssNm;

    /**
     * 사용여부
     */
    @NotEmpty(message = "사용여부는(은) 필수입력 항목입니다.")
    private String useYn;

    /**
     * 등록일시
     */
    @NotEmpty(message = "등록일시는(은) 필수입력 항목입니다.")
    private String regDttm;

    /**
     * 프로세스설명
     */
    private String prcssDc;

    /**
     * 수정일시
     */
    private String updtDttm;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 수정자ID
     */
    private String updtUserId;



    public int getProcssSeq() {
		return procssSeq;
	}

	public void setProcssSeq(int procssSeq) {
		this.procssSeq = procssSeq;
	}

	public String getProcssNm() {
        return procssNm;
    }

    public void setProcssNm(String procssNm) {
        this.procssNm = procssNm;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getPrcssDc() {
        return prcssDc;
    }

    public void setPrcssDc(String prcssDc) {
        this.prcssDc = prcssDc;
    }

    public String getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(String updtDttm) {
        this.updtDttm = updtDttm;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

}
