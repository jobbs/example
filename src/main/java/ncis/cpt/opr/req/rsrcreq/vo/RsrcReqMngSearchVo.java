package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;
import java.util.ArrayList;

import ncis.cmn.vo.CommonSearchVo;
public class RsrcReqMngSearchVo extends CommonSearchVo {

	private String rsrcReqNo;  /* 자원요청번호 */

	private String rsrcReqUsrNm;  /* 자원요청자명 */

	private String exeUserNm;  /* 실행자명 */

	private String rsrcReqDtStrt;  /* 자원요청 시작일자 */

	private String rsrcReqDtEnd;  /* 자원요청 종료일자 */

	private String rsrcReqPrcssStatCd;  /* 자원요청진행상태코드 */

	private String searchRegion;		/* 지역 구분 코드 */

	private String sbjct;  /* 제목 */

	private String ticktNo;  /* 티켓번호 */

	private String testYn;  /* 테스트여부 */

	private String linkYn;  /* 연계여부 */

	private String rsrcReqTyCd;  /* 자원요청유형코드  */

	private String schRsrcReqNo;  /* 조회 자원요청번호 */

	private String mainYn;

	private String reqInstitutionId;  /* 요청기관ID */

	private BigDecimal rsrcReqSeq; 	/* 자원요청 일련번호 */

	private String haCompYn; /* HA구성여부 */

	private String rsrcReqClCd;  /* 구분코드 */

    private ArrayList<String> updtCheck;  /* 표시여부 처리 List */


	public String getRsrcReqNo() {
		return rsrcReqNo;
	}
	public void setRsrcReqNo(String rsrcReqNo) {
		this.rsrcReqNo = rsrcReqNo;
	}
	public String getRsrcReqUsrNm() {
		return rsrcReqUsrNm;
	}
	public void setRsrcReqUsrNm(String rsrcReqUsrNm) {
		this.rsrcReqUsrNm = rsrcReqUsrNm;
	}
	public String getExeUserNm() {
		return exeUserNm;
	}
	public void setExeUserNm(String exeUserNm) {
		this.exeUserNm = exeUserNm;
	}
	public String getRsrcReqDtStrt() {
		return rsrcReqDtStrt;
	}
	/**
	 * @return the searchRegion
	 */
	public String getSearchRegion()
	{
		return searchRegion;
	}
	/**
	 * @param searchRegion the searchRegion to set
	 */
	public void setSearchRegion(String searchRegion)
	{
		this.searchRegion = searchRegion;
	}

	public void setRsrcReqDtStrt(String rsrcReqDtStrt) {
		this.rsrcReqDtStrt = rsrcReqDtStrt;
	}
	public String getRsrcReqDtEnd() {
		return rsrcReqDtEnd;
	}
	public void setRsrcReqDtEnd(String rsrcReqDtEnd) {
		this.rsrcReqDtEnd = rsrcReqDtEnd;
	}
	public String getRsrcReqPrcssStatCd() {
		return rsrcReqPrcssStatCd;
	}
	public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
		this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
	}
	public String getSbjct() {
		return sbjct;
	}
	public void setSbjct(String sbjct) {
		this.sbjct = sbjct;
	}
	public String getTicktNo() {
		return ticktNo;
	}
	public void setTicktNo(String ticktNo) {
		this.ticktNo = ticktNo;
	}
	public String getTestYn() {
		return testYn;
	}
	public void setTestYn(String testYn) {
		this.testYn = testYn;
	}
	public String getLinkYn() {
		return linkYn;
	}
	public void setLinkYn(String linkYn) {
		this.linkYn = linkYn;
	}
	public String getRsrcReqTyCd() {
		return rsrcReqTyCd;
	}
	public void setRsrcReqTyCd(String rsrcReqTyCd) {
		this.rsrcReqTyCd = rsrcReqTyCd;
	}
	public String getSchRsrcReqNo() {
		return schRsrcReqNo;
	}
	public void setSchRsrcReqNo(String schRsrcReqNo) {
		this.schRsrcReqNo = schRsrcReqNo;
	}
    public String getMainYn() {
        return mainYn;
    }
    public void setMainYn(String mainYn) {
        this.mainYn = mainYn;
    }
	public String getReqInstitutionId() {
		return reqInstitutionId;
	}
	public void setReqInstitutionId(String reqInstitutionId) {
		this.reqInstitutionId = reqInstitutionId;
	}
	public BigDecimal getRsrcReqSeq() {
		return rsrcReqSeq;
	}
	public void setRsrcReqSeq(BigDecimal rsrcReqSeq) {
		this.rsrcReqSeq = rsrcReqSeq;
	}
	public String getHaCompYn() {
		return haCompYn;
	}
	public void setHaCompYn(String haCompYn) {
		this.haCompYn = haCompYn;
	}
	public ArrayList<String> getUpdtCheck() {
		return updtCheck;
	}
	public void setUpdtCheck(ArrayList<String> updtCheck) {
		this.updtCheck = updtCheck;
	}
	public String getRsrcReqClCd() {
		return rsrcReqClCd;
	}
	public void setRsrcReqClCd(String rsrcReqClCd) {
		this.rsrcReqClCd = rsrcReqClCd;
	}

}
