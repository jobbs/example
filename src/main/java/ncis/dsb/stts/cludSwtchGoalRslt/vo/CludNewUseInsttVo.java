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




public class CludNewUseInsttVo{
	private String stdrYr;
	private int jobQty;
	private int institutionQty;
	private String institutionNm;
	private String institutionId;
	private int sumJobQty;
	private int sumInstitutionQty;

	public String getStdrYr() {
		return stdrYr;
	}
	public void setStdrYr(String stdrYr) {
		this.stdrYr = stdrYr;
	}
	public int getJobQty() {
		return jobQty;
	}
	public void setJobQty(int jobQty) {
		this.jobQty = jobQty;
	}
	public int getInstitutionQty() {
		return institutionQty;
	}
	public void setInstitutionQty(int institutionQty) {
		this.institutionQty = institutionQty;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public int getSumJobQty() {
		return sumJobQty;
	}
	public void setSumJobQty(int sumJobQty) {
		this.sumJobQty = sumJobQty;
	}
	public int getSumInstitutionQty() {
		return sumInstitutionQty;
	}
	public void setSumInstitutionQty(int sumInstitutionQty) {
		this.sumInstitutionQty = sumInstitutionQty;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}


}
