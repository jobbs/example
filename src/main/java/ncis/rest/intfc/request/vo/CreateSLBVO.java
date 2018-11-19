/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CreateSLBVO.java
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

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ShinKeeBong
 *
 */
public class CreateSLBVO {

	
	@ApiModelProperty(value = "센터구분코드", required = true)
	private String centerId;            /* 센터구분코드       */
	@ApiModelProperty(value = "제목", required = true)
	private String subject;             /* 제목               */
	@ApiModelProperty(value = "요청ID ", required = true)
	private String reqId;               /* 요청ID             */
	@ApiModelProperty(value = "요청자ID", required = true)
	private String reqUserId;           /* 요청자ID           */
	@ApiModelProperty(value = "요청일자", required = true)
	private String reqDate;             /* 요청일자           */
	@ApiModelProperty(value = "가상서버 개수", required = false)
	private Integer vmCnt;          /* 가상서버 개수        */
	@ApiModelProperty(value = "VIP", required = true)
	private String vip;             /* VIP                  */
	@ApiModelProperty(value = "LB포트", required = false)
	private String lbPort;          /* LB포트               */
	@ApiModelProperty(value = "LB메소드", required = true)
	private String lbMethod;        /* LB메소드             */
	@ApiModelProperty(value = "세션유지유형", required = true)
	private String sessionType;     /* 세션유지유형         */
	@ApiModelProperty(value = "세션유지값", required = true)
	private String sessionValue;    /* 세션유지값           */
	@ApiModelProperty(value = "상태확인", required = true)
	private String statusCheck;     /* 상태확인             */
	@ApiModelProperty(value = "상태확인주기(초)", required = true)
	private Integer statusPeriod;   /* 상태확인주기(초)     */
	@ApiModelProperty(value = "상태확인타임아웃(초)", required = true)
	private Integer statusTimeout;  /* 상태확인타임아웃(초) */
	@ApiModelProperty(value = "최대시도회수", required = false)
	private Integer retryCnt;       /* 최대시도회수         */
	@ApiModelProperty(value = "HTTP URL", required = true)
	private String httpUrl;         /* HTTP URL             */
	
	
	@ApiModelProperty(value = "SLB설정 요청정보", required = true)
	private List<CreateSLBVmInfoVO> vmInfos; 


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
	public Integer getVmCnt() {
		return vmCnt;
	}
	public void setVmCnt(Integer vmCnt) {
		this.vmCnt = vmCnt;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getLbPort() {
		return lbPort;
	}
	public void setLbPort(String lbPort) {
		this.lbPort = lbPort;
	}
	public String getLbMethod() {
		return lbMethod;
	}
	public void setLbMethod(String lbMethod) {
		this.lbMethod = lbMethod;
	}
	public String getSessionType() {
		return sessionType;
	}
	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}
	public String getSessionValue() {
		return sessionValue;
	}
	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}
	public String getStatusCheck() {
		return statusCheck;
	}
	public void setStatusCheck(String statusCheck) {
		this.statusCheck = statusCheck;
	}
	public Integer getStatusPeriod() {
		return statusPeriod;
	}
	public void setStatusPeriod(Integer statusPeriod) {
		this.statusPeriod = statusPeriod;
	}
	public Integer getStatusTimeout() {
		return statusTimeout;
	}
	public void setStatusTimeout(Integer statusTimeout) {
		this.statusTimeout = statusTimeout;
	}
	public Integer getRetryCnt() {
		return retryCnt;
	}
	public void setRetryCnt(Integer retryCnt) {
		this.retryCnt = retryCnt;
	}
	public String getHttpUrl() {
		return httpUrl;
	}
	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
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
	/**
	 * @return the reqUserId
	 */
	public String getReqUserId() {
		return reqUserId;
	}
	/**
	 * @param reqUserId the reqUserId to set
	 */
	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}
	/**
	 * @return the reqDate
	 */
	public String getReqDate() {
		return reqDate;
	}
	/**
	 * @param reqDate the reqDate to set
	 */
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	/**
	 * @return the vmInfos
	 */
	public List<CreateSLBVmInfoVO> getVmInfos() {
		return vmInfos;
	}
	/**
	 * @param vmInfos the vmInfos to set
	 */
	public void setVmInfos(List<CreateSLBVmInfoVO> vmInfos) {
		this.vmInfos = vmInfos;
	}
	
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
}
