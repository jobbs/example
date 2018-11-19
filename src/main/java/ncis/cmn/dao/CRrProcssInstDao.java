package ncis.cmn.dao;

import ncis.cmn.entity.RrProcssInst;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 프로세스인스턴스 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrProcssInstDao")
public class CRrProcssInstDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 프로세스인스턴스 등록
	 * @param rrProcssInst
	 */
	public void insertRrProcssInst(RrProcssInst rrProcssInst) {
		sqlSession.insert("ncis.sql.cmn.rrProcssInst.insertRrProcssInst", rrProcssInst);
	}

	/**
	 * 프로세스인스턴스 수정
	 * @param rrProcssInst
	 */
	public void updateRrProcssInst(RrProcssInst rrProcssInst) {
		sqlSession.update("ncis.sql.cmn.rrProcssInst.updateRrProcssInst", rrProcssInst);
	}

	/**
	 * 프로세스인스턴스 삭제
	 * @param rrProcssInst
	 */
	public void deleteRrProcssInst(RrProcssInst rrProcssInst) {
		sqlSession.update("ncis.sql.cmn.rrProcssInst.deleteRrProcssInst", rrProcssInst);
	}

	/**
	 * 프로세스인스턴스 상태 수정
	 * @param rrProcssInst
	 */
	public void updateRrProcssInstStat(RrProcssInst rrProcssInst) {
		sqlSession.update("ncis.sql.cmn.rrProcssInst.updateRrProcssInstStat", rrProcssInst);
	}

}
