/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteDao.java
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
 *
 */

package ncis.dsb.stts.rsrcuse.dao;

import java.util.List;

import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jobRsrcStteDao")
public class JobRsrcStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 업무별 자원 현황 조회
	 * */
	public List<JobRsrcStteVo> selecJobRsrcStteList(JobRsrcStteSearchVo searchVo){

		return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStte.selectJobRsrcStteList",searchVo);
	}

	/**
	 * 서비스목록 건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectServcTotCnt(JobRsrcStteSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.dsb.stts.jobRsrcStte.selectServcTotCnt",searchVo);
	}




}
