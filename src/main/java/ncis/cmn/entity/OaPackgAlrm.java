package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 패치알림 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaPackgAlrm {

    /**
     * 패치알림ID
     */
    @NotEmpty(message = "패치알림ID는(은) 필수입력 항목입니다.")
    private BigDecimal patchAlrmSeq;

    /**
     * 패치알림명
     */
    @NotEmpty(message = "패치알림명는(은) 필수입력 항목입니다.")
    private String patchAlrmNm;

    /**
     * 패치알림유형코드
     */
    @NotEmpty(message = "패치알림유형코드는(은) 필수입력 항목입니다.")
    private String patchAlrmTyCd;

    /**
     * 패치알림일시
     */
    @NotEmpty(message = "패치알림일시는(은) 필수입력 항목입니다.")
    private String patchAlrmDttm;

    /**
     * 패치알림사유
     */
    private String patchAlrmReasn;

    /**
     * 패치알림방식
     */
    private String patchAlrmMethod;

    /**
     * 패치알림통보자ID
     */
    private String patchAlrmDspthId;

    /**
     * 패치알림내용
     */
    private String patchAlrmCn;


    public BigDecimal getPatchAlrmSeq() {
		return patchAlrmSeq;
	}

	public void setPatchAlrmSeq(BigDecimal patchAlrmSeq) {
		this.patchAlrmSeq = patchAlrmSeq;
	}

	public String getPatchAlrmNm() {
        return patchAlrmNm;
    }

    public void setPatchAlrmNm(String patchAlrmNm) {
        this.patchAlrmNm = patchAlrmNm;
    }

    public String getPatchAlrmTyCd() {
        return patchAlrmTyCd;
    }

    public void setPatchAlrmTyCd(String patchAlrmTyCd) {
        this.patchAlrmTyCd = patchAlrmTyCd;
    }

    public String getPatchAlrmDttm() {
        return patchAlrmDttm;
    }

    public void setPatchAlrmDttm(String patchAlrmDttm) {
        this.patchAlrmDttm = patchAlrmDttm;
    }

    public String getPatchAlrmReasn() {
        return patchAlrmReasn;
    }

    public void setPatchAlrmReasn(String patchAlrmReasn) {
        this.patchAlrmReasn = patchAlrmReasn;
    }

    public String getPatchAlrmMethod() {
        return patchAlrmMethod;
    }

    public void setPatchAlrmMethod(String patchAlrmMethod) {
        this.patchAlrmMethod = patchAlrmMethod;
    }

    public String getPatchAlrmDspthId() {
        return patchAlrmDspthId;
    }

    public void setPatchAlrmDspthId(String patchAlrmDspthId) {
        this.patchAlrmDspthId = patchAlrmDspthId;
    }

    public String getPatchAlrmCn() {
        return patchAlrmCn;
    }

    public void setPatchAlrmCn(String patchAlrmCn) {
        this.patchAlrmCn = patchAlrmCn;
    }

}
