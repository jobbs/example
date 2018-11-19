/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewayVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 26.
 * @lastmodified 2016. 9. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 26.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.gateway.vo;

import ncis.cmn.entity.CmGateway;
import ncis.intfc.apigwstatus.vo.ResultHealthCheckVO;

/**
 * @author 박봉춘
 *
 */
public class GatewayVo extends CmGateway {

    private String regionNm;

	private String regUserNm;

	private ResultHealthCheckVO health;

	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}

	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

    /**
     * @return the regionNm
     */
    public String getRegionNm() {
        return regionNm;
    }

    /**
     * @param regionNm the regionNm to set
     */
    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    /**
     * @return the health
     */
    public ResultHealthCheckVO getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(ResultHealthCheckVO health) {
        this.health = health;
    }
}
