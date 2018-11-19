/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmServiceImpl.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cpt.sys.alrm.dao.AlrmDao;
import ncis.cpt.sys.alrm.service.AlrmService;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.alrm.vo.AlrmVo;
import org.springframework.stereotype.Service;

/**
 * @author 최진호
 *
 */
@Service("alrmService")
public class AlrmServiceImpl implements AlrmService {

    @Resource private AlrmDao alrmDao;

    @Override
    public int selectAlrmTotCnt(AlrmSearchVo searchVo) {
        return alrmDao.selectAlrmTotCnt(searchVo);
    }

    @Override
    public List<AlrmVo> selectAlrmList(AlrmSearchVo searchVo) {

    	List<AlrmVo> list = null;

		int totalCount = alrmDao.selectAlrmTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
			list = alrmDao.selectAlrmList(searchVo);
		}

        return list;
    }

    @Override
    public AlrmVo selectAlrm(Long alrmSeq) {
        return alrmDao.selectAlrm(alrmSeq);
    }

    @Override
    public void updateAlrm(AlrmVo alrmVo) {
        alrmDao.updateAlrm(alrmVo);
    }

	@Override
	public List<AlrmVo> selectAlrmListXlsDwnl(AlrmSearchVo searchVo) {
		List<AlrmVo> list = alrmDao.selectAlrmListXlsDwnl(searchVo);

		for (AlrmVo vo : list){
			String stat = vo.getStatCd();
			if("I".equals(stat)){
				vo.setStatNm("정보");
			}else if("E".equals(stat)){
				vo.setStatNm("오류(장애)");
			}
		}
		return list;
	}



}
