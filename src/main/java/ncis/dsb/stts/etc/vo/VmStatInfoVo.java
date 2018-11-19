/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmInfoVo.java
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
package ncis.dsb.stts.etc.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

public class VmStatInfoVo extends CommonSearchVo {

	private String regionNm;
	private String vmConfId;
	private String institutionNm;
	private String jobNm;
	private String vmId;
	private String vmNm;
	private String zoneNm;
	private String creDt;
	private String oprNm;
	private String oprUserNm;
	private String oprUser2Nm;

	private BigDecimal avgCpuVcorQty;
	private BigDecimal avgAsgnVcorQty;
	private BigDecimal avgMemCapa;
	private BigDecimal avgAsgnMemCapa;
	private BigDecimal avgStrgCapa;
	private BigDecimal avgAsgnStrgCapa;

	private BigDecimal avgVcorQtyRat;
	private BigDecimal avgMemCapaRat;

	private BigDecimal buzAsgnVcorQtyRat;
	private BigDecimal buzAsgnMemCapaRat;
	private BigDecimal buzAsgnStrgCapaRat;
	private BigDecimal buzAsgnStrgCapa;

	private BigDecimal maxAsgnVcorQtyRat;
	private BigDecimal maxAsgnMemCapaRat;
	private BigDecimal maxAsgnStrgCapaRat;
	private BigDecimal maxAsgnStrgCapa;
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
	 * @return the vmConfId
	 */
	public String getVmConfId()
	{
		return vmConfId;
	}
	/**
	 * @param vmConfId the vmConfId to set
	 */
	public void setVmConfId(String vmConfId)
	{
		this.vmConfId = vmConfId;
	}
	/**
	 * @return the institutionNm
	 */
	public String getInstitutionNm()
	{
		return institutionNm;
	}
	/**
	 * @param institutionNm the institutionNm to set
	 */
	public void setInstitutionNm(String institutionNm)
	{
		this.institutionNm = institutionNm;
	}
	/**
	 * @return the jobNm
	 */
	public String getJobNm()
	{
		return jobNm;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobNm(String jobNm)
	{
		this.jobNm = jobNm;
	}
	/**
	 * @return the vmId
	 */
	public String getVmId()
	{
		return vmId;
	}
	/**
	 * @param vmId the vmId to set
	 */
	public void setVmId(String vmId)
	{
		this.vmId = vmId;
	}
	/**
	 * @return the vmNm
	 */
	public String getVmNm()
	{
		return vmNm;
	}
	/**
	 * @param vmNm the vmNm to set
	 */
	public void setVmNm(String vmNm)
	{
		this.vmNm = vmNm;
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
	 * @return the creDt
	 */
	public String getCreDt()
	{
		return creDt;
	}
	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt)
	{
		this.creDt = creDt;
	}
	/**
	 * @return the oprNm
	 */
	public String getOprNm()
	{
		return oprNm;
	}
	/**
	 * @param oprNm the oprNm to set
	 */
	public void setOprNm(String oprNm)
	{
		this.oprNm = oprNm;
	}
	/**
	 * @return the oprUserNm
	 */
	public String getOprUserNm()
	{
		return oprUserNm;
	}
	/**
	 * @param oprUserNm the oprUserNm to set
	 */
	public void setOprUserNm(String oprUserNm)
	{
		this.oprUserNm = oprUserNm;
	}
	/**
	 * @return the oprUser2Nm
	 */
	public String getOprUser2Nm()
	{
		return oprUser2Nm;
	}
	/**
	 * @param oprUser2Nm the oprUser2Nm to set
	 */
	public void setOprUser2Nm(String oprUser2Nm)
	{
		this.oprUser2Nm = oprUser2Nm;
	}
	/**
	 * @return the avgCpuCorQty
	 */
	public BigDecimal getAvgCpuVcorQty()
	{
		return avgCpuVcorQty;
	}
	/**
	 * @param avgCpuCorQty the avgCpuCorQty to set
	 */
	public void setAvgCpuVcorQty(BigDecimal avgCpuCorQty)
	{
		this.avgCpuVcorQty = avgCpuCorQty;
	}
	/**
	 * @return the avgMemCapa
	 */
	public BigDecimal getAvgMemCapa()
	{
		return avgMemCapa;
	}
	/**
	 * @param avgMemCapa the avgMemCapa to set
	 */
	public void setAvgMemCapa(BigDecimal avgMemCapa)
	{
		this.avgMemCapa = avgMemCapa;
	}
	/**
	 * @return the avgStrgCapa
	 */
	public BigDecimal getAvgStrgCapa()
	{
		return avgStrgCapa;
	}
	/**
	 * @param avgStrgCapa the avgStrgCapa to set
	 */
	public void setAvgStrgCapa(BigDecimal avgStrgCapa)
	{
		this.avgStrgCapa = avgStrgCapa;
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
	 * @return the avgAsgnStrgCapa
	 */
	public BigDecimal getAvgAsgnStrgCapa()
	{
		return avgAsgnStrgCapa;
	}
	/**
	 * @param avgAsgnStrgCapa the avgAsgnStrgCapa to set
	 */
	public void setAvgAsgnStrgCapa(BigDecimal avgAsgnStrgCapa)
	{
		this.avgAsgnStrgCapa = avgAsgnStrgCapa;
	}
	/**
	 * @return the avgVcorQtyRat
	 */
	public BigDecimal getAvgVcorQtyRat()
	{
		return avgVcorQtyRat;
	}
	/**
	 * @param avgVcorQtyRat the avgVcorQtyRat to set
	 */
	public void setAvgVcorQtyRat(BigDecimal avgVcorQtyRat)
	{
		this.avgVcorQtyRat = avgVcorQtyRat;
	}
	/**
	 * @return the avgMemCapaRat
	 */
	public BigDecimal getAvgMemCapaRat()
	{
		return avgMemCapaRat;
	}
	/**
	 * @param avgMemCapaRat the avgMemCapaRat to set
	 */
	public void setAvgMemCapaRat(BigDecimal avgMemCapaRat)
	{
		this.avgMemCapaRat = avgMemCapaRat;
	}
	/**
	 * @return the buzAsgnVcorQtyRate
	 */
	public BigDecimal getBuzAsgnVcorQtyRat()
	{
		return buzAsgnVcorQtyRat;
	}
	/**
	 * @param buzAsgnVcorQtyRate the buzAsgnVcorQtyRate to set
	 */
	public void setBuzAsgnVcorQtyRat(BigDecimal buzAsgnVcorQtyRat)
	{
		this.buzAsgnVcorQtyRat = buzAsgnVcorQtyRat;
	}
	/**
	 * @return the buzAsgnMemCapaRat
	 */
	public BigDecimal getBuzAsgnMemCapaRat()
	{
		return buzAsgnMemCapaRat;
	}
	/**
	 * @param buzAsgnMemCapaRat the buzAsgnMemCapaRat to set
	 */
	public void setBuzAsgnMemCapaRat(BigDecimal buzAsgnMemCapaRat)
	{
		this.buzAsgnMemCapaRat = buzAsgnMemCapaRat;
	}
	/**
	 * @return the buzAsgnStrgCapaRat
	 */
	public BigDecimal getBuzAsgnStrgCapaRat()
	{
		return buzAsgnStrgCapaRat;
	}
	/**
	 * @param buzAsgnStrgCapaRat the buzAsgnStrgCapaRat to set
	 */
	public void setBuzAsgnStrgCapaRat(BigDecimal buzAsgnStrgCapaRat)
	{
		this.buzAsgnStrgCapaRat = buzAsgnStrgCapaRat;
	}
	/**
	 * @return the buzAsgnStrgCapa
	 */
	public BigDecimal getBuzAsgnStrgCapa()
	{
		return buzAsgnStrgCapa;
	}
	/**
	 * @param buzAsgnStrgCapa the buzAsgnStrgCapa to set
	 */
	public void setBuzAsgnStrgCapa(BigDecimal buzAsgnStrgCapa)
	{
		this.buzAsgnStrgCapa = buzAsgnStrgCapa;
	}
	/**
	 * @return the maxAsgnVcorQtyRat
	 */
	public BigDecimal getMaxAsgnVcorQtyRat()
	{
		return maxAsgnVcorQtyRat;
	}
	/**
	 * @param maxAsgnVcorQtyRat the maxAsgnVcorQtyRat to set
	 */
	public void setMaxAsgnVcorQtyRat(BigDecimal maxAsgnVcorQtyRat)
	{
		this.maxAsgnVcorQtyRat = maxAsgnVcorQtyRat;
	}
	/**
	 * @return the maxAsgnMemCapaRat
	 */
	public BigDecimal getMaxAsgnMemCapaRat()
	{
		return maxAsgnMemCapaRat;
	}
	/**
	 * @param maxAsgnMemCapaRat the maxAsgnMemCapaRat to set
	 */
	public void setMaxAsgnMemCapaRat(BigDecimal maxAsgnMemCapaRat)
	{
		this.maxAsgnMemCapaRat = maxAsgnMemCapaRat;
	}
	/**
	 * @return the maxAsgnStrgCapaRat
	 */
	public BigDecimal getMaxAsgnStrgCapaRat()
	{
		return maxAsgnStrgCapaRat;
	}
	/**
	 * @param maxAsgnStrgCapaRat the maxAsgnStrgCapaRat to set
	 */
	public void setMaxAsgnStrgCapaRat(BigDecimal maxAsgnStrgCapaRat)
	{
		this.maxAsgnStrgCapaRat = maxAsgnStrgCapaRat;
	}
	/**
	 * @return the maxAsgnStrgCapa
	 */
	public BigDecimal getMaxAsgnStrgCapa()
	{
		return maxAsgnStrgCapa;
	}
	/**
	 * @param maxAsgnStrgCapa the maxAsgnStrgCapa to set
	 */
	public void setMaxAsgnStrgCapa(BigDecimal maxAsgnStrgCapa)
	{
		this.maxAsgnStrgCapa = maxAsgnStrgCapa;
	}


}
