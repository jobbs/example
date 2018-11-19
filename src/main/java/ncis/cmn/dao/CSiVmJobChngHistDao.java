package ncis.cmn.dao;

import ncis.cmn.entity.SiVmJobChngHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버업무변경이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiVmJobChngHistDao")
public class CSiVmJobChngHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버업무변경이력 등록
	 * @param siVmJobChngHist
	 */
	public void insertSiVmJobChngHist(SiVmJobChngHist siVmJobChngHist) {
		sqlSession.insert("ncis.sql.cmn.siVmJobChngHist.insertSiVmJobChngHist", siVmJobChngHist);
	}

	/**
	 * 가상서버업무변경이력 수정
	 * @param siVmJobChngHist
	 */
	public void updateSiVmJobChngHist(SiVmJobChngHist siVmJobChngHist) {
		sqlSession.update("ncis.sql.cmn.siVmJobChngHist.updateSiVmJobChngHist", siVmJobChngHist);
	}

	/**
	 * 가상서버업무변경이력 삭제
	 * @param siVmJobChngHist
	 */
	public void deleteSiVmJobChngHist(SiVmJobChngHist siVmJobChngHist) {
		sqlSession.update("ncis.sql.cmn.siVmJobChngHist.deleteSiVmJobChngHist", siVmJobChngHist);
	}

}
