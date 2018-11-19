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




public class PoolStatInfoVo {


	//센터명
	private String regionNm;
	//가상화종류
	private String 	virtualType;
	//망명
	private String 	netNm;
	//자원풀 명
	private String 	rsrcPoolNm;
	//물리서버수
	private int 	pmCnt;
	//가상서버수
	private int vmCnt;
	//가상화율
	private double virtRate;
	//CPU 총보유량
	private double totVcore;
	// MEM 총 보유량
	private double totMem;
	// SAN 총 보유량
	private double totStrg;
	// CPU 할당량
	private double asgnVcore;
	// MEM 할당량
	private double asgnMem;
	// SAN 할당량
	private double asgnStrg;

	// CPU 할당률
	private double asgnVcoreRate;
	// MEM 할당률
	private double asgnMemRate;
	// SAN 할당률
	private double asgnStrgRate;

	//비고
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
	 * @return the virtualType
	 */
	public String getVirtualType()
	{
		return virtualType;
	}
	/**
	 * @param virtualType the virtualType to set
	 */
	public void setVirtualType(String virtualType)
	{
		this.virtualType = virtualType;
	}
	/**
	 * @return the netNm
	 */
	public String getNetNm()
	{
		return netNm;
	}
	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm)
	{
		this.netNm = netNm;
	}
	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm()
	{
		return rsrcPoolNm;
	}
	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm)
	{
		this.rsrcPoolNm = rsrcPoolNm;
	}
	/**
	 * @return the pmCnt
	 */
	public int getPmCnt()
	{
		return pmCnt;
	}
	/**
	 * @param pmCnt the pmCnt to set
	 */
	public void setPmCnt(int pmCnt)
	{
		this.pmCnt = pmCnt;
	}

	/**
	 * @param pmCnt the pmCnt to set
	 */
	public void addPmCnt(int pmCnt)
	{
		this.pmCnt += pmCnt;
	}

	/**
	 * @return the vmCnt
	 */
	public int getVmCnt()
	{
		return vmCnt;
	}
	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void setVmCnt(int vmCnt)
	{
		this.vmCnt = vmCnt;
	}

	/**
	 * @param vmCnt the vmCnt to set
	 */
	public void addVmCnt(int vmCnt)
	{
		this.vmCnt += vmCnt;
	}
	/**
	 * @return the totVcore
	 */
	public double getTotVcore()
	{
		return totVcore;
	}
	/**
	 * @param totVcore the totVcore to set
	 */
	public void setTotVcore(double totVcore)
	{
		this.totVcore = totVcore;
	}
	/**
	 * @param totVcore the totVcore to set
	 */
	public void addTotVcore(double totVcore)
	{
		this.totVcore += totVcore;
	}
	/**
	 * @return the totMem
	 */
	public double getTotMem()
	{
		return totMem;
	}
	/**
	 * @param totMem the totMem to set
	 */
	public void setTotMem(double totMem)
	{
		this.totMem = totMem;
	}
	/**
	 * @param totMem the totMem to set
	 */
	public void addTotMem(double totMem)
	{
		this.totMem += totMem;
	}
	/**
	 * @return the totStrg
	 */
	public double getTotStrg()
	{
		return totStrg;
	}
	/**
	 * @param totStrg the totStrg to set
	 */
	public void setTotStrg(double totStrg)
	{
		this.totStrg = totStrg;
	}
	/**
	 * @param totStrg the totStrg to set
	 */
	public void addTotStrg(double totStrg)
	{
		this.totStrg += totStrg;
	}
	/**
	 * @return the asgnVcore
	 */
	public double getAsgnVcore()
	{
		return asgnVcore;
	}
	/**
	 * @param asgnVcore the asgnVcore to set
	 */
	public void setAsgnVcore(double asgnVcore)
	{
		this.asgnVcore = asgnVcore;
	}
	/**
	 * @param asgnVcore the asgnVcore to set
	 */
	public void addAsgnVcore(double asgnVcore)
	{
		this.asgnVcore += asgnVcore;
	}
	/**
	 * @return the asgnMem
	 */
	public double getAsgnMem()
	{
		return asgnMem;
	}
	/**
	 * @param asgnMem the asgnMem to set
	 */
	public void setAsgnMem(double asgnMem)
	{
		this.asgnMem = asgnMem;
	}
	/**
	 * @param asgnMem the asgnMem to set
	 */
	public void addAsgnMem(double asgnMem)
	{
		this.asgnMem += asgnMem;
	}
	/**
	 * @return the asgnStrg
	 */
	public double getAsgnStrg()
	{
		return asgnStrg;
	}
	/**
	 * @param asgnStrg the asgnStrg to set
	 */
	public void setAsgnStrg(double asgnStrg)
	{
		this.asgnStrg = asgnStrg;
	}
	/**
	 * @param asgnStrg the asgnStrg to set
	 */
	public void addAsgnStrg(double asgnStrg)
	{
		this.asgnStrg += asgnStrg;
	}
	/**
	 * @return the virtRate
	 */
	public double getVirtRate()
	{
		if(pmCnt > 0 )
		{
			virtRate = Math.round(vmCnt / pmCnt * 100)/Math.pow(10,2);
		}

		return virtRate;
	}
	/**
	 * @return the asgnVcoreRate
	 */
	public double getAsgnVcoreRate()
	{
		if(totVcore > 0 )
		{
			asgnVcoreRate = Math.round(asgnVcore / totVcore * 100)/Math.pow(10,2);
		}

		return asgnVcoreRate;
	}

	/**
	 * @return the asgnMemRate
	 */
	public double getAsgnMemRate()
	{
		if(totMem > 0 )
		{
			asgnMemRate = Math.round(asgnMem / totMem * 100)/Math.pow(10,2);
		}

		return asgnMemRate;
	}

	/**
	 * @return the asgnStrgRate
	 */
	public double getAsgnStrgRate()
	{
		if(totStrg > 0 )
		{
			asgnStrgRate = Math.round(asgnStrg / totStrg * 100)/Math.pow(10,2);
		}

		return asgnStrgRate;
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
