/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProcssSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 김봉민
 *
 */
public class ProcssInstSearchVo extends CommonSearchVo {

	private BigDecimal procssInstSeq; /* 프로세스인스턴스ID */
	private BigDecimal procssSeq; /* 프로세스ID */
	private String strtDttm; /* 시작일시 */
	private String endDttm; /* 종료일시 */
	private String upperProcssInstSeq; /* 상위프로세스인스턴스ID */
	private String statCd; /* 상태코드 */
	private String rsrcReqNo; /* 자원요청번호 */
	private String upperProcssJobInstSeq; /* 상위프로세스업무인스턴스ID */

	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}
	public BigDecimal getProcssSeq() {
		return procssSeq;
	}
	public void setProcssSeq(BigDecimal procssSeq) {
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
	public String getUpperProcssInstSeq() {
		return upperProcssInstSeq;
	}
	public void setUpperProcssInstSeq(String upperProcssInstSeq) {
		this.upperProcssInstSeq = upperProcssInstSeq;
	}
	public String getStatCd() {
		return statCd;
	}
	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	public String getRsrcReqNo() {
		return rsrcReqNo;
	}
	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}
	public String getUpperProcssJobInstSeq() {
		return upperProcssJobInstSeq;
	}
	public void setUpperProcssJobInstSeq(String upperProcssJobInstSeq) {
		this.upperProcssJobInstSeq = upperProcssJobInstSeq;
	}
}
