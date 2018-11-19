/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
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
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;


public class PmResStteVo {


	//센터명
	private String regionNm;
	//존명
	private String zoneNm;
	//망명
	private String netNm;
	//자원풀 명
	private String rsrcPoolNm;
	private String clstrNm;
	private String clstrSeq;
	private BigDecimal pmSeq;
	private String pmNm;
	//물리서버구성ID
	private String  pmCompId;
	//최종 가상서버수
	private String pmLastVSrvrQty;
	//최종 물리서버cpu 코어수
	private BigDecimal pmLastCpuCorQty;
	// 최종 물리서버 할당vCore코어 수
	private BigDecimal pmLastAsgnVcorQty;
	// 최종 물리서버  메모리 총용량
	private BigDecimal pmLastMemSumCapa;
	// 최종 물리서버 할당 메모리 용량
	private BigDecimal pmLastAsgnMemCapa;
	//물리서버 CPU사용율
	private BigDecimal pmAvgCpuUseRt;
	// --물리서버 합계 메모리 총용량
	private BigDecimal pmSumMemSumCapa;
	//물리서버 합계 메모리 사용량
	private BigDecimal pmSumMemUseCapa;
	//--메모리 사용률
	private BigDecimal pmMemUseRt;
	private BigDecimal vmSeq;
	private String vmNm;
	private String hstNm;
	private String institutionNm;
	private String jobNm;
	//--최종 가상서버 VCORE 수
	private BigDecimal vmLastVcoreQty;
	//--최종 가상서버 메모리 용량
	private BigDecimal vmLastMemSumCapa;
	//--최종 가상서버 스토리지 용량
	private BigDecimal vmLastStrgSumCapa;
	//--가상서버 평균 CPU 사용율
	private BigDecimal vmAvgCpuUseRt;
	//가상서버 합계 메모리 총용량
	private BigDecimal vmSumMemSumCapa;
	// --가상서버 합계 메모리 사용량
	private BigDecimal vmmSumMemUseCapa;
	// 가상서버 메모리 사용율
	private BigDecimal vmMemUseRt;
	//가상서버 합계 스토리지 총용량
	private BigDecimal vmSumStrgCapa;
	//가상서버 합계 스토리지 사용량
	private BigDecimal vmSumStrgUseCapa;
	// --가상서버 스토리지 사용율
	private BigDecimal vmStrgUseRt;
	private BigDecimal pmCpuVRt;
	private BigDecimal pmMemVRt;
	//물리서버 스토리지 총용량(가상서버 스토리지 합)
	private BigDecimal pmLastStrgSumCapa;
	//물리서버 스토리지 사용률
	private BigDecimal pmStrgUseRt;
	private String vmCompId;
	private int cnt;
	private int seq;
	private int vmCnt;

	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getZoneNm() {
		return zoneNm;
	}
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	public String getNetNm() {
		return netNm;
	}
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public BigDecimal getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(BigDecimal pmSeq) {
		this.pmSeq = pmSeq;
	}
	public String getPmNm() {
		return pmNm;
	}
	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
	}
	public String getPmCompId() {
		return pmCompId;
	}
	public void setPmCompId(String pmCompId) {
		this.pmCompId = pmCompId;
	}
	public String getPmLastVSrvrQty() {
		return pmLastVSrvrQty;
	}
	public void setPmLastVSrvrQty(String pmLastVSrvrQty) {
		this.pmLastVSrvrQty = pmLastVSrvrQty;
	}
	public BigDecimal getPmLastCpuCorQty() {
		return pmLastCpuCorQty;
	}
	public void setPmLastCpuCorQty(BigDecimal pmLastCpuCorQty) {
		this.pmLastCpuCorQty = pmLastCpuCorQty;
	}
	public BigDecimal getPmLastAsgnVcorQty() {
		return pmLastAsgnVcorQty;
	}
	public void setPmLastAsgnVcorQty(BigDecimal pmLastAsgnVcorQty) {
		this.pmLastAsgnVcorQty = pmLastAsgnVcorQty;
	}
	public BigDecimal getPmLastMemSumCapa() {
		return pmLastMemSumCapa;
	}
	public void setPmLastMemSumCapa(BigDecimal pmLastMemSumCapa) {
		this.pmLastMemSumCapa = pmLastMemSumCapa;
	}
	public BigDecimal getPmLastAsgnMemCapa() {
		return pmLastAsgnMemCapa;
	}
	public void setPmLastAsgnMemCapa(BigDecimal pmLastAsgnMemCapa) {
		this.pmLastAsgnMemCapa = pmLastAsgnMemCapa;
	}
	public BigDecimal getPmAvgCpuUseRt() {
		return pmAvgCpuUseRt;
	}
	public void setPmAvgCpuUseRt(BigDecimal pmAvgCpuUseRt) {
		this.pmAvgCpuUseRt = pmAvgCpuUseRt;
	}
	public BigDecimal getPmSumMemSumCapa() {
		return pmSumMemSumCapa;
	}
	public void setPmSumMemSumCapa(BigDecimal pmSumMemSumCapa) {
		this.pmSumMemSumCapa = pmSumMemSumCapa;
	}
	public BigDecimal getPmSumMemUseCapa() {
		return pmSumMemUseCapa;
	}
	public void setPmSumMemUseCapa(BigDecimal pmSumMemUseCapa) {
		this.pmSumMemUseCapa = pmSumMemUseCapa;
	}
	public BigDecimal getPmMemUseRt() {
		return pmMemUseRt;
	}
	public void setPmMemUseRt(BigDecimal pmMemUseRt) {
		this.pmMemUseRt = pmMemUseRt;
	}
	public BigDecimal getVmSeq() {
		return vmSeq;
	}
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
	}
	public String getVmNm() {
		return vmNm;
	}
	public void setVmNm(String vmNm) {
		this.vmNm = vmNm;
	}
	public String getHstNm() {
		return hstNm;
	}
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
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
	public BigDecimal getVmLastVcoreQty() {
		return vmLastVcoreQty;
	}
	public void setVmLastVcoreQty(BigDecimal vmLastVcoreQty) {
		this.vmLastVcoreQty = vmLastVcoreQty;
	}
	public BigDecimal getVmLastMemSumCapa() {
		return vmLastMemSumCapa;
	}
	public void setVmLastMemSumCapa(BigDecimal vmLastMemSumCapa) {
		this.vmLastMemSumCapa = vmLastMemSumCapa;
	}
	public BigDecimal getVmLastStrgSumCapa() {
		return vmLastStrgSumCapa;
	}
	public void setVmLastStrgSumCapa(BigDecimal vmLastStrgSumCapa) {
		this.vmLastStrgSumCapa = vmLastStrgSumCapa;
	}
	public BigDecimal getVmAvgCpuUseRt() {
		return vmAvgCpuUseRt;
	}
	public void setVmAvgCpuUseRt(BigDecimal vmAvgCpuUseRt) {
		this.vmAvgCpuUseRt = vmAvgCpuUseRt;
	}
	public BigDecimal getVmSumMemSumCapa() {
		return vmSumMemSumCapa;
	}
	public void setVmSumMemSumCapa(BigDecimal vmSumMemSumCapa) {
		this.vmSumMemSumCapa = vmSumMemSumCapa;
	}
	public BigDecimal getVmmSumMemUseCapa() {
		return vmmSumMemUseCapa;
	}
	public void setVmmSumMemUseCapa(BigDecimal vmmSumMemUseCapa) {
		this.vmmSumMemUseCapa = vmmSumMemUseCapa;
	}
	public BigDecimal getVmMemUseRt() {
		return vmMemUseRt;
	}
	public void setVmMemUseRt(BigDecimal vmMemUseRt) {
		this.vmMemUseRt = vmMemUseRt;
	}
	public BigDecimal getVmSumStrgCapa() {
		return vmSumStrgCapa;
	}
	public void setVmSumStrgCapa(BigDecimal vmSumStrgCapa) {
		this.vmSumStrgCapa = vmSumStrgCapa;
	}
	public BigDecimal getVmSumStrgUseCapa() {
		return vmSumStrgUseCapa;
	}
	public void setVmSumStrgUseCapa(BigDecimal vmSumStrgUseCapa) {
		this.vmSumStrgUseCapa = vmSumStrgUseCapa;
	}
	public BigDecimal getVmStrgUseRt() {
		return vmStrgUseRt;
	}
	public void setVmStrgUseRt(BigDecimal vmStrgUseRt) {
		this.vmStrgUseRt = vmStrgUseRt;
	}
	public BigDecimal getPmCpuVRt() {
		return pmCpuVRt;
	}
	public void setPmCpuVRt(BigDecimal pmCpuVRt) {
		this.pmCpuVRt = pmCpuVRt;
	}
	public BigDecimal getPmMemVRt() {
		return pmMemVRt;
	}
	public void setPmMemVRt(BigDecimal pmMemVRt) {
		this.pmMemVRt = pmMemVRt;
	}
	public BigDecimal getPmLastStrgSumCapa() {
		return pmLastStrgSumCapa;
	}
	public void setPmLastStrgSumCapa(BigDecimal pmLastStrgSumCapa) {
		this.pmLastStrgSumCapa = pmLastStrgSumCapa;
	}
	public String getClstrNm() {
		return clstrNm;
	}
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
	}
	public String getClstrSeq() {
		return clstrSeq;
	}
	public void setClstrSeq(String clstrSeq) {
		this.clstrSeq = clstrSeq;
	}
	public BigDecimal getPmStrgUseRt() {
		return pmStrgUseRt;
	}
	public void setPmStrgUseRt(BigDecimal pmStrgUseRt) {
		this.pmStrgUseRt = pmStrgUseRt;
	}
	public String getVmCompId() {
		return vmCompId;
	}
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getVmCnt() {
		return vmCnt;
	}
	public void setVmCnt(int vmCnt) {
		this.vmCnt = vmCnt;
	}

}
