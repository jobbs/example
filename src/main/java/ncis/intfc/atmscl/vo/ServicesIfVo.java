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

import java.util.List;


/**
 * @author x
 *
 */
public class ServicesIfVo {

	private String name;
	private String namespaceId;
	private String displayName;
	private String description;
	private String baseImgId;

	List<ServicesPortsIfVo> ports;

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
	 * @return the namespaceId
	 */
	public String getNamespaceId() {
		return namespaceId;
	}

	/**
	 * @param namespaceId the namespaceId to set
	 */
	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}

	/**
	 * @return the ports
	 */
	public List<ServicesPortsIfVo> getPorts() {
		return ports;
	}

	/**
	 * @param ports the ports to set
	 */
	public void setPorts(List<ServicesPortsIfVo> ports) {
		this.ports = ports;
	}

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
	 * @return the baseImgId
	 */
	public String getBaseImgId() {
		return baseImgId;
	}

	/**
	 * @param baseImgId the baseImgId to set
	 */
	public void setBaseImgId(String baseImgId) {
		this.baseImgId = baseImgId;
	}


}
