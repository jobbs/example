package ncis.cmn.dao;

import ncis.cmn.entity.SiNetwkChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_네트워크변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiNetwkChngHistDao")
public class CSiNetwkChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_네트워크변경이력 등록
	 * @param siNetwkChngHist
	 */
	public void insertSiNetwkChngHist(SiNetwkChngHist siNetwkChngHist) {
		sqlSession.insert("ncis.sql.cmn.siNetwkChngHist.insertSiNetwkChngHist", siNetwkChngHist);
	}

	/**
	 * 구성정보_네트워크변경이력 수정
	 * @param siNetwkChngHist
	 */
	public void updateSiNetwkChngHist(SiNetwkChngHist siNetwkChngHist) {
		sqlSession.update("ncis.sql.cmn.siNetwkChngHist.updateSiNetwkChngHist", siNetwkChngHist);
	}

	/**
	 * 구성정보_네트워크변경이력 삭제
	 * @param siNetwkChngHist
	 */
	public void deleteSiNetwkChngHist(SiNetwkChngHist siNetwkChngHist) {
		sqlSession.update("ncis.sql.cmn.siNetwkChngHist.deleteSiNetwkChngHist", siNetwkChngHist);
	}

}
