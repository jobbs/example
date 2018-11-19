/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonServiceImpl.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmSeqNumDao;
import ncis.cmn.dao.CCmUserWrkHistDao;
import ncis.cmn.entity.CmUserWrkHist;
import ncis.cmn.service.CommonService;
import ncis.cpt.sys.code.dao.CodeDao;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource(name="cCmSeqNumDao") private CCmSeqNumDao cCmSeqNumDao;
    @Resource(name="codeDao") private CodeDao codeDao;
    @Resource(name="cUserWrkHistDao") private CCmUserWrkHistDao cUserWrkHistDao;

    @Override
    @Transactional(value="transactionManager", propagation=Propagation.REQUIRES_NEW)
    public String selectSeqNum(String classfy, String prefix) {

        cCmSeqNumDao.selectForUpdate(classfy, prefix);
        cCmSeqNumDao.updateSeqNum(classfy, prefix);
        return cCmSeqNumDao.selectSeqNum(classfy, prefix);

    }


    @Override
    public List<CodeVo> selectCodeList(String parentGrpCd, String parentCd) {

        CodeSearchVo searchVo = new CodeSearchVo();
        searchVo.setSearchParentCd(parentCd);
        searchVo.setSearchParentGrpCd(parentGrpCd);

        return codeDao.selectCodeChildList(searchVo);
    }

    @Override
    public List<CodeVo> selectCodeList(String parentGrpCd, String parentCd, boolean isWhole) {

        List<CodeVo> codes = selectCodeList(parentGrpCd, parentCd);

        if( isWhole ) {
            CodeVo code = new CodeVo();
            code.setCd("");
            code.setCdNm("전체");
            code.setCdOrder(0);
            codes.add(0, code);
        }


        return codes;
    }

    @Override
    public List<CodeVo> selectCodeList(CodeSearchVo searchVo) {
        List<CodeVo> codes = codeDao.selectCodeChildList(searchVo);

        if( searchVo.getSearchWhole() ) {
            CodeVo code = new CodeVo();
            code.setCd("");
            code.setCdNm("전체");
            code.setCdOrder(0);
            codes.add(0, code);
        }

        return codes;
    }


    @Override
    public CodeVo selectCode(String cd, String grpCd) {
    	  return  codeDao.selectCode(cd, grpCd);
    }

    @Override
    public void insertUserWrkHist(CmUserWrkHist userWrkHist) {
    	cUserWrkHistDao.insertUserWrkHist(userWrkHist);
    }

}
