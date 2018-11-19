package ncis.dsb.cmn.vo;

public class PmResSttsVo {
	private Long lastCpuCorQty;
	private Long lastMemSumCapa;
	private Double lastStrgSumCapa;

	/**
	 * @return the lastCpuCorQty
	 */
	public Long getLastCpuCorQty() {
		return lastCpuCorQty;
	}

	/**
	 * @param lastCpuCorQty
	 *            the lastCpuCorQty to set
	 */
	public void setLastCpuCorQty(Long lastCpuCorQty) {
		this.lastCpuCorQty = lastCpuCorQty;
	}

	/**
	 * @return the lastMemSumCapa
	 */
	public Long getLastMemSumCapa() {
		return lastMemSumCapa;
	}

	/**
	 * @param lastMemSumCapa
	 *            the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(Long lastMemSumCapa) {
		this.lastMemSumCapa = lastMemSumCapa;
	}

	/**
	 * @return the lastStrgSumCapa
	 */
	public Double getLastStrgSumCapa() {
		return lastStrgSumCapa;
	}

	/**
	 * @param lastStrgSumCapa
	 *            the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(Double lastStrgSumCapa) {
		this.lastStrgSumCapa = lastStrgSumCapa;
	}

}
