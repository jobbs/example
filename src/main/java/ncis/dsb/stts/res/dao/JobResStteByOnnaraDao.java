/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteByOnnaraDao.java
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
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jobResStteByOnnaraDao")
public class JobResStteByOnnaraDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * vm 조회 (온나라)
	 * */
	public List<Map<String,String>> selectJobResStteByOnnaraVmList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectJobResStteByOnnaraVmList", searchVo);
	}

	/**
	 * 사용률 조회 (온나라)
	 * */
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectJobTimeResByOnnaraUseRtPivot", searchVo);
	}

	/**
	 * 최소, 평균, 최대 조회 (온나라)
	 * */
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtTop(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectJobTimeResByOnnaraUseRtTop", searchVo);
	}

	/**
	 * pod 조회 (온나라)
	 * */
	public List<Map<String,String>> selectJobResStteByOnnaraPodList(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectJobResStteByOnnaraPodList", searchVo);
	}

	/**
	 * pod 사용률 조회 (온나라)
	 * */
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectAxTimeResByOnnaraUseRtPivot", searchVo);
	}

	/**
	 *pod 최소, 평균, 최대 조회 (온나라)
	 * */
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtTop(JobResSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.res.JobResStteByOnnara.selectAxTimeResByOnnaraUseRtTop", searchVo);
	}

}
