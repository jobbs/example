/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseServiceImpl.java
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
 * 2017. 05. 21   양정순         v2.0             자동확장 추가
 *
 */
package ncis.dsb.stts.etc.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.etc.dao.MmSttsCloseDao;
import ncis.dsb.stts.etc.service.MmSttsCloseService;
import ncis.dsb.stts.etc.vo.MmSttsCloseSearchVo;
import ncis.dsb.stts.etc.vo.MmSttsCloseVo;
import ncis.dsb.stts.etc.vo.AxMmSttsCloseVo;
import org.springframework.stereotype.Service;

@Service("mmSttsCloseService")
public class MmSttsCloseServiceImpl implements MmSttsCloseService {

	@Resource(name="mmSttsCloseDao")
	private MmSttsCloseDao mmSttsCloseDao;

	/**
	 * 월별 통계마감  조회
	 * */
	@Override
	public List<MmSttsCloseVo> selectMmSttsCloseList(MmSttsCloseSearchVo searchVo) throws Exception {

		List<MmSttsCloseVo> list = null;

		int totalCount = mmSttsCloseDao.selectMmSttsCloseTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = mmSttsCloseDao.selectMmSttsCloseList(searchVo);
		}

		return list;
	}

	/**
	 * 자동 확장 월별 통계마감  조회
	 * */
	@Override
	public List<AxMmSttsCloseVo> selectAxMmSttsCloseList(MmSttsCloseSearchVo searchVo) throws Exception {

		List<AxMmSttsCloseVo> list = null;

		int totalCount = mmSttsCloseDao.selectAxMmSttsCloseTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = mmSttsCloseDao.selectAxMmSttsCloseList(searchVo);
		}

		return list;
	}

	/**
	 * VM별 통계 마감 조회
	 * */
	@Override
	public List<MmSttsCloseVo> selectVmCloseList(MmSttsCloseSearchVo searchVo) throws Exception {
		List<MmSttsCloseVo> list = null;

		int totalCount = mmSttsCloseDao.selectVmCloseTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = mmSttsCloseDao.selectVmCloseList(searchVo);
		}

		return list;
	}

	/**
	 * 자동확장 통계 마감 조회
	 * */
	@Override
	public List<AxMmSttsCloseVo> selectAxCloseList(MmSttsCloseSearchVo searchVo) throws Exception {
		List<AxMmSttsCloseVo> list = null;

		int totalCount = mmSttsCloseDao.selectAxCloseTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = mmSttsCloseDao.selectAxCloseList(searchVo);
		}

		return list;
	}

}
