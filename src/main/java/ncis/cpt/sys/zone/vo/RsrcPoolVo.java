/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.vo;

import ncis.cmn.entity.RcRsrcPool;

/**
 * @author 최진호
 *
 */
public class RsrcPoolVo extends RcRsrcPool {

	private String strgCompNm;

	private String vrlzSwTyNm;

    private NetVo net;

    /**
     * @return the vrlzSwTyNm
     */
    public String getVrlzSwTyNm() {
        return vrlzSwTyNm;
    }

    /**
     * @param vrlzSwTyNm the vrlzSwTyNm to set
     */
    public void setVrlzSwTyNm(String vrlzSwTyNm) {
        this.vrlzSwTyNm = vrlzSwTyNm;
    }

    /**
     * @return the net
     */
    public NetVo getNet() {
        return net;
    }

    /**
     * @param net the net to set
     */
    public void setNet(NetVo net) {
        this.net = net;
    }

	/**
	 * @return the strgCompNm
	 */
	public String getStrgCompNm() {
		return strgCompNm;
	}

	/**
	 * @param strgCompNm the strgCompNm to set
	 */
	public void setStrgCompNm(String strgCompNm) {
		this.strgCompNm = strgCompNm;
	}

}
