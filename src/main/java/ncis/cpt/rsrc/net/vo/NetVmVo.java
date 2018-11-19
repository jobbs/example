/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ncis.cmn.entity.RcVm;
import ncis.cmn.entity.RnSlb;
import ncis.cmn.util.ObjectUtils;

/**
 * @author 송승규
 *
 */
public class NetVmVo extends RcVm{

	/**
	 * 상태명
	 */
	private String statCdNm;

	/**
	 * 부처명
	 */
	private String institutionNm;

	/**
	 * 업무명
	 */
	private String vmJob;

	/**
	 * 업무ID
	 */
	private String jobId;

	/**
	 * 네트워크유형구분코드
	 */
	private String netwkTyClCdNm;

	/**
	 * 센터명
	 */
	private String regionNm;

	/**
	 * 존명
	 */
	private String zoneNm;

	/**
	 * 망명
	 */
	private String netNm;
	/**
	 * 망구분코드
	 */
	private String netClCd;
	/**
	 * 망구분명
	 */
	private String netClCdNm;



	/**
	 * 자원풀명
	 */
	private String rsrcPoolNm;

	/**
	 * 클러스터명
	 */
	private String clstrNm;

	/**
	 * 물리서버S
	 */
	private BigDecimal pmSeq;

	/**
	 * 물리서버명
	 */
	private String pmNm;

	/**
	 * 물리서버 구성ID
	 */
	private String pmCompId;

	/**
	 * 운영체제
	 */
	private String osTyCdNm;

	/**
	 * 가상화SW
	 */
	private String vrlzSwTyCdNm;

	/**
	 * 가동시간
	 */
	private String uptime;

	/**
	 * 기동일시 (for excel)
	 */
	private String strtupDt;

	/**
	 * 등록일시 (for excel)
	 */
	private String regDt;

	/**
	 * 센터ID
	 */
	private String regoinId;

	/**
	 * 존ID
	 */
	private String zoneId;

	/**
	 * 망ID
	 */
	private String netId;

	/**
	 * 자원풀 ID
	 */
	private String poolId;

	/**
	 * 순번 (for excel)
	 */
	private int rowNum;

	/**
	 * L4 스위치 리스트
	 */
	private List<NetL4VmVo> swtchList;

	/**
	 * L4 SLB 리스트
	 */
	private List<RnSlb> slbList;

