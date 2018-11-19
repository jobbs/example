/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwkSearchVo.java
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

public class RsrcReqNetwkSearchVo extends CommonSearchVo {

	private String rsrcReqNo;			/* 자원요청번호 */
	private BigDecimal rsrcReqSeq;		/* 자원요청일련벊호 */
	private String setRoleCd;		/* 롤 유형코드  */

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

	public String getSetRoleCd() {
		return setRoleCd;
	}

	public void setSetRoleCd(String setRoleCd) {
		this.setRoleCd = setRoleCd;
	}
}
