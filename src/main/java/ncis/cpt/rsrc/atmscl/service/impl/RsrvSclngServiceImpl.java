package ncis.cpt.rsrc.atmscl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxRsrvSclngDao;
import ncis.cmn.entity.RxRsrvSclng;
import ncis.cmn.service.CommonService;
import ncis.cpt.rsrc.atmscl.dao.RsrvSclngDao;
import ncis.cpt.rsrc.atmscl.service.RsrvSclngService;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngSearchVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service("rsrvSclngService")
public class RsrvSclngServiceImpl implements RsrvSclngService {

	@Resource(name="rsrvSclngDao")
	private RsrvSclngDao rsrvSclngDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="cRxRsrvSclngDao")
	private CRxRsrvSclngDao cRxRsrvSclngDao;

	private static final Logger logger = LoggerFactory.getLogger(RsrvSclngServiceImpl.class);

	@Override
	public List<RsrvSclngVo> selectRsrvSclngList(RsrvSclngSearchVo rsrvSclngSearchVo) {

		List<RsrvSclngVo> list = null;
		int totalCount = rsrvSclngDao.selectRsrvSclngTotCnt(rsrvSclngSearchVo);

		if(totalCount > 0){

			rsrvSclngSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = rsrvSclngDao.selectRsrvSclngList(rsrvSclngSearchVo);

		}

		return list;
	}



	@Override
	public String insertRsrvSclng(RsrvSclngVo rsrvSclngVo) {
		// 스케일러ID를 셋팅한다.
		RxRsrvSclng rxRsrvSclng = new RxRsrvSclng();
		String scalrId = rsrvSclngVo.getServcSeq() + "_";
		String seqNum = commonService.selectSeqNum("RX_SERVC_SCLNG",scalrId);
		rxRsrvSclng.setServcSeq(rsrvSclngVo.getServcSeq());
		rxRsrvSclng.setScalrId(seqNum);
		rxRsrvSclng.setSclngClCd(rsrvSclngVo.getSclngClCd());
		rxRsrvSclng.setScalrNm(rsrvSclngVo.getScalrNm());
		rxRsrvSclng.setNowPodQty(rsrvSclngVo.getNowPodQty());
		rxRsrvSclng.setMinPodQty(rsrvSclngVo.getMinPodQty());
		rxRsrvSclng.setMaxPodQty(rsrvSclngVo.getMaxPodQty());
		rxRsrvSclng.setUseYn(rsrvSclngVo.getUseYn());
		rxRsrvSclng.setCreUserId(rsrvSclngVo.getCreUserId());
		rxRsrvSclng.setRsrvStrtDt(rsrvSclngVo.getRsrvStrtDt());
		rxRsrvSclng.setRsrvEndDt(rsrvSclngVo.getRsrvEndDt());
		String resultmessage = null;
		try{
			resultmessage =  OprConstant.RSRC_SAVE_SUCC_MSG;
			cRxRsrvSclngDao.insertRsrvSclng(rxRsrvSclng);

		}catch(PersistenceException e){
			logger.error("스케일 설정 시 오류가 발생했습니다.", e);
		}
		return resultmessage;
	}



	/**
	 * 스케일 예약설정 상세 조회
	 * @param servcSeq
	 * @param scalrId
	 * @return rsrvSclngVo
	 */
	@Override
	public RsrvSclngVo selectAtmSclRsrvSclng(Integer servcSeq, String scalrId) {

		RsrvSclngVo rsrvSclngVo = new RsrvSclngVo();
		rsrvSclngVo.setServcSeq(servcSeq);
		rsrvSclngVo.setScalrId(scalrId);

		return rsrvSclngDao.selectAtmSclRsrvSclng(rsrvSclngVo);
	}



	/**
	 * 스케일 예약설정 수정
	 * @param rsrvSclngVo
	 * @return
	 */
	@Override
	public void updateAtmSclRsrvSclng(RsrvSclngVo rsrvSclngVo) {
		RxRsrvSclng rxRsrvSclng = new RxRsrvSclng();
		rxRsrvSclng.setScalrNm(rsrvSclngVo.getScalrNm());
		rxRsrvSclng.setRsrvStrtDt(rsrvSclngVo.getRsrvStrtDt());
		rxRsrvSclng.setRsrvEndDt(rsrvSclngVo.getRsrvEndDt());
		rxRsrvSclng.setUseYn(rsrvSclngVo.getUseYn());
		rxRsrvSclng.setMaxPodQty(rsrvSclngVo.getMaxPodQty());
		rxRsrvSclng.setServcSeq(rsrvSclngVo.getServcSeq());
		rxRsrvSclng.setScalrId(rsrvSclngVo.getScalrId());
		rxRsrvSclng.setUpdtUserId(rsrvSclngVo.getUpdtUserId());
		try {
			cRxRsrvSclngDao.udtAtmSclRsrvSclng(rxRsrvSclng);
		} catch (PersistenceException e) {
			logger.error("스케일 설정 수정 시 오류가 발생했습니다.", e);
		}
	}



	/**
	 * 스케일 예약설정 여부 체크
	 * @param rsrvSclngVo
	 * @return Integer
	 */
	@Override
	public RsrvSclngVo selectRsrvSclngCheck(RsrvSclngVo rsrvSclngVo) {
		RsrvSclngVo selectRsrvSclngCheck = rsrvSclngDao.selectRsrvSclngCheck(rsrvSclngVo);
		if (ObjectUtils.isEmpty(selectRsrvSclngCheck)){
			if (ObjectUtils.isEmpty(selectRsrvSclngCheck.getRsrvCount())){
				selectRsrvSclngCheck.setRsrvCount(0);
			}
			if (ObjectUtils.isEmpty(selectRsrvSclngCheck.getOpMultiSclCount())){
				selectRsrvSclngCheck.setOpMultiSclCount(0);
			}
		}
		return selectRsrvSclngCheck;
	}



	@Override
	public String deleteSclYn(RsrvSclngVo rsrvSclngVo) {
		String resultmessage =  "";

		RxRsrvSclng rxScl = new RxRsrvSclng();
		rxScl.setServcSeq(rsrvSclngVo.getServcSeq());
		rxScl.setScalrId(rsrvSclngVo.getScalrId());
		rxScl.setSclngClCd("03");
		try {
			cRxRsrvSclngDao.deleteSclYn(rxScl);
			resultmessage = "Y";
		} catch(PersistenceException e) {
			resultmessage = "N";
		}
		return resultmessage;
	}


}
