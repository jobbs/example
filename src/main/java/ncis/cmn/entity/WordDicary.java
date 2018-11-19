package ncis.cmn.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class WordDicary {

	/**
	 * 시퀀스
	 */
	private Long wordSeq;

	/**
	 * 한글명
	 */
	@NotEmpty(message="한글명을 입력하세요.")
	private String wordKr;

	/**
	 * 영문명
	 */
	@NotEmpty(message="영문명을 입력하세요.")
	private String wordEn;

    @NotEmpty(message = "영문약자를 입력하세요.")
    private String wordAbrv;

	/**
	 * 설명
	 */
	private String wordDc;

	/**
	 * 금칙어구분
	 */
	private String prohibitYn;

	/**
	 * 사전구분 ( T : 용어사전, W : 단어사전 )
	 */
	private String dicaryDiv;


	/**
	 * 등록자아이디
	 */
	private String regId;

	/**
	 * 등록일시
	 */
	private Date regDate;

	/**
	 * 수정자아이디
	 */
	private String modId;

	/**
	 * 수정일시
	 */
	private Date modDate;

	public Long getWordSeq() {
		return wordSeq;
	}

	public void setWordSeq(Long wordSeq) {
		this.wordSeq = wordSeq;
	}

	public String getWordKr() {
		return wordKr;
	}

	public void setWordKr(String wordKr) {
		this.wordKr = wordKr;
	}

	public String getWordEn() {
		return wordEn;
	}

	public void setWordEn(String wordEn) {
		this.wordEn = wordEn;
	}

	public String getWordAbrv() {
		return wordAbrv;
	}

	public void setWordAbrv(String wordAbrv) {
		this.wordAbrv = wordAbrv;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
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
	 * @return the prohibitYn
	 */
	public String getProhibitYn() {
		return prohibitYn;
	}

	/**
	 * @param prohibitYn the prohibitYn to set
	 */
	public void setProhibitYn(String prohibitYn) {
		this.prohibitYn = prohibitYn;
	}

	/**
	 * @return the dicaryDiv
	 */
	public String getDicaryDiv() {
		return dicaryDiv;
	}

	/**
	 * @param dicaryDiv the dicaryDiv to set
	 */
	public void setDicaryDiv(String dicaryDiv) {
		this.dicaryDiv = dicaryDiv;
	}



}
