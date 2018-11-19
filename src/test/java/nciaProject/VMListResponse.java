package nciaProject;

import java.util.List;

public class VMListResponse {
	
	private List<Vm> vmList;
	
	private int vmCount;

	/**
	 * @return the vmList
	 */
	public List<Vm> getVmList() {
		return vmList;
	}

	/**
	 * @param vmList the vmList to set
	 */
	public void setVmList(List<Vm> vmList) {
		this.vmList = vmList;
	}

	/**
	 * @return the vmCount
	 */
	public int getVmCount() {
		return vmCount;
	}

	/**
	 * @param vmCount the vmCount to set
	 */
	public void setVmCount(int vmCount) {
		this.vmCount = vmCount;
	}


	
}
