package ncis.cmn.dao;

import ncis.cmn.entity.SiInstitutionChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 기관업무변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiInstitutionChngHistDao")
public class CSiInstitutionChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 기관업무변경이력 등록
	 * @param siInstitutionChngHist
	 */
	public void insertSiInstitutionChngHist(SiInstitutionChngHist siInstitutionChngHist) {
		sqlSession.insert("ncis.sql.cmn.siInstitutionChngHist.insertSiInstitutionChngHist", siInstitutionChngHist);
	}

	/**
	 * 기관업무변경이력 수정
	 * @param siInstitutionChngHist
	 */
	public void updateSiInstitutionChngHist(SiInstitutionChngHist siInstitutionChngHist) {
		sqlSession.update("ncis.sql.cmn.siInstitutionChngHist.updateSiInstitutionChngHist", siInstitutionChngHist);
	}

	/**
	 * 기관업무변경이력 삭제
	 * @param siInstitutionChngHist
	 */
	public void deleteSiInstitutionChngHist(SiInstitutionChngHist siInstitutionChngHist) {
		sqlSession.update("ncis.sql.cmn.siInstitutionChngHist.deleteSiInstitutionChngHist", siInstitutionChngHist);
	}

}
