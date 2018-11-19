/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원 요청상세_물지자원</pre>
 *
 * @filename RsrcReqPhyRsrcInfoVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

public class RsrcReqPhyRsrcSearchVo extends  CommonSearchVo {

	private String rsrcReqNo;  /* 자원요청번호 */
	private BigDecimal rsrcReqSeq;  /* 자원요청일련번호 */
	private BigDecimal seq;  /* 일련번호 */

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
	public BigDecimal getSeq() {
		return seq;
	}
	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}
}
