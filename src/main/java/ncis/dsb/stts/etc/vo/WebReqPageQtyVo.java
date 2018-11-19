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



public class WebReqPageQtyVo{
	private String checkDatetime;
	private String objName;
	private int cnt;
	private int reqPageMax;
	private int reqPageMin;
	private int reqPageAvg;
	private int hitMax;
	private int hitMin;
	private int hitAvg;

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
	public int getReqPageMax() {
		return reqPageMax;
	}
	public void setReqPageMax(int reqPageMax) {
		this.reqPageMax = reqPageMax;
	}
	public int getReqPageMin() {
		return reqPageMin;
	}
	public void setReqPageMin(int reqPageMin) {
		this.reqPageMin = reqPageMin;
	}
	public int getReqPageAvg() {
		return reqPageAvg;
	}
	public void setReqPageAvg(int reqPageAvg) {
		this.reqPageAvg = reqPageAvg;
	}
	public int getHitMax() {
		return hitMax;
	}
	public void setHitMax(int hitMax) {
		this.hitMax = hitMax;
	}
	public int getHitMin() {
		return hitMin;
	}
	public void setHitMin(int hitMin) {
		this.hitMin = hitMin;
	}
	public int getHitAvg() {
		return hitAvg;
	}
	public void setHitAvg(int hitAvg) {
		this.hitAvg = hitAvg;
	}
}
