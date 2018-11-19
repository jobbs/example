package ncis.cmn.dao;

import ncis.cmn.entity.SiVmChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_가상화구성서버변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiVmChngHistDao")
public class CSiVmChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_가상화구성서버변경이력 등록
	 * @param siVmChngHist
	 */
	public void insertSiVmChngHist(SiVmChngHist siVmChngHist) {
		sqlSession.insert("ncis.sql.cmn.siVmChngHist.insertSiVmChngHist", siVmChngHist);
	}

	/**
	 * 구성정보_가상화구성서버변경이력 수정
	 * @param siVmChngHist
	 */
	public void updateSiVmChngHist(SiVmChngHist siVmChngHist) {
		sqlSession.update("ncis.sql.cmn.siVmChngHist.updateSiVmChngHist", siVmChngHist);
	}

	/**
	 * 구성정보_가상화구성서버변경이력 삭제
	 * @param siVmChngHist
	 */
	public void deleteSiVmChngHist(SiVmChngHist siVmChngHist) {
		sqlSession.update("ncis.sql.cmn.siVmChngHist.deleteSiVmChngHist", siVmChngHist);
	}

}
