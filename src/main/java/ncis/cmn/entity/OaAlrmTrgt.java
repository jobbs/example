package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 알림대상자 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaAlrmTrgt {

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
     * 담당자ID
     */
    @NotEmpty(message = "담당자ID는(은) 필수입력 항목입니다.")
    private String chargerId;

    /**
     * 담당자구분코드
     */
    @NotEmpty(message = "담당자구분코드는(은) 필수입력 항목입니다.")
    private String chargerClCd;

    /**
     * 확인여부
     */
    private String confrmYn;

    /**
     * 확인일자
     */
    private String confrmDt;

    public BigDecimal getPatchAlrmSeq() {
		return patchAlrmSeq;
	}

	public void setPatchAlrmSeq(BigDecimal patchAlrmSeq) {
		this.patchAlrmSeq = patchAlrmSeq;
	}

	public String getChargerId() {
        return chargerId;
    }

    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
    }

    public String getChargerClCd() {
        return chargerClCd;
    }

    public void setChargerClCd(String chargerClCd) {
        this.chargerClCd = chargerClCd;
    }

    public String getConfrmYn() {
        return confrmYn;
    }

    public void setConfrmYn(String confrmYn) {
        this.confrmYn = confrmYn;
    }

    public String getConfrmDt() {
        return confrmDt;
    }

    public void setConfrmDt(String confrmDt) {
        this.confrmDt = confrmDt;
    }

	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}



}
