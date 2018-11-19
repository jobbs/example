package ncis.cmn.dao;

import ncis.cmn.entity.SiNetwkComp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 네트워크구성정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiNetwkCompDao")
public class CSiNetwkCompDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 네트워크구성정보 등록
	 * @param siNetwkComp
	 */
	public void insertSiNetwkComp(SiNetwkComp siNetwkComp) {
		sqlSession.insert("ncis.sql.cmn.siNetwkComp.insertSiNetwkComp", siNetwkComp);
	}

	/**
	 * 네트워크구성정보 수정
	 * @param siNetwkComp
	 */
	public void updateSiNetwkComp(SiNetwkComp siNetwkComp) {
		sqlSession.update("ncis.sql.cmn.siNetwkComp.updateSiNetwkComp", siNetwkComp);
	}

	/**
	 * 네트워크구성정보 삭제
	 * @param siNetwkComp
	 */
	public void deleteSiNetwkComp(SiNetwkComp siNetwkComp) {
		sqlSession.update("ncis.sql.cmn.siNetwkComp.deleteSiNetwkComp", siNetwkComp);
	}

}
