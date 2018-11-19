package ncis.cmn.entity;

import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 배치작업 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmBtchWrk {

    /**
     * 배치작업SEQ
     */
    private Long btchWrkSeq;

    /**
     * 배치작업명
     */
    @NotEmpty(message="배치작업명을 입력하세요.")
    @Size(max=60, message="배치작업명은 최대 60자까지 허용합니다.")
    private String btchWrkNm;

    /**
     * 배치잡ID
     */
    @NotEmpty(message="배치 JOB ID를 입력하세요.")
    @Size(max=50, message="배치 JOB ID는 최대 50자까지 허용합니다.")
    private String btchWrkId;

    /**
     * 주기
     */
    private String cycle;

    /**
     * 주기 직접입력
     */
    private String cycleDirectWrite;

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
     * 주기/시점 구분
     */
    private String timeType;

    /**
     * 상태
     */
    private String stat;

    /**
     * 배치파일명
     */
//    @NotEmpty(message="배치파일명을 입력하세요.")
    @Size(max=200, message="배치파일명은 최대 200자까지 허용합니다.")
    private String btchWrkFileNm;

    /**
     * 실행예약일시
     */
    private Date exeRsrvDttm;

    /**
     * 정지예약일시
     */
    private Date stopRsrvDttm;

    /**
     * 실행옵션
     */
    @Size(max=4000, message="실행옵션은 최대 4000자까지 허용합니다.")
    private String exeOptn;

    /**
     * 설명
     */
    @Size(max=4000, message="배치설명은 최대 4000자까지 허용합니다.")
    private String dc;

    /**
     * 등록사용자ID
     */
    private String regUserId;

    /**
     * 등록일자
     */
    private Date regDt;

    private Date strtDttm;

    private Date endDttm;

    private String lastStat;

    private String exitCd;

	/**
	 * @return the btchWrkSeq
	 */
	public Long getBtchWrkSeq() {
		return btchWrkSeq;
	}

	/**
	 * @param btchWrkSeq the btchWrkSeq to set
	 */
	public void setBtchWrkSeq(Long btchWrkSeq) {
		this.btchWrkSeq = btchWrkSeq;
	}

	/**
	 * @return the btchWrkNm
	 */
	public String getBtchWrkNm() {
		return btchWrkNm;
	}

	/**
	 * @param btchWrkNm the btchWrkNm to set
	 */
	public void setBtchWrkNm(String btchWrkNm) {
		this.btchWrkNm = btchWrkNm;
	}

	/**
	 * @return the cycle
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	/**
	 * @return the cycleDirectWrite
	 */
	public String getCycleDirectWrite() {
		return cycleDirectWrite;
	}

	/**
	 * @param cycleDirectWrite the cycleDirectWrite to set
	 */
	public void setCycleDirectWrite(String cycleDirectWrite) {
		this.cycleDirectWrite = cycleDirectWrite;
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

	/**
	 * @return the timeType
	 */
	public String getTimeType() {
		return timeType;
	}

	/**
	 * @param timeType the timeType to set
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	/**
	 * @return the stat
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * @param stat the stat to set
	 */
	public void setStat(String stat) {
		this.stat = stat;
	}

	/**
	 * @return the btchWrkFileNm
	 */
	public String getBtchWrkFileNm() {
		return btchWrkFileNm;
	}

	/**
	 * @param btchWrkFileNm the btchWrkFileNm to set
	 */
	public void setBtchWrkFileNm(String btchWrkFileNm) {
		this.btchWrkFileNm = btchWrkFileNm;
	}

	/**
	 * @return the exeRsrvDttm
	 */
	public Date getExeRsrvDttm() {
		return exeRsrvDttm;
	}

	/**
	 * @param exeRsrvDttm the exeRsrvDttm to set
	 */
	public void setExeRsrvDttm(Date exeRsrvDttm) {
		this.exeRsrvDttm = exeRsrvDttm;
	}

	/**
	 * @return the stopRsrvDttm
	 */
	public Date getStopRsrvDttm() {
		return stopRsrvDttm;
	}

	/**
	 * @param stopRsrvDttm the stopRsrvDttm to set
	 */
	public void setStopRsrvDttm(Date stopRsrvDttm) {
		this.stopRsrvDttm = stopRsrvDttm;
	}

	/**
	 * @return the exeOptn
	 */
	public String getExeOptn() {
		return exeOptn;
	}

	/**
	 * @param exeOptn the exeOptn to set
	 */
	public void setExeOptn(String exeOptn) {
		this.exeOptn = exeOptn;
	}

	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

	/**
	 * @return the regUserId
	 */
	public String getRegUserId() {
		return regUserId;
	}

	/**
	 * @param regUserId the regUserId to set
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	/**
	 * @return the regDt
	 */
	public Date getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

    /**
     * @return the btchWrkId
     */
    public String getBtchWrkId() {
        return btchWrkId;
    }

    /**
     * @param btchWrkId the btchWrkId to set
     */
    public void setBtchWrkId(String btchWrkId) {
        this.btchWrkId = btchWrkId;
    }

	/**
	 * @return the strtDttm
	 */
	public Date getStrtDttm() {
		return strtDttm;
	}

	/**
	 * @param strtDttm the strtDttm to set
	 */
	public void setStrtDttm(Date strtDttm) {
		this.strtDttm = strtDttm;
	}

	/**
	 * @return the endDttm
	 */
	public Date getEndDttm() {
		return endDttm;
	}

	/**
	 * @param endDttm the endDttm to set
	 */
	public void setEndDttm(Date endDttm) {
		this.endDttm = endDttm;
	}

	/**
	 * @return the lastStat
	 */
	public String getLastStat() {
		return lastStat;
	}

	/**
	 * @param lastStat the lastStat to set
	 */
	public void setLastStat(String lastStat) {
		this.lastStat = lastStat;
	}

	/**
	 * @return the exitCd
	 */
	public String getExitCd() {
		return exitCd;
	}

	/**
	 * @param exitCd the exitCd to set
	 */
	public void setExitCd(String exitCd) {
		this.exitCd = exitCd;
	}


}
