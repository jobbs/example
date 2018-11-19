/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RemoveClusterVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wisecom
 *
 */
public class ModifyVmVmInfoVO {

	@ApiModelProperty(value = "가상서버구성ID", required = true)
	private String vmConfId;     /* 가상서버구성ID   */
	
	
	@ApiModelProperty(value = "변경할 스펙 ID", required = false)
	private BigDecimal specId;	/*변경할 스펙 ID*/
	@ApiModelProperty(value = "가상코어수", required = false)
	private BigDecimal vcore;	/*가상코어수*/
	@ApiModelProperty(value = "메모리", required = false)
	private BigDecimal memory;	/*메모리*/
	@ApiModelProperty(value = "추가디스크사이즈", required = false)
	private BigDecimal addDiskSize;	/*추가디스크사이즈*/
	@ApiModelProperty(value = "공유여부", required = false)
	private String isShare;	/*공유여부*/
	@ApiModelProperty(value = "제거할디스크ID", required = false)
	private BigDecimal vDiskId;	/*제거할디스크ID*/

	

	/**
	 * @return the vmConfId
	 */
	public String getVmConfId() {
		return vmConfId;
	}

	/**
	 * @param vmConfId the vmConfId to set
	 */
	public void setVmConfId(String vmConfId) {
		this.vmConfId = vmConfId;
	}

	/**
	 * @return the specId
	 */
	public BigDecimal getSpecId() {
		return specId;
	}

	/**
	 * @param specId the specId to set
	 */
	public void setSpecId(BigDecimal specId) {
		this.specId = specId;
	}

	/**
	 * @return the vcore
	 */
	public BigDecimal getVcore() {
		return vcore;
	}

	/**
	 * @param vcore the vcore to set
	 */
	public void setVcore(BigDecimal vcore) {
		this.vcore = vcore;
	}

	/**
	 * @return the memory
	 */
	public BigDecimal getMemory() {
		return memory;
	}

	/**
	 * @param memory the memory to set
	 */
	public void setMemory(BigDecimal memory) {
		this.memory = memory;
	}

	/**
	 * @return the addDiskSize
	 */
	public BigDecimal getAddDiskSize() {
		return addDiskSize;
	}

	/**
	 * @param addDiskSize the addDiskSize to set
	 */
	public void setAddDiskSize(BigDecimal addDiskSize) {
		this.addDiskSize = addDiskSize;
	}

	/**
	 * @return the isShare
	 */
	public String getIsShare() {
		return isShare;
	}

	/**
	 * @param isShare the isShare to set
	 */
	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	/**
	 * @return the vDiskId
	 */
	public BigDecimal getvDiskId() {
		return vDiskId;
	}

	/**
	 * @param vDiskId the vDiskId to set
	 */
	public void setvDiskId(BigDecimal vDiskId) {
		this.vDiskId = vDiskId;
	}

	


}
