package ncis.cmn.entity;


/**
 * API게이트웨이정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StYrCludNwUseInstitution {

    private String stdrYr;
    private String institutionId;
    private String institutionNm;
    private int jobQty;

	public int getJobQty() {
		return jobQty;
	}
	public void setJobQty(int jobQty) {
		this.jobQty = jobQty;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getStdrYr() {
		return stdrYr;
	}
	public void setStdrYr(String stdrYr) {
		this.stdrYr = stdrYr;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
}
