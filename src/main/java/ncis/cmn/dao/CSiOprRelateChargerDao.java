package ncis.cmn.dao;

import ncis.cmn.entity.SiOprRelateCharger;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 운영연관담당자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiOprRelateChargerDao")
public class CSiOprRelateChargerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 운영연관담당자 등록
	 * @param siOprRelateCharger
	 */
	public void insertSiOprRelateCharger(SiOprRelateCharger siOprRelateCharger) {
		sqlSession.insert("ncis.sql.cmn.siOprRelateCharger.insertSiOprRelateCharger", siOprRelateCharger);
	}

	/**
	 * 운영연관담당자 수정
	 * @param siOprRelateCharger
	 */
	public void updateSiOprRelateCharger(SiOprRelateCharger siOprRelateCharger) {
		sqlSession.update("ncis.sql.cmn.siOprRelateCharger.updateSiOprRelateCharger", siOprRelateCharger);
	}

	/**
	 * 운영연관담당자 삭제
	 * @param siOprRelateCharger
	 */
	public void deleteSiOprRelateCharger(SiOprRelateCharger siOprRelateCharger) {
		sqlSession.update("ncis.sql.cmn.siOprRelateCharger.deleteSiOprRelateCharger", siOprRelateCharger);
	}

}
