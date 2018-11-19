package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 프로세스업무목록 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrProcssJobList {

    /**
     * 프로세스업무인스턴스SEQ
     */
    @NotEmpty(message = "프로세스업무인스턴스SEQ는(은) 필수입력 항목입니다.")
    private int procssJobInstSeq;

    /**
     * 프로세스인스턴스SEQ
     */
    @NotEmpty(message = "프로세스인스턴스SEQ는(은) 필수입력 항목입니다.")
    private int procssInstSeq;

    /**
     * 프로세스SEQ
     */
    @NotEmpty(message = "프로세스SEQ는(은) 필수입력 항목입니다.")
    private int procssSeq;

    /**
     * 단위업무ID
     */
    @NotEmpty(message = "단위업무ID는(은) 필수입력 항목입니다.")
    private String uJobId;

    /**
     * 단위업무명
     */
    @NotEmpty(message = "단위업무명는(은) 필수입력 항목입니다.")
    private String uJobNm;

    /**
     * 시작일시
     */
    private String strtDttm;

    /**
     * 종료일시
     */
    private String endDttm;

    /**
     * 상태코드
     */
    private String statCd;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 설명
     */
    private String dc;


    public int getProcssJobInstSeq() {
		return procssJobInstSeq;
	}

	public void setProcssJobInstSeq(int procssJobInstSeq) {
		this.procssJobInstSeq = procssJobInstSeq;
	}

	public int getProcssInstSeq() {
		return procssInstSeq;
	}

	public void setProcssInstSeq(int procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}

	public int getProcssSeq() {
		return procssSeq;
	}

	public void setProcssSeq(int procssSeq) {
		this.procssSeq = procssSeq;
	}

	public String getuJobId() {
        return uJobId;
    }

    public void setuJobId(String uJobId) {
        this.uJobId = uJobId;
    }

    public String getuJobNm() {
        return uJobNm;
    }

    public void setuJobNm(String uJobNm) {
        this.uJobNm = uJobNm;
    }

    public String getStrtDttm() {
        return strtDttm;
    }

    public void setStrtDttm(String strtDttm) {
        this.strtDttm = strtDttm;
    }

    public String getEndDttm() {
        return endDttm;
    }

    public void setEndDttm(String endDttm) {
        this.endDttm = endDttm;
    }

    public String getStatCd() {
        return statCd;
    }

    public void setStatCd(String statCd) {
        this.statCd = statCd;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

}
