package ncis.cmn.dao;

import ncis.cmn.entity.RrProcssVar;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 프로세스변수 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrProcssVarDao")
public class CRrProcssVarDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 프로세스변수 등록
	 * @param rrProcssVar
	 */
	public void insertRrProcssVar(RrProcssVar rrProcssVar) {
		sqlSession.insert("ncis.sql.cmn.rrProcssVar.insertRrProcssVar", rrProcssVar);
	}

	/**
	 * 프로세스변수 수정
	 * @param rrProcssVar
	 */
	public void updateRrProcssVar(RrProcssVar rrProcssVar) {
		sqlSession.update("ncis.sql.cmn.rrProcssVar.updateRrProcssVar", rrProcssVar);
	}

	/**
	 * 프로세스변수 삭제
	 * @param rrProcssVar
	 */
	public void deleteRrProcssVar(RrProcssVar rrProcssVar) {
		sqlSession.update("ncis.sql.cmn.rrProcssVar.deleteRrProcssVar", rrProcssVar);
	}

}
