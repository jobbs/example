/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeServiceImpl.java
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
package ncis.cpt.sys.code.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmCodeDao;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.code.dao.CodeDao;
import ncis.cpt.sys.code.service.CodeService;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import org.springframework.stereotype.Service;

/**
 * @author 최진호
 *
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

    @Resource(name="cCmCodeDao")
    private CCmCodeDao cCmCodeDao;

    @Resource(name="codeDao")
    private CodeDao codeDao;

    @Override
    public Tree<String, CodeVo> selectCodeListTree(String parentCd, String parentGrpCd, boolean isLazy) {
        return this.selectCodeListTree(parentCd, parentGrpCd, null, isLazy);
    }

    public Tree<String, CodeVo> selectCodeListTree(String parentCd, String parentGrpCd, String state, boolean isLazy) {

        String parentKey = null;
        if( null == parentCd || "".equals(parentCd)) parentKey = "000^|^000";


        Tree<String,CodeVo> tree = new Tree<String, CodeVo>(new TreeNode<String,CodeVo>(null,"root",null),isLazy);

        tree.addChild(new TreeNode<String, CodeVo>(parentKey, "공통코드", new CodeVo()));

        tree.addChilds(codeDao.selectCodeListTree(parentCd, parentGrpCd, state));
        return tree;
    }


    @Override
    public CodeVo selectCode(String cd, String grpCd) {
        CodeVo code = codeDao.selectCode(cd, grpCd);
        if( null != code )
            code.setParent(codeDao.selectCode(code.getParentCd(), code.getParentGrpCd()));

        return code;
    }

    @Override
    public boolean selectExistsCd(String cd, String grpCd) {
        return codeDao.selectExistsCd(cd, grpCd)>0?true:false;
    }

    /* (non-Javadoc)
     * @see ncis.cpt.sys.code.service.CodeService#insertCode(ncis.cpt.sys.code.vo.CodeVo)
     */
    @Override
    public void insertCode(CodeVo code) {
        codeDao.selectSelectForUpdate(code);
        cCmCodeDao.insertCmCode(code);
    }

    @Override
    public void updateCode(CodeVo code) {
        cCmCodeDao.updateCmCode(code);
    }

    @Override
    public List<CodeVo> selectCodeSearchList(CodeSearchVo searchVo) {

        List<CodeVo> list = null;

        int totalCount = codeDao.selectCodeTotCnt(searchVo);

        if( totalCount > 0 ) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount);   // 페이지 처리위한 count
            list = codeDao.selectCodeList(searchVo);
        }
        return list;
    }

    @Override
    public void updatCodeOrderUp(String cd, String grpCd, String parentCd, String parentGrpCd) {
        cCmCodeDao.updateCodeDownOrderByUp(cd, grpCd);
        cCmCodeDao.updateCodeUpOrder(cd, grpCd);
    }

    @Override
    public void updateCodeOrderDown(String cd, String grpCd, String parentCd, String parentGrpCd) {
        if(codeDao.selectCode(cd, grpCd).getCdOrder().intValue() == codeDao.selectMaxOrder(parentCd, parentGrpCd).intValue()){
            return;
        }
        cCmCodeDao.updateCodeUpOrderByDown(cd, grpCd);
        cCmCodeDao.updateCodeDownOrder(cd, grpCd);
    }

	@Override
	public List<CodeVo> selectCodeListXlsDwnl(CodeSearchVo searchVo) {
		return codeDao.selectCodeListXlsDwnl(searchVo);
	}

}
