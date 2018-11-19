/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptJobCntVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

public class GovDeptJobCntVo extends CommonSearchVo {

	private BigDecimal institutionCnt;
	private BigDecimal jobCnt;
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



}
