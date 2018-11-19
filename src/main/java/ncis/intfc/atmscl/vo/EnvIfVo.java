/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NodeIfVo.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 06. 21.
 * @lastmodified 2017. 06. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 06. 21.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;


/**
 * @author x
 *
 */
public class EnvIfVo {

	private String name;  /* 환경변수명 */
    private String value;  /* 환경변수값 */

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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}



}
