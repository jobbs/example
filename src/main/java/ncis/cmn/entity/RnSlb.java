package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SLB Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnSlb {

    /**
     * VIP주소
     */
    @NotEmpty(message = "VIP주소는(은) 필수입력 항목입니다.")
    private String vipAddr;

    /**
     * 프로토콜
     */
    @NotEmpty(message = "프로토콜는(은) 필수입력 항목입니다.")
    private String prtcl;

    /**
     * 포트
     */
    @NotEmpty(message = "포트는(은) 필수입력 항목입니다.")
    private String port;

    /**
     * SLB유형코드
     */
    @NotEmpty(message = "SLB유형코드는(은) 필수입력 항목입니다.")
    private String slbTyCd;

    /**
     * 세션유지유형코드
     */
    @NotEmpty(message = "세션유지유형코드는(은) 필수입력 항목입니다.")
    private String sessMntncTyCd;

    /**
     * 세션유지값
     */
    private String sessMntncVl;

    /**
     * 상태확인
     */
    private String statConfrm;

    /**
     * 상태확인주기
     */
    private BigDecimal statConfrmCycle;

    /**
     * 상태확인타임아웃
     */
    private BigDecimal statConfrmTOut;

    /**
     * 최대시도횟수
     */
    private BigDecimal maxTryCnt;

    /**
     * 상태확인_HTTP_URL
     */
    private String statConfrmHttpUrl;

    /**
     * 기관ID
     */
    private String institutionId;

    /**
     * 네트워크ID
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

	/**
	 * @return the vipAddr
	 */
	public String getVipAddr() {
		return vipAddr;
	}

	/**
	 * @param vipAddr the vipAddr to set
	 */
	public void setVipAddr(String vipAddr) {
		this.vipAddr = vipAddr;
	}

	/**
	 * @return the prtcl
	 */
	public String getPrtcl() {
		return prtcl;
	}

	/**
	 * @param prtcl the prtcl to set
	 */
	public void setPrtcl(String prtcl) {
		this.prtcl = prtcl;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the slbTyCd
	 */
	public String getSlbTyCd() {
		return slbTyCd;
	}

	/**
	 * @param slbTyCd the slbTyCd to set
	 */
	public void setSlbTyCd(String slbTyCd) {
		this.slbTyCd = slbTyCd;
	}

	/**
	 * @return the sessMntncTyCd
	 */
	public String getSessMntncTyCd() {
		return sessMntncTyCd;
	}

	/**
	 * @param sessMntncTyCd the sessMntncTyCd to set
	 */
	public void setSessMntncTyCd(String sessMntncTyCd) {
		this.sessMntncTyCd = sessMntncTyCd;
	}

	/**
	 * @return the sessMntncVl
	 */
	public String getSessMntncVl() {
		return sessMntncVl;
	}

	/**
	 * @param sessMntncVl the sessMntncVl to set
	 */
	public void setSessMntncVl(String sessMntncVl) {
		this.sessMntncVl = sessMntncVl;
	}

	/**
	 * @return the statConfrm
	 */
	public String getStatConfrm() {
		return statConfrm;
	}

	/**
	 * @param statConfrm the statConfrm to set
	 */
	public void setStatConfrm(String statConfrm) {
		this.statConfrm = statConfrm;
	}

	/**
	 * @return the statConfrmCycle
	 */
	public BigDecimal getStatConfrmCycle() {
		return statConfrmCycle;
	}

	/**
	 * @param statConfrmCycle the statConfrmCycle to set
	 */
	public void setStatConfrmCycle(BigDecimal statConfrmCycle) {
		this.statConfrmCycle = statConfrmCycle;
	}

	/**
	 * @return the statConfrmTOut
	 */
	public BigDecimal getStatConfrmTOut() {
		return statConfrmTOut;
	}

	/**
	 * @param statConfrmTOut the statConfrmTOut to set
	 */
	public void setStatConfrmTOut(BigDecimal statConfrmTOut) {
		this.statConfrmTOut = statConfrmTOut;
	}

	/**
	 * @return the maxTryCnt
	 */
	public BigDecimal getMaxTryCnt() {
		return maxTryCnt;
	}

	/**
	 * @param maxTryCnt the maxTryCnt to set
	 */
	public void setMaxTryCnt(BigDecimal maxTryCnt) {
		this.maxTryCnt = maxTryCnt;
	}

	/**
	 * @return the statConfrmHttpUrl
	 */
	public String getStatConfrmHttpUrl() {
		return statConfrmHttpUrl;
	}

	/**
	 * @param statConfrmHttpUrl the statConfrmHttpUrl to set
	 */
	public void setStatConfrmHttpUrl(String statConfrmHttpUrl) {
		this.statConfrmHttpUrl = statConfrmHttpUrl;
	}

	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return the vmSeq
	 */
	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	/**
	 * @param vmSeq the vmSeq to set
	 */
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}
}
