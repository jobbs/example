package ncis.cmn.dao;

import ncis.cmn.entity.SiCompCommon;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보_공통 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiCompCommonDao")
public class CSiCompCommonDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 구성정보_공통 등록
	 * @param siCompCommon
	 */
	public void insertSiCompCommon(SiCompCommon siCompCommon) {
		sqlSession.insert("ncis.sql.cmn.siCompCommon.insertSiCompCommon", siCompCommon);
	}

	/**
	 * 구성정보_공통 수정
	 * @param siCompCommon
	 */
	public void updateSiCompCommon(SiCompCommon siCompCommon) {
		sqlSession.update("ncis.sql.cmn.siCompCommon.updateSiCompCommon", siCompCommon);
	}

	/**
	 * 구성정보_공통 삭제
	 * @param siCompCommon
	 */
	public void deleteSiCompCommon(SiCompCommon siCompCommon) {
		sqlSession.update("ncis.sql.cmn.siCompCommon.deleteSiCompCommon", siCompCommon);
	}

}
