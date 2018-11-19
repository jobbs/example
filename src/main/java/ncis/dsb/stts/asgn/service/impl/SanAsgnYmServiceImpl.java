package ncis.dsb.stts.asgn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.asgn.dao.SanAsgnYmDao;
import ncis.dsb.stts.asgn.service.SanAsgnYmService;
import ncis.dsb.stts.asgn.vo.SanAsgnYmSearchVo;
import ncis.dsb.stts.asgn.vo.SanAsgnYmVo;

import org.springframework.stereotype.Service;

@Service("sanAsgnYmService")
public class SanAsgnYmServiceImpl implements SanAsgnYmService {

	@Resource(name="sanAsgnYmDao")
	private SanAsgnYmDao sanAsgnYmDao;

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 조회
	 * */

	@Override
	public List<SanAsgnYmVo> selectSanAsgnYmList(SanAsgnYmSearchVo searchVo) throws Exception {
		List<SanAsgnYmVo> list = null;
		list = sanAsgnYmDao.selectSanAsgnYmList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 상세조회
	 * */
	@Override
	public List<SanAsgnYmVo> selectSanAsgnRsrcList(SanAsgnYmSearchVo searchVo) throws Exception {
		List<SanAsgnYmVo> list = null;
		list = sanAsgnYmDao.selectSanAsgnRsrcList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 상세보기
	 * */
	@Override
	public List<SanAsgnYmVo> selectSanAsgnView(SanAsgnYmSearchVo searchVo) throws Exception {

		List<SanAsgnYmVo> list = sanAsgnYmDao.selectSanAsgnView(searchVo);

		return list;
	}


	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 등록 수정
	 * */
	@Override
	public void insertSanAsgn(List<SanAsgnYmVo> list) throws Exception {
		for(SanAsgnYmVo vo : list){
			sanAsgnYmDao.insertSanAsgn(vo);
		}
	}

	/**
	 * 자원 보유 및 할당 현황 - SAN 스토리지 삭제
	 */
	@Override
	public void deleteSanAsgn(List<SanAsgnYmVo> list) throws Exception{
       for(SanAsgnYmVo vo : list){
    	   sanAsgnYmDao.deleteSanAsgn(vo);
       }
	}

}
