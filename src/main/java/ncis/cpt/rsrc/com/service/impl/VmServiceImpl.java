/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmServiceImpl.java
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
package ncis.cpt.rsrc.com.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRcVmDao;
import ncis.cmn.dao.CRrProcssInstDao;
import ncis.cmn.dao.CRrProcssJobListDao;
import ncis.cmn.dao.CRrProcssVarListDao;
import ncis.cmn.dao.CRrVmWrkHistDao;
import ncis.cmn.entity.RrProcssInst;
import ncis.cmn.entity.RrProcssJobList;
import ncis.cmn.entity.RrProcssVarList;
import ncis.cpt.rsrc.com.dao.NetwkIntfcDao;
import ncis.cpt.rsrc.com.dao.VmDao;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmCompHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmCompHistVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistSearchVo;
import ncis.cpt.rsrc.com.vo.VmMigrHistVo;
import ncis.cpt.rsrc.com.vo.VmMigrVo;
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
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
/**
 * @author 최경철
 *
 */
@Service("vmService")
public class VmServiceImpl implements VmService {

    @Resource(name = "cRcVmDao")
    private CRcVmDao cRcVmDao;

    @Resource(name = "vmDao")
    private VmDao vmDao;

    @Resource(name = "cRrVmWrkHistDao")
    private CRrVmWrkHistDao cRrVmWrkHistDao;

    @Resource(name = "netwkIntfcDao")
    private NetwkIntfcDao netwkIntfcDao;

    @Resource(name = "cRrProcssInstDao")
    private CRrProcssInstDao cRrProcssInstDao;

    @Resource(name = "cRrProcssJobListDao")
    private CRrProcssJobListDao cRrProcssJobListDao;

    @Resource(name = "cRrProcssVarListDao")
    private CRrProcssVarListDao cRrProcssVarListDao;

    /**
     * 가상서버 목록 조회 페이징
     *
     * @param vmSearchVo
     * @return
     */
    @Override
    public List<VmVo> selectVmListPaging(VmSearchVo vmSearchVo) {

        List<VmVo> vmList = null;

        int vmTotalCount = vmDao.selectVmTotCnt(vmSearchVo);

        if (vmTotalCount > 0) {
            vmSearchVo.getPaginationInfo().setTotalRecordCount(vmTotalCount); // 페이지 처리위한 count

            vmList = vmDao.selectVmListPaging(vmSearchVo);
        }

        return vmList;

    }

    /**
     * 가상서버 목록 조회
     *
     * @param vmSearchVo
     * @return
     */
    @Override
    public List<VmVo> selectVmList(VmSearchVo vmSearchVo) {

        return vmDao.selectVmList(vmSearchVo);

    }

    /**
     * 가상서버 조회
     *
     * @param vmSeq
     * @return
     */
    @Override
    public VmVo selectVm(BigDecimal vmSeq) {

        return vmDao.selectVm(vmSeq);

    }

    /**
     * 가상서버 조회
     *
     * @param vmCompId
     * @return
     */
    @Override
    public VmVo selectVmByVmCompId(String vmCompId) {

        return vmDao.selectVmByVmCompId(vmCompId);

    }

    /**
     * 가상서버 조회
     *
     * @param vmSearchVo
     * @return
     */
    @Override
    public VmVo selectVmByVmSearchVo(VmSearchVo vmSearchVo) {

        return vmDao.selectVmByVmSearchVo(vmSearchVo);

    }

    /**
     * 가상서버 상세 조회
     *
     * @param vmSeq
     * @return
     */
    @Override
    public VmVo selectVmDetail(BigDecimal vmSeq) {

        return vmDao.selectVmDetail(vmSeq);

    }

    /**
     * 가상서버 상세 조회
     *
     * @param vmCompId
     * @return
     */
    @Override
    public VmVo selectVmDetailByVmCompId(String vmCompId) {

        return vmDao.selectVmDetailByVmCompId(vmCompId);

    }

    /**
     * 가상서버 상세 조회
     *
     * @param vmSearchVo
     * @return
     */
    @Override
    public VmVo selectVmDetailByVmSearchVo(VmSearchVo vmSearchVo) {

        return vmDao.selectVmDetailByVmSearchVo(vmSearchVo);

    }

    /**
     * 가상서버 정보 수정
     *
     * @param vmVo
     * @param vmResHistVo
     * @return
     */
    @Override
    public void updateVm(VmVo vmVo, VmResHistVo vmResHistVo) {

        if (null != vmResHistVo) {
            cRrVmWrkHistDao.insertRrVmWrkHist(vmResHistVo);
        }

        cRcVmDao.updateRcVm(vmVo);

    }

