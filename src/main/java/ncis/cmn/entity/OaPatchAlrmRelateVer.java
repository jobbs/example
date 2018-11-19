package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 패치알림관련패키지버전 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaPatchAlrmRelateVer {

    /**
     * 패키지Seq
     */
    @NotEmpty(message = "패키지Seq는(은) 필수입력 항목입니다.")
    private BigDecimal packgSeq;

    /**
     * 버전
     */
    @NotEmpty(message = "버전는(은) 필수입력 항목입니다.")
    private String ver;

    /**
     * 패치알림Seq
     */
    @NotEmpty(message = "패치알림Seq는(은) 필수입력 항목입니다.")
    private BigDecimal patchAlrmSeq;

    /**
     * 구성패키지구분코드
     */
    private String compPackgClCd;

    /**
     * 릴리즈
     */
    private String release;

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

	public BigDecimal getPatchAlrmSeq() {
		return patchAlrmSeq;
	}

	public void setPatchAlrmSeq(BigDecimal patchAlrmSeq) {
		this.patchAlrmSeq = patchAlrmSeq;
	}

	public String getCompPackgClCd() {
		return compPackgClCd;
	}

	public void setCompPackgClCd(String compPackgClCd) {
		this.compPackgClCd = compPackgClCd;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}






}
