/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SelectPoolTag.java
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
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public class SelectPoolTag extends AbstractCustomSelectTag  {

    private static final long serialVersionUID = -7855318585475067266L;

    protected String regionId;

    protected String zoneId;

    protected String netId;

    protected String netClCd;

    protected String poolTypeCd;

    protected String swTypeCd;

    protected boolean dynamic;

    protected String ctlTrgtYn;

    protected boolean netVmSltAt=false;

    private ApplicationContext context;

    /**
     *
     */
    public SelectPoolTag() {
        this.dynamic = true;
        this.ctlTrgtYn = "Y";
    }

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {

        try {

            List<RsrcPoolVo> items = null;

            context = (ApplicationContext) pageContext.getServletConfig().getServletContext()
                    .getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

            tagWriter.startTag("select");

            writeOptionalAttributes(tagWriter);


            if( null != regionId && !"".equals(regionId) &&
                    null != zoneId && !"".equals(zoneId) &&
                    ( (null != netId && !"".equals(netId)) || (null != netClCd && !"".equals(netClCd)) ) ) {

                RsrcPoolService rsrcPoolService = (RsrcPoolService) context.getBean("rsrcPoolService");
                RsrcPoolSearchVo searchVo = new RsrcPoolSearchVo();

                searchVo.setByRole(isByRole());
                if(netVmSltAt){
                	searchVo.setNetVmSltAt(netVmSltAt);
                	poolTypeCd="CN";
                }
                searchVo.setSearchRegionId(regionId);
                searchVo.setSearchZoneId(zoneId);
                searchVo.setSearchNetId(netId);
                searchVo.setSearchNetClCd(netClCd);
                searchVo.setSearchPoolTypeCd(poolTypeCd);
                searchVo.setSearchSwTypeCd(swTypeCd);
                searchVo.setSearchCtlTrgtYn(ctlTrgtYn);
                items = rsrcPoolService.selectUserRsrcPoolList(searchVo);
            }

            if( whole ) {
                tagWriter.startTag("option");
                tagWriter.writeAttribute("value", "");
                tagWriter.appendValue(wholeText);
                tagWriter.endTag();
            }

            if( items != null && items.size() > 0 ) {

                for (RsrcPoolVo item : items) {

                    tagWriter.startTag("option");
                    tagWriter.writeAttribute("value", item.getRsrcPoolId());

                    if( null != value && !"".equals(value) && value.equals(item.getRsrcPoolId())) {
                        tagWriter.writeAttribute("selected", "selected");
                    }

                    if( isDisabled() ) {
                        tagWriter.writeAttribute("disabled", "disabled");
                    }
                    tagWriter.appendValue(item.getRsrcPoolNm());
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

    /**
     * @return the zoneId
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * @param zoneId the zoneId to set
     */
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * @return the netId
     */
    public String getNetId() {
        return netId;
    }

    /**
     * @param netId the netId to set
     */
    public void setNetId(String netId) {
        this.netId = netId;
    }

    /**
     * @return the poolType
     */
    public String getPoolTypeCd() {
        return poolTypeCd;
    }

    /**
     * @param poolType the poolType to set
     */
    public void setPoolTypeCd(String poolTypeCd) {
        this.poolTypeCd = poolTypeCd;
    }

	/**
	 * @return the swTypeCd
	 */
	public String getSwTypeCd() {
		return swTypeCd;
	}

	/**
	 * @param swTypeCd the swTypeCd to set
	 */
	public void setSwTypeCd(String swTypeCd) {
		this.swTypeCd = swTypeCd;
	}

	/**
	 * @return the ctlTrgtYn
	 */
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}

	/**
	 * @param ctlTrgtYn the ctlTrgtYn to set
	 */
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}

	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}

	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	/**
	 * @return the netVmSltAt
	 */
	public boolean isNetVmSltAt() {
		return netVmSltAt;
	}

	/**
	 * @param netVmSltAt the netVmSltAt to set
	 */
	public void setNetVmSltAt(boolean netVmSltAt) {
		this.netVmSltAt = netVmSltAt;
	}



}
