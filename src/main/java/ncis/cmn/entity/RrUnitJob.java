/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmRsrcReqController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 단위업무 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrUnitJob {

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
     * 단위업무일련번호
     */
    @NotEmpty(message = "단위업무일련번호는(은) 필수입력 항목입니다.")
    private int uJobSeq;

    /**
     * 단위업무명
     */
    @NotEmpty(message = "단위업무명는(은) 필수입력 항목입니다.")
    private String uJobNm;

    /**
     * 단위업무설명
     */
    private String uJobDc;

    /**
     * 단위업무유형코드
     */
    private String uJobTyCd;

    /**
     * 인터페이스URL
     */
    private String intfcUrl;

    /**
     * 인터페이스파라미터
     */
    private String intfcParamtr;

    /**
     *  인터페이스기능유형코드
     *  */
    private String intfcFnctTyCd;

    /**
     * 하위프로세스SEQ
     */
    private BigDecimal lowProcssSeq;

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

    public String getuJobDc() {
        return uJobDc;
    }

    public void setuJobDc(String uJobDc) {
        this.uJobDc = uJobDc;
    }

    public String getuJobTyCd() {
        return uJobTyCd;
    }

    public void setuJobTyCd(String uJobTyCd) {
        this.uJobTyCd = uJobTyCd;
    }

    public String getIntfcUrl() {
        return intfcUrl;
    }

    public void setIntfcUrl(String intfcUrl) {
        this.intfcUrl = intfcUrl;
    }

    public String getIntfcParamtr() {
        return intfcParamtr;
    }

    public void setIntfcParamtr(String intfcParamtr) {
        this.intfcParamtr = intfcParamtr;
    }

	public int getProcssSeq() {
		return procssSeq;
	}

	public void setProcssSeq(int procssSeq) {
		this.procssSeq = procssSeq;
	}

	public int getuJobSeq() {
		return uJobSeq;
	}

	public void setuJobSeq(int uJobSeq) {
		this.uJobSeq = uJobSeq;
	}

	public BigDecimal getLowProcssSeq() {
		return lowProcssSeq;
	}

	public void setLowProcssSeq(BigDecimal lowProcssSeq) {
		this.lowProcssSeq = lowProcssSeq;
	}

	public String getIntfcFnctTyCd() {
		return intfcFnctTyCd;
	}

	public void setIntfcFnctTyCd(String intfcFnctTyCd) {
		this.intfcFnctTyCd = intfcFnctTyCd;
	}
}
