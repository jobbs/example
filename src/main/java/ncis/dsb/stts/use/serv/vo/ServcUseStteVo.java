/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServcUseStteVo.java
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
 */

package ncis.dsb.stts.use.serv.vo;


public class ServcUseStteVo  {
	private String mm;

	private String quarter;

	private String institutionId;
	private String jobId;
	private String tot;
	private String linux;
	private String win;
	private String hp;
	private String aix;
	private Long lastVcoreQty;
	private Long lastMemSumCapa;
	private Long lastStrgSumCapa;
	private Long cpuAsgnCapa;
	private Long memTotCapa;
	private Long strgTotCapa;

	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}
	/**
	 * @param mm the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
	}

	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the tot
	 */
	public String getTot() {
		return tot;
	}
	/**
	 * @param tot the tot to set
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	/**
	 * @return the linux
	 */
	public String getLinux() {
		return linux;
	}
	/**
	 * @param linux the linux to set
	 */
	public void setLinux(String linux) {
		this.linux = linux;
	}
	/**
	 * @return the win
	 */
	public String getWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public void setWin(String win) {
		this.win = win;
	}
	/**
	 * @return the hp
	 */
	public String getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(String hp) {
		this.hp = hp;
	}
	/**
	 * @return the aix
	 */
	public String getAix() {
		return aix;
	}
	/**
	 * @param aix the aix to set
	 */
	public void setAix(String aix) {
		this.aix = aix;
	}
	/**
	 * @return the lastVcoreQty
	 */
	public Long getLastVcoreQty() {
		return lastVcoreQty;
	}
	/**
	 * @param lastVcoreQty the lastVcoreQty to set
	 */
	public void setLastVcoreQty(Long lastVcoreQty) {
		this.lastVcoreQty = lastVcoreQty;
	}
	/**
	 * @return the lastMemSumCapa
	 */
	public Long getLastMemSumCapa() {
		return lastMemSumCapa;
	}
	/**
	 * @param lastMemSumCapa the lastMemSumCapa to set
	 */
	public void setLastMemSumCapa(Long lastMemSumCapa) {
		this.lastMemSumCapa = lastMemSumCapa;
	}
	/**
	 * @return the lastStrgSumCapa
	 */
	public Long getLastStrgSumCapa() {
		return lastStrgSumCapa;
	}
	/**
	 * @param lastStrgSumCapa the lastStrgSumCapa to set
	 */
	public void setLastStrgSumCapa(Long lastStrgSumCapa) {
		this.lastStrgSumCapa = lastStrgSumCapa;
	}
	/**
	 * @return the quarter
	 */
	public String getQuarter() {
		return quarter;
	}
	/**
	 * @param quarter the quarter to set
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * @return the cpuAsgnCapa
	 */
	public Long getCpuAsgnCapa() {
		return cpuAsgnCapa;
	}
	/**
	 * @param cpuAsgnCapa the cpuAsgnCapa to set
	 */
	public void setCpuAsgnCapa(Long cpuAsgnCapa) {
		this.cpuAsgnCapa = cpuAsgnCapa;
	}
	/**
	 * @return the memTotCapa
	 */
	public Long getMemTotCapa() {
		return memTotCapa;
	}
	/**
	 * @param memTotCapa the memTotCapa to set
	 */
	public void setMemTotCapa(Long memTotCapa) {
		this.memTotCapa = memTotCapa;
	}
	/**
	 * @return the strgTotCapa
	 */
	public Long getStrgTotCapa() {
		return strgTotCapa;
	}
	/**
	 * @param strgTotCapa the strgTotCapa to set
	 */
	public void setStrgTotCapa(Long strgTotCapa) {
		this.strgTotCapa = strgTotCapa;
	}
}
