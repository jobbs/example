package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 이벤트통보(이력) Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StEvntDspthHist {

    /**
     * 이벤트통보ID
     */
    @NotEmpty(message = "이벤트통보ID는(은) 필수입력 항목입니다.")
    private BigDecimal evntDspthId;

    /**
     * 대상서버구분코드
     */
    @NotEmpty(message = "대상서버구분코드는(은) 필수입력 항목입니다.")
    private String trgtSrvrClCd;

    /**
     * 임계치대상서버ID
     */
    @NotEmpty(message = "임계치대상서버ID는(은) 필수입력 항목입니다.")
    private String thresTrgtSrvrId;

    /**
     * 지표항목ID
     */
    @NotEmpty(message = "지표항목ID는(은) 필수입력 항목입니다.")
    private BigDecimal idxItmId;

    /**
     * 임계등급ID
     */
    @NotEmpty(message = "임계등급ID는(은) 필수입력 항목입니다.")
    private String thresGrdId;

    /**
     * 통보일시
     */
    @NotEmpty(message = "통보일시는(은) 필수입력 항목입니다.")
    private String dspthDttm;

    /**
     * 통보대상자ID
     */
    @NotEmpty(message = "통보대상자ID는(은) 필수입력 항목입니다.")
    private String dspthTrgtId;

    /**
     * 통보형식코드
     */
    @NotEmpty(message = "통보형식코드는(은) 필수입력 항목입니다.")
    private String dspthTyCd;

    /**
     * 대상서버명
     */
    private String trgtSrvrNm;

    /**
     * 통보상태코드
     */
    private String dspthStatCd;

    /**
     * 경로
     */
    private String path;

    /**
     * 내용
     */
    private String cn;

    public BigDecimal getEvntDspthId() {
        return evntDspthId;
    }

    public void setEvntDspthId(BigDecimal evntDspthId) {
        this.evntDspthId = evntDspthId;
    }

    public String getTrgtSrvrClCd() {
        return trgtSrvrClCd;
    }

    public void setTrgtSrvrClCd(String trgtSrvrClCd) {
        this.trgtSrvrClCd = trgtSrvrClCd;
    }

    public String getThresTrgtSrvrId() {
        return thresTrgtSrvrId;
    }

    public void setThresTrgtSrvrId(String thresTrgtSrvrId) {
        this.thresTrgtSrvrId = thresTrgtSrvrId;
    }

    public BigDecimal getIdxItmId() {
        return idxItmId;
    }

    public void setIdxItmId(BigDecimal idxItmId) {
        this.idxItmId = idxItmId;
    }

    public String getThresGrdId() {
        return thresGrdId;
    }

    public void setThresGrdId(String thresGrdId) {
        this.thresGrdId = thresGrdId;
    }

    public String getDspthDttm() {
        return dspthDttm;
    }

    public void setDspthDttm(String dspthDttm) {
        this.dspthDttm = dspthDttm;
    }

    public String getDspthTrgtId() {
        return dspthTrgtId;
    }

    public void setDspthTrgtId(String dspthTrgtId) {
        this.dspthTrgtId = dspthTrgtId;
    }

    public String getDspthTyCd() {
        return dspthTyCd;
    }

    public void setDspthTyCd(String dspthTyCd) {
        this.dspthTyCd = dspthTyCd;
    }

    public String getTrgtSrvrNm() {
        return trgtSrvrNm;
    }

    public void setTrgtSrvrNm(String trgtSrvrNm) {
        this.trgtSrvrNm = trgtSrvrNm;
    }

    public String getDspthStatCd() {
        return dspthStatCd;
    }

    public void setDspthStatCd(String dspthStatCd) {
        this.dspthStatCd = dspthStatCd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

}
