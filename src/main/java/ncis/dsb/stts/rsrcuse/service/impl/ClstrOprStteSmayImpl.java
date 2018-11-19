/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstrOprStteSmayImpl.java
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

import ncis.dsb.stts.rsrcuse.dao.ClstrOprStteSmayDao;
import ncis.dsb.stts.rsrcuse.service.ClstrOprStteSmayService;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmaySearchVo;
import ncis.dsb.stts.rsrcuse.vo.ClstrOprStteSmayVo;

import org.springframework.stereotype.Service;

@Service("clstrOprStteSmayService")
public class ClstrOprStteSmayImpl implements ClstrOprStteSmayService {


	@Resource(name="clstrOprStteSmayDao")
	private ClstrOprStteSmayDao clstrOprStteSmayDao;

	/**
	 * 자원풀 운영 현황 개요
	 * */
	@Override
	public List<ClstrOprStteSmayVo> selectClstrOprStteSmayList(ClstrOprStteSmaySearchVo searchVo) throws Exception {

		List<ClstrOprStteSmayVo> list = null;
		list = clstrOprStteSmayDao.selecClstrOprStteSmayList(searchVo);
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

	@Override
	public List<ClstrOprStteSmayVo> selectClstrOprStteSmayRsAutoList(ClstrOprStteSmaySearchVo searchVo) {
		List<ClstrOprStteSmayVo> list = null;
		list = clstrOprStteSmayDao.selectClstrOprStteSmayRsAutoList(searchVo);
		return list;
	}

}
