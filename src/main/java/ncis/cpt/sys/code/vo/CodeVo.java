/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 28.
 * @lastmodified 2016. 9. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 28.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.code.vo;

import java.util.List;
import ncis.cmn.entity.CmCode;

/**
 * @author 최진호
 *
 */
public class CodeVo extends CmCode {

    private CodeVo parent;

    private List<CodeVo> subCodeList;

    /**
     * @return the parent
     */
    public CodeVo getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(CodeVo parent) {
        this.parent = parent;
    }

    /**
     * @return the subCodeList
     */
    public List<CodeVo> getSubCodeList() {
        return subCodeList;
    }

    /**
     * @param subCodeList the subCodeList to set
     */
    public void setSubCodeList(List<CodeVo> subCodeList) {
        this.subCodeList = subCodeList;
    }
}
