/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteCvo.java
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

public class ClstResStteCvo extends CommonSearchVo {

	private PmResInfoVo pmResInfoVo;
	private VmResInfoVo vmResInfoVo;
	private AxCntVo axCntVo;
	private List<ClstResInfoVo> clstResInfoList;
	/**
	 * @return the pmResInfoVo
	 */
	public PmResInfoVo getPmResInfoVo()
	{
		return pmResInfoVo;
	}
	/**
	 * @param pmResInfoVo the pmResInfoVo to set
	 */
	public void setPmResInfoVo(PmResInfoVo pmResInfoVo)
	{
		this.pmResInfoVo = pmResInfoVo;
	}
	/**
	 * @return the vmResInfoVo
	 */
	public VmResInfoVo getVmResInfoVo()
	{
		return vmResInfoVo;
	}
	/**
	 * @param vmResInfoVo the vmResInfoVo to set
	 */
	public void setVmResInfoVo(VmResInfoVo vmResInfoVo)
	{
		this.vmResInfoVo = vmResInfoVo;
	}
	/**
	 * @return the axCntVo
	 */
	public AxCntVo getAxCntVo()
	{
		return axCntVo;
	}
	/**
	 * @param axCntVo the axCntVo to set
	 */
	public void setAxCntVo(AxCntVo axCntVo)
	{
		this.axCntVo = axCntVo;
	}
	/**
	 * @return the clstResInfoList
	 */
	public List<ClstResInfoVo> getClstResInfoList()
	{
		return clstResInfoList;
	}
	/**
	 * @param clstResInfoList the clstResInfoList to set
	 */
	public void setClstResInfoList(List<ClstResInfoVo> clstResInfoList)
	{
		this.clstResInfoList = clstResInfoList;
	}

}
