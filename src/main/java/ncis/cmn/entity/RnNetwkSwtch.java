package ncis.cmn.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 네크워크스위치 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnNetwkSwtch {

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * 네트워크유형구분코드
     */
    private String netwkTyClCd;

    /**
     * 상위가상서버SEQ
     */
    private BigDecimal upperVmSeq;

    /**
     * 기관ID
     */
    @NotEmpty(message = "기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private Timestamp delDttm;

    /**
     * 삭제여부
     */
    private String delYn;

	/**
	 * @return the vmSeq
	 */
	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	/**
	 * @param vmSeq the vmSeq to set
	 */
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}

	/**
	 * @return the netwkTyClCd
	 */
	public String getNetwkTyClCd() {
		return netwkTyClCd;
	}

	/**
	 * @param netwkTyClCd the netwkTyClCd to set
	 */
	public void setNetwkTyClCd(String netwkTyClCd) {
		this.netwkTyClCd = netwkTyClCd;
	}

	/**
	 * @return the upperVmSeq
	 */
	public BigDecimal getUpperVmSeq() {
		return upperVmSeq;
	}

	/**
	 * @param upperVmSeq the upperVmSeq to set
	 */
	public void setUpperVmSeq(BigDecimal upperVmSeq) {
		this.upperVmSeq = upperVmSeq;
	}

	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return the delUserId
	 */
	public String getDelUserId() {
		return delUserId;
	}

	/**
	 * @param delUserId the delUserId to set
	 */
	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}

	/**
	 * @return the delDttm
	 */
	public Timestamp getDelDttm() {
		return delDttm;
	}

	/**
	 * @param delDttm the delDttm to set
	 */
	public void setDelDttm(Timestamp delDttm) {
		this.delDttm = delDttm;
	}

	/**
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}

	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
