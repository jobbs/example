package ncis.cmn.dao;

import ncis.cmn.entity.RrProcss;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 프로세스 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrProcssDao")
public class CRrProcssDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 프로세스 등록
	 * @param rrProcss
	 */
	public void insertRrProcss(RrProcss rrProcss) {
		sqlSession.insert("ncis.sql.cmn.rrProcss.insertRrProcss", rrProcss);
	}

	/**
	 * 프로세스 수정
	 * @param rrProcss
	 */
	public void updateRrProcss(RrProcss rrProcss) {
		sqlSession.update("ncis.sql.cmn.rrProcss.updateRrProcss", rrProcss);
	}

	/**
	 * 프로세스 삭제
	 * @param rrProcss
	 */
	public void deleteRrProcss(RrProcss rrProcss) {
		sqlSession.update("ncis.sql.cmn.rrProcss.deleteRrProcss", rrProcss);
	}

}
