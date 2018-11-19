package ncis.cmn.dao;

import ncis.cmn.entity.RrUnitJob;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 단위업무 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrUnitJobDao")
public class CRrUnitJobDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 단위업무 등록
	 * @param rrUnitJob
	 */
	public void insertRrUnitJob(RrUnitJob rrUnitJob) {
		sqlSession.insert("ncis.sql.cmn.rrUnitJob.insertRrUnitJob", rrUnitJob);
	}

	/**
	 * 단위업무 수정
	 * @param rrUnitJob
	 */
	public void updateRrUnitJob(RrUnitJob rrUnitJob) {
		sqlSession.update("ncis.sql.cmn.rrUnitJob.updateRrUnitJob", rrUnitJob);
	}

	/**
	 * 단위업무 삭제
	 * @param rrUnitJob
	 */
	public void deleteRrUnitJob(RrUnitJob rrUnitJob) {
		sqlSession.update("ncis.sql.cmn.rrUnitJob.deleteRrUnitJob", rrUnitJob);
	}

}
