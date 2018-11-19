/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZErrRptDao.java
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
package ncis.cmn.dao;

import java.util.HashMap;
import java.util.Map;
import ncis.cmn.entity.ZErrRpt;
import ncis.cpt.sys.errrpt.vo.ErrRptFileVo;
import ncis.cpt.sys.errrpt.vo.ErrRptVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("zErrRptDao")
public class ZErrRptDao {

    @Autowired private SqlSession sqlSession;

    public void insertZErrRpt(ZErrRpt zErrRpt) {
        sqlSession.insert("ncis.sql.cmn.ZErrRpt.insertZErrRpt", zErrRpt);
    }

    public void updateZErrRpt(ZErrRpt zErrRpt) {
        sqlSession.update("ncis.sql.cmn.ZErrRpt.updateZErrRpt", zErrRpt);
    }

    public void deleteZErrRpt(Long errRptSeq) {
        sqlSession.delete("ncis.sql.cmn.ZErrRpt.deleteZErrRpt", errRptSeq);
    }

    /**
     * @param file
     */
    public void insertZErrRptFile(ErrRptFileVo file) {
        sqlSession.delete("ncis.sql.cmn.ZErrRpt.insertZErrRptFile", file);
    }

    /**
     * @param errRptVo
     */
    public void deleteZErrRptFiles(ErrRptVo errRptVo) {
        sqlSession.delete("ncis.sql.cmn.ZErrRpt.deleteZErrRptFiles", errRptVo);
    }

    /**
     * @param errRptSeq
     * @param procssStatCd
     */
    public void updateZerrRptStat(Long errRptSeq, String procssStatCd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("errRptSeq", errRptSeq);
        params.put("procssStatCd", procssStatCd);
        sqlSession.update("ncis.sql.cmn.ZErrRpt.updateZerrRptStat", params);
    }

}
