package ncis.cmn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ncis.cmn.entity.RxServcArea;

/**
 * 서비스영역 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcAreaDao")
public class CRxServcAreaDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스영역 등록
	 * @param rxServcArea
	 */
	public void insertRxServcArea(RxServcArea rxServcArea) {
		sqlSession.insert("ncis.sql.cmn.rxServcArea.insertRxServcArea", rxServcArea);
	}

	/**
	 * 서비스영역 수정
	 * @param rxServcArea
	 */
	public void updateRxServcArea(RxServcArea rxServcArea) {
		sqlSession.update("ncis.sql.cmn.rxServcArea.updateRxServcArea", rxServcArea);
	}


	/**
	 * 서비스영역 삭제
	 * @param rxServcArea
	 */
	public void deleteRxServcArea(RxServcArea rxServcArea) {
		sqlSession.delete("ncis.sql.cmn.rxServcArea.deleteRxServcArea", rxServcArea);
	}

}
