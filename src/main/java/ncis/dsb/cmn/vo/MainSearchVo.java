package ncis.dsb.cmn.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class MainSearchVo extends CommonSearchVo {

	private String view;
	private String id;
	private String podId;
	private String podNm;
	private String servcNm;
	private String gubun;
	private String vmPod;
	private String regionId;
	private String netId;
	private String zoneId;
	private String rsrcPoolId;
	private Long clstrSeq;
	private String atmsclNodeId;
	private Long pmSeq;
	private Long vmSeq;
	private String institutionId;
	private String jobId;
	private String vmId;
	private String trgtSrvrClCd;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;

	@SuppressWarnings("unused")
	private boolean allJobAuth;

	private String vrlzSwTyCd;

	private String vmCompId;
	private String strtDt;
	private String endDt;
	private String strtDtPod;
	private String endDtPod;
	private String pmCompId;
	private String vmNm;
	private String institutionNm;
	private String institutionNmPod;
	private String jobNm;
	private String colctDt;
	private String colctHour;
	private String colctMi;

	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}

	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}
	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}
	/**
	 * @param view the view to set
	 */
	public void setView(String view) {
		this.view = view;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the podId
	 */
	public String getPodId() {
		return podId;
	}
	/**
	 * @param podId the podId to set
	 */
	public void setPodId(String podId) {
		this.podId = podId;
	}
	/**
	 * @return the podNm
	 */
	public String getPodNm() {
		return podNm;
	}
	/**
	 * @param podNm the podNm to set
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	/**
	 * @return the servcNm
	 */
	public String getServcNm() {
		return servcNm;
	}
	/**
	 * @param servcNm the servcNm to set
	 */
	public void setServcNm(String servcNm) {
		this.servcNm = servcNm;
	}
	/**
	 * @return the gubun
	 */
	public String getGubun() {
		return gubun;
	}
	/**
	 * @param gubun the gubun to set
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	/**
	 * @return the gubun
	 */
	public String getVmPod() {
		return vmPod;
	}
	/**
	 * @param gubun the gubun to set
	 */
	public void setVmPod(String vmPod) {
		this.vmPod = vmPod;
	}
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
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
	 * @return the clstrSeq
	 */
	public Long getClstrSeq() {
		return clstrSeq;
	}
	/**
	 * @param clstrSeq the clstrSeq to set
	 */
	public void setClstrSeq(Long clstrSeq) {
		this.clstrSeq = clstrSeq;
	}

	/**
	 * @return the atmsclNodeId
	 */
	public String getAtmsclNodeId() {
		return atmsclNodeId;
	}
	/**
	 * @param atmsclNodeId the atmsclNodeId to set
	 */
	public void setAtmsclNodeId(String atmsclNodeId) {
		this.atmsclNodeId = atmsclNodeId;
	}
	/**
	 * @return the pmSeq
	 */
	public Long getPmSeq() {
		return pmSeq;
	}
	/**
	 * @param pmSeq the pmSeq to set
	 */
	public void setPmSeq(Long pmSeq) {
		this.pmSeq = pmSeq;
	}
	/**
	 * @return the vmSeq
	 */
	public Long getVmSeq() {
		return vmSeq;
	}
	/**
	 * @param vmSeq the vmSeq to set
	 */
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}
	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the vmId
	 */
	public String getVmId() {
		return vmId;
	}
	/**
	 * @param vmId the vmId to set
	 */
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
	/**
	 * @return the trgtSrvrClCd
	 */
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	/**
	 * @param trgtSrvrClCd the trgtSrvrClCd to set
	 */
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}

	/**
	 * @return the vrlzSwTyCd
	 */
	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	/**
	 * @param vrlzSwTyCd the vrlzSwTyCd to set
	 */
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}
	/**
	 * @return the vmCompId
	 */
	public String getVmCompId() {
		return vmCompId;
	}
	/**
	 * @param vmCompId the vmCompId to set
	 */
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	/**
	 * @return the strtDt
	 */
	public String getStrtDt() {
		return strtDt;
	}
	/**
	 * @param strtDt the strtDt to set
	 */
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	/**
	 * @return the strtDtPod
	 */
	public String getStrtDtPod() {
		return strtDtPod;
	}
	/**
	 * @param strtDtPod the strtDtPod to set
	 */
	public void setStrtDtPod(String strtDtPod) {
		this.strtDtPod = strtDtPod;
	}
	/**
	 * @return the endDtPod
	 */
	public String getEndDtPod() {
		return endDtPod;
	}
	/**
	 * @param endDtPod the endDtPod to set
	 */
	public void setEndDtPod(String endDtPod) {
		this.endDtPod = endDtPod;
	}
	/**
	 * @return the pmCompId
	 */
	public String getPmCompId() {
		return pmCompId;
	}
	/**
	 * @param pmCompId the pmCompId to set
	 */
	public void setPmCompId(String pmCompId) {
		this.pmCompId = pmCompId;
	}
	/**
	 * @return the vmNm
	 */
	public String getVmNm() {
		return vmNm;
	}
	/**
	 * @param vmNm the vmNm to set
	 */
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
	/**
	 * @return the institutionNm
	 */
	public String getInstitutionNm() {
		return institutionNm;
	}
	/**
	 * @param institutionNm the institutionNm to set
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	/**
	 * @return the institutionNmPod
	 */
	public String getInstitutionNmPod() {
		return institutionNmPod;
	}
	/**
	 * @param institutionNmPod the institutionNmPod to set
	 */
	public void setInstitutionNmPod(String institutionNmPod) {
		this.institutionNmPod = institutionNmPod;
	}
	/**
	 * @return the jobNm
	 */
	public String getJobNm() {
		return jobNm;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	/**
	 * @return the colctDt
	 */
	public String getColctDt() {
		return colctDt;
	}
	/**
	 * @param colctDt the colctDt to set
	 */
	public void setColctDt(String colctDt) {
		this.colctDt = colctDt;
	}
	/**
	 * @return the colctHour
	 */
	public String getColctHour() {
		return colctHour;
	}
	/**
	 * @param colctHour the colctHour to set
	 */
	public void setColctHour(String colctHour) {
		this.colctHour = colctHour;
	}
	/**
	 * @return the colctMi
	 */
	public String getColctMi() {
		return colctMi;
	}
	/**
	 * @param colctMi the colctMi to set
	 */
	public void setColctMi(String colctMi) {
		this.colctMi = colctMi;
	}



}
