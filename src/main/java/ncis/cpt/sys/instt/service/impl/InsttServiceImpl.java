/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DepartServiceImpl.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.instt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmInstitutionDao;
import ncis.cpt.sys.instt.dao.InsttDao;
import ncis.cpt.sys.instt.service.InsttService;
import ncis.cpt.sys.instt.vo.InsttSearchVo;
import ncis.cpt.sys.instt.vo.InsttVo;
import org.springframework.stereotype.Service;

/**
 * @author 최경철
 *
 */
@Service("insttService")
public class InsttServiceImpl implements InsttService {

	@Resource(name="cCmInstitutionDao") private CCmInstitutionDao cCmInstitutionDao;
	@Resource(name="insttDao") private InsttDao insttDao;

	@Override
	public List<InsttVo> selectInsttList(InsttSearchVo searchVo) {

		List<InsttVo> list = null;

		int totalCount = insttDao.selectInsttTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
			list = insttDao.selectInsttList(searchVo);
		}
		return list;
	}

	@Override
	public List<InsttVo> selectInsttListXlsDwnl(InsttSearchVo searchVo) {
	    return insttDao.selectInsttListXlsDwnl(searchVo);
	}

	@Override
	public InsttVo selectInstt(String institutionId) {

		InsttVo insttVo = insttDao.selectInstt(institutionId);
		return insttVo;
	}

	@Override
	public String selectInsttId(String institutionNm) {

		String insttVo = insttDao.selectInsttId(institutionNm);
		return insttVo;
	}

	@Override
	public void updateInstt(InsttVo insttVo) {

	    if("N".equals(insttVo.getUseYn())){
            updateJob(insttVo);
        }

		cCmInstitutionDao.updateCmInstitutionUseYn(insttVo);
	}

	@Override
	public void updateJob(InsttVo insttVo) {
		cCmInstitutionDao.updateSubJob(insttVo);

	}
	
	@Override
	public List<InsttVo> selectInsttListByOnnara(InsttSearchVo searchVo) {

		List<InsttVo> list = null;

		int totalCount = insttDao.selectInsttByOnnaraTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
			list = insttDao.selectInsttListByOnnara(searchVo);
		}
		return list;
	}

}
