/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServStteCvo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.servstte.vo;

import java.util.List;
import ncis.cmn.vo.CommonSearchVo;

public class ServStteCvo extends CommonSearchVo {

	private List<CntServStteVo> cntServStteList;
	private List<PmStteVo> pmStteList;
	private List<VmStteVo> vmStteList;
	private List<VrlzStteVo> vrlzStteList;
	private List<CloudJobVo> cloudJobList;

	/**
	 * @return the cntServStteList
	 */
	public List<CntServStteVo> getCntServStteList() {
		return cntServStteList;
	}
	/**
	 * @param cntServStteList the cntServStteList to set
	 */
	public void setCntServStteList(List<CntServStteVo> cntServStteList) {
		this.cntServStteList = cntServStteList;
	}
	/**
	 * @return the pmStteList
	 */
	public List<PmStteVo> getPmStteList() {
		return pmStteList;
	}
	/**
	 * @param pmStteList the pmStteList to set
	 */
	public void setPmStteList(List<PmStteVo> pmStteList) {
		this.pmStteList = pmStteList;
	}
	/**
	 * @return the vmStteList
	 */
	public List<VmStteVo> getVmStteList() {
		return vmStteList;
	}
	/**
	 * @param vmStteList the vmStteList to set
	 */
	public void setVmStteList(List<VmStteVo> vmStteList) {
		this.vmStteList = vmStteList;
	}
	/**
	 * @return the vrlzStteList
	 */
	public List<VrlzStteVo> getVrlzStteList() {
		return vrlzStteList;
	}
	/**
	 * @param vrlzStteList the vrlzStteList to set
	 */
	public void setVrlzStteList(List<VrlzStteVo> vrlzStteList) {
		this.vrlzStteList = vrlzStteList;
	}

	/**
	 * @return the vrlzStteList
	 */
	public List<CloudJobVo> getCloudJobList() {
		return cloudJobList;
	}
	/**
	 * @param vrlzStteList the vrlzStteList to set
	 */
	public void setCloudJobList(List<CloudJobVo> cloudJobList) {
		this.cloudJobList = cloudJobList;
	}




}
