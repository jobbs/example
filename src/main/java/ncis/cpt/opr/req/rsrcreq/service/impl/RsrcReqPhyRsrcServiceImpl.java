package ncis.cpt.opr.req.rsrcreq.service.impl;

/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>물리자원 서비스 -impl</pre>
 *
 * @filename RsrcReqProcssServiceImpl.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     김봉민         v1.0             최초생성
 *
 */
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRrProcssInstDao;
import ncis.cmn.dao.CRrProcssJobListDao;
import ncis.cmn.dao.CRrProcssVarListDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlPRsrcDao;
import ncis.cmn.entity.RrProcssInst;
import ncis.cmn.entity.RrProcssJobList;
import ncis.cmn.entity.RrProcssVarList;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqMngDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqPhyRsrcDao;
import ncis.cpt.opr.req.rsrcreq.exception.RsrcReqExeception;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqPhyRsrcService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 김봉민
 *
 */
@Service("rsrcReqPhyRsrcService")
public class RsrcReqPhyRsrcServiceImpl implements RsrcReqPhyRsrcService {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqPhyRsrcServiceImpl.class);

	@Resource(name = "rsrcReqMngDao")
	private RsrcReqMngDao rsrcReqMngDao;

	@Resource(name = "rsrcReqPhyRsrcDao")
	private RsrcReqPhyRsrcDao rsrcReqPhyRsrcDao;

	@Resource(name="cRrRsrcReqDao")
	private CRrRsrcReqDao cRrRsrcReqDao;

	@Resource(name="cRrRsrcReqDtlPRsrcDao")
	private CRrRsrcReqDtlPRsrcDao cRrRsrcReqDtlPRsrcDao;

	@Resource(name = "cRrProcssInstDao")
	private CRrProcssInstDao cRrProcssInstDao;

	@Resource(name = "cRrProcssJobListDao")
	private CRrProcssJobListDao cRrProcssJobListDao;

	@Resource(name = "cRrProcssVarListDao")
	private CRrProcssVarListDao cRrProcssVarListDao;


	/**
	 * 자원 요청 상세 기본 정보 조회
	 */
	@Override
	public RsrcReqVo selectRsrcReqInfo(RsrcReqMngSearchVo searchVo) {
		return  this.rsrcReqMngDao.selectRsrcReqDtl(searchVo);
	}


	/**
	 * 물리자원 추가
	 */
	@Override
	public RsrcReqPhyRsrcVo selectRsrcReqPhySrvrAdd(String rsrcReqNo) {
		RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
		 searchVo.setRsrcReqNo(rsrcReqNo);

		List<RsrcReqPhyRsrcVo> list = rsrcReqPhyRsrcDao.selectRsrcReqPhySrvrAdd(searchVo);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 물리자원 삭제
	 * @param searchVo
	 * @return
	 */
	public RsrcReqPhyRsrcVo selectRsrcReqPhySrvrDel(String rsrcReqNo) {
		RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
		 searchVo.setRsrcReqNo(rsrcReqNo);

		List<RsrcReqPhyRsrcVo> list = rsrcReqPhyRsrcDao.selectRsrcReqPhySrvrDel(searchVo);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 클러스터 추가
	 */
	public RsrcReqPhyRsrcVo selectRsrcReqClstrAdd(String rsrcReqNo){
		RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
		 searchVo.setRsrcReqNo(rsrcReqNo);

		List<RsrcReqPhyRsrcVo> list = rsrcReqPhyRsrcDao.selectRsrcReqPhyClstrAdd(searchVo);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 클러스터 삭제
	 */
	public RsrcReqPhyRsrcVo selectRsrcReqClstrDel(String rsrcReqNo){
		RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
		 searchVo.setRsrcReqNo(rsrcReqNo);

		List<RsrcReqPhyRsrcVo> list = rsrcReqPhyRsrcDao.selectRsrcReqClstrDel(searchVo);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	/**
	 *  물리자원 추가,삭제 (실행 /반려) 상태 업데이트
	 */
	@Override
	public String updateRsrcReqPhyRsrcExe(RsrcReqPhyRsrcVo vo, String exeUserId) throws Exception{
		try{
			// 자원 요청 업데이트
			RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
			searchVo.setRsrcReqNo(vo.getRsrcReqNo());
			RsrcReqPhyRsrcVo resultVo = rsrcReqPhyRsrcDao.selectRsrcReqPhyRsrc(searchVo);

			String resultmessage = resultVo.getRsrcReqTyNm() + " "+ OprConstant.RSRC_EXEC_FAIL_MSG;

			int prcessSeq = 0;
			//물리서버추가
			if( vo.getRsrcReqTyCd().equals(OprConstant.RSRC_REQ_TY_CD_PM_ADD)){
				prcessSeq =   OprConstant.PM_ADD_PROCESS_ID;
			}else if( vo.getRsrcReqTyCd().equals(OprConstant.RSRC_REQ_TY_CD_PM_DEL)){
				prcessSeq =   OprConstant.PM_DEL_PROCESS_ID;

				if(resultVo.getPmCompId() != null &&  this.rsrcReqPhyRsrcDao.selectDisableDeleteVmCnt(resultVo.getPmSeq()) >0){
					String errormessage ="\nreason=물리서버 하위에 삭제할 수 없는 가상서버가 존재합니다.(자원요청번호 = "+ resultVo.getRsrcReqNo() +", 물리서버구성 ID ="+ resultVo.getPmCompId()+")";
					logger.warn(errormessage);
					throw new RsrcReqExeception(errormessage);
				}

			}else if( vo.getRsrcReqTyCd().equals(OprConstant.RSRC_REQ_TY_CD_CLSTR_ADD)){
				prcessSeq =   OprConstant.CL_ADD_PROCESS_ID;
			}else if( vo.getRsrcReqTyCd().equals(OprConstant.RSRC_REQ_TY_CD_CLSTR_DEL)){
				prcessSeq =   OprConstant.CL_DEL_PROCESS_ID;
			}

			int procssInstSeq =  executeProcess(vo.getRsrcReqNo(),exeUserId, prcessSeq);
			if( procssInstSeq>0){
				updateRsrcReqPhyRsrc(vo,exeUserId , new BigDecimal(procssInstSeq) );
				resultmessage = resultVo.getRsrcReqTyNm() +" "+ OprConstant.RSRC_EXEC_SUCC_MSG;
			}
			return resultmessage;
		}catch(RsrcReqExeception e){
			throw e;
		}catch(Exception e){
			throw new Exception("물리자원 실행 요청에 실패하였습니다. 자원요청번호="+ vo.getRsrcReqNo());
		}
	}

	/**
	 * 실행 액션
	 * @param rsrcReqNo
	 * @return
	 */
	private int executeProcess(String rsrcReqNo, String exeUserId, int prcessSeq){
		/*  프로세스 인스턴스정보 추가 */
		RrProcssInst rrProcssInst = new RrProcssInst();
		rrProcssInst.setRsrcReqNo(rsrcReqNo);
		rrProcssInst.setProcssSeq(prcessSeq);
		rrProcssInst.setStatCd(OprConstant.PROCESS_STAT_CD_01);
		cRrProcssInstDao.insertRrProcssInst(rrProcssInst);

		//프로세스 업무목록정보 추가
		RrProcssJobList rrProcssJobList = new RrProcssJobList();
		rrProcssJobList.setProcssInstSeq(rrProcssInst.getProcssInstSeq());
		rrProcssJobList.setRegUserId(exeUserId);
		rrProcssJobList.setStatCd(OprConstant.PROCESS_STAT_CD_01);
		rrProcssJobList.setProcssSeq(prcessSeq);
		cRrProcssJobListDao.insertRrProcssJobList(rrProcssJobList);

		//프로세스 변수목록 추가
		RrProcssVarList rrProcssVarList = new RrProcssVarList();
		rrProcssVarList.setProcssInstSeq(rrProcssJobList.getProcssInstSeq());
		rrProcssVarList.setProcssSeq(prcessSeq);
		cRrProcssVarListDao.insertRrProcssVarList(rrProcssVarList);

		return rrProcssInst.getProcssInstSeq();
	}


	/**
	 *  자원요청상세_물리자원_반려
	 */
	@Override
	public String updateRsrcReqPhyRsrcRjct(RsrcReqPhyRsrcVo vo, String exeUserId)  throws Exception {
		// 자원 요청 업데이트
		RsrcReqPhyRsrcSearchVo searchVo = new RsrcReqPhyRsrcSearchVo();
		searchVo.setRsrcReqNo(vo.getRsrcReqNo());
		RsrcReqPhyRsrcVo resultVo = rsrcReqPhyRsrcDao.selectRsrcReqPhyRsrc(searchVo);

		String resultmessage = resultVo.getRsrcReqTyNm() +" "+ OprConstant.RSRC_EXEC_FAIL_MSG;

		updateRsrcReqPhyRsrc(vo,exeUserId, null);
		resultmessage = resultVo.getRsrcReqTyNm()+" "+ OprConstant.RSRC_EXEC_SUCC_MSG;

		return resultmessage;

	}

	/**
	 * 물리자원 상태 수정
	 * @param rsrcReqPhyRsrcVo
	 * @param exeUserId
	 */
	public void updateRsrcReqPhyRsrc(RsrcReqPhyRsrcVo rsrcReqPhyRsrcVo, String exeUserId,BigDecimal procssInstSeq) {
		// 자원요청 상태 업데이트
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setRsrcReqNo(rsrcReqPhyRsrcVo.getRsrcReqNo());
		rrRsrcReq.setExeUserId(exeUserId);
		rrRsrcReq.setRsrcReqPrcssStatCd(rsrcReqPhyRsrcVo.getRsrcReqPrcssStatCd());
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

		// 물리 자원 반려 상태 수정
		RrRsrcReqDtlPRsrc rrDtlPRsrc = new RrRsrcReqDtlPRsrc();
		rrDtlPRsrc.setRsrcReqNo(rsrcReqPhyRsrcVo.getRsrcReqNo());
		rrDtlPRsrc.setRsrcReqPrcssStatCd(rsrcReqPhyRsrcVo.getRsrcReqPrcssStatCd());
		rrDtlPRsrc.setRjctTyCd(rsrcReqPhyRsrcVo.getRjctTyCd());
		rrDtlPRsrc.setRjctReasn(rsrcReqPhyRsrcVo.getRjctReasn());
		rrDtlPRsrc.setPmId(rsrcReqPhyRsrcVo.getPmId());
		rrDtlPRsrc.setClstrId(rsrcReqPhyRsrcVo.getClstrId());
		rrDtlPRsrc.setProcssInstSeq(procssInstSeq);
		rrDtlPRsrc.setZoneId(rsrcReqPhyRsrcVo.getZoneId());
		rrDtlPRsrc.setNetClCd(rsrcReqPhyRsrcVo.getNetClCd());
		rrDtlPRsrc.setRsrcPoolId(rsrcReqPhyRsrcVo.getRsrcPoolId());
		rrDtlPRsrc.setDataCntrSeq(rsrcReqPhyRsrcVo.getDataCntrSeq());
		cRrRsrcReqDtlPRsrcDao.updateRsrcReqPhyRsrcPrcssStatCd(rrDtlPRsrc);
	}

	/**
	 * 데이터센터목록 조회
	 */
	public List<RsrcReqPhyRsrcVo> selectDataCntrList() {
		List<RsrcReqPhyRsrcVo> list = null;
		list = rsrcReqPhyRsrcDao.selectDataCntrList();
		return list;
	}


}
