/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UnitJobProcssSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;



/**
 * 실행내역 작업 진행상태 Vo
 * @author 김봉민
 *
 */
public class UnitJobProcssSearchVo extends CommonSearchVo{

	private String rsrcReqNo;			/* 자원요청번호  */
	private BigDecimal rsrcReqSeq;		/* 자원요청일련번호 */
	private BigDecimal procssInstSeq;	/* 프로세스 인스턴트  SEQ */
	private String procssJobInstSeq;	/* 프로세스 업무 인스턴트 SEQ*/
	private BigDecimal procssSeq;		/* 프로세스  SEQ*/
	private String uJobId;				/* 단위 업무 Id */

	private String strtUJobId;		/* 시작 잡업 ID  */
	private String endUJobId;		/* 종료작업 ID */

	private BigDecimal uJobRelateSeq; /* 단위 업무 관계SEQ */

	private BigDecimal upperProcssInstSeq; /*상위 프로세서 인스턴스 SEQ */
	private String rmk;

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
	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}
	public String getProcssJobInstSeq() {
		return procssJobInstSeq;
	}
	public void setProcssJobInstSeq(String procssJobInstSeq) {
		this.procssJobInstSeq = procssJobInstSeq;
	}
	public BigDecimal getProcssSeq() {
		return procssSeq;
	}
	public void setProcssSeq(BigDecimal procssSeq) {
		this.procssSeq = procssSeq;
	}
	public String getuJobId() {
		return uJobId;
	}
	public void setuJobId(String uJobId) {
		this.uJobId = uJobId;
	}
	public String getStrtUJobId() {
		return strtUJobId;
	}
	public void setStrtUJobId(String strtUJobId) {
		this.strtUJobId = strtUJobId;
	}
	public String getEndUJobId() {
		return endUJobId;
	}
	public void setEndUJobId(String endUJobId) {
		this.endUJobId = endUJobId;
	}
	public BigDecimal getuJobRelateSeq() {
		return uJobRelateSeq;
	}
	public void setuJobRelateSeq(BigDecimal uJobRelateSeq) {
		this.uJobRelateSeq = uJobRelateSeq;
	}
	public BigDecimal getUpperProcssInstSeq() {
		return upperProcssInstSeq;
	}
	public void setUpperProcssInstSeq(BigDecimal upperProcssInstSeq) {
		this.upperProcssInstSeq = upperProcssInstSeq;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
}
