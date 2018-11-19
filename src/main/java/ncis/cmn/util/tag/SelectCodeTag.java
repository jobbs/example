/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectCodeTag.java
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

import java.util.List;
import javax.servlet.jsp.JspException;
import ncis.cmn.service.CommonService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectCodeTag extends AbstractCustomSelectTag {

    private static final long serialVersionUID = -2497287886960022178L;

    protected String parentCd;

    protected String parentGrpCd;

    protected String extra1;

    protected String extra2;

    protected String extra3;

    protected String extra4;

    protected String extra5;

    private ApplicationContext context;

    /* (non-Javadoc)
     * @see ncis.cmn.util.tag.CustomSelectTag#writeTagContent(org.springframework.web.servlet.tags.form.TagWriter)
     */
    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {
        try {
            context = (ApplicationContext) pageContext.getServletConfig().getServletContext()
                    .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);

            CommonService codeService = (CommonService) context.getBean("commonService");
            CodeSearchVo searchVo = new CodeSearchVo();
            searchVo.setSearchParentCd(parentCd);
            searchVo.setSearchParentGrpCd(parentGrpCd);
            searchVo.setSearchWhole(false);
            searchVo.setSearchExtra1(extra1);
            searchVo.setSearchExtra2(extra2);
            searchVo.setSearchExtra3(extra3);
            searchVo.setSearchExtra4(extra4);
            searchVo.setSearchExtra5(extra5);


            List<CodeVo> items = codeService.selectCodeList(searchVo);

            if( whole ) {
                tagWriter.startTag("option");
                tagWriter.writeAttribute("value", "");
                tagWriter.appendValue(wholeText);
                tagWriter.endTag();
            }

            if( items != null && items.size() > 0 ) {

                for (CodeVo item : items) {

                    tagWriter.startTag("option");
                    tagWriter.writeAttribute("value", item.getCd());

                    if( null != value && !"".equals(value) && value.equals(item.getCd())) {
                        tagWriter.writeAttribute("selected", "selected");
                    }

                    if( isDisabled() ) {
                        tagWriter.writeAttribute("disabled", "disabled");
                    }
                    tagWriter.appendValue(item.getCdNm());
                    tagWriter.endTag();
                }
            }

            tagWriter.endTag(true);
            return SKIP_BODY;

        } catch (JspException e) {
            throw new JspException(e.toString(), e);
        }
    }

    /**
     * @return the parentCd
     */
    public String getParentCd() {
        return parentCd;
    }

    /**
     * @param parentCd the parentCd to set
     */
    public void setParentCd(String parentCd) {
        this.parentCd = parentCd;
    }

    /**
     * @return the context
     */
    public ApplicationContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    /**
     * @return the parentGrpCd
     */
    public String getParentGrpCd() {
        return parentGrpCd;
    }

    /**
     * @param parentGrpCd the parentGrpCd to set
     */
    public void setParentGrpCd(String parentGrpCd) {
        this.parentGrpCd = parentGrpCd;
    }

    /**
     * @return the extra1
     */
    public String getExtra1() {
        return extra1;
    }

    /**
     * @param extra1 the extra1 to set
     */
    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    /**
     * @return the extra2
     */
    public String getExtra2() {
        return extra2;
    }

    /**
     * @param extra2 the extra2 to set
     */
    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    /**
     * @return the extra3
     */
    public String getExtra3() {
        return extra3;
    }

    /**
     * @param extra3 the extra3 to set
     */
    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    /**
     * @return the extra4
     */
    public String getExtra4() {
        return extra4;
    }

    /**
     * @param extra4 the extra4 to set
     */
    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    /**
     * @return the extra5
     */
    public String getExtra5() {
        return extra5;
    }

    /**
     * @param extra5 the extra5 to set
     */
    public void setExtra5(String extra5) {
        this.extra5 = extra5;
    }

}
