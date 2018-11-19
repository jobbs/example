/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqServiceImpl.java
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

import java.math.BigDecimal;

import javax.annotation.Resource;

import ncis.cmn.dao.CRrClstrPrposReqListDao;
import ncis.cmn.dao.CRrHaCompDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlPRsrcDao;
import ncis.cmn.dao.CRrRsrcReqDtlVmDao;
import ncis.cmn.entity.RrHaComp;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.service.RsrcReqService;
import ncis.cpt.rsrc.com.vo.RsrcReqClstrPrposVo;
import ncis.cpt.rsrc.com.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.rsrc.com.vo.RsrcReqPmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVmVo;
import ncis.cpt.rsrc.com.vo.RsrcReqVo;
import ncis.cpt.rsrc.zone.dao.NetDao;

import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("rsrcReqService")
public class RsrcReqServiceImpl implements RsrcReqService {

    @Resource(name = "netDao")
    private NetDao netDao;

    @Resource(name = "cRrRsrcReqDao")
    private CRrRsrcReqDao cRrRsrcReqDao;

    @Resource(name = "cRrRsrcReqDtlPRsrcDao")
    private CRrRsrcReqDtlPRsrcDao cRrRsrcReqDtlPRsrcDao;

    @Resource(name = "cRrClstrPrposReqListDao")
    private CRrClstrPrposReqListDao cRrClstrPrposReqListDao;

    @Resource(name = "cRrRsrcReqDtlVmDao")
    private CRrRsrcReqDtlVmDao cRrRsrcReqDtlVmDao;

    @Resource(name = "cRrHaCompDao")
    private CRrHaCompDao cRrHaCompDao;

    @Resource(name="commonService")
    private CommonService commonService;

    /**
     * 자원요청 클러스터 생성 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqClstrCreReq(RsrcReqVo rsrcReqVo) {

        if (rsrcReqVo.getRsrcReqPhyRsrcVoList() != null && rsrcReqVo.getRsrcReqPhyRsrcVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo : rsrcReqVo.getRsrcReqPhyRsrcVoList()) {
            	rsrcReqPhyRsrcVo.setRsrcReqSeq( new BigDecimal(seq++) );
                rsrcReqPhyRsrcVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqPhyRsrcVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqPhyRsrcVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());
                rsrcReqPhyRsrcVo.setNetClCd(netDao.selectNet(rsrcReqPhyRsrcVo.getNetId()).getNetClCd()); // 망구분코드
                cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(rsrcReqPhyRsrcVo);
                for (String clstrPrposCd : rsrcReqPhyRsrcVo.getClstrPrposCdList()) {
                    RsrcReqClstrPrposVo rsrcReqClstrPrposVo = new RsrcReqClstrPrposVo();
                    rsrcReqClstrPrposVo.setPrposClCd(clstrPrposCd);
                    rsrcReqClstrPrposVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                    rsrcReqClstrPrposVo.setRsrcReqSeq(rsrcReqPhyRsrcVo.getRsrcReqSeq());
                    cRrClstrPrposReqListDao.insertRrClstrPrposReqList(rsrcReqClstrPrposVo);
                }
            }
        }
    }

    /**
     * 자원요청 클러스터 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqClstrDelReq(RsrcReqVo rsrcReqVo) {
        if (rsrcReqVo.getRsrcReqPhyRsrcVoList() != null && rsrcReqVo.getRsrcReqPhyRsrcVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo : rsrcReqVo.getRsrcReqPhyRsrcVoList()) {
            	rsrcReqPhyRsrcVo.setRsrcReqSeq( new BigDecimal(seq++));
                rsrcReqPhyRsrcVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqPhyRsrcVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqPhyRsrcVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());

                cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(rsrcReqPhyRsrcVo);
            }
        }
    }

    /**
     * 자원요청 가상서버 생성 요청 추가
     * 테이블의 계층형이 아닌 3개의 테이블에 1:1:1 형태로 등록하도록 처리 함.
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqVmCreReq(RsrcReqVo rsrcReqVo) {

        if (rsrcReqVo.getRsrcReqVmVoList() != null && rsrcReqVo.getRsrcReqVmVoList().size() > 0) {

        	String displayYn = "Y"; //표시여부
        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

        	//HA 정보를 담고 있는 객체
        	RrHaComp rrHaComp = rsrcReqVo.getHaComp();

        	for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {

        		String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
        		rsrcReqVo.setRsrcReqNo(rsrcReqNo);
        		rsrcReqVo.setDisplayYn(displayYn);

        		//HA인 경우 대표 VM에(첫번째 VM) 대해서만 표시
        		if( "Y".equals(rsrcReqVo.getHaCompYn()) && "Y".equals(displayYn) ) {
        			rsrcReqVo.setDisplayYn(displayYn); //표시여부
        			rsrcReqVmVo.setExeStatCd(ComConstant.RSRC_REQ_EXE_STAT_CD_01); //미설정
        			displayYn = "N";
        		}

        		cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

        		rsrcReqVmVo.setRsrcReqSeq( new BigDecimal(1) );
                rsrcReqVmVo.setRsrcReqNo(rsrcReqNo);
                rsrcReqVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqVmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());

                cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(rsrcReqVmVo);

                //HA 여부가 Y일 경우
                if( "Y".equals(rsrcReqVo.getHaCompYn()) ) {
                	rrHaComp.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                    rrHaComp.setRsrcReqSeq( new BigDecimal(1) );
                    rrHaComp.setHaStatCd(rsrcReqVmVo.getHaStatCd());
                    cRrHaCompDao.insertRrHaComp(rrHaComp);
                }
            }
        }
    }

    /**
     * 자원요청 가상서버 스펙변경 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqVmSpecModReq(RsrcReqVo rsrcReqVo) {
        if (rsrcReqVo.getRsrcReqVmVoList() != null && rsrcReqVo.getRsrcReqVmVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
                rsrcReqVmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqVmVo.setRsrcReqSeq(new BigDecimal( seq++ ));
                rsrcReqVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqVmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());
                rsrcReqVmVo.setVmChngClCd(ComConstant.VM_CHNG_CL_CD_VM_SPEC_MOD); // 가상서버변경구분코드 - 가상서버 스펙 변경
                cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(rsrcReqVmVo);
            }
        }
    }

    /**
     * 자원요청 가상서버 스토리지추가 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqVmStrgAddReq(RsrcReqVo rsrcReqVo) {
        if (rsrcReqVo.getRsrcReqVmVoList() != null && rsrcReqVo.getRsrcReqVmVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
                rsrcReqVmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqVmVo.setRsrcReqSeq(new BigDecimal( seq++ ));
                rsrcReqVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqVmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());
                rsrcReqVmVo.setVmChngClCd(ComConstant.VM_CHNG_CL_CD_VM_STRG_ADD); // 가상서버변경구분코드 - 가상서버 스토리지 추가
                cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(rsrcReqVmVo);
            }
        }
    }

    /**
     * 자원요청 가상서버 스토리지삭제 요청 추가 (사용안함)
     *
     * @param rsrcReqVo
     */
    /*
     * @Override
     * public void insertRsrcReqVmStrgDelReq(RsrcReqVo rsrcReqVo) {
     * if (rsrcReqVo.getRsrcReqVmVoList() != null && rsrcReqVo.getRsrcReqVmVoList().size() > 0) {
     * cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);
     * for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
     * rsrcReqVmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
     * rsrcReqVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
     * rsrcReqVmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());
     * rsrcReqVmVo.setVmChngClCd(ComConstant.VM_CHNG_CL_CD_VM_STRG_ADD);
     * cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(rsrcReqVmVo);
     * }
     * }
     * }
     */

