package ncis.cpt.opr.catalg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRxImgDao;
import ncis.cmn.entity.RxImg;
import ncis.cmn.service.CommonService;
import ncis.cpt.opr.catalg.dao.BaseImgDao;
import ncis.cpt.opr.catalg.service.BaseImgService;
import ncis.cpt.opr.catalg.vo.BaseImgSearchVo;
import ncis.cpt.opr.catalg.vo.BaseImgVo;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

@Service("baseImgService")
public class BaseImgServiceImpl implements BaseImgService {

	@Resource(name="baseImgDao") private BaseImgDao baseImgDao;
	@Resource(name="cRxImgDao") private CRxImgDao cRxImgDao;
    @Resource(name="commonService") private CommonService commonService;


	@Override
	public List<BaseImgVo> selectBaseImgList(BaseImgSearchVo searchVo) {

		List<BaseImgVo> list = null;
		int totalCount = baseImgDao.selectBaseImgTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한   count
			list = baseImgDao.selectBaseImgList(searchVo);
		}

		return list;
	}

	@Override
	public BaseImgVo selectBaseImg(String rsrcPoolId, String imgId, int servcAreaSeq) {
		BaseImgVo baseImgVo = new BaseImgVo();
		baseImgVo.setImgId(imgId);
		baseImgVo.setRsrcPoolId(rsrcPoolId);
		baseImgVo.setServcAreaSeq(servcAreaSeq);
		return baseImgDao.selectBaseImg(baseImgVo);
	}


	@Override
	public void updateBaseImg(BaseImgVo vo) throws Exception {

		RxImg rxImg = new RxImg();
		BeanUtils.copyProperties(rxImg, vo);
		cRxImgDao.updateRxImg(rxImg);
	}


	@Override
	public List<BaseImgVo> selectBaseImgPortList(BaseImgVo baseImgVo) {

		List<BaseImgVo> list = baseImgDao.selectBaseImgPortList(baseImgVo);
		return list;
	}
}
