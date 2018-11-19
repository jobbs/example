/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RrUnitJob.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.entity.RrUnitJob;

/**
 * @author 이화영
 *
 */
public class UnitJobVo extends RrUnitJob {

	private String uJobTyNm;  /* 단위업무유형명 */

	public String getuJobTyNm() {
		return uJobTyNm;
	}

	public void setuJobTyNm(String uJobTyNm) {
		this.uJobTyNm = uJobTyNm;
	}

	@Override
	public String toString() {
		return "UnitJobVo [uJobTyNm="
				+ uJobTyNm + ", getuJobId()=" + getuJobId() + ", getuJobNm()="
				+ getuJobNm() + ", getuJobDc()=" + getuJobDc()
				+ ", getuJobTyCd()=" + getuJobTyCd() + ", getIntfcUrl()="
				+ getIntfcUrl() + ", getIntfcParamtr()=" + getIntfcParamtr()
				+ ", getProcssSeq()=" + getProcssSeq() + ", getuJobSeq()="
				+ getuJobSeq() + ", getLowProcssSeq()=" + getLowProcssSeq()
				+ ", getIntfcFnctTyCd()=" + getIntfcFnctTyCd()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
