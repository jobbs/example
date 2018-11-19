package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 프로세스인스턴스 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrProcssInst {

    /**
     * 프로세스인스턴스SEQ
     */
    @NotEmpty(message = "프로세스인스턴스ID는(은) 필수입력 항목입니다.")
    private int procssInstSeq;

    /**
     * 프로세스SEQ
     */
    @NotEmpty(message = "프로세스ID는(은) 필수입력 항목입니다.")
    private int procssSeq;

    /**
     * 시작일시
     */
    @NotEmpty(message = "시작일시는(은) 필수입력 항목입니다.")
    private String strtDttm;

    /**
     * 종료일시
     */
    private String endDttm;

    /**
     * 상위프로세스인스턴스SEQ
     */
    private int upperProcssInstSeq;

    /**
     * 상태코드
     */
    private String statCd;

    /**
     * 참조업무ID
     */
    private String refJobId;

    /**
     * 자원요청번호
     */
    @NotEmpty(message = "자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 강제완료 여부 (default : N)
     */
    private String forceComptYn;

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

	public int getUpperProcssInstSeq() {
		return upperProcssInstSeq;
	}

	public void setUpperProcssInstSeq(int upperProcssInstSeq) {
		this.upperProcssInstSeq = upperProcssInstSeq;
	}

	public String getStatCd() {
		return statCd;
	}

	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}

	public String getRefJobId() {
		return refJobId;
	}

	public void setRefJobId(String refJobId) {
		this.refJobId = refJobId;
	}

	public String getRsrcReqNo() {
		return rsrcReqNo;
	}

	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getForceComptYn() {
		return forceComptYn;
	}

	public void setForceComptYn(String forceComptYn) {
		this.forceComptYn = forceComptYn;
	}
}
