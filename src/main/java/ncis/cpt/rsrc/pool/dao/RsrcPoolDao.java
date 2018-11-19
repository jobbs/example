/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolDao.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.pool.dao;

import java.util.List;

import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.dsb.stts.etc.vo.OprStatSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("rsrcPoolDao")
public class RsrcPoolDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * @param rsrcPoolSearchVo
     * @return
     */
    public int selectUserRsrcPoolTotCnt(RsrcPoolSearchVo rsrcPoolSearchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.rsrcPool.selectUserRsrcPoolTotCnt", rsrcPoolSearchVo);
    }

    /**
     * 자원풀 목록 조회
     *
     * @param rsrcPoolSearchVo
     * @return
     */
    public List<RsrcPoolVo> selectUserRsrcPoolList(RsrcPoolSearchVo rsrcPoolSearchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.rsrcPool.selectUserRsrcPoolList", rsrcPoolSearchVo);
    }

    /**
     * 자원풀 상세 정보 조회
     *
     * @param rsrcPoolId
     * @return
     */
    public RsrcPoolVo selectRsrcPool(String rsrcPoolId) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.rsrcPool.selectRsrcPool", rsrcPoolId);
    }

    /**
     * @param searchVo
     * @return
     */
    public int selectRsrcPoolTotCnt(RsrcPoolSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.rsrcPool.selectRsrcPoolTotCnt", searchVo);
    }


    /**
     * @param searchVo
     * @return
     */
    public int selectRsrcPoolTotCnt(OprStatSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.rsrcPool.selectRsrcPoolTotCnt", searchVo);
    }

    /**
     * @param searchVo
     * @return
     */
    public List<RsrcPoolVo> selectRsrcPoolList(OprStatSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.rsrcPool.selectOprRsrcPoolList", searchVo);
    }

    /**
     * @param searchVo
     * @return
     */
    public List<RsrcPoolVo> selectRsrcPoolList(RsrcPoolSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.rsrcPool.selectRsrcPoolList", searchVo);
    }

    /**
     * 수량 조회 (가상스토리지 포함된 조회 조건)
     *
     * @param searchVo
     * @return
     */
    public int selectVrStrgRsrcPoolListTotCnt(VrStrgSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.rsrcPool.selectVrStrgRsrcPoolListTotCnt", searchVo);
    }

    /**
     * 목록 조회 (가상스토리지 포함된 조회 조건)
     *
     * @param searchVo
     * @return
     */
    public List<RsrcPoolVrStrgVo> selectVrStrgRsrcPoolList(VrStrgSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.rsrcPool.selectVrStrgRsrcPoolList", searchVo);
    }

}
