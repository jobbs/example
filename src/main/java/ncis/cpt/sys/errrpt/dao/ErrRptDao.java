/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.dao;

import java.util.List;
import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.sys.errrpt.vo.ErrRptProcssVo;
import ncis.cpt.sys.errrpt.vo.ErrRptSearchVo;
import ncis.cpt.sys.errrpt.vo.ErrRptVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("errRptDao")
public class ErrRptDao {

    @Autowired SqlSession sqlSession;

    /**
     * @param searchVo
     * @return
     */
    public int selectErrRptTotCnt(ErrRptSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.errrpt.selectErrRptTotCnt", searchVo);
    }

    /**
     * @param searchVo
     * @return
     */
    public List<ErrRptVo> selectErrRptList(ErrRptSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.errrpt.selectErrRptList", searchVo);
    }

    /**
     * @param errRptSeq
     * @return
     */
    public ErrRptVo selectErrRpt(Long errRptSeq) {
        return sqlSession.selectOne("ncis.sql.cpt.errrpt.selectErrRpt", errRptSeq);
    }

    /**
     * @param seq
     * @return
     */
    public CommonFileVo selectErrRptFile(Long seq) {
        return sqlSession.selectOne("ncis.sql.cpt.errrpt.selectErrRptFile", seq);
    }

    /**
     * @param errRptProcssSeq
     * @return
     */
    public ErrRptProcssVo selectErrRptProcss(Long errRptProcssSeq) {
        return sqlSession.selectOne("ncis.sql.cpt.errrpt.selectErrRptProcss", errRptProcssSeq);
    }


}
