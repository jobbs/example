package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버별배포상세(배포이력 포함) Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaVmDistrbDtl {

	/**
     * 배포SEQ
     */
    @NotEmpty(message = "배포SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal distrbSeq;

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 배포완료일시
     */
    private String distrbComptDttm;

    /**
     * 가상서버구성ID
     */
    private String vmCompId;

    /**
     * 배포처리상태코드
     */
    private String distrbPrcssStatCd;




    public String getDistrbComptDttm() {
        return distrbComptDttm;
    }

    public void setDistrbComptDttm(String distrbComptDttm) {
        this.distrbComptDttm = distrbComptDttm;
    }

    public String getVmCompId() {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId) {
        this.vmCompId = vmCompId;
    }

    public String getDistrbPrcssStatCd() {
        return distrbPrcssStatCd;
    }

    public void setDistrbPrcssStatCd(String distrbPrcssStatCd) {
        this.distrbPrcssStatCd = distrbPrcssStatCd;
    }

	public BigDecimal getDistrbSeq() {
		return distrbSeq;
	}

	public void setDistrbSeq(BigDecimal distrbSeq) {
		this.distrbSeq = distrbSeq;
	}

	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}

}
