/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZErrRptProcssDao.java
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

import ncis.cmn.entity.ZErrRptProcss;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("zErrRptProcssDao")
public class ZErrRptProcssDao {

    @Autowired private SqlSession sqlSession;

    public void insertZErrRptProcss(ZErrRptProcss zErrRptProcss) {
        sqlSession.insert("ncis.sql.cmn.ZErrRptProcss.insertZErrRptProcss", zErrRptProcss);
    }

    public void updateZErrRptProcss(ZErrRptProcss zErrRptProcss) {
        sqlSession.insert("ncis.sql.cmn.ZErrRptProcss.updateZErrRptProcss", zErrRptProcss);
    }

    public void deleteZErrRptProcss(Long errRptProcssSeq) {
        sqlSession.insert("ncis.sql.cmn.ZErrRptProcss.deleteZErrRptProcss", errRptProcssSeq);
    }

    public void deleteZErrRptProcssByParent(Long errRptSeq) {
        sqlSession.delete("ncis.sql.cmn.ZErrRptProcss.deleteZErrRptProcssByParent", errRptSeq);
    }

}
