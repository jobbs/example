/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptResStteCvo.java
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

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;

public class GovDeptResStteCvo extends CommonSearchVo {

	private GovDeptResInfoVo govDeptResInfoVo;
	private GovAxCntVo govAxCntVo;

	private List<GovDeptResStteVo> gvDeptResStteList;

	/**
	 * @return the govDeptResInfoVo
	 */
	public GovDeptResInfoVo getGovDeptResInfoVo()
	{
		return govDeptResInfoVo;
	}

	/**
	 * @param govDeptResInfoVo the govDeptResInfoVo to set
	 */
	public void setGovDeptResInfoVo(GovDeptResInfoVo govDeptResInfoVo)
	{
		this.govDeptResInfoVo = govDeptResInfoVo;
	}

	/**
	 * @return the govDeptHwResVo
	 */
	public GovAxCntVo getGovAxCntVo() {
		return govAxCntVo;
	}

	/**
	 * @param govDeptHwResVo the govDeptHwResVo to set
	 */
	public void setGovAxCntVo(GovAxCntVo govAxCntVo) {
		this.govAxCntVo = govAxCntVo;
	}

	/**
	 * @return the gvDeptResStteList
	 */
	public List<GovDeptResStteVo> getGvDeptResStteList() {
		return gvDeptResStteList;
	}

	/**
	 * @param gvDeptResStteList the gvDeptResStteList to set
	 */
	public void setGvDeptResStteList(List<GovDeptResStteVo> gvDeptResStteList) {
		this.gvDeptResStteList = gvDeptResStteList;
	}



}
