package ncis.cmn.dao;

import java.math.BigDecimal;
import java.util.HashMap;

import ncis.cmn.entity.RnIp;
import ncis.cpt.opr.ip.vo.IpVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * IP DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnIpDao")
public class CRnIpDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * IP 추가
     *
     * @param rnIp
     */
    public void insertRnIp(RnIp rnIp) {
        sqlSession.update("ncis.sql.cmn.rnIp.insertRnIp", rnIp);
    }

    /**
     * 동기화
     *
     * @param ipVo
     */
    public void updateIpSyncronize(IpVo ipVo) {
        sqlSession.update("ncis.sql.cmn.rnIp.updateIpSyncronize", ipVo);
    }

    /**
     * IP 정보 수정
     *
     * @param ipVo
     */
    public void updateIpList(IpVo ipVo) {
        sqlSession.update("ncis.sql.cmn.rnIp.updateIpList", ipVo);
    }

    /**
     * IP 정보 수정 (블락해제)
     *
     * @param ipVo
     */
    public void updateIpListByBlkToUnasgn(IpVo ipVo) {
        sqlSession.update("ncis.sql.cmn.rnIp.updateIpListByBlkToUnasgn", ipVo);
    }

    /**
     * IP대역 삭제 호출로 인한 해당 IP 삭제 (범위)
     * @param strtIp
     * @param endIp
     */
    public void deleteIpBndWidth(BigDecimal bndSeq){
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("bndSeq", ""+bndSeq);
        sqlSession.update("ncis.sql.cmn.rnIp.deleteIpBndWidth", bndSeq);
    }



}
