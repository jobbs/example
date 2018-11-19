/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmRcKey.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;

/**
 * @author 심원보
 *
 */

public class VmRcKey {

    private BigDecimal vmSeq;

    private String keys;

    private String cmdCd; // 명령코드

    private String vmId;

    private String vmCompId; //vm구성id



    /**
	 * @return the vmId
	 */
	public String getVmId() {
		return vmId;
	}

	/**
	 * @param vmId the vmId to set
	 */
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	/**
	 * @return the vmCompId
	 */
	public String getVmCompId() {
		return vmCompId;
	}

	/**
	 * @param vmCompId the vmCompId to set
	 */
	public void setVmCompId(String vmCompId) {
		this.vmCompId = vmCompId;
	}

	public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getCmdCd() {
        return cmdCd;
    }

    public void setCmdCd(String cmdCd) {
        this.cmdCd = cmdCd;
    }

}