    /**
     * 가상서버 상태동기화
     *
     * @param vmVo
     * @return
     */
    @Override
    public void updateVmStatSync(VmVo vmVo) {

        cRcVmDao.updateRcVmStatSync(vmVo);

    }

    /**
     * 가상서버 존재 여부
     *
     * @param vmSeq
     * @return
     */
    @Override
    public boolean isExistsVm(BigDecimal vmSeq) {

        if (vmDao.selectVmTotCntByVmSeq(vmSeq) == 0) {
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * 가상서버 구성ID 존재 여부
     *
     * @param vmCompId
     * @return
     */
    @Override
    public boolean isExistsVmCompId(String vmCompId) {

        if (vmDao.selectVmTotCntByVmCompId(vmCompId) == 0) {
            return false;
        }
        else {
            return true;
        }

    }

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
    @Override
    public void executeProcess(String userId, String refJobId, Object vo, BigDecimal vmSeq, String reqKey) throws JsonGenerationException, JsonMappingException, IOException {

        int procssInstSeq = 0;

        RrProcssInst rrProcssInst = new RrProcssInst();
        rrProcssInst.setRefJobId(refJobId);
        rrProcssInst.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
        rrProcssInst.setStatCd(OprConstant.PROCESS_STAT_CD_01);
        cRrProcssInstDao.insertRrProcssInst(rrProcssInst);

        procssInstSeq = rrProcssInst.getProcssInstSeq();

        // 프로세스 업무목록정보 추가
        RrProcssJobList rrProcssJobList = new RrProcssJobList();
        rrProcssJobList.setProcssInstSeq(procssInstSeq);
        rrProcssJobList.setRegUserId(userId);
        rrProcssJobList.setStatCd(OprConstant.PROCESS_STAT_CD_01);
        rrProcssJobList.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
        cRrProcssJobListDao.insertRrProcssJobList(rrProcssJobList);

        // 프로세스 변수목록 추가
        RrProcssVarList rrProcssVarList = new RrProcssVarList();
        rrProcssVarList.setProcssInstSeq(procssInstSeq);
        rrProcssVarList.setProcssSeq(OprConstant.VM_REQ_COM_PROCESS_ID);
        cRrProcssVarListDao.insertRrProcssVarList(rrProcssVarList);

        rrProcssVarList.setVarNm(OprConstant.REQ_JSON_DATA_NM);
        rrProcssVarList.setVarVl(new ObjectMapper().writeValueAsString(vo));
        cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

        rrProcssVarList.setVarNm(OprConstant.REQ_VM_SEQ_NM);
        rrProcssVarList.setVarVl(vmSeq.toString());
        cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

        rrProcssVarList.setVarNm(OprConstant.REQ_REQ_KEY_NM);
        rrProcssVarList.setVarVl(reqKey);
        cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

//        rrProcssVarList.setVarNm(OprConstant.REQ_REQ_USERID_NM);
//        rrProcssVarList.setVarVl(userId);
//        cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

        String title = null;
        if (vo instanceof VmSnapReqVo) {
        	VmSnapReqVo vmSnapReqVo = (VmSnapReqVo) vo;

        	if(OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_CRE.equals(refJobId))
        		title = vmSnapReqVo.getSnapshtNm() + " 스냅샷 생성" ;
        	else if(OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_RESTOR.equals(refJobId))
        		title = vmSnapReqVo.getSnapshtNm() + " 스냅샷 복원" ;
        	else if(OprConstant.PROCESS_REF_JOB_KEY_VM_SNAP_DEL.equals(refJobId))
        		title = vmSnapReqVo.getSnapshtNm() + " 스냅샷 삭제";
		}
        else if (vo instanceof VmMigrVo) {
        	VmMigrVo vmMigrVo = (VmMigrVo) vo;

        	title = vmMigrVo.getVmNm() + " 마이그레이션";
        }

        rrProcssVarList.setVarNm(OprConstant.REQ_REQ_TITLE_NM);
        rrProcssVarList.setVarVl(title);
        cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

    }

    /**
     * 가상서버 스냅샷 목록 조회
     *
     * @param vmSeq
     * @return
     */
    @Override
    public List<VmSnapVo> selectVmSnapList(BigDecimal vmSeq) {
        return vmDao.selectVmSnapList(vmSeq);
    }

    /**
     * 가상서버 자원 이력 조회
     *
     * @param vmResHistSearchVo
     * @return
     */
    @Override
    public List<VmResHistVo> selectVmResHistList(VmResHistSearchVo vmResHistSearchVo, boolean isPagination) {
        List<VmResHistVo> vmResHistList = null;

        int totalCount = vmDao.selectVmHistTotCnt(vmResHistSearchVo);

        if (isPagination && totalCount > 0) {
            vmResHistSearchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        }
        else if (!isPagination) {
            vmResHistSearchVo.setPaginationInfo(null);
        }

        if (totalCount > 0) {
            vmResHistList = vmDao.selectVmResHistList(vmResHistSearchVo);
        }

        return vmResHistList;
    }

    /**
     * 가상서버 마이그레이션 이력 조회
     *
     * @param vmMigrHistSearchVo
     * @return
     */
    @Override
    public List<VmMigrHistVo> selectVmMigrHistList(VmMigrHistSearchVo vmMigrHistSearchVo, boolean isPagination) {
        List<VmMigrHistVo> vmMigrHistList = null;

        int totalCount = vmDao.selectVmHistTotCnt(vmMigrHistSearchVo);

        if (isPagination && totalCount > 0) {
            vmMigrHistSearchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        }
        else if (!isPagination) {
            vmMigrHistSearchVo.setPaginationInfo(null);
        }

        if (totalCount > 0) {
            vmMigrHistList = vmDao.selectVmMigrHistList(vmMigrHistSearchVo);
        }

        return vmMigrHistList;
    }

    /**
     * 가상서버 스냅샷 이력 조회
     *
     * @param vmSnapHistSearchVo
     * @return
     */
    @Override
    public List<VmSnapHistVo> selectVmSnapHistList(VmSnapHistSearchVo vmSnapHistSearchVo, boolean isPagination) {
        List<VmSnapHistVo> vmSnapHistList = null;

        int totalCount = vmDao.selectVmHistTotCnt(vmSnapHistSearchVo);

        if (isPagination && totalCount > 0) {
            vmSnapHistSearchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        }
        else if (!isPagination) {
            vmSnapHistSearchVo.setPaginationInfo(null);
        }

        if (totalCount > 0) {
            vmSnapHistList = vmDao.selectVmSnapHistList(vmSnapHistSearchVo);
        }

        return vmSnapHistList;
    }

    /**
     * 가상서버 구성변경 이력 조회
     *
     * @param vmCompHistSearchVo
     * @return
     */
    @Override
    public List<VmCompHistVo> selectVmCompHistList(VmCompHistSearchVo vmCompHistSearchVo, boolean isPagination) {
        List<VmCompHistVo> vmCompHistList = null;

        int totalCount = vmDao.selectVmHistTotCnt(vmCompHistSearchVo);

        if (isPagination && totalCount > 0) {
            vmCompHistSearchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        }
        else if (!isPagination) {
            vmCompHistSearchVo.setPaginationInfo(null);
        }

        if (totalCount > 0) {
            vmCompHistList = vmDao.selectVmCompHistList(vmCompHistSearchVo);
        }

        return vmCompHistList;
    }

    /**
     * 가상서버 스냅샷 요청 정보 조회
     *
     * @param vmSnapVo
     * @return
     */
    @Override
    public VmSnapReqVo selectVmSnapReq(VmSnapVo vmSnapVo) {
        return vmDao.selectVmSnapReq(vmSnapVo);
    }

    /**
     * 가상서버 패키지 대상 여부 정보 수정
     *
     * @param vmVo
     * @return
     */
    public void updateRcVmPackgMngTrgtYn(VmVo vmVo) {
        cRcVmDao.updateRcVmPackgMngTrgtYn(vmVo);
    }

    /**
     * 가상서버 스냅샷 요청 정보 조회
     *
     * @param vmProcssVo
     * @return
     */
    @Override
    public VmProcssVo selectVmProcss(VmProcssVo vmProcssVo) {
        return vmDao.selectVmProcss(vmProcssVo);
    }

    /**
     * 가상서버 자원요청 및 처리 내역 조회
     *
     * @param vmSeq
     * @return
     */
    @Override
    public List<VmProcssMsgVo> selectVmProcssMsgList(BigDecimal vmSeq) {
        return vmDao.selectVmProcssMsgList(vmSeq);
    }

    /**
     * 가상서버 마이그레이션 상세 정보
     *
     * @param procssInstSeq
     * @return
     */
    @Override
    public String selectVmProcssVarList(BigDecimal procssInstSeq) {
        return vmDao.selectVmProcssVarList(procssInstSeq);
    }

}
