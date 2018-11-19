package ncis.cmn.dao;

import ncis.cmn.entity.RrProcssVarList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 프로세스변수목록 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrProcssVarListDao")
public class CRrProcssVarListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 프로세스변수목록 등록
	 * @param rrProcssVarList
	 */
	public void insertRrProcssVarList(RrProcssVarList rrProcssVarList) {
		sqlSession.insert("ncis.sql.cmn.rrProcssVarList.insertRrProcssVarList", rrProcssVarList);
	}

	/**
	 * 프로세스변수목록 수정
	 * @param rrProcssVarList
	 */
	public void updateRrProcssVarList(RrProcssVarList rrProcssVarList) {
		sqlSession.update("ncis.sql.cmn.rrProcssVarList.updateRrProcssVarList", rrProcssVarList);
	}

	/**
	 * 프로세스변수목록 삭제
	 * @param rrProcssVarList
	 */
	public void deleteRrProcssVarList(RrProcssVarList rrProcssVarList) {
		sqlSession.update("ncis.sql.cmn.rrProcssVarList.deleteRrProcssVarList", rrProcssVarList);
	}

	/**
	 * 해당 프로세스변수목록 전체 삭제
	 * @param rrProcssVarList
	 */
	public void deleteRrProcssVarListAll(RrProcssVarList rrProcssVarList) {
		sqlSession.update("ncis.sql.cmn.rrProcssVarList.deleteRrProcssVarListAll", rrProcssVarList);
	}

	/**
	 * 프로세스변수목록 값 수정
	 * @param rrProcssVarList
	 */
	public void updateRrProcssVarVl(RrProcssVarList rrProcssVarList) {
		sqlSession.update("ncis.sql.cmn.rrProcssVarList.updateRrProcssVarVl", rrProcssVarList);
	}

}
