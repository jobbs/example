/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CpuUseRtDao.java
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
package ncis.dsb.stts.specusert.dao;

import java.util.List;

import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cpuUseRtDao")
public class CpuUseRtDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 CPU 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<MemUseRtVo> selectCpuUseRtList(CpuUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.cpuUseRt.selectCpuUseRtList", searchVo);
	}

	/**
	 * 가상서버 CPU 최빈시 사용률 분포 조회
	 * @param searchVo
	 * @return
	 */
	public List<MemUseRtVo> selectTopCpuUseRtList(CpuUseRtSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.specusert.cpuUseRt.selectTopCpuUseRtList", searchVo);
	}
}
