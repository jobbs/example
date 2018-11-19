/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasVstrQtyVo.java
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
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.vo;

public class DbmsSpaceUseRtVo {
	private String checkDatetime;
	private String objName;
	private int cnt;
	private double dbBufferCacheAvg;
	private double dbBufferCacheMax;
	private double dbBufferCacheMin;

	private double dbSpaceUseRtAvg;
	private double dbSpaceUseRtMax;
	private double dbSpaceUseRtMin;

	public String getCheckDatetime() {
		return checkDatetime;
	}

	public void setCheckDatetime(String checkDatetime) {
		this.checkDatetime = checkDatetime;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public double getDbBufferCacheAvg() {
		return dbBufferCacheAvg;
	}

	public void setDbBufferCacheAvg(double dbBufferCacheAvg) {
		this.dbBufferCacheAvg = dbBufferCacheAvg;
	}

	public double getDbBufferCacheMax() {
		return dbBufferCacheMax;
	}

	public void setDbBufferCacheMax(double dbBufferCacheMax) {
		this.dbBufferCacheMax = dbBufferCacheMax;
	}

	public double getDbBufferCacheMin() {
		return dbBufferCacheMin;
	}

	public void setDbBufferCacheMin(double dbBufferCacheMin) {
		this.dbBufferCacheMin = dbBufferCacheMin;
	}

	public double getDbSpaceUseRtAvg() {
		return dbSpaceUseRtAvg;
	}

	public void setDbSpaceUseRtAvg(double dbSpaceUseRtAvg) {
		this.dbSpaceUseRtAvg = dbSpaceUseRtAvg;
	}

	public double getDbSpaceUseRtMax() {
		return dbSpaceUseRtMax;
	}

	public void setDbSpaceUseRtMax(double dbSpaceUseRtMax) {
		this.dbSpaceUseRtMax = dbSpaceUseRtMax;
	}

	public double getDbSpaceUseRtMin() {
		return dbSpaceUseRtMin;
	}

	public void setDbSpaceUseRtMin(double dbSpaceUseRtMin) {
		this.dbSpaceUseRtMin = dbSpaceUseRtMin;
	}
}
