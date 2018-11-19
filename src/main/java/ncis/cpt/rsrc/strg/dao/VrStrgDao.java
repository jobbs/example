/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgDao.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 신재훈
 *
 */

@Repository("vrStrgDao")
public class VrStrgDao {
    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 가상스토리지 상세 조회
     *
     * @param searchVo
     * @return
     */
    public VrStrgVo selectVrStrg(VrStrgSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrg", searchVo);
    }

    /**
     * 가상스토리지 상세 - 가상서버 탭 조회 (수량)
     *
     * @param searchVo
     * @return
     */
    public int selectVrStrgVmTotCnt(VmSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgVmTotCnt", searchVo);
    }

    /**
     * 가상스토리지 상세 - 가상서버 탭 조회
     *
     * @param searchVo
     * @return
     */
    public List<VrStrgVo> selectVrStrgVm(VmSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgVm", searchVo);
    }

    /**
     * 가상스토리지 상세 - 템플릿 탭 조회 (수량)
     *
     * @param searchVo
     * @return
     */
    public int selectVrStrgTmplatTotCnt(TmplatSvo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgTmplatTotCnt", searchVo);
    }

    /**
     * 가상스토리지 상세 - 템플릿 탭 조회
     *
     * @param searchVo
     * @return
     */
    public List<VrStrgVo> selectVrStrgTmplat(TmplatSvo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgTmplat", searchVo);
    }

    /**
     * 가상서버가 할당 된 가상스토리지 도메인 가용용량 및 디스크할당용량 조회
     * @param vmSeq
     * @return
     */
    public List<VrStrgVo> selectVrStrgAsgnInfoOfVm(BigDecimal vmSeq) {
        return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.vrStrg.selectVrStrgAsgnInfoOfVm", vmSeq);
    }

}
