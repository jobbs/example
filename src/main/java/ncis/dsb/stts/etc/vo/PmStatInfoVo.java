/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.vo;

import java.math.BigDecimal;


public class PmStatInfoVo {

	//센터명
	private String regionNm;
	//물리서버구성ID
	private String  pmCompId;
	//존명
	private String zoneNm;
	//자원풀명
	private String clstrNm;
	// 평균 보유량 vCore
	private BigDecimal avgVcorQty;
	// 평균 보유량  메모리
	private BigDecimal avgMemCapa;
	// 평균 할당량 CPU 용량
	private BigDecimal avgAsgnVcorQty;
	// 평균할당량 메모리 용량
	private BigDecimal avgAsgnMemCapa;
	//최빈시 CPU 사용율
	private BigDecimal buzAvgCpuUseRt;
	//최빈시 Mem 사용율
	private BigDecimal buzAvgMemUseRt;

	//평균 CPU 사용율
	private BigDecimal avgCpuUseRt;
	//평균 Mem 사용율
	private BigDecimal avgMemUseRt;

	//최대 CPU사용율
	private BigDecimal maxAvgCpuUseRt;
	//최대 Mem사용율
	private BigDecimal maxAvgMemUseRt;
	// 비고
	private String rmk;
	/**
	 * @return the regionNm
	 */
	public String getRegionNm()
	{
		return regionNm;
	}
	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm)
	{
		this.regionNm = regionNm;
	}
	/**
	 * @return the pmCompId
	 */
	public String getPmCompId()
	{
		return pmCompId;
	}
	/**
	 * @param pmCompId the pmCompId to set
	 */
	public void setPmCompId(String pmCompId)
	{
		this.pmCompId = pmCompId;
	}
	/**
	 * @return the zoneNm
	 */
	public String getZoneNm()
	{
		return zoneNm;
	}
	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm)
	{
		this.zoneNm = zoneNm;
	}
	/**
	 * @return the clstrNm
	 */
	public String getClstrNm()
	{
		return clstrNm;
	}
	/**
	 * @param clstrNm the clstrNm to set
	 */
	public void setClstrNm(String clstrNm)
	{
		this.clstrNm = clstrNm;
	}
	/**
	 * @return the avgVcorQty
	 */
	public BigDecimal getAvgVcorQty()
	{
		return avgVcorQty;
	}
	/**
	 * @param avgVcorQty the avgVcorQty to set
	 */
	public void setAvgVcorQty(BigDecimal avgVcorQty)
	{
		this.avgVcorQty = avgVcorQty;
	}
	/**
	 * @return the avgMemSumCapa
	 */
	public BigDecimal getAvgMemCapa()
	{
		return avgMemCapa;
	}
	/**
	 * @param avgMemSumCapa the avgMemSumCapa to set
	 */
	public void setAvgMemCapa(BigDecimal avgMemSumCapa)
	{
		this.avgMemCapa = avgMemSumCapa;
	}
	/**
	 * @return the avgAsgnVcorQty
	 */
	public BigDecimal getAvgAsgnVcorQty()
	{
		return avgAsgnVcorQty;
	}
	/**
	 * @param avgAsgnVcorQty the avgAsgnVcorQty to set
	 */
	public void setAvgAsgnVcorQty(BigDecimal avgAsgnVcorQty)
	{
		this.avgAsgnVcorQty = avgAsgnVcorQty;
	}
	/**
	 * @return the avgAsgnMemCapa
	 */
	public BigDecimal getAvgAsgnMemCapa()
	{
		return avgAsgnMemCapa;
	}
	/**
	 * @param avgAsgnMemCapa the avgAsgnMemCapa to set
	 */
	public void setAvgAsgnMemCapa(BigDecimal avgAsgnMemCapa)
	{
		this.avgAsgnMemCapa = avgAsgnMemCapa;
	}
	/**
	 * @return the avgCpuUseRt
	 */
	public BigDecimal getAvgCpuUseRt()
	{
		return avgCpuUseRt;
	}
	/**
	 * @param avgCpuUseRt the avgCpuUseRt to set
	 */
	public void setAvgCpuUseRt(BigDecimal avgCpuUseRt)
	{
		this.avgCpuUseRt = avgCpuUseRt;
	}
	/**
	 * @return the avgMemUseRt
	 */
	public BigDecimal getAvgMemUseRt()
	{
		return avgMemUseRt;
	}
	/**
	 * @param avgMemUseRt the avgMemUseRt to set
	 */
	public void setAvgMemUseRt(BigDecimal avgMemUseRt)
	{
		this.avgMemUseRt = avgMemUseRt;
	}
	/**
	 * @return the buzAvgCpuUseRt
	 */
	public BigDecimal getBuzAvgCpuUseRt()
	{
		return buzAvgCpuUseRt;
	}
	/**
	 * @param buzAvgCpuUseRt the buzAvgCpuUseRt to set
	 */
	public void setBuzAvgCpuUseRt(BigDecimal buzAvgCpuUseRt)
	{
		this.buzAvgCpuUseRt = buzAvgCpuUseRt;
	}
	/**
	 * @return the buzAvgMemUseRt
	 */
	public BigDecimal getBuzAvgMemUseRt()
	{
		return buzAvgMemUseRt;
	}
	/**
	 * @param buzAvgMemUseRt the buzAvgMemUseRt to set
	 */
	public void setBuzAvgMemUseRt(BigDecimal buzAvgMemUseRt)
	{
		this.buzAvgMemUseRt = buzAvgMemUseRt;
	}
	/**
	 * @return the maxAvgCpuUseRt
	 */
	public BigDecimal getMaxAvgCpuUseRt()
	{
		return maxAvgCpuUseRt;
	}
	/**
	 * @param maxAvgCpuUseRt the maxAvgCpuUseRt to set
	 */
	public void setMaxAvgCpuUseRt(BigDecimal maxAvgCpuUseRt)
	{
		this.maxAvgCpuUseRt = maxAvgCpuUseRt;
	}
	/**
	 * @return the maxAvgMemUseRt
	 */
	public BigDecimal getMaxAvgMemUseRt()
	{
		return maxAvgMemUseRt;
	}
	/**
	 * @param maxAvgMemUseRt the maxAvgMemUseRt to set
	 */
	public void setMaxAvgMemUseRt(BigDecimal maxAvgMemUseRt)
	{
		this.maxAvgMemUseRt = maxAvgMemUseRt;
	}
	/**
	 * @return the rmk
	 */
	public String getRmk()
	{
		return rmk;
	}
	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk)
	{
		this.rmk = rmk;
	}


}
