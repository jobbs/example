/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
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
 * 2017. 06. 17   양정순         v2.0             자동확장
 *
 */
package ncis.dsb.stts.res.dao;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.JobResSearchVo;
import ncis.dsb.stts.res.vo.JobResStteVo;
import ncis.dsb.stts.res.vo.JobTimeResUseRtVo;
import ncis.dsb.stts.res.vo.JobVmStteVo;
import ncis.dsb.stts.res.vo.JobAxStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jobResStteDao")
public class JobResStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 업무 자원현황 조회
	 * */
	public List<JobResStteVo> selectJobResStteList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobResStteList", searchVo);
	}

	/**
	 * 업무 가상서버현황 조회
	 * */
	public List<JobVmStteVo> selectJobVmStteList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobVmStteList", searchVo);
	}

	/**
	 * 업무 자동확장 서비스 현황 조회
	 * */
	public List<JobAxStteVo> selectJobAxStteList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobAxStteList", searchVo);
	}

	/**
	 * 시간대별 CPU사용율 조회
	 * */
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtCpu(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobTimeResUseRtCpu", searchVo);
	}
	/**
	 * 시간대별 MEM사용율 조회
	 * */
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtMem(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobTimeResUseRtMem", searchVo);
	}
	/**
	 * 시간대별 SAN사용율 조회
	 * */
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtSan(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobTimeResUseRtSan", searchVo);
	}

	/**
	 * 사용율 조회
	 * */

	public List<Map<String,String>> selectJobTimeResUseRtPivot(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobTimeResUseRtPivot", searchVo);
	}
	/**
	 * VM List
	 * */

	public List<Map<String,String>> selectJobResStteVmList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobResStteVmList", searchVo);
	}

	/**
	 * 자동확장 사용율 조회
	 * */

	public List<Map<String,String>> selectAxTimeResUseRtPivot(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectAxTimeResUseRtPivot", searchVo);
	}
	/**
	 * VM List
	 * */

	public List<Map<String,String>> selectAxResSttePodList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectAxResSttePodList", searchVo);
	}
	
	/**
	 * 업무 가상서버현황 조회 (온나라)
	 * */
	public List<JobVmStteVo> selectJobVmStteListByOnnara(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobVmStteList", searchVo);
	}

	/**
	 * 업무 자동확장 서비스 현황 조회 (온나라)
	 * */
	public List<JobAxStteVo> selectJobAxStteListByOnnara(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStte.selectJobAxStteList", searchVo);
	}


}
