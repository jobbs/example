/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GraphicConsoleVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 11. 2.
 * @lastmodified 2016. 11. 2.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 2.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

/**
 * @author ShinKeeBong
 *
 */
public class GraphicConsoleVO {

	private String id;       //그래픽콘솔 ID
	private String protocol; //프로토콜

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


}
