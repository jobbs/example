/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasSmTimeConectDao.java
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

import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WasVstrQtyVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wasSmTimeConectDao")
public class WasSmTimeConectDao {

	@Autowired SqlSessionTemplate slaveSqlSession;

	public List<WasVstrQtyVo> selectWasSmTimeConectList(GcamsSearchVo searchVo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWasDailyVstrQtyList",searchVo);
	}
	public List<String> selectWasDailyVstrQtyDateList(GcamsSearchVo vo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWasDailyVstrQtyDateList",vo);
	}
	public List<String> selectWasDailyVstrQtyObjList(GcamsSearchVo vo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWasDailyVstrQtyObjList",vo);
	}
	public List<GcamObjVo> selectJobWebWasDbmsList(GcamObjSearchVo vo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectJobWebWasDbmsList",vo);
	}

}