    /**
     * 자원요청 가상서버 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqVmDelReq(RsrcReqVo rsrcReqVo) {
        if (rsrcReqVo.getRsrcReqVmVoList() != null && rsrcReqVo.getRsrcReqVmVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqVmVo rsrcReqVmVo : rsrcReqVo.getRsrcReqVmVoList()) {
                rsrcReqVmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqVmVo.setRsrcReqSeq( new BigDecimal( seq++ ) );
                rsrcReqVmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqVmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());

                cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(rsrcReqVmVo);
            }
        }
    }

    /**
     * 자원요청 물리서버 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqPmDelReq(RsrcReqVo rsrcReqVo) {

        if (rsrcReqVo.getRsrcReqPmVoList() != null && rsrcReqVo.getRsrcReqPmVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqPmVo rsrcReqPmVo : rsrcReqVo.getRsrcReqPmVoList()) {
            	rsrcReqPmVo.setRsrcReqSeq(new BigDecimal(seq++));
                rsrcReqPmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqPmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqPmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());

                cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(rsrcReqPmVo);
            }
        }

    }

    /**
     * 자원요청 물리서버 생성 요청 추가
     *
     * @param rsrcReqVo
     */
    @Override
    public void insertRsrcReqPmCreReq(RsrcReqVo rsrcReqVo) {

        if (rsrcReqVo.getRsrcReqPmVoList() != null && rsrcReqVo.getRsrcReqPmVoList().size() > 0) {

        	String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
			rsrcReqVo.setRsrcReqNo(rsrcReqNo);

            cRrRsrcReqDao.insertRrRsrcReq(rsrcReqVo);

            int seq = 1;
            for (RsrcReqPmVo rsrcReqPmVo : rsrcReqVo.getRsrcReqPmVoList()) {
            	rsrcReqPmVo.setRsrcReqSeq(new BigDecimal(seq++));
                rsrcReqPmVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());
                rsrcReqPmVo.setRsrcReqTyCd(rsrcReqVo.getRsrcReqTyCd());
                rsrcReqPmVo.setRsrcReqPrcssStatCd(rsrcReqVo.getRsrcReqPrcssStatCd());

                cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(rsrcReqPmVo);
            }
        }

    }

}
