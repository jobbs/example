/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ResAsgnCntVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.vo;

import ncis.cmn.vo.CommonSearchVo;

public class ResAsgnCntVo extends CommonSearchVo {

	private long lastAsgnVcorQty;
	private long lastAsgnMemCapa;
	private long lastAsgnStrgCapa;
	/**
	 * @return the lastAsgnVcorQty
	 */
	public long getLastAsgnVcorQty() {
		return lastAsgnVcorQty;
	}
	/**
	 * @param lastAsgnVcorQty the lastAsgnVcorQty to set
	 */
	public void setLastAsgnVcorQty(long lastAsgnVcorQty) {
		this.lastAsgnVcorQty = lastAsgnVcorQty;
	}
	/**
	 * @return the lastAsgnMemCapa
	 */
	public long getLastAsgnMemCapa() {
		return lastAsgnMemCapa;
	}
	/**
	 * @param lastAsgnMemCapa the lastAsgnMemCapa to set
	 */
	public void setLastAsgnMemCapa(long lastAsgnMemCapa) {
		this.lastAsgnMemCapa = lastAsgnMemCapa;
	}
	/**
	 * @return the lastAsgnStrgCapa
	 */
	public long getLastAsgnStrgCapa() {
		return lastAsgnStrgCapa;
	}
	/**
	 * @param lastAsgnStrgCapa the lastAsgnStrgCapa to set
	 */
	public void setLastAsgnStrgCapa(long lastAsgnStrgCapa) {
		this.lastAsgnStrgCapa = lastAsgnStrgCapa;
	}


}
