package ncis.cmn.dao;

import ncis.cmn.entity.SiSrvrComp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서버구성정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiSrvrCompDao")
public class CSiSrvrCompDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서버구성정보 등록
	 * @param siSrvrComp
	 */
	public void insertSiSrvrComp(SiSrvrComp siSrvrComp) {
		sqlSession.insert("ncis.sql.cmn.siSrvrComp.insertSiSrvrComp", siSrvrComp);
	}

	/**
	 * 서버구성정보 수정
	 * @param siSrvrComp
	 */
	public void updateSiSrvrComp(SiSrvrComp siSrvrComp) {
		sqlSession.update("ncis.sql.cmn.siSrvrComp.updateSiSrvrComp", siSrvrComp);
	}

	/**
	 * 서버구성정보 삭제
	 * @param siSrvrComp
	 */
	public void deleteSiSrvrComp(SiSrvrComp siSrvrComp) {
		sqlSession.update("ncis.sql.cmn.siSrvrComp.deleteSiSrvrComp", siSrvrComp);
	}

}
