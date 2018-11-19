package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청상세_네트워크 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrRsrcReqDtlNetwk {

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
	 * 자원요청내용
	 */
	private String rsrcReqCn;

	/**
	 * 자원요청진행상태코드
	 */
	@NotEmpty(message = "자원요청진행상태코드는(은) 필수입력 항목입니다.")
	private String rsrcReqPrcssStatCd;

	/**
	 * 프로세스인스턴스ID
	 */
	private BigDecimal procssInstSeq;

	/**
	 * 실행일시
	 */
	private String exeDttm;

	/**
	 * 존ID
	 */
	@NotEmpty(message = "존ID는(은) 필수입력 항목입니다.")
	private String zoneId;

	/**
	 * 망ID
	 */
	@NotEmpty(message = "망ID는(은) 필수입력 항목입니다.")
	private String netId;

	/**
	 * VIP주소
	 */
	private String vipAddr;

	/**
	 * 프로토콜
	 */
	private String prtcl;

	/**
	 * 포트
	 */
	private String port;

	/**
	 * SLB유형코드
	 */
	private String slbTyCd;

	/**
	 * 세션유지유형코드
	 */
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
	 * 자원요청유형코드
	 */
	private String rsrcReqTyCd;

	/**
	 * 매니저ID
	 */
	private String rsrcPoolId;

	/**
	 * UUID
	 */
	private String uuid;

	/**
	 * 완료일시
	 */
	private String comptDttm;

	/**
	 *  등록일시
	 */
	private String regDttm;

	/**
	 *  반려유형코드
	 */
	private String rjctTyCd;

	/**
	 *  반려일시
	 */
	private String rjctDttm;

	 /**
	  *  반려사유
	  */
	private String rjctReasn;

	/**
	 * 망구분 코드
	 */
	private String netClCd;
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
	 * @return the rsrcReqCn
	 */
	public String getRsrcReqCn() {
		return rsrcReqCn;
	}

	/**
	 * @param rsrcReqCn the rsrcReqCn to set
	 */
	public void setRsrcReqCn(String rsrcReqCn) {
		this.rsrcReqCn = rsrcReqCn;
	}

	/**
	 * @return the rsrcReqPrcssStatCd
	 */
	public String getRsrcReqPrcssStatCd() {
		return rsrcReqPrcssStatCd;
	}

	/**
	 * @param rsrcReqPrcssStatCd the rsrcReqPrcssStatCd to set
	 */
	public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
		this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
	}

	/**
	 * @return the procssInstSeq
	 */
	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}

	/**
	 * @param procssInstSeq the procssInstSeq to set
	 */
	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}

	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
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
	 * @return the rsrcReqTyCd
	 */
	public String getRsrcReqTyCd() {
		return rsrcReqTyCd;
	}

	/**
	 * @param rsrcReqTyCd the rsrcReqTyCd to set
	 */
	public void setRsrcReqTyCd(String rsrcReqTyCd) {
		this.rsrcReqTyCd = rsrcReqTyCd;
	}

	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the comptDttm
	 */
	public String getComptDttm() {
		return comptDttm;
	}

	/**
	 * @param comptDttm the comptDttm to set
	 */
	public void setComptDttm(String comptDttm) {
		this.comptDttm = comptDttm;
	}

	public String getExeDttm() {
		return exeDttm;
	}

	public void setExeDttm(String exeDttm) {
		this.exeDttm = exeDttm;
	}

	public String getRegDttm() {
		return regDttm;
	}

	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}

	public String getRjctDttm() {
		return rjctDttm;
	}

	public void setRjctDttm(String rjctDttm) {
		this.rjctDttm = rjctDttm;
	}

	/**
	 * @return the rjctTyCd
	 */
	public String getRjctTyCd() {
		return rjctTyCd;
	}

	/**
	 * @param rjctTyCd the rjctTyCd to set
	 */
	public void setRjctTyCd(String rjctTyCd) {
		this.rjctTyCd = rjctTyCd;
	}


	/**
	 * @return the rjctReasn
	 */
	public String getRjctReasn() {
		return rjctReasn;
	}

	/**
	 * @param rjctReasn the rjctReasn to set
	 */
	public void setRjctReasn(String rjctReasn) {
		this.rjctReasn = rjctReasn;
	}

	public String getNetClCd() {
		return netClCd;
	}

	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}


}
