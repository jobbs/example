package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class ServcAreaSearchVo extends CommonSearchVo {

    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private String institutionNm; /* 부처명 */
    private String jobNm; /* 업무명 */
    private String servcAreaNm; /* 서비스영역명 */
    private Integer servcAreaSeq; /* 서비스영역Seq */
    private String servcAreaCompId; /* 서비스영역구성ID */
    private String servcAreaClCd; /* 서비스영역구분코드 */
    private String ctlTrgtYn; /* 제어여부 */


    private boolean all = false;

	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getServcAreaNm() {
		return servcAreaNm;
	}
	public void setServcAreaNm(String servcAreaNm) {
		this.servcAreaNm = servcAreaNm;
	}
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	public String getServcAreaCompId() {
		return servcAreaCompId;
	}
	public void setServcAreaCompId(String servcAreaCompId) {
		this.servcAreaCompId = servcAreaCompId;
	}
	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	public String getServcAreaClCd() {
		return servcAreaClCd;
	}
	public void setServcAreaClCd(String servcAreaClCd) {
		this.servcAreaClCd = servcAreaClCd;
	}
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}
}
