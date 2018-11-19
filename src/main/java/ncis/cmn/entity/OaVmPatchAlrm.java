package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버별패치알림 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaVmPatchAlrm {

    /**
     * 패치알림Seq
     */
    @NotEmpty(message = "패치알림Seq는(은) 필수입력 항목입니다.")
    private BigDecimal patchAlrmSeq;

    /**
     * 가상서버Seq
     */
    @NotEmpty(message = "가상서버Seq는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 적용여부
     */
    private String applcYn;

    /**
     * 패키지SEQ
     */
    private BigDecimal packgSeq;

    /**
     * 버전
     */
    private String ver;

    /**
     * 릴리즈
     */
    private String release;



    public BigDecimal getPatchAlrmSeq() {
		return patchAlrmSeq;
	}

	public void setPatchAlrmSeq(BigDecimal patchAlrmSeq) {
		this.patchAlrmSeq = patchAlrmSeq;
	}

	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}

	public String getApplcYn() {
        return applcYn;
    }

    public void setApplcYn(String applcYn) {
        this.applcYn = applcYn;
    }

	public BigDecimal getPackgSeq() {
		return packgSeq;
	}

	public void setPackgSeq(BigDecimal packgSeq) {
		this.packgSeq = packgSeq;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}


}
