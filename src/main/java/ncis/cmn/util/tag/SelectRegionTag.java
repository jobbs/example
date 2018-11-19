/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectRegionTag.java
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
import ncis.cpt.rsrc.zone.service.RegionService;
import ncis.cpt.rsrc.zone.vo.RegionSearchVo;
import ncis.cpt.rsrc.zone.vo.RegionVo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectRegionTag extends AbstractCustomSelectTag  {

    private static final long serialVersionUID = -7855318585475067266L;

    private ApplicationContext context;

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {

        try {
            context = (ApplicationContext) pageContext.getServletConfig().getServletContext()
                    .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);

            RegionService regionService = (RegionService) context.getBean("regionService");
            RegionSearchVo searchVo = new RegionSearchVo();

            searchVo.setByRole(isByRole());

            List<RegionVo> items = null;

            if( whole ) {
                tagWriter.startTag("option");
                tagWriter.writeAttribute("value", "");
                tagWriter.appendValue(wholeText);
                tagWriter.endTag();
            }

            if( byRole ) {
            	items = regionService.selectRegionList(searchVo);
            } else {
            	items = regionService.selectRegionAllList();
            }

            if( items != null && items.size() > 0 ) {

                for (RegionVo item : items) {

                    tagWriter.startTag("option");
                    tagWriter.writeAttribute("value", item.getRegionId());

                    if( null != value && !"".equals(value) && value.equals(item.getRegionId())) {
                        tagWriter.writeAttribute("selected", "selected");
                    }

                    if( isDisabled() ) {
                        tagWriter.writeAttribute("disabled", "disabled");
                    }
                    tagWriter.appendValue(item.getRegionNm());
                    tagWriter.endTag();
                }
            }

            tagWriter.endTag(true);
            return SKIP_BODY;

        } catch (JspException e) {
            throw new JspException(e.toString(), e);
        }
    }

}
