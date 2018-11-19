/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasVstrQtyVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.vo;

import ncis.cmn.vo.CommonSearchVo;



public class GcamObjSearchVo extends CommonSearchVo {
	private String jobId;
	private String managetypeId;

	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getManagetypeId() {
		return managetypeId;
	}
	public void setManagetypeId(String managetypeId) {
		this.managetypeId = managetypeId;
	}

}
