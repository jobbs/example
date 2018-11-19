/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TemplateSwVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;


/**
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class TemplateSwVO {

	private Integer swId;          /* 소프트웨어 일련번호 */
	private Integer templateId;    /* 템플릿 일련번호     */


	public Integer getSwId() {
		return swId;
	}
	public void setSwId(Integer swId) {
		this.swId = swId;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}


}
