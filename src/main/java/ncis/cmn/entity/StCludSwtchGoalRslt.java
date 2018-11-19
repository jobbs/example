package ncis.cmn.entity;


/**
 * API게이트웨이정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StCludSwtchGoalRslt {

    private String stdrYr;
    private String regionId;
    private Long goalInstitutionQty;
    private Long goalJobQty;
    private Long rsltInstitutionQty;
    private Long rsltJobQty;

	public String getStdrYr() {
		return stdrYr;
	}
	public void setStdrYr(String stdrYr) {
		this.stdrYr = stdrYr;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public Long getGoalInstitutionQty() {
		return goalInstitutionQty;
	}
	public void setGoalInstitutionQty(Long goalInstitutionQty) {
		this.goalInstitutionQty = goalInstitutionQty;
	}
	public Long getGoalJobQty() {
		return goalJobQty;
	}
	public void setGoalJobQty(Long goalJobQty) {
		this.goalJobQty = goalJobQty;
	}
	public Long getRsltJobQty() {
		return rsltJobQty;
	}
	public void setRsltJobQty(Long rsltJobQty) {
		this.rsltJobQty = rsltJobQty;
	}
	public Long getRsltInstitutionQty() {
		return rsltInstitutionQty;
	}
	public void setRsltInstitutionQty(Long rsltInstitutionQty) {
		this.rsltInstitutionQty = rsltInstitutionQty;
	}
}
