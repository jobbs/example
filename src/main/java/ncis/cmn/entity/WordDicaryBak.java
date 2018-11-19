package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 용어사전 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class WordDicaryBak {

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

    public String getWordDc() {
        return wordDc;
    }

    public void setWordDc(String wordDc) {
        this.wordDc = wordDc;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public BigDecimal getWordSeq() {
        return wordSeq;
    }

    public void setWordSeq(BigDecimal wordSeq) {
        this.wordSeq = wordSeq;
    }

}
