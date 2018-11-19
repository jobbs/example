/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqProcssServiceImpl.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRnIpDao;
import ncis.cmn.dao.CRrProcssInstDao;
import ncis.cmn.dao.CRrProcssJobListDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlNetwkDao;
import ncis.cmn.dao.CRrRsrcReqDtlPRsrcDao;
import ncis.cmn.dao.CRrRsrcReqDtlVmDao;
import ncis.cmn.dao.CRrTmplatDao;
import ncis.cmn.entity.RrProcssInst;
import ncis.cmn.entity.RrProcssJobList;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;
import ncis.cmn.entity.RrRsrcReqDtlVm;
import ncis.cmn.security.vo.UserVo;
import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobSearchVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqMngDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqProcssDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqVmDao;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqNetwkService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqPhyRsrcService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqProcssService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.ProcssInstVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssListVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssVo;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 김봉민
 *
 */
@Service("rsrcReqProcssService")
public class RsrcReqProcssServiceImpl implements RsrcReqProcssService {

	private final Logger logger = LoggerFactory.getLogger(RsrcReqProcssServiceImpl.class);

	@Resource(name = "rsrcReqProcssDao")
	private RsrcReqProcssDao rsrcReqProcssDao;

	@Resource(name = "cRrProcssJobListDao")
	private CRrProcssJobListDao cRrProcssJobListDao;

	@Resource(name = "cRrProcssInstDao")
	private CRrProcssInstDao cRrProcssInstDao;

	@Resource(name = "cRrRsrcReqDao")
	private CRrRsrcReqDao cRrRsrcReqDao;

	@Resource(name = "cRrRsrcReqDtlVmDao")
	private CRrRsrcReqDtlVmDao cRrRsrcReqDtlVmDao;

	@Resource(name = "cRrRsrcReqDtlPRsrcDao")
	private CRrRsrcReqDtlPRsrcDao cRrRsrcReqDtlPRsrcDao;

	@Resource(name = "cRrRsrcReqDtlNetwkDao")
	private CRrRsrcReqDtlNetwkDao cRrRsrcReqDtlNetwkDao;

	@Resource(name = "rsrcReqMngDao")
	private RsrcReqMngDao rsrcReqMngDao;

	@Resource(name="rsrcReqVmDao") private RsrcReqVmDao rsrcReqVmDao;

	@Resource(name="cRnIpDao") private CRnIpDao cRnIpDao;

	@Resource(name="rsrcReqVmService")		private RsrcReqVmService rsrcReqVmService;
	@Resource(name="rsrcReqPhyRsrcService")	private RsrcReqPhyRsrcService rsrcReqPhyRsrcService;
	@Resource(name="rsrcReqNetwkService")	private RsrcReqNetwkService rsrcReqNetwkService;

	@Resource(name="cRrTmplatDao") private CRrTmplatDao cTmplatDao;

	/**
	 * 프로세서 인스턴스 조회
	 */
	@Override
	public ProcssInstVo selectProcssInst(BigDecimal procssInstSeq ){
		ProcssInstSearchVo searchVo = new ProcssInstSearchVo();
		searchVo.setProcssInstSeq(procssInstSeq);
		return this.rsrcReqProcssDao.selectProcssInst(searchVo);
	}

	/**
	 * 단위 넙무 프로세스 목록 조회
	 */
	@Override
	public List<UnitJobProcssVo> selectUnitJobProcssList(BigDecimal procssInstSeq) throws Exception{
		List<UnitJobProcssVo> resultList = selectStep1( procssInstSeq);
		return resultList;
	}

	/**
	 * 단위 업무 프로세스
	 * @param procssInstSeq
	 * @return
	 * @throws Exception
	 */
	private List<UnitJobProcssVo> selectStep1(BigDecimal procssInstSeq) throws Exception{
		if(procssInstSeq == null)  return null;

		ProcssInstSearchVo searchVo = new ProcssInstSearchVo();
		searchVo.setProcssInstSeq(procssInstSeq);
		ProcssInstVo procssInstVo = this.rsrcReqProcssDao.selectProcssInst(searchVo);

		if(procssInstVo == null){
			logger.warn("프로세스 ID를 조회할 수 없습니다.");
			return null;
		}

		BigDecimal procssSeq = new BigDecimal(procssInstVo.getProcssSeq());
		return selectUnitJobListStep(procssInstSeq, procssSeq );
	}

