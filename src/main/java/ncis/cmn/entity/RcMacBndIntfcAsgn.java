package ncis.cmn.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * MAC대역인터페이스할당 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcMacBndIntfcAsgn {

    /**
     * MAC SEQ
     */
    @NotEmpty(message = "MAC_SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal macSeq;

    /**
     * MAC대역Seq
     */
    @NotEmpty(message = "MAC대역Seq는(은) 필수입력 항목입니다.")
    private BigDecimal macBndSeq;

    /**
     * 네트워크인터페이스SEQ
     */
    private BigDecimal netwkIntfcSeq;

    /**
     * MAC주소
     */
    private String macAddr;

    /**
     * 할당여부
     */
    private String asgnYn;

    /**
     * 할당일자
     */
    private Date asgnDt;

	/**
	 * @return the macSeq
	 */
	public BigDecimal getMacSeq() {
		return macSeq;
	}

	/**
	 * @param macSeq the macSeq to set
	 */
	public void setMacSeq(BigDecimal macSeq) {
		this.macSeq = macSeq;
	}

	/**
	 * @return the macBndSeq
	 */
	public BigDecimal getMacBndSeq() {
		return macBndSeq;
	}

	/**
	 * @param macBndSeq the macBndSeq to set
	 */
	public void setMacBndSeq(BigDecimal macBndSeq) {
		this.macBndSeq = macBndSeq;
	}

	/**
	 * @return the netwkIntfcSeq
	 */
	public BigDecimal getNetwkIntfcSeq() {
		return netwkIntfcSeq;
	}

	/**
	 * @param netwkIntfcSeq the netwkIntfcSeq to set
	 */
	public void setNetwkIntfcSeq(BigDecimal netwkIntfcSeq) {
		this.netwkIntfcSeq = netwkIntfcSeq;
	}

	/**
	 * @return the macAddr
	 */
	public String getMacAddr() {
		return macAddr;
	}

	/**
	 * @param macAddr the macAddr to set
	 */
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	/**
	 * @return the asgnYn
	 */
	public String getAsgnYn() {
		return asgnYn;
	}

	/**
	 * @param asgnYn the asgnYn to set
	 */
	public void setAsgnYn(String asgnYn) {
		this.asgnYn = asgnYn;
	}

	/**
	 * @return the asgnDt
	 */
	public Date getAsgnDt() {
		return asgnDt;
	}

	/**
	 * @param asgnDt the asgnDt to set
	 */
	public void setAsgnDt(Date asgnDt) {
		this.asgnDt = asgnDt;
	}
}
