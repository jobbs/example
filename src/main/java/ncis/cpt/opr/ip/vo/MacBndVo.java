/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.util.Date;

import ncis.cmn.entity.RcMacBnd;

/**
 * @author 송승규
 *
 */
public class MacBndVo extends RcMacBnd{

	/**
	 * 센터ID
	 */
	private String regionNm;

	/**
	 * 존ID
	 */
	private String zoneNm;

	/**
	 * 망ID
	 */
	private String netNm;

	/**
	 * 가상화SW구분코드
	 */
	private String poolId;

	/**
	 * 자원풀명
	 */
	private String rsrcPoolNm;

	/**
	 * 할당MAC주소 갯수
	 */
	private Integer asgnCnt;

	/**
	 * 할당여부 (for MAC주소List)
	 */
	private String asgnYn;

	/**
	 * 가상서버구성ID (for MAC주소List)
	 */
	private String vmCompId;

	/**
	 * MAC주소
	 */
	private String macAddr;

	/**
	 * 부처명
	 */
	private String institutionNm;

	/**
	 * 가상서버명
	 */
	private String vmNm;

	/**
	 * 네트워크인터페이스명
	 */
	private String netwkIntfcNm;

	/**
	 * 할당일시
	 */
	private Date asgnDt;

	/**
	 * 가상서버업무
	 */
	private String vmJob;


	/**
	 * 망구분코드
	 */
	private String netClCd;

	/**
	 * 망구분코드
	 */
	private String netClCdNm;





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
	 * @return the asgnCnt
	 */
	public Integer getAsgnCnt() {
		return asgnCnt;
	}

	/**
	 * @param asgnCnt the asgnCnt to set
	 */
	public void setAsgnCnt(Integer asgnCnt) {
		this.asgnCnt = asgnCnt;
	}

	/**
	 * @return the asgnYn
	 */
	public String getAsgnYn() {
		return asgnYn;
	}

	/**
	 * @param asgnYn the asgnYn to set
	 */
	public void setAsgnYn(String asgnYn) {
		this.asgnYn = asgnYn;
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
	 * @return the macAddr
	 */
	public String getMacAddr() {
		return macAddr;
	}

	/**
	 * @param macAddr the macAddr to set
	 */
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
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
	 * @return the netwkIntfcNm
	 */
	public String getNetwkIntfcNm() {
		return netwkIntfcNm;
	}

	/**
	 * @param netwkIntfcNm the netwkIntfcNm to set
	 */
	public void setNetwkIntfcNm(String netwkIntfcNm) {
		this.netwkIntfcNm = netwkIntfcNm;
	}

	/**
	 * @return the asgnDt
	 */
	public Date getAsgnDt() {
		return asgnDt;
	}

	/**
	 * @param asgnDt the asgnDt to set
	 */
	public void setAsgnDt(Date asgnDt) {
		this.asgnDt = asgnDt;
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
}
