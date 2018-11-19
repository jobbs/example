package ncis.cmn.dao;

import ncis.cmn.entity.RrVmWrkHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버작업이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrVmWrkHistDao")
public class CRrVmWrkHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버작업이력 등록
	 * @param rrVmWrkHist
	 */
	public void insertRrVmWrkHist(RrVmWrkHist rrVmWrkHist) {
		sqlSession.insert("ncis.sql.cmn.rrVmWrkHist.insertRrVmWrkHist", rrVmWrkHist);
	}

	/**
	 * 가상서버작업이력 수정
	 * @param rrVmWrkHist
	 */
	public void updateRrVmWrkHist(RrVmWrkHist rrVmWrkHist) {
		sqlSession.update("ncis.sql.cmn.rrVmWrkHist.updateRrVmWrkHist", rrVmWrkHist);
	}

	/**
	 * 가상서버작업이력 삭제
	 * @param rrVmWrkHist
	 */
	public void deleteRrVmWrkHist(RrVmWrkHist rrVmWrkHist) {
		sqlSession.update("ncis.sql.cmn.rrVmWrkHist.deleteRrVmWrkHist", rrVmWrkHist);
	}

}
