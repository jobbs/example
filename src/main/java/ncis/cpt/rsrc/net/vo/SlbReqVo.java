/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlbReqVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.util.List;

import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.entity.RrSlbConfIpReqList;

/**
 * @author 송승규
 *
 */
public class SlbReqVo extends RrRsrcReq{

	/**
	 * 존ID
	 */
	private String zoneId;

	/**
	 * 망ID
	 */
	private String netId;

	/**
	 * 자원풀ID
	 */
	private String poolId;

	/**
	 * 자원요청상세 네트워크 리스트
	 */
	private List<RrRsrcReqDtlNetwk> reqNetList;

	/**
	 * SLB설정 IP요청 리스트
	 */
	private List<RrSlbConfIpReqList> reqSlbList;

	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}

	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
	}

	/**
	 * @return the poolId
	 */
	public String getPoolId() {
		return poolId;
	}

	/**
	 * @param poolId the poolId to set
	 */
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	/**
	 * @return the reqNetList
	 */
	public List<RrRsrcReqDtlNetwk> getReqNetList() {
		return reqNetList;
	}

	/**
	 * @param reqNetList the reqNetList to set
	 */
	public void setReqNetList(List<RrRsrcReqDtlNetwk> reqNetList) {
		this.reqNetList = reqNetList;
	}

	/**
	 * @return the reqSlbList
	 */
	public List<RrSlbConfIpReqList> getReqSlbList() {
		return reqSlbList;
	}

	/**
	 * @param reqSlbList the reqSlbList to set
	 */
	public void setReqSlbList(List<RrSlbConfIpReqList> reqSlbList) {
		this.reqSlbList = reqSlbList;
	}
}