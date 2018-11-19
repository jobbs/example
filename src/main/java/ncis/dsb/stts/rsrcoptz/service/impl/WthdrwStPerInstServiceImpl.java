/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStPerInstServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcoptz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.rsrcoptz.dao.WthdrwStPerInstDao;
import ncis.dsb.stts.rsrcoptz.service.WthdrwStPerInstService;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStPerInstVo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("wthdrwStPerInstService")
public class WthdrwStPerInstServiceImpl implements WthdrwStPerInstService {

	@Resource(name="wthdrwStPerInstDao")
	private WthdrwStPerInstDao wthdrwStPerInstDao;

	/**
	 * 기관별 자원 회수 현황 조회
	 */
	@Override
	public List<WthdrwStPerInstVo> selectWthdrwStPerInstList(WthdrwStPerInstSearchVo searchVo) throws Exception {

		List<WthdrwStPerInstVo> list = null;

		list = wthdrwStPerInstDao.selectWthdrwStPerInstList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		return list;
	}

	@Override
	public List<WthdrwStPerInstVo> selectWthdrwStPerInstView(WthdrwStPerInstSearchVo searchVo) throws Exception {

		List<WthdrwStPerInstVo> list = wthdrwStPerInstDao.selectWthdrwStPerInstView(searchVo);

		return list;
	}


	/**
	 * 기관별 자원 회수 등록
	 */
	public void insertWthdrwStPerInst(List<WthdrwStPerInstVo> list) throws Exception{
		WthdrwStPerInstVo voD = list.get(0);
		WthdrwStPerInstVo copyVo = new WthdrwStPerInstVo();
		BeanUtils.copyProperties(voD, copyVo);
		copyVo.setRegionId(null);
		copyVo.setQuarter(null);
		deleteWthdrwStPerInst(copyVo);

		for(WthdrwStPerInstVo vo : list){
			wthdrwStPerInstDao.insertWthdrwStPerInst(vo);

		}
	}

	/**
	 * 기관별 자원 회수 삭제
	 */
	public void deleteWthdrwStPerInst(WthdrwStPerInstVo vo) throws Exception{

    	   wthdrwStPerInstDao.deleteWthdrwStPerInst(vo);

	}
}