	/**
	 * 단위 업무 목록 조회 상세
	 * @param procssInstSeq
	 * @param procssSeq
	 * @return
	 * @throws Exception
	 */
	private List<UnitJobProcssVo> selectUnitJobListStep(BigDecimal procssInstSeq, BigDecimal procssSeq) throws Exception {
		if(procssSeq == null) return null;
		List<UnitJobProcssVo> list = new ArrayList<UnitJobProcssVo>();

		UnitJobSearchVo  searchVo = new UnitJobSearchVo();
		searchVo.setProcssSeq(procssSeq.intValue());
		UnitJobVo fUnitJobVo= this.rsrcReqProcssDao.selectUnitJobList(searchVo).get(0);

		//현재 단위 작업의 정보를 조회
		UnitJobProcssVo nextVo = new UnitJobProcssVo();
		nextVo.setProcssSeq(fUnitJobVo.getProcssSeq());
		nextVo.setuJobId( fUnitJobVo.getuJobId());

		list.add( selectUnitProcssInfo(new BigDecimal(fUnitJobVo.getProcssSeq()), fUnitJobVo.getuJobId() , procssInstSeq));

		while(nextVo != null){
			//현 SEQ, ID를 통한  다음 단위 업무 목록 조회
			UnitJobSearchVo nextSearchVo = new UnitJobSearchVo();
			nextSearchVo.setProcssSeq(nextVo.getProcssSeq());
			nextSearchVo.setuJobId(nextVo.getuJobId());
			List<UnitJobRelateVo> unitJobRelateVoList = this.rsrcReqProcssDao.selectNextUnitJobRelateList(nextSearchVo);

			nextVo = null;
			if(unitJobRelateVoList ==null ||unitJobRelateVoList.size()==0){
				logger.debug("list size ="+ list.size());
			}else{
				for(UnitJobRelateVo aVo : unitJobRelateVoList){
					UnitJobProcssVo tmp = validateUnitJob(aVo, procssInstSeq);
					if(tmp!=null){
						tmp.setuJobId(aVo.getEndUJobId());	//다음 작업을 위한  단위 업무 id 설정
						if(tmp !=null) {
							list.add(tmp);
							nextVo = tmp;
						}
					}
				}
			}
		}
		return list.size()>0 ? list : null;
	}

	/**
	 * 단위 업무 프로세스 정보 조회
	 * @param procssSeq
	 * @param uJobId
	 * @param procssInstSeq
	 * @return
	 * @throws Exception
	 */
	private UnitJobProcssVo selectUnitProcssInfo(BigDecimal procssSeq, String uJobId, BigDecimal procssInstSeq) throws Exception {
		UnitJobProcssSearchVo searchVo = new UnitJobProcssSearchVo();
		searchVo.setProcssSeq(procssSeq);
		searchVo.setuJobId(uJobId);
		searchVo.setProcssInstSeq(procssInstSeq);
		UnitJobProcssVo resultVo = this.rsrcReqProcssDao.selectUnitProcssJobInfo(searchVo);
		resultVo.setUnitJobProcssListVoList(subList(resultVo));
		return resultVo;
	}

