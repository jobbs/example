/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename FocusHandlerVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 11. 10.
 * @lastmodified 2016. 11. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 10.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

/**
 * @author 심원보
 *
 */
public class ViewFocusHandlerVo {

    private String name;

    private ViewFocusHandlerVo child;

    /**
     * @param name
     */
    public ViewFocusHandlerVo(String name) {
        super();
        this.name = name;
    }

    /**
     * @param name
     * @param child
     */
    public ViewFocusHandlerVo(String name, ViewFocusHandlerVo child) {
        super();
        this.name = name;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ViewFocusHandlerVo getChild() {
        return child;
    }

    public void setChild(ViewFocusHandlerVo child) {
        this.child = child;
    }

}
