/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UnitJobProcssVo.java
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
import java.util.List;

import ncis.cmn.entity.RrUnitJob;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 실행내역 작업 진행상태 Vo
 * @author 김봉민
 *
 */
public class UnitJobProcssVo extends RrUnitJob{

	private String uJobTyNm;  /* 단위업무유형명 */
	private String strtDttm;	/*시작 일시*/
	private String endDttm;		/* 종료일시*/
	private String statCd;		/* 상태코드*/
	private String statNm;		/* 상태명*/
	private String dc;			/* 비교*/
	private BigDecimal procssInstSeq; 		/* 프로세스 인스턴트 seq */
	private BigDecimal procssJobInstSeq;	/* 프로세스 업무 인스턴스 seq */

	private String strtUJobId;		/* 시작 잡업 ID  */
	private String endUJobId;		/* 종료작업 ID */
	private String endUJobCndVarId;	/* 종료 작업 변수명 */
	private String endUJobCndVarVl;	/*  종료작업 변수 값 */

	private int reProcssCnt;		/* 재 처리 쵯수 */
	private String errCn;			/* 에러메시지 */
	private BigDecimal upperProcssInstSeq;  /*상위 프로세서 인스턴스 SEQ */

	private String procssNm;	/* 프로세스 명 */
	private String procssDc;	/* 프로세스 설명 */

	private List<UnitJobProcssListVo> unitJobProcssListVoList;

	private String rsrcReqNo;			/* 자원요청번호  */
	private BigDecimal rsrcReqSeq;		/* 자원요청일련번호 */
	private String rsrcReqTyCd;			/* 자원요청유형코드 */

	private String rmk;					/* 강제완료 사유 */
	private String forceComptYn;		/* 강제완료 여부 */

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
	public String getStatCd() {
		return statCd;
	}
	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	public String getStatNm() {
		return statNm;
	}
	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getuJobTyNm() {
		return uJobTyNm;
	}
	public void setuJobTyNm(String uJobTyNm) {
		this.uJobTyNm = uJobTyNm;
	}
	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
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
	public String getEndUJobCndVarId() {
		return endUJobCndVarId;
	}
	public void setEndUJobCndVarId(String endUJobCndVarId) {
		this.endUJobCndVarId = endUJobCndVarId;
	}
	public String getEndUJobCndVarVl() {
		return endUJobCndVarVl;
	}
	public void setEndUJobCndVarVl(String endUJobCndVarVl) {
		this.endUJobCndVarVl = endUJobCndVarVl;
	}
	public List<UnitJobProcssListVo> getUnitJobProcssListVoList() {
		return unitJobProcssListVoList;
	}
	public void setUnitJobProcssListVoList(List<UnitJobProcssListVo> unitJobProcssListVoList) {
		this.unitJobProcssListVoList = unitJobProcssListVoList;
	}
	public int getReProcssCnt() {
		return reProcssCnt;
	}
	public void setReProcssCnt(int reProcssCnt) {
		this.reProcssCnt = reProcssCnt;
	}
	public String getErrCn() {
		return errCn;
	}
	public void setErrCn(String errCn) {
		this.errCn = errCn;
	}
	public BigDecimal getProcssJobInstSeq() {
		return procssJobInstSeq;
	}
	public void setProcssJobInstSeq(BigDecimal procssJobInstSeq) {
		this.procssJobInstSeq = procssJobInstSeq;
	}
	public BigDecimal getUpperProcssInstSeq() {
		return upperProcssInstSeq;
	}
	public void setUpperProcssInstSeq(BigDecimal upperProcssInstSeq) {
		this.upperProcssInstSeq = upperProcssInstSeq;
	}
	public String getProcssNm() {
		return procssNm;
	}
	public void setProcssNm(String procssNm) {
		this.procssNm = procssNm;
	}
	public String getProcssDc() {
		return procssDc;
	}
	public void setProcssDc(String procssDc) {
		this.procssDc = procssDc;
	}
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
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getRsrcReqTyCd() {
		return rsrcReqTyCd;
	}
	public void setRsrcReqTyCd(String rsrcReqTyCd) {
		this.rsrcReqTyCd = rsrcReqTyCd;
	}
	public String getForceComptYn() {
		return forceComptYn;
	}
	public void setForceComptYn(String forceComptYn) {
		this.forceComptYn = forceComptYn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
