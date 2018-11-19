/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolVo.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.vo;


public class VmSpecPerPoolVo{
	private long no;
	private String rsrcPoolId;
	private String rsrcPoolNm;
	private int minAvgVcoreQty;
	private double avgAvgVcoreQty;
	private int maxAvgVcoreQty;
	private double minMemSumCapa;
	private double avgMemSumCapa;
	private double maxMemSumCapa;
	private double minStrgSumCapa;
	private double avgStrgSumCapa;
	private double maxStrgSumCapa;
	/**
	 * @return the no
	 */
	public long getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(long no) {
		this.no = no;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	/**
	 * @return the minAvgVcoreQty
	 */
	public int getMinAvgVcoreQty() {
		return minAvgVcoreQty;
	}
	/**
	 * @param minAvgVcoreQty the minAvgVcoreQty to set
	 */
	public void setMinAvgVcoreQty(int minAvgVcoreQty) {
		this.minAvgVcoreQty = minAvgVcoreQty;
	}
	/**
	 * @return the avgAvgVcoreQty
	 */
	public double getAvgAvgVcoreQty() {
		return avgAvgVcoreQty;
	}
	/**
	 * @param avgAvgVcoreQty the avgAvgVcoreQty to set
	 */
	public void setAvgAvgVcoreQty(double avgAvgVcoreQty) {
		this.avgAvgVcoreQty = avgAvgVcoreQty;
	}
	/**
	 * @return the maxAvgVcoreQty
	 */
	public int getMaxAvgVcoreQty() {
		return maxAvgVcoreQty;
	}
	/**
	 * @param maxAvgVcoreQty the maxAvgVcoreQty to set
	 */
	public void setMaxAvgVcoreQty(int maxAvgVcoreQty) {
		this.maxAvgVcoreQty = maxAvgVcoreQty;
	}
	/**
	 * @return the minMemSumCapa
	 */
	public double getMinMemSumCapa() {
		return minMemSumCapa;
	}
	/**
	 * @param minMemSumCapa the minMemSumCapa to set
	 */
	public void setMinMemSumCapa(double minMemSumCapa) {
		this.minMemSumCapa = minMemSumCapa;
	}
	/**
	 * @return the avgMemSumCapa
	 */
	public double getAvgMemSumCapa() {
		return avgMemSumCapa;
	}
	/**
	 * @param avgMemSumCapa the avgMemSumCapa to set
	 */
	public void setAvgMemSumCapa(double avgMemSumCapa) {
		this.avgMemSumCapa = avgMemSumCapa;
	}
	/**
	 * @return the maxMemSumCapa
	 */
	public double getMaxMemSumCapa() {
		return maxMemSumCapa;
	}
	/**
	 * @param maxMemSumCapa the maxMemSumCapa to set
	 */
	public void setMaxMemSumCapa(double maxMemSumCapa) {
		this.maxMemSumCapa = maxMemSumCapa;
	}
	/**
	 * @return the minStrgSumCapa
	 */
	public double getMinStrgSumCapa() {
		return minStrgSumCapa;
	}
	/**
	 * @param minStrgSumCapa the minStrgSumCapa to set
	 */
	public void setMinStrgSumCapa(double minStrgSumCapa) {
		this.minStrgSumCapa = minStrgSumCapa;
	}
	/**
	 * @return the avgStrgSumCapa
	 */
	public double getAvgStrgSumCapa() {
		return avgStrgSumCapa;
	}
	/**
	 * @param avgStrgSumCapa the avgStrgSumCapa to set
	 */
	public void setAvgStrgSumCapa(double avgStrgSumCapa) {
		this.avgStrgSumCapa = avgStrgSumCapa;
	}
	/**
	 * @return the maxStrgSumCapa
	 */
	public double getMaxStrgSumCapa() {
		return maxStrgSumCapa;
	}
	/**
	 * @param maxStrgSumCapa the maxStrgSumCapa to set
	 */
	public void setMaxStrgSumCapa(double maxStrgSumCapa) {
		this.maxStrgSumCapa = maxStrgSumCapa;
	}


}
