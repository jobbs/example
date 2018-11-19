/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ColctVo.java
 *
 * @author 최장성
 * @lastmodifier 최장성
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     최장성         v1.0             최초생성
 *
 */
package ncis.api.stack.colct.vo;

import ncis.cmn.entity.couch.CmnCouchVo;


/**
 * @author 최장성
 *
 */
public class ViewVo extends CmnCouchVo {
	private String rsrcPoolId;
	private String colctDttm;

	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the colctDttm
	 */
	public String getColctDttm() {
		return colctDttm;
	}
	/**
	 * @param colctDttm the colctDttm to set
	 */
	public void setColctDttm(String colctDttm) {
		this.colctDttm = colctDttm;
	}

}
