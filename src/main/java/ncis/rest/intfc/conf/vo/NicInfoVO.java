/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NicInfoVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;


/**
 * 네크워크인터페이스 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class NicInfoVO {

	private String nicTypeCode;                      /* 네크워크인터페이스:용도 */
	private String nicType;                      /* 네크워크인터페이스:용도 */
    private String ipAddress;                   /* 네크워크인터페이스:IP */
    private String macAddress;                  /* 네크워크인터페이스:MAC주소 */

	public String getNicTypeCode()
	{
		return nicTypeCode;
	}
	public void setNicTypeCode(String nicTypeCode)
	{
		this.nicTypeCode = nicTypeCode;
	}
	public String getNicType() {
		return nicType;
	}
	public void setNicType(String nicType) {
		this.nicType = nicType;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}


}
