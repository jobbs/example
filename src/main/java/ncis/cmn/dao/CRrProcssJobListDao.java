package ncis.cmn.dao;

import ncis.cmn.entity.RrProcssJobList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 프로세스업무목록 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrProcssJobListDao")
public class CRrProcssJobListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 프로세스업무목록 등록
	 * @param rrProcssJobList
	 */
	public void insertRrProcssJobList(RrProcssJobList rrProcssJobList) {
		sqlSession.insert("ncis.sql.cmn.rrProcssJobList.insertRrProcssJobList", rrProcssJobList);
	}

	/**
	 * 프로세스업무목록 수정
	 * @param rrProcssJobList
	 */
	public void updateRrProcssJobList(RrProcssJobList rrProcssJobList) {
		sqlSession.update("ncis.sql.cmn.rrProcssJobList.updateRrProcssJobList", rrProcssJobList);
	}

	/**
	 * 프로세스업무목록 삭제
	 * @param rrProcssJobList
	 */
	public void deleteRrProcssJobList(RrProcssJobList rrProcssJobList) {
		sqlSession.update("ncis.sql.cmn.rrProcssJobList.deleteRrProcssJobList", rrProcssJobList);
	}

	/**
	 * 프로세스업무목록 삭제
	 * @param rrProcssJobList
	 */
	public void deleteRrProcssJobListAll(RrProcssJobList rrProcssJobList) {
		sqlSession.update("ncis.sql.cmn.rrProcssJobList.deleteRrProcssJobListAll", rrProcssJobList);
	}

	/**
	 * 단위업무 상태 수정
	 * @param rrProcssJobList
	 */
	public void updateProcssJobStat(RrProcssJobList rrProcssJobList) {
		sqlSession.update("ncis.sql.cmn.rrProcssJobList.updateProcssJobStat", rrProcssJobList);
	}

}
