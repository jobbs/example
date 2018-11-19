/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmService.java
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
package ncis.cpt.rsrc.com.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import ncis.cpt.rsrc.com.vo.VmCompHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmCompHistVo;
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
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @author 심원보
 *
 */
public interface VmService {

    /**
     * 가상서버 목록 조회 페이징
     *
     * @param vmSearchVo
     * @return
     */
    List<VmVo> selectVmListPaging(VmSearchVo vmSearchVo);

    /**
     * 가상서버 목록 조회
     *
     * @param vmSearchVo
     * @return
     */
    List<VmVo> selectVmList(VmSearchVo vmSearchVo);

    /**
     * 가상서버 조회
     *
     * @param vmSeq
     * @return
     */
    VmVo selectVm(BigDecimal vmSeq);

    /**
     * 가상서버 조회
     *
     * @param vmCompId
     * @return
     */
    VmVo selectVmByVmCompId(String vmCompId);

    /**
     * 가상서버 조회
     *
     * @param vmSeq
     * @return
     */
    VmVo selectVmByVmSearchVo(VmSearchVo vmSearchVo);

    /**
     * 가상서버 상세 조회
     *
     * @param vmSeq
     * @return
     */
    VmVo selectVmDetail(BigDecimal vmSeq);

    /**
     * 가상서버 상세 조회
     *
     * @param vmCompId
     * @return
     */
    VmVo selectVmDetailByVmCompId(String vmCompId);

    /**
     * 가상서버 상세 조회
     *
     * @param vmSeq
     * @return
     */
    VmVo selectVmDetailByVmSearchVo(VmSearchVo vmSearchVo);

    /**
     * 가상서버 정보 수정
     *
     * @param vmVo
     * @param vmResHistVo
     * @return
     */
    void updateVm(VmVo vmVo, VmResHistVo vmResHistVo);

    /**
     * 가상서버 패키지 대상여부 정보 수정
     *
     * @param vmVo
     * @return
     */
    void updateRcVmPackgMngTrgtYn(VmVo vmVo);

    /**
     * 가상서버 상태 동기화
     *
     * @param vmVo
     * @return
     */
    void updateVmStatSync(VmVo vmVo);

    /**
     * 가상서버 존재 여부
     *
     * @param vmSeq
     * @return
     */
    boolean isExistsVm(BigDecimal vmSeq);

    /**
     * 가상서버 구성ID 존재 여부
     *
     * @param vmCompId
     * @return
     */
    boolean isExistsVmCompId(String vmCompId);

    /**
     * 가상서버 프로세스 실행
     *
     * @param vmSeq
     * @param userId
     * @param processId
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    void executeProcess(String userId, String refJobId, Object vo, BigDecimal vmSeq, String reqKey) throws JsonGenerationException, JsonMappingException, IOException;

    /**
     * 가상서버 스냅샷 목록 조회
     *
     * @param vmSeq
     * @return
     */
    List<VmSnapVo> selectVmSnapList(BigDecimal vmSeq);

    /**
     * 가상서버 자원 이력 조회
     *
     * @param vmResHistSearchVo
     * @return
     */
    List<VmResHistVo> selectVmResHistList(VmResHistSearchVo vmResHistSearchVo, boolean isPagination);

    /**
     * 가상서버 마이그레이션 이력 조회
     *
     * @param vmMigrHistSearchVo
     * @return
     */
    List<VmMigrHistVo> selectVmMigrHistList(VmMigrHistSearchVo vmMigrHistSearchVo, boolean isPagination);

    /**
     * 가상서버 스냅샷 이력 조회
     *
     * @param vmSnapHistSearchVo
     * @return
     */
    List<VmSnapHistVo> selectVmSnapHistList(VmSnapHistSearchVo vmSnapHistSearchVo, boolean isPagination);

    /**
     * 가상서버 구성변경 이력 조회
     *
     * @param vmCompHistSearchVo
     * @return
     */
    List<VmCompHistVo> selectVmCompHistList(VmCompHistSearchVo vmCompHistSearchVo, boolean isPagination);

    /**
     * 가상서버 스냅샷 요청 정보 조회
     *
     * @param vmSnapVo
     * @return
     */
    VmSnapReqVo selectVmSnapReq(VmSnapVo vmSnapVo);

    /**
     * 가상서버 처리내역 여부 조회
     *
     * @param vmProcssVo
     * @return
     */
    VmProcssVo selectVmProcss(VmProcssVo vmProcssVo);

    /**
     * 가상서버 자원요청 및 처리 내역 조회
     *
     * @param vmSeq
     * @return
     */
    List<VmProcssMsgVo> selectVmProcssMsgList(BigDecimal vmSeq);

    /**
     * 가상서버 마이그레이션 상세 정보
     *
     * @param procssInstSeq
     * @return
     */
    String selectVmProcssVarList(BigDecimal procssInstSeq);

}