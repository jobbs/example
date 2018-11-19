/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RemoveClusterVO.java
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
 * @author wisecom
 *
 */
public class CreateSLBVmInfoVO {

	@ApiModelProperty(value = "가상서버구성ID", required = true)
	private String vmConfId;     /* 가상서버구성ID   */
	@ApiModelProperty(value = "가상서버IP", required = false)
	private String realIp;          /* 가상서버IP           */
	@ApiModelProperty(value = "가상서버 포트", required = true)
	private Integer port;           /* 가상서버 포트        */
	@ApiModelProperty(value = "가중치", required = false)
	private Integer lbPoint;        /* 가중치               */
	/**
	 * @return the vmConfId
	 */
	public String getVmConfId() {
		return vmConfId;
	}
	/**
	 * @param vmConfId the vmConfId to set
	 */
	public void setVmConfId(String vmConfId) {
		this.vmConfId = vmConfId;
	}
	/**
	 * @return the realIp
	 */
	public String getRealIp() {
		return realIp;
	}
	/**
	 * @param realIp the realIp to set
	 */
	public void setRealIp(String realIp) {
		this.realIp = realIp;
	}
	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the lbPoint
	 */
	public Integer getLbPoint() {
		return lbPoint;
	}
	/**
	 * @param lbPoint the lbPoint to set
	 */
	public void setLbPoint(Integer lbPoint) {
		this.lbPoint = lbPoint;
	}





}
