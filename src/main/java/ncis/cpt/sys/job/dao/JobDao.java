/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.job.dao;

import java.util.List;
import ncis.cpt.sys.job.vo.JobSearchVo;
import ncis.cpt.sys.job.vo.JobVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("jobDao")
public class JobDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 검색 조건에 해당하는 업무 수
     * @param searchVo
     * @return
     */
    public int selectJobTotCnt(JobSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.job.selectJobTotCnt", searchVo);
    }

    /**
     * 검색 조건에 해당하는 업무 목록
     * @param searchVo
     * @return
     */
    public List<JobVo> selectJobList(JobSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.job.selectJobList", searchVo);
    }


    /**
     * @param searchVo
     * @return
     */
    public List<JobVo> selectJobListXlsDwnl(JobSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.job.selectJobListXlsDwnl", searchVo);
    }

	/**
	 * 부처업무 상세 조회
	 * @param jobId
	 * @return
	 */
	public JobVo selectJobTotCnt(String jobId) {
		return sqlSession.selectOne("ncis.sql.cpt.job.selectJob", jobId);
	}


}