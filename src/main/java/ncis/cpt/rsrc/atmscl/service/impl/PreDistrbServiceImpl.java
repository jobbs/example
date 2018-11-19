package ncis.cpt.rsrc.atmscl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRxPreDistrbDao;
import ncis.cmn.entity.RxPreDistrb;
import ncis.cmn.service.CommonService;
import ncis.cpt.rsrc.atmscl.dao.PreDistrbDao;
import ncis.cpt.rsrc.atmscl.service.PreDistrbService;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbVo;

import org.springframework.stereotype.Service;

@Service("preDistrbService")
public class PreDistrbServiceImpl implements PreDistrbService {

	@Resource(name="preDistrbDao")
	private PreDistrbDao preDistrbDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="cRxPreDistrbDao")
	private CRxPreDistrbDao cRxPreDistrbDao;


	@Override
	public List<PreDistrbVo> selectPreDistrbList(PreDistrbSearchVo preDistrbSearchVo) {

		List<PreDistrbVo> list = null;
		int totalCount = preDistrbDao.selectPreDistrbTotCnt(preDistrbSearchVo);

		if(totalCount > 0){
			preDistrbSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = preDistrbDao.selectPreDistrbList(preDistrbSearchVo);
		}

		return list;
	}

	@Override
	public List<PreDistrbVo> selectPreDistrbListP(PreDistrbSearchVo preDistrbSearchVo) {

		List<PreDistrbVo> list = null;
		int totalCount = preDistrbDao.selectPreDistrbTotCntP(preDistrbSearchVo);

		if(totalCount > 0){
			preDistrbSearchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = preDistrbDao.selectPreDistrbListP(preDistrbSearchVo);
		}

		return list;
	}


	@Override
	public void insertPreDistrb(PreDistrbVo preDistrbVo) {
		RxPreDistrb rxPreDistrb = new RxPreDistrb();
		rxPreDistrb.setRsrcPoolId(preDistrbVo.getRsrcPoolId());
		rxPreDistrb.setServcAreaSeq(preDistrbVo.getServcAreaSeq());
		rxPreDistrb.setImgId(preDistrbVo.getImgId());
		rxPreDistrb.setImgRepoDtlAddr(preDistrbVo.getImgRepoDtlAddr());
		rxPreDistrb.setDistrbReqUserId(preDistrbVo.getDistrbReqUserId());
		rxPreDistrb.setRmk(preDistrbVo.getRmk());
		rxPreDistrb.setDemonSetId(preDistrbVo.getDemonSetId());
		rxPreDistrb.setDistrbStatCd("01");
		cRxPreDistrbDao.insertPreDistrb(rxPreDistrb);
	}


	@Override
	public PreDistrbVo updatePreDistrb(Integer servcAreaSeq,Integer preDistrbReqSeq) {

		PreDistrbVo preDistrbVo = new PreDistrbVo();
		preDistrbVo.setServcAreaSeq(servcAreaSeq);
		preDistrbVo.setPreDistrbReqSeq(preDistrbReqSeq);

		return preDistrbDao.updatePreDistrb(preDistrbVo);
	}

	@Override
	public void updatePreDistrbStat(PreDistrbVo preDistrbVo) {
		RxPreDistrb rxPreDistrb = new RxPreDistrb();
		rxPreDistrb.setDistrbStatCd(preDistrbVo.getDistrbStatCd());
		rxPreDistrb.setPreDistrbReqSeq(preDistrbVo.getPreDistrbReqSeq());
		cRxPreDistrbDao.updatePreDistrbStat(rxPreDistrb);
	}

	@Override
	public void updateRePreDistrb(PreDistrbVo preDistrbVo) {
		RxPreDistrb rxPreDistrb = new RxPreDistrb();
		rxPreDistrb.setDemonSetId(preDistrbVo.getDemonSetId());
		rxPreDistrb.setDistrbStatCd(preDistrbVo.getDistrbStatCd());
		rxPreDistrb.setPreDistrbReqSeq(preDistrbVo.getPreDistrbReqSeq());
		rxPreDistrb.setRmk(preDistrbVo.getRmk());
		cRxPreDistrbDao.updateRePreDistrb(rxPreDistrb);
	}

}
