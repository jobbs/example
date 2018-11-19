/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CntServStteVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.servstte.vo;
import java.math.BigDecimal;


public class CntServStteVo{
	private String regionNm;
	private BigDecimal institutionCnt;
	private BigDecimal jobCnt;
	private BigDecimal vmCnt;
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
	 * @return the institutionCnt
	 */
	public BigDecimal getInstitutionCnt() {
		return institutionCnt;
	}
	/**
	 * @param institutionCnt the institutionCnt to set
	 */
	public void setInstitutionCnt(BigDecimal institutionCnt) {
		this.institutionCnt = institutionCnt;
	}
	/**
	 * @return the jobCnt
	 */
	public BigDecimal getJobCnt() {
		return jobCnt;
	}
	/**
	 * @param jobCnt the jobCnt to set
	 */
	public void setJobCnt(BigDecimal jobCnt) {
		this.jobCnt = jobCnt;
	}
	/**
	 * @return the vmCnt
	 */
	public BigDecimal getVmCnt() {
		return vmCnt;
	}
	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(BigDecimal vmCnt) {
		this.vmCnt = vmCnt;
	}


}
