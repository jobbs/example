/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetSwtchVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.util.List;

import ncis.cmn.entity.RnNetwkSwtch;

/**
 * @author 송승규
 *
 */
public class NetSwtchVo extends RnNetwkSwtch {

	/**
	 * 네트워크유형구분코드
	 */
	private String netwkTyClCdNm;

	/**
	 * 가상서버ID
	 */
	private String vmId;

	/**
	 * 가상서버명
	 */
	private String vmNm;

	/**
	 * 기관명
	 */
	private String institutionNm;

	/**
	 * 네트워크스위치리스트
	 */
	private List<RnNetwkSwtch> netSwtchList;

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
	 * @return the netSwtchList
	 */
	public List<RnNetwkSwtch> getNetSwtchList() {
		return netSwtchList;
	}

	/**
	 * @param netSwtchList the netSwtchList to set
	 */
	public void setNetSwtchList(List<RnNetwkSwtch> netSwtchList) {
		this.netSwtchList = netSwtchList;
	}
}
