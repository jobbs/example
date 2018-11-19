/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwkSlbConfIpReqSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

import org.hibernate.validator.constraints.NotEmpty;

public class RsrcReqNetwkSlbConfIpReqSearchVo extends CommonSearchVo  {

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

	public String getRsrcReqNo() {
		return rsrcReqNo;
	}

	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}

	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}

	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}


}
