/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmSlbIpVo.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 11. 23.
 * @lastmodified 2016. 11. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 23.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.math.BigDecimal;

import ncis.cmn.entity.RnSlbIp;

/**
 * @author 송승규
 *
 */
public class NetVmSlbIpVo extends RnSlbIp{

	/**
	 * 대상 가상서버 시퀀스
	 */
	private BigDecimal trgtVmSeq;

	/**
	 * 대상 가상서버구성ID
	 */
	private String trgtVmCompId;


	/**
	 * 상세보기 링크여부
	 */
	private String linkAt;



	/**
	 * @return the linkAt
	 */
	public String getLinkAt() {
		return linkAt;
	}

	/**
	 * @param linkAt the linkAt to set
	 */
	public void setLinkAt(String linkAt) {
		this.linkAt = linkAt;
	}

	/**
	 * @return the trgtVmSeq
	 */
	public BigDecimal getTrgtVmSeq() {
		return trgtVmSeq;
	}

	/**
	 * @param trgtVmSeq the trgtVmSeq to set
	 */
	public void setTrgtVmSeq(BigDecimal trgtVmSeq) {
		this.trgtVmSeq = trgtVmSeq;
	}

	/**
	 * @return the trgtVmCompId
	 */
	public String getTrgtVmCompId() {
		return trgtVmCompId;
	}

	/**
	 * @param trgtVmCompId the trgtVmCompId to set
	 */
	public void setTrgtVmCompId(String trgtVmCompId) {
		this.trgtVmCompId = trgtVmCompId;
	}
}