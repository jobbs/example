/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AbstractCustomSelectTag.java
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

import javax.servlet.jsp.JspException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.tags.form.SelectTag;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * @author 최진호
 *
 */
public abstract class AbstractCustomSelectTag extends SelectTag {

    private static final long serialVersionUID = -7855318585475067266L;

    protected String name;

    protected String id;

    protected Object value;

    protected boolean whole;

    protected String wholeText;

    protected boolean byRole;

    /**
     *
     */
    public AbstractCustomSelectTag() {
        whole = true;
        wholeText = "전체";
        byRole = true;
    }

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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    protected void writeDefaultAttributes(TagWriter tagWriter) throws JspException {
        tagWriter.writeOptionalAttributeValue("name", name);
        tagWriter.writeOptionalAttributeValue("id", id);
        tagWriter.writeOptionalAttributeValue("size", getDisplayString(evaluate("size", getSize())));
    }

    @Override
    protected void writeOptionalAttributes(TagWriter tagWriter) throws JspException {
        this.writeDefaultAttributes(tagWriter);

        //super.writeOptionalAttributes(tagWriter);
        tagWriter.writeOptionalAttributeValue(CLASS_ATTRIBUTE, getCssClass());
        tagWriter.writeOptionalAttributeValue(STYLE_ATTRIBUTE, getCssStyle());

        writeOptionalAttribute(tagWriter, LANG_ATTRIBUTE, getLang());
        writeOptionalAttribute(tagWriter, TITLE_ATTRIBUTE, getTitle());
        writeOptionalAttribute(tagWriter, DIR_ATTRIBUTE, getDir());
        writeOptionalAttribute(tagWriter, TABINDEX_ATTRIBUTE, getTabindex());

        if( isDisabled() ) {
        	writeOptionalAttribute(tagWriter, DISABLED_ATTRIBUTE, "disabled");
        }

        if( isReadonly() ) {
        	writeOptionalAttribute(tagWriter, READONLY_ATTRIBUTE, "readonly");
        }

        writeOptionalAttribute(tagWriter, ONCLICK_ATTRIBUTE, getOnclick());
        writeOptionalAttribute(tagWriter, ONDBLCLICK_ATTRIBUTE, getOndblclick());
        writeOptionalAttribute(tagWriter, ONMOUSEDOWN_ATTRIBUTE, getOnmousedown());
        writeOptionalAttribute(tagWriter, ONMOUSEUP_ATTRIBUTE, getOnmouseup());
        writeOptionalAttribute(tagWriter, ONMOUSEOVER_ATTRIBUTE, getOnmouseover());
        writeOptionalAttribute(tagWriter, ONMOUSEMOVE_ATTRIBUTE, getOnmousemove());
        writeOptionalAttribute(tagWriter, ONMOUSEOUT_ATTRIBUTE, getOnmouseout());

        writeOptionalAttribute(tagWriter, ONMOUSEOUT_ATTRIBUTE, getOnmouseout());
        writeOptionalAttribute(tagWriter, ONKEYPRESS_ATTRIBUTE, getOnkeypress());
        writeOptionalAttribute(tagWriter, ONKEYUP_ATTRIBUTE, getOnkeyup());
        writeOptionalAttribute(tagWriter, ONKEYDOWN_ATTRIBUTE, getOnkeydown());

        writeOptionalAttribute(tagWriter, ONCHANGE_ATTRIBUTE, getOnchange());
        writeOptionalAttribute(tagWriter, ONBLUR_ATTRIBUTE, getOnblur());
        writeOptionalAttribute(tagWriter, ONFOCUS_ATTRIBUTE, getOnfocus());

        if( !CollectionUtils.isEmpty(getDynamicAttributes())) {
            for (String attr : getDynamicAttributes().keySet()) {
                tagWriter.writeOptionalAttributeValue(attr, getDisplayString(getDynamicAttributes().get(attr)));
            }
        }
    }

    @Override
    protected abstract int writeTagContent(TagWriter tagWriter) throws JspException;

    /**
     * @return the whole
     */
    public boolean isWhole() {
        return whole;
    }

    /**
     * @param whole the whole to set
     */
    public void setWhole(boolean whole) {
        this.whole = whole;
    }

    /**
     * @return the wholeText
     */
    public String getWholeText() {
        return wholeText;
    }

    /**
     * @param wholeText the wholeText to set
     */
    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }

	/**
	 * @return the byRole
	 */
	public boolean isByRole() {
		return byRole;
	}

	/**
	 * @param byRole the byRole to set
	 */
	public void setByRole(boolean byRole) {
		this.byRole = byRole;
	}
}
