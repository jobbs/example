/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPackageVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.seoa.vo;

import java.util.List;

/**
 * @author ShinKeeBong
 *
 */
public class VmPackageVO {
	private String machineIp;          //타겟VM IP
	private List<PackageVO> packages;  //패키지 배열


	public String getMachineIp() {
		return machineIp;
	}
	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}
	public List<PackageVO> getPackages() {
		return packages;
	}
	public void setPackages(List<PackageVO> packages) {
		this.packages = packages;
	}


}
