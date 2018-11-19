/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtDao.java
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
package ncis.dsb.stts.etc.dao;

import java.util.List;

import ncis.dsb.stts.etc.vo.DbmsSpaceUseRtVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dbmsSpaceUseRtDao")
public class DbmsSpaceUseRtDao {

	@Autowired SqlSessionTemplate slaveSqlSession;

	public List<DbmsSpaceUseRtVo> selectDbmsSpaceUseRtList(GcamsSearchVo searchVo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectDbmsSpaceUseRtList",searchVo);
	}
	public List<String> selectDbmsSpaceUseRtDateList(GcamsSearchVo searchVo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectDbmsSpaceUseRtDateList",searchVo);
	}
	public List<String> selectDbmsSpaceUseRtObjList(GcamsSearchVo searchVo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectDbmsSpaceUseRtObjList",searchVo);
	}


}
