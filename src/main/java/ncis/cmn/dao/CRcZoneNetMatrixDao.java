package ncis.cmn.dao;

import ncis.cmn.entity.RcZoneNetMatrix;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 존망매트릭스(매핑) DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcZoneNetMatrixDao")
public class CRcZoneNetMatrixDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 존망매트릭스(매핑) 등록
	 * @param rcZoneNetMatrix
	 */
	public void insertRcZoneNetMatrix(RcZoneNetMatrix rcZoneNetMatrix) {
		sqlSession.insert("ncis.sql.cmn.rcZoneNetMatrix.insertRcZoneNetMatrix", rcZoneNetMatrix);
	}

	/**
	 * 존망매트릭스(매핑) 수정
	 * @param rcZoneNetMatrix
	 */
	public void updateRcZoneNetMatrix(RcZoneNetMatrix rcZoneNetMatrix) {
		sqlSession.update("ncis.sql.cmn.rcZoneNetMatrix.updateRcZoneNetMatrix", rcZoneNetMatrix);
	}

	/**
	 * 존망매트릭스(매핑) 삭제
	 * @param rcZoneNetMatrix
	 */
	public void deleteRcZoneNetMatrix(String netId) {
		sqlSession.update("ncis.sql.cmn.rcZoneNetMatrix.deleteRcZoneNetMatrix", netId);
	}

}
