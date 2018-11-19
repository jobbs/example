/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NamespaceVO.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 31.
 * @lastmodified 2017. 05. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 31.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

/**
 * @author x
 *
 */
public class PodIfVo {

	private String name; //이름
	private String uid;  //uid
	private String creationTimestamp; //생성일시
	private String phase; //상태
	private String hostIP; //호스트IP
	private String podIP; //PodIp
	private String startTime; //기동일시
	private String image;   //이미지
	private String imageID;  //이미지 저장소 상세주소
	private String nodeName; //노드명
	private String podType;  //pod유형



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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the creationTimestamp
	 */
	public String getCreationTimestamp() {
		return creationTimestamp;
	}
	/**
	 * @param creationTimestamp the creationTimestamp to set
	 */
	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	/**
	 * @return the phase
	 */
	public String getPhase() {
		return phase;
	}
	/**
	 * @param phase the phase to set
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}
	/**
	 * @return the hostIP
	 */
	public String getHostIP() {
		return hostIP;
	}
	/**
	 * @param hostIP the hostIP to set
	 */
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	/**
	 * @return the podIP
	 */
	public String getPodIP() {
		return podIP;
	}
	/**
	 * @param podIP the podIP to set
	 */
	public void setPodIP(String podIP) {
		this.podIP = podIP;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
	 * @return the imageID
	 */
	public String getImageID() {
		return imageID;
	}
	/**
	 * @param imageID the imageID to set
	 */
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * @return the podType
	 */
	public String getPodType() {
		return podType;
	}
	/**
	 * @param podType the podType to set
	 */
	public void setPodType(String podType) {
		this.podType = podType;
	}



}
