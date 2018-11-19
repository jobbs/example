/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectRecodeCntPerPageTag.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import ncis.cmn.vo.CommonSearchVo;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectRecodeCntPerPageTag extends AbstractCustomSelectTag  {

    private static final long serialVersionUID = -7855318585475067266L;

    protected String targetUrl;

    protected String formId;

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {

        try {

            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

            String currentUrl = (String) request.getAttribute("javax.servlet.forward.request_uri");
            if( !StringUtils.isEmpty(targetUrl) ) {
                currentUrl = targetUrl;
            }

            tagWriter.startTag("div");  //label div
            tagWriter.writeOptionalAttributeValue("class", "input-group-cell pad-right-5");

            tagWriter.startTag("label");
            tagWriter.writeOptionalAttributeValue("for", "tmpCntPerPage");
            tagWriter.appendValue("목록수");
            tagWriter.endTag();

            tagWriter.endTag();//label div


            tagWriter.startTag("div");  //select box wrapper
            tagWriter.writeOptionalAttributeValue("class", "input-group-cell pad-right-5");

            tagWriter.startTag("div");  //select box div
            tagWriter.writeOptionalAttributeValue("class", "input-group");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);
            tagWriter.writeOptionalAttributeValue("id", "tmpCntPerPage");
            tagWriter.writeOptionalAttributeValue("class", "form-control input-sm");
            tagWriter.writeOptionalAttributeValue("title", "목록수");

            int[] items = { 10, 20, 30, 50, 100 };

            CommonSearchVo searchVo = (CommonSearchVo)value;

            for (int item : items) {

                tagWriter.startTag("option");
                tagWriter.writeAttribute("value",  Integer.toString(item) );

                if( null != searchVo && item == searchVo.getPaginationInfo().getRecordCountPerPage()) {
                    tagWriter.writeAttribute("selected", "selected");
                }

                if( isDisabled() ) {
                    tagWriter.writeAttribute("disabled", "disabled");
                }
                tagWriter.appendValue(Integer.toString(item));
                tagWriter.endTag();
            }

            tagWriter.endTag();//selectbox

            tagWriter.endTag();  //select box div

            tagWriter.endTag();  //select box wrapper

            tagWriter.startTag("div");  //button div
            tagWriter.writeOptionalAttributeValue("class", "input-group-cell pad-right-5");

            tagWriter.startTag("button");
            tagWriter.writeOptionalAttributeValue("type", "button");
            tagWriter.writeOptionalAttributeValue("class", "btn btn-sm btn-function");
            tagWriter.writeOptionalAttributeValue("onclick", "changeRecordCntPerPage('" + currentUrl + "', '" + formId + "')");
            tagWriter.appendValue("적용");
            tagWriter.endTag();

            tagWriter.endTag(true); //button div

            return SKIP_BODY;

        } catch (JspException e) {
            throw new JspException(e.toString(), e);
        }
    }

    /**
     * @return the formId
     */
    public String getFormId() {
        return formId;
    }

    /**
     * @param formId the formId to set
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * @return the targetUrl
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * @param targetUrl the targetUrl to set
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

}
