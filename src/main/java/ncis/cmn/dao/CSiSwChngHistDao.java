package ncis.cmn.dao;

import ncis.cmn.entity.SiSwChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_소프트웨어변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiSwChngHistDao")
public class CSiSwChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_소프트웨어변경이력 등록
	 * @param siSwChngHist
	 */
	public void insertSiSwChngHist(SiSwChngHist siSwChngHist) {
		sqlSession.insert("ncis.sql.cmn.siSwChngHist.insertSiSwChngHist", siSwChngHist);
	}

	/**
	 * 구성정보_소프트웨어변경이력 수정
	 * @param siSwChngHist
	 */
	public void updateSiSwChngHist(SiSwChngHist siSwChngHist) {
		sqlSession.update("ncis.sql.cmn.siSwChngHist.updateSiSwChngHist", siSwChngHist);
	}

	/**
	 * 구성정보_소프트웨어변경이력 삭제
	 * @param siSwChngHist
	 */
	public void deleteSiSwChngHist(SiSwChngHist siSwChngHist) {
		sqlSession.update("ncis.sql.cmn.siSwChngHist.deleteSiSwChngHist", siSwChngHist);
	}

}
