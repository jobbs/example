/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.vo;
import java.util.Date;
import ncis.cmn.util.DateUtil;

/**
 * @author 박봉춘
 *
 */
public class BtchHistVo {

	private Long stepExecutionId;

	/**
	 * 배치작업명
	 */
	private String btchWrkNm;

	/**
	 * 배치작업ID
	 */
	private String jobName;

	/**
	 * 배치 시작시간
	 */
	private Date startTime;

	/**
	 * 배치 종료시간
	 */
	private Date endTime;

	/**
	 * 배치 상태
	 */
	private String status;

	/**
	 * 배치 종료 메세지
	 */
	private String exitMessage;

	/**
	 * 배치 단계명
	 */
	private String stepNm;

	/**
	 * 배치 단계 시작시간
	 */
	private Date stepStartTime;

	/**
	 * 배치 단계 종료시간
	 */
	private Date stepEndTime;

	/**
	 * 배치 단계 상태
	 */
	private String stepStatus;

	/**
	 * commit 수
	 */
	private int  commitCnt;

	/**
	 * read 수
	 */
	private int readCnt;

	/**
	 * filter 수
	 */
	private int filterCnt;

	/**
	 * write 수
	 */
	private int writeCnt;

	/**
	 * readSkip 수
	 */
	private int readSkipCnt;

	/**
	 * processSkip 수
	 */
	private int processSkipCnt;

	/**
	 * rollback 수
	 */
	private int rollbackCnt;

	/**
	 * 배치 작업 실행 ID
	 */
	private int jobExecutionId;

	/**
	 * 배치 작업 종료 메세지
	 */
	private String jobExitMessage;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the exitMessage
	 */
	public String getExitMessage() {
		return exitMessage;
	}

	/**
	 * @param exitMessage the exitMessage to set
	 */
	public void setExitMessage(String exitMessage) {
		this.exitMessage = exitMessage;
	}

	/**
	 * 시작시간 타입 변경
	 * @return
	 */
	public String getStartTimePattern() {
		return DateUtil.dateToString( getStartTime(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * 종료시간 타입 변경
	 * @return
	 */
	public String getEndTimePattern() {
		return DateUtil.dateToString( getEndTime(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * @return the stepNm
	 */
	public String getStepNm() {
		return stepNm;
	}

	/**
	 * @param stepNm the stepNm to set
	 */
	public void setStepNm(String stepNm) {
		this.stepNm = stepNm;
	}

	/**
	 * @return the stepStartTime
	 */
	public Date getStepStartTime() {
		return stepStartTime;
	}

	/**
	 * @param stepStartTime the stepStartTime to set
	 */
	public void setStepStartTime(Date stepStartTime) {
		this.stepStartTime = stepStartTime;
	}

	/**
	 * @return the stepEndTime
	 */
	public Date getStepEndTime() {
		return stepEndTime;
	}

	/**
	 * @param stepEndTime the stepEndTime to set
	 */
	public void setStepEndTime(Date stepEndTime) {
		this.stepEndTime = stepEndTime;
	}

	/**
	 * @return the stepStatus
	 */
	public String getStepStatus() {
		return stepStatus;
	}

	/**
	 * @param stepStatus the stepStatus to set
	 */
	public void setStepStatus(String stepStatus) {
		this.stepStatus = stepStatus;
	}

	/**
	 * @return the commitCnt
	 */
	public int getCommitCnt() {
		return commitCnt;
	}

	/**
	 * @param commitCnt the commitCnt to set
	 */
	public void setCommitCnt(int commitCnt) {
		this.commitCnt = commitCnt;
	}

	/**
	 * @return the readCnt
	 */
	public int getReadCnt() {
		return readCnt;
	}

	/**
	 * @param readCnt the readCnt to set
	 */
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	/**
	 * @return the filterCnt
	 */
	public int getFilterCnt() {
		return filterCnt;
	}

	/**
	 * @param filterCnt the filterCnt to set
	 */
	public void setFilterCnt(int filterCnt) {
		this.filterCnt = filterCnt;
	}

	/**
	 * @return the writeCnt
	 */
	public int getWriteCnt() {
		return writeCnt;
	}

	/**
	 * @param writeCnt the writeCnt to set
	 */
	public void setWriteCnt(int writeCnt) {
		this.writeCnt = writeCnt;
	}

	/**
	 * @return the readSkipCnt
	 */
	public int getReadSkipCnt() {
		return readSkipCnt;
	}

	/**
	 * @param readSkipCnt the readSkipCnt to set
	 */
	public void setReadSkipCnt(int readSkipCnt) {
		this.readSkipCnt = readSkipCnt;
	}

	/**
	 * @return the processSkipCnt
	 */
	public int getProcessSkipCnt() {
		return processSkipCnt;
	}

	/**
	 * @param processSkipCnt the processSkipCnt to set
	 */
	public void setProcessSkipCnt(int processSkipCnt) {
		this.processSkipCnt = processSkipCnt;
	}

	/**
	 * @return the rollbackCnt
	 */
	public int getRollbackCnt() {
		return rollbackCnt;
	}

	/**
	 * @param rollbackCnt the rollbackCnt to set
	 */
	public void setRollbackCnt(int rollbackCnt) {
		this.rollbackCnt = rollbackCnt;
	}

	/**
	 * @return the jobExecutionId
	 */
	public int getJobExecutionId() {
		return jobExecutionId;
	}

	/**
	 * @param jobExecutionId the jobExecutionId to set
	 */
	public void setJobExecutionId(int jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	/**
	 * @return the jobExitMessage
	 */
	public String getJobExitMessage() {
		return jobExitMessage;
	}

	/**
	 * @param jobExitMessage the jobExitMessage to set
	 */
	public void setJobExitMessage(String jobExitMessage) {
		this.jobExitMessage = jobExitMessage;
	}

	/**
	 * @return the stepExecutionId
	 */
	public Long getStepExecutionId() {
		return stepExecutionId;
	}

	/**
	 * @param stepExecutionId the stepExecutionId to set
	 */
	public void setStepExecutionId(Long stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
	}
}
