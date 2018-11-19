/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseDao.java
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
package ncis.dsb.stts.etc.dao;

import java.util.List;

import ncis.dsb.stts.etc.vo.OprStatSearchVo;
import ncis.dsb.stts.etc.vo.PmStatInfoVo;
import ncis.dsb.stts.etc.vo.PoolStatInfoVo;
import ncis.dsb.stts.etc.vo.VmStatInfoVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("oprStatDao")
public class OprStatDao
{

	@Autowired
	SqlSessionTemplate sqlSession;

	public List<PmStatInfoVo> selectOprStatPmMinList(OprStatSearchVo searchVo)
	{
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.oprStat.selectOprStatPmMinList", searchVo);
	}

	public List<PoolStatInfoVo> selectOprStatPoolList(OprStatSearchVo searchVo)
	{
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.oprStat.selectOprStatPoolList", searchVo);
	}

	public List<VmStatInfoVo> selectOprStatVmList(OprStatSearchVo searchVo)
	{
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.oprStat.selectOprStatVmList", searchVo);
	}

	public List<PmStatInfoVo> selectOprStatPmList(OprStatSearchVo searchVo)
	{
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.oprStat.selectOprStatPmList", searchVo);
	}
}
