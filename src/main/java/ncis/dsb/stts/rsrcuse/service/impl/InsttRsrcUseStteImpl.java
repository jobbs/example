/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttRsrcUseStteImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.rsrcuse.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.rsrcuse.dao.InsttRsrcUseStteDao;
import ncis.dsb.stts.rsrcuse.service.InsttRsrcUseStteService;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcRxMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteAsgnVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteMaxVo;
import ncis.dsb.stts.rsrcuse.vo.InsttRsrcUseStteSearchVo;

import org.springframework.stereotype.Service;

@Service("insttRsrcUseStteService")
public class InsttRsrcUseStteImpl implements InsttRsrcUseStteService {


	@Resource(name="insttRsrcUseStteDao")
	private InsttRsrcUseStteDao insttRsrcUseStteDao;

	/**
	 * 논리자원 할당량 목록
	 * */
	@Override
	public List<InsttRsrcUseStteAsgnVo> selectInsttRsrcUseStteAsgnList(InsttRsrcUseStteSearchVo searchVo) throws Exception {

		List<InsttRsrcUseStteAsgnVo> list = null;
		list = insttRsrcUseStteDao.selecInsttRsrcUseStteAsgnList(searchVo);
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

	/**
	 * 가상서버 최빈시 자원 사용률 목록
	 * */
	@Override
	public List<InsttRsrcUseStteMaxVo> selectInsttRsrcUseStteMaxList(InsttRsrcUseStteSearchVo searchVo) throws Exception {

		List<InsttRsrcUseStteMaxVo> list = null;
		list = insttRsrcUseStteDao.selecInsttRsrcUseStteMaxList(searchVo);
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

	/**
	 * 자동확장 할당량 목록
	 * */
	@Override
	public List<InsttRsrcRxAsgnVo> selectRxAsgnList(InsttRsrcUseStteSearchVo searchVo) throws Exception {
		List<InsttRsrcRxAsgnVo> listRxAsgn = insttRsrcUseStteDao.selectRxAsgnList(searchVo);

		return listRxAsgn;
	}

	@Override
	public List<InsttRsrcRxMaxVo> selectRxMaxList(InsttRsrcUseStteSearchVo searchVo) throws Exception {
		List<InsttRsrcRxMaxVo> listRxAsgn = insttRsrcUseStteDao.selectRxMaxList(searchVo);

		return listRxAsgn;
	}

}
