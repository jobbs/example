/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UnitJobProcssListVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 실행내역 작업 진행상태 Vo
 * @author 김봉민
 *
 */
public class UnitJobProcssListVo{

	private BigDecimal procssSeq;
	private String uJobId;
	private BigDecimal procssInstSeq;

	private List<UnitJobProcssVo> unitJobProcssVoList;

	public BigDecimal getProcssSeq() {
		return procssSeq;
	}

	public void setProcssSeq(BigDecimal procssSeq) {
		this.procssSeq = procssSeq;
	}
	public BigDecimal getProcssInstSeq() {
		return procssInstSeq;
	}

	public void setProcssInstSeq(BigDecimal procssInstSeq) {
		this.procssInstSeq = procssInstSeq;
	}

	public String getuJobId() {
		return uJobId;
	}

	public void setuJobId(String uJobId) {
		this.uJobId = uJobId;
	}

	public List<UnitJobProcssVo> getUnitJobProcssVoList() {
		return unitJobProcssVoList;
	}

	public void setUnitJobProcssVoList(List<UnitJobProcssVo> unitJobProcssVoList) {
		this.unitJobProcssVoList = unitJobProcssVoList;
	}
}
