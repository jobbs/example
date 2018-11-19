/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxThrdConfSearchVo.java
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
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class AxThrdConfSearchVo extends CommonSearchVo {
	private String id;
	private String gubun;
	private String institutionId;
	private String jobId;
	private String servcAreaSeq;
	private String servcSeq;

	@SuppressWarnings("unused")
	private boolean allJobAuth;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getServcSeq() {
		return servcSeq;
	}
	public void setServcSeq(String servcSeq) {
		this.servcSeq = servcSeq;
	}
	public String getServcAreaSeq() {
		return servcAreaSeq;
	}
	public void setServcAreaSeq(String servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}

}
