/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IPBndDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("rnIpBndDao")
public class RnIpBndDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 검색조건에 해당하는 IP대역 수 조회
     *
     * @param searchVo
     * @return
     */
    public int selectIpBndTotCnt(IpBndSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rnIpBnd.selectIpBndTotCnt", searchVo);
    }

    /**
     * 검색조건에 해당하는 IP대역 목록 조회
     *
     * @param searchVo
     * @return
     */
    public List<IpBndVo> selectIpBndList(IpBndSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rnIpBnd.selectIpBndList", searchVo);
    }

    /**
     * 선택한 IP대역 상세 조회
     *
     * @param bndSeq
     * @return
     */
    public IpBndVo selectIpBnd(BigDecimal bndSeq) {
        return sqlSession.selectOne("ncis.sql.cpt.rnIpBnd.selectIpBnd", bndSeq);
    }

    /**
     * 선택한 IP대역의 IP목록 조회
     *
     * @param ipBndSeq
     * @param ipStatCd
     * @return
     */
    public List<IpVo> selectIp(BigDecimal ipBndSeq, String ipStatCd) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("bnd_Seq", ipBndSeq);
        param.put("ip_stat_cd", ipStatCd);

        return sqlSession.selectList("ncis.sql.cpt.rnIpBnd.selectIpList", param);
    }

    /**
     * 범위 조회
     *
     * @param strtIP
     * @param endIp
     * @return
     */
    public List<IpVo> selectCheckIpRange(String strtIp, String endIp, String regionId, String netId, List<String> prposClCdList) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("strtIp", strtIp);
        param.put("endIp", endIp);
        param.put("regionId", regionId);
        param.put("netClCd", netId);
        param.put("prposClCdList", prposClCdList);

        return sqlSession.selectList("ncis.sql.cpt.rnIpBnd.selectCheckIpRange", param);
    }
}
