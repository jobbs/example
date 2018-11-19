package ncis.cmn.dao;

import ncis.cpt.opr.ip.vo.SRoutVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 스태틱라우터 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnSRoutDao")
public class CRnSRoutDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 스태틱라우터 등록
     *
     * @param rnSRout
     */
    public void insertRnSRout(SRoutVo sRoutVo) {
        sqlSession.insert("ncis.sql.cmn.rnSRout.insertRnSRout", sRoutVo);
    }

    /**
     * 스태틱라우터 삭제
     *
     * @param rnSRout
     */
    public void deleteRnSRout(SRoutVo sRoutVo) {
        sqlSession.delete("ncis.sql.cmn.rnSRout.deleteRnSRout", sRoutVo);
    }

}
