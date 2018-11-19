package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 용어사전 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class WordDicary1 {

    /**
     * 한글명
     */
    @NotEmpty(message = "한글명는(은) 필수입력 항목입니다.")
    private String wordKr;

    /**
     * 영문명
     */
    @NotEmpty(message = "영문명는(은) 필수입력 항목입니다.")
    private String wordEn;

    /**
     * 약어
     */
    @NotEmpty(message = "약어는(은) 필수입력 항목입니다.")
    private String wordAbrv;

    /**
     * 설명
     */
    private String wordDc;

    /**
     * 등록일
     */
    private String regDate;

    /**
     * 등록자아이디
     */
    private String regId;

    /**
     * 수정자아이디
     */
    private String modId;

    /**
     * 시퀀스
     */
    @NotEmpty(message = "시퀀스는(은) 필수입력 항목입니다.")
    private BigDecimal wordSeq;

	/**
	 * @return the wordKr
	 */
	public String getWordKr() {
		return wordKr;
	}

	/**
	 * @param wordKr the wordKr to set
	 */
	public void setWordKr(String wordKr) {
		this.wordKr = wordKr;
	}

	/**
	 * @return the wordEn
	 */
	public String getWordEn() {
		return wordEn;
	}

	/**
	 * @param wordEn the wordEn to set
	 */
	public void setWordEn(String wordEn) {
		this.wordEn = wordEn;
	}

	/**
	 * @return the wordAbrv
	 */
	public String getWordAbrv() {
		return wordAbrv;
	}

	/**
	 * @param wordAbrv the wordAbrv to set
	 */
	public void setWordAbrv(String wordAbrv) {
		this.wordAbrv = wordAbrv;
	}

	/**
	 * @return the wordDc
	 */
	public String getWordDc() {
		return wordDc;
	}

	/**
	 * @param wordDc the wordDc to set
	 */
	public void setWordDc(String wordDc) {
		this.wordDc = wordDc;
	}

	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}

	/**
	 * @return the modId
	 */
	public String getModId() {
		return modId;
	}

	/**
	 * @param modId the modId to set
	 */
	public void setModId(String modId) {
		this.modId = modId;
	}

	/**
	 * @return the wordSeq
	 */
	public BigDecimal getWordSeq() {
		return wordSeq;
	}

	/**
	 * @param wordSeq the wordSeq to set
	 */
	public void setWordSeq(BigDecimal wordSeq) {
		this.wordSeq = wordSeq;
	}

}
