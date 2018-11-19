/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResourceQuotasIfVo.java
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
public class SecretsIfVo {

	private String namespaceId; //namespaceId
	private String name; // 보안키ID
	private String password; //사용자PW
	private String username;  //사용자ID
	private String type; // 보안유형

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
