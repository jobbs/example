/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqVmVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import ncis.cmn.entity.RrRsrcReqDtlVm;

public class RsrcReqVmVo extends RrRsrcReqDtlVm {

    private String haYn;

    private String haStatCd;

    public String getHaYn() {
        return haYn;
    }

    public void setHaYn(String haYn) {
        this.haYn = haYn;
    }

	/**
	 * @return the haStatCd
	 */
	public String getHaStatCd() {
		return haStatCd;
	}

	/**
	 * @param haStatCd the haStatCd to set
	 */
	public void setHaStatCd(String haStatCd) {
		this.haStatCd = haStatCd;
	}

}
