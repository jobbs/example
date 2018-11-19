package ncis.cmn.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * MAC 대역 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcMacBnd {

    /**
     * MAC대역SEQ
     */
    @NotEmpty(message = "MAC대역SEQ는(은) 필수입력 항목입니다.")
    private Integer macBndSeq;

    /**
     * MAC대역명
     */
    @NotEmpty(message = "MAC대역명는(은) 필수입력 항목입니다.")
    private String macBndNm;

    /**
     * 설명
     */
    private String dc;

    /**
     * MAC시작주소
     */
    private String macStrtAddr;

    /**
     * MAC종료주소
     */
    private String macEndAddr;

    /**
     * 자원풀ID
     */
    @NotEmpty(message = "자원풀ID는(은) 필수입력 항목입니다.")
    private String rsrcPoolId;

    /**
     * UUID
     */
    private String uuid;

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

    private Date updtDttm;

    private String regUserId;

    private Date regDttm;


    /**
     * @return the macBndId
     */
    public Integer getMacBndSeq() {
        return macBndSeq;
    }

    /**
     * @param macBndId the macBndId to set
     */
    public void setMacBndSeq(Integer macBndSeq) {
        this.macBndSeq = macBndSeq;
    }

    /**
     * @return the macBndNm
     */
    public String getMacBndNm() {
        return macBndNm;
    }

    /**
     * @param macBndNm the macBndNm to set
     */
    public void setMacBndNm(String macBndNm) {
        this.macBndNm = macBndNm;
    }

    /**
     * @return the dc
     */
    public String getDc() {
        return dc;
    }

    /**
     * @param dc the dc to set
     */
    public void setDc(String dc) {
        this.dc = dc;
    }

    /**
     * @return the macEndAddr
     */
    public String getMacEndAddr() {
        return macEndAddr;
    }

    /**
     * @param macEndAddr the macEndAddr to set
     */
    public void setMacEndAddr(String macEndAddr) {
        this.macEndAddr = macEndAddr;
    }

    /**
     * @return the rsrcPoolId
     */
    public String getRsrcPoolId() {
        return rsrcPoolId;
    }

    /**
     * @param rsrcPoolId the rsrcPoolId to set
     */
    public void setRsrcPoolId(String rsrcPoolId) {
        this.rsrcPoolId = rsrcPoolId;
    }

    public String getMacStrtAddr() {
        return macStrtAddr;
    }

    public void setMacStrtAddr(String macStrtAddr) {
        this.macStrtAddr = macStrtAddr;
    }

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	/**
	 * @return the updtDttm
	 */
	public Date getUpdtDttm() {
		return updtDttm;
	}

	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(Date updtDttm) {
		this.updtDttm = updtDttm;
	}

	/**
	 * @return the regUserId
	 */
	public String getRegUserId() {
		return regUserId;
	}

	/**
	 * @param regUserId the regUserId to set
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	/**
	 * @return the regDttm
	 */
	public Date getRegDttm() {
		return regDttm;
	}

	/**
	 * @param regDttm the regDttm to set
	 */
	public void setRegDttm(Date regDttm) {
		this.regDttm = regDttm;
	}
}
