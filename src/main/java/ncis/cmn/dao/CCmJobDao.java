/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmJobDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import ncis.cmn.entity.CmJob;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 업무 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmJobDao")
public class CCmJobDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 업무 등록
	 * @param Job
	 */
	public void insertCmJob(CmJob cmJob) {
		sqlSession.insert("ncis.sql.cmn.cmJob.insertCmJob", cmJob);
	}

	/**
	 * 업무 수정
	 * @param Job
	 */
	public void updateCmJob(CmJob cmJob) {
		sqlSession.update("ncis.sql.cmn.cmJob.updateCmJob", cmJob);
	}

	/**
	 * 업무 삭제
	 * @param Job
	 */
	public void deleteCmJob(CmJob cmJob) {
		sqlSession.update("ncis.sql.cmn.cmJob.deleteCmJob", cmJob);
	}

	/**
	 * 사용여부 수정
	 * @param jobVo
	 */
	public void updateCmJobUseYn(CmJob cmJob) {
		sqlSession.update("ncis.sql.cmn.cmJob.updateUseYNCmJob", cmJob);
	}

}
