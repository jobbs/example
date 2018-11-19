/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmAlrm.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.util.Date;

/**
 * @author 최진호
 *
 */
public class CmAlrm {

	/**
	 * 알람 시퀀스
	 */
    private Long alrmSeq;

    /**
     * 제목
     */
    private String alrmSbjct;

    /**
     * 내용
     */
    private String alrmCn;

    /**
     * 담당자 아이디
     */
    private String chargerId;

    /**
     * 대상 URL
     */
    private String trgtUrl;

    /**
     * 상태
     */
    private String statCd;

    /**
     * 등록일시
     */
    private Date regDttm;

    /**
     * 확인여부
     */
    private String confrmYn;

    /**
     * 확인일시
     */
    private Date confrmDttm;

    /**
     * @return the alrmSeq
     */
    public Long getAlrmSeq() {
        return alrmSeq;
    }

    /**
     * @param alrmSeq the alrmSeq to set
     */
    public void setAlrmSeq(Long alrmSeq) {
        this.alrmSeq = alrmSeq;
    }

    /**
     * @return the alrmSbjct
     */
    public String getAlrmSbjct() {
        return alrmSbjct;
    }

    /**
     * @param alrmSbjct the alrmSbjct to set
     */
    public void setAlrmSbjct(String alrmSbjct) {
        this.alrmSbjct = alrmSbjct;
    }

    /**
     * @return the alrmCn
     */
    public String getAlrmCn() {
        return alrmCn;
    }

    /**
     * @param alrmCn the alrmCn to set
     */
    public void setAlrmCn(String alrmCn) {
        this.alrmCn = alrmCn;
    }

    /**
     * @return the chargerId
     */
    public String getChargerId() {
        return chargerId;
    }

    /**
     * @param chargerId the chargerId to set
     */
    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
    }

    /**
     * @return the trgtUrl
     */
    public String getTrgtUrl() {
        return trgtUrl;
    }

    /**
     * @param trgtUrl the trgtUrl to set
     */
    public void setTrgtUrl(String trgtUrl) {
        this.trgtUrl = trgtUrl;
    }

    /**
     * @return the statCd
     */
    public String getStatCd() {
        return statCd;
    }

    /**
     * @param statCd the statCd to set
     */
    public void setStatCd(String statCd) {
        this.statCd = statCd;
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

    /**
     * @return the confrmYn
     */
    public String getConfrmYn() {
        return confrmYn;
    }

    /**
     * @param confrmYn the confrmYn to set
     */
    public void setConfrmYn(String confrmYn) {
        this.confrmYn = confrmYn;
    }

    /**
     * @return the confrmDttm
     */
    public Date getConfrmDttm() {
        return confrmDttm;
    }

    /**
     * @param confrmDttm the confrmDttm to set
     */
    public void setConfrmDttm(Date confrmDttm) {
        this.confrmDttm = confrmDttm;
    }


}
