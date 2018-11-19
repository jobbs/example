package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 단위업무관계 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrUnitJobRelate {

    /**
     * 단위업무관계SEQ
     */
    @NotEmpty(message = "단위업무관계SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal uJobRelateSeq;

    /**
     * 단위업무관계명
     */
    @NotEmpty(message = "단위업무관계명는(은) 필수입력 항목입니다.")
    private String uJobRelateNm;

    /**
     * 단위업무관계유형코드
     */
    @NotEmpty(message = "단위업무관계유형코드는(은) 필수입력 항목입니다.")
    private String uJobRelateTyCd;

    /**
     * 등록일시
     */
    @NotEmpty(message = "등록일시는(은) 필수입력 항목입니다.")
    private String regDttm;

    /**
     * 설명
     */
    private String dc;

    /**
     * 시작단위업무ID
     */
    private String strtUJobId;

    /**
     * 종료단위업무ID
     */
    private String endUJobId;

    /**
     * 종료단위업무조건변수ID
     */
    private String endUJobCndVarId;

    /**
     * 종료단위업무조건변수값
     */
    private String endUJobCndVarVl;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private String updtDttm;

    /**
     * 단위업무ID
     */
    @NotEmpty(message = "단위업무ID는(은) 필수입력 항목입니다.")
    private String uJobId;

    /**
     * 프로세스ID
     */
    @NotEmpty(message = "프로세스ID는(은) 필수입력 항목입니다.")
    private BigDecimal procssSeq;



    public String getuJobRelateNm() {
        return uJobRelateNm;
    }

    public void setuJobRelateNm(String uJobRelateNm) {
        this.uJobRelateNm = uJobRelateNm;
    }

    public String getuJobRelateTyCd() {
        return uJobRelateTyCd;
    }

	public BigDecimal getuJobRelateSeq() {
		return uJobRelateSeq;
	}

	public void setuJobRelateSeq(BigDecimal uJobRelateSeq) {
		this.uJobRelateSeq = uJobRelateSeq;
	}

	public void setuJobRelateTyCd(String uJobRelateTyCd) {
        this.uJobRelateTyCd = uJobRelateTyCd;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getStrtUJobId() {
        return strtUJobId;
    }

    public void setStrtUJobId(String strtUJobId) {
        this.strtUJobId = strtUJobId;
    }

    public String getEndUJobId() {
        return endUJobId;
    }

    public void setEndUJobId(String endUJobId) {
        this.endUJobId = endUJobId;
    }

    public String getEndUJobCndVarId() {
        return endUJobCndVarId;
    }

    public void setEndUJobCndVarId(String endUJobCndVarId) {
        this.endUJobCndVarId = endUJobCndVarId;
    }

    public String getEndUJobCndVarVl() {
        return endUJobCndVarVl;
    }

    public void setEndUJobCndVarVl(String endUJobCndVarVl) {
        this.endUJobCndVarVl = endUJobCndVarVl;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public String getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(String updtDttm) {
        this.updtDttm = updtDttm;
    }

    public String getuJobId() {
        return uJobId;
    }

    public void setuJobId(String uJobId) {
        this.uJobId = uJobId;
    }

	public BigDecimal getProcssSeq() {
		return procssSeq;
	}

	public void setProcssSeq(BigDecimal procssSeq) {
		this.procssSeq = procssSeq;
	}



}
