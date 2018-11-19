/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BuildConfigsIfVo.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 27.
 * @lastmodified 2017. 06. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 27.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;



/**
 * @author x
 *
 */
public class BuildConfigsIfVo {

	private String name;
	private String host;
	private String namespaceId;
	private String serviceName;
	private String uri;
	private String sourceType;
	private String contextDir;
	private String secret;
	private String ref;
	private String baseImgId;
	private String baseImgVer;
	private String bldHstryId;

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
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * @return the sourceType
	 */
	public String getSourceType() {
		return sourceType;
	}
	/**
	 * @param sourceType the sourceType to set
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * @return the contextDir
	 */
	public String getContextDir() {
		return contextDir;
	}
	/**
	 * @param contextDir the contextDir to set
	 */
	public void setContextDir(String contextDir) {
		this.contextDir = contextDir;
	}
	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}
	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
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
	/**
	 * @return the baseImgVer
	 */
	public String getBaseImgVer() {
		return baseImgVer;
	}
	/**
	 * @param baseImgVer the baseImgVer to set
	 */
	public void setBaseImgVer(String baseImgVer) {
		this.baseImgVer = baseImgVer;
	}
	/**
	 * @return the bldHstryId
	 */
	public String getBldHstryId() {
		return bldHstryId;
	}
	/**
	 * @param bldHstryId the bldHstryId to set
	 */
	public void setBldHstryId(String bldHstryId) {
		this.bldHstryId = bldHstryId;
	}

}
