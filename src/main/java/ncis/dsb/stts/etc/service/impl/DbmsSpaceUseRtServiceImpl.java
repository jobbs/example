/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtServiceImpl.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.etc.dao.DbmsSpaceUseRtDao;
import ncis.dsb.stts.etc.service.DbmsSpaceUseRtService;
import ncis.dsb.stts.etc.vo.DbmsSpaceUseRtVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;

import org.springframework.stereotype.Service;

@Service("dbmsSpaceUseRtService")
public class DbmsSpaceUseRtServiceImpl implements DbmsSpaceUseRtService {

	@Resource(name="dbmsSpaceUseRtDao")
	private DbmsSpaceUseRtDao dbmsSpaceUseRtDao;

	@Override
	public List<DbmsSpaceUseRtVo> selectDbmsSpaceUseRtList(GcamsSearchVo searchVo) throws Exception {

		return dbmsSpaceUseRtDao.selectDbmsSpaceUseRtList(searchVo);
	}
	@Override
	public List<String> selectDbmsSpaceUseRtDateList(GcamsSearchVo searchVo) throws Exception {

		return dbmsSpaceUseRtDao.selectDbmsSpaceUseRtDateList(searchVo);
	}
	@Override
	public List<String> selectDbmsSpaceUseRtObjList(GcamsSearchVo searchVo) throws Exception {

		return dbmsSpaceUseRtDao.selectDbmsSpaceUseRtObjList(searchVo);
	}
}
