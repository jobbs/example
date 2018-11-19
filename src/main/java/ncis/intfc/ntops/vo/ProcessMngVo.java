/**
 *
 */
package ncis.intfc.ntops.vo;

import java.math.BigDecimal;


/**
 * @author hsLee
 *
 */
public class ProcessMngVo {

	private int procssSeq;  /* 프로세스SEQ */
	private int procssJobInstSeq;  /* 프로세스업무인스턴스SEQ */
	private int procssInstSeq;  /* 프로세스인스턴스SEQ */
	private String uJobId;  /* 업무ID */
	private String intfcUrl;  /* 인터페이스URL */
	private String intfcParamtr;  /* 인터페이스파라메터 */
	private String uJobTyCd;  /* 업무유형 */
	private String varVl; /* 프로세스 변수 값 */
	private String varNm; /* 프로세스 변수 값 */
	private String lastJobYn; /* 마지막업무여부 */
	private String intfcFnctTyCd; /* 인터페이스기능코드 */
	private String seq; /* API GW와의 인터페이스 키 */
	private int upperProcssSeq; /* 상위프로세스SEQ */
	private int lowProcssSeq; /* 하위프로세스SEQ */
	private String rsrcReqPrcssStatCd;  /* 자원요청진행상태코드 */
	private String refJobId;  /* 참조업무ID  */
	private String rsrcReqNo;  /* 자원요청번호 */
	private BigDecimal rsrcReqSeq;  /* 자원요청일련번호 */
	private String statCd; /* 상태코드 */
	private int nextJobCnt; /* Next 단위업무 수 */
	private int upperProcssInstSeq;  /* 상위프로세스인스턴스SEQ */
	private int upperProcssJobInstSeq;  /* 상위프로세스업무인스턴스SEQ */
	private String regUserId;
	private String nicPrposCd;  /* NIC 용도구분코드 */
	private String dc;  /* 단위업무설명 */
	private String errCn; /* 오류내용 */
	private String errCd; /* 오류코드 */
	private String vmCrePrcssYn;  /* 가상서버 생성 진행여부  */
	private String vmCompId; /* 가상서버구성ID  */
	private Integer vmSeq;  /* 가상서버SEQ  */
	private Integer reProcssCnt; /* 재시도수  */

	public int getProcssSeq() {
		return procssSeq;
	}
	public void setProcssSeq(int procssSeq) {
		this.procssSeq = procssSeq;
	}
	public int getProcssJobInstSeq() {
		return procssJobInstSeq;
	}
	public void setProcssJobInstSeq(int procssJobInstSeq) {
		this.procssJobInstSeq = procssJobInstSeq;
	}
	public int getProcssInstSeq() {
		return procssInstSeq;
	}
	public void setProcssInstSeq(int procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}
	public String getuJobId() {
		return uJobId;
	}
	public void setuJobId(String uJobId) {
		this.uJobId = uJobId;
	}
	public String getIntfcUrl() {
		return intfcUrl;
	}
	public void setIntfcUrl(String intfcUrl) {
		this.intfcUrl = intfcUrl;
	}
	public String getIntfcParamtr() {
		return intfcParamtr;
	}
	public void setIntfcParamtr(String intfcParamtr) {
		this.intfcParamtr = intfcParamtr;
	}
	public String getuJobTyCd() {
		return uJobTyCd;
	}
	public void setuJobTyCd(String uJobTyCd) {
		this.uJobTyCd = uJobTyCd;
	}
	public String getVarVl() {
		return varVl;
	}
	public void setVarVl(String varVl) {
		this.varVl = varVl;
	}
	public String getVarNm() {
		return varNm;
	}
	public void setVarNm(String varNm) {
		this.varNm = varNm;
	}
	public String getLastJobYn() {
		return lastJobYn;
	}
	public void setLastJobYn(String lastJobYn) {
		this.lastJobYn = lastJobYn;
	}
	public String getIntfcFnctTyCd() {
		return intfcFnctTyCd;
	}
	public void setIntfcFnctTyCd(String intfcFnctTyCd) {
		this.intfcFnctTyCd = intfcFnctTyCd;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getUpperProcssSeq() {
		return upperProcssSeq;
	}
	public void setUpperProcssSeq(int upperProcssSeq) {
		this.upperProcssSeq = upperProcssSeq;
	}
	public int getLowProcssSeq() {
		return lowProcssSeq;
	}
	public void setLowProcssSeq(int lowProcssSeq) {
		this.lowProcssSeq = lowProcssSeq;
	}
	public String getRsrcReqPrcssStatCd() {
		return rsrcReqPrcssStatCd;
	}
	public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
		this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
	}
	public String getRefJobId() {
		return refJobId;
	}
	public void setRefJobId(String refJobId) {
		this.refJobId = refJobId;
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
	public String getStatCd() {
		return statCd;
	}
	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	public int getNextJobCnt() {
		return nextJobCnt;
	}
	public void setNextJobCnt(int nextJobCnt) {
		this.nextJobCnt = nextJobCnt;
	}
	public int getUpperProcssInstSeq() {
		return upperProcssInstSeq;
	}
	public void setUpperProcssInstSeq(int upperProcssInstSeq) {
		this.upperProcssInstSeq = upperProcssInstSeq;
	}
	public int getUpperProcssJobInstSeq() {
		return upperProcssJobInstSeq;
	}
	public void setUpperProcssJobInstSeq(int upperProcssJobInstSeq) {
		this.upperProcssJobInstSeq = upperProcssJobInstSeq;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public String getNicPrposCd() {
		return nicPrposCd;
	}
	public void setNicPrposCd(String nicPrposCd) {
		this.nicPrposCd = nicPrposCd;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getErrCn() {
		return errCn;
	}
	public void setErrCn(String errCn) {
		this.errCn = errCn;
	}
	public String getVmCrePrcssYn() {
		return vmCrePrcssYn;
	}
	public void setVmCrePrcssYn(String vmCrePrcssYn) {
		this.vmCrePrcssYn = vmCrePrcssYn;
	}
	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	public Integer getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Integer vmSeq) {
		this.vmSeq = vmSeq;
	}
	public Integer getReProcssCnt() {
		return reProcssCnt;
	}
	public void setReProcssCnt(Integer reProcssCnt) {
		this.reProcssCnt = reProcssCnt;
	}
	public String getErrCd() {
		return errCd;
	}
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
}
