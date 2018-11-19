/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectClusterTag.java
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
import ncis.cpt.rsrc.com.service.ClstrService;
import ncis.cpt.rsrc.com.vo.ClstrSearchVo;
import ncis.cpt.rsrc.com.vo.ClstrVo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectClusterTag extends AbstractCustomSelectTag  {

    private static final long serialVersionUID = -7855318585475067266L;

    protected String poolId;

    protected boolean dynamic;

    private ApplicationContext context;

    /**
     *
     */
    public SelectClusterTag() {
        this.dynamic = true;
    }

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {

        try {

            List<ClstrVo> items = null;

            context = (ApplicationContext) pageContext.getServletConfig().getServletContext()
                    .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);

            if( null != poolId && !"".equals(poolId) ) {
                ClstrService clstrService = (ClstrService) context.getBean("clstrService");
                ClstrSearchVo searchVo = new ClstrSearchVo();

                searchVo.setEqualsRsrcPoolId(poolId);

                items = clstrService.selectClstrList(searchVo);
            }

            if( whole ) {
                tagWriter.startTag("option");
                tagWriter.writeAttribute("value", "");
                tagWriter.appendValue(wholeText);
                tagWriter.endTag();
            }

            if( items != null && items.size() > 0 ) {

                for (ClstrVo item : items) {

                    tagWriter.startTag("option");
                    tagWriter.writeAttribute("value", item.getClstrSeq().toString());

                    if( null != value && !"".equals(value) && value.equals(item.getClstrSeq().toString())) {
                        tagWriter.writeAttribute("selected", "selected");
                    }

                    if( isDisabled() ) {
                        tagWriter.writeAttribute("disabled", "disabled");
                    }
                    tagWriter.appendValue(item.getClstrNm());
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
     * @return the dynamic
     */
    public boolean isDynamic() {
        return dynamic;
    }

    /**
     * @param dynamic the dynamic to set
     */
    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * @return the poolId
     */
    public String getPoolId() {
        return poolId;
    }

    /**
     * @param poolId the poolId to set
     */
    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

}
