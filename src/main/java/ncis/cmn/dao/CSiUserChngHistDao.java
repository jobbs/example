package ncis.cmn.dao;

import ncis.cmn.entity.SiUserChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 사용자정보변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiUserChngHistDao")
public class CSiUserChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 사용자정보변경이력 등록
	 * @param siUserChngHist
	 */
	public void insertSiUserChngHist(SiUserChngHist siUserChngHist) {
		sqlSession.insert("ncis.sql.cmn.siUserChngHist.insertSiUserChngHist", siUserChngHist);
	}

	/**
	 * 사용자정보변경이력 수정
	 * @param siUserChngHist
	 */
	public void updateSiUserChngHist(SiUserChngHist siUserChngHist) {
		sqlSession.update("ncis.sql.cmn.siUserChngHist.updateSiUserChngHist", siUserChngHist);
	}

	/**
	 * 사용자정보변경이력 삭제
	 * @param siUserChngHist
	 */
	public void deleteSiUserChngHist(SiUserChngHist siUserChngHist) {
		sqlSession.update("ncis.sql.cmn.siUserChngHist.deleteSiUserChngHist", siUserChngHist);
	}

}
