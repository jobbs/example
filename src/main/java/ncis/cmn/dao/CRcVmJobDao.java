package ncis.cmn.dao;

import ncis.cmn.entity.RcVmJob;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버 업무 DAO - 공통(등록/수정/삭제)
 *
 * @author 심원보
 */

@Repository("cRcVmJobDao")
public class CRcVmJobDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 업무 등록
	 * @param rcVmJob
	 */
	public void insertRcVmJob(RcVmJob rcVmJob) {
		sqlSession.insert("ncis.sql.cmn.rcVmJob.insertRcVmJob", rcVmJob);
	}

	/**
	 * 가상서버 업무 삭제
	 * @param rcVmJob
	 */
	public void deleteRcVmJob(RcVmJob rcVmJob) {
		sqlSession.update("ncis.sql.cmn.rcVmJob.deleteRcVmJob", rcVmJob);
	}

}
