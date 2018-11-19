/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 29.
 * @lastmodified 2016. 9. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 29.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.code.service;

import java.util.List;
import ncis.cmn.vo.Tree;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;

/**
 * @author 최진호
 *
 */
public interface CodeService {

    /**
     * @param parentCd
     * @param parentGrpCd
     * @param isLazy
     * @return
     */
    Tree<String, CodeVo> selectCodeListTree(String parentCd, String parentGrpCd, boolean isLazy);

    /**
     * @param cd
     * @param grpCd
     * @return
     */
    CodeVo selectCode(String cd, String grpCd);

    /**
     * @param cd
     * @param grpCd
     * @return
     */
    boolean selectExistsCd(String cd, String grpCd);

    /**
     * @param code
     */
    void insertCode(CodeVo code);

    /**
     * @param code
     */
    void updateCode(CodeVo code);

    /**
     * @param searchVo
     * @return
     */
    List<CodeVo> selectCodeSearchList(CodeSearchVo searchVo);

    /**
     * @param cd
     * @param grpCd
     * @param parentCd
     * @param parentGrpCd
     */
    void updatCodeOrderUp(String cd, String grpCd, String parentCd, String parentGrpCd);

    /**
     * @param cd
     * @param grpCd
     * @param parentCd
     * @param parentGrpCd
     */
    void updateCodeOrderDown(String cd, String grpCd, String parentCd, String parentGrpCd);

	/**
	 * @param searchVo
	 * @return
	 */
	List<CodeVo> selectCodeListXlsDwnl(CodeSearchVo searchVo);

}
