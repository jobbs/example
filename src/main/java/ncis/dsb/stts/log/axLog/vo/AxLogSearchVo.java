/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.vo;

import ncis.cmn.vo.CommonSearchVo;



public class AxLogSearchVo extends CommonSearchVo {
	private String strtDt;
	private String endDt;
	private String jobId;
	private String jobNm;
	private String servcAreaCompId;
	private Long objId;

	public String getStrtDt() {
		return strtDt;
	}
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}

	public String getServcAreaCompId() {
		return servcAreaCompId;
	}
	public void setServcAreaCompId(String servcAreaCompId) {
		this.servcAreaCompId = servcAreaCompId;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
}
