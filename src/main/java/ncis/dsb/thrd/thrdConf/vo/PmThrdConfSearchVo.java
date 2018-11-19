/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfSearchVo.java
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
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class PmThrdConfSearchVo extends CommonSearchVo {
	private String id;
	private String gubun;
	private String regionId;
	private String netId;
	private String zoneId;
	private String rsrcPoolId;
	private Long clstrSeq;
	private Long pmSeq;
	private Long vmSeq;
	private Long servcSeq;
	private String institutionId;
	private String jobId;
	private String trgtSrvrClCd;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;

	@SuppressWarnings("unused")
	private boolean allJobAuth;


	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public Long getClstrSeq() {
		return clstrSeq;
	}
	public void setClstrSeq(Long clstrSeq) {
		this.clstrSeq = clstrSeq;
	}
	public Long getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(Long pmSeq) {
		this.pmSeq = pmSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(Long vmSeq) {
		this.vmSeq = vmSeq;
	}
	public Long getServcSeq() {
		return servcSeq;
	}
	public void setServcSeq(Long servcSeq) {
		this.servcSeq = servcSeq;
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
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}
	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}
}
