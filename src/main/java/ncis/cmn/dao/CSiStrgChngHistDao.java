package ncis.cmn.dao;

import ncis.cmn.entity.SiStrgChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_스토리지변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiStrgChngHistDao")
public class CSiStrgChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_스토리지변경이력 등록
	 * @param siStrgChngHist
	 */
	public void insertSiStrgChngHist(SiStrgChngHist siStrgChngHist) {
		sqlSession.insert("ncis.sql.cmn.siStrgChngHist.insertSiStrgChngHist", siStrgChngHist);
	}

	/**
	 * 구성정보_스토리지변경이력 수정
	 * @param siStrgChngHist
	 */
	public void updateSiStrgChngHist(SiStrgChngHist siStrgChngHist) {
		sqlSession.update("ncis.sql.cmn.siStrgChngHist.updateSiStrgChngHist", siStrgChngHist);
	}

	/**
	 * 구성정보_스토리지변경이력 삭제
	 * @param siStrgChngHist
	 */
	public void deleteSiStrgChngHist(SiStrgChngHist siStrgChngHist) {
		sqlSession.update("ncis.sql.cmn.siStrgChngHist.deleteSiStrgChngHist", siStrgChngHist);
	}

}
