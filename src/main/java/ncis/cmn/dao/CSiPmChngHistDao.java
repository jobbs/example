package ncis.cmn.dao;

import ncis.cmn.entity.SiPmChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_서버모듈변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiPmChngHistDao")
public class CSiPmChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_서버모듈변경이력 등록
	 * @param siPmChngHist
	 */
	public void insertSiPmChngHist(SiPmChngHist siPmChngHist) {
		sqlSession.insert("ncis.sql.cmn.siPmChngHist.insertSiPmChngHist", siPmChngHist);
	}

	/**
	 * 구성정보_서버모듈변경이력 수정
	 * @param siPmChngHist
	 */
	public void updateSiPmChngHist(SiPmChngHist siPmChngHist) {
		sqlSession.update("ncis.sql.cmn.siPmChngHist.updateSiPmChngHist", siPmChngHist);
	}

	/**
	 * 구성정보_서버모듈변경이력 삭제
	 * @param siPmChngHist
	 */
	public void deleteSiPmChngHist(SiPmChngHist siPmChngHist) {
		sqlSession.update("ncis.sql.cmn.siPmChngHist.deleteSiPmChngHist", siPmChngHist);
	}

}
