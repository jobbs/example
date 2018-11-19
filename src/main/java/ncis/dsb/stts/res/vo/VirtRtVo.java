/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VirtRtVo.java
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

public class VirtRtVo extends CommonSearchVo {

	private BigDecimal cpuVirtRt;
	private BigDecimal memVirtRt;
	/**
	 * @return the cpuVirtRt
	 */
	public BigDecimal getCpuVirtRt() {
		return cpuVirtRt;
	}
	/**
	 * @param cpuVirtRt the cpuVirtRt to set
	 */
	public void setCpuVirtRt(BigDecimal cpuVirtRt) {
		this.cpuVirtRt = cpuVirtRt;
	}
	/**
	 * @return the memVirtRt
	 */
	public BigDecimal getMemVirtRt() {
		return memVirtRt;
	}
	/**
	 * @param memVirtRt the memVirtRt to set
	 */
	public void setMemVirtRt(BigDecimal memVirtRt) {
		this.memVirtRt = memVirtRt;
	}



}