	/**
	 * 단위 업무 하위 목록 조회
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	private List<UnitJobProcssListVo> subList(UnitJobProcssVo vo) throws Exception{
		final  String U_JOB_TY_CD_03 = "03"; //하위 진행
		if(!vo.getuJobTyCd().equals(U_JOB_TY_CD_03)){
			return null;
		}

		UnitJobSearchVo ujSearchVo = new UnitJobSearchVo();
		ujSearchVo.setProcssSeq(vo.getLowProcssSeq().intValue());
		UnitJobVo fUnitJobVo= this.rsrcReqProcssDao.selectUnitJobList(ujSearchVo).get(0);
		if(fUnitJobVo == null){
			throw new Exception("하위 업무가  존재해야 하지만 실 단위업무가 존재하지 않습니다.");
		}

		BigDecimal procssSeq =new BigDecimal(fUnitJobVo.getProcssSeq());
		String uJobId=  fUnitJobVo.getuJobId();
		BigDecimal upperProcssInstSeq = vo.getProcssInstSeq();

		List<UnitJobProcssListVo> resultList = new ArrayList<UnitJobProcssListVo>();

		UnitJobProcssSearchVo searchVo = new UnitJobProcssSearchVo();
		searchVo.setProcssSeq(procssSeq);
		searchVo.setuJobId(uJobId);
		searchVo.setUpperProcssInstSeq(upperProcssInstSeq);

		List<UnitJobProcssVo> list = this.rsrcReqProcssDao.selectUnitProcssJobInfoList(searchVo);

		if(list != null && list.size()>0){
			for(UnitJobProcssVo aVo : list){
				List<UnitJobProcssVo>  unitJobProcssVoList = selectStep1(aVo.getProcssInstSeq());
				UnitJobProcssListVo newVo = new UnitJobProcssListVo();
				newVo.setProcssSeq(new BigDecimal(aVo.getProcssSeq()));
				newVo.setuJobId(aVo.getuJobId());
				newVo.setProcssInstSeq(aVo.getProcssInstSeq());
				newVo.setUnitJobProcssVoList(unitJobProcssVoList);
				resultList.add(newVo);
			}
		}
		return resultList;
	}

	/**
	 * 단위 업무의 정보 조회 및 검사
	 * @param processSeq
	 * @param uJobId
	 * @return
	 * @throws Exception
	 */
	private UnitJobProcssVo validateUnitJob(UnitJobRelateVo vo, BigDecimal procssInstSeq) throws Exception{

		boolean valid = false;

		if(vo.getEndUJobCndVarId() != null){
			UnitJobProcssSearchVo searchVo = new UnitJobProcssSearchVo();
			searchVo.setProcssSeq(vo.getProcssSeq());
			searchVo.setStrtUJobId(vo.getStrtUJobId());
			searchVo.setEndUJobId(vo.getEndUJobId());
			searchVo.setProcssInstSeq(procssInstSeq);
			if(rsrcReqProcssDao.selectUnitJobValidate(searchVo) !=null){
				valid = true;
			}
		}else{
			valid = true;
		}
		if(!valid){
			return null;
		}

		UnitJobProcssVo resultVo = selectUnitProcssInfo(vo.getProcssSeq(), vo.getEndUJobId(), procssInstSeq);
		return resultVo;
	}

	/**
	 * 단위업무 상태를 진행중으로 변경
	 * @param unitJobRelateVo
	 */
	public void updateUnitProcssJobStat(UnitJobProcssVo unitJobProcssVo) throws Exception {
		RrProcssJobList rrProcssJobList = new RrProcssJobList();
		BeanUtils.copyProperties(rrProcssJobList, unitJobProcssVo);
		rrProcssJobList.setStatCd("01");
		cRrProcssJobListDao.updateProcssJobStat(rrProcssJobList);

		RrProcssInst rrProcssInst = new RrProcssInst();
		rrProcssInst.setProcssInstSeq(unitJobProcssVo.getProcssInstSeq().intValue());
		rrProcssInst.setStatCd("01");
		cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		if(unitJobProcssVo.getRsrcReqNo() !=null ) {
			RrRsrcReq rrRsrcReq = new RrRsrcReq();
			rrRsrcReq.setRsrcReqNo(unitJobProcssVo.getRsrcReqNo());
			rrRsrcReq.setRsrcReqPrcssStatCd("02");
			cRrRsrcReqDao.updateRsrcReqPrcssStat(rrRsrcReq);
		}
	}


