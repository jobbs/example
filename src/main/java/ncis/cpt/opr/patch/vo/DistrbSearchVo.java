/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 23.
 * @lastmodified 2017. 1. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 23.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class DistrbSearchVo extends CommonSearchVo {

	private String searchTicketId;
	private String searchDistrbReasn;
	private String searchVmCompId;
	/**
	 * @return the searchTicketId
	 */
	public String getSearchTicketId() {
		return searchTicketId;
	}
	/**
	 * @param searchTicketId the searchTicketId to set
	 */
	public void setSearchTicketId(String searchTicketId) {
		this.searchTicketId = searchTicketId;
	}
	/**
	 * @return the searchDistrbReasn
	 */
	public String getSearchDistrbReasn() {
		return searchDistrbReasn;
	}
	/**
	 * @param searchDistrbReasn the searchDistrbReasn to set
	 */
	public void setSearchDistrbReasn(String searchDistrbReasn) {
		this.searchDistrbReasn = searchDistrbReasn;
	}
	/**
	 * @return the searchVmCompId
	 */
	public String getSearchVmCompId() {
		return searchVmCompId;
	}
	/**
	 * @param searchVmCompId the searchVmCompId to set
	 */
	public void setSearchVmCompId(String searchVmCompId) {
		this.searchVmCompId = searchVmCompId;
	}



}
