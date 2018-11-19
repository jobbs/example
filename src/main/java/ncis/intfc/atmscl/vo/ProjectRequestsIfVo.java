/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ProjectRequestsIfVo.java
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
public class ProjectRequestsIfVo {

	private String displayName;  //서비스영역 명
	private String description;  //서비스영역 설명
	private String requester;    //서비스영역 요청자
	private String name;         //서비스영역 ID

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the requester
	 */
	public String getRequester() {
		return requester;
	}
	/**
	 * @param requester the requester to set
	 */
	public void setRequester(String requester) {
		this.requester = requester;
	}
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
}
