package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 프로세스변수목록 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrProcssVarList {

    /**
     * 변수SEQ
     */
    @NotEmpty(message = "변수ID는(은) 필수입력 항목입니다.")
    private int varSeq;

    /**
     * 변수명
     */
    @NotEmpty(message = "변수명는(은) 필수입력 항목입니다.")
    private String varNm;

    /**
     * 변수유형코드
     */
    @NotEmpty(message = "변수유형코드는(은) 필수입력 항목입니다.")
    private String varTyCd;

    /**
     * 변수값
     */
    private String varVl;

    /**
     * 변수구분코드
     */
    private String valVlClCd;

    /**
     * 프로세스인스턴스SEQ
     */
    private int procssInstSeq;

    /**
     * 프로세스SEQ
     */
    private int procssSeq;


    public int getVarSeq() {
		return varSeq;
	}

	public void setVarSeq(int varSeq) {
		this.varSeq = varSeq;
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

	public String getVarNm() {
        return varNm;
    }

    public void setVarNm(String varNm) {
        this.varNm = varNm;
    }

    public String getVarTyCd() {
        return varTyCd;
    }

    public void setVarTyCd(String varTyCd) {
        this.varTyCd = varTyCd;
    }

    public String getVarVl() {
        return varVl;
    }

    public void setVarVl(String varVl) {
        this.varVl = varVl;
    }

    public String getValVlClCd() {
        return valVlClCd;
    }

    public void setValVlClCd(String valVlClCd) {
        this.valVlClCd = valVlClCd;
    }

}
