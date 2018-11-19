/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStServiceImpl.java
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

import ncis.dsb.stts.rsrcoptz.dao.WthdrwStDao;
import ncis.dsb.stts.rsrcoptz.service.WthdrwStService;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStSearchVo;
import ncis.dsb.stts.rsrcoptz.vo.WthdrwStVo;

import org.springframework.stereotype.Service;

@Service("wthdrwStService")
public class WthdrwStServiceImpl implements WthdrwStService {

	@Resource(name="wthdrwStDao")
	private WthdrwStDao wthdrwStDao;

	/**
	 *  자원 회수 현황 조회
	 */
	@Override
	public List<WthdrwStVo> selectWthdrwStList(WthdrwStSearchVo searchVo) throws Exception {
		return wthdrwStDao.selectWthdrwStList(searchVo);
	}

	/**
	 *  자원 회수 현황 보기
	 */
	@Override
	public List<WthdrwStVo> selectWthdrwStView(WthdrwStSearchVo searchVo) throws Exception {

		List<WthdrwStVo> list = wthdrwStDao.selectWthdrwStView(searchVo);

		return list;
	}

	/**
	 *  자원 회수 상세 현황
	 */
	@Override
	public List<WthdrwStVo> selectWthdrwRsrcList(WthdrwStSearchVo searchVo) throws Exception {
		return wthdrwStDao.selectWthdrwRsrcList(searchVo);
	}

	/**
	 *  자원 회수 상세 현황 등록 수정
	 */

	public void insertWthdrwSt(List<WthdrwStVo> insert) throws Exception {
		for(WthdrwStVo vo : insert){
			wthdrwStDao.insertWthdrwSt(vo);
		}
	}

	/**
	 *  자원 회수 삭제
	 */
	public void deleteWthdrwSt(WthdrwStVo vo) throws Exception{

    	   wthdrwStDao.deleteWthdrwSt(vo);

	}

}
