/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmSearchVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최경철
 *
 */
public class MngmObjVmSearchVo extends CommonSearchVo {

	// 검색조건용
	private String searchRegionId;
	private String searchNetClCd;
	private String searchInsttId;
	private String searchInsttNm;
	private String searchPackgMngTrgtYn;

	// 페이지간 param
	private String regionId;
	private String netClCd;
	private String insttId;

	private List<BigDecimal> updtCheck;

	/**
	 * @return the searchRegionId
	 */
	public String getSearchRegionId() {
		return searchRegionId;
	}

	/**
	 * @param searchRegionId
	 *            the searchRegionId to set
	 */
	public void setSearchRegionId(String searchRegionId) {
		this.searchRegionId = searchRegionId;
	}

	/**
	 * @return the searchNetId
	 */
	public String getSearchNetClCd() {
		return searchNetClCd;
	}

	/**
	 * @param searchNetId
	 *            the searchNetId to set
	 */
	public void setSearchNetClCd(String searchNetClCd) {
		this.searchNetClCd = searchNetClCd;
	}

	/**
	 * @return the searchInsttId
	 */
	public String getSearchInsttId() {
		return searchInsttId;
	}

	/**
	 * @param searchInsttId
	 *            the searchInsttId to set
	 */
	public void setSearchInsttId(String searchInsttId) {
		this.searchInsttId = searchInsttId;
	}

	/**
	 * @return the searchInsttNm
	 */
	public String getSearchInsttNm() {
		return searchInsttNm;
	}

	/**
	 * @param searchInsttNm
	 *            the searchInsttNm to set
	 */
	public void setSearchInsttNm(String searchInsttNm) {
		this.searchInsttNm = searchInsttNm;
	}

	/**
	 * @return the searchPackgMngTrgtYn
	 */
	public String getSearchPackgMngTrgtYn() {
		return searchPackgMngTrgtYn;
	}

	/**
	 * @param searchPackgMngTrgtYn
	 *            the searchPackgMngTrgtYn to set
	 */
	public void setSearchPackgMngTrgtYn(String searchPackgMngTrgtYn) {
		this.searchPackgMngTrgtYn = searchPackgMngTrgtYn;
	}

	/**
	 * @return the updtCheck
	 */
	public List<BigDecimal> getUpdtCheck() {
		return updtCheck;
	}

	/**
	 * @param updtCheck
	 *            the updtCheck to set
	 */
	public void setUpdtCheck(List<BigDecimal> updtCheck) {
		this.updtCheck = updtCheck;
	}

	public boolean isSysadm() {
		return "SYSADM".equals(RequestUtils.getUser().getSuperposedUserRole());
	}

	public boolean isOpradm() {
		return "OPRADM".equals(RequestUtils.getUser().getSuperposedUserRole());
	}

	public String getUserId() {
		return RequestUtils.getUserId();
	}

	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}

	/**
	 * @param netClCd
	 *            the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	/**
	 * @return the insttId
	 */
	public String getInsttId() {
		return insttId;
	}

	/**
	 * @param insttId
	 *            the insttId to set
	 */
	public void setInsttId(String insttId) {
		this.insttId = insttId;
	}

	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

}
