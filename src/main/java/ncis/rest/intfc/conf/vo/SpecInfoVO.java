/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecInfoVO.java
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
package ncis.rest.intfc.conf.vo;


/**
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class SpecInfoVO {

	private Integer specTypeId;     /* 스펙 ID       */
	private String specTypeName;    /* 스펙 이름     */
	private Integer cpuCores;       /* CPU 코어수    */
	private Integer memorySize;     /* 메모리 사이즈 */
	private String osCode;          /* OS타입        */


	public Integer getSpecTypeId() {
		return specTypeId;
	}
	public void setSpecTypeId(Integer specTypeId) {
		this.specTypeId = specTypeId;
	}
	public String getSpecTypeName() {
		return specTypeName;
	}
	public void setSpecTypeName(String specTypeName) {
		this.specTypeName = specTypeName;
	}
	public Integer getCpuCores() {
		return cpuCores;
	}
	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}
	public Integer getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}
	public String getOsCode() {
		return osCode;
	}
	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}


}
