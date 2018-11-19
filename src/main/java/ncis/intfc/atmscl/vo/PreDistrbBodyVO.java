/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LbBodyVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 11.
 * @lastmodified 2016. 11. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 11.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;


/**
 * @author x
 *
 */
public class PreDistrbBodyVO {

	private String name; /*DaemonsetId*/
	private String image; /*ImageFullPath*/
	private String namespace; /*서비스영역 ID*/
	private Integer currentNumberScheduled;
	private Integer numberMisscheduled;
	private Integer desiredNumberScheduled;
	private String status; // 상태
	private Integer runningPods;
	private Integer waitingPods;
	private Integer failedPods;
	private String reason;


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}


	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}


	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}


	/**
	 * @return the currentNumberScheduled
	 */
	public Integer getCurrentNumberScheduled() {
		return currentNumberScheduled;
	}


	/**
	 * @param currentNumberScheduled the currentNumberScheduled to set
	 */
	public void setCurrentNumberScheduled(Integer currentNumberScheduled) {
		this.currentNumberScheduled = currentNumberScheduled;
	}


	/**
	 * @return the numberMisscheduled
	 */
	public Integer getNumberMisscheduled() {
		return numberMisscheduled;
	}


	/**
	 * @param numberMisscheduled the numberMisscheduled to set
	 */
	public void setNumberMisscheduled(Integer numberMisscheduled) {
		this.numberMisscheduled = numberMisscheduled;
	}


	/**
	 * @return the desiredNumberScheduled
	 */
	public Integer getDesiredNumberScheduled() {
		return desiredNumberScheduled;
	}


	/**
	 * @param desiredNumberScheduled the desiredNumberScheduled to set
	 */
	public void setDesiredNumberScheduled(Integer desiredNumberScheduled) {
		this.desiredNumberScheduled = desiredNumberScheduled;
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
	 * @return the runningPods
	 */
	public Integer getRunningPods() {
		return runningPods;
	}


	/**
	 * @param runningPods the runningPods to set
	 */
	public void setRunningPods(Integer runningPods) {
		this.runningPods = runningPods;
	}


	/**
	 * @return the waitingPods
	 */
	public Integer getWaitingPods() {
		return waitingPods;
	}


	/**
	 * @param waitingPods the waitingPods to set
	 */
	public void setWaitingPods(Integer waitingPods) {
		this.waitingPods = waitingPods;
	}


	/**
	 * @return the failedPods
	 */
	public Integer getFailedPods() {
		return failedPods;
	}


	/**
	 * @param failedPods the failedPods to set
	 */
	public void setFailedPods(Integer failedPods) {
		this.failedPods = failedPods;
	}


	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}


	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreDistrbBodyVO [name=" + name + ", image=" + image
				+ ", namespace=" + namespace + ", currentNumberScheduled="
				+ currentNumberScheduled + ", numberMisscheduled="
				+ numberMisscheduled + ", desiredNumberScheduled="
				+ desiredNumberScheduled + ", status=" + status
				+ ", runningPods=" + runningPods + ", waitingPods="
				+ waitingPods + ", failedPods=" + failedPods + ", reason="
				+ reason + "]";
	}




}
