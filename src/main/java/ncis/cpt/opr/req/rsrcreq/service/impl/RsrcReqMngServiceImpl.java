package ncis.cpt.opr.req.rsrcreq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.vo.FileVo;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqMngDao;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqMngService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqNetwkService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqPhyRsrcService;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngFileVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

@Service("rsrcReqMngService")
public class RsrcReqMngServiceImpl implements RsrcReqMngService {

	@Resource(name="rsrcReqMngDao") private RsrcReqMngDao rsrcReqMngDao;
	@Resource(name="cRrRsrcReqDao") private CRrRsrcReqDao cRrRsrcReqDao;

	@Resource(name="rsrcReqVmService")	private RsrcReqVmService rsrcReqVmService;
	@Resource(name="rsrcReqPhyRsrcService")	private RsrcReqPhyRsrcService rsrcReqPhyRsrcService;
	@Resource(name="rsrcReqNetwkService")	private RsrcReqNetwkService rsrcReqNetwkService;
	
    @Resource(name="commonService")
    private CommonService commonService;


	@Override
	public List<RsrcReqMngVo> selectRsrcReqList(RsrcReqMngSearchVo searchVo) {

		List<RsrcReqMngVo> list = null;
		int totalCount = rsrcReqMngDao.selectRsrcReqTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한   count
			list = rsrcReqMngDao.selectRsrcReqList(searchVo);
		}

		return list;
	}

	@Override
	public RsrcReqVo selectRsrcReqDtl(String rsrcReqNo) {
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqMngDao.selectRsrcReqDtl(searchVo);
	}

	@Override
	public List<RsrcReqMngVo> selectRsrcReqExcelList(RsrcReqMngSearchVo searchVo) {

		List<RsrcReqMngVo> list = null;
		list = rsrcReqMngDao.selectRsrcReqExcelList(searchVo);

		return list;
	}

	@Override
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

	@Override
	public void updateRsrcReqDeleteYn(RsrcReqMngVo vo){
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setDelUserId(vo.getDelUserId());
		rrRsrcReq.setRsrcReqNo(vo.getRsrcReqNo());
		rrRsrcReq.setDelYn("Y");
		cRrRsrcReqDao.updateRsrcReqDeleteYn(rrRsrcReq);
	}
	
	
	@Override
	public String insertRsrcReqAtmScl(RsrcReqMngVo vo) throws Exception{
		
		String resultmessage = null;
		String attchFilePath = null;

		attchFilePath = OprConstant.RX_REQ_FILE_DEFAULT_PATH+"/"+Integer.toString(DateUtil.getCurrentYear());

		FileVo fileVo = new FileVo();
		fileVo = FileManageUtil.uploadFile(vo.getUploadFile(), attchFilePath,
				RsrcReqMngFileVo.class, FileManageUtil.FileType.DEFAULT, new Long(10 * 1024 * 1024));
		
		vo.setOriAtchFileNm(fileVo.getOriginFileName());
		vo.setSavAtchFileNm(fileVo.getSaveFileName());
		vo.setAtchFilePath(fileVo.getFilePath());
		vo.setAtchFileSize(fileVo.getFileSize());
		vo.setRsrcReqPrcssStatCd("01"); //상태(요청)
		vo.setRsrcReqClCd("02"); //구분(자동확장)

		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, vo);
		
		String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
		String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);
		rrRsrcReq.setRsrcReqNo(rsrcReqNo);

		cRrRsrcReqDao.insertRrRsrcReq(rrRsrcReq);
		resultmessage =  OprConstant.RX_REQ_SUCC_MSG;

		return resultmessage;
	}
	
	@Override
	public RsrcReqMngVo selectRsrcReq(String rsrcReqNo) {
		return rsrcReqMngDao.selectRsrcReq(rsrcReqNo);
	}
	
	
	@Override
	public void updateRsrcReqExeInfo(RsrcReqMngVo vo){
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setExeUserId(vo.getExeUserId());
		rrRsrcReq.setRsrcReqNo(vo.getRsrcReqNo());
		rrRsrcReq.setRsrcReqPrcssStatCd(vo.getRsrcReqPrcssStatCd());
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}
	
	@Override
	public RsrcReqMngVo selectRsrcReqFileInfo(String rsrcReqNo) {
		return rsrcReqMngDao.selectRsrcReqFileInfo(rsrcReqNo);
	}
	
	@Override
	public List<RsrcReqMngVo> selectRegionList(String userId) {

		List<RsrcReqMngVo> list = null;
		list = rsrcReqMngDao.selectRegionList(userId);

		return list;
	}
	
}
