package ncis.cmn.dao;

import ncis.cmn.entity.RnSRoutingScript;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 스태틱라우터스크립트 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnSRoutingScriptDao")
public class CRnSRoutingScriptDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 스태틱라우터스크립트 등록
     *
     * @param rnSRout
     */
    public void insertRnSRoutingScript(RnSRoutingScript rnSRoutingScript) {
        sqlSession.insert("ncis.sql.cmn.rnsroutingscript.insertRnSRoutingScript", rnSRoutingScript);
    }

    /**
     * 스태틱라우터스크립트 수정
     * @param rnSRoutingScript
     */
    public void updateRnSRoutingScript(RnSRoutingScript rnSRoutingScript) {
    	sqlSession.update("ncis.sql.cmn.rnsroutingscript.updateRnSRoutingScript", rnSRoutingScript);
    }


    /**
     * 스태틱라우터스크립트 삭제
     * @param sRoutingScriptSeq
     */
    public void deleteRnSRoutingScript(Long sRoutingScriptSeq) {
        sqlSession.delete("ncis.sql.cmn.rnsroutingscript.deleteRnSRoutingScript", sRoutingScriptSeq);
    }

}
