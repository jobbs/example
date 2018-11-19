/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchVo.java
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
package ncis.api.stack.btch.vo;

import ncis.cmn.entity.Btch;

/**
 * @author 정승용
 *
 */
public class BtchVo extends Btch {

	/**
     * seq(공통)
     */
	private String[] seqArr;

	/**
     * resversion(공통)
     */
	private String[] rev;

	/**
     * 배치ID(공통)
     */
    private String[] batchId;

    /**
     * 크론표현식-월(배치주기)
     */
    private String[] timeMonth;

    /**
     * 크론표현식-일(배치주기)
     */
    private String[] timeDay;

    /**
     * 크론표현식-시(배치주기)
     */
    private String[] timeHour;

    /**
     * 크론표현식-분(배치주기)
     */
    private String[] timeMinute;

    /**
     * 크론표현식-월(삭제주기)
     */
    private String[] delTimeMonth;

    /**
     * 크론표현식-일(삭제주기)
     */
    private String[] delTimeDay;

    /**
     * 크론표현식-시(삭제주기)
     */
    private String[] delTimeHour;

    /**
     * 크론표현식-분(삭제주기)
     */
    private String[] delTimeMinute;

	/**
	 * @return the seqArr
	 */
	public String[] getSeqArr() {
		return seqArr;
	}

	/**
	 * @param seqArr the seqArr to set
	 */
	public void setSeqArr(String[] seqArr) {
		this.seqArr = seqArr;
	}

	/**
	 * @return the rev
	 */
	public String[] getRev() {
		return rev;
	}

	/**
	 * @param rev the rev to set
	 */
	public void setRev(String[] rev) {
		this.rev = rev;
	}

	/**
	 * @return the batchId
	 */
	public String[] getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(String[] batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the timeMonth
	 */
	public String[] getTimeMonth() {
		return timeMonth;
	}

	/**
	 * @param timeMonth the timeMonth to set
	 */
	public void setTimeMonth(String[] timeMonth) {
		this.timeMonth = timeMonth;
	}

	/**
	 * @return the timeDay
	 */
	public String[] getTimeDay() {
		return timeDay;
	}

	/**
	 * @param timeDay the timeDay to set
	 */
	public void setTimeDay(String[] timeDay) {
		this.timeDay = timeDay;
	}

	/**
	 * @return the timeHour
	 */
	public String[] getTimeHour() {
		return timeHour;
	}

	/**
	 * @param timeHour the timeHour to set
	 */
	public void setTimeHour(String[] timeHour) {
		this.timeHour = timeHour;
	}

	/**
	 * @return the timeMinute
	 */
	public String[] getTimeMinute() {
		return timeMinute;
	}

	/**
	 * @param timeMinute the timeMinute to set
	 */
	public void setTimeMinute(String[] timeMinute) {
		this.timeMinute = timeMinute;
	}

	/**
	 * @return the delTimeMonth
	 */
	public String[] getDelTimeMonth() {
		return delTimeMonth;
	}

	/**
	 * @param delTimeMonth the delTimeMonth to set
	 */
	public void setDelTimeMonth(String[] delTimeMonth) {
		this.delTimeMonth = delTimeMonth;
	}

	/**
	 * @return the delTimeDay
	 */
	public String[] getDelTimeDay() {
		return delTimeDay;
	}

	/**
	 * @param delTimeDay the delTimeDay to set
	 */
	public void setDelTimeDay(String[] delTimeDay) {
		this.delTimeDay = delTimeDay;
	}

	/**
	 * @return the delTimeHour
	 */
	public String[] getDelTimeHour() {
		return delTimeHour;
	}

	/**
	 * @param delTimeHour the delTimeHour to set
	 */
	public void setDelTimeHour(String[] delTimeHour) {
		this.delTimeHour = delTimeHour;
	}

	/**
	 * @return the delTimeMinute
	 */
	public String[] getDelTimeMinute() {
		return delTimeMinute;
	}

	/**
	 * @param delTimeMinute the delTimeMinute to set
	 */
	public void setDelTimeMinute(String[] delTimeMinute) {
		this.delTimeMinute = delTimeMinute;
	}

}
