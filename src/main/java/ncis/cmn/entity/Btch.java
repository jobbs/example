/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Btch.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     정승용         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import ncis.cmn.entity.couch.CmnCouchVo;

/**
 * @author 정승용
 *
 */
public class Btch extends CmnCouchVo {

    /**
     * 배치명
     */
    private String batchName;

    /**
     * 배치주기 순번
     */
    private String seq;

    /**
     * 삭제주기 순번
     */
    private String delSeq;

    /**
     * cronExpression
     */
    private String cronExpression;

	/**
     * 실행시점월
     */
    private String exeTimeMonth;

    /**
     * 실행시점 일
     */
    private String exeTimeDay;

    /**
     * 실행시점 시
     */
    private String exeTimeHour;

    /**
     * 실행시점 분
     */
    private String exeTimeMinute;

	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}

	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the delSeq
	 */
	public String getDelSeq() {
		return delSeq;
	}

	/**
	 * @param delSeq the delSeq to set
	 */
	public void setDelSeq(String delSeq) {
		this.delSeq = delSeq;
	}

	/**
	 * @return the cronExpression
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * @param cronExpression the cronExpression to set
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * @return the exeTimeMonth
	 */
	public String getExeTimeMonth() {
		return exeTimeMonth;
	}

	/**
	 * @param exeTimeMonth the exeTimeMonth to set
	 */
	public void setExeTimeMonth(String exeTimeMonth) {
		this.exeTimeMonth = exeTimeMonth;
	}

	/**
	 * @return the exeTimeDay
	 */
	public String getExeTimeDay() {
		return exeTimeDay;
	}

	/**
	 * @param exeTimeDay the exeTimeDay to set
	 */
	public void setExeTimeDay(String exeTimeDay) {
		this.exeTimeDay = exeTimeDay;
	}

	/**
	 * @return the exeTimeHour
	 */
	public String getExeTimeHour() {
		return exeTimeHour;
	}

	/**
	 * @param exeTimeHour the exeTimeHour to set
	 */
	public void setExeTimeHour(String exeTimeHour) {
		this.exeTimeHour = exeTimeHour;
	}

	/**
	 * @return the exeTimeMinute
	 */
	public String getExeTimeMinute() {
		return exeTimeMinute;
	}

	/**
	 * @param exeTimeMinute the exeTimeMinute to set
	 */
	public void setExeTimeMinute(String exeTimeMinute) {
		this.exeTimeMinute = exeTimeMinute;
	}

}
