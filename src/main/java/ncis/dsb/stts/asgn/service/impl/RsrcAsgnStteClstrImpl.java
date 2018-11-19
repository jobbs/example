package ncis.dsb.stts.asgn.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.asgn.dao.RsrcAsgnStteClstrDao;
import ncis.dsb.stts.asgn.service.RsrcAsgnStteClstrService;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteClstrAxVo;
import org.springframework.stereotype.Service;

@Service("rsrcAsgnStteClstrService")
public class RsrcAsgnStteClstrImpl implements RsrcAsgnStteClstrService {


	@Resource(name="rsrcAsgnStteClstrDao")
	private RsrcAsgnStteClstrDao rsrcAsgnStteClstrDao;

	/**
	 * 자원 보유 및 할당 현황-클러스터별 조회
	 * */
	@Override
	public List<RsrcAsgnStteClstrVo> selectRsrcAsgnStteClstrList(RsrcAsgnStteClstrSearchVo searchVo) throws Exception {

		List<RsrcAsgnStteClstrVo> list = null;
		list = rsrcAsgnStteClstrDao.selectRsrcAsgnStteClstrList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		return list;
	}

	/**
	 * 자동확장 자원 보유 및 할당 현황-클러스터별 조회
	 * */
	@Override
	public List<RsrcAsgnStteClstrAxVo> selectRsrcAsgnStteClstrAxList(RsrcAsgnStteClstrSearchVo searchVo) throws Exception {

		List<RsrcAsgnStteClstrAxVo> list = null;
		list = rsrcAsgnStteClstrDao.selectRsrcAsgnStteClstrAxList(searchVo);
		return list;
	}

}
