package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SLB설정IP요청목록 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrSlbConfIpReqList {

    /**
     * 자원요청번호
     */
    @NotEmpty(message = "자원요청번호는(은) 필수입력 항목입니다.")
    private String rsrcReqNo;

    /**
     * 자원요청일련번호
     */
    @NotEmpty(message = "자원요청일련번호는(은) 필수입력 항목입니다.")
    private BigDecimal rsrcReqSeq;

    /**
     * IP주소
     */
    @NotEmpty(message = "IP주소는(은) 필수입력 항목입니다.")
    private String ipAddr;

    /**
     * VIP주소
     */
    private String vipAddr;

    /**
     * 포트
     */
    private String port;

    /**
     * 가중치(로드밸런싱)
     */
    private BigDecimal wvl;

    /**
     * 설명
     */
    private String dc;

    /**
     * 가상서버시퀀스
     */
    @NotEmpty(message = "가상서버시퀀스는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

	/**
	 * @return the rsrcReqNo
	 */
	public String getRsrcReqNo() {
		return rsrcReqNo;
	}

	/**
	 * @param rsrcReqNo the rsrcReqNo to set
	 */
	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}

	/**
	 * @return the rsrcReqSeq
	 */
	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}

	/**
	 * @param rsrcReqSeq the rsrcReqSeq to set
	 */
	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}

	/**
	 * @return the ipAddr
	 */
	public String getIpAddr() {
		return ipAddr;
	}

	/**
	 * @param ipAddr the ipAddr to set
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

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
	 * @return the wvl
	 */
	public BigDecimal getWvl() {
		return wvl;
	}

	/**
	 * @param wvl the wvl to set
	 */
	public void setWvl(BigDecimal wvl) {
		this.wvl = wvl;
	}

	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
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
