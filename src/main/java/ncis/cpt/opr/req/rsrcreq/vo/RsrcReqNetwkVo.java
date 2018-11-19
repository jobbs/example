/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-네트워크</pre>
 *
 * @filename RsrcReqNetwkVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import ncis.cmn.entity.RrRsrcReqDtlNetwk;

/**
 * 자원요청상세_네트워크
 * @author 김봉민
 *
 */
public class RsrcReqNetwkVo extends RrRsrcReqDtlNetwk{

	private String	slbTyNm;		/*SLB유형코드 명 */
	private String	sessMntncTyNm;		/*션유지유형명 */
	private String prtclNm;				/* 프로토콜 명 */
	private String rsrcReqPrcssStatNm; /* 진행상태 명 */
	private String regionId;		/* 센터 ID */

	public String getSlbTyNm() {
		return slbTyNm;
	}
	public void setSlbTyNm(String slbTyNm) {
		this.slbTyNm = slbTyNm;
	}
	public String getSessMntncTyNm() {
		return sessMntncTyNm;
	}
	public void setSessMntncTyNm(String sessMntncTyNm) {
		this.sessMntncTyNm = sessMntncTyNm;
	}
	public String getPrtclNm() {
		return prtclNm;
	}
	public void setPrtclNm(String prtclNm) {
		this.prtclNm = prtclNm;
	}
	public String getRsrcReqPrcssStatNm() {
		return rsrcReqPrcssStatNm;
	}
	public void setRsrcReqPrcssStatNm(String rsrcReqPrcssStatNm) {
		this.rsrcReqPrcssStatNm = rsrcReqPrcssStatNm;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
