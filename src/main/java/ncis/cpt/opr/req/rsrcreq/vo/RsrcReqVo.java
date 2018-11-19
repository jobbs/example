/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqDtlvo.java
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

import ncis.cmn.entity.RrRsrcReq;

/**
 *
 * @author 김봉민
 *
 */
public class RsrcReqVo extends RrRsrcReq{
	private String rsrcReqTyNm; 		/* 처리 상태 */
	private String exeUserNm;			/*실행자명*/
	private String rsrcReqPrcssStatNm;  /* 자원요청진행상태명 */
	private String reqInstitutionNm;  	/* 요청기관명 */

	private String regionNm;  			/* 센터 명 */
	private String rsrcReqUserNm;  		/* 자원요청자명 */
	private String rsrcReqMobile; 		/* 핸드폰 */
	private String rsrcReqEmail;		/* 이메일 */


	private String rjctTyCd;			/* 반려 유형 */
	private String rjctReasn;			/* 반려사유 */

	private String schRsrcReqNo;		/* 페이지 전황용 */

	private String exeDttm;				/* 실행 시간 */
	private BigDecimal procssInstSeq; 	/* 프로세스 인스턴스 SEQ */
	private BigDecimal rsrcReqSeq; 		/* 자원요청 일련번호 */

	private String zoneId;		/* 존*/
	private String netId;		/* 망 */
	private String netClCd;		/* 망구분 */
	private String uuid;		/* uuid */
	private String rsrcPoolId;	/* 자원풀 */

	public String getRsrcReqUserNm() {
		return rsrcReqUserNm;
	}

	public void setRsrcReqUserNm(String rsrcReqUserNm) {
		this.rsrcReqUserNm = rsrcReqUserNm;
	}

	public String getRsrcReqPrcssStatNm() {
		return rsrcReqPrcssStatNm;
	}

	public void setRsrcReqPrcssStatNm(String rsrcReqPrcssStatNm) {
		this.rsrcReqPrcssStatNm = rsrcReqPrcssStatNm;
	}

	public String getReqInstitutionNm() {
		return reqInstitutionNm;
	}

	public void setReqInstitutionNm(String reqInstitutionNm) {
		this.reqInstitutionNm = reqInstitutionNm;
	}

	public String getRegionNm() {
		return regionNm;
	}

	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}

	public String getRsrcReqMobile() {
		return rsrcReqMobile;
	}

	public void setRsrcReqMobile(String rsrcReqMobile) {
		this.rsrcReqMobile = rsrcReqMobile;
	}

	public String getRsrcReqEmail() {
		return rsrcReqEmail;
	}

	public void setRsrcReqEmail(String rsrcReqEmail) {
		this.rsrcReqEmail = rsrcReqEmail;
	}

	public String getRsrcReqTyNm() {
		return rsrcReqTyNm;
	}

	public void setRsrcReqTyNm(String rsrcReqTyNm) {
		this.rsrcReqTyNm = rsrcReqTyNm;
	}

	public String getExeUserNm() {
		return exeUserNm;
	}

	public void setExeUserNm(String exeUserNm) {
		this.exeUserNm = exeUserNm;
	}

	public String getRjctTyCd() {
		return rjctTyCd;
	}

	public void setRjctTyCd(String rjctTyCd) {
		this.rjctTyCd = rjctTyCd;
	}

	public String getRjctReasn() {
		return rjctReasn;
	}

	public void setRjctReasn(String rjctReasn) {
		this.rjctReasn = rjctReasn;
	}

	public String getSchRsrcReqNo() {
		return schRsrcReqNo;
	}

	public void setSchRsrcReqNo(String schRsrcReqNo) {
		this.schRsrcReqNo = schRsrcReqNo;
	}

	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}

	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}

	public String getExeDttm() {
		return exeDttm;
	}

	public void setExeDttm(String exeDttm) {
		this.exeDttm = exeDttm;
	}

	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}

	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getNetClCd() {
		return netClCd;
	}

	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
}