	/**
	 * 프로세스 실행 취소
	 * @param unitJobRelateVo
	 */
	public void updateRsrcReqProcssCancel(UnitJobProcssVo upVo, String userId) throws Exception {
		//프로세스 인스턴스 상태를 취소로 변경
		RrProcssInst rrProcssInst = new RrProcssInst();
		rrProcssInst.setProcssInstSeq(upVo.getProcssInstSeq().intValue());
		rrProcssInst.setStatCd("05"); //실행취소
		cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		if(upVo.getRsrcReqNo() !=null ) {
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(upVo.getRsrcReqNo());
			RsrcReqVo rrVo = this.rsrcReqMngDao.selectRsrcReqDtl(searchVo);
			rrVo.setRsrcReqSeq(upVo.getRsrcReqSeq());
			updateRrStatInit(rrVo, userId);

			cTmplatDao.updateRrTmplatRsrcReqInit(upVo.getRsrcReqNo()); //가상서버 생성 진행여부를 'N'으로 초기화
		}
	}

	/**
	 * 자원요청 상태 초기화
	 * @param rrVo
	 * @param rrProcssStat
	 * @param reasn
	 */
	private void updateRrStatInit(RsrcReqVo rrVo, String userId) {

		// 자원요청 상태를 '요청'으로 변경
		String rrProcssStat = OprConstant.RSRC_REQ_PRCSS_STAT_REQ;

		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setRsrcReqNo(rrVo.getRsrcReqNo());
		rrRsrcReq.setRsrcReqPrcssStatCd(rrProcssStat);
		// HA 인경우 '처리중'으로 변경
		if(OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rrVo.getRsrcReqTyCd()) && "Y".equals(rrVo.getHaCompYn()))
		{
			rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_PRCSS);
		}
		else
		{
			rrRsrcReq.setRsrcReqPrcssStatCd(rrProcssStat);
		}

		cRrRsrcReqDao.updateRsrcReqPrcssStat(rrRsrcReq);

		if (OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_VM_DEL.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_VM_STRG_ADD.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_VM_STRG_DEL.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_VM_SPEC_CHNG.equals(rrVo.getRsrcReqTyCd())) {
			// 자원요청상세 실행정보를 초기화
			RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
			if(OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rrVo.getRsrcReqTyCd()) && "Y".equals(rrVo.getHaCompYn()))
			{
				rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.PROCESS_STAT_CD_03);
			}
			else
			{
				rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(rrProcssStat);
			}
			rrRsrcReqDtlVm.setRsrcReqNo(rrVo.getRsrcReqNo());
			rrRsrcReqDtlVm.setRsrcReqSeq(rrVo.getRsrcReqSeq());
			cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmInitExeInfo(rrRsrcReqDtlVm);

			if(OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rrVo.getRsrcReqTyCd()) && !"Y".equals(rrVo.getHaCompYn())) {
				List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = null;  // 할당된 IP를 미할당으로 변경
				rsrcReqNetwkIntfcList = rsrcReqVmDao.selectRsrcReqNetwkIntfcList(rrVo.getRsrcReqNo(), "N");
				IpVo ipVo = new IpVo();

				for(RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList) {
					ipVo.setUpdtUserId(userId);
					ipVo.setIpStatCd(OprConstant.IP_STAT_CD_02);  //미할당
					ipVo.setIpAddr(rsrcReqNetwkIntfcVo.getIpAddr());
					ipVo.setBndSeq(rsrcReqNetwkIntfcVo.getIpBndSeq());
					// 2017-08-21 IP주소""일 경우, SQLException 발생.
					if(!StringUtils.isEmpty(rsrcReqNetwkIntfcVo.getIpAddr())) cRnIpDao.updateIpList(ipVo);  //해당 IP정보를 미할당으로 업데이트
				}
			}

		} else if (OprConstant.RSRC_REQ_TY_CD_PM_ADD.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_PM_DEL.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_CLSTR_ADD.equals(rrVo.getRsrcReqTyCd())
				|| OprConstant.RSRC_REQ_TY_CD_CLSTR_DEL.equals(rrVo.getRsrcReqTyCd())) {
			RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc = new RrRsrcReqDtlPRsrc();
			rrRsrcReqDtlPRsrc.setRsrcReqPrcssStatCd(rrProcssStat);
			rrRsrcReqDtlPRsrc.setRsrcReqNo(rrVo.getRsrcReqNo());
			rrRsrcReqDtlPRsrc.setRsrcReqSeq(rrVo.getRsrcReqSeq());
			cRrRsrcReqDtlPRsrcDao.updateRrRsrcReqDtlPRsrcInitExeInfo(rrRsrcReqDtlPRsrc);
		} else if (OprConstant.RSRC_REQ_TY_CD_SLB_CRE.equals(rrVo.getRsrcReqTyCd())) {
			RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk = new RrRsrcReqDtlNetwk();
			rrRsrcReqDtlNetwk.setRsrcReqPrcssStatCd(rrProcssStat);
			rrRsrcReqDtlNetwk.setRsrcReqNo(rrVo.getRsrcReqNo());
			rrRsrcReqDtlNetwk.setRsrcReqSeq(rrVo.getRsrcReqSeq());
			cRrRsrcReqDtlNetwkDao.updateRrRsrcReqDtlNetwkInitExeInfo(rrRsrcReqDtlNetwk);
		}
	}

	/**
	 * 프로세스 강제완료
	 */
	@Override
	public void updateRsrcReqProcssManualComplete(UnitJobProcssVo upVo, String reasn,UserVo userVo) throws Exception {
		//프로세스 인스턴스 상태를 취소로 변경
		RrProcssInst rrProcssInst = new RrProcssInst();
		rrProcssInst.setProcssInstSeq(upVo.getProcssInstSeq().intValue());
		rrProcssInst.setStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT); //강제완료
		String rmk = "[강제완료:"+userVo.getUserNm()+"("+userVo.getUserId()+")] - "+ upVo.getRmk();
		rrProcssInst.setRmk(rmk);
		rrProcssInst.setForceComptYn(OprConstant.USE_YN_Y);
		cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(upVo.getRsrcReqNo());
		RsrcReqVo rrVo = this.rsrcReqMngDao.selectRsrcReqDtl(searchVo);
		rrVo.setRsrcReqSeq(upVo.getRsrcReqSeq());
		updateRrStat(rrVo, OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT);
	}

	/**
	 * 자원요청 상태 수정
	 * @param rrVo
	 * @param rrProcssStat
	 */
	private void updateRrStat(RsrcReqVo rrVo,String rrProcssStat) {
		if(rrVo.getRsrcReqNo() !=null ) {
			RrRsrcReq rrRsrcReq = new RrRsrcReq();
			rrRsrcReq.setRsrcReqNo(rrVo.getRsrcReqNo());
			rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT);
			cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

			if (OprConstant.RSRC_REQ_TY_CD_VM_CRE.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_VM_DEL.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_VM_STRG_ADD.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_VM_STRG_DEL.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_VM_SPEC_CHNG.equals(rrVo.getRsrcReqTyCd())) {
				// 자원요청상세 실행정보를 초기화
				RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
				rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(rrProcssStat);
				rrRsrcReqDtlVm.setRsrcReqNo(rrVo.getRsrcReqNo());
				rrRsrcReqDtlVm.setRsrcReqSeq(rrVo.getRsrcReqSeq());
				cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmSpecChng(rrRsrcReqDtlVm);
			} else if (OprConstant.RSRC_REQ_TY_CD_PM_ADD.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_PM_DEL.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_CLSTR_ADD.equals(rrVo.getRsrcReqTyCd())
					|| OprConstant.RSRC_REQ_TY_CD_CLSTR_DEL.equals(rrVo.getRsrcReqTyCd())) {
				RrRsrcReqDtlPRsrc rrRsrcReqDtlPRsrc = new RrRsrcReqDtlPRsrc();
				rrRsrcReqDtlPRsrc.setRsrcReqPrcssStatCd(rrProcssStat);
				rrRsrcReqDtlPRsrc.setRsrcReqNo(rrVo.getRsrcReqNo());
				rrRsrcReqDtlPRsrc.setRsrcReqSeq(rrVo.getRsrcReqSeq());
				cRrRsrcReqDtlPRsrcDao.updateRsrcReqPhyRsrcPrcssStatCd(rrRsrcReqDtlPRsrc);
			} else if (OprConstant.RSRC_REQ_TY_CD_SLB_CRE.equals(rrVo.getRsrcReqTyCd())) {
				RrRsrcReqDtlNetwk rrRsrcReqDtlNetwk = new RrRsrcReqDtlNetwk();
				rrRsrcReqDtlNetwk.setRsrcReqPrcssStatCd(rrProcssStat);
				rrRsrcReqDtlNetwk.setRsrcReqNo(rrVo.getRsrcReqNo());
				rrRsrcReqDtlNetwk.setRsrcReqSeq(rrVo.getRsrcReqSeq());
				cRrRsrcReqDtlNetwkDao.updateRsrcReqNetwkPrcssStatCd(rrRsrcReqDtlNetwk);
			}
		}
	}


	/**
	 * 자원풀 및 자원요청 상세 정보 조회
	 * @param rsrcReqNo
	 * @return
	 * @throws Exception
	 */
	public RsrcReqVo selectRsrcReqDtlPoolInfo(String rsrcReqNo) throws Exception {
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		RsrcReqVo resultVo = rsrcReqMngDao.selectRsrcReqDtl(searchVo);

		String rrTyCd = resultVo.getRsrcReqTyCd();

		if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_VM_CRE)){
			RsrcReqDtlVmVo vo = this.rsrcReqVmService.selectRsrcReqVmCre(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_VM_DEL)){
			RsrcReqDtlVmVo vo = this.rsrcReqVmService.selectRsrcReqVmDel(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_VM_SPEC_CHNG)
				|| rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_VM_STRG_ADD)
				|| rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_VM_STRG_DEL)){
			RsrcReqDtlVmVo vo = this.rsrcReqVmService.selectRsrcReqVmSpecChng(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_SLB_CRE) ){
			RsrcReqNetwkVo vo = this.rsrcReqNetwkService.selectRsrcReqNetwk(searchVo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_PM_ADD) ){
			RsrcReqPhyRsrcVo vo = this.rsrcReqPhyRsrcService.selectRsrcReqPhySrvrAdd(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_PM_DEL) ){
			RsrcReqPhyRsrcVo vo = this.rsrcReqPhyRsrcService.selectRsrcReqPhySrvrDel(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_CLSTR_ADD) ){
			RsrcReqPhyRsrcVo vo = this.rsrcReqPhyRsrcService.selectRsrcReqClstrAdd(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}else if(rrTyCd.equals(OprConstant.RSRC_REQ_TY_CD_CLSTR_DEL) ){
			RsrcReqPhyRsrcVo vo = this.rsrcReqPhyRsrcService.selectRsrcReqClstrDel(rsrcReqNo);
			resultVo.setZoneId(vo.getZoneId());
			resultVo.setNetClCd(vo.getNetClCd());
			resultVo.setNetId(vo.getNetId());
			resultVo.setUuid(vo.getUuid());
			resultVo.setRsrcPoolId(vo.getRsrcPoolId());
		}
		return resultVo;

	}

	/* (non-Javadoc)
	 * @see ncis.cpt.opr.req.rsrcreq.service.RsrcReqProcssService#updateRsrcReqAllManualComplete(ncis.cpt.opr.req.rsrcreq.vo.UnitJobProcssVo, java.lang.String, ncis.cmn.security.vo.UserVo)
	 */
	@Override
	public void updateRsrcReqAllManualComplete(UnitJobProcssVo upVo, String reasn,UserVo userVo) throws Exception
	{
		//상위 프로세스 인스턴스 상태를 완료로 변경
		RrProcssInst rrProcssInst = new RrProcssInst();
		rrProcssInst.setProcssInstSeq(upVo.getUpperProcssInstSeq().intValue());
		rrProcssInst.setStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT); //강제완료
		String rmk = "[강제완료:"+userVo.getUserNm()+"("+userVo.getUserId()+")] - "+ upVo.getRmk();
		rrProcssInst.setRmk(rmk);
		rrProcssInst.setForceComptYn(OprConstant.USE_YN_Y);
		cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(upVo.getRsrcReqNo());
		RsrcReqVo rrVo = this.rsrcReqMngDao.selectRsrcReqDtl(searchVo);
		rrVo.setRsrcReqSeq(upVo.getRsrcReqSeq());
		updateRrStat(rrVo, OprConstant.RSRC_REQ_PRCSS_STAT_CMPLT);
	}
}
