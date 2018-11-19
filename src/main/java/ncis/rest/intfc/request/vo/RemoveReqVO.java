/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RemovePmVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 이해룡
 *
 */
public class RemoveReqVO {
	@ApiModelProperty(value = "센터구분코드", required = true)
	private String centerId;     /* 센터구분코드   */
	@ApiModelProperty(value = "요청ID", required = true)
	private String reqId;        /* 요청ID         */
	
	private String rsrcReqPrcssStatCd ;// 자원요청진행상태코드
	/**
	 * @return the centerId
	 */
	public String getCenterId() {
		return centerId;
	}
	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	/**
	 * @return the reqId
	 */
	public String getReqId() {
		return reqId;
	}
	/**
	 * @param reqId the reqId to set
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	/**
	 * @return the rsrcReqPrcssStatCd
	 */
	public String getRsrcReqPrcssStatCd() {
		return rsrcReqPrcssStatCd;
	}
	/**
	 * @param rsrcReqPrcssStatCd the rsrcReqPrcssStatCd to set
	 */
	public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
		this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
	}
	
}
