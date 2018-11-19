package ncis.dsb.stts.asgn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.asgn.dao.InstlDao;
import ncis.dsb.stts.asgn.service.InstlService;
import ncis.dsb.stts.asgn.vo.InstlSearchVo;
import ncis.dsb.stts.asgn.vo.InstlVo;

import org.springframework.stereotype.Service;

@Service("instlService")
public class InstlServiceImpl implements InstlService {

	@Resource(name="instlDao")
	private InstlDao instlDao;

	/**
	 * 자원풀 구축 현황 조회
	 * */

	@Override
	public List<InstlVo> selectInstlList(InstlSearchVo searchVo) throws Exception {
		List<InstlVo> list = null;
		list = instlDao.selectInstlList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}

	/**
	 * 자원풀 구축 현황 상세 보기
	 * */
	@Override
	public List<InstlVo> selectInstlView(InstlSearchVo searchVo) throws Exception {

		List<InstlVo> list = instlDao.selectInstlView(searchVo);

		return list;
	}

	/**
	 * 자원풀 구축 현황 등록 수정
	 * */
	@Override
	public void insertInstl(List<InstlVo> list) throws Exception {
		for(InstlVo vo : list){
			instlDao.insertInstl(vo);
		}
	}

	/**
	 * 자원풀 구축 현황 삭제
	 */
	public void deleteInstl(InstlVo vo) throws Exception{

    	   instlDao.deleteInstl(vo);

	}

}
