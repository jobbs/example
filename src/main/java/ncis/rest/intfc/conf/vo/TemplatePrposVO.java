/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TemplatePrposVO.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 2. 10.
 * @lastmodified 2017. 2. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 2. 10.     selim         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;

/**
 * @author selim
 *
 */
//@JsonInclude(Include.NON_NULL)
public class TemplatePrposVO
{
	private String purposeCode;

	private String purposeCodeName;

	public String getPurposeCode()
	{
		return purposeCode;
	}

	public void setPurposeCode(String purposeCode)
	{
		this.purposeCode = purposeCode;
	}

	public String getPurposeCodeName()
	{
		return purposeCodeName;
	}

	public void setPurposeCodeName(String purposeCodeName)
	{
		this.purposeCodeName = purposeCodeName;
	}


}
