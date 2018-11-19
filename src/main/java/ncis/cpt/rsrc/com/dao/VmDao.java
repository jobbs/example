/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmDao.java
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
package ncis.cpt.rsrc.com.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import ncis.cpt.rsrc.com.vo.VmCompHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmCompHistVo;
import ncis.cpt.rsrc.com.vo.VmHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistVo;
import ncis.cpt.rsrc.com.vo.VmProcssMsgVo;
import ncis.cpt.rsrc.com.vo.VmProcssVo;
import ncis.cpt.rsrc.com.vo.VmResHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmResHistVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmSnapHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmSnapHistVo;
import ncis.cpt.rsrc.com.vo.VmSnapReqVo;
import ncis.cpt.rsrc.com.vo.VmSnapVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 심원보
 *
 */
@Repository("vmDao")
public class VmDao {

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 가상서버 목록 수 조회
     *
     * @param vmSearchVo
     * @return
     */
    public int selectVmTotCnt(VmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmTotCnt", vmSearchVo);

    }

    /**
     * 가상서버 목록 조회
     *
     * @param vmSearchVo
     * @return
     */
    public List<VmVo> selectVmListPaging(VmSearchVo vmSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmListPaging", vmSearchVo);

    }

    /**
     * 가상서버 목록 조회
     *
     * @param vmSearchVo
     * @return
     */
    public List<VmVo> selectVmList(VmSearchVo vmSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmList", vmSearchVo);

    }

    /**
     * 가상서버 정보 조회
     *
     * @param vmSeq
     * @return
     */
    public VmVo selectVm(BigDecimal vmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVm", vmSeq);

    }

    /**
     * 가상서버 정보 조회
     *
     * @param vmCompId
     * @return
     */
    public VmVo selectVmByVmCompId(String vmCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmByVmCompId", vmCompId);

    }

    /**
     * 가상서버 정보 조회
     *
     * @param vmSearchVo
     * @return
     */
    public VmVo selectVmByVmSearchVo(VmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmByVmSearchVo", vmSearchVo);

    }

    /**
     * 가상서버 상세 정보 조회
     *
     * @param vmSeq
     * @return
     */
    public VmVo selectVmDetail(BigDecimal vmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmDetail", vmSeq);

    }

    /**
     * 가상서버 상세 정보 조회
     *
     * @param vmCompId
     * @return
     */
    public VmVo selectVmDetailByVmCompId(String vmCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmDetailByVmCompId", vmCompId);

    }

    /**
     * 가상서버 상세 정보 조회
     *
     * @param vmSearchVo
     * @return
     */
    public VmVo selectVmDetailByVmSearchVo(VmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmDetailByVmSearchVo", vmSearchVo);

    }

    /**
     * 가상서버 존재 여부
     *
     * @param vmSeq
     * @return
     */
    public int selectVmTotCntByVmSeq(BigDecimal vmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmTotCntByVmSeq", vmSeq);

    }

    /**
     * 가상서버 구성ID 존재 여부
     *
     * @param vmCompId
     * @return
     */
    public int selectVmTotCntByVmCompId(String vmCompId) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmTotCntByVmCompId", vmCompId);

    }

    /**
     * 가상서버 스냅샷 목록 조회
     *
     * @param vmSeq
     * @return
     */
    public List<VmSnapVo> selectVmSnapList(BigDecimal vmSeq) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmSnapList", vmSeq);

    }

    /**
     * 가상서버 이력 목록 수 조회
     *
     * @param vmHistSearchVo
     * @return
     */
    public int selectVmHistTotCnt(VmHistSearchVo vmHistSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmHistTotCnt", vmHistSearchVo);

    }

    /**
     * 가상서버 자원 이력 조회
     *
     * @param vmResHistSearchVo
     * @return
     */
    public List<VmResHistVo> selectVmResHistList(VmResHistSearchVo vmResHistSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmResHistList", vmResHistSearchVo);

    }

    /**
     * 가상서버 마이그레이션 이력 조회
     *
     * @param vmMigrHistSearchVo
     * @return
     */
    public List<VmMigrHistVo> selectVmMigrHistList(VmMigrHistSearchVo vmMigrHistSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmMigrHistList", vmMigrHistSearchVo);

    }

    /**
     * 가상서버 스냅샷 이력 조회
     *
     * @param vmSnapHistSearchVo
     * @return
     */
    public List<VmSnapHistVo> selectVmSnapHistList(VmSnapHistSearchVo vmSnapHistSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmSnapHistList", vmSnapHistSearchVo);

    }

    /**
     * 가상서버 구성변경 이력 조회
     *
     * @param vmCompSearchVo
     * @return
     */
    public List<VmCompHistVo> selectVmCompHistList(VmCompHistSearchVo vmCompHistSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmCompHistList", vmCompHistSearchVo);

    }

    /**
     * 사용자별 가상서버 통계
     *
     * @param vmSearchVo
     * @return
     */
    public Map<String, Object> selectVmSttsByUser(VmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmSttsByUser", vmSearchVo);

    }

    /**
     * 사용자별 가상서버 부처업무 통계
     *
     * @param vmSearchVo
     * @return
     */
    public Map<String, Object> selectVmJobSttsByUser(VmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmJobSttsByUser", vmSearchVo);

    }

    /**
     * 가상서버 스냅샷 요청 정보 조회
     *
     * @param vmSeq
     * @return
     */
    public VmSnapReqVo selectVmSnapReq(VmSnapVo vmSnapVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmSnapReq", vmSnapVo);

    }

    /**
     * 가상서버 처리내역 여부 조회
     *
     * @param vmProcssVo
     * @return
     */
    public VmProcssVo selectVmProcss(VmProcssVo vmProcssVo) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmProcss", vmProcssVo);

    }

    /**
     * 가상서버 자원요청 및 처리 내역 조회
     *
     * @param vmSeq
     * @return
     */
    public List<VmProcssMsgVo> selectVmProcssMsgList(BigDecimal vmSeq) {

        return sqlSession.selectList("ncis.sql.cpt.rsrc.com.vm.selectVmProcssMsgList", vmSeq);

    }

    /**
     * 가상서버 마이그레이션 상세 정보
     *
     * @param procssInstSeq
     * @return
     */
    public String selectVmProcssVarList(BigDecimal procssInstSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.rsrc.com.vm.selectVmProcssVarList", procssInstSeq);

    }

}
