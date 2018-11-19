/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteClstrImpl.java
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
import ncis.dsb.stts.rsrcuse.dao.RsrcUseStteClstrDao;
import ncis.dsb.stts.rsrcuse.service.RsrcUseStteClstrService;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteClstrSearchVo;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteClstrVo;
import org.springframework.stereotype.Service;

@Service("rsrcUseStteClstrService")
public class RsrcUseStteClstrImpl implements RsrcUseStteClstrService {


	@Resource(name="rsrcUseStteClstrDao")
	private RsrcUseStteClstrDao rsrcUseStteClstrDao;
	/**
	 * 자원 사용 현황-클러스터별 조회
	 * */
	@Override
	public List<RsrcUseStteClstrVo> selectRsrcUseStteClstrList(RsrcUseStteClstrSearchVo searchVo) throws Exception {

		List<RsrcUseStteClstrVo> list = null;
		list = rsrcUseStteClstrDao.selecRsrcUseStteClstrList(searchVo);
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

}
