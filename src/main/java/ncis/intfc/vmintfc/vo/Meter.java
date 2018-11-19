/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Meter.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 2. 1.
 * @lastmodified 2017. 2. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 2. 1.     selim         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 통계정보 리소스
 *
 * @author ihjang
 *
 */
public class Meter
{
	private String timestamp;
	private String usageCpu;
	private String totalMemory;
	private String usedMemory;
	private String usageMemroy;
	private String totalVolume;
	private String inNet;
	private String outNet;

	/**
	 * @return the timestamp
	 */
	public String getTimestamp()
	{
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	/**
	 * @return the usageCpu
	 */
	public String getUsageCpu()
	{
		return usageCpu;
	}

	/**
	 * @param usageCpu
	 *            the usageCpu to set
	 */
	public void setUsageCpu(String usageCpu)
	{
		this.usageCpu = usageCpu;
	}

	/**
	 * @return the totalMemory
	 */
	public String getTotalMemory()
	{
		return totalMemory;
	}

	/**
	 * @param totalMemory
	 *            the totalMemory to set
	 */
	public void setTotalMemory(String totalMemory)
	{
		this.totalMemory = totalMemory;
	}

	/**
	 * @return the usedMemory
	 */
	public String getUsedMemory()
	{
		return usedMemory;
	}

	/**
	 * @param usedMemory
	 *            the usedMemory to set
	 */
	public void setUsedMemory(String usedMemory)
	{
		this.usedMemory = usedMemory;
	}

	/**
	 * @return the usageMemroy
	 */
	public String getUsageMemroy()
	{
		return usageMemroy;
	}

	/**
	 * @param usageMemroy
	 *            the usageMemroy to set
	 */
	public void setUsageMemroy(String usageMemroy)
	{
		this.usageMemroy = usageMemroy;
	}

	/**
	 * @return the totalVolume
	 */
	public String getTotalVolume()
	{
		return totalVolume;
	}

	/**
	 * @param totalVolume
	 *            the totalVolume to set
	 */
	public void setTotalVolume(String totalVolume)
	{
		this.totalVolume = totalVolume;
	}

	/**
	 * @return the inNet
	 */
	public String getInNet()
	{
		return inNet;
	}

	/**
	 * @param inNet
	 *            the inNet to set
	 */
	public void setInNet(String inNet)
	{
		this.inNet = inNet;
	}

	/**
	 * @return the outNet
	 */
	public String getOutNet()
	{
		return outNet;
	}

	/**
	 * @param outNet
	 *            the outNet to set
	 */
	public void setOutNet(String outNet)
	{
		this.outNet = outNet;
	}

	public String toString()
	{
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.JSON_STYLE);
	}
}