	/**
	 * L4 SLB IP 리스트
	 */
	private List<NetVmSlbIpVo> slbIpList;

	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}

	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	/**
	 * @return the netClCdNm
	 */
	public String getNetClCdNm() {
		return netClCdNm;
	}

	/**
	 * @param netClCdNm the netClCdNm to set
	 */
	public void setNetClCdNm(String netClCdNm) {
		this.netClCdNm = netClCdNm;
	}

	/**
	 * @return the statCdNm
	 */
	public String getStatCdNm() {
		return statCdNm;
	}

	/**
	 * @param statCdNm the statCdNm to set
	 */
	public void setStatCdNm(String statCdNm) {
		this.statCdNm = statCdNm;
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
	 * @return the vmJob
	 */
	public String getVmJob() {
		return vmJob;
	}

	/**
	 * @param vmJob the vmJob to set
	 */
	public void setVmJob(String vmJob) {
		this.vmJob = vmJob;
	}

	/**
	 * @return the vmJob
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param vmJob the vmJob to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the netwkTyClCdNm
	 */
	public String getNetwkTyClCdNm() {
		return netwkTyClCdNm;
	}

	/**
	 * @param netwkTyClCdNm the netwkTyClCdNm to set
	 */
	public void setNetwkTyClCdNm(String netwkTyClCdNm) {
		this.netwkTyClCdNm = netwkTyClCdNm;
	}

	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}

	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}

	/**
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}

	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}

	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}

	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}

	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}

	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}

	/**
	 * @return the clstrNm
	 */
	public String getClstrNm() {
		return clstrNm;
	}

	/**
	 * @param clstrNm the clstrNm to set
	 */
	public void setClstrNm(String clstrNm) {
		this.clstrNm = clstrNm;
	}

	/**
	 * @return the pmSeq
	 */
	public BigDecimal getPmSeq() {
		return pmSeq;
	}

	/**
	 * @param pmSeq the pmSeq to set
	 */
	public void setPmSeq(BigDecimal pmSeq) {
		this.pmSeq = pmSeq;
	}

	/**
	 * @return the pmNm
	 */
	public String getPmNm() {
		return pmNm;
	}

	/**
	 * @param pmNm the pmNm to set
	 */
	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
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
	 * @return the osTyCdNm
	 */
	public String getOsTyCdNm() {
		return osTyCdNm;
	}

	/**
	 * @param osTyCdNm the osTyCdNm to set
	 */
	public void setOsTyCdNm(String osTyCdNm) {
		this.osTyCdNm = osTyCdNm;
	}

	/**
	 * @return the vrlzSwTyCdNm
	 */
	public String getVrlzSwTyCdNm() {
		return vrlzSwTyCdNm;
	}

	/**
	 * @param vrlzSwTyCdNm the vrlzSwTyCdNm to set
	 */
	public void setVrlzSwTyCdNm(String vrlzSwTyCdNm) {
		this.vrlzSwTyCdNm = vrlzSwTyCdNm;
	}

	/**
	 * @return the uptime
	 */
	public String getUptime() {
		return uptime;
	}

	/**
	 * @param uptime the uptime to set
	 */
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	/**
	 * @return the strtupDt
	 */
	public String getStrtupDt() {
		return strtupDt;
	}

	/**
	 * @param strtupDt the strtupDt to set
	 */
	public void setStrtupDt(String strtupDt) {
		this.strtupDt = strtupDt;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the regoinId
	 */
	public String getRegoinId() {
		return regoinId;
	}

	/**
	 * @param regoinId the regoinId to set
	 */
	public void setRegoinId(String regoinId) {
		this.regoinId = regoinId;
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
	 * @return the poolId
	 */
	public String getPoolId() {
		return poolId;
	}

	/**
	 * @param poolId the poolId to set
	 */
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	/**
	 * @return the rowNum
	 */
	public int getRowNum() {
		return rowNum;
	}

	/**
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	/**
	 * @return the swtchList
	 */
	@SuppressWarnings("unchecked")
	public List<NetL4VmVo> getSwtchList() {
		if(ObjectUtils.isEmpty(swtchList)){
			swtchList = new ArrayList<NetL4VmVo>();
		}
		return (List<NetL4VmVo>) ((ArrayList<NetL4VmVo>) swtchList).clone();
	}

	/**
	 * @param swtchList the swtchList to set
	 */
	@SuppressWarnings("unchecked")
	public void setSwtchList(List<NetL4VmVo> swtchList) {
		this.swtchList = (List<NetL4VmVo>) ((ArrayList<NetL4VmVo>) swtchList).clone();
	}

	/**
	 * @return the slbList
	 */
	@SuppressWarnings("unchecked")
	public List<RnSlb> getSlbList() {
		if(ObjectUtils.isEmpty(slbList)){
			slbList = new ArrayList<RnSlb>();
		}
		return (List<RnSlb>) ((ArrayList<RnSlb>) slbList).clone();
	}

	/**
	 * @param slbList the slbList to set
	 */
	@SuppressWarnings("unchecked")
	public void setSlbList(List<RnSlb> slbList) {
		this.slbList = (List<RnSlb>) ((ArrayList<RnSlb>) slbList).clone();
	}

	/**
	 * @return the slbIpList
	 */
	@SuppressWarnings("unchecked")
	public List<NetVmSlbIpVo> getSlbIpList() {
		if(ObjectUtils.isEmpty(slbIpList)){
			slbIpList = new ArrayList<NetVmSlbIpVo>();
		}
		return (List<NetVmSlbIpVo>) ((ArrayList<NetVmSlbIpVo>) slbIpList).clone();
	}

	/**
	 * @param slbIpList the slbIpList to set
	 */
	@SuppressWarnings("unchecked")
	public void setSlbIpList(List<NetVmSlbIpVo> slbIpList) {
		this.slbIpList = (List<NetVmSlbIpVo>) ((ArrayList<NetVmSlbIpVo>) slbIpList).clone();
	}
}
