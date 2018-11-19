package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 이벤트 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StEvnt {

    /**
     * 이벤트ID
     */
    @NotEmpty(message = "이벤트ID는(은) 필수입력 항목입니다.")
    private BigDecimal evntSeq;

    /**
     * 발생일시
     */
    @NotEmpty(message = "발생일시는(은) 필수입력 항목입니다.")
    private String occrDttm;

    /**
     * 대상서버구분코드
     */
    private String trgtSrvrClCd;

    /**
     * 임계치대상서버ID
     */
    private String thresTrgtSrvrId;

    /**
     * 지표항목ID
     */
    private BigDecimal idxItmId;

    /**
     * 임계등급ID
     */
    private BigDecimal thresGrdId;

    /**
     * 현재값
     */
    @NotEmpty(message = "현재값는(은) 필수입력 항목입니다.")
    private String nowVl;

    /**
     * 이벤트내용
     */
    private String evntCn;

    /**
     * 대상경로
     */
    private String trgtPath;

    /**
     * 확인자
     */
    private String confrmUserId;

    /**
     * 확인일시
     */
    private String confrmDt;


    public String getOccrDttm() {
        return occrDttm;
    }

    public void setOccrDttm(String occrDttm) {
        this.occrDttm = occrDttm;
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

    public BigDecimal getThresGrdId() {
        return thresGrdId;
    }

    public void setThresGrdId(BigDecimal thresGrdId) {
        this.thresGrdId = thresGrdId;
    }

    public String getNowVl() {
        return nowVl;
    }

    public void setNowVl(String nowVl) {
        this.nowVl = nowVl;
    }

    public String getEvntCn() {
        return evntCn;
    }

    public void setEvntCn(String evntCn) {
        this.evntCn = evntCn;
    }

    public String getTrgtPath() {
        return trgtPath;
    }

    public void setTrgtPath(String trgtPath) {
        this.trgtPath = trgtPath;
    }

    public String getConfrmUserId() {
        return confrmUserId;
    }

    public void setConfrmUserId(String confrmUserId) {
        this.confrmUserId = confrmUserId;
    }

    public String getConfrmDt() {
        return confrmDt;
    }

    public void setConfrmDt(String confrmDt) {
        this.confrmDt = confrmDt;
    }

	public BigDecimal getEvntSeq() {
		return evntSeq;
	}

	public void setEvntSeq(BigDecimal evntSeq) {
		this.evntSeq = evntSeq;
	}

}
