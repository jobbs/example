/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectZoneTag.java
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
import ncis.cpt.rsrc.zone.service.ZoneService;
import ncis.cpt.rsrc.zone.vo.ZoneSearchVo;
import ncis.cpt.rsrc.zone.vo.ZoneVo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectZoneTag extends AbstractCustomSelectTag  {

    private static final long serialVersionUID = -7855318585475067266L;

    protected String regionId;

    protected boolean dynamic;

    private ApplicationContext context;

    /**
     *
     */
    public SelectZoneTag() {
        this.dynamic = true;
    }

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {

        try {

            List<ZoneVo> items = null;

            context = (ApplicationContext) pageContext.getServletConfig().getServletContext()
                    .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);

            ZoneService zoneService = (ZoneService) context.getBean("zoneService");

            //다이나믹한 Selectbox 여부 확인
            //다이나믹인 경우 존 아이디가 존제해야 하며 존 아이디에 해당하는 정보만 호출 하도록 한다.
        	ZoneSearchVo searchVo = new ZoneSearchVo();

        	searchVo.setByRole(isByRole());

            searchVo.setSearchRegionId(regionId);

            items = zoneService.selectZoneListByRegion(searchVo);

            if( whole ) {
                tagWriter.startTag("option");
                tagWriter.writeAttribute("value", "");
                tagWriter.appendValue(wholeText);
                tagWriter.endTag();
            }

            if( items != null && items.size() > 0 ) {

                for (ZoneVo item : items) {

                    tagWriter.startTag("option");
                    tagWriter.writeAttribute("value", item.getZoneId());

                    if( null != value && !"".equals(value) && value.equals(item.getZoneId())) {
                        tagWriter.writeAttribute("selected", "selected");
                    }

                    if( isDisabled() ) {
                        tagWriter.writeAttribute("disabled", "disabled");
                    }
                    tagWriter.appendValue(item.getZoneNm());
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
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
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

}
