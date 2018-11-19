/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmSvo.java
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

import ncis.cmn.util.ObjectUtils;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 송승규
 *
 */
public class NetVmSvo extends CommonSearchVo{

	/**
	 * 가상서버시퀀스
	 */
	private BigDecimal vmSeq;

	/**
	 * 센터ID
	 */
	private String regionId;

	/**
	 * 존ID
	 */
	private String zoneId;

	/**
	 * 망ID
	 */
	private String netId;

	/**
	 * 자원풀ID
	 */
	private String poolId;

	/**
	 * 상태코드
	 */
	private String statCd;

	/**
	 * 클러스터명
	 */
	private String clstrNm;

	/**
	 * 물리서버 시퀀스
	 */
	private BigDecimal pmSeq;

	/**
	 * 물리서버명
	 */
	private String pmNm;

	/**
	 * 물리서버구성ID
	 */
	private String pmCompId;

	/**
	 * 가상서버명
	 */
	private String vmNm;

	/**
	 * 가성서버ID
	 */
	private String vmId;

	/**
	 * 가상서버구성ID
	 */
	private String vmCompId;

	/**
	 * 호스트명
	 */
	private String hstNm;

	/**
	 * 대표IP주소
	 */
	private String rprsntIpAddr;

	/**
	 * OS유형
	 */
	private String osTyCd;

	/**
	 * 기관명
	 */
	private String institutionNm;

	/**
	 * 업무명
	 */
	private String jobNm;

	/**
	 * 업무ID
	 */
	private String jobId;

	/**
	 * 네트워크유형
	 */
	private String netwkTyClCd;

	/**
	 * 가상화SW
	 */
	private List<String> vrlzSwTyCdList;

	/**
	 * L4 조회용 List
	 */
	private List<BigDecimal> vmList;
	/**
	 * 망구분
	 */
	private String netClCd;

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
	 * @return the vmSeq
	 */
	public BigDecimal getVmSeq() {
		return vmSeq;
	}

	/**
	 * @param vmSeq the vmSeq to set
	 */
	public void setVmSeq(BigDecimal vmSeq) {
		this.vmSeq = vmSeq;
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
	 * @return the statCd
	 */
	public String getStatCd() {
		return statCd;
	}

	/**
	 * @param statCd the statCd to set
	 */
	public void setStatCd(String statCd) {
		this.statCd = statCd;
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
	 * @return the vmCompId
	 */
	public String getVmCompId() {
		return vmCompId;
	}

	/**
	 * @param vmCmopId the vmCmopId to set
	 */
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}

	/**
	 * @return the hstNm
	 */
	public String getHstNm() {
		return hstNm;
	}

	/**
	 * @param hstNm the hstNm to set
	 */
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
	}

	/**
	 * @return the rprsntIpAddr
	 */
	public String getRprsntIpAddr() {
		return rprsntIpAddr;
	}

	/**
	 * @param rprsntIpAddr the rprsntIpAddr to set
	 */
	public void setRprsntIpAddr(String rprsntIpAddr) {
		this.rprsntIpAddr = rprsntIpAddr;
	}

	/**
	 * @return the osTyCd
	 */
	public String getOsTyCd() {
		return osTyCd;
	}

	/**
	 * @param osTyCd the osTyCd to set
	 */
	public void setOsTyCd(String osTyCd) {
		this.osTyCd = osTyCd;
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
	 * @return the jobNm
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the netwkTyClCd
	 */
	public String getNetwkTyClCd() {
		return netwkTyClCd;
	}

	/**
	 * @param netwkTyClCd the netwkTyClCd to set
	 */
	public void setNetwkTyClCd(String netwkTyClCd) {
		this.netwkTyClCd = netwkTyClCd;
	}

	/**
	 * @return the vrlzSwTyCdList
	 */
	public List<String> getVrlzSwTyCdList() {
		return vrlzSwTyCdList;
	}

	/**
	 * @param vrlzSwTyCdList the vrlzSwTyCdList to set
	 */
	public void setVrlzSwTyCdList(List<String> vrlzSwTyCdList) {
		this.vrlzSwTyCdList = vrlzSwTyCdList;
	}

	/**
	 * @return the vmList
	 */
	@SuppressWarnings("unchecked")
	public List<BigDecimal> getVmList() {
		if(ObjectUtils.isEmpty(vmList)){
			vmList =  new ArrayList<BigDecimal>();
		}
		return (List<BigDecimal>) ((ArrayList<BigDecimal>) vmList).clone();
	}

	/**
	 * @param vmList the vmList to set
	 */
	@SuppressWarnings("unchecked")
	public void setVmList(List<BigDecimal> vmList) {
		this.vmList = (List<BigDecimal>) ((ArrayList<BigDecimal>) vmList).clone();
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
