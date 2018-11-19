/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.util.List;

import ncis.cmn.entity.RcVm;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.rsrc.com.vo.VmJobVo;

/**
 * @author 이화영
 *
 */
public class VmPatchVo extends RcVm {

	private String statCdNm;
	private String institutionNm;
	private String regionId;
    private String regionNm;
    private String zoneId;
    private String zoneNm;
    private String netId;
    private String netNm;
    private String vrlzSwTyCd;
    private String vrlzSwTyCdNm;
    private String rsrcPoolId;
    private String rsrcPoolNm;
    private String osTyCdNm;
    private List<VmJobVo> vmPatchJobVoList;
    private String pmCompId;
    private String jobsNm;
    private String packgNm;
    private String passWd;
    private String statGrpCdNm;
    private String statGrpCd;
    private String regDt;
    private String netClCd;

	public String getStatCdNm() {
		return statCdNm;
	}
	public void setStatCdNm(String statCdNm) {
		this.statCdNm = statCdNm;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneNm() {
		return zoneNm;
	}
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getNetNm() {
		return netNm;
	}
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}
	public String getVrlzSwTyCdNm() {
		return vrlzSwTyCdNm;
	}
	public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
		this.vrlzSwTyCdNm = vrlzSwTyCdNm;
	}
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public String getOsTyCdNm() {
		return osTyCdNm;
	}
	public void setOsTyCdNm(String osTyCdNm) {
		this.osTyCdNm = osTyCdNm;
	}
	public List<VmJobVo> getVmPatchJobVoList() {
		return vmPatchJobVoList;
	}
	public void setVmPatchJobVoList(List<VmJobVo> vmPatchJobVoList) {
		this.vmPatchJobVoList = vmPatchJobVoList;
	}
	public String getPmCompId() {
		return pmCompId;
	}
	public void setPmCompId(String pmCompId) {
		this.pmCompId = pmCompId;
	}
	public String getPackgNm() {
		return packgNm;
	}
	public void setPackgNm(String packgNm) {
		this.packgNm = packgNm;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getStatGrpCdNm() {
		return statGrpCdNm;
	}
	public void setStatGrpCdNm(String statGrpCdNm) {
		this.statGrpCdNm = statGrpCdNm;
	}
	public String getStatGrpCd() {
		return statGrpCd;
	}
	public void setStatGrpCd(String statGrpCd) {
		this.statGrpCd = statGrpCd;
	}
	public String getJobsNm() {
		return jobsNm;
	}
	public void setJobsNm(String jobsNm) {
		this.jobsNm = jobsNm;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	public boolean isSysadm() {
        return "SYSADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }
	public boolean isOpradm() {
        return "OPRADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }

	public String getUserId() {
        return RequestUtils.getUserId();
    }





}
