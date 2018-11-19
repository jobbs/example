package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SLB_IP Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnSlbIp {

    /**
     * IP주소
     */
    @NotEmpty(message = "IP주소는(은) 필수입력 항목입니다.")
    private String ipAddr;

    /**
     * 포트
     */
    @NotEmpty(message = "포트는(은) 필수입력 항목입니다.")
    private String port;

    /**
     * VIP주소
     */
    private String vipAddr;

    /**
     * 가중치(로드밸런싱)
     */
    private BigDecimal wvl;

    /**
     * 설명
     */
    private String dc;

    /**
     * 가상서버SEQ
     */
    private BigDecimal vmSeq;

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
