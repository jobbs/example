/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CreateClusterVO.java
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

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ShinKeeBong
 *
 */
public class CreateClusterVO {
	@ApiModelProperty(value = "센터구분코드", required = true)
	private String centerId;       /* 센터구분코드       */
	@ApiModelProperty(value = "요청제목", required = true)
	private String subject;		 /* 요청제목 */
	@ApiModelProperty(value = "요청ID", required = true)
	private String reqId;          /* 요청ID             */
	@ApiModelProperty(value = "요청자ID", required = true)
	private String reqUserId;      /* 요청자ID           */
	@ApiModelProperty(value = "요청일자", required = true)
	private String reqDate;        /* 요청일자           */
	
	@ApiModelProperty(value = "클러스터 생성요청 정보", required = true)
	private List<CreateClusterClusterInfoVO> clusterInfos; /*클러스터구성ID*/

	
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getReqUserId() {
		return reqUserId;
	}
	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	/**
	 * @return the clusterInfos
	 */
	public List<CreateClusterClusterInfoVO> getClusterInfos() {
		return clusterInfos;
	}
	/**
	 * @param clusterInfos the clusterInfos to set
	 */
	public void setClusterInfos(List<CreateClusterClusterInfoVO> clusterInfos) {
		this.clusterInfos = clusterInfos;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
