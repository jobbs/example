package ncis.dsb.cmn.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class MainIncSearchVo extends CommonSearchVo {

	private String view;
	private String id;
	private String gubun;
	private String institutionId;
	private String jobId;
	private String vmId;
	private Long vmSeq;

	@SuppressWarnings("unused")
	private boolean allJobAuth;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;

	private String vrlzSwTyCd;
	private String vmCompId;
	private String strtDt;
	private String endDt;
	private String pmCompId;
	private String vmNm;
	private String institutionNm;
	private String jobNm;

	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getVmId() {
		return vmId;
	}
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
	public Long getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}

	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}

	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}

	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getStrtDt() {
		return strtDt;
	}
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}

	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}


	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}

	public String getPmCompId() {
		return pmCompId;
	}
	public void setPmCompId(String pmCompId) {
		this.pmCompId = pmCompId;
	}

	public String getVmNm() {
		return vmNm;
	}
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}

	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}

	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}

}
