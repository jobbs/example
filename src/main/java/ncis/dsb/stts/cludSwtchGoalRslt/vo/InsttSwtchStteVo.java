/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasVstrQtyVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.cludSwtchGoalRslt.vo;




public class InsttSwtchStteVo{
	private String institutionId;
	private String institutionNm;
	private long swtchJobQty;
	private String primeSwtchExam;
	private int totCnt;
	private long rnk;

	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public long getSwtchJobQty() {
		return swtchJobQty;
	}
	public void setSwtchJobQty(long swtchJobQty) {
		this.swtchJobQty = swtchJobQty;
	}
	public String getPrimeSwtchExam() {
		return primeSwtchExam;
	}
	public void setPrimeSwtchExam(String primeSwtchExam) {
		this.primeSwtchExam = primeSwtchExam;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public long getRnk() {
		return rnk;
	}
	public void setRnk(long rnk) {
		this.rnk = rnk;
	}


}
