/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetL4VmVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.math.BigDecimal;

/**
 * @author 송승규
 *
 */
public class NetL4VmVo {

	/**
	 * 가상서버SEQ
	 */
	private BigDecimal vmSeq;

	/**
	 * 상태코드
	 */
	private String statCd;

	/**
	 * 상태
	 */
	private String statCdNm;

	/**
	 * 부처명
	 */
	private String institutionNm;

	/**
	 * 가상서버명
	 */
	private String vmNm;

	/**
	 * 가상서버ID
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
	 * OS타입
	 */
	private String osTyCdNm;

	/**
	 * 생성일시
	 */
	private String regDttm;

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
	 * @param vmCompId the vmCompId to set
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
	 * @return the regDttm
	 */
	public String getRegDttm() {
		return regDttm;
	}

	/**
	 * @param regDttm the regDttm to set
	 */
	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}
}
