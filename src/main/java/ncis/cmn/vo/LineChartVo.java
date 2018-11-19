/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteVo.java
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
package ncis.cmn.vo;


/**
 * 개별 사용율 차트 팝업에서 사용하기 위한 사용률정보 데이터 객체
 * @author ihjang
 *
 */
public class LineChartVo {

	public String time;	// 기준 시간
	public String cpuUseRatio; // cpu 사용률
	public String memUseRatio; // mem 사용률
	public String sanUseRatio; // 디스크 사용률
	public String inTrafficUsed; // 트래픽 사용량
	public String outTrafficUsed; // 트래픽 사용량

	/**
	 * @return the time
	 */
	public String getTime()
	{
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time)
	{
		this.time = time;
	}
	/**
	 * @return the cpuUseRatio
	 */
	public String getCpuUseRatio()
	{
		return cpuUseRatio;
	}
	/**
	 * @param cpuUseRatio the cpuUseRatio to set
	 */
	public void setCpuUseRatio(String cpuUseRatio)
	{
		this.cpuUseRatio = cpuUseRatio;
	}
	/**
	 * @return the memUseRatio
	 */
	public String getMemUseRatio()
	{
		return memUseRatio;
	}
	/**
	 * @param memUseRatio the memUseRatio to set
	 */
	public void setMemUseRatio(String memUseRatio)
	{
		this.memUseRatio = memUseRatio;
	}
	/**
	 * @return the sanUseRatio
	 */
	public String getSanUseRatio()
	{
		return sanUseRatio;
	}
	/**
	 * @param sanUseRatio the sanUseRatio to set
	 */
	public void setSanUseRatio(String sanUseRatio)
	{
		this.sanUseRatio = sanUseRatio;
	}
	/**
	 * @return the inTrafficUsed
	 */
	public String getInTrafficUsed()
	{
		return inTrafficUsed;
	}
	/**
	 * @param inTrafficUsed the inTrafficUsed to set
	 */
	public void setInTrafficUsed(String inTrafficUsed)
	{
		this.inTrafficUsed = inTrafficUsed;
	}
	/**
	 * @return the outTrafficUsed
	 */
	public String getOutTrafficUsed()
	{
		return outTrafficUsed;
	}
	/**
	 * @param outTrafficUsed the outTrafficUsed to set
	 */
	public void setOutTrafficUsed(String outTrafficUsed)
	{
		this.outTrafficUsed = outTrafficUsed;
	}
}
