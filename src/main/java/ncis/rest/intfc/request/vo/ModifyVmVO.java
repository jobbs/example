/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ModifyVmVO.java
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

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class ModifyVmVO {

	@ApiModelProperty(value = "센터구분코드", required = true)
	private String centerId;     /* 센터구분코드     */
	@ApiModelProperty(value = "제목", required = true)
	private String subject;      /* 제목             */
	@ApiModelProperty(value = "요청ID", required = true)
	private String reqId;        /* 요청ID           */
	@ApiModelProperty(value = "요청자ID", required = true)
	private String reqUserId;    /* 요청자ID         */
	@ApiModelProperty(value = "요청일자", required = true)
	private String reqDate;      /* 요청일자         */

	//private String isDeleted;    /* 삭제여부         */

	@ApiModelProperty(value = "가상서버 변경 요청정보", required = true)
	private List<ModifyVmVmInfoVO> vmInfos; /*가상서버 변경 요청정보*/

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
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
	 * @return the vmInfos
	 */
	public List<ModifyVmVmInfoVO> getVmInfos() {
		return vmInfos;
	}
	/**
	 * @param vmInfos the vmInfos to set
	 */
	public void setVmInfos(List<ModifyVmVmInfoVO> vmInfos) {
		this.vmInfos = vmInfos;
	}
}
