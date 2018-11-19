package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버설치패키지 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaVmInstlPackg {

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 패키지SEQ
     */
    @NotEmpty(message = "패키지SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal packgSeq;

    /**
     * 버전
     */
    @NotEmpty(message = "버전는(은) 필수입력 항목입니다.")
    private String ver;

    /**
     * 패키지명
     */
    @NotEmpty(message = "패키지명는(은) 필수입력 항목입니다.")
    private String packgNm;

    /**
     * 설치일자
     */
    private String instlDt;

    /**
     * 릴리즈
     */
    private String release;

    /**
     * 삭제자 ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private String delDttm;

    /**
     * 삭제여부
     */
    private String delYn;


    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
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

    public String getPackgNm() {
        return packgNm;
    }

    public void setPackgNm(String packgNm) {
        this.packgNm = packgNm;
    }

    public String getInstlDt() {
        return instlDt;
    }

    public void setInstlDt(String instlDt) {
        this.instlDt = instlDt;
    }

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}

	public String getDelDttm() {
		return delDttm;
	}

	public void setDelDttm(String delDttm) {
		this.delDttm = delDttm;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}



}
