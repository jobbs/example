/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */

package ncis.cmn.dao;

import java.util.List;

import ncis.cmn.vo.LineChartVo;
import ncis.cmn.vo.MonitorSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.VmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("monitorDao")
public class CCmMonitorDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * VM List
	 * */

	public List<LineChartVo> selectVmLineChartList(MonitorSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cmn.monitor.selectVmLineChartList", searchVo);
	}
	/**
	 * 가상서버 정보 조회
	 * @param searchVo
	 * @return
	 */
	public VmVo selectVmInfo(MonitorSearchVo searchVo)
	{
		return sqlSession.selectOne("ncis.sql.cmn.monitor.selectVmInfo", searchVo);
	}


	/**
	 * PM List
	 * */

	public List<LineChartVo> selectPmLineChartList(MonitorSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cmn.monitor.selectPmLineChartList", searchVo);
	}

	/**
	 * @param searchVo
	 * @return
	 */
	public PmVo selectPmInfo(MonitorSearchVo searchVo)
	{
		return sqlSession.selectOne("ncis.sql.cmn.monitor.selectPmInfo", searchVo);
	}

}
