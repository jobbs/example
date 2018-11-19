/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewaySearchVo.java
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

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박봉춘
 *
 */
public class GatewaySearchVo extends CommonSearchVo {

	private String searchName;

	private String searchHOST;

	private String searchregionId;

	/**
	 * API-Gateway 접속정보 명칭
	 * @return the searchName
	 */
	public String getSearchName() {
		return searchName;
	}

	/**
	 * API-Gateway 접속정보 명칭
	 * @param searchName the searchName to set
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/**
	 * API-Gateway 접속정보 HOST
	 * @return the searchHOST
	 */
	public String getSearchHOST() {
		return searchHOST;
	}

	/**
	 * API-Gateway 접속정보 HOST
	 * @param searchHOST the searchHOST to set
	 */
	public void setSearchHOST(String searchHOST) {
		this.searchHOST = searchHOST;
	}

	/**
	 * API-Gateway 접속정보 리전 ID
	 * @return the searchregionId
	 */
	public String getSearchregionId() {
		return searchregionId;
	}

	/**
	 * API-Gateway 접속정보 리전 ID
	 * @param searchregionId the searchregionId to set
	 */
	public void setSearchregionId(String searchregionId) {
		this.searchregionId = searchregionId;
	}


}